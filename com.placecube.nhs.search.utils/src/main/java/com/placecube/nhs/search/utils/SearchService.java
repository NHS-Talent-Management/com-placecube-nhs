package com.placecube.nhs.search.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.BooleanClauseFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.IndexerRegistry;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.generic.StringQuery;
import com.liferay.portal.kernel.util.Validator;

@Component(immediate = true, service = SearchService.class)
public class SearchService {

	@Reference
	private IndexerRegistry indexerRegistry;

	public String getExpandoSearchFieldName(String fieldName) {
		return "expando__keyword__custom_fields__" + fieldName;
	}

	public SearchContext getSearchContext(long companyId) {
		SearchContext searchContext = new SearchContext();
		searchContext.setCompanyId(companyId);
		return searchContext;
	}

	public void configureBooleanClauses(SearchContext searchContext, List<BooleanClause<Query>> queries) {
		searchContext.setBooleanClauses(queries.toArray(new BooleanClause[queries.size()]));
	}

	public void configureBooleanClauses(SearchContext searchContext, BooleanClause... queries) {
		searchContext.setBooleanClauses(queries);
	}

	public BooleanClause<Query> getStringQuery(String fieldName, String fieldValue, BooleanClauseOccur match) {
		return BooleanClauseFactoryUtil.create(new StringQuery("+(" + fieldName + ":" + fieldValue + ")"), match.toString());
	}

	public BooleanClause<Query> getStringQuery(String fieldName, long fieldValue, BooleanClauseOccur match) {
		return BooleanClauseFactoryUtil.create(new StringQuery("+(" + fieldName + ":" + fieldValue + ")"), match.toString());
	}

	public BooleanClause<Query> getStringQuery(String fieldName, String[] fieldValues, BooleanClauseOccur match) {
		String stringQuery = getOrQuery(fieldName, fieldValues);
		return getStringQuery(stringQuery);
	}

	public BooleanClause<Query> getStringQuery(String fieldName, long[] fieldValues, BooleanClauseOccur match) {
		String stringQuery = getOrQuery(fieldName, fieldValues);
		return getStringQuery(stringQuery);
	}

	public Document[] getSearchResults(SearchContext searchContext, String indexerClassName) throws SearchException {
		Hits hits = indexerRegistry.getIndexer(indexerClassName).search(searchContext);
		return hits.getDocs();
	}

	private String getOrQuery(String fieldName, long[] fieldValues) {
		List<String> fieldValueQueries = new ArrayList<>();
		for (long value : fieldValues) {
			fieldValueQueries.add("(" + fieldName + ":" + value + ")");
		}
		return fieldValueQueries.stream().collect(Collectors.joining(" OR "));
	}

	private String getOrQuery(String fieldName, String[] fieldValues) {
		List<String> fieldValueQueries = new ArrayList<>();
		for (String value : fieldValues) {
			fieldValueQueries.add("(" + fieldName + ":" + value + ")");
		}
		return fieldValueQueries.stream().collect(Collectors.joining(" OR "));
	}

	private BooleanClause<Query> getStringQuery(String stringQuery) {
		if (Validator.isNotNull(stringQuery)) {
			return BooleanClauseFactoryUtil.create(new StringQuery("+(" + stringQuery + ")"), BooleanClauseOccur.MUST.toString());
		}
		return null;
	}

}
