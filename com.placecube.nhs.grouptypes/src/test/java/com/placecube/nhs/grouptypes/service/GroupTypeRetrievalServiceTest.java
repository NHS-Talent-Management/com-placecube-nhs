package com.placecube.nhs.grouptypes.service;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.expando.kernel.model.ExpandoTableConstants;
import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.service.ExpandoValueLocalService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.placecube.nhs.grouptypes.constants.GroupType;
import com.placecube.nhs.grouptypes.constants.GroupTypeExpando;
import com.placecube.nhs.search.utils.SearchService;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(JUnitParamsRunner.class)
public class GroupTypeRetrievalServiceTest extends PowerMockito {

	private static final long COMPANY_ID = 20;
	private static final Long GROUP_ID_ONE = 30l;
	private static final Long GROUP_ID_TWO = 40l;

	@InjectMocks
	private GroupTypeRetrievalService groupTypeRetrievalService;

	@Mock
	private AssetEntryLocalService mockAssetEntryLocalService;

	@Mock
	private ExpandoValueLocalService mockExpandoValueLocalService;

	@Mock
	private SearchService mockSearchService;

	@Mock
	private ExpandoValue mockExpandoValue1;

	@Mock
	private ExpandoValue mockExpandoValue2;

	@Mock
	private SearchContext mockSearchContext;

	@Mock
	private AssetEntry mockAssetEntry;

	@Mock
	private BooleanClause mockBooleanClauseCategoryIds;

	@Mock
	private BooleanClause mockBooleanClauseGroupId;

	@Mock
	private BooleanClause mockBooleanClauseGroupType;

	@Mock
	private Document mockDocument1;

	@Mock
	private Document mockDocument2;

	@Test
	@Parameters({ "COMMUNITY_OF_INTEREST", "COMMUNITY_OF_PRACTICE" })
	public void getGroupIds_WhenNoError_ThenReturnsAllExpandoValuesClassPKs(String groupTypeKey) {
		GroupType groupType = GroupType.valueOf(groupTypeKey);
		List<ExpandoValue> expandoValues = new ArrayList<>();
		expandoValues.add(mockExpandoValue1);
		expandoValues.add(mockExpandoValue2);
		expandoValues.add(null);
		when(mockExpandoValue1.getClassPK()).thenReturn(GROUP_ID_ONE);
		when(mockExpandoValue2.getClassPK()).thenReturn(GROUP_ID_TWO);
		when(mockExpandoValueLocalService.getColumnValues(COMPANY_ID, Group.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME, GroupTypeExpando.FIELD_NAME, groupType.getValue(),
				QueryUtil.ALL_POS, QueryUtil.ALL_POS)).thenReturn(expandoValues);

		List<Long> results = groupTypeRetrievalService.getGroupIds(COMPANY_ID, groupType);

		assertThat(results, containsInAnyOrder(GROUP_ID_ONE, GROUP_ID_TWO));
	}

	@Test(expected = PortalException.class)
	@Parameters({ "COMMUNITY_OF_INTEREST", "COMMUNITY_OF_PRACTICE" })
	public void getRelatedGroupIds_WhenExceptionRetrievingAssetEntryForGroup_ThenThrowsPortalException(String groupTypeKey) throws PortalException {
		GroupType groupType = GroupType.valueOf(groupTypeKey);
		when(mockAssetEntryLocalService.getEntry(Group.class.getName(), GROUP_ID_ONE)).thenThrow(new PortalException());

		groupTypeRetrievalService.getRelatedGroupIds(COMPANY_ID, GROUP_ID_ONE, groupType);
	}

	@Test(expected = PortalException.class)
	@Parameters({ "COMMUNITY_OF_INTEREST", "COMMUNITY_OF_PRACTICE" })
	public void getRelatedGroupIds_WhenExceptionPerformingSearch_ThenThrowsPortalException(String groupTypeKey) throws PortalException {
		GroupType groupType = GroupType.valueOf(groupTypeKey);
		when(mockSearchService.getSearchContext(COMPANY_ID)).thenReturn(mockSearchContext);
		when(mockAssetEntryLocalService.getEntry(Group.class.getName(), GROUP_ID_ONE)).thenReturn(mockAssetEntry);
		when(mockSearchService.getSearchResults(mockSearchContext, Group.class.getName())).thenThrow(new SearchException());

		groupTypeRetrievalService.getRelatedGroupIds(COMPANY_ID, GROUP_ID_ONE, groupType);
	}

