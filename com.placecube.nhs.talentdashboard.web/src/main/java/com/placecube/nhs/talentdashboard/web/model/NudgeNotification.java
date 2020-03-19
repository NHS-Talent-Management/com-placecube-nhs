package com.placecube.nhs.talentdashboard.web.model;

public class NudgeNotification {

	private final long totalResults;
	private String emailSubject;
	private String emailBody;

	public NudgeNotification(long totalResults) {
		this.totalResults = totalResults;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public String getEmailBody() {
		return emailBody;
	}

	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}

	public long getTotalResults() {
		return totalResults;
	}

}
