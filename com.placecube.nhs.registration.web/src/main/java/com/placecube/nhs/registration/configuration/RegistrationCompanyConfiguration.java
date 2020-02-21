package com.placecube.nhs.registration.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "nsh.user.registration", scope = ExtendedObjectClassDefinition.Scope.COMPANY)
@Meta.OCD(id = "com.placecube.nhs.registration.configuration.RegistrationCompanyConfiguration", localization = "content/Language", name = "nhs-registation-configuration")
public interface RegistrationCompanyConfiguration {

	@Meta.AD(required = false, deflt = "", name = "registration-page-url")
	String registrationFullPageURL();

}
