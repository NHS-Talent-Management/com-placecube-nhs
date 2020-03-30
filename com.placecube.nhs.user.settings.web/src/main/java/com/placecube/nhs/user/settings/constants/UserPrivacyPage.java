package com.placecube.nhs.user.settings.constants;

import com.liferay.portal.kernel.model.User;
import com.placecube.nhs.readiness.model.ReadinessQuestion;
import com.placecube.nhs.userprofile.model.Experience;
import com.placecube.nhs.userprofile.model.ProfessionalBody;
import com.placecube.nhs.userprofile.model.Qualification;

public enum UserPrivacyPage {

	PROFILE("who-can-see-my-profile", "who-can-see-my-profile-intro", User.class.getName()),

	CAREER_READINESS("who-can-see-my-career-readiness", "who-can-see-my-career-readiness-intro", ReadinessQuestion.class.getName()),

	EXPERIENCE("who-can-see-my-experience", "who-can-see-my-experience-intro", Experience.class.getName()),

	LEARNING_AND_SKILLS("who-can-see-my-learning-and-skills", "who-can-see-my-learning-and-skills-intro", Qualification.class.getName()),

	PROFESSIONAL_BODIES("who-can-see-my-professional-bodies", "who-can-see-my-professional-bodies-intro", ProfessionalBody.class.getName());

	private final String fieldLabel;
	private final String fieldIntro;
	private final String classNameId;

	private UserPrivacyPage(String fieldLabel, String fieldIntro, String classNameId) {
		this.fieldLabel = fieldLabel;
		this.fieldIntro = fieldIntro;
		this.classNameId = classNameId;
	}

	public String getClassNameId() {
		return classNameId;
	}

	public String getFieldLabel() {
		return fieldLabel;
	}

	public String getFieldIntro() {
		return fieldIntro;
	}

}
