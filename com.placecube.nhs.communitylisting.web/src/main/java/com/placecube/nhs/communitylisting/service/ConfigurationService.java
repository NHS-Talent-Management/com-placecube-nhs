package com.placecube.nhs.communitylisting.service;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.Validator;
import com.placecube.nhs.communitylisting.portlet.az.configuration.AZCommunityPortletInstanceConfiguration;
import com.placecube.nhs.communitylisting.portlet.mostpopular.configuration.MostPopularCommunityPortletInstanceConfiguration;

@Component(immediate = true, service = ConfigurationService.class)
public class ConfigurationService {

	public AZCommunityPortletInstanceConfiguration getAZConfiguration(ThemeDisplay themeDisplay, boolean skipValidation) throws ConfigurationException {
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		AZCommunityPortletInstanceConfiguration configuration = portletDisplay.getPortletInstanceConfiguration(AZCommunityPortletInstanceConfiguration.class);
		if (skipValidation || hasValidGroupTypes(configuration.groupTypes())) {
			return configuration;
		}
		throw new ConfigurationException("Invalid AZ configuration");
	}

	public MostPopularCommunityPortletInstanceConfiguration getMostPopularConfiguration(ThemeDisplay themeDisplay, boolean skipValidation) throws ConfigurationException {
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		MostPopularCommunityPortletInstanceConfiguration configuration = portletDisplay.getPortletInstanceConfiguration(MostPopularCommunityPortletInstanceConfiguration.class);
		if (skipValidation || configuration.maxItemsToDisplay() > 0 && Validator.isNotNull(configuration.groupType())) {
			return configuration;
		}
		throw new ConfigurationException("Invalid Most popular configuration");
	}

	private boolean hasValidGroupTypes(String[] groupTypes) {
		return ArrayUtil.isNotEmpty(groupTypes) && Validator.isNotNull(groupTypes[0]) && !"false".equalsIgnoreCase(groupTypes[0]);
	}
}
