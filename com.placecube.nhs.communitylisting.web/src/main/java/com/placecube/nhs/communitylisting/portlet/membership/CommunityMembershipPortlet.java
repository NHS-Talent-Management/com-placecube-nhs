package com.placecube.nhs.communitylisting.portlet.membership;

import java.io.IOException;

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
import com.placecube.nhs.communitylisting.service.RetrievalService;

@Component(immediate = true, property = { "com.liferay.fragment.entry.processor.portlet.alias=communitylisting-membership",
		"com.liferay.portlet.css-class-wrapper=portlet-communitylisting portlet-communitylisting-membership", "com.liferay.portlet.display-category=category.nhs",
		"com.liferay.portlet.instanceable=false", "javax.portlet.resource-bundle=content.Language", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/membership/view.jsp", "javax.portlet.security-role-ref=power-user,user", "javax.portlet.name=" + PortletKeys.MEMBERSHIP,
		"javax.portlet.init-param.add-process-action-success-action=false" }, service = Portlet.class)
public class CommunityMembershipPortlet extends MVCPortlet {

	@Reference
	private RetrievalService retrievalService;

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		boolean isSignedIn = themeDisplay.isSignedIn();
		renderRequest.setAttribute("isGuest", !isSignedIn);

		if (isSignedIn) {
			renderRequest.setAttribute("isSiteMember", retrievalService.isGroupMember(themeDisplay.getUser(), themeDisplay.getScopeGroupId()));
		}

		super.render(renderRequest, renderResponse);
	}
}