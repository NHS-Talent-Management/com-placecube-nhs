package com.placecube.nhs.communitylisting.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.placecube.nhs.communitylisting.model.Community;
import com.placecube.nhs.communitylisting.portlet.mostpopular.configuration.MostPopularCommunityPortletInstanceConfiguration;

@Component(immediate = true, service = CommunityListingService.class)
public class CommunityListingService {

	@Reference
	private CommunityRetrievalService communityRetrievalService;

	@Reference
	private GroupLocalService groupLocalService;

	public MostPopularCommunityPortletInstanceConfiguration getMostPopularConfiguration(ThemeDisplay themeDisplay) throws ConfigurationException {
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		return portletDisplay.getPortletInstanceConfiguration(MostPopularCommunityPortletInstanceConfiguration.class);
	}

	public List<Community> getAllCommunities(ThemeDisplay themeDisplay) {
		List<Community> results = new ArrayList<>();

		Locale locale = themeDisplay.getLocale();

		List<Group> groups = communityRetrievalService.getAllParentGroups(themeDisplay);

		for (Group group : groups) {
			results.add(Community.init(group, locale));
		}

		results.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));

		return results;
	}

	public Map<String, List<Community>> getCommunitiesGroupedByInitial(List<Community> communities) {
		Map<String, List<Community>> results = communityRetrievalService.initializeMapAtoZ();

		for (Community community : communities) {
			String initial = community.getInitial();
			List<Community> communitiesForInitial = results.get(initial);
			communitiesForInitial.add(community);
			results.put(initial, communitiesForInitial);
		}
		return results;
	}

	public List<Community> getMostPopularCommunities(ThemeDisplay themeDisplay, Integer maxItemsToDisplay) {
		List<Community> results = new ArrayList<>();

		Locale locale = themeDisplay.getLocale();

		List<Group> groups = communityRetrievalService.getAllParentGroups(themeDisplay);

		for (Group group : groups) {
			long activitiesCount = communityRetrievalService.getActivitiesCountForGroupAndChildren(group);
			results.add(Community.init(group, activitiesCount, locale));
		}

		results.sort((o1, o2) -> o2.getActivitiesCount().compareTo(o1.getActivitiesCount()));

		if (results.size() > maxItemsToDisplay) {
			return results.subList(0, maxItemsToDisplay);
		}

		return results;
	}

}
