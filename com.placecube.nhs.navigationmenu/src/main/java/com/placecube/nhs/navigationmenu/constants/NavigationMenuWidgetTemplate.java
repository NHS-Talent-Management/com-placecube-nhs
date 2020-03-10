package com.placecube.nhs.navigationmenu.constants;

public enum NavigationMenuWidgetTemplate {

	HEADER("NAV-MENU-HEADER", "Nav Menu Header");

	private final String key;
	private final String name;

	private NavigationMenuWidgetTemplate(String key, String name) {
		this.key = key;
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public String getName() {
		return name;
	}
}
