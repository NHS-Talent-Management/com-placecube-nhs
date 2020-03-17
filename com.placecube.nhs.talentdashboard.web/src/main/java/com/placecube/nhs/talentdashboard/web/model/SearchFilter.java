package com.placecube.nhs.talentdashboard.web.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.util.ArrayUtil;
import com.placecube.nhs.readiness.model.ReadinessQuestion;

public class SearchFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private final String fieldName;
	private final String searchableFieldName;
	private final String fieldLabel;
	private final Map<String, String> fieldValues;
	private String[] fieldSelectedValues;

	public SearchFilter(ReadinessQuestion readinessQuestion) {
		fieldName = readinessQuestion.getQuestionName();
		searchableFieldName = readinessQuestion.getQuestionSearchableName();
		fieldLabel = readinessQuestion.getQuestionShortTitle();
		fieldSelectedValues = new String[0];
		fieldValues = new LinkedHashMap<>();
		for (String answer : readinessQuestion.getAvailableAnswers()) {
			fieldValues.put(answer, answer);
		}
	}

	public void addSelectedValue(String fieldValue) {
		fieldSelectedValues = ArrayUtil.append(fieldSelectedValues, fieldValue);
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

	public void removeSelectedValue(String fieldValue) {
		fieldSelectedValues = ArrayUtil.remove(fieldSelectedValues, fieldValue);
	}

	public void setFieldSelectedValues(String[] fieldSelectedValues) {
		this.fieldSelectedValues = fieldSelectedValues;
	}

}
