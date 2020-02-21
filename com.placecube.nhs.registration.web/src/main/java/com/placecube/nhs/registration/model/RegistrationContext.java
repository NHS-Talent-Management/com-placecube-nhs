package com.placecube.nhs.registration.model;

import java.util.HashMap;
import java.util.Map;

import com.placecube.nhs.registration.constants.RegistrationField;

public class RegistrationContext {

	private String firstName;
	private String lastName;
	private String emailAddress;
	private String password;
	private String confirmPassword;
	private Map<String, String> errors;

	public RegistrationContext() {
		errors = new HashMap<>();
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public String getFieldError(String fieldName) {
		return errors.get(fieldName);
	}

	public boolean isValid() {
		return errors.isEmpty();
	}

	public void addFieldError(RegistrationField registrationField, String message) {
		errors.put(registrationField.getFieldName(), message);
	}

	public void addFieldError(String fieldName, String message) {
		errors.put(fieldName, message);
	}
}
