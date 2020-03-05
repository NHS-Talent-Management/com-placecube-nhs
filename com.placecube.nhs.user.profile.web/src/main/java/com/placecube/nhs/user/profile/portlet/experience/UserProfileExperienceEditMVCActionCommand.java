package com.placecube.nhs.user.profile.portlet.experience;

import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.WindowState;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.placecube.nhs.user.profile.constants.MVCCommandKeys;
import com.placecube.nhs.user.profile.constants.PortletKeys;
import com.placecube.nhs.user.profile.model.ExtraInfoContext;
import com.placecube.nhs.user.profile.service.ExtraInfoService;

@Component(immediate = true, property = { "javax.portlet.name=" + PortletKeys.USER_PROFILE_EXPERIENCE, "mvc.command.name=" + MVCCommandKeys.EXPERIENCE_EDIT }, service = MVCActionCommand.class)

public class UserProfileExperienceEditMVCActionCommand extends BaseMVCActionCommand {

	@Reference
	private ExtraInfoService extraInfoService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		User user = themeDisplay.getUser();
		Locale locale = user.getLocale();

		ExtraInfoContext extraInfoContext = extraInfoService.populateExtraInfoFromRequest(actionRequest, user.getTimeZone());

		Map<String, String> validationErrors = extraInfoService.getValidationErrorsForExperience(extraInfoContext, locale);

		if (validationErrors.isEmpty()) {

			if (extraInfoContext.getId() > 0) {
				extraInfoService.updateExperience(extraInfoContext);
			} else {
				extraInfoService.addExperience(user, extraInfoContext);
			}

			actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandKeys.EXPERIENCE_VIEW);
			actionResponse.setWindowState(WindowState.NORMAL);

		} else {
			actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandKeys.EXPERIENCE_EDIT);
			actionRequest.setAttribute("extraInfoContext", extraInfoContext);
			actionRequest.setAttribute("validationErrors", validationErrors);
		}
	}

}
