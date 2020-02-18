package com.placecube.nhs.communitylisting.portlet.mostpopular;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.placecube.nhs.communitylisting.constants.PortletKeys;
import com.placecube.nhs.communitylisting.portlet.mostpopular.configuration.MostPopularCommunityPortletInstanceConfiguration;
import com.placecube.nhs.communitylisting.service.CommunityListingService;
import com.placecube.nhs.communitylisting.service.ConfigurationService;
import com.placecube.nhs.grouptypes.constants.GroupType;

@Component(immediate = true, property = { "com.liferay.fragment.entry.processor.portlet.alias=communitylisting-mostpopular",
		"com.liferay.portlet.css-class-wrapper=portlet-communitylisting portlet-communitylisting-most-popular", "com.liferay.portlet.display-category=category.nhs",
		"com.liferay.portlet.instanceable=true", "javax.portlet.resource-bundle=content.Language", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/most-popular/view.jsp", "javax.portlet.security-role-ref=power-user,user", "javax.portlet.name=" + PortletKeys.MOST_POPULAR,
		"javax.portlet.init-param.add-process-action-success-action=false" }, service = Portlet.class)
public class MostPopularCommunitiesPortlet extends MVCPortlet {

	private static final Log LOG = LogFactoryUtil.getLog(MostPopularCommunitiesPortlet.class);

	@Reference
	private ConfigurationService configurationService;

	@Reference
	private CommunityListingService communityListingService;

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

			MostPopularCommunityPortletInstanceConfiguration configuration = configurationService.getMostPopularConfiguration(themeDisplay, false);
			String groupType = configuration.groupType();

			if (GroupType.COMMUNITY_OF_INTEREST.getValue().equals(groupType)) {
				renderRequest.setAttribute("communities", communityListingService.getMostPopularCommunitiesOfInterest(themeDisplay, configuration.maxItemsToDisplay()));

			} else if (GroupType.COMMUNITY_OF_PRACTICE.getValue().equals(groupType)) {
				renderRequest.setAttribute("communities", communityListingService.getMostPopularCommunitiesOfPractice(themeDisplay, configuration.maxItemsToDisplay()));
			}
			renderRequest.setAttribute("compactDisplay", configuration.compactDisplay());

		} catch (Exception e) {
			LOG.debug(e);
			LOG.error(e.getMessage());
			SessionErrors.add(renderRequest, e.getClass());
		}

		super.render(renderRequest, renderResponse);
	}
}