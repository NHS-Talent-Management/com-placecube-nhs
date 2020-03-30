package com.placecube.nhs.setup.constants;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.blogs.model.BlogsEntry;
import com.liferay.portal.kernel.theme.NavItem;

public enum WidgetTemplates {

	ASSET_PUBLISHER_BLOGS_CARD_LISTING("ASSET_PUBLISHER_BLOGS_CARD_LISTING", "Asset Entry Blogs Card Listing", AssetEntry.class.getName()),

	BLOG_CARDS("BLOG_CARDS", "Blogs Card Listing", BlogsEntry.class.getName()),

	NAVIGATION_HEADER("NAV-MENU-HEADER", "Navigation Menu Header", NavItem.class.getName());

	private final String key;
	private final String className;
	private final String title;

	private WidgetTemplates(String key, String title, String className) {
		this.key = key;
		this.className = className;
		this.title = title;
	}

	public String getKey() {
		return key;
	}

	public String getClassName() {
		return className;
	}

	public String getTitle() {
		return title;
	}

}
