package com.placecube.nhs.talentsearch.constants;

import java.util.Locale;

import com.liferay.portal.kernel.language.LanguageUtil;

public enum Category {

	BEREAVEMENT_MIDWIVES("category-bereavement-midwives", 1),

	DOCTORS("category-doctors", 2),

	DOCTORS_IN_TRAINING("category-doctors-in-training", 3),

	GRADUATE_MANAGEMENT_TRAINEES("category-graduate-management-trainees", 4),

	MIDWIVES("category-midwives", 5),

	NURSES("category-nurses", 6);

	private final long id;
	private final String key;

	private Category(String key, long id) {
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
