package com.placecube.nhs.notification.constants;

import java.util.Arrays;
import java.util.Locale;

import com.liferay.portal.kernel.language.LanguageUtil;

public enum NotificationType {

	EMAIL("email");

	private final String key;

	private NotificationType(String key) {
		this.key = key;
	}

	public static NotificationType getByKey(String key) {
		return Arrays.asList(NotificationType.values()).stream().filter(entry -> entry.getKey().equals(key)).findFirst().get();
	}

	public String getKey() {
		return key;
	}

	public String getLabel(Locale locale) {
		return LanguageUtil.get(locale, key);
	}

}
