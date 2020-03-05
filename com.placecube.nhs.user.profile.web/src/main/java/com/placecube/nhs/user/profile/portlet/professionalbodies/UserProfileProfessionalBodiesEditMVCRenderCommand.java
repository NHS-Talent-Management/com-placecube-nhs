package com.placecube.nhs.user.profile.portlet.professionalbodies;

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
import com.placecube.nhs.userprofile.model.ProfessionalBody;
import com.placecube.nhs.userprofile.service.ProfessionalBodyLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + PortletKeys.USER_PROFILE_PROFESSIONAL_BODIES,
		"mvc.command.name=" + MVCCommandKeys.PROFESSIONAL_BODIES_EDIT }, service = MVCRenderCommand.class)
public class UserProfileProfessionalBodiesEditMVCRenderCommand implements MVCRenderCommand {

	@Reference
	private ProfessionalBodyLocalService professionalBodyLocalService;

	@Reference
	private ExtraInfoService extraInfoService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		ExtraInfoContext extraInfoContext = (ExtraInfoContext) renderRequest.getAttribute("extraInfoContext");

		if (Validator.isNull(extraInfoContext)) {
			ProfessionalBody professionalBody = professionalBodyLocalService.fetchProfessionalBody(ParamUtil.getLong(renderRequest, "professionalBodyId", 0l));
			extraInfoContext = extraInfoService.getExtraInfoFromProfessionalBody(professionalBody);
		}

		renderRequest.setAttribute("validationErrors", renderRequest.getAttribute("validationErrors"));
		renderRequest.setAttribute("extraInfoContext", extraInfoContext);

		return "/user-profile-professional-bodies/edit.jsp";
	}

}
