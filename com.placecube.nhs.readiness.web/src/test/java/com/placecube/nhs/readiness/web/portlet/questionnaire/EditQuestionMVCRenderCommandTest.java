package com.placecube.nhs.readiness.web.portlet.questionnaire;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Optional;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.placecube.nhs.readiness.model.ReadinessQuestion;
import com.placecube.nhs.readiness.web.constants.ViewKeys;
import com.placecube.nhs.readiness.web.service.ReadinessQuestionnaireService;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ PropsUtil.class, ParamUtil.class })
public class EditQuestionMVCRenderCommandTest extends PowerMockito {

	private static final Integer CURRENT_INDEX = 12;
	private static final Long GROUP_ID = 456l;
	private static final Integer TOTAL_QUESTIONS = 3;

	@InjectMocks
	private EditQuestionMVCRenderCommand editQuestionMVCRenderCommand;

	@Mock
	private ReadinessQuestionnaireService mockReadinessQuestionnaireService;

	@Mock
	private RenderRequest mockRenderRequest;

	@Mock
	private RenderResponse mockRenderResponse;

	@Mock
	private ThemeDisplay mockThemeDisplay;

	@Mock
	private ReadinessQuestion mockReadinessQuestion;

	@Mock
	private List<ReadinessQuestion> mockQuestions;

	@Before
	public void setUp() {
		mockStatic(PropsUtil.class, ParamUtil.class);
	}

	@Test
	public void render_WhenCommandIsPreviousAndNoQuestionFound_ThenReturnsStartJSP() throws Exception {
		mockBasicDetails("previous");
		mockQuestionNotFound(CURRENT_INDEX - 1);

		String result = editQuestionMVCRenderCommand.render(mockRenderRequest, mockRenderResponse);

		assertThat(result, equalTo(ViewKeys.QUESTIONNAIRE_START));
	}

	@Test
	public void render_WhenCommandIsPreviousAndNoQuestionFound_ThenSetsWebContentGroupIdAsRequestAttribute() throws Exception {
		mockBasicDetails("previous");
		mockQuestionNotFound(CURRENT_INDEX - 1);

		editQuestionMVCRenderCommand.render(mockRenderRequest, mockRenderResponse);

		verify(mockRenderRequest, times(1)).setAttribute("webContentGroupId", GROUP_ID);
	}

	@Test
	public void render_WhenCommandIsPreviousAndQuestionFound_ThenReturnsEditJSP() throws Exception {
		mockBasicDetails("previous");
		mockQuestionFound(CURRENT_INDEX - 1);

		String result = editQuestionMVCRenderCommand.render(mockRenderRequest, mockRenderResponse);

		assertThat(result, equalTo(ViewKeys.QUESTIONNAIRE_EDIT));
	}

	@Test
	public void render_WhenCommandIsPreviousAndQuestionFound_ThenSetsQuestionAsRequestAttribute() throws Exception {
		mockBasicDetails("previous");
		mockQuestionFound(CURRENT_INDEX - 1);

		editQuestionMVCRenderCommand.render(mockRenderRequest, mockRenderResponse);

		verify(mockRenderRequest, times(1)).setAttribute("question", mockReadinessQuestion);
	}

	@Test
	public void render_WhenCommandIsPreviousAndQuestionFound_ThenSetsTotalQuestionsAsRequestAttribute() throws Exception {
		mockBasicDetails("previous");
		mockQuestionFound(CURRENT_INDEX - 1);

		editQuestionMVCRenderCommand.render(mockRenderRequest, mockRenderResponse);

		verify(mockRenderRequest, times(1)).setAttribute("totalQuestions", TOTAL_QUESTIONS);
	}

	@Test
	public void render_WhenCommandIsNextAndNoQuestionFound_ThenReturnsCompleteJSP() throws Exception {
		mockBasicDetails("next");
		mockQuestionNotFound(CURRENT_INDEX + 1);

		String result = editQuestionMVCRenderCommand.render(mockRenderRequest, mockRenderResponse);

		assertThat(result, equalTo(ViewKeys.QUESTIONNAIRE_COMPLETE));
	}

	@Test
	public void render_WhenCommandIsNextAndNoQuestionFound_ThenSetsWebContentGroupIdAsRequestAttribute() throws Exception {
		mockBasicDetails("next");
		mockQuestionNotFound(CURRENT_INDEX + 1);

		editQuestionMVCRenderCommand.render(mockRenderRequest, mockRenderResponse);

		verify(mockRenderRequest, times(1)).setAttribute("webContentGroupId", GROUP_ID);
	}

