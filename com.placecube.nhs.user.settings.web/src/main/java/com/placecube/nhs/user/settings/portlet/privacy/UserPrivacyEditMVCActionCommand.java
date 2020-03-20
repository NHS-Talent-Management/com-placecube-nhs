package com.placecube.nhs.user.settings.portlet.privacy;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.placecube.nhs.user.settings.constants.MVCCommandKeys;
import com.placecube.nhs.user.settings.constants.PortletKeys;
import com.placecube.nhs.user.settings.constants.UserPrivacyPage;
import com.placecube.nhs.user.settings.service.UserPrivacyService;

@Component(immediate = true, property = { "javax.portlet.name=" + PortletKeys.USER_SETTINGS, "mvc.command.name=" + MVCCommandKeys.USER_PRIVACY_UPDATE }, service = MVCActionCommand.class)
public class UserPrivacyEditMVCActionCommand extends BaseMVCActionCommand {

	@Reference
	private UserPrivacyService userPrivacyService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long privacyRoleId = ParamUtil.getLong(actionRequest, "userPrivacy");
		String userPrivacyPage = ParamUtil.getString(actionRequest, "userPrivacyPage");

		userPrivacyService.updateUserPrivacy(themeDisplay.getUserId(), UserPrivacyPage.valueOf(userPrivacyPage), privacyRoleId, themeDisplay.getCompany());

		actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandKeys.USER_PRIVACY_OPTIONS);
	}
}
