package com.placecube.nhs.search.utils;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistry;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(JUnitParamsRunner.class)
public class SearchServiceTest extends PowerMockito {

	private static final BooleanClauseOccur BOOLEAN_CLAUSE = BooleanClauseOccur.MUST;
	private static final String FIELD_VALUE_STRING = "myFieldValue";
	private static final String FIELD_NAME = "myFieldName";
	private static final long FIELD_VALUE_LONG = 123;

	@InjectMocks
	private SearchService searchService;

	@Mock
	private IndexerRegistry mockIndexerRegistry;

	@Mock
	private SearchContext mockSearchContext;

	@Mock
	private Indexer mockIndexer;

	@Mock
	private BooleanClause mockBooleanClause1;

	@Mock
	private BooleanClause mockBooleanClause2;

	@Mock
	private Hits mockHits;

	@Mock
	private Document mockDocument1;

	@Mock
	private Document mockDocument2;

	@Test
	public void getExpandoSearchFieldName_WhenNoError_ThenReturnsTheFieldNamePrefixedWithTheExpandoName() {
		String result = searchService.getExpandoSearchFieldName(FIELD_NAME);

		assertThat(result, equalTo("expando__keyword__custom_fields__" + FIELD_NAME));
	}

	@Test
	public void getSearchContext_WhenNoError_ThenReturnsSearchContextWithCompanyIdConfigured() {
		long companyId = 123;

		SearchContext result = searchService.getSearchContext(companyId);

		assertThat(result.getCompanyId(), equalTo(companyId));
	}

	@Test
	public void configureBooleanClauses_WithBooleanClauseListParameter_WhenNoError_ThenConfiguresTheSearchContextWithAllTheClauses() {
		List<BooleanClause<Query>> queries = new ArrayList<>();
		queries.add(mockBooleanClause1);
		queries.add(mockBooleanClause2);

		searchService.configureBooleanClauses(mockSearchContext, queries);

		verify(mockSearchContext, times(1)).setBooleanClauses(queries.toArray(new BooleanClause[queries.size()]));
	}

	@Test
	public void configureBooleanClauses_WithBooleanClausesParameter_WhenNoError_ThenConfiguresTheSearchContextWithAllTheClauses() {
		searchService.configureBooleanClauses(mockSearchContext, mockBooleanClause1, mockBooleanClause2);

		verify(mockSearchContext, times(1)).setBooleanClauses(new BooleanClause[] { mockBooleanClause1, mockBooleanClause2 });
	}

	@Test
	public void getStringQuery_WithFieldNameFieldValueAndBooleaClause_ThenReturnsTheBooleanClauseWithTheSearchQuery() {
		BooleanClause<Query> result = searchService.getStringQuery(FIELD_NAME, FIELD_VALUE_STRING, BOOLEAN_CLAUSE);

		assertThat(result.getBooleanClauseOccur(), equalTo(BOOLEAN_CLAUSE));
		assertThat(result.getClause().toString(), equalTo("{className=StringQuery, query=+(myFieldName:myFieldValue)}"));
	}

	@Test
	public void getStringQuery_WithFieldNameFieldValueLongAndBooleaClause_ThenReturnsTheBooleanClauseWithTheSearchQuery() {
		BooleanClause<Query> result = searchService.getStringQuery(FIELD_NAME, FIELD_VALUE_LONG, BOOLEAN_CLAUSE);

		assertThat(result.getBooleanClauseOccur(), equalTo(BOOLEAN_CLAUSE));
		assertThat(result.getClause().toString(), equalTo("{className=StringQuery, query=+(myFieldName:123)}"));
	}

	@Test(expected = SearchException.class)
	public void getStringQuery_WithFieldNameFieldValuesAndBooleaClause_WhenFieldValuesAreEmpty_ThenThrowsSearchException() throws SearchException {
		searchService.getStringQuery(FIELD_NAME, new String[0], BOOLEAN_CLAUSE);
	}

	@Test
	public void getStringQuery_WithFieldNameFieldValuesAndBooleaClause_WhenFieldValuesAreValid_ThenReturnsTheBooleanClauseWithTheSearchQuery() throws SearchException {
		BooleanClause<Query> result = searchService.getStringQuery(FIELD_NAME, new String[] { FIELD_VALUE_STRING, "OtherValue" }, BOOLEAN_CLAUSE);

		assertThat(result.getClause().toString(), equalTo("{className=StringQuery, query=+((myFieldName:myFieldValue) OR (myFieldName:OtherValue))}"));
	}

