package com.placecube.nhs.user.profile.service;

import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.Validator;
import com.placecube.nhs.user.profile.constants.UserProfileField;

@Component(immediate = true, service = ValidationService.class)
public class ValidationService {

	public void validateMandatoryField(Map<String, String> errors, Locale locale, UserProfileField userProfileField, String fieldValue) {
		if (Validator.isNull(fieldValue)) {
			errors.put(userProfileField.getFieldName(), getMessage(locale, userProfileField.getMandatoryErrorKey()));
		} else if (fieldValue.length() > userProfileField.getMaxLength()) {
			errors.put(userProfileField.getFieldName(), getMessage(locale, userProfileField.getMaxLengthErrorKey()));
		}
	}

	public void validateOptionalField(Map<String, String> errors, Locale locale, UserProfileField userProfileField, String fieldValue) {
		if (Validator.isNotNull(fieldValue) && fieldValue.length() > userProfileField.getMaxLength()) {
			errors.put(userProfileField.getFieldName(), getMessage(locale, userProfileField.getMaxLengthErrorKey()));
		}
	}

	private String getMessage(Locale locale, String key) {
		return LanguageUtil.get(locale, key);
	}
}
