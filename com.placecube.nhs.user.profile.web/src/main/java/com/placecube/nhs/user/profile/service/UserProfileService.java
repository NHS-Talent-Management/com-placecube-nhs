package com.placecube.nhs.user.profile.service;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.placecube.nhs.user.expando.constants.UserExpando;
import com.placecube.nhs.user.profile.constants.UserProfileField;
import com.placecube.nhs.user.profile.model.UserProfileContext;

@Component(immediate = true, service = UserProfileService.class)
public class UserProfileService {

	@Reference
	private ValidationService validationService;

	@Reference
	private UserLocalService userLocalService;

	public void validateUserProfileModel(UserProfileContext userProfileContext, Locale locale) {
		Map<String, String> errors = new HashMap<>();
		validationService.validateMandatoryField(errors, locale, UserProfileField.FIRSTNAME, userProfileContext.getFirstName());
		validationService.validateMandatoryField(errors, locale, UserProfileField.LASTNAME, userProfileContext.getLastName());
		validationService.validateOptionalField(errors, locale, UserProfileField.CURRENT_POSITION, userProfileContext.getCurrentPosition());
		validationService.validateOptionalField(errors, locale, UserProfileField.SUMMARY, userProfileContext.getSummary());
		validationService.validateOptionalField(errors, locale, UserProfileField.LOCATION, userProfileContext.getLocation());
		userProfileContext.setErrors(errors);
	}

	public UserProfileContext getUserProfileContext(PortletRequest portletRequest) {
		UserProfileContext result = (UserProfileContext) portletRequest.getAttribute("userProfileContext");
		if (Validator.isNotNull(result)) {
			return result;
		} else {
			ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
			User user = themeDisplay.getUser();
			UserProfileContext userProfileContext = new UserProfileContext();
			userProfileContext.setCurrentPosition(user.getJobTitle());
			userProfileContext.setFirstName(user.getFirstName());
			userProfileContext.setLastName(user.getLastName());
			userProfileContext.setLocation(GetterUtil.getString(user.getExpandoBridge().getAttribute(UserExpando.LOCATION.getFieldName(), false)));
			userProfileContext.setSummary(user.getComments());
			return userProfileContext;
		}

	}

	public UserProfileContext populateFromRequest(PortletRequest portletRequest) {
		UserProfileContext userProfileModel = new UserProfileContext();
		userProfileModel.setFirstName(ParamUtil.getString(portletRequest, "firstName"));
		userProfileModel.setLastName(ParamUtil.getString(portletRequest, "lastName"));
		userProfileModel.setLocation(ParamUtil.getString(portletRequest, "location"));
		userProfileModel.setSummary(ParamUtil.getString(portletRequest, "summary"));
		userProfileModel.setCurrentPosition(ParamUtil.getString(portletRequest, "currentPosition"));
		return userProfileModel;
	}

	public void updateUserProfile(UserProfileContext userProfileContext, User user) {
		user.setFirstName(userProfileContext.getFirstName());
		user.setLastName(userProfileContext.getLastName());
		user.setComments(userProfileContext.getSummary());
		user.setJobTitle(userProfileContext.getCurrentPosition());
		user.getExpandoBridge().setAttribute(UserExpando.LOCATION.getFieldName(), userProfileContext.getLocation(), false);
		userLocalService.updateUser(user);
	}

}
