package com.placecube.nhs.communitylisting.portlet.mostpopular.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "nhs", scope = ExtendedObjectClassDefinition.Scope.PORTLET_INSTANCE)
@Meta.OCD(id = "com.placecube.nhs.communitylisting.mostpopular.configuration.MostPopularCommunityPortletInstanceConfiguration", localization = "content/Language", name = "communitylisting-mostpopular-portlet-instance-configuration-name")
public interface MostPopularCommunityPortletInstanceConfiguration {

	@Meta.AD(deflt = "", name = "browse-all-url", required = false)
	String browseAllURL();

	@Meta.AD(deflt = "8", name = "max-items-to-display", required = false)
	Integer maxItemsToDisplay();
}
