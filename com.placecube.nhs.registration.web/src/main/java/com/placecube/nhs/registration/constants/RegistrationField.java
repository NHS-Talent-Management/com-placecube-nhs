package com.placecube.nhs.registration.constants;

public enum RegistrationField {

	FIRSTNAME("firstName", "enter-your-firstname", 75, "enter-a-firstname-that-is-75-characters-or-fewer"),

	LASTNAME("lastName", "enter-your-lastname", 75, "enter-a-lastname-that-is-75-characters-or-fewer"),

	EMAIL("emailAddress", "enter-your-email-address", 250, "enter-an-email-that-is-250-characters-or-fewer"),

	PASSWORD("password", "enter-your-password", 75, "enter-a-password-that-is-75-characters-or-fewer"),

	PASSWORD_CONFIRM("confirmPassword", "enter-your-password-again", 75, "enter-a-password-that-is-75-characters-or-fewer");

	private final String fieldName;
	private final String mandatoryErrorKey;
	private final int maxLength;
	private final String maxLengthErrorKey;

	private RegistrationField(String fieldName, String mandatoryErrorKey, int maxLength, String maxLengthErrorKey) {
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
