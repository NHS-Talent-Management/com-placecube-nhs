package com.placecube.nhs.talentdashboard.web.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import javax.portlet.ActionRequest;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.RenderURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.placecube.nhs.readiness.model.ReadinessQuestion;
import com.placecube.nhs.readiness.service.ReadinessService;
import com.placecube.nhs.search.utils.SearchService;
import com.placecube.nhs.talentdashboard.web.model.SearchFilter;
import com.placecube.nhs.talentdashboard.web.model.TalentSearchContext;
import com.placecube.nhs.talentsearch.constants.Category;
import com.placecube.nhs.talentsearch.constants.Type;
import com.placecube.nhs.talentsearch.service.TalentSearchLocalService;

@Component(immediate = true, service = TalentDashboardService.class)
public class TalentDashboardService {

	private static final Log LOG = LogFactoryUtil.getLog(TalentDashboardService.class);

	private static final String SESSION_AVAILABLE_FILTERS = "sessionAvailableFilters";
	private static final String SESSION_TALENT_DASHBOARD_CONTEXT = "sessionTalentDashboardContext";

	@Reference
	private TalentSearchLocalService talentSearchLocalService;

	@Reference
	private ReadinessService readinessService;

	@Reference
	private SearchService searchService;

	@Reference
	private UserLocalService userLocalService;

	public void configureSelectedFilterValues(PortletRequest portletRequest, List<SearchFilter> searchFilters) {
		for (SearchFilter searchFilter : searchFilters) {
			String[] selectedFilterValues = ParamUtil.getStringValues(portletRequest, searchFilter.getSearchableFieldName());
			searchFilter.setFieldSelectedValues(selectedFilterValues);
		}
		portletRequest.getPortletSession().setAttribute(SESSION_AVAILABLE_FILTERS, searchFilters);
	}

	public TalentSearchContext configureTalentSearchDetails(ActionRequest actionRequest, TalentSearchContext talentSearchContext, List<SearchFilter> availableFilters) {
		talentSearchContext.setTalentSearchName(ParamUtil.getString(actionRequest, "talentSearchName"));
		talentSearchContext.setTalentSearchCategoryId(ParamUtil.getLong(actionRequest, "talentSearchCategoryId"));
		talentSearchContext.setTalentSearchTypeId(ParamUtil.getLong(actionRequest, "talentSearchTypeId"));
		boolean hasActiveSearch = "search".equalsIgnoreCase(ParamUtil.getString(actionRequest, Constants.CMD)) || availableFilters.stream().filter(entry -> entry.isActive()).findAny().isPresent();
		talentSearchContext.setSearchExecuted(hasActiveSearch);
		actionRequest.getPortletSession().setAttribute(SESSION_TALENT_DASHBOARD_CONTEXT, talentSearchContext);
		return talentSearchContext;
	}

	public Hits executeSearch(ThemeDisplay themeDisplay, List<SearchFilter> searchFilters, int start, int end) throws PortletException {
		try {
			SearchContext searchContext = searchService.getSearchContext(themeDisplay.getCompanyId());
			searchContext.setEntryClassNames(new String[] { User.class.getName() });
			searchContext.setStart(start);
			searchContext.setEnd(end);

			List<BooleanClause<Query>> queries = new ArrayList<>();
			for (SearchFilter searchFilter : searchFilters) {
				if (searchFilter.isActive()) {
					queries.add(searchService.getStringQuery(searchFilter.getSearchableFieldName(), searchFilter.getFieldSelectedValues(), BooleanClauseOccur.MUST));
				}
			}
			searchService.configureBooleanClauses(searchContext, queries);

			return searchService.executeSearch(searchContext, User.class.getName());
		} catch (Exception e) {
			throw new PortletException(e);
		}
	}

	public Map<String, String> getAvailableCategories(PortletRequest portletRequest, Locale locale) {
		Map<String, String> results = getMapFromSession(portletRequest, "availableCategories");
		if (results.isEmpty()) {
			for (Category category : Category.values()) {
				results.put(String.valueOf(category.getId()), category.getLabel(locale));
			}
		}
		return results;
	}

	public Map<String, String> getAvailableTypes(PortletRequest portletRequest, Locale locale) {
		Map<String, String> results = getMapFromSession(portletRequest, "availableTypes");
		if (results.isEmpty()) {
			for (Type type : Type.values()) {
				results.put(String.valueOf(type.getId()), type.getLabel(locale));
			}
		}
		return results;
	}

