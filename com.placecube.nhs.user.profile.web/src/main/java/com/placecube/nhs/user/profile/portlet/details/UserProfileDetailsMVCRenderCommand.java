package com.placecube.nhs.user.profile.portlet.details;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.placecube.nhs.user.profile.constants.MVCCommandKeys;
import com.placecube.nhs.user.profile.constants.PortletKeys;
import com.placecube.nhs.user.profile.service.UserProfileService;

@Component(immediate = true, property = { "javax.portlet.name=" + PortletKeys.USER_PROFILE_DETAILS, "mvc.command.name=" + MVCCommandKeys.PROFILE_DETAILS_VIEW,
		"mvc.command.name=/" }, service = MVCRenderCommand.class)
public class UserProfileDetailsMVCRenderCommand implements MVCRenderCommand {

	@Reference
	private UserProfileService userProfileService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		renderRequest.setAttribute("userProfileContext", userProfileService.getUserProfileContext(renderRequest));

		return "/user-profile-details/view.jsp";
	}

}
