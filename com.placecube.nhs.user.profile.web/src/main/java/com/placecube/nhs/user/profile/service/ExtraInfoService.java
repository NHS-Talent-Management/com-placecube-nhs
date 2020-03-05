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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.placecube.nhs.user.profile.model.ExtraInfoContext;
import com.placecube.nhs.userprofile.model.Experience;
import com.placecube.nhs.userprofile.model.ProfessionalBody;
import com.placecube.nhs.userprofile.model.Qualification;
import com.placecube.nhs.userprofile.service.ExperienceLocalService;
import com.placecube.nhs.userprofile.service.ProfessionalBodyLocalService;
import com.placecube.nhs.userprofile.service.QualificationLocalService;

@Component(immediate = true, service = ExtraInfoService.class)
public class ExtraInfoService {

	private static final Log LOG = LogFactoryUtil.getLog(ExtraInfoService.class);

	@Reference
	private ExperienceLocalService experienceLocalService;

	@Reference
	private ProfessionalBodyLocalService professionalBodyLocalService;

	@Reference
	private QualificationLocalService qualificationLocalService;

	@Reference
	private ValidationService validationService;

	public void addExperience(User user, ExtraInfoContext extraInfoContext) {
		experienceLocalService.createExperience(user, extraInfoContext.getPlace(), extraInfoContext.getRole(), extraInfoContext.isCurrent(), extraInfoContext.getFromDate(),
				extraInfoContext.getToDate());
	}

	public void addProfessionalBody(User user, ExtraInfoContext extraInfoContext) {
		professionalBodyLocalService.createProfessionalBody(user, extraInfoContext.getRole(), extraInfoContext.getPlace(), extraInfoContext.getToDate());
	}

	public void addQualification(User user, ExtraInfoContext extraInfoContext) {
		qualificationLocalService.createQualification(user, extraInfoContext.getPlace(), extraInfoContext.getRole(), extraInfoContext.getFromDate(), extraInfoContext.getToDate());
	}

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

	public ExtraInfoContext getExtraInfoFromProfessionalBody(ProfessionalBody professionalBody) {
		ExtraInfoContext extraInfoContext = new ExtraInfoContext();
		if (Validator.isNotNull(professionalBody)) {
			extraInfoContext.setToDate(professionalBody.getExpiryDate());
			extraInfoContext.setPlace(professionalBody.getLocation());
			extraInfoContext.setRole(professionalBody.getTitle());
			extraInfoContext.setId(professionalBody.getProfessionalBodyId());
		}
		return extraInfoContext;
	}

	public ExtraInfoContext getExtraInfoFromQualification(Qualification qualification) {
		ExtraInfoContext extraInfoContext = new ExtraInfoContext();
		if (Validator.isNotNull(qualification)) {
			extraInfoContext.setFromDate(qualification.getFromDate());
			extraInfoContext.setToDate(qualification.getToDate());
			extraInfoContext.setPlace(qualification.getPlace());
			extraInfoContext.setRole(qualification.getQualification());
			extraInfoContext.setId(qualification.getQualificationId());
		}
		return extraInfoContext;
	}

	public Map<String, String> getValidationErrorsForExperience(ExtraInfoContext extraInfoContext, Locale locale) {
		Map<String, String> errors = new LinkedHashMap<>();
		validationService.validateMandatoryField(errors, locale, extraInfoContext.getPlace(), "place", "enter-your-place-of-work", 100, "enter-a-place-of-work-that-is-100-characters-or-fewer");
		validationService.validateMandatoryField(errors, locale, extraInfoContext.getRole(), "role", "enter-your-role", 100, "enter-a-role-that-is-100-characters-or-fewer");
		validationService.validateMandatoryField(errors, locale, extraInfoContext.getFromDate(), "fromDate", "enter-the-from-date");
		if (!extraInfoContext.isCurrent()) {
			validationService.validateMandatoryField(errors, locale, extraInfoContext.getToDate(), "toDate", "enter-the-to-date");
		}
		validationService.validateDateField(errors, locale, extraInfoContext.getFromDate(), extraInfoContext.getToDate(), "toDate", "enter-a-to-date-after-the-from-date");
		return errors;
	}

