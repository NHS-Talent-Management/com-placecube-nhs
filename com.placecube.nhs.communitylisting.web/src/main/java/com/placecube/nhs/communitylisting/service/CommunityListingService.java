package com.placecube.nhs.communitylisting.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.comparator.GroupNameComparator;
import com.placecube.nhs.grouptypes.constants.GroupType;
import com.placecube.nhs.grouptypes.constants.GroupTypeExpando;
import com.placecube.nhs.grouptypes.service.GroupTypeRetrievalService;
import com.placecube.nhs.search.utils.SearchService;
import com.placecube.nhs.taglibs.model.AZEntry;

@Component(immediate = true, service = CommunityListingService.class)
public class CommunityListingService {

	private static final Log LOG = LogFactoryUtil.getLog(CommunityListingService.class);

	@Reference
	private AssetEntryLocalService assetEntryLocalService;

	@Reference
	private GroupTypeRetrievalService groupTypeRetrievalService;

	@Reference
	private SearchService searchService;

	@Reference
	private RetrievalService retrievalService;

	public List<AZEntry> getAllGroups(ThemeDisplay themeDisplay, String[] groupTypes, boolean matchOnCategories) throws PortalException {

		SearchContext searchContext = searchService.getSearchContext(themeDisplay.getCompanyId());

		List<BooleanClause<Query>> queries = new ArrayList<>();
		queries.add(searchService.getStringQuery(searchService.getExpandoSearchFieldName(GroupTypeExpando.FIELD_NAME), groupTypes, BooleanClauseOccur.MUST));
		queries.add(searchService.getStringQuery(Field.GROUP_ID, themeDisplay.getScopeGroupId(), BooleanClauseOccur.MUST_NOT));

		if (matchOnCategories) {
			AssetEntry assetEntry = assetEntryLocalService.getEntry(Group.class.getName(), themeDisplay.getScopeGroupId());
			queries.add(searchService.getStringQuery(Field.ASSET_CATEGORY_IDS, assetEntry.getCategoryIds(), BooleanClauseOccur.MUST));
		}

		searchService.configureBooleanClauses(searchContext, queries);

		Document[] searchResults = searchService.getSearchResults(searchContext, Group.class.getName());

		return retrievalService.getEntriesFromSearchResults(themeDisplay, searchResults);
	}

	public List<Group> getCommunitiesForUser(ThemeDisplay themeDisplay, String[] groupTypes) {
		User user = themeDisplay.getUser();
		List<Group> groups = user.getGroups();
		List<Group> communities = groups.stream().filter(group -> ArrayUtil.contains(groupTypes, groupTypeRetrievalService.getGroupType(group))).collect(Collectors.toList());
		communities.sort(new GroupNameComparator(true));
		return communities;
	}

	/*
	 * For each CoI in the system
	 *
	 * - get CoPs with matching categories for the CoI
	 *
	 * - get total activities for the CoI + its related CoPs
	 *
	 * - return top x CoIs
	 */
	public List<Group> getMostPopularCommunitiesOfInterest(ThemeDisplay themeDisplay, Integer maxItemsToDisplay) throws PortalException {
		Map<Long, Long> groupActivityCount = new HashMap<>();

		long companyId = themeDisplay.getCompanyId();

		List<Long> communityOfInterestGroupIds = groupTypeRetrievalService.getGroupIds(companyId, GroupType.COMMUNITY_OF_INTEREST);

		for (Long communityOfInterestGroupId : communityOfInterestGroupIds) {
			try {
				List<Long> relatedGroupIds = groupTypeRetrievalService.getRelatedGroupIds(companyId, communityOfInterestGroupId, GroupType.COMMUNITY_OF_PRACTICE);
				relatedGroupIds.add(communityOfInterestGroupId);

				groupActivityCount.put(communityOfInterestGroupId, retrievalService.getActivitiesCount(relatedGroupIds));
			} catch (Exception e) {
				LOG.debug(e);
			}
		}

		return retrievalService.getGroups(retrievalService.getMostPopular(maxItemsToDisplay, groupActivityCount));
	}

	/*
	 * - get CoPs with matching categories for the scope group
	 *
	 * - get total activities for each CoP
	 *
	 * - return top x CoPs
	 */
	public List<Group> getMostPopularCommunitiesOfPractice(ThemeDisplay themeDisplay, Integer maxItemsToDisplay) throws PortalException {
		Map<Long, Long> groupActivityCount = new HashMap<>();
		try {
			List<Long> relatedGroupIds = groupTypeRetrievalService.getRelatedGroupIds(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), GroupType.COMMUNITY_OF_PRACTICE);

			for (Long groupId : relatedGroupIds) {
				groupActivityCount.put(groupId, retrievalService.getActivitiesCount(groupId));
			}
		} catch (Exception e) {
			LOG.debug(e);
		}
		return retrievalService.getGroups(retrievalService.getMostPopular(maxItemsToDisplay, groupActivityCount));
	}

}
