package com.placecube.nhs.user.profile.constants;

public enum WebContentArticles {

	PROFILE_DETAILS("PROFILE-DETAILS", "Profile details"),

	EXPERIENCE("EXPERIENCE", "Experience"),

	QUALIFICATION("QUALIFICATION", "Qualification"),

	PROFESSIONAL_BODY("PROFESSIONAL-BODY", "Professional Body");

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
