package com.placecube.nhs.user.profile.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import javax.portlet.ActionRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.placecube.nhs.user.profile.model.ExtraInfoContext;
import com.placecube.nhs.userprofile.model.Experience;
import com.placecube.nhs.userprofile.service.ExperienceLocalService;

@Component(immediate = true, service = ExtraInfoService.class)
public class ExtraInfoService {

	@Reference
	private ExperienceLocalService experienceLocalService;

	@Reference
	private ValidationService validationService;

	public ExtraInfoContext getExtraInfoFromExperience(Experience experience) {
		ExtraInfoContext extraInfoContext = new ExtraInfoContext();
		if (Validator.isNotNull(experience)) {
			extraInfoContext.setCurrent(experience.isCurrent());
			extraInfoContext.setFromDate(experience.getFromDate());
			extraInfoContext.setToDate(experience.getToDate());
			extraInfoContext.setPlace(experience.getPlaceOfWork());
			extraInfoContext.setRole(experience.getRole());
			extraInfoContext.setId(experience.getExperienceId());
		}
		return extraInfoContext;
	}

	public ExtraInfoContext populateExtraInfoExperienceFromRequest(ActionRequest actionRequest, TimeZone timeZone) {
		ExtraInfoContext extraInfoContext = new ExtraInfoContext();
		extraInfoContext.setId(ParamUtil.getLong(actionRequest, "id"));
		boolean isCurrent = ParamUtil.getBoolean(actionRequest, "current");
		extraInfoContext.setCurrent(isCurrent);
		extraInfoContext.setFromDate(getDateFromRequest(actionRequest, "fromDate", timeZone));
		if (isCurrent) {
			extraInfoContext.setToDate(null);
		} else {
			extraInfoContext.setToDate(getDateFromRequest(actionRequest, "toDate", timeZone));
		}
		extraInfoContext.setPlace(ParamUtil.getString(actionRequest, "placeOfWork"));
		extraInfoContext.setRole(ParamUtil.getString(actionRequest, "role"));
		return extraInfoContext;
	}

	private Date getDateFromRequest(ActionRequest actionRequest, String fieldName, TimeZone timeZone) {
		try {
			int day = ParamUtil.getInteger(actionRequest, fieldName + "_day");
			int month = ParamUtil.getInteger(actionRequest, fieldName + "_month");
			int year = ParamUtil.getInteger(actionRequest, fieldName + "_year");
			LocalDate localDate = LocalDate.of(year, month, day);
			Instant instant = localDate.atStartOfDay().toInstant(ZoneOffset.UTC);
			return Date.from(instant);
		} catch (Exception e) {
			return null;
		}
	}

	public void addExperience(User user, ExtraInfoContext extraInfoContext) {
		experienceLocalService.createExperience(user, extraInfoContext.getPlace(), extraInfoContext.getRole(), extraInfoContext.isCurrent(), extraInfoContext.getFromDate(),
				extraInfoContext.getToDate());
	}

	public void updateExperience(ExtraInfoContext extraInfoContext) throws PortalException {
		experienceLocalService.updateExperience(extraInfoContext.getId(), extraInfoContext.getPlace(), extraInfoContext.getRole(), extraInfoContext.isCurrent(), extraInfoContext.getFromDate(),
				extraInfoContext.getToDate());
	}

	public Map<String, String> getValidationErrorsForExperience(ExtraInfoContext extraInfoContext, Locale locale) {
		Map<String, String> errors = new LinkedHashMap<>();
		validationService.validateMandatoryField(errors, locale, extraInfoContext.getPlace(), "placeOfWork", "enter-your-place-of-work", 100, "enter-a-place-of-work-that-is-100-characters-or-fewer");
		validationService.validateMandatoryField(errors, locale, extraInfoContext.getRole(), "role", "enter-your-role", 100, "enter-a-role-that-is-100-characters-or-fewer");
		validationService.validateMandatoryField(errors, locale, extraInfoContext.getFromDate(), "fromDate", "enter-the-from-date");
		if (!extraInfoContext.isCurrent()) {
			validationService.validateMandatoryField(errors, locale, extraInfoContext.getToDate(), "toDate", "enter-the-to-date");
		}
		validationService.validateDateField(errors, locale, extraInfoContext.getFromDate(), extraInfoContext.getToDate(), "toDate", "enter-a-to-date-after-the-from-date");
		return errors;
	}
}
