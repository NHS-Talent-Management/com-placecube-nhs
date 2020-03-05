package com.placecube.nhs.user.profile.service;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.Validator;

@Component(immediate = true, service = ValidationService.class)
public class ValidationService {

	public void validateMandatoryField(Map<String, String> errors, Locale locale, String fieldValue, String fieldName, String mandatoryMessageKey, int maxLength, String maxLengthMessageKey) {
		if (Validator.isNull(fieldValue)) {
			errors.put(fieldName, getMessage(locale, mandatoryMessageKey));
		} else if (fieldValue.length() > maxLength) {
			errors.put(fieldName, getMessage(locale, maxLengthMessageKey));
		}
	}

	public void validateOptionalField(Map<String, String> errors, Locale locale, String fieldValue, String fieldName, int maxLength, String maxLengthMessageKey) {
		if (Validator.isNotNull(fieldValue) && fieldValue.length() > maxLength) {
			errors.put(fieldName, getMessage(locale, maxLengthMessageKey));
		}
	}

	private String getMessage(Locale locale, String key) {
		return LanguageUtil.get(locale, key);
	}

	public void validateMandatoryField(Map<String, String> errors, Locale locale, Date date, String fieldName, String mandatoryMessageKey) {
		if (Validator.isNull(date)) {
			errors.put(fieldName, getMessage(locale, mandatoryMessageKey));
		}
	}

	public void validateDateField(Map<String, String> errors, Locale locale, Date fromDate, Date toDate, String fieldName, String messageKey) {
		if (Validator.isNotNull(fromDate) && Validator.isNotNull(toDate) && toDate.before(fromDate)) {
			errors.put(fieldName, getMessage(locale, messageKey));
		}
	}

}