	public Map<String, String> getValidationErrorsForProfessionalBody(ExtraInfoContext extraInfoContext, Locale locale) {
		Map<String, String> errors = new LinkedHashMap<>();
		validationService.validateMandatoryField(errors, locale, extraInfoContext.getPlace(), "location", "enter-the-location", 100, "enter-a-location-that-is-100-characters-or-fewer");
		validationService.validateMandatoryField(errors, locale, extraInfoContext.getRole(), "title", "enter-the-professional-body-name", 100,
				"enter-a-professional-body-name-that-is-100-characters-or-fewer");
		validationService.validateMandatoryField(errors, locale, extraInfoContext.getToDate(), "toDate", "enter-the-expiry-date");
		return errors;
	}

	public Map<String, String> getValidationErrorsForQualification(ExtraInfoContext extraInfoContext, Locale locale) {
		Map<String, String> errors = new LinkedHashMap<>();
		validationService.validateMandatoryField(errors, locale, extraInfoContext.getPlace(), "place", "enter-the-institution-university", 100,
				"enter-an-institution-university-that-is-100-characters-or-fewer");
		validationService.validateMandatoryField(errors, locale, extraInfoContext.getRole(), "role", "enter-your-qualification", 100, "enter-a-qualification-that-is-100-characters-or-fewer");
		validationService.validateMandatoryField(errors, locale, extraInfoContext.getFromDate(), "fromDate", "enter-the-from-date");
		validationService.validateMandatoryField(errors, locale, extraInfoContext.getToDate(), "toDate", "enter-the-to-date");
		validationService.validateDateField(errors, locale, extraInfoContext.getFromDate(), extraInfoContext.getToDate(), "toDate", "enter-a-to-date-after-the-from-date");
		return errors;
	}

	public ExtraInfoContext populateExtraInfoFromRequest(ActionRequest actionRequest, TimeZone timeZone) {
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
		extraInfoContext.setPlace(ParamUtil.getString(actionRequest, "place"));
		extraInfoContext.setRole(ParamUtil.getString(actionRequest, "role"));
		return extraInfoContext;
	}

	public void updateExperience(ExtraInfoContext extraInfoContext) throws PortalException {
		experienceLocalService.updateExperience(extraInfoContext.getId(), extraInfoContext.getPlace(), extraInfoContext.getRole(), extraInfoContext.isCurrent(), extraInfoContext.getFromDate(),
				extraInfoContext.getToDate());
	}

	public void updateProfessionalBody(ExtraInfoContext extraInfoContext) {
		// TODO Auto-generated method stub

	}

	public void updateQualification(ExtraInfoContext extraInfoContext) throws PortalException {
		Qualification qualification = qualificationLocalService.getQualification(extraInfoContext.getId());
		qualification.setPlace(extraInfoContext.getPlace());
		qualification.setQualification(extraInfoContext.getRole());
		qualification.setFromDate(extraInfoContext.getFromDate());
		qualification.setToDate(extraInfoContext.getToDate());
		qualificationLocalService.updateQualification(qualification);
	}

	private Date getDateFromRequest(ActionRequest actionRequest, String fieldName, TimeZone timeZone) {
		try {
			int day = ParamUtil.getInteger(actionRequest, fieldName + "_day");
			int month = ParamUtil.getInteger(actionRequest, fieldName + "_month");
			int year = ParamUtil.getInteger(actionRequest, fieldName + "_year");
			if (day > 0 && month > 0 && year > 0) {
				LocalDate localDate = LocalDate.of(year, month, day);
				Instant instant = localDate.atStartOfDay().toInstant(ZoneOffset.UTC);
				return Date.from(instant);
			}
		} catch (Exception e) {
			LOG.debug(e);
		}
		return null;
	}
}
