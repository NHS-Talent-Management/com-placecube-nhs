package com.placecube.nhs.user.settings.service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.Validator;
import com.placecube.nhs.readiness.model.ReadinessQuestion;
import com.placecube.nhs.readiness.service.ReadinessService;
import com.placecube.nhs.user.settings.constants.UserPrivacyPage;
import com.placecube.nhs.user.settings.model.UserPrivacyContextRole;
import com.placecube.nhs.userprivacy.service.UserPrivacyLocalService;

@Component(immediate = true, service = { UserPrivacyService.class })
public class UserPrivacyService {

	@Reference
	private RoleLocalService roleLocalService;

	@Reference
	private ReadinessService readinessService;

	@Reference
	private UserPrivacyLocalService userPrivacyLocalService;

	@Reference
	private UserPrivacyProfileService userPrivacyProfileService;

	public void updateUserPrivacy(long userId, String fieldName, long privacyRoleId, Company company) throws PortalException {
		List<ReadinessQuestion> questionnaire;
		List<Long> privacyRoleIds = new LinkedList<>();
		privacyRoleIds.add(Long.valueOf(privacyRoleId));
		UserPrivacyPage userPrivacyPage = UserPrivacyPage.valueOf(fieldName);
		switch (userPrivacyPage) {
		case WHO_CAN_SEE_MY_CAREER_READINESS:
			questionnaire = this.readinessService.getQuestionnaire(company);
			for (ReadinessQuestion readinessQuestion : questionnaire) {
				userPrivacyLocalService.updateUserPrivacy(userId, readinessQuestion.getQuestionSearchableName(), company.getCompanyId(), privacyRoleIds);
			}
			break;
		case WHO_CAN_SEE_MY_PROFILE:
			String profileFields[] = userPrivacyProfileService.getProfilePrivacyFields(company.getCompanyId());
			for (String profileFieldId : profileFields) {
				userPrivacyLocalService.updateUserPrivacy(userId, profileFieldId, company.getCompanyId(), privacyRoleIds);
			}
			break;
		default:
			userPrivacyLocalService.updateUserPrivacy(userId, userPrivacyPage.getFieldId(), company.getCompanyId(), privacyRoleIds);
		}
	}

	public List<UserPrivacyContextRole> getUserPrivacyContextRole(long companyId) throws PortletException {
		List<UserPrivacyContextRole> userPrivacyContextRole = new LinkedList<>();
		try {
			Role owner = roleLocalService.getRole(companyId, RoleConstants.OWNER);
			Role user = roleLocalService.getRole(companyId, RoleConstants.USER);
			userPrivacyContextRole.add(new UserPrivacyContextRole("privacy-role-user", user.getRoleId()));
			userPrivacyContextRole.add(new UserPrivacyContextRole("privacy-role-owner", owner.getRoleId()));
		} catch (PortalException e) {
			throw new PortletException(e);
		}
		return userPrivacyContextRole;
	}

	public List<Long> getUserPrivacyRoleIds(long userId, String fieldName, Company company) throws PortletException {
		try {

			long privacyRoleIdsSelected[];
			String userPrivacyFieldId = StringPool.BLANK;
			UserPrivacyPage userPrivacyPage = UserPrivacyPage.valueOf(fieldName);
			switch (userPrivacyPage) {
			case WHO_CAN_SEE_MY_CAREER_READINESS:
				List<ReadinessQuestion> readinessQuestions = readinessService.getQuestionnaire(company);
				userPrivacyFieldId = readinessQuestions.get(0).getQuestionSearchableName();
				break;
			case WHO_CAN_SEE_MY_PROFILE:
				String profileFields[] = userPrivacyProfileService.getProfilePrivacyFields(company.getCompanyId());
				if (ArrayUtil.isNotEmpty(profileFields) && Validator.isNotNull(profileFields[0])) {
					userPrivacyFieldId = profileFields[0];
				}
				break;
			default:
				userPrivacyFieldId = userPrivacyPage.getFieldId();
				break;
			}
			privacyRoleIdsSelected = userPrivacyLocalService.getUserPrivacyRoleIds(userId, userPrivacyFieldId);
			return Arrays.stream(privacyRoleIdsSelected).boxed().collect(Collectors.toList());
		} catch (PortalException e) {
			throw new PortletException(e);
		}

	}

	public List<UserPrivacyPage> getUserPrivacySharingPages(Company company) throws PortletException {
		try {
			List<UserPrivacyPage> userUserPrivacyPages = new LinkedList<UserPrivacyPage>();
			for (UserPrivacyPage userPrivacyPage : UserPrivacyPage.values()) {
				switch (userPrivacyPage) {
				case WHO_CAN_SEE_MY_CAREER_READINESS:
					List<ReadinessQuestion> readinessQuestions = readinessService.getQuestionnaire(company);
					if (!readinessQuestions.isEmpty()) {
						userUserPrivacyPages.add(userPrivacyPage);
					}
					break;
				case WHO_CAN_SEE_MY_PROFILE:
					String profileFields[] = userPrivacyProfileService.getProfilePrivacyFields(company.getCompanyId());
					if (ArrayUtil.isNotEmpty(profileFields) && Validator.isNotNull(profileFields[0])) {
						userUserPrivacyPages.add(userPrivacyPage);
					}
					break;
				default:
					userUserPrivacyPages.add(userPrivacyPage);
					break;
				}
			}
			return userUserPrivacyPages;
		} catch (PortalException e) {
			throw new PortletException(e);
		}
	}
}
