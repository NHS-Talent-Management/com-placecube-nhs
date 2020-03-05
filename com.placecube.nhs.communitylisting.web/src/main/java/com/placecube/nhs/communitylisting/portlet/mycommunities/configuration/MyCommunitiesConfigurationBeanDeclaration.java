package com.placecube.nhs.communitylisting.portlet.mycommunities.configuration;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

@Component(service = ConfigurationBeanDeclaration.class)
public class MyCommunitiesConfigurationBeanDeclaration implements ConfigurationBeanDeclaration {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return MyCommunitiesPortletInstanceConfiguration.class;
	}

}
