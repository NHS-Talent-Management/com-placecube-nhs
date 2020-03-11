package com.placecube.nhs.readiness.web.portlet.questionnaire;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.placecube.nhs.readiness.web.constants.MVCCommandKeys;
import com.placecube.nhs.readiness.web.constants.PortletKeys;
import com.placecube.nhs.readiness.web.constants.ViewKeys;
import com.placecube.nhs.readiness.web.service.ReadinessQuestionnaireService;

@Component(immediate = true, property = { "javax.portlet.name=" + PortletKeys.READINESS_QUESTIONNAIRE, "mvc.command.name=/",
		"mvc.command.name=" + MVCCommandKeys.QUESTIONNAIRE_VIEW }, service = MVCRenderCommand.class)
public class ReadinessQuestionnaireMVCRenderCommand implements MVCRenderCommand {

	@Reference
	private ReadinessQuestionnaireService readinessQuestionnaireService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		readinessQuestionnaireService.setWebContentAttributesInRequest(renderRequest, true);
		return ViewKeys.QUESTIONNAIRE_START;
	}

}
