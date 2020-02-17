package com.placecube.nhs.communitylisting.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.social.kernel.service.SocialActivityLocalService;
import com.placecube.nhs.taglib.az.model.AZEntry;

@Component(immediate = true, service = RetrievalService.class)
public class RetrievalService {

	private static final Log LOG = LogFactoryUtil.getLog(RetrievalService.class);

	@Reference
	private GroupLocalService groupLocalService;

	@Reference
	private SocialActivityLocalService socialActivityLocalService;

	public List<AZEntry> getEntriesFromSearchResults(ThemeDisplay themeDisplay, Document[] searchResults) {
		List<AZEntry> results = new LinkedList<>();
		Locale locale = themeDisplay.getLocale();
		for (Document document : searchResults) {
			try {
				long groupId = GetterUtil.getLong(document.get(Field.GROUP_ID));
				Group group = groupLocalService.getGroup(groupId);
				results.add(AZEntry.init(group.getName(locale), group.getDisplayURL(themeDisplay)));
			} catch (Exception e) {
				LOG.debug(e);
			}
		}
		return results;
	}

	public List<Long> getMostPopular(Integer maxItemsToDisplay, Map<Long, Long> groupActivityCount) {
		Set<Long> keySet = groupActivityCount.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new)).keySet();

		if (keySet.size() > maxItemsToDisplay) {
			return new ArrayList<>(keySet).subList(0, maxItemsToDisplay);
		} else {
			return new ArrayList<>(keySet);
		}
	}

	public List<Group> getGroups(List<Long> groupIds) {
		List<Group> results = new LinkedList<>();
		for (Long groupId : groupIds) {
			try {
				results.add(groupLocalService.getGroup(groupId));
			} catch (Exception e) {
				LOG.debug(e);
			}
		}
		return results;
	}

	public long getActivitiesCount(Long groupId) {
		DynamicQuery dynamicQuery = socialActivityLocalService.dynamicQuery();
		dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", groupId));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("mirrorActivityId", 0l));
		return socialActivityLocalService.dynamicQueryCount(dynamicQuery);
	}

	public long getActivitiesCount(List<Long> groupIds) {
		DynamicQuery dynamicQuery = socialActivityLocalService.dynamicQuery();
		dynamicQuery.add(RestrictionsFactoryUtil.in("groupId", groupIds));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("mirrorActivityId", 0l));
		return socialActivityLocalService.dynamicQueryCount(dynamicQuery);
	}
}
