package com.placecube.nhs.communitylisting.portlet.mycommunities.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "nhs", scope = ExtendedObjectClassDefinition.Scope.PORTLET_INSTANCE)
@Meta.OCD(id = "com.placecube.nhs.communitylisting.portlet.mycommunities.configuration.MyCommunitiesPortletInstanceConfiguration", localization = "content/Language", name = "communitylisting-mycommunities-portlet-instance-configuration-name")
public interface MyCommunitiesPortletInstanceConfiguration {

	@Meta.AD(deflt = "", name = "group-type", required = false)
	String[] groupTypes();

	@Meta.AD(deflt = "", name = "view-all-url", required = false)
	String viewAllURL();

}
