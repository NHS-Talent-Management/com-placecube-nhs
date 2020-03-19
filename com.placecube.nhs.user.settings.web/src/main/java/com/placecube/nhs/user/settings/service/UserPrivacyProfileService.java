package com.placecube.nhs.user.settings.service;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.placecube.nhs.user.settings.configuration.UserPrivacyInstanceConfiguration;

@Component(immediate = true, service = { UserPrivacyProfileService.class })
public class UserPrivacyProfileService {

	@Reference
	private ConfigurationProvider configurationProvider;

	public String[] getProfilePrivacyFields(long companyId) throws PortalException {
		UserPrivacyInstanceConfiguration configuration = configurationProvider.getCompanyConfiguration(UserPrivacyInstanceConfiguration.class, companyId);
		return configuration.profilePrivacyFields();
	}
}
