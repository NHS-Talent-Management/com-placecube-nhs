package com.placecube.nhs.registration.service;

import java.util.Locale;
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

	public void createUserAccount(RegistrationContext registrationContext) throws PortalException {
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		userLocalService.addUserWithWorkflow(0, serviceContext.getCompanyId(), false, registrationContext.getPassword(), registrationContext.getConfirmPassword(), true, null,
				registrationContext.getEmailAddress(), 0, null, serviceContext.getLocale(), registrationContext.getFirstName(), null, registrationContext.getLastName(), 0, 0, true, 1, 1, 1960, null,
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

	public void validateRegistrationModel(RegistrationContext registrationContext, Locale locale) {
		validationService.validateMandatoryField(registrationContext, locale, RegistrationField.FIRSTNAME, registrationContext.getFirstName());
		validationService.validateMandatoryField(registrationContext, locale, RegistrationField.LASTNAME, registrationContext.getLastName());
		validationService.validateMandatoryField(registrationContext, locale, RegistrationField.EMAIL, registrationContext.getEmailAddress());
		validationService.validateEmail(registrationContext, locale);
		validationService.validateMandatoryField(registrationContext, locale, RegistrationField.PASSWORD, registrationContext.getPassword());
		validationService.validateMandatoryField(registrationContext, locale, RegistrationField.PASSWORD_CONFIRM, registrationContext.getConfirmPassword());
		validationService.validatePasswordMatch(registrationContext, locale);
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

		if (exception instanceof UserPasswordException.MustBeLonger) {
			UserPasswordException.MustBeLonger upe = (UserPasswordException.MustBeLonger) exception;
			registrationModel.addFieldError(RegistrationField.PASSWORD, LanguageUtil.format(locale, "that-password-is-too-short", String.valueOf(upe.minLength)));

		} else if (exception instanceof UserPasswordException.MustComplyWithModelListeners) {
			registrationModel.addFieldError(RegistrationField.PASSWORD, LanguageUtil.get(locale, "that-password-is-invalid-please-enter-a-different-password"));

		} else if (exception instanceof UserPasswordException.MustComplyWithRegex) {
			UserPasswordException.MustComplyWithRegex upe = (UserPasswordException.MustComplyWithRegex) exception;
			registrationModel.addFieldError(RegistrationField.PASSWORD, LanguageUtil.format(locale, "that-password-does-not-comply-with-the-regular-expression", String.valueOf(upe.regex)));

		} else if (exception instanceof UserPasswordException.MustHaveMoreAlphanumeric) {
			UserPasswordException.MustHaveMoreAlphanumeric upe = (UserPasswordException.MustHaveMoreAlphanumeric) exception;
			registrationModel.addFieldError(RegistrationField.PASSWORD,
					LanguageUtil.format(locale, "that-password-must-contain-at-least-x-alphanumeric-characters", String.valueOf(upe.minAlphanumeric)));

		} else if (exception instanceof UserPasswordException.MustHaveMoreLowercase) {
			UserPasswordException.MustHaveMoreLowercase upe = (UserPasswordException.MustHaveMoreLowercase) exception;
			registrationModel.addFieldError(RegistrationField.PASSWORD, LanguageUtil.format(locale, "that-password-must-contain-at-least-x-lowercase-characters", String.valueOf(upe.minLowercase)));

		} else if (exception instanceof UserPasswordException.MustHaveMoreNumbers) {
			UserPasswordException.MustHaveMoreNumbers upe = (UserPasswordException.MustHaveMoreNumbers) exception;
			registrationModel.addFieldError(RegistrationField.PASSWORD, LanguageUtil.format(locale, "that-password-must-contain-at-least-x-numbers", String.valueOf(upe.minNumbers)));

		} else if (exception instanceof UserPasswordException.MustHaveMoreSymbols) {
			UserPasswordException.MustHaveMoreSymbols upe = (UserPasswordException.MustHaveMoreSymbols) exception;
			registrationModel.addFieldError(RegistrationField.PASSWORD, LanguageUtil.format(locale, "that-password-must-contain-at-least-x-symbols", String.valueOf(upe.minSymbols)));

		} else if (exception instanceof UserPasswordException.MustHaveMoreUppercase) {
			UserPasswordException.MustHaveMoreUppercase upe = (UserPasswordException.MustHaveMoreUppercase) exception;
			registrationModel.addFieldError(RegistrationField.PASSWORD, LanguageUtil.format(locale, "that-password-must-contain-at-least-x-uppercase-characters", String.valueOf(upe.minUppercase)));

		} else if (exception instanceof UserPasswordException.MustNotBeEqualToCurrent) {
			registrationModel.addFieldError(RegistrationField.PASSWORD, LanguageUtil.get(locale, "your-new-password-cannot-be-the-same-as-your-old-password-please-enter-a-different-password"));

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
