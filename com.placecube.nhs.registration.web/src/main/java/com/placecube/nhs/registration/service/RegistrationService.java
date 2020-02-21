package com.placecube.nhs.registration.service;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.captcha.CaptchaConfigurationException;
import com.liferay.portal.kernel.captcha.CaptchaException;
import com.liferay.portal.kernel.captcha.CaptchaTextException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.UserEmailAddressException;
import com.liferay.portal.kernel.exception.UserPasswordException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.PasswordPolicy;
import com.liferay.portal.kernel.service.PasswordPolicyLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.placecube.nhs.registration.constants.RegistrationField;
import com.placecube.nhs.registration.model.RegistrationContext;

@Component(immediate = true, service = RegistrationService.class)
public class RegistrationService {

	private static final Log LOG = LogFactoryUtil.getLog(RegistrationService.class);

	@Reference
	private PasswordPolicyLocalService passwordPolicyLocalService;

	@Reference
	private Portal portal;

	@Reference
	private ValidationService validationService;

	@Reference
	private UserLocalService userLocalService;

	public void checkAccountCreationEnabled(PortletRequest portletRequest) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		if (!themeDisplay.getCompany().isStrangers()) {
			throw new PortletException();
		}
	}

	public void createUserAccount(RegistrationContext registrationModel) throws PortalException {
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		userLocalService.addUserWithWorkflow(0, serviceContext.getCompanyId(), false, registrationModel.getPassword(), registrationModel.getConfirmPassword(), true, null,
				registrationModel.getEmailAddress(), 0, null, serviceContext.getLocale(), registrationModel.getFirstName(), null, registrationModel.getLastName(), 0, 0, true, 1, 1, 1960, null,
				new long[0], new long[0], new long[0], new long[0], true, serviceContext);
	}

	public Optional<PasswordPolicy> getDefaultPasswordPolicy(PortletRequest portletRequest) {
		try {
			return Optional.of(passwordPolicyLocalService.getDefaultPasswordPolicy(portal.getCompanyId(portletRequest)));
		} catch (Exception e) {
			LOG.warn("Exception retrieving password policy - " + e.getMessage());
			LOG.debug(e);
			return Optional.empty();
		}
	}

	public void validateRegistrationModel(RegistrationContext registrationModel, Locale locale) {
		Map<String, String> errors = new HashMap<>();
		validationService.validateMandatoryField(errors, locale, RegistrationField.FIRSTNAME, registrationModel.getFirstName());
		validationService.validateMandatoryField(errors, locale, RegistrationField.LASTNAME, registrationModel.getLastName());
		validationService.validateMandatoryField(errors, locale, RegistrationField.EMAIL, registrationModel.getEmailAddress());
		validationService.validateEmail(errors, locale, registrationModel.getEmailAddress());
		validationService.validateMandatoryField(errors, locale, RegistrationField.PASSWORD, registrationModel.getPassword());
		validationService.validateMandatoryField(errors, locale, RegistrationField.PASSWORD_CONFIRM, registrationModel.getConfirmPassword());
		validationService.validatePasswordMatch(errors, locale, registrationModel.getPassword(), registrationModel.getConfirmPassword());
		registrationModel.setErrors(errors);
	}

	public RegistrationContext getRegistrationContext(PortletRequest portletRequest) {
		RegistrationContext result = (RegistrationContext) portletRequest.getAttribute("registrationContext");
		return Validator.isNotNull(result) ? result : new RegistrationContext();
	}

	public RegistrationContext populateFromRequest(PortletRequest portletRequest) {
		RegistrationContext registrationModel = new RegistrationContext();
		registrationModel.setFirstName(ParamUtil.getString(portletRequest, "firstName"));
		registrationModel.setLastName(ParamUtil.getString(portletRequest, "lastName"));
		registrationModel.setEmailAddress(ParamUtil.getString(portletRequest, "emailAddress"));
		registrationModel.setPassword(ParamUtil.getString(portletRequest, "password"));
		registrationModel.setConfirmPassword(ParamUtil.getString(portletRequest, "confirmPassword"));
		return registrationModel;
	}

	public void configureExceptionMessage(Locale locale, Exception exception, RegistrationContext registrationModel) {
		// TODO Auto-generated method stub

		String errorMessage;

		if (exception instanceof UserPasswordException.MustBeLonger) {
			UserPasswordException.MustBeLonger upe = (UserPasswordException.MustBeLonger) exception;
			registrationModel.addFieldError(RegistrationField.PASSWORD, LanguageUtil.format(locale, "that-password-is-too-short", String.valueOf(upe.minLength)));

		} else if (exception instanceof UserPasswordException.MustComplyWithModelListeners) {
			registrationModel.addFieldError(RegistrationField.PASSWORD, LanguageUtil.get(locale, "that-password-is-invalid-please-enter-a-different-password"));

		} else if (exception instanceof UserPasswordException.MustComplyWithRegex) {
			UserPasswordException.MustComplyWithRegex upe = (UserPasswordException.MustComplyWithRegex) exception;
			registrationModel.addFieldError(RegistrationField.PASSWORD, LanguageUtil.format(locale, "that-password-does-not-comply-with-the-regular-expression", String.valueOf(upe.regex)));

		} else if (exception instanceof UserPasswordException.MustMatch) {
			registrationModel.addFieldError(RegistrationField.PASSWORD, LanguageUtil.get(locale, "the-passwords-you-entered-do-not-match"));

		} else if (exception instanceof UserPasswordException.MustNotBeNull) {
			registrationModel.addFieldError(RegistrationField.PASSWORD, LanguageUtil.get(locale, "the-password-cannot-be-blank"));

		} else if (exception instanceof UserPasswordException.MustNotBeTrivial) {
			registrationModel.addFieldError(RegistrationField.PASSWORD,
					LanguageUtil.get(locale, "that-password-uses-common-words-please-enter-a-password-that-is-harder-to-guess-i-e-contains-a-mix-of-numbers-and-letters"));

		} else if (exception instanceof UserPasswordException.MustNotContainDictionaryWords) {
			registrationModel.addFieldError(RegistrationField.PASSWORD, LanguageUtil.get(locale, "that-password-uses-common-dictionary-words"));

		} else if (exception instanceof CaptchaConfigurationException) {
			registrationModel.addFieldError("captchaField", LanguageUtil.get(locale, "a-captcha-error-occurred-please-contact-an-administrator"));

		} else if (exception instanceof CaptchaException) {
			registrationModel.addFieldError("captchaField", LanguageUtil.get(locale, "captcha-verification-failed"));

		} else if (exception instanceof CaptchaTextException) {
			registrationModel.addFieldError("captchaField", LanguageUtil.get(locale, "text-verification-failed"));

		} else if (exception instanceof UserEmailAddressException.MustNotBeDuplicate) {
			registrationModel.addFieldError(RegistrationField.EMAIL, LanguageUtil.get(locale, "the-email-address-you-requested-is-already-taken"));

		} else {
			registrationModel.addFieldError("generic", LanguageUtil.get(locale, "sorry-something-went-wrong"));
		}

	}
}
