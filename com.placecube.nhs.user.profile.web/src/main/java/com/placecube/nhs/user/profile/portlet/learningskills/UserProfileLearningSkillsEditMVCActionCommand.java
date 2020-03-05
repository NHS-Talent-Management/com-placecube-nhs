package com.placecube.nhs.user.profile.portlet.learningskills;

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

@Component(immediate = true, property = { "javax.portlet.name=" + PortletKeys.USER_PROFILE_LEARNING_SKILLS,
		"mvc.command.name=" + MVCCommandKeys.LEARNING_SKILLS_EDIT }, service = MVCActionCommand.class)

public class UserProfileLearningSkillsEditMVCActionCommand extends BaseMVCActionCommand {

	@Reference
	private ExtraInfoService extraInfoService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		User user = themeDisplay.getUser();
		Locale locale = user.getLocale();

		ExtraInfoContext extraInfoContext = extraInfoService.populateExtraInfoFromRequest(actionRequest, user.getTimeZone());

		Map<String, String> validationErrors = extraInfoService.getValidationErrorsForQualification(extraInfoContext, locale);

		if (validationErrors.isEmpty()) {

			if (extraInfoContext.getId() > 0) {
				extraInfoService.updateQualification(extraInfoContext);
			} else {
				extraInfoService.addQualification(user, extraInfoContext);
			}

			actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandKeys.LEARNING_SKILLS_VIEW);
			actionResponse.setWindowState(WindowState.NORMAL);

		} else {
			actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandKeys.LEARNING_SKILLS_EDIT);
			actionRequest.setAttribute("extraInfoContext", extraInfoContext);
			actionRequest.setAttribute("validationErrors", validationErrors);
		}
	}

}
