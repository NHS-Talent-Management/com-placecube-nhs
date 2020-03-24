package com.placecube.nhs.talentdashboard.web.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.petra.string.StringPool;
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
import com.liferay.portal.kernel.search.QueryConfig;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.placecube.nhs.readiness.model.ReadinessQuestion;
import com.placecube.nhs.readiness.service.ReadinessService;
import com.placecube.nhs.search.utils.SearchService;
import com.placecube.nhs.taglibs.model.SearchFilter;
import com.placecube.nhs.talentsearch.constants.Category;
import com.placecube.nhs.talentsearch.constants.Type;

@Component(immediate = true, service = RetrievalUtil.class)
public class RetrievalUtil {

	private static final Log LOG = LogFactoryUtil.getLog(RetrievalUtil.class);

	@Reference
	private ReadinessService readinessService;

	@Reference
	private SearchService searchService;

	@Reference
	private UserLocalService userLocalService;

	public void configureSearchQueries(List<SearchFilter> searchFilters, SearchContext searchContext) throws SearchException {
		List<BooleanClause<Query>> queries = new ArrayList<>();
		for (SearchFilter searchFilter : searchFilters) {
			if (searchFilter.isActive()) {
				queries.add(searchService.getStringQuery(searchFilter.getSearchableFieldName(), searchFilter.getFieldSelectedValues(), BooleanClauseOccur.MUST));
			}
		}
		searchService.configureBooleanClauses(searchContext, queries);
	}

	public Hits executeSearch(SearchContext searchContext) throws SearchException {
		return searchService.executeSearch(searchContext, User.class.getName());
	}

	public Map<String, String> getCategories(Locale locale) {
		Map<String, String> results = new LinkedHashMap<>();
		for (Category category : Category.values()) {
			results.put(String.valueOf(category.getId()), category.getLabel(locale));
		}
		return results;
	}

	public String getQueryParametersForSearchFilters(List<SearchFilter> availableFilters) {
		StringBuilder sb = new StringBuilder();
		for (SearchFilter searchFilter : availableFilters) {
			if (searchFilter.isActive()) {
				sb.append(searchFilter.getSearchableFieldName());
				sb.append(StringPool.EQUAL);
				sb.append(searchFilter.getFieldSelectedValuesList().stream().collect(Collectors.joining(StringPool.SEMICOLON)));
				sb.append(StringPool.RETURN_NEW_LINE);
			}
		}
		return sb.toString();
	}

	public SearchContext getSearchContext(ThemeDisplay themeDisplay, int start, int end) {
		SearchContext searchContext = searchService.getSearchContext(themeDisplay.getCompanyId());
		searchContext.setEntryClassNames(new String[] { User.class.getName() });
		searchContext.setStart(start);
		searchContext.setEnd(end);
		QueryConfig queryConfig = searchContext.getQueryConfig();
		queryConfig.setSelectedFieldNames(Field.USER_ID);
		return searchContext;
	}

	public Map<String, String> getTypes(Locale locale) {
		Map<String, String> results = new LinkedHashMap<>();
		for (Type type : Type.values()) {
			results.put(String.valueOf(type.getId()), type.getLabel(locale));
		}
		return results;
	}

	public void getUserFromSearchResult(List<User> users, Document document) {
		try {
			users.add(userLocalService.getUser(GetterUtil.getLong(document.get(Field.USER_ID))));
		} catch (Exception e) {
			LOG.debug(e);
			LOG.error("Unable to get user from search result " + e.getMessage());
		}
	}

	public void populateSearchFiltersWithReadinessQuestions(Company company, List<SearchFilter> searchFilters) {
		try {
			List<ReadinessQuestion> questionnaire = readinessService.getQuestionnaire(company);
			searchFilters.addAll(questionnaire.stream().map(readinessQuestion -> getSearchFilter(readinessQuestion)).collect(Collectors.toList()));
		} catch (Exception e) {
			LOG.debug(e);
		}
	}

	private SearchFilter getSearchFilter(ReadinessQuestion readinessQuestion) {
		Map<String, String> fieldValues = new LinkedHashMap<>();
		for (String answer : readinessQuestion.getAvailableAnswers()) {
			fieldValues.put(answer, answer);
		}
		return new SearchFilter(readinessQuestion.getQuestionName(), readinessQuestion.getQuestionSearchableName(), readinessQuestion.getQuestionShortTitle(), fieldValues);
	}
}
