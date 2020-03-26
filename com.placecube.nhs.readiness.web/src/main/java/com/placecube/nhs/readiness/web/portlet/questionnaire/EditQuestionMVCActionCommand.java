package com.placecube.nhs.readiness.web.portlet.questionnaire;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.placecube.nhs.readiness.service.ReadinessService;
import com.placecube.nhs.readiness.web.constants.MVCCommandKeys;
import com.placecube.nhs.readiness.web.constants.PortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + PortletKeys.READINESS_QUESTIONNAIRE,
		"mvc.command.name=" + MVCCommandKeys.QUESTIONNAIRE_EDIT_ANSWER }, service = MVCActionCommand.class)
public class EditQuestionMVCActionCommand extends BaseMVCActionCommand {

	@Reference
	private ReadinessService readinessService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		int currentQuestionIndex = ParamUtil.getInteger(actionRequest, "currentQuestionIndex", 0);
		long currentQuestionId = ParamUtil.getLong(actionRequest, "currentQuestionId");
		String userAnswer = ParamUtil.getString(actionRequest, "userAnswer");

		if (Validator.isNotNull(userAnswer)) {
			readinessService.updateAnswer(currentQuestionId, themeDisplay.getUserId(), userAnswer);
			actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandKeys.QUESTIONNAIRE_EDIT_ANSWER);
			actionResponse.getRenderParameters().setValue("currentQuestionIndex", String.valueOf(currentQuestionIndex));
			actionResponse.getRenderParameters().setValue("cmd", "next");
		} else {
			actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandKeys.QUESTIONNAIRE_EDIT_ANSWER);
			actionResponse.getRenderParameters().setValue("currentQuestionIndex", String.valueOf(currentQuestionIndex));
			actionRequest.setAttribute("validationErrorMessage", "select-an-answer");
		}
	}

}
