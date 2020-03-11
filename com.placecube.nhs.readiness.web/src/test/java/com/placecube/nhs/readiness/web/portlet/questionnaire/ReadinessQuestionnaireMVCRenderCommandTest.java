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

	@Before
	public void setUp() {
		initMocks(this);
	}

	@Test
	public void render_WhenNoError_ThenReturnsStartJSP() throws Exception {
		String result = readinessQuestionnaireMVCRenderCommand.render(mockRenderRequest, mockRenderResponse);

		assertThat(result, equalTo(ViewKeys.QUESTIONNAIRE_START));
	}

	@Test
	public void render_WhenNoError_ThenSetsWebContentGroupIdAsRequestAttribute() throws Exception {
		readinessQuestionnaireMVCRenderCommand.render(mockRenderRequest, mockRenderResponse);

		verify(mockReadinessQuestionnaireService, times(1)).setWebContentAttributesInRequest(mockRenderRequest, true);
	}

}
