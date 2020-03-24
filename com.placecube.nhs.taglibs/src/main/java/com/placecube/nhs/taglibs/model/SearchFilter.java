package com.placecube.nhs.taglibs.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.util.ArrayUtil;

public class SearchFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private final String fieldName;
	private final String searchableFieldName;
	private final String fieldLabel;
	private final Map<String, String> fieldValues;
	private String[] fieldSelectedValues;

	public SearchFilter(String fieldName, String searchableFieldName, String fieldLabel, Map<String, String> fieldValues) {
		this.fieldName = fieldName;
		this.searchableFieldName = searchableFieldName;
		this.fieldLabel = fieldLabel;
		fieldSelectedValues = new String[0];
		this.fieldValues = fieldValues;
	}

	public void addSelectedValue(String fieldValue) {
		if (!ArrayUtil.contains(fieldSelectedValues, fieldValue)) {
			fieldSelectedValues = ArrayUtil.append(fieldSelectedValues, fieldValue);
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

	public void removeSelectedValue(String fieldValue) {
		fieldSelectedValues = ArrayUtil.remove(fieldSelectedValues, fieldValue);
	}

	public void setFieldSelectedValues(String[] fieldSelectedValues) {
		this.fieldSelectedValues = fieldSelectedValues;
	}

}
