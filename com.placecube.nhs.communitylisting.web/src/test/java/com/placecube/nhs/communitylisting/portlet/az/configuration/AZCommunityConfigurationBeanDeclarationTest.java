package com.placecube.nhs.communitylisting.portlet.az.configuration;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class AZCommunityConfigurationBeanDeclarationTest {

	@Test
	public void getConfigurationBeanClass_ThenReturnsAZCommunityConfiguration() {
		AZCommunityConfigurationBeanDeclaration azCommunityConfigurationBeanDeclaration = new AZCommunityConfigurationBeanDeclaration();

		assertThat(azCommunityConfigurationBeanDeclaration.getConfigurationBeanClass(), equalTo(AZCommunityPortletInstanceConfiguration.class));
	}

}
