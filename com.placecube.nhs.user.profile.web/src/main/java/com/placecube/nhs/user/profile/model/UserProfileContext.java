package com.placecube.nhs.user.profile.model;

import java.util.HashMap;
import java.util.Map;

import com.placecube.nhs.user.profile.constants.UserProfileField;

public class UserProfileContext {

	private String currentPosition;
	private String firstName;
	private String lastName;
	private String location;
	private String summary;
	private Map<String, String> errors;

	public UserProfileContext() {
		errors = new HashMap<>();
	}

	public String getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(String currentPosition) {
		this.currentPosition = currentPosition;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

	public String getFieldError(String fieldName) {
		return errors.get(fieldName);
	}

	public boolean isValid() {
		return errors.isEmpty();
	}

	public void addFieldError(UserProfileField userProfileField, String message) {
		errors.put(userProfileField.getFieldName(), message);
	}

	public void addFieldError(String fieldName, String message) {
		errors.put(fieldName, message);
	}
}
