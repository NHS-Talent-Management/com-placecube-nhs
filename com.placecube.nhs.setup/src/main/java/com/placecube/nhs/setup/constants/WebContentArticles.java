package com.placecube.nhs.setup.constants;

public enum WebContentArticles {

	FOOTER("FOOTER", "Footer content", "Footer");

	private final String articleId;
	private final String articleTitle;
	private final String folderName;

	private WebContentArticles(String articleId, String articleTitle, String folderName) {
		this.articleId = articleId;
		this.articleTitle = articleTitle;
		this.folderName = folderName;
	}

	public String getArticleId() {
		return articleId;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public String getFolderName() {
		return folderName;
	}

}
