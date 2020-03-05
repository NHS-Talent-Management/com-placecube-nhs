package com.placecube.nhs.registration.service;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.Validator;
import com.placecube.nhs.registration.constants.RegistrationField;
import com.placecube.nhs.registration.model.RegistrationContext;

@Component(immediate = true, service = ValidationService.class)
public class ValidationService {

	public void validateMandatoryField(RegistrationContext registrationContext, Locale locale, RegistrationField registrationField, String fieldValue) {
		if (Validator.isNull(fieldValue)) {
			registrationContext.addFieldError(registrationField, getMessage(locale, registrationField.getMandatoryErrorKey()));
		} else if (fieldValue.length() > registrationField.getMaxLength()) {
			registrationContext.addFieldError(registrationField, getMessage(locale, registrationField.getMaxLengthErrorKey()));
		}
	}

	public void validateEmail(RegistrationContext registrationContext, Locale locale) {
		String email = registrationContext.getEmailAddress();
		if (Validator.isNotNull(email) && !Validator.isEmailAddress(email)) {
			registrationContext.addFieldError(RegistrationField.EMAIL.getFieldName(), getMessage(locale, "enter-a-valid-email-address"));
		}
	}

	public void validatePasswordMatch(RegistrationContext registrationContext, Locale locale) {
		String password1 = registrationContext.getPassword();
		String password2 = registrationContext.getConfirmPassword();
		if (Validator.isNotNull(password1) && Validator.isNotNull(password2) && !password1.equals(password2)) {
			registrationContext.addFieldError(RegistrationField.PASSWORD_CONFIRM.getFieldName(), getMessage(locale, "password-do-not-match"));
		}
	}

	private String getMessage(Locale locale, String key) {
		return LanguageUtil.get(locale, key);
	}
}