	@Test
	@Parameters({ "COMMUNITY_OF_INTEREST", "COMMUNITY_OF_PRACTICE" })
	public void getRelatedGroupIds_WhenNoError_ThenReturnsTheGroupIdsWithMatchingCategoriesAndOfTheSpecifiedGroupType(String groupTypeKey) throws PortalException {
		GroupType groupType = GroupType.valueOf(groupTypeKey);
		long[] categoryIds = new long[] { 123456l, 789456l, 456l };
		String searchFieldName = "searchFieldNameValue";
		Document[] documents = new Document[] { mockDocument1, mockDocument2 };
		when(mockSearchService.getSearchContext(COMPANY_ID)).thenReturn(mockSearchContext);
		when(mockAssetEntryLocalService.getEntry(Group.class.getName(), GROUP_ID_ONE)).thenReturn(mockAssetEntry);
		when(mockAssetEntry.getCategoryIds()).thenReturn(categoryIds);
		when(mockSearchService.getStringQuery(Field.ASSET_CATEGORY_IDS, categoryIds, BooleanClauseOccur.MUST)).thenReturn(mockBooleanClauseCategoryIds);
		when(mockSearchService.getExpandoSearchFieldName(GroupTypeExpando.FIELD_NAME)).thenReturn(searchFieldName);
		when(mockSearchService.getStringQuery(searchFieldName, groupType.getValue(), BooleanClauseOccur.MUST)).thenReturn(mockBooleanClauseGroupType);
		when(mockSearchService.getStringQuery(Field.GROUP_ID, GROUP_ID_ONE, BooleanClauseOccur.MUST_NOT)).thenReturn(mockBooleanClauseGroupId);
		when(mockDocument1.get(Field.GROUP_ID)).thenReturn("66");
		when(mockDocument2.get(Field.GROUP_ID)).thenReturn("77");
		when(mockSearchService.getSearchResults(mockSearchContext, Group.class.getName())).thenReturn(documents);

		List<Long> results = groupTypeRetrievalService.getRelatedGroupIds(COMPANY_ID, GROUP_ID_ONE, groupType);

		assertThat(results, containsInAnyOrder(66l, 77l));
	}

	@Test
	@Parameters({ "COMMUNITY_OF_INTEREST", "COMMUNITY_OF_PRACTICE" })
	public void getRelatedGroupIds_WhenNoError_ThenConfiguresTheSearchClausesBeforeRunningTheSearch(String groupTypeKey) throws PortalException {
		GroupType groupType = GroupType.valueOf(groupTypeKey);
		long[] categoryIds = new long[] { 123456l, 789456l, 456l };
		String searchFieldName = "searchFieldNameValue";
		Document[] documents = new Document[] {};
		when(mockSearchService.getSearchContext(COMPANY_ID)).thenReturn(mockSearchContext);
		when(mockAssetEntryLocalService.getEntry(Group.class.getName(), GROUP_ID_ONE)).thenReturn(mockAssetEntry);
		when(mockAssetEntry.getCategoryIds()).thenReturn(categoryIds);
		when(mockSearchService.getStringQuery(Field.ASSET_CATEGORY_IDS, categoryIds, BooleanClauseOccur.MUST)).thenReturn(mockBooleanClauseCategoryIds);
		when(mockSearchService.getExpandoSearchFieldName(GroupTypeExpando.FIELD_NAME)).thenReturn(searchFieldName);
		when(mockSearchService.getStringQuery(searchFieldName, groupType.getValue(), BooleanClauseOccur.MUST)).thenReturn(mockBooleanClauseGroupType);
		when(mockSearchService.getStringQuery(Field.GROUP_ID, GROUP_ID_ONE, BooleanClauseOccur.MUST_NOT)).thenReturn(mockBooleanClauseGroupId);
		when(mockSearchService.getSearchResults(mockSearchContext, Group.class.getName())).thenReturn(documents);

		groupTypeRetrievalService.getRelatedGroupIds(COMPANY_ID, GROUP_ID_ONE, groupType);

		InOrder inOrder = Mockito.inOrder(mockSearchService);
		inOrder.verify(mockSearchService, times(1)).configureBooleanClauses(mockSearchContext, mockBooleanClauseCategoryIds, mockBooleanClauseGroupType, mockBooleanClauseGroupId);
		inOrder.verify(mockSearchService, times(1)).getSearchResults(mockSearchContext, Group.class.getName());
	}
}
