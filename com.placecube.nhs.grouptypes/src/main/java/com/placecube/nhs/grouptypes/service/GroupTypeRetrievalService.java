package com.placecube.nhs.grouptypes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

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
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.placecube.nhs.grouptypes.constants.GroupType;
import com.placecube.nhs.grouptypes.constants.GroupTypeExpando;
import com.placecube.nhs.search.utils.SearchService;

@Component(immediate = true, service = GroupTypeRetrievalService.class)
public class GroupTypeRetrievalService {

	@Reference
	private AssetEntryLocalService assetEntryLocalService;

	@Reference
	private ExpandoValueLocalService expandoValueLocalService;

	@Reference
	private SearchService searchService;

	public List<Long> getGroupIds(long companyId, GroupType groupType) {
		List<ExpandoValue> columnValues = expandoValueLocalService.getColumnValues(companyId, Group.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME, GroupTypeExpando.FIELD_NAME,
				groupType.getValue(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<Long> groupIds = columnValues.stream().map(expandoValue -> Validator.isNotNull(expandoValue) ? expandoValue.getClassPK() : 0).collect(Collectors.toList());
		groupIds.remove(0l);
		return groupIds;
	}

	public List<Long> getRelatedGroupIds(long companyId, long groupId, GroupType groupType) throws PortalException {
		List<Long> results = new ArrayList<>();

		AssetEntry assetEntry = assetEntryLocalService.getEntry(Group.class.getName(), groupId);

		SearchContext searchContext = searchService.getSearchContext(companyId);
		BooleanClause<Query> queryOnCategoryIds = searchService.getStringQuery(Field.ASSET_CATEGORY_IDS, assetEntry.getCategoryIds(), BooleanClauseOccur.MUST);
		BooleanClause<Query> queryOnGroupType = searchService.getStringQuery(searchService.getExpandoSearchFieldName(GroupTypeExpando.FIELD_NAME), groupType.getValue(), BooleanClauseOccur.MUST);
		BooleanClause<Query> queryOnGroupId = searchService.getStringQuery(Field.GROUP_ID, groupId, BooleanClauseOccur.MUST_NOT);

		searchService.configureBooleanClauses(searchContext, queryOnCategoryIds, queryOnGroupType, queryOnGroupId);

		Document[] searchResults = searchService.getSearchResults(searchContext, Group.class.getName());
		for (Document document : searchResults) {
			results.add(GetterUtil.getLong(document.get(Field.GROUP_ID)));
		}
		return results;
	}

}
