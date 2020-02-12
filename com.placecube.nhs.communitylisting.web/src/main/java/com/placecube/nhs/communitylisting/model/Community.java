package com.placecube.nhs.communitylisting.model;

import java.util.Locale;

import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.theme.ThemeDisplay;

public class Community {

	private final Group group;
	private String initial;
	private Long activitiesCount;
	private final String name;

	private Community(Group group, Locale locale) {
		this.group = group;
		name = group.getName(locale);
	}

	public static Community init(Group group, Locale locale) {
		Community community = new Community(group, locale);
		community.initial = community.name.substring(0, 1);
		return community;
	}

	public static Community init(Group group, Long activitiesCount, Locale locale) {
		Community community = new Community(group, locale);
		community.activitiesCount = activitiesCount;
		return community;
	}

	public Long getActivitiesCount() {
		return activitiesCount;
	}

	public String getName() {
		return name;
	}

	public String getViewURL(ThemeDisplay themeDisplay) {
		return group.getDisplayURL(themeDisplay);
	}

	public String getInitial() {
		return initial;
	}

}
