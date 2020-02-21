package com.placecube.nhs.registration.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.captcha.util.CaptchaUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.placecube.nhs.registration.constants.MVCCommandKeys;
import com.placecube.nhs.registration.constants.PortletKeys;
import com.placecube.nhs.registration.model.RegistrationContext;
import com.placecube.nhs.registration.service.RegistrationService;

@Component(immediate = true, property = { "javax.portlet.name=" + PortletKeys.REGISTRATION, "mvc.command.name=" + MVCCommandKeys.REGISTER }, service = MVCActionCommand.class)

public class RegistrationMVCActionCommand extends BaseMVCActionCommand {

	private static final Log LOG = LogFactoryUtil.getLog(RegistrationMVCActionCommand.class);

	@Reference
	private RegistrationService registrationService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		RegistrationContext registrationModel = registrationService.populateFromRequest(actionRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		try {
			CaptchaUtil.check(actionRequest);

			registrationService.validateRegistrationModel(registrationModel, themeDisplay.getLocale());

			if (registrationModel.isValid()) {
				registrationService.createUserAccount(registrationModel);

				actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandKeys.REGISTER);

			} else {
				redirectToInitialPage(actionRequest, actionResponse, registrationModel);
			}

		} catch (Exception e) {
			LOG.debug(e);
			LOG.error("Unable to create user account - " + e.getMessage());

			hideDefaultErrorMessage(actionRequest);
			registrationService.configureExceptionMessage(themeDisplay.getLocale(), e, registrationModel);
			redirectToInitialPage(actionRequest, actionResponse, registrationModel);
		}
	}

	private void redirectToInitialPage(ActionRequest actionRequest, ActionResponse actionResponse, RegistrationContext registrationModel) {
		actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandKeys.VIEW);
		actionRequest.setAttribute("registrationContext", registrationModel);
	}

}
