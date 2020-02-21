package com.placecube.nhs.registration.service;

import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.Validator;
import com.placecube.nhs.registration.constants.RegistrationField;

@Component(immediate = true, service = ValidationService.class)
public class ValidationService {

	public void validateMandatoryField(Map<String, String> errors, Locale locale, RegistrationField registrationField, String fieldValue) {
		if (Validator.isNull(fieldValue)) {
			errors.put(registrationField.getFieldName(), getMessage(locale, registrationField.getMandatoryErrorKey()));
		} else if (fieldValue.length() > registrationField.getMaxLength()) {
			errors.put(registrationField.getFieldName(), getMessage(locale, registrationField.getMaxLengthErrorKey()));
		}
	}

	public void validateEmail(Map<String, String> errors, Locale locale, String email) {
		if (Validator.isNotNull(email) && !Validator.isEmailAddress(email)) {
			errors.put(RegistrationField.EMAIL.getFieldName(), getMessage(locale, "enter-a-valid-email-address"));
		}
	}

	public void validatePasswordMatch(Map<String, String> errors, Locale locale, String password1, String password2) {
		if (Validator.isNotNull(password1) && Validator.isNotNull(password2) && !password1.equals(password2)) {
			errors.put(RegistrationField.PASSWORD_CONFIRM.getFieldName(), getMessage(locale, "password-do-not-match"));
		}
	}

	private String getMessage(Locale locale, String key) {
		return LanguageUtil.get(locale, key);
	}
}
