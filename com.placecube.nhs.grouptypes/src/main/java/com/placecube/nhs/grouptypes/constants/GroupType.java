package com.placecube.nhs.grouptypes.constants;

public enum GroupType {

	COMMUNITY_OF_INTEREST("community-of-interest"),

	COMMUNITY_OF_PRACTICE("community-of-practice");

	private final String key;

	private GroupType(String key) {
		this.key = key;
	}

	public String getValue() {
		return key;
	}

}
