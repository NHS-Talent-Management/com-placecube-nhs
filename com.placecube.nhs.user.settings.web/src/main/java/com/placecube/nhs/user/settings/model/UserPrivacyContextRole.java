package com.placecube.nhs.user.settings.model;

import java.util.Locale;

import com.liferay.portal.kernel.language.LanguageUtil;

public class UserPrivacyContextRole {

	private String displayName;

	private Long roleId;

	public UserPrivacyContextRole(String displayName, Long roleId) {
		this.displayName = displayName;
		this.roleId = roleId;
	}

	public String getDisplayName(Locale locale) {
		return LanguageUtil.get(locale, this.displayName);
	}

	public Long getRoleId() {
		return this.roleId;
	}
}
