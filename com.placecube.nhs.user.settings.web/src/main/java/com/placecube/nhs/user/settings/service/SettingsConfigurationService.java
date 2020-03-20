package com.placecube.nhs.user.settings.service;

import java.util.Collections;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.Validator;
import com.placecube.nhs.readiness.model.ReadinessQuestion;
import com.placecube.nhs.readiness.service.ReadinessService;
import com.placecube.nhs.user.settings.configuration.UserPrivacyInstanceConfiguration;

@Component(immediate = true, service = { SettingsConfigurationService.class })
public class SettingsConfigurationService {

	private static final Log LOG = LogFactoryUtil.getLog(SettingsConfigurationService.class);

	@Reference
	private ConfigurationProvider configurationProvider;

	@Reference
	private ReadinessService readinessService;

	public List<ReadinessQuestion> getCareerReadinessFields(Company company) {
		try {
			return readinessService.getQuestionnaire(company);
		} catch (Exception e) {
			LOG.debug(e);
			return Collections.emptyList();
		}
	}

	public String getCareerReadinessPrivacyFieldId(Company company) {
		return getCareerReadinessFields(company).get(0).getQuestionSearchableName();
	}

	public String getProfilePrivacyFieldId(Company company) {
		return getProfilePrivacyFields(company.getCompanyId())[0];
	}

	public String[] getProfilePrivacyFields(long companyId) {
		try {
			UserPrivacyInstanceConfiguration configuration = configurationProvider.getCompanyConfiguration(UserPrivacyInstanceConfiguration.class, companyId);
			String[] profilePrivacyFields = configuration.profilePrivacyFields();
			if (ArrayUtil.isNotEmpty(profilePrivacyFields) && Validator.isNotNull(profilePrivacyFields[0])) {
				return profilePrivacyFields;
			}
		} catch (Exception e) {
			LOG.debug(e);
		}
		return new String[0];
	}

}
