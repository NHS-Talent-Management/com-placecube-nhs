package com.placecube.nhs.user.profile.portlet.details;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.placecube.nhs.user.profile.constants.MVCCommandKeys;
import com.placecube.nhs.user.profile.constants.PortletKeys;
import com.placecube.nhs.user.profile.constants.WebContentArticles;

@Component(immediate = true, property = { "javax.portlet.name=" + PortletKeys.USER_PROFILE_DETAILS, "mvc.command.name=" + MVCCommandKeys.PULL_FROM_SOURCE }, service = MVCRenderCommand.class)
public class UserProfileDetailsPullFromSourceMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		renderRequest.setAttribute("webcontentArticleId", WebContentArticles.PROFILE_DETAILS.getArticleId());

		return "/pull-from-source.jsp";
	}

}
