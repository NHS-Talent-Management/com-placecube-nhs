package com.placecube.nhs.user.profile.portlet.professionalbodies;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.placecube.nhs.user.profile.constants.MVCCommandKeys;
import com.placecube.nhs.user.profile.constants.PortletKeys;
import com.placecube.nhs.userprofile.service.ProfessionalBodyLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + PortletKeys.USER_PROFILE_PROFESSIONAL_BODIES, "mvc.command.name=" + MVCCommandKeys.PROFESSIONAL_BODIES_VIEW,
		"mvc.command.name=/" }, service = MVCRenderCommand.class)
public class UserProfileProfessionalBodiesMVCRenderCommand implements MVCRenderCommand {

	@Reference
	private ProfessionalBodyLocalService professionalBodyLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		renderRequest.setAttribute("professionalBodies", professionalBodyLocalService.getProfessionalBodies(themeDisplay.getUserId()));

		return "/user-profile-professional-bodies/view.jsp";
	}

}