	@Test(expected = SearchException.class)
	public void getStringQuery_WithFieldNameFieldValuesLongAndBooleaClause_WhenFieldValuesAreEmpty_ThenThrowsSearchException() throws SearchException {
		searchService.getStringQuery(FIELD_NAME, new long[0], BOOLEAN_CLAUSE);
	}

	@Test
	public void getStringQuery_WithFieldNameFieldValuesLongAndBooleaClause_WhenFieldValuesAreValid_ThenReturnsTheBooleanClauseWithTheSearchQuery() throws SearchException {
		BooleanClause<Query> result = searchService.getStringQuery(FIELD_NAME, new long[] { FIELD_VALUE_LONG, 77 }, BOOLEAN_CLAUSE);

		assertThat(result.getClause().toString(), equalTo("{className=StringQuery, query=+((myFieldName:123) OR (myFieldName:77))}"));
	}

	@Test(expected = SearchException.class)
	public void getStringQuery_WithStirngQueryAndBooleaClause_WhenStirngQueryIsEmpty_ThenThrowsSearchException() throws SearchException {
		searchService.getStringQuery(StringPool.BLANK, BOOLEAN_CLAUSE);
	}

	@Test
	public void getStringQuery_WithStirngQueryAndBooleaClause_WhenStirngQueryIsValid_ThenReturnsTheBooleanClauseWithTheSearchQuery() throws SearchException {
		String myQuery = "myQueryValue";
		BooleanClause<Query> result = searchService.getStringQuery(myQuery, BOOLEAN_CLAUSE);

		assertThat(result.getClause().toString(), equalTo("{className=StringQuery, query=+(myQueryValue)}"));
	}

	@Test(expected = SearchException.class)
	public void getSearchResults_WhenExceptionPerformingSearch_ThenThrowsSearchException() throws SearchException {
		String className = "myClassName";
		when(mockIndexerRegistry.getIndexer(className)).thenReturn(mockIndexer);
		when(mockIndexer.search(mockSearchContext)).thenThrow(new SearchException());

		searchService.getSearchResults(mockSearchContext, className);
	}

	@Test
	public void getSearchResults_WhenNoError_ThenReturnsTheSearchResults() throws SearchException {
		String className = "myClassName";
		when(mockIndexerRegistry.getIndexer(className)).thenReturn(mockIndexer);
		when(mockIndexer.search(mockSearchContext)).thenReturn(mockHits);
		Document[] documents = new Document[] { mockDocument1, mockDocument2 };
		when(mockHits.getDocs()).thenReturn(documents);

		Document[] results = searchService.getSearchResults(mockSearchContext, className);

		assertThat(results, equalTo(documents));
	}

	@Test
	@Parameters({ "true", "false" })
	public void getSortOnDate_WhenNoError_ThenReturnsTheSort(boolean reverse) {
		Sort sort = searchService.getSortOnDate(FIELD_NAME, reverse);

		assertThat(sort.getFieldName(), equalTo(Field.getSortableFieldName(FIELD_NAME)));
		assertThat(sort.getType(), equalTo(Sort.LONG_TYPE));
		assertThat(sort.isReverse(), equalTo(reverse));
	}

	@Test
	public void getValuesJoinedInOr_WithLongValues_WhenThereAreNoValues_ThenReturnsEmptyString() throws SearchException {
		String result = searchService.getValuesJoinedInOr(FIELD_NAME, new long[0]);

		assertThat(result, equalTo(StringPool.BLANK));
	}

	@Test
	public void getValuesJoinedInOr_WithLongValues_WhenThereAreValues_ThenReturnsValuesInOr() throws SearchException {
		String result = searchService.getValuesJoinedInOr(FIELD_NAME, new long[] { FIELD_VALUE_LONG, 77 });

		assertThat(result, equalTo("(myFieldName:123) OR (myFieldName:77)"));
	}

	@Test
	public void getValuesJoinedInOr_WithStringValues_WhenThereAreNoValues_ThenReturnsEmptyString() throws SearchException {
		String result = searchService.getValuesJoinedInOr(FIELD_NAME, new String[0]);

		assertThat(result, equalTo(StringPool.BLANK));
	}

	@Test
	public void getValuesJoinedInOr_WithStringValues_WhenThereAreValues_ThenReturnsValuesInOr() throws SearchException {
		String result = searchService.getValuesJoinedInOr(FIELD_NAME, new String[] { "valueOne", "valueTwo" });

		assertThat(result, equalTo("(myFieldName:valueOne) OR (myFieldName:valueTwo)"));
	}
}
