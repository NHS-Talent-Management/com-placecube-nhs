package com.placecube.nhs.user.settings.portlet;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.placecube.nhs.user.settings.constants.PortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + PortletKeys.USER_SETTINGS, "mvc.command.name=/" }, service = MVCRenderCommand.class)
public class UserSettingsMVCRenderCommand implements MVCRenderCommand {

	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		return "/view.jsp";
	}
}
