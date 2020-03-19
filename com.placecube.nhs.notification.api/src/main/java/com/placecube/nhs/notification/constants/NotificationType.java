package com.placecube.nhs.notification.constants;

import java.util.Locale;

import com.liferay.portal.kernel.language.LanguageUtil;

public enum NotificationType {

	EMAIL(1, "email");

	private final int key;
	private final String label;

	private NotificationType(int key, String label) {
		this.key = key;
		this.label = label;
	}

	public int getKey() {
		return key;
	}

	public String getLabel(Locale locale) {
		return LanguageUtil.get(locale, label);
	}

}
