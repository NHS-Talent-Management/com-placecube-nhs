package com.placecube.nhs.user.profile.portlet.learningskills;

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
import com.placecube.nhs.userprofile.service.QualificationLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + PortletKeys.USER_PROFILE_LEARNING_SKILLS, "mvc.command.name=" + MVCCommandKeys.LEARNING_SKILLS_VIEW,
		"mvc.command.name=/" }, service = MVCRenderCommand.class)
public class UserProfileLearningSkillsMVCRenderCommand implements MVCRenderCommand {

	@Reference
	private QualificationLocalService qualificationLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		renderRequest.setAttribute("qualifications", qualificationLocalService.getQualifications(themeDisplay.getUserId()));

		return "/user-profile-learning-skills/view.jsp";
	}

}
