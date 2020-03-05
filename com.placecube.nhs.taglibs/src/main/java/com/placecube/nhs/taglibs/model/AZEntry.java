package com.placecube.nhs.taglibs.model;

public class AZEntry {

	private final String title;
	private final String url;

	private AZEntry(String title, String url) {
		this.title = title;
		this.url = url;
	}

	public static AZEntry init(String title, String url) {
		return new AZEntry(title, url);
	}

	public String getTitle() {
		return title;
	}

	public String getUrl() {
		return url;
	}

	public String getInitial() {
		return title.substring(0, 1);
	}

}
