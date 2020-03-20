package com.placecube.nhs.user.settings.portlet.communications;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.placecube.nhs.notification.constants.NotificationType;
import com.placecube.nhs.notification.service.UserNotificationPreferenceLocalService;
import com.placecube.nhs.user.settings.constants.MVCCommandKeys;
import com.placecube.nhs.user.settings.constants.PortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + PortletKeys.USER_SETTINGS, "mvc.command.name=" + MVCCommandKeys.COMMUNICATIONS_UPDATE }, service = MVCActionCommand.class)
public class CommunicationsEditMVCActionCommand extends BaseMVCActionCommand {

	@Reference
	private UserNotificationPreferenceLocalService userNotificationPreferenceLocalService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		String[] userNotificationPreferences = ParamUtil.getStringValues(actionRequest, "userNotificationPreference", new String[0]);

		for (NotificationType notificationType : NotificationType.values()) {
			boolean enabled = ArrayUtil.contains(userNotificationPreferences, notificationType.getKey());
			userNotificationPreferenceLocalService.configureNotificationPreference(userId, notificationType, enabled);
		}

		actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandKeys.VIEW_SETTINGS_OPTIONS);
	}
}
