package com.placecube.nhs.registration.configuration;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

@Component(service = ConfigurationBeanDeclaration.class)
public class RegistrationCompanyConfigurationBeanDeclaration implements ConfigurationBeanDeclaration {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return RegistrationCompanyConfiguration.class;
	}

}
