package com.placecube.nhs.user.profile.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.WindowState;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.placecube.nhs.user.profile.constants.MVCCommandKeys;
import com.placecube.nhs.user.profile.constants.PortletKeys;
import com.placecube.nhs.user.profile.model.UserProfileContext;
import com.placecube.nhs.user.profile.service.UserProfileService;

@Component(immediate = true, property = { "javax.portlet.name=" + PortletKeys.USER_PROFILE, "mvc.command.name=" + MVCCommandKeys.EDIT }, service = MVCActionCommand.class)

public class UserProfileMVCActionCommand extends BaseMVCActionCommand {

	@Reference
	private UserProfileService userProfileService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		UserProfileContext userProfileContext = userProfileService.populateFromRequest(actionRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		userProfileService.validateUserProfileModel(userProfileContext, themeDisplay.getLocale());

		if (userProfileContext.isValid()) {

			userProfileService.updateUserProfile(userProfileContext, themeDisplay.getUser());

			actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandKeys.VIEW);
			actionResponse.setWindowState(WindowState.NORMAL);

		} else {
			actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandKeys.EDIT);
			actionRequest.setAttribute("userProfileContext", userProfileContext);
		}
	}

}
