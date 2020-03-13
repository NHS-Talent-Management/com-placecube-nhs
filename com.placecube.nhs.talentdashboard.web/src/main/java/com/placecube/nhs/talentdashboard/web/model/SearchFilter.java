package com.placecube.nhs.talentdashboard.web.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.placecube.nhs.readiness.model.ReadinessQuestion;

public class SearchFilter {

	private final String fieldName;
	private final String searchableFieldName;
	private final String fieldLabel;
	private final Map<String, String> fieldValues;
	private String[] fieldSelectedValues;

	public SearchFilter(ReadinessQuestion readinessQuestion) {
		ExpandoColumn expandoColumn = readinessQuestion.getExpandoColumn();
		fieldName = expandoColumn.getName();
		searchableFieldName = "expando__keyword__custom_fields__" + expandoColumn.getName();
		fieldLabel = readinessQuestion.getQuestionName();
		fieldSelectedValues = new String[0];
		fieldValues = new HashMap<>();
		String[] availableAnswers = readinessQuestion.getAvailableAnswers();
		for (String answer : availableAnswers) {
			fieldValues.put(answer, answer);
		}
	}

	public String getFieldLabel() {
		return fieldLabel;
	}

	public String getFieldName() {
		return fieldName;
	}

	public String[] getFieldSelectedValues() {
		return fieldSelectedValues;
	}

	public List<String> getFieldSelectedValuesList() {
		return Arrays.asList(fieldSelectedValues);
	}

	public Map<String, String> getFieldValues() {
		return fieldValues;
	}

	public String getSearchableFieldName() {
		return searchableFieldName;
	}

	public boolean isActive() {
		return ArrayUtil.isNotEmpty(fieldSelectedValues);
	}

	public void setFieldSelectedValues(String[] fieldSelectedValues) {
		this.fieldSelectedValues = fieldSelectedValues;
	}

}
