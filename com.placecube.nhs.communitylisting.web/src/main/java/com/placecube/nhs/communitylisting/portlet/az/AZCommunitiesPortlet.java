package com.placecube.nhs.communitylisting.portlet.az;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.placecube.nhs.communitylisting.constants.PortletKeys;
import com.placecube.nhs.communitylisting.model.Community;
import com.placecube.nhs.communitylisting.service.CommunityListingService;

@Component(immediate = true, property = { "com.liferay.fragment.entry.processor.portlet.alias=communitylisting-az",
		"com.liferay.portlet.css-class-wrapper=portlet-communitylisting portlet-communitylisting-az", "com.liferay.portlet.display-category=category.nhs", "com.liferay.portlet.instanceable=false",
		"javax.portlet.resource-bundle=content.Language", "javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/az/view.jsp",
		"javax.portlet.security-role-ref=power-user,user", "javax.portlet.name=" + PortletKeys.AZ, "javax.portlet.init-param.add-process-action-success-action=false" }, service = Portlet.class)
public class AZCommunitiesPortlet extends MVCPortlet {

	@Reference
	private CommunityListingService communityListingService;

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		List<Community> allCommunities = communityListingService.getAllCommunities(themeDisplay);
		Map<String, List<Community>> azCommunities = communityListingService.getCommunitiesGroupedByInitial(allCommunities);
		renderRequest.setAttribute("azCommunities", azCommunities);

		super.render(renderRequest, renderResponse);
	}
}