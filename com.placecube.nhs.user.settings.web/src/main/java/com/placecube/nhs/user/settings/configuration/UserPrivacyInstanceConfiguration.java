package com.placecube.nhs.user.settings.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "nhs.userprivacy", scope = ExtendedObjectClassDefinition.Scope.COMPANY)
@Meta.OCD(id = "com.placecube.nhs.user.settings.configuration.UserPrivacyInstanceConfiguration", localization = "content/Language", name = "userprivacy-instance-configuration-name")
public interface UserPrivacyInstanceConfiguration {

	@Meta.AD(deflt = "", name = "profile-privacy-fields-name", required = false)
	String[] profilePrivacyFields();
}
