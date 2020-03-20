package com.placecube.nhs.user.settings.portlet.communications;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.placecube.nhs.notification.constants.NotificationType;
import com.placecube.nhs.notification.model.UserNotificationPreference;
import com.placecube.nhs.notification.service.UserNotificationPreferenceLocalService;
import com.placecube.nhs.user.settings.constants.MVCCommandKeys;
import com.placecube.nhs.user.settings.constants.PortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + PortletKeys.USER_SETTINGS, "mvc.command.name=" + MVCCommandKeys.COMMUNICATIONS_UPDATE }, service = MVCRenderCommand.class)
public class CommunicationsEditMVCRenderCommand implements MVCRenderCommand {

	@Reference
	private UserNotificationPreferenceLocalService userNotificationPreferenceLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Locale locale = themeDisplay.getLocale();

		Map<String, String> notificationOptions = new LinkedHashMap<>();
		for (NotificationType notificationType : NotificationType.values()) {
			notificationOptions.put(notificationType.getKey(), notificationType.getLabel(locale));
		}
		renderRequest.setAttribute("notificationOptions", notificationOptions);

		List<UserNotificationPreference> userNotificationPreferences = userNotificationPreferenceLocalService.getByUserId(themeDisplay.getUserId());
		List<String> notificationSelectedValues = userNotificationPreferences.stream().filter(UserNotificationPreference::isEnabled).map(UserNotificationPreference::getNotificationType)
				.collect(Collectors.toList());
		renderRequest.setAttribute("notificationSelectedValues", notificationSelectedValues);

		return "/communications/edit.jsp";
	}
}
