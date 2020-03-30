package com.placecube.nhs.announcementsbanner.web.portlet;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.placecube.nhs.announcementsbanner.web.portlet.DismissAnnouncementMVCResourceCommand;
import com.placecube.nhs.announcementsbanner.web.service.AnnouncementsBannerService;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ ParamUtil.class, PropsUtil.class })
public class DismissAnnouncementMVCResourceCommandTest extends PowerMockito {

	@InjectMocks
	private DismissAnnouncementMVCResourceCommand dismissAnnouncementMVCResourceCommand;

	@Mock
	private AnnouncementsBannerService mockAnnouncementsBannerService;

	@Mock
	private Portal mockPortal;

	@Mock
	private ResourceRequest mockResourceRequest;

	@Mock
	private ResourceResponse mockResourceResponse;

	@Mock
	private ThemeDisplay mockThemeDisplay;

	@Mock
	private User mockUser;

	@Mock
	private HttpServletRequest mockHttpServletRequest;

	@Before
	public void setUp() {
		mockStatic(PropsUtil.class, ParamUtil.class);
	}

	@Test
	public void doServeResource_WhenNoError_ThenMarksAnnouncementAsRead() {
		Long announcementsEntryId = 11l;
		when(mockResourceRequest.getAttribute(WebKeys.THEME_DISPLAY)).thenReturn(mockThemeDisplay);
		when(mockThemeDisplay.getUser()).thenReturn(mockUser);
		when(mockPortal.getHttpServletRequest(mockResourceRequest)).thenReturn(mockHttpServletRequest);
		when(ParamUtil.getLong(mockResourceRequest, "announcementsEntryId")).thenReturn(announcementsEntryId);

		dismissAnnouncementMVCResourceCommand.doServeResource(mockResourceRequest, mockResourceResponse);

		verify(mockAnnouncementsBannerService, times(1)).markAnnouncementAsRead(mockHttpServletRequest, mockUser, announcementsEntryId);
	}

}
