package com.placecube.nhs.readiness.model.impl;

import java.util.Locale;

import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.placecube.nhs.readiness.model.ReadinessQuestion;

public class ReadinessQuestionImpl implements ReadinessQuestion {

	private final long questionId;
	private final String questionSearchableName;
	private final String questionShortTitle;
	private final String questionTitle;
	private final String questionName;
	private final int index;
	private final String[] availableAnswers;
	private final String userAnswer;

	private ReadinessQuestionImpl(long questionId, String questionName, String questionSearchableName, String[] availableAnswers, String questionShortTitle, String questionTitle, int index,
			String userAnswer) {
		this.questionId = questionId;
		this.questionName = questionName;
		this.questionSearchableName = questionSearchableName;
		this.availableAnswers = availableAnswers;
		this.questionShortTitle = questionShortTitle;
		this.questionTitle = questionTitle;
		this.index = index;
		this.userAnswer = userAnswer;
	}

	public static ReadinessQuestionImpl init(ExpandoColumn expandoColumn, Locale locale, String questionTitle, int index, String userAnswer) {
		String[] availableAnswers = expandoColumn.getDefaultData().split(StringPool.COMMA);
		String expandoColumnName = expandoColumn.getName();
		String questionShortTitle = LanguageUtil.get(locale, expandoColumnName);
		return new ReadinessQuestionImpl(expandoColumn.getColumnId(), expandoColumnName, "expando__keyword__custom_fields__" + expandoColumnName, availableAnswers, questionShortTitle, questionTitle,
				index, userAnswer);
	}

	@Override
	public String[] getAvailableAnswers() {
		return availableAnswers;
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

	@Override
	public String getQuestionSearchableName() {
		return questionSearchableName;
	}

	@Override
	public String getQuestionShortTitle() {
		return questionShortTitle;
	}

}
