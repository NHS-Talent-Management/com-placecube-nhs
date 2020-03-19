package com.placecube.nhs.talentdashboard.web.service;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.Validator;
import com.placecube.nhs.talentdashboard.web.model.NudgeNotification;
import com.placecube.nhs.talentdashboard.web.model.TalentSearchContext;

@Component(immediate = true, service = ValidationService.class)
public class ValidationService {

	public Map<String, String> getValidationErrors(TalentSearchContext talentSearchContext, Locale locale) {
		Map<String, String> errors = new LinkedHashMap<>();
		validateMandatoryField(errors, locale, talentSearchContext.getTalentSearchName(), "talentSearchName", "enter-the-talent-search-name", 200,
				"enter-a-talent-search-name-that-is-200-characters-or-fewer");
		return errors;
	}

	private String getMessage(Locale locale, String key) {
		return LanguageUtil.get(locale, key);
	}

	private void validateMandatoryField(Map<String, String> errors, Locale locale, String fieldValue, String fieldName, String mandatoryMessageKey, int maxLength, String maxLengthMessageKey) {
		if (Validator.isNull(fieldValue)) {
			errors.put(fieldName, getMessage(locale, mandatoryMessageKey));
		} else if (fieldValue.length() > maxLength) {
			errors.put(fieldName, getMessage(locale, maxLengthMessageKey));
		}
	}

	public Map<String, String> getValidationErrors(NudgeNotification nudgeNotification, Locale locale) {
		Map<String, String> errors = new LinkedHashMap<>();
		validateMandatoryField(errors, locale, nudgeNotification.getEmailSubject(), "emailSubject", "enter-the-email-subject", 70, "enter-an-email-subject-that-is-70-characters-or-fewer");
		validateMandatoryField(errors, locale, nudgeNotification.getEmailBody(), "emailBody", "enter-the-email-body", 3000, "enter-an-email-body-that-is-3000-characters-or-fewer");
		return errors;
	}
}
