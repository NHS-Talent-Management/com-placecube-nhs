package com.placecube.nhs.readiness.web.portlet.questionnaire;

import java.util.List;
import java.util.Optional;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.placecube.nhs.readiness.model.ReadinessQuestion;
import com.placecube.nhs.readiness.web.constants.MVCCommandKeys;
import com.placecube.nhs.readiness.web.constants.PortletKeys;
import com.placecube.nhs.readiness.web.constants.ViewKeys;
import com.placecube.nhs.readiness.web.service.ReadinessQuestionnaireService;

@Component(immediate = true, property = { "javax.portlet.name=" + PortletKeys.READINESS_QUESTIONNAIRE,
		"mvc.command.name=" + MVCCommandKeys.QUESTIONNAIRE_EDIT_ANSWER }, service = MVCRenderCommand.class)
public class EditQuestionMVCRenderCommand implements MVCRenderCommand {

	@Reference
	private ReadinessQuestionnaireService readinessQuestionnaireService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		int currentQuestionIndex = ParamUtil.getInteger(renderRequest, "currentQuestionIndex", 0);
		String cmd = ParamUtil.getString(renderRequest, Constants.CMD);

		String noQuestionViewPage;
		boolean showIntro = false;
		int questionIndex;

		if ("previous".equals(cmd)) {
			questionIndex = currentQuestionIndex - 1;
			noQuestionViewPage = ViewKeys.QUESTIONNAIRE_START;
			showIntro = true;
		} else if ("next".equals(cmd)) {
			questionIndex = currentQuestionIndex + 1;
			noQuestionViewPage = ViewKeys.QUESTIONNAIRE_COMPLETE;
		} else {
			questionIndex = currentQuestionIndex;
			noQuestionViewPage = ViewKeys.QUESTIONNAIRE_COMPLETE;
		}

		List<ReadinessQuestion> questions = readinessQuestionnaireService.getQuestions(themeDisplay);
		Optional<ReadinessQuestion> readinessQuestion = readinessQuestionnaireService.getQuestionWithIndex(questions, questionIndex);

		if (readinessQuestion.isPresent()) {
			renderRequest.setAttribute("question", readinessQuestion.get());
			renderRequest.setAttribute("totalQuestions", questions.size());
			return ViewKeys.QUESTIONNAIRE_EDIT;

		} else {
			readinessQuestionnaireService.setWebContentAttributesInRequest(renderRequest, showIntro);
			return noQuestionViewPage;
		}
	}

}
