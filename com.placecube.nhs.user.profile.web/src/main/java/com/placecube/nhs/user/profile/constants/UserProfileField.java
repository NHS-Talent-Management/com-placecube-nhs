package com.placecube.nhs.user.profile.constants;

public enum UserProfileField {

	CURRENT_POSITION("currentPosition", "enter-your-current-position", 100, "enter-a-current-position-that-is-100-characters-or-fewer"),

	FIRSTNAME("firstName", "enter-your-firstname", 75, "enter-a-firstname-that-is-75-characters-or-fewer"),

	LASTNAME("lastName", "enter-your-lastname", 75, "enter-a-lastname-that-is-75-characters-or-fewer"),

	LOCATION("location", "enter-your-location", 250, "enter-a-location-that-is-250-characters-or-fewer"),

	SUMMARY("summary", "enter-your-summary", 1000, "enter-a-summary-that-is-1000-characters-or-fewer");

	private final String fieldName;
	private final String mandatoryErrorKey;
	private final int maxLength;
	private final String maxLengthErrorKey;

	private UserProfileField(String fieldName, String mandatoryErrorKey, int maxLength, String maxLengthErrorKey) {
		this.fieldName = fieldName;
		this.mandatoryErrorKey = mandatoryErrorKey;
		this.maxLength = maxLength;
		this.maxLengthErrorKey = maxLengthErrorKey;
	}

	public String getFieldName() {
		return fieldName;
	}

	public String getMandatoryErrorKey() {
		return mandatoryErrorKey;
	}

	public int getMaxLength() {
		return maxLength;
	}

	public String getMaxLengthErrorKey() {
		return maxLengthErrorKey;
	}

}
