package com.placecube.nhs.user.settings.configuration;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

@Component(service = ConfigurationBeanDeclaration.class)
public class UserPrivacyConfigurationBeanDeclaration implements ConfigurationBeanDeclaration {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return UserPrivacyInstanceConfiguration.class;
	}

}
