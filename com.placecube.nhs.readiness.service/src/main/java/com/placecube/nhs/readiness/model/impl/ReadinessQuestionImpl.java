package com.placecube.nhs.readiness.model.impl;

import com.liferay.expando.kernel.model.ExpandoColumn;
import com.placecube.nhs.readiness.model.ReadinessQuestion;

public class ReadinessQuestionImpl implements ReadinessQuestion {

	private final long questionId;
	private final ExpandoColumn expandoColumn;
	private final String questionTitle;
	private final String questionName;
	private final int index;
	private final String[] availableAnswers;
	private final String userAnswer;

	ReadinessQuestionImpl(ExpandoColumn expandoColumn, String questionName, String questionTitle, String[] availableAnswers, int index, String userAnswer) {
		questionId = expandoColumn.getColumnId();
		this.expandoColumn = expandoColumn;
		this.questionName = questionName;
		this.questionTitle = questionTitle;
		this.availableAnswers = availableAnswers;
		this.index = index;
		this.userAnswer = userAnswer;
	}

	@Override
	public String[] getAvailableAnswers() {
		return availableAnswers;
	}

	@Override
	public ExpandoColumn getExpandoColumn() {
		return expandoColumn;
	}

	@Override
	public int getIndex() {
		return index;
	}

	@Override
	public long getQuestionId() {
		return questionId;
	}

	@Override
	public String getQuestionName() {
		return questionName;
	}

	@Override
	public String getQuestionTitle() {
		return questionTitle;
	}

	@Override
	public String getUserAnswer() {
		return userAnswer;
	}

}
