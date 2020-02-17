package com.placecube.nhs.communitylisting.portlet.az.configuration;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

@Component(service = ConfigurationBeanDeclaration.class)
public class AZCommunityConfigurationBeanDeclaration implements ConfigurationBeanDeclaration {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return AZCommunityPortletInstanceConfiguration.class;
	}

}
