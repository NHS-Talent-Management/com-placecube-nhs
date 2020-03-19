package com.placecube.nhs.user.settings.constants;

import java.util.Locale;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.User;
import com.placecube.nhs.readiness.model.ReadinessQuestion;
import com.placecube.nhs.userprofile.model.Experience;
import com.placecube.nhs.userprofile.model.ProfessionalBody;
import com.placecube.nhs.userprofile.model.Qualification;

public enum UserPrivacyPage {
	WHO_CAN_SEE_MY_PROFILE("who-can-see-my-profile", User.class.getName()), WHO_CAN_SEE_MY_CAREER_READINESS("who-can-see-my-career-readiness",
			ReadinessQuestion.class.getName()), WHO_CAN_SEE_MY_EXPERIENCE("who-can-see-my-experience", Experience.class.getName()), WHO_CAN_SEE_MY_LEARNING_AND_SKILLS(
					"who-can-see-my-learning-and-skills", Qualification.class.getName()), WHO_CAN_SEE_MY_PROFESSIONAL_BODIES("who-can-see-my-professional-bodies", ProfessionalBody.class.getName());

	private final String fieldName;

	private final String fieldId;

	UserPrivacyPage(String fieldName, String fieldId) {
		this.fieldName = fieldName;
		this.fieldId = fieldId;
	}

	public String getFieldName() {
		return this.fieldName;
	}

	public String getFieldId() {
		return this.fieldId;
	}

	public String getFieldLabel(Locale locale) {
		return LanguageUtil.get(locale, this.fieldName);
	}
}
