package com.placecube.nhs.communitylisting.portlet.az.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(scope = ExtendedObjectClassDefinition.Scope.PORTLET_INSTANCE)
@Meta.OCD(id = "com.placecube.nhs.communitylisting.az.configuration.AZCommunityPortletInstanceConfiguration", localization = "content/Language", name = "communitylisting-az-portlet-instance-configuration-name")
public interface AZCommunityPortletInstanceConfiguration {

	@Meta.AD(deflt = "", name = "group-type", required = false)
	String[] groupTypes();

	@Meta.AD(deflt = "false", name = "matching-categories", required = false)
	boolean matchingCategories();

}
