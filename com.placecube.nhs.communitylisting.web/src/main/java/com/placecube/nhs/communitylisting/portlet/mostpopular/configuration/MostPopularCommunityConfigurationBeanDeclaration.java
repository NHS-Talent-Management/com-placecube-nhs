package com.placecube.nhs.communitylisting.portlet.mostpopular.configuration;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

@Component(service = ConfigurationBeanDeclaration.class)
public class MostPopularCommunityConfigurationBeanDeclaration implements ConfigurationBeanDeclaration {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return MostPopularCommunityPortletInstanceConfiguration.class;
	}

}
