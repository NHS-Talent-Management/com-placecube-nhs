package com.placecube.nhs.readiness.constants;

public enum WebContentArticles {

	READINESS_QUESTIONNAIRE_INTRO("READINESS-QUESTIONNAIRE-INTRO", "Readiness Questionnaire intro"),

	READINESS_QUESTIONNAIRE_COMPLETED("READINESS-QUESTIONNAIRE-COMPLETED", "Readiness Questionnaire completed");

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
