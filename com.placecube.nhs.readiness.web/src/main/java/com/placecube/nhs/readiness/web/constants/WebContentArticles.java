package com.placecube.nhs.readiness.web.constants;

public enum WebContentArticles {

	CAREER_READINESS("CAREER-READINESS", "Career Readiness"),

	READINESS_QUESTIONNAIRE_COMPLETED("READINESS-QUESTIONNAIRE-COMPLETED", "Questionnaire completed");

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
