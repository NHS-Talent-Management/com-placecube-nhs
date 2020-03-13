package com.placecube.nhs.registration.portlet;

import java.util.Optional;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.captcha.util.CaptchaUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.PasswordPolicy;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import com.placecube.nhs.registration.constants.MVCCommandKeys;
import com.placecube.nhs.registration.constants.PortletKeys;
import com.placecube.nhs.registration.service.RegistrationService;

@Component(immediate = true, property = { "javax.portlet.name=" + PortletKeys.REGISTRATION, "mvc.command.name=" + MVCCommandKeys.REGISTER, "mvc.command.name=/" }, service = MVCRenderCommand.class)
public class RegistrationMVCRenderCommand implements MVCRenderCommand {

	private static final Log LOG = LogFactoryUtil.getLog(RegistrationMVCRenderCommand.class);

	@Reference
	private RegistrationService registrationService;

	@Reference
	private Portal portal;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		if (themeDisplay.isSignedIn() && !themeDisplay.getPermissionChecker().isCompanyAdmin(themeDisplay.getCompanyId())) {
			try {
				portal.getHttpServletResponse(renderResponse).sendRedirect(themeDisplay.getURLHome());
			} catch (Exception e) {
				LOG.debug(e);
			}
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
