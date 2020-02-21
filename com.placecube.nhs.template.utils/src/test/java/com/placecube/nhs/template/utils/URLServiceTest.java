package com.placecube.nhs.template.utils;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Optional;

import javax.portlet.PortletRequest;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;

import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.portlet.PortletURLFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;

public class URLServiceTest extends PowerMockito {

	@InjectMocks
	private URLService urlService;

	@Mock
	private PortletURLFactory mockPortletURLFactory;

	@Mock
	private ThemeDisplay mockThemeDisplay;

	@Mock
	private Layout mockLayout;

	@Mock
	private Group mockGroup;

	@Mock
	private LiferayPortletURL mockLiferayPortletURL;

	@Mock
	private HttpServletRequest mockHttpServletRequest;

	@Before
	public void setUp() {
		initMocks(this);
	}

	@Test
	public void getCurrentFullURL_WhenLayoutIsPrivate_ThenReturnsTheFullLayoutURL() {
		String pathPrivate = "pathPrivateValue";
		String groupURL = "groupURLValue";
		String layoutURL = "layoutURLValue";
		when(mockThemeDisplay.getLayout()).thenReturn(mockLayout);
		when(mockLayout.isPrivateLayout()).thenReturn(true);
		when(mockThemeDisplay.getPathFriendlyURLPrivateGroup()).thenReturn(pathPrivate);
		when(mockLayout.getGroup()).thenReturn(mockGroup);
		when(mockGroup.getFriendlyURL()).thenReturn(groupURL);
		when(mockLayout.getFriendlyURL()).thenReturn(layoutURL);

		String result = urlService.getCurrentFullURL(mockThemeDisplay);

		assertThat(result, equalTo(pathPrivate + groupURL + layoutURL));
	}

	@Test
	public void getCurrentFullURL_WhenLayoutIsPublic_ThenReturnsTheFullLayoutURL() {
		String pathPublic = "pathPublicValue";
		String groupURL = "groupURLValue";
		String layoutURL = "layoutURLValue";
		when(mockThemeDisplay.getLayout()).thenReturn(mockLayout);
		when(mockLayout.isPrivateLayout()).thenReturn(false);
		when(mockThemeDisplay.getPathFriendlyURLPublic()).thenReturn(pathPublic);
		when(mockLayout.getGroup()).thenReturn(mockGroup);
		when(mockGroup.getFriendlyURL()).thenReturn(groupURL);
		when(mockLayout.getFriendlyURL()).thenReturn(layoutURL);

		String result = urlService.getCurrentFullURL(mockThemeDisplay);

		assertThat(result, equalTo(pathPublic + groupURL + layoutURL));
	}

	@Test
	public void getRegistrationURL_WhenException_ThenReturnsEmptyOptional() throws WindowStateException {
		when(mockPortletURLFactory.create(mockHttpServletRequest, URLService.LOGIN_PORTLET_KEY, PortletRequest.RENDER_PHASE)).thenReturn(mockLiferayPortletURL);
		doThrow(new WindowStateException("msg", null)).when(mockLiferayPortletURL).setWindowState(WindowState.MAXIMIZED);

		Optional<String> result = urlService.getRegistrationURL(mockHttpServletRequest, mockThemeDisplay);

		assertThat(result.isPresent(), equalTo(false));
	}

	@Test
	public void getRegistrationURL_WhenNoError_ThenReturnsOptioanlWithLiferayRegistrationURL() throws WindowStateException {
		when(mockPortletURLFactory.create(mockHttpServletRequest, URLService.LOGIN_PORTLET_KEY, PortletRequest.RENDER_PHASE)).thenReturn(mockLiferayPortletURL);
		String expected = "expected";
		when(mockLiferayPortletURL.toString()).thenReturn(expected);

		Optional<String> result = urlService.getRegistrationURL(mockHttpServletRequest, mockThemeDisplay);

		assertThat(result.get(), equalTo(expected));
		verify(mockLiferayPortletURL, times(1)).setWindowState(WindowState.MAXIMIZED);
		verify(mockLiferayPortletURL, times(1)).setParameter("mvcRenderCommandName", URLService.CREATE_ACCOUNT_MVC_RENDER_COMMAND_NAME);
	}
}
