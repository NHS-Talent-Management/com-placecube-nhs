package com.placecube.nhs.user.settings.constants;

public enum UserSettingsPage {

	PRIVACY_SHARING("privacy-sharing", MVCCommandKeys.USER_PRIVACY_OPTIONS),

	COMMUNICATIONS("communications", MVCCommandKeys.COMMUNICATIONS_UPDATE);

	private final String fieldLabel;
	private final String mvcCommandName;

	private UserSettingsPage(String fieldLabel, String mvcCommandName) {
		this.fieldLabel = fieldLabel;
		this.mvcCommandName = mvcCommandName;
	}

	public String getMvcCommandName() {
		return mvcCommandName;
	}

	public String getFieldLabel() {
		return fieldLabel;
	}
}
