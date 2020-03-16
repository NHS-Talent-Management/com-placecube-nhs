package com.placecube.nhs.talentdashboard.web.model;

import java.io.Serializable;

public class TalentSearchContext implements Serializable {

	private static final long serialVersionUID = 1L;

	private String talentSearchName;
	private long talentSearchTypeId;
	private long talentSearchCategoryId;

	public TalentSearchContext() {
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
