package com.placecube.nhs.user.settings.userprivacy;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.placecube.nhs.user.settings.constants.MVCCommandKeys;
import com.placecube.nhs.user.settings.constants.PortletKeys;
import com.placecube.nhs.user.settings.constants.UserPrivacyPage;
import com.placecube.nhs.user.settings.service.UserPrivacyService;

@Component(immediate = true, property = { "javax.portlet.name=" + PortletKeys.USER_SETTINGS, "mvc.command.name=" + MVCCommandKeys.USER_PRIVACY_SHARING_VIEW }, service = MVCRenderCommand.class)
public class UserPrivacySharingMVCRenderCommand implements MVCRenderCommand {

	@Reference
	private UserPrivacyService userPrivacyService;

	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<UserPrivacyPage> userPrivacySharingPages = userPrivacyService.getUserPrivacySharingPages(themeDisplay.getCompany());
		renderRequest.setAttribute("userPrivacySharingPages", userPrivacySharingPages);
		return "/user-privacy-sharing/view.jsp";
	}
}
