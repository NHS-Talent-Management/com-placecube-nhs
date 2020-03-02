package com.placecube.nhs.readiness.web.portlet.questionnaire;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.MutableRenderParameters;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.placecube.nhs.readiness.service.ReadinessService;
import com.placecube.nhs.readiness.web.constants.MVCCommandKeys;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ PropsUtil.class, ParamUtil.class })
public class EditQuestionMVCActionCommandTest extends PowerMockito {

	private static final Integer CURRENT_INDEX = 12;
	private static final long QUESTION_ID = 33;
	private static final String USER_ANSWER = "myAnswer";
	private static final long USER_ID = 550;

	@InjectMocks
	private EditQuestionMVCActionCommand editQuestionMVCActionCommand;

	@Mock
	private ReadinessService mockReadinessService;

	@Mock
	private ActionRequest mockActionRequest;

	@Mock
	private ActionResponse mockActionResponse;

	@Mock
	private ThemeDisplay mockThemeDisplay;

	@Mock
	private MutableRenderParameters mockParameters;

	@Before
	public void setUp() {
		mockStatic(PropsUtil.class, ParamUtil.class);
	}

	@Test
	public void doProcessAction_WhenNoError_ThenUpdatesTheAnswer() throws Exception {
		mockBasicDetails();

		editQuestionMVCActionCommand.doProcessAction(mockActionRequest, mockActionResponse);

		verify(mockReadinessService, times(1)).updateAnswer(QUESTION_ID, USER_ID, USER_ANSWER);
	}

	@Test
	public void doProcessAction_WhenNoError_ThenAddsEditAnswerAsRenderCommandNameParameter() throws Exception {
		mockBasicDetails();

		editQuestionMVCActionCommand.doProcessAction(mockActionRequest, mockActionResponse);

		verify(mockParameters, times(1)).setValue("mvcRenderCommandName", MVCCommandKeys.QUESTIONNAIRE_EDIT_ANSWER);
	}

	@Test
	public void doProcessAction_WhenNoError_ThenAddsCurrentIndexAsRenderCommandNameParameter() throws Exception {
		mockBasicDetails();

		editQuestionMVCActionCommand.doProcessAction(mockActionRequest, mockActionResponse);

		verify(mockParameters, times(1)).setValue("currentQuestionIndex", String.valueOf(CURRENT_INDEX));
	}

	@Test
	public void doProcessAction_WhenNoError_ThenAddsCommandNextAsRenderCommandNameParameter() throws Exception {
		mockBasicDetails();

		editQuestionMVCActionCommand.doProcessAction(mockActionRequest, mockActionResponse);

		verify(mockParameters, times(1)).setValue("cmd", "next");
	}

	private void mockBasicDetails() {
		when(mockActionRequest.getAttribute(WebKeys.THEME_DISPLAY)).thenReturn(mockThemeDisplay);
		when(mockThemeDisplay.getUserId()).thenReturn(USER_ID);
		when(ParamUtil.getInteger(mockActionRequest, "currentQuestionIndex", 0)).thenReturn(CURRENT_INDEX);
		when(ParamUtil.getLong(mockActionRequest, "currentQuestionId")).thenReturn(QUESTION_ID);
		when(ParamUtil.getString(mockActionRequest, "userAnswer")).thenReturn(USER_ANSWER);
		when(mockActionResponse.getRenderParameters()).thenReturn(mockParameters);
	}

}
