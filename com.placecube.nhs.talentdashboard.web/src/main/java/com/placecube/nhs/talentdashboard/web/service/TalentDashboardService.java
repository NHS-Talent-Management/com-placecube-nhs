package com.placecube.nhs.talentdashboard.web.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.RenderURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.placecube.nhs.taglibs.constants.SearchFilterConstants;
import com.placecube.nhs.talentdashboard.web.model.SearchFilter;
import com.placecube.nhs.talentdashboard.web.model.TalentSearchContext;
import com.placecube.nhs.talentsearch.service.TalentSearchLocalService;

@Component(immediate = true, service = TalentDashboardService.class)
public class TalentDashboardService {

	private static final Log LOG = LogFactoryUtil.getLog(TalentDashboardService.class);

	@Reference
	private SessionUtil sessionUtil;

	@Reference
	private RetrievalUtil retrievalUtil;

	@Reference
	private TalentSearchLocalService talentSearchLocalService;

	public Hits executeSearch(ThemeDisplay themeDisplay, List<SearchFilter> searchFilters, int start, int end) throws PortletException {
		try {
			SearchContext searchContext = retrievalUtil.getSearchContext(themeDisplay, start, end);

			retrievalUtil.configureSearchQueries(searchFilters, searchContext);

			return retrievalUtil.executeSearch(searchContext);
		} catch (Exception e) {
			throw new PortletException(e);
		}
	}

	public SearchContainer<User> getSearchContainer(RenderRequest renderRequest, RenderResponse renderResponse) {
		RenderURL createRenderURL = renderResponse.createRenderURL();
		createRenderURL.setParameter("keepFilters", "true");
		return new SearchContainer<>(renderRequest, createRenderURL, null, "no-results-found");
	}

	public List<SearchFilter> getSearchFilters(PortletRequest portletRequest, Company company, Locale locale, boolean readFromSession) {
		List<SearchFilter> searchFilters = sessionUtil.getSearchFiltersFromSession(portletRequest, readFromSession);
		if (searchFilters.isEmpty()) {
			retrievalUtil.populateSearchFiltersWithReadinessQuestions(company, searchFilters);
		}
		sessionUtil.saveSearchFiltersInSession(portletRequest, searchFilters);
		return searchFilters;
	}

	public TalentSearchContext getTalentSearchContext(PortletRequest portletRequest, boolean readFromSession) {
		return sessionUtil.getTalentSearchContextFromSession(portletRequest, readFromSession);
	}

	public List<User> getUsersFromSearchResults(Hits hits) {
		List<User> users = new LinkedList<>();
		Document[] searchResults = hits.getDocs();
		for (Document document : searchResults) {
			retrievalUtil.getUserFromSearchResult(users, document);
		}
		return users;
	}

	public void saveSearch(User user, TalentSearchContext talentSearchContext, List<SearchFilter> availableFilters) {
		String queryFilter = retrievalUtil.getQueryParametersForSearchFilters(availableFilters);
		talentSearchLocalService.createTalentSearch(user, talentSearchContext.getTalentSearchName(), talentSearchContext.getTalentSearchTypeId(), talentSearchContext.getTalentSearchCategoryId(),
				queryFilter);
	}

	public boolean shouldExecuteSearch(List<SearchFilter> searchFilters) {
		return searchFilters.stream().filter(entry -> entry.isActive()).findAny().isPresent();
	}

	public void updateFiltersWithSelectedValues(PortletRequest portletRequest, List<SearchFilter> searchFilters) {
		for (SearchFilter searchFilter : searchFilters) {
			String[] selectedFilterValues = ParamUtil.getStringValues(portletRequest, searchFilter.getSearchableFieldName());
			searchFilter.setFieldSelectedValues(selectedFilterValues);
		}
		sessionUtil.saveSearchFiltersInSession(portletRequest, searchFilters);
	}

	public void updateFiltersWithSingleSelectedValue(PortletRequest portletRequest, List<SearchFilter> searchFilters) {
		String fieldName = ParamUtil.getString(portletRequest, "fieldName", StringPool.BLANK);

		Optional<SearchFilter> searchFilterToUpdate = searchFilters.stream().filter(entry -> fieldName.equals(entry.getSearchableFieldName())).findFirst();
		if (searchFilterToUpdate.isPresent()) {
			String cmd = ParamUtil.getString(portletRequest, Constants.CMD);
			String fieldValue = ParamUtil.getString(portletRequest, "fieldValue");

			SearchFilter searchFilter = searchFilterToUpdate.get();
			if (SearchFilterConstants.ACTION_ADD_FILTER.equals(cmd)) {
				searchFilter.addSelectedValue(fieldValue);
				LOG.debug("Adding filter for fieldName: " + fieldName + ", value: " + fieldValue);
			} else if (SearchFilterConstants.ACTION_REMOVE_FILTER.equals(cmd)) {
				searchFilter.removeSelectedValue(fieldValue);
				LOG.debug("Removing filter for fieldName: " + fieldName + ", value: " + fieldValue);
			}
			searchFilters.remove(searchFilter);
			searchFilters.add(searchFilter);
			sessionUtil.saveSearchFiltersInSession(portletRequest, searchFilters);
		}
	}

	public void updateTalentSearchWithSelectedValues(PortletRequest portletRequest, TalentSearchContext talentSearchContext) {
		talentSearchContext.setTalentSearchName(ParamUtil.getString(portletRequest, "talentSearchName"));
		talentSearchContext.setTalentSearchCategoryId(ParamUtil.getLong(portletRequest, "talentSearchCategoryId"));
		talentSearchContext.setTalentSearchTypeId(ParamUtil.getLong(portletRequest, "talentSearchTypeId"));
		sessionUtil.saveTalentSearchInSession(portletRequest, talentSearchContext);
	}

}
