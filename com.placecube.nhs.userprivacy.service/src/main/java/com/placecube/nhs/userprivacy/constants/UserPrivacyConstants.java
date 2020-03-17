package com.placecube.nhs.userprivacy.constants;

import com.liferay.petra.string.StringPool;

public final class UserPrivacyConstants {

	public static final String PRIVACY_FIELD_PREFIX = "privacy_";

	public static final String ROLE_IDS_SEPARATOR = StringPool.SEMICOLON;

	public static String getPrivacyFieldName(String fieldName) {
		return PRIVACY_FIELD_PREFIX.concat(fieldName);
	}

	private UserPrivacyConstants() {
	}
}
