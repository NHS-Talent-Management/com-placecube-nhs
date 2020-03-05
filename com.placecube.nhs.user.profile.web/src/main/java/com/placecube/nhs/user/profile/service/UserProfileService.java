package com.placecube.nhs.user.profile.service;

import java.util.LinkedHashMap;
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
import com.placecube.nhs.user.profile.model.UserProfileContext;

@Component(immediate = true, service = UserProfileService.class)
public class UserProfileService {

	@Reference
	private ValidationService validationService;

	@Reference
	private UserLocalService userLocalService;

	public Map<String, String> getValidationErrorsForUserProfileModel(UserProfileContext userProfileContext, Locale locale) {
		Map<String, String> errors = new LinkedHashMap<>();
		validationService.validateMandatoryField(errors, locale, userProfileContext.getFirstName(), "firstName", "enter-your-firstname", 75, "enter-a-firstname-that-is-75-characters-or-fewer");
		validationService.validateMandatoryField(errors, locale, userProfileContext.getLastName(), "lastName", "enter-your-lastname", 75, "enter-a-lastname-that-is-75-characters-or-fewer");
		validationService.validateOptionalField(errors, locale, userProfileContext.getCurrentPosition(), "currentPosition", 100, "enter-a-current-position-that-is-100-characters-or-fewer");
		validationService.validateOptionalField(errors, locale, userProfileContext.getSummary(), "summary", 1000, "enter-a-summary-that-is-1000-characters-or-fewer");
		validationService.validateOptionalField(errors, locale, userProfileContext.getLocation(), "location", 250, "enter-a-location-that-is-250-characters-or-fewer");
		return errors;
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
