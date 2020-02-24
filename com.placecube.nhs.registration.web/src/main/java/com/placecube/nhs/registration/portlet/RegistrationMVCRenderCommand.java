package com.placecube.nhs.registration.portlet;

import java.util.Optional;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.captcha.util.CaptchaUtil;
import com.liferay.portal.kernel.model.PasswordPolicy;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.placecube.nhs.registration.constants.MVCCommandKeys;
import com.placecube.nhs.registration.constants.PortletKeys;
import com.placecube.nhs.registration.service.RegistrationService;

@Component(immediate = true, property = { "javax.portlet.name=" + PortletKeys.REGISTRATION, "mvc.command.name=" + MVCCommandKeys.REGISTER, "mvc.command.name=/" }, service = MVCRenderCommand.class)
public class RegistrationMVCRenderCommand implements MVCRenderCommand {

	@Reference
	private RegistrationService registrationService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		if (themeDisplay.isSignedIn() && !themeDisplay.getPermissionChecker().isCompanyAdmin(themeDisplay.getCompanyId())) {
			return "/logged-in-view.jsp";
		}

		Optional<PasswordPolicy> defaultPasswordPolicy = registrationService.getDefaultPasswordPolicy(renderRequest);
		if (defaultPasswordPolicy.isPresent()) {
			renderRequest.setAttribute("passwordPolicyDescription", defaultPasswordPolicy.get().getDescription());
		}
		renderRequest.setAttribute("registrationContext", registrationService.getRegistrationContext(renderRequest));
		renderRequest.setAttribute("captchaEnabled", CaptchaUtil.isEnabled(renderRequest));
		return "/view.jsp";
	}

}
