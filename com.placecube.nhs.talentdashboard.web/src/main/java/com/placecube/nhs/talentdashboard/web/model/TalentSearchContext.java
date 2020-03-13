package com.placecube.nhs.talentdashboard.web.model;

public class TalentSearchContext {

	private String talentSearchName;
	private long talentSearchTypeId;
	private long talentSearchCategoryId;
	boolean searchExecuted;

	public TalentSearchContext() {
		searchExecuted = false;
	}

	public long getTalentSearchCategoryId() {
		return talentSearchCategoryId;
	}

	public String getTalentSearchName() {
		return talentSearchName;
	}

	public long getTalentSearchTypeId() {
		return talentSearchTypeId;
	}

	public boolean isSearchExecuted() {
		return searchExecuted;
	}

	public void setSearchExecuted(boolean searchExecuted) {
		this.searchExecuted = searchExecuted;
	}

	public void setTalentSearchCategoryId(long talentSearchCategoryId) {
		this.talentSearchCategoryId = talentSearchCategoryId;
	}

	public void setTalentSearchName(String talentSearchName) {
		this.talentSearchName = talentSearchName;
	}

	public void setTalentSearchTypeId(long talentSearchTypeId) {
		this.talentSearchTypeId = talentSearchTypeId;
	}

}
