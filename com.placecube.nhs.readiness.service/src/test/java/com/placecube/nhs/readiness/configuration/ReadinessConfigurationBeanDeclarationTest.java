package com.placecube.nhs.readiness.configuration;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

public class ReadinessConfigurationBeanDeclarationTest extends PowerMockito {

	private ReadinessConfigurationBeanDeclaration readinessConfigurationBeanDeclaration = new ReadinessConfigurationBeanDeclaration();

	@Test
	public void getConfigurationBeanClass_WhenNoError_ThenReturnsTheReadinessInstanceConfiguration() {
		Class<?> result = readinessConfigurationBeanDeclaration.getConfigurationBeanClass();

		assertThat(result, equalTo(ReadinessInstanceConfiguration.class));
	}

}
