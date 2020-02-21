package com.placecube.nhs.registration.portlet;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.captcha.util.CaptchaUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.placecube.nhs.registration.constants.MVCCommandKeys;
import com.placecube.nhs.registration.constants.PortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + PortletKeys.REGISTRATION, "mvc.command.name=" + MVCCommandKeys.DISPLAY_CAPTCHA }, service = MVCResourceCommand.class)
public class CaptchaMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException {
		try {
			CaptchaUtil.serveImage(resourceRequest, resourceResponse);
			return true;
		} catch (Exception e) {
			throw new PortletException(e);
		}
	}

}
