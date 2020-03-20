package com.placecube.nhs.taglibs.model;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class AZEntryTest {

	@Test
	public void init_ThenReturnsEntryWithTitleConfigured() {
		AZEntry result = AZEntry.init("titleValue", "urlValue");

		assertThat(result.getTitle(), equalTo("titleValue"));
	}

	@Test
	public void init_ThenReturnsEntryWithURLConfigured() {
		AZEntry result = AZEntry.init("titleValue", "urlValue");

		assertThat(result.getUrl(), equalTo("urlValue"));
	}

}
