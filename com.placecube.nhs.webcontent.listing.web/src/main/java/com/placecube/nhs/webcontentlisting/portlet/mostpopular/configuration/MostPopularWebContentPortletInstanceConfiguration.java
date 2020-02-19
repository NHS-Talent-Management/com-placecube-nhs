package com.placecube.nhs.webcontentlisting.portlet.mostpopular.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "nhs", scope = ExtendedObjectClassDefinition.Scope.PORTLET_INSTANCE)
@Meta.OCD(id = "com.placecube.nhs.webcontentlisting.mostpopular.configuration.MostPopularCommunityPortletInstanceConfiguration", localization = "content/Language", name = "webcontentlisting-mostpopular-portlet-instance-configuration-name")
public interface MostPopularWebContentPortletInstanceConfiguration {

	@Meta.AD(deflt = "false", name = "matching-categories", required = false)
	boolean matchingCategories();

	@Meta.AD(deflt = "8", name = "max-items-to-display", required = false)
	Integer maxItemsToDisplay();

	@Meta.AD(deflt = "", name = "structure-key", required = false)
	String structureKey();

	@Meta.AD(deflt = "", name = "template-key", required = false)
	String templateKey();

}
