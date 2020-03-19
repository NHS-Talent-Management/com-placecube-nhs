package com.placecube.nhs.user.settings.constants;

import com.liferay.portal.kernel.language.LanguageUtil;
import java.util.Locale;

public enum UserSettingsPage {
	PRIVACY_SHARING("privacy-sharing", "/userPrivacySharing/view"), COMMUNICATIONS("communications", "/");

	private final String fieldName;

	private final String mvcCommandName;

	UserSettingsPage(String fieldName, String mvcCommandName) {
		this.fieldName = fieldName;
		this.mvcCommandName = mvcCommandName;
	}

	public String getFieldName() {
		return this.fieldName;
	}

	public String getMvcCommandName() {
		return this.mvcCommandName;
	}

	public String getFieldLabel(Locale locale) {
		return LanguageUtil.get(locale, this.fieldName);
	}
}
