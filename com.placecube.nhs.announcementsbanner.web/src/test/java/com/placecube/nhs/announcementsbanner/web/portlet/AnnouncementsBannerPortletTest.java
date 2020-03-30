package com.placecube.nhs.announcementsbanner.web.portlet;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.liferay.announcements.kernel.model.AnnouncementsEntry;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import com.placecube.nhs.announcementsbanner.web.portlet.AnnouncementsBannerPortlet;
import com.placecube.nhs.announcementsbanner.web.service.AnnouncementsBannerService;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ MVCPortlet.class })
public class AnnouncementsBannerPortletTest extends PowerMockito {

	@InjectMocks
	private AnnouncementsBannerPortlet announcementsBannerPortlet;

	@Mock
	private AnnouncementsBannerService mockAnnouncementsBannerService;

	@Mock
	private Portal mockPortal;

	@Mock
	private RenderRequest mockRenderRequest;

	@Mock
	private RenderResponse mockRenderResponse;

	@Mock
	private ThemeDisplay mockThemeDisplay;

	@Mock
	private User mockUser;

	@Mock
	private AnnouncementsEntry mockAnnouncementsEntry;

	@Mock
	private HttpServletRequest mockHttpServletRequest;

	@Before
	public void setUp() throws Exception {
		mockCallToSuper();
	}

	@Test(expected = PortletException.class)
	public void render_WhenExceptionRetrievingAnnouncements_ThenThrowsPortletException() throws Exception {
		mockBasicDetails();
		when(mockAnnouncementsBannerService.getUnreadAnnouncements(mockHttpServletRequest, mockUser)).thenThrow(new PortletException());

		announcementsBannerPortlet.render(mockRenderRequest, mockRenderResponse);
	}

	@Test
	public void render_WhenNoErrorAndAnnouncementsAreFound_ThenSetsAnnouncementsAsRequestAttribute() throws Exception {
		mockBasicDetails();
		List<AnnouncementsEntry> announcements = new ArrayList<>();
		announcements.add(mockAnnouncementsEntry);
		when(mockAnnouncementsBannerService.getUnreadAnnouncements(mockHttpServletRequest, mockUser)).thenReturn(announcements);

		announcementsBannerPortlet.render(mockRenderRequest, mockRenderResponse);

		verify(mockRenderRequest, times(1)).setAttribute("announcements", announcements);
	}

	@Test
	public void render_WhenNoErrorAndAnnouncementsAreFound_ThenDoesNotSetPortletConfiguratorVisibilityAsRequestAttribute() throws Exception {
		mockBasicDetails();
		List<AnnouncementsEntry> announcements = new ArrayList<>();
		announcements.add(mockAnnouncementsEntry);
		when(mockAnnouncementsBannerService.getUnreadAnnouncements(mockHttpServletRequest, mockUser)).thenReturn(announcements);

		announcementsBannerPortlet.render(mockRenderRequest, mockRenderResponse);

		verify(mockRenderRequest, never()).setAttribute(eq(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY), any());
	}

	@Test
	public void render_WhenNoErrorAndNoAnnouncementsAreFound_ThenDoesNotSetAnnouncementsAsRequestAttribute() throws Exception {
		mockBasicDetails();
		when(mockAnnouncementsBannerService.getUnreadAnnouncements(mockHttpServletRequest, mockUser)).thenReturn(Collections.emptyList());

		announcementsBannerPortlet.render(mockRenderRequest, mockRenderResponse);

		verify(mockRenderRequest, never()).setAttribute(eq("announcements"), any());
	}

	@Test
	public void render_WhenNoErrorAndNoAnnouncementsAreFound_ThenSetPortletConfiguratorVisibilityTrueAsRequestAttribute() throws Exception {
		mockBasicDetails();
		when(mockAnnouncementsBannerService.getUnreadAnnouncements(mockHttpServletRequest, mockUser)).thenReturn(Collections.emptyList());

		announcementsBannerPortlet.render(mockRenderRequest, mockRenderResponse);

		verify(mockRenderRequest, times(1)).setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, true);
	}

	@SuppressWarnings("rawtypes")
	private void mockCallToSuper() throws Exception {
		Class[] cArg = new Class[2];
		cArg[0] = RenderRequest.class;
		cArg[1] = RenderResponse.class;
		Method superRenderMethod = MVCPortlet.class.getMethod("render", cArg);
		MemberModifier.suppress(superRenderMethod);
	}

	private void mockBasicDetails() {
		when(mockRenderRequest.getAttribute(WebKeys.THEME_DISPLAY)).thenReturn(mockThemeDisplay);
		when(mockThemeDisplay.getUser()).thenReturn(mockUser);
		when(mockPortal.getHttpServletRequest(mockRenderRequest)).thenReturn(mockHttpServletRequest);
	}
}
