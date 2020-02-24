package com.placecube.nhs.registration.constants;

public enum WebContentArticles {

	REGISTRATION_BOTTOM_TEXT("REGISTRATION-BOTTOM-TEXT", "Registration disclaimer text"),

	REGISTRATION_CONFIRMATION_PAGE("REGISTRATION-CONFIRMATION-PAGE", "Registration confirmation page"),

	REGISTRATION_INTRO_TEXT("REGISTRATION-INTRO-TEXT", "Registration intro text");

	private final String articleId;
	private final String articleTitle;

	private WebContentArticles(String articleId, String articleTitle) {
		this.articleId = articleId;
		this.articleTitle = articleTitle;
	}

	public String getArticleId() {
		return articleId;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

}
