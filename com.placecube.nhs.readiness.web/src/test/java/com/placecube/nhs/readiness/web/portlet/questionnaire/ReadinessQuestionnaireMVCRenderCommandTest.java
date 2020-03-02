package com.placecube.nhs.readiness.web.portlet.questionnaire;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;

import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.placecube.nhs.readiness.web.constants.ViewKeys;
import com.placecube.nhs.readiness.web.service.ReadinessQuestionnaireService;

public class ReadinessQuestionnaireMVCRenderCommandTest extends PowerMockito {

	@InjectMocks
	private ReadinessQuestionnaireMVCRenderCommand readinessQuestionnaireMVCRenderCommand;

	@Mock
	private ReadinessQuestionnaireService mockReadinessQuestionnaireService;

	@Mock
	private RenderRequest mockRenderRequest;

	@Mock
	private RenderResponse mockRenderResponse;

	@Mock
	private ThemeDisplay mockThemeDisplay;

	@Before
	public void setUp() {
		initMocks(this);
	}

	@Test
	public void render_WhenNoError_ThenReturnsStartJSP() throws Exception {
		when(mockRenderRequest.getAttribute(WebKeys.THEME_DISPLAY)).thenReturn(mockThemeDisplay);

		String result = readinessQuestionnaireMVCRenderCommand.render(mockRenderRequest, mockRenderResponse);

		assertThat(result, equalTo(ViewKeys.QUESTIONNAIRE_START));
	}

	@Test
	public void render_WhenNoError_ThenSetsWebContentGroupIdAsRequestAttribute() throws Exception {
		long groupId = 123;
		when(mockRenderRequest.getAttribute(WebKeys.THEME_DISPLAY)).thenReturn(mockThemeDisplay);
		when(mockReadinessQuestionnaireService.getWebContentGroupId(mockThemeDisplay)).thenReturn(groupId);

		readinessQuestionnaireMVCRenderCommand.render(mockRenderRequest, mockRenderResponse);

		verify(mockRenderRequest, times(1)).setAttribute("webContentGroupId", groupId);
	}

}
