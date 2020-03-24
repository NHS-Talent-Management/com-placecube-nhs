package com.placecube.nhs.talentdashboard.web.constants;

public enum WebContentArticles {

	TALENT_DASHBOARD_FILTERS_TEXT("TALENT-DASHBOARD-FILTERS-TEXT", "Talent Dashboard filters text"),

	TALENT_DASHBOARD_INTRO_TEXT("TALENT-DASHBOARD-INTRO-TEXT", "Talent Dashboard intro text"),

	TALENT_DASHBOARD_NUDGE_TEXT("TALENT-DASHBOARD-NUDGE-TEXT", "Talent Dashboard nudge intro text");

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