	public TalentSearchContext getFromSession(PortletRequest portletRequest, boolean keepFilters) {
		TalentSearchContext talentSearchContext = (TalentSearchContext) portletRequest.getPortletSession().getAttribute(SESSION_TALENT_DASHBOARD_CONTEXT);
		if (!keepFilters || Validator.isNull(talentSearchContext)) {
			talentSearchContext = new TalentSearchContext();
		}
		return talentSearchContext;
	}

	public SearchContainer<User> getSearchContainer(RenderRequest renderRequest, RenderResponse renderResponse) {
		RenderURL createRenderURL = renderResponse.createRenderURL();
		createRenderURL.setParameter("keepFilters", "true");
		return new SearchContainer<>(renderRequest, createRenderURL, null, "no-results-found");
	}

	public List<SearchFilter> getSearchFilters(PortletRequest portletRequest, Company company, Locale locale, boolean keepFilters) {
		List<SearchFilter> results = getListFromSession(portletRequest, SESSION_AVAILABLE_FILTERS, keepFilters);
		if (results.isEmpty()) {
			try {
				List<ReadinessQuestion> questionnaire = readinessService.getQuestionnaire(company);
				results.addAll(questionnaire.stream().map(redinessQuestion -> new SearchFilter(redinessQuestion)).collect(Collectors.toList()));
			} catch (Exception e) {
				LOG.debug(e);
				return Collections.emptyList();
			}

			results.sort((o1, o2) -> o1.getFieldLabel().compareTo(o2.getFieldLabel()));
		}
		return results;
	}

	public List<User> getUsersFromSearchResults(Hits hits) {
		List<User> users = new ArrayList<>();
		Document[] searchResults = hits.getDocs();
		for (Document document : searchResults) {
			users.add(userLocalService.fetchUser(GetterUtil.getLong(document.get(Field.USER_ID))));
		}
		return users;
	}

	public Map<String, String> getValidationErrors(TalentSearchContext talentSearchContext, Locale locale) {
		Map<String, String> errors = new LinkedHashMap<>();
		validateMandatoryField(errors, locale, talentSearchContext.getTalentSearchName(), "talentSearchName", "enter-the-talent-search-name", 200,
				"enter-a-talent-search-name-that-is-200-characters-or-fewer");
		return errors;
	}

	public void saveSearch(User user, TalentSearchContext talentSearchContext, List<SearchFilter> availableFilters) {
		StringBuilder sb = new StringBuilder();
		for (SearchFilter searchFilter : availableFilters) {
			if (searchFilter.isActive()) {
				sb.append(searchFilter.getFieldName());
				sb.append(StringPool.EQUAL);
				sb.append(searchFilter.getFieldSelectedValuesList().stream().collect(Collectors.joining(StringPool.SEMICOLON)));
				sb.append(StringPool.RETURN_NEW_LINE);
			}
		}
		String queryFilter = sb.toString();
		talentSearchLocalService.createTalentSearch(user, talentSearchContext.getTalentSearchName(), talentSearchContext.getTalentSearchTypeId(), talentSearchContext.getTalentSearchCategoryId(),
				queryFilter);
	}

	@SuppressWarnings("unchecked")
	private List<SearchFilter> getListFromSession(PortletRequest portletRequest, String attributeName, boolean keepFilters) {
		List<SearchFilter> results = (List<SearchFilter>) portletRequest.getPortletSession().getAttribute(attributeName);
		if (!keepFilters || Validator.isNull(results)) {
			results = new LinkedList<>();
		}
		return results;
	}

	@SuppressWarnings("unchecked")
	private Map<String, String> getMapFromSession(PortletRequest portletRequest, String attributeName) {
		Map<String, String> results = (Map<String, String>) portletRequest.getPortletSession().getAttribute(attributeName);
		if (Validator.isNull(results)) {
			results = new LinkedHashMap<>();
		}
		return results;
	}

	private String getMessage(Locale locale, String key) {
		return LanguageUtil.get(locale, key);
	}

	private void validateMandatoryField(Map<String, String> errors, Locale locale, String fieldValue, String fieldName, String mandatoryMessageKey, int maxLength, String maxLengthMessageKey) {
		if (Validator.isNull(fieldValue)) {
			errors.put(fieldName, getMessage(locale, mandatoryMessageKey));
		} else if (fieldValue.length() > maxLength) {
			errors.put(fieldName, getMessage(locale, maxLengthMessageKey));
		}
	}
}
