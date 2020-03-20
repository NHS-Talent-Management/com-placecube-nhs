package com.placecube.nhs.communitylisting.portlet.mycommunities.configuration;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MyCommunitiesConfigurationBeanDeclarationTest {

	@Test
	public void getConfigurationBeanClass_ThenReturnsMyCommunitiesConfiguration() {
		MyCommunitiesConfigurationBeanDeclaration myCommunitiesConfigurationBeanDeclaration = new MyCommunitiesConfigurationBeanDeclaration();

		assertThat(myCommunitiesConfigurationBeanDeclaration.getConfigurationBeanClass(), equalTo(MyCommunitiesPortletInstanceConfiguration.class));
	}
}
