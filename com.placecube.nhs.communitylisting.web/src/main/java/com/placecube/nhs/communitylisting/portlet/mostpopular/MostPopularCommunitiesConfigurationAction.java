package com.placecube.nhs.communitylisting.portlet.mostpopular;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.placecube.nhs.communitylisting.constants.PortletKeys;
import com.placecube.nhs.communitylisting.service.CommunityListingService;
import com.placecube.nhs.communitylisting.service.ConfigurationService;
import com.placecube.nhs.grouptypes.constants.GroupType;

@Component(immediate = true, property = "javax.portlet.name=" + PortletKeys.MOST_POPULAR, service = ConfigurationAction.class)
public class MostPopularCommunitiesConfigurationAction extends DefaultConfigurationAction {

	@Reference
	private ConfigurationService configurationService;

	@Reference
	private CommunityListingService communityListingService;

	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY);

		httpServletRequest.setAttribute("availableGroupTypes", GroupType.values());
		httpServletRequest.setAttribute("configuration", configurationService.getMostPopularConfiguration(themeDisplay, true));

		super.include(portletConfig, httpServletRequest, httpServletResponse);
	}

	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		setPreference(actionRequest, "groupType", ParamUtil.getString(actionRequest, "groupType"));
		setPreference(actionRequest, "compactDisplay", String.valueOf(ParamUtil.getBoolean(actionRequest, "compactDisplay")));
		setPreference(actionRequest, "maxItemsToDisplay", String.valueOf(ParamUtil.getInteger(actionRequest, "maxItemsToDisplay")));

		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	@Override
	public String getJspPath(HttpServletRequest httpServletRequest) {
		return "/most-popular/configuration.jsp";
	}

	@Override
	@Reference(target = "(osgi.web.symbolicname=com.placecube.nhs.communitylisting.web)", unbind = "-")
	public void setServletContext(ServletContext servletContext) {
		super.setServletContext(servletContext);
	}

}
