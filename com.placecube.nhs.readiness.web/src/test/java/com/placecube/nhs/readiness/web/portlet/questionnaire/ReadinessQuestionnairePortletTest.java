package com.placecube.nhs.readiness.web.portlet.questionnaire;

import static org.junit.Assert.fail;

import java.lang.reflect.Method;

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
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ MVCPortlet.class })
public class ReadinessQuestionnairePortletTest extends PowerMockito {

	@InjectMocks
	private ReadinessQuestionnairePortlet readinessQuestionnairePortlet;

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

	@Test(expected = PortletException.class)
	public void render_WhenUserIsNotSignedIn_ThenThrowsPortletException() throws Exception {
		when(mockRenderRequest.getAttribute(WebKeys.THEME_DISPLAY)).thenReturn(mockThemeDisplay);
		when(mockThemeDisplay.isSignedIn()).thenReturn(false);

		readinessQuestionnairePortlet.render(mockRenderRequest, mockRenderResponse);
	}

	@Test
	public void render_WhenUserIsSigned_ThenNoErrorIsThrown() throws Exception {
		when(mockRenderRequest.getAttribute(WebKeys.THEME_DISPLAY)).thenReturn(mockThemeDisplay);
		when(mockThemeDisplay.isSignedIn()).thenReturn(true);

		try {
			readinessQuestionnairePortlet.render(mockRenderRequest, mockRenderResponse);
		} catch (Exception e) {
			fail();
		}
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
