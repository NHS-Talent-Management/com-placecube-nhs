package com.placecube.nhs.readiness.web.portlet.summary;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.lang.reflect.Method;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.placecube.nhs.readiness.model.ReadinessQuestion;
import com.placecube.nhs.readiness.service.ReadinessService;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ MVCPortlet.class })
public class ReadinessSummaryPortletTest extends PowerMockito {

	@InjectMocks
	private ReadinessSummaryPortlet readinessSummaryPortlet;

	@Mock
	private ReadinessService mockReadinessService;

	@Mock
	private List<ReadinessQuestion> mockQuestions;

	@Mock
	private User mockUser;

	@Mock
	private RenderRequest mockRenderRequest;

	@Mock
	private RenderResponse mockRenderResponse;

	@Mock
	private ThemeDisplay mockThemeDisplay;

	@Before
	public void setUp() throws Exception {
		mockCallToSuper();
	}

	@Test
	public void render_WhenUserIsNotSignedIn_ThenNothingIsAddedAsRequestAttribute() throws Exception {
		when(mockRenderRequest.getAttribute(WebKeys.THEME_DISPLAY)).thenReturn(mockThemeDisplay);
		when(mockThemeDisplay.isSignedIn()).thenReturn(false);

		readinessSummaryPortlet.render(mockRenderRequest, mockRenderResponse);

		verifyZeroInteractions(mockReadinessService);
		verify(mockRenderRequest, never()).setAttribute(anyString(), any());
	}

	@Test(expected = PortletException.class)
	public void render_WhenUserIsSignedInAndException_ThenThrowsPortletException() throws Exception {
		when(mockRenderRequest.getAttribute(WebKeys.THEME_DISPLAY)).thenReturn(mockThemeDisplay);
		when(mockThemeDisplay.isSignedIn()).thenReturn(true);
		when(mockThemeDisplay.getUser()).thenReturn(mockUser);
		when(mockReadinessService.getQuestions(mockUser)).thenThrow(new ConfigurationException());

		readinessSummaryPortlet.render(mockRenderRequest, mockRenderResponse);
	}

	@Test
	public void render_WhenUserIsSignedInAnNoError_ThenSetsQuestionsAsRequestAttribute() throws Exception {
		when(mockRenderRequest.getAttribute(WebKeys.THEME_DISPLAY)).thenReturn(mockThemeDisplay);
		when(mockThemeDisplay.isSignedIn()).thenReturn(true);
		when(mockThemeDisplay.getUser()).thenReturn(mockUser);
		when(mockReadinessService.getQuestions(mockUser)).thenReturn(mockQuestions);

		readinessSummaryPortlet.render(mockRenderRequest, mockRenderResponse);

		verify(mockRenderRequest, times(1)).setAttribute("questions", mockQuestions);
	}

	@SuppressWarnings("rawtypes")
	private void mockCallToSuper() throws Exception {
		Class[] cArg = new Class[2];
		cArg[0] = RenderRequest.class;
		cArg[1] = RenderResponse.class;
		Method superRenderMethod = MVCPortlet.class.getMethod("render", cArg);
		MemberModifier.suppress(superRenderMethod);
	}

}
