package com.placecube.nhs.readiness.configuration;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

@Component(service = ConfigurationBeanDeclaration.class)
public class ReadinessConfigurationBeanDeclaration implements ConfigurationBeanDeclaration {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return ReadinessInstanceConfiguration.class;
	}

}
