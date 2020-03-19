package com.placecube.nhs.user.settings.portlet;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.placecube.nhs.user.settings.constants.MVCCommandKeys;
import com.placecube.nhs.user.settings.constants.PortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + PortletKeys.USER_SETTINGS, "mvc.command.name=" + MVCCommandKeys.USER_PRIVACY_SETTINGS_VIEW }, service = MVCRenderCommand.class)
public class UserPrivacySettingsMVCRenderCommand implements MVCRenderCommand {

	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		return "/settings.jsp";
	}
}
