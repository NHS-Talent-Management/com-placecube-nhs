package com.placecube.nhs.user.profile.portlet.experience;

import java.util.Collections;

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
import com.placecube.nhs.userprofile.model.Experience;
import com.placecube.nhs.userprofile.service.ExperienceLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + PortletKeys.USER_PROFILE_EXPERIENCE, "mvc.command.name=" + MVCCommandKeys.EXPERIENCE_EDIT }, service = MVCRenderCommand.class)
public class UserProfileExperienceEditMVCRenderCommand implements MVCRenderCommand {

	@Reference
	private ExperienceLocalService experienceLocalService;

	@Reference
	private ExtraInfoService extraInfoService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		ExtraInfoContext extraInfoContext = (ExtraInfoContext) renderRequest.getAttribute("extraInfoContext");

		if (Validator.isNull(extraInfoContext)) {
			Experience experience = experienceLocalService.fetchExperience(ParamUtil.getLong(renderRequest, "experienceId", 0l));
			extraInfoContext = extraInfoService.getExtraInfoFromExperience(experience);
		}

		renderRequest.setAttribute("validationErrors", renderRequest.getAttribute("validationErrors"));
		renderRequest.setAttribute("timePeriodOptions", Collections.singletonMap("true", "i-currently-work-here"));
		renderRequest.setAttribute("extraInfoContext", extraInfoContext);

		return "/user-profile-experience/edit.jsp";
	}

}