	@Test
	public void render_WhenCommandIsNextAndQuestionFound_ThenReturnsEditJSP() throws Exception {
		mockBasicDetails("next");
		mockQuestionFound(CURRENT_INDEX + 1);

		String result = editQuestionMVCRenderCommand.render(mockRenderRequest, mockRenderResponse);

		assertThat(result, equalTo(ViewKeys.QUESTIONNAIRE_EDIT));
	}

	@Test
	public void render_WhenCommandIsNextAndQuestionFound_ThenSetsQuestionAsRequestAttribute() throws Exception {
		mockBasicDetails("next");
		mockQuestionFound(CURRENT_INDEX + 1);

		editQuestionMVCRenderCommand.render(mockRenderRequest, mockRenderResponse);

		verify(mockRenderRequest, times(1)).setAttribute("question", mockReadinessQuestion);
	}

	@Test
	public void render_WhenCommandIsNextAndQuestionFound_ThenSetsTotalQuestionsAsRequestAttribute() throws Exception {
		mockBasicDetails("next");
		mockQuestionFound(CURRENT_INDEX + 1);

		editQuestionMVCRenderCommand.render(mockRenderRequest, mockRenderResponse);

		verify(mockRenderRequest, times(1)).setAttribute("totalQuestions", TOTAL_QUESTIONS);
	}

	@Test
	public void render_WhenCommandIsNotManagedAndNoQuestionFound_ThenReturnsCompleteJSP() throws Exception {
		mockBasicDetails("next11");
		mockQuestionNotFound(CURRENT_INDEX);

		String result = editQuestionMVCRenderCommand.render(mockRenderRequest, mockRenderResponse);

		assertThat(result, equalTo(ViewKeys.QUESTIONNAIRE_COMPLETE));
	}

	@Test
	public void render_WhenCommandIsNotManagedAndNoQuestionFound_ThenSetsWebContentGroupIdAsRequestAttribute() throws Exception {
		mockBasicDetails("otherCommand");
		mockQuestionNotFound(CURRENT_INDEX);

		editQuestionMVCRenderCommand.render(mockRenderRequest, mockRenderResponse);

		verify(mockRenderRequest, times(1)).setAttribute("webContentGroupId", GROUP_ID);
	}

	@Test
	public void render_WhenCommandIsNotManagedAndQuestionFound_ThenReturnsEditJSP() throws Exception {
		mockBasicDetails(null);
		mockQuestionFound(CURRENT_INDEX);

		String result = editQuestionMVCRenderCommand.render(mockRenderRequest, mockRenderResponse);

		assertThat(result, equalTo(ViewKeys.QUESTIONNAIRE_EDIT));
	}

	@Test
	public void render_WhenCommandIsNotManagedAndQuestionFound_ThenSetsQuestionAsRequestAttribute() throws Exception {
		mockBasicDetails("   ");
		mockQuestionFound(CURRENT_INDEX);

		editQuestionMVCRenderCommand.render(mockRenderRequest, mockRenderResponse);

		verify(mockRenderRequest, times(1)).setAttribute("question", mockReadinessQuestion);
	}

	@Test
	public void render_WhenCommandIsNotManagedAndQuestionFound_ThenSetsTotalQuestionsAsRequestAttribute() throws Exception {
		mockBasicDetails("different");
		mockQuestionFound(CURRENT_INDEX);

		editQuestionMVCRenderCommand.render(mockRenderRequest, mockRenderResponse);

		verify(mockRenderRequest, times(1)).setAttribute("totalQuestions", TOTAL_QUESTIONS);
	}

	private void mockQuestionFound(int index) {
		when(mockReadinessQuestionnaireService.getQuestionWithIndex(mockQuestions, index)).thenReturn(Optional.of(mockReadinessQuestion));
		when(mockQuestions.size()).thenReturn(TOTAL_QUESTIONS);
	}

	private void mockQuestionNotFound(int index) throws Exception {
		when(mockReadinessQuestionnaireService.getQuestionWithIndex(mockQuestions, index)).thenReturn(Optional.empty());
		when(mockReadinessQuestionnaireService.getWebContentGroupId(mockThemeDisplay)).thenReturn(GROUP_ID);
	}

	private void mockBasicDetails(String cmd) throws Exception {
		when(mockRenderRequest.getAttribute(WebKeys.THEME_DISPLAY)).thenReturn(mockThemeDisplay);
		when(ParamUtil.getInteger(mockRenderRequest, "currentQuestionIndex", 0)).thenReturn(CURRENT_INDEX);
		when(ParamUtil.getString(mockRenderRequest, Constants.CMD)).thenReturn(cmd);
		when(mockReadinessQuestionnaireService.getQuestions(mockThemeDisplay)).thenReturn(mockQuestions);
	}

}
