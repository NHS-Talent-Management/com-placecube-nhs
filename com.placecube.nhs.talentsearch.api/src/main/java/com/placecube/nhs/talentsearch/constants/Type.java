package com.placecube.nhs.talentsearch.constants;

import java.util.Locale;

import com.liferay.portal.kernel.language.LanguageUtil;

public enum Type {

	CAPABILITY("type-capability", 1),

	RETENTION("type-retention", 2),

	SUCCESSION_PLANNING("type-succession-planning", 3),

	TALENT_PIPELINE("type-talent-pipeline", 4);

	private final String key;
	private final long id;

	private Type(String key, long id) {
		this.key = key;
		this.id = id;
	}

	public String getLabel(Locale locale) {
		return LanguageUtil.get(locale, key);
	}

	public long getId() {
		return id;
	}

}
