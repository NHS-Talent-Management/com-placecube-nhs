package com.placecube.nhs.user.profile.portlet.learningskills;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.placecube.nhs.user.profile.constants.MVCCommandKeys;
import com.placecube.nhs.user.profile.constants.PortletKeys;
import com.placecube.nhs.user.profile.model.ExtraInfoContext;
import com.placecube.nhs.user.profile.service.ExtraInfoService;
import com.placecube.nhs.userprofile.model.Qualification;
import com.placecube.nhs.userprofile.service.QualificationLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + PortletKeys.USER_PROFILE_LEARNING_SKILLS,
		"mvc.command.name=" + MVCCommandKeys.LEARNING_SKILLS_EDIT }, service = MVCRenderCommand.class)
public class UserProfileLearningSkillsEditMVCRenderCommand implements MVCRenderCommand {

	@Reference
	private QualificationLocalService qualificationLocalService;

	@Reference
	private ExtraInfoService extraInfoService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		ExtraInfoContext extraInfoContext = (ExtraInfoContext) renderRequest.getAttribute("extraInfoContext");

		if (Validator.isNull(extraInfoContext)) {
			Qualification qualification = qualificationLocalService.fetchQualification(ParamUtil.getLong(renderRequest, "qualificationId", 0l));
			extraInfoContext = extraInfoService.getExtraInfoFromQualification(qualification);
		}

		renderRequest.setAttribute("validationErrors", renderRequest.getAttribute("validationErrors"));
		renderRequest.setAttribute("extraInfoContext", extraInfoContext);

		return "/user-profile-learning-skills/edit.jsp";
	}

}
