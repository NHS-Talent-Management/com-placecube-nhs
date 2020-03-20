package com.placecube.nhs.communitylisting.portlet.mostpopular.configuration;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MostPopularCommunityConfigurationBeanDeclarationTest {

	@Test
	public void getConfigurationBeanClass_ThenReturnsMostPopularCommunityConfiguration() {
		MostPopularCommunityConfigurationBeanDeclaration mostPopularCommunityConfigurationBeanDeclaration = new MostPopularCommunityConfigurationBeanDeclaration();

		assertThat(mostPopularCommunityConfigurationBeanDeclaration.getConfigurationBeanClass(), equalTo(MostPopularCommunityPortletInstanceConfiguration.class));
	}
}
