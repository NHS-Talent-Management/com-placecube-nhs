package com.placecube.nhs.readiness.model;

import com.liferay.expando.kernel.model.ExpandoColumn;

public interface ReadinessQuestion {

	String[] getAvailableAnswers();

	ExpandoColumn getExpandoColumn();

	int getIndex();

	long getQuestionId();

	String getQuestionName();

	String getQuestionTitle();

	String getUserAnswer();

}
