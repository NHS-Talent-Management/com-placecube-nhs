package com.placecube.nhs.user.settings.service;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.placecube.nhs.readiness.model.ReadinessQuestion;
import com.placecube.nhs.user.settings.constants.UserPrivacyPage;
import com.placecube.nhs.userprivacy.service.UserPrivacyLocalService;

@Component(immediate = true, service = { UserPrivacyService.class })
public class UserPrivacyService {

	@Reference
	private RoleLocalService roleLocalService;

	@Reference
	private UserPrivacyLocalService userPrivacyLocalService;

	@Reference
	private SettingsConfigurationService settingsConfigurationService;

	public List<UserPrivacyPage> getEnabledPrivacyPages(Company company) {
		List<UserPrivacyPage> results = new LinkedList<>(Arrays.asList(UserPrivacyPage.values()));

		if (settingsConfigurationService.getCareerReadinessFields(company).isEmpty()) {
			results.remove(UserPrivacyPage.CAREER_READINESS);
		}

		if (ArrayUtil.isEmpty(settingsConfigurationService.getProfilePrivacyFields(company.getCompanyId()))) {
			results.remove(UserPrivacyPage.PROFILE);
		}

		return results;
	}

	public Long getSelectedValue(long userId, UserPrivacyPage userPrivacyPage, Company company) {
		String userPrivacyFieldId;
		switch (userPrivacyPage) {
		case CAREER_READINESS:
			userPrivacyFieldId = settingsConfigurationService.getCareerReadinessPrivacyFieldId(company);
			break;
		case PROFILE:
			userPrivacyFieldId = settingsConfigurationService.getProfilePrivacyFieldId(company);
			break;
		default:
			userPrivacyFieldId = userPrivacyPage.getClassNameId();
			break;
		}

		long[] privacyRoleIdsSelected = userPrivacyLocalService.getUserPrivacyRoleIds(userId, userPrivacyFieldId);
		if (ArrayUtil.isNotEmpty(privacyRoleIdsSelected)) {
			return privacyRoleIdsSelected[0];
		}
		return 0l;
	}

	public Map<String, String> getUserPrivacyOptions(long companyId) throws PortletException {
		try {
			Map<String, String> results = new LinkedHashMap<>();
			results.put(String.valueOf(roleLocalService.getRole(companyId, RoleConstants.USER).getRoleId()), "privacy-nhs");
			results.put(String.valueOf(roleLocalService.getRole(companyId, RoleConstants.OWNER).getRoleId()), "private");
			return results;
		} catch (Exception e) {
			throw new PortletException(e);
		}
	}

	public void updateUserPrivacy(long userId, UserPrivacyPage userPrivacyPage, long privacyRoleId, Company company) throws PortalException {
		List<Long> privacyRoleIds = new LinkedList<>();
		privacyRoleIds.add(privacyRoleId);

		switch (userPrivacyPage) {
		case CAREER_READINESS:
			List<ReadinessQuestion> questionnaire = settingsConfigurationService.getCareerReadinessFields(company);
			for (ReadinessQuestion readinessQuestion : questionnaire) {
				userPrivacyLocalService.updateUserPrivacy(company.getCompanyId(), userId, readinessQuestion.getQuestionSearchableName(), privacyRoleIds);
			}
			break;
		case PROFILE:
			String profileFields[] = settingsConfigurationService.getProfilePrivacyFields(company.getCompanyId());
			for (String profileFieldId : profileFields) {
				userPrivacyLocalService.updateUserPrivacy(company.getCompanyId(), userId, profileFieldId, privacyRoleIds);
			}
			break;
		default:
			userPrivacyLocalService.updateUserPrivacy(company.getCompanyId(), userId, userPrivacyPage.getClassNameId(), privacyRoleIds);
		}
	}
}
