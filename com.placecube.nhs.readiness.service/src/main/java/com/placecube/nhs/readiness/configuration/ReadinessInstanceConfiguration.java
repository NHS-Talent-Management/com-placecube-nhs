package com.placecube.nhs.readiness.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@FunctionalInterface
@ExtendedObjectClassDefinition(category = "nhs.readiness", scope = ExtendedObjectClassDefinition.Scope.COMPANY)
@Meta.OCD(id = "com.placecube.nhs.readiness.configuration.ReadinessInstanceConfiguration", localization = "content/Language", name = "readiness-instance-configuration-name")
public interface ReadinessInstanceConfiguration {

	@Meta.AD(deflt = "", name = "questions-name", description = "questions-description", required = false)
	String[] questions();

}
