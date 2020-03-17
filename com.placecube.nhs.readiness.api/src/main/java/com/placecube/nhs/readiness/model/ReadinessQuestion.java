package com.placecube.nhs.readiness.model;

public interface ReadinessQuestion {

	String[] getAvailableAnswers();

	int getIndex();

	long getQuestionId();

	String getQuestionName();

	String getQuestionSearchableName();

	String getQuestionShortTitle();

	String getQuestionTitle();

	String getUserAnswer();

}
