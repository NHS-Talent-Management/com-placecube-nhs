package com.placecube.nhs.registration.portlet;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.placecube.nhs.registration.constants.MVCCommandKeys;
import com.placecube.nhs.registration.constants.PortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + PortletKeys.REGISTRATION, "mvc.command.name=" + MVCCommandKeys.CONFIRMATION }, service = MVCRenderCommand.class)
public class ConfirmationPageMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		return "/confirmation-page.jsp";
	}

}
