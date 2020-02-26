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
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.IndexerRegistry;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.generic.StringQuery;
import com.liferay.portal.kernel.util.ArrayUtil;
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

	public BooleanClause<Query> getStringQuery(String fieldName, String[] fieldValues, BooleanClauseOccur match) throws SearchException {
		String stringQuery = getValuesJoinedInOr(fieldName, fieldValues);
		return getStringQuery(stringQuery, match);
	}

	public BooleanClause<Query> getStringQuery(String fieldName, long[] fieldValues, BooleanClauseOccur match) throws SearchException {
		String stringQuery = getValuesJoinedInOr(fieldName, fieldValues);
		return getStringQuery(stringQuery, match);
	}

	public BooleanClause<Query> getStringQuery(String stringQuery, BooleanClauseOccur match) throws SearchException {
		if (Validator.isNotNull(stringQuery)) {
			return BooleanClauseFactoryUtil.create(new StringQuery("+(" + stringQuery + ")"), match.toString());
		}
		throw new SearchException("Empty string query");
	}

	public Document[] getSearchResults(SearchContext searchContext, String indexerClassName) throws SearchException {
		Hits hits = indexerRegistry.getIndexer(indexerClassName).search(searchContext);
		return hits.getDocs();
	}

	public Sort getSortOnDate(String fieldName, boolean reverse) {
		return new Sort(Field.getSortableFieldName(fieldName), Sort.LONG_TYPE, reverse);
	}

	public String getValuesJoinedInOr(String fieldName, long[] fieldValues) {
		List<String> fieldValueQueries = new ArrayList<>();
		if (ArrayUtil.isNotEmpty(fieldValues)) {
			for (long value : fieldValues) {
				fieldValueQueries.add("(" + fieldName + ":" + value + ")");
			}
		}
		return fieldValueQueries.stream().collect(Collectors.joining(" OR "));
	}

	public String getValuesJoinedInOr(String fieldName, String[] fieldValues) {
		List<String> fieldValueQueries = new ArrayList<>();

		if (ArrayUtil.isNotEmpty(fieldValues)) {
			for (String value : fieldValues) {
				fieldValueQueries.add("(" + fieldName + ":" + value + ")");
			}
		}
		return fieldValueQueries.stream().collect(Collectors.joining(" OR "));
	}

}
