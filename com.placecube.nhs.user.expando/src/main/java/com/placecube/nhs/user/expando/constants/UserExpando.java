package com.placecube.nhs.user.expando.constants;

import java.util.Locale;

import com.liferay.portal.kernel.language.LanguageUtil;

public enum UserExpando {

	ENVIRONMENT("environment"),

	GOAL("goal"),

	LOCATION("location"),

	PAY_SCALE("pay-scale"),

	PROFESSIONAL_AREA("professional-area"),

	READINESS("readiness");

	private final String fieldName;

	private UserExpando(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public String getFieldLabel(Locale locale) {
		return LanguageUtil.get(locale, fieldName);
	}

}
