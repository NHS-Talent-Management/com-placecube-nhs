package com.placecube.nhs.webcontentlisting.portlet.az.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "nhs", scope = ExtendedObjectClassDefinition.Scope.PORTLET_INSTANCE)
@Meta.OCD(id = "com.placecube.nhs.webcontentlisting.az.configuration.AZWebContentPortletInstanceConfiguration", localization = "content/Language", name = "webcontentlisting-az-portlet-instance-configuration-name")
public interface AZWebContentPortletInstanceConfiguration {

	@Meta.AD(deflt = "", name = "structure-key", required = false)
	String structureKey();

}
