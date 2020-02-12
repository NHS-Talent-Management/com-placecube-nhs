package com.placecube.nhs.communitylisting.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.social.kernel.service.SocialActivityLocalService;
import com.placecube.nhs.communitylisting.model.Community;

@Component(immediate = true, service = CommunityRetrievalService.class)
public class CommunityRetrievalService {

	@Reference
	private SocialActivityLocalService socialActivityLocalService;

	@Reference
	private GroupLocalService groupLocalService;

	public List<Group> getAllParentGroups(ThemeDisplay themeDisplay) {
		List<Group> groups = groupLocalService.getGroups(themeDisplay.getCompanyId(), GroupConstants.DEFAULT_PARENT_GROUP_ID, true);
		return groups.stream().filter(group -> isValidGroup(group)).collect(Collectors.toList());
	}

	public long getActivitiesCountForGroupAndChildren(Group group) {
		List<Group> children = group.getChildren(true);
		List<Long> groupIds = children.stream().map(Group::getGroupId).collect(Collectors.toList());
		groupIds.add(group.getGroupId());

		DynamicQuery dynamicQuery = socialActivityLocalService.dynamicQuery();
		dynamicQuery.add(RestrictionsFactoryUtil.in("groupId", groupIds));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("mirrorActivityId", 0l));
		return socialActivityLocalService.dynamicQueryCount(dynamicQuery);
	}

	private boolean isValidGroup(Group group) {
		return !group.isCompany() && !group.isGuest() && group.isActive();
	}

	public Map<String, List<Community>> initializeMapAtoZ() {
		Map<String, List<Community>> results = new TreeMap<>();
		List<Character> collect = IntStream.rangeClosed('A', 'Z').mapToObj(var -> (char) var).collect(Collectors.toList());
		for (Character character : collect) {
			results.put(String.valueOf(character), new LinkedList<>());
		}
		return results;
	}

}
