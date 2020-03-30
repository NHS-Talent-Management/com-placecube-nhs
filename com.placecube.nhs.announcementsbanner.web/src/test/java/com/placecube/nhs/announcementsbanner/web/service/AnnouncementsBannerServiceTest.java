package com.placecube.nhs.announcementsbanner.web.service;

import static org.hamcrest.Matchers.sameInstance;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.portlet.PortletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.liferay.announcements.kernel.model.AnnouncementsEntry;
import com.liferay.announcements.kernel.model.AnnouncementsFlagConstants;
import com.liferay.announcements.kernel.service.AnnouncementsEntryLocalService;
import com.liferay.announcements.kernel.service.AnnouncementsFlagLocalService;
import com.liferay.announcements.kernel.util.AnnouncementsUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.placecube.nhs.announcementsbanner.web.service.AnnouncementsBannerService;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ AnnouncementsUtil.class, PortalUtil.class, PropsUtil.class })
public class AnnouncementsBannerServiceTest extends PowerMockito {

	@InjectMocks
	private AnnouncementsBannerService announcementsBannerService;

	private static final long USER_ID = 1;
	private static final long ANNOUNCEMENT_ID_1 = 11;
	private static final long ANNOUNCEMENT_ID_2 = 22;
	private static final long ANNOUNCEMENT_ID_3 = 33;

	@Mock
	private AnnouncementsEntryLocalService mockAnnouncementsEntryLocalService;

	@Mock
	private AnnouncementsFlagLocalService mockAnnouncementsFlagLocalService;

	@Mock
	private User mockUser;

	@Mock
	private HttpServletRequest mockHttpServletRequest;

	@Mock
	private HttpSession mockHttpSession;

	@Mock
	private LinkedHashMap<Long, long[]> mockScopes;

	@Mock
	private AnnouncementsEntry mockAnnouncementsEntry1;

	@Mock
	private AnnouncementsEntry mockAnnouncementsEntry2;

	@Mock
	private AnnouncementsEntry mockAnnouncementsEntry3;

	private List<AnnouncementsEntry> announcements;

	@Before
	public void setUp() {
		mockStatic(PortalUtil.class, PropsUtil.class);
		mockStatic(AnnouncementsUtil.class);

		announcements = new ArrayList<>();
	}

	@Test(expected = PortletException.class)
	public void getUnreadAnnouncements_WhenException_ThenThrowsPortletException() throws Exception {
		when(AnnouncementsUtil.getAnnouncementScopes(mockUser)).thenThrow(new PortalException());

		announcementsBannerService.getUnreadAnnouncements(mockHttpServletRequest, mockUser);
	}

	@Test
	public void getUnreadAnnouncements_WhenNoErrorAndUserIsNotTheDefaultUser_ThenReturnsAnnouncementsRetrieved() throws Exception {
		mockAnnouncementDetail(mockAnnouncementsEntry1, ANNOUNCEMENT_ID_1, false);
		mockAnnouncementDetail(mockAnnouncementsEntry2, ANNOUNCEMENT_ID_2, true);
		mockAnnouncementDetail(mockAnnouncementsEntry3, ANNOUNCEMENT_ID_3, false);
		mockUserDetails(false);
		mockAnnouncementsRetrieval();

		List<AnnouncementsEntry> results = announcementsBannerService.getUnreadAnnouncements(mockHttpServletRequest, mockUser);

		assertThat(results, sameInstance(announcements));
	}

	@Test
	public void getUnreadAnnouncements_WhenNoErrorAndUserIsTheDefaultUser_ThenReturnsAnnouncementsRetrievedFilteredBasedOnSessionAttributes() throws Exception {
		mockAnnouncementDetail(mockAnnouncementsEntry1, ANNOUNCEMENT_ID_1, false);
		mockAnnouncementDetail(mockAnnouncementsEntry2, ANNOUNCEMENT_ID_2, true);
		mockAnnouncementDetail(mockAnnouncementsEntry3, ANNOUNCEMENT_ID_3, false);
		when(mockHttpServletRequest.getSession()).thenReturn(mockHttpSession);
		mockUserDetails(true);
		mockAnnouncementsRetrieval();

		List<AnnouncementsEntry> results = announcementsBannerService.getUnreadAnnouncements(mockHttpServletRequest, mockUser);

		assertThat(results, containsInAnyOrder(mockAnnouncementsEntry1, mockAnnouncementsEntry3));
	}

	@Test
	public void markAnnouncementAsRead_WhenUserIsNotTheDefaultUser_ThenAddsTheFlagToHideTheAnnouncement() {
		mockUserDetails(false);

		announcementsBannerService.markAnnouncementAsRead(mockHttpServletRequest, mockUser, ANNOUNCEMENT_ID_1);

		verify(mockAnnouncementsFlagLocalService, times(1)).addFlag(USER_ID, ANNOUNCEMENT_ID_1, AnnouncementsFlagConstants.HIDDEN);
	}

	@Test
	public void markAnnouncementAsRead_WhenUserIsTheDefaultUser_ThenAddsTheAnnouncementAsDismissedInSession() {
		mockUserDetails(true);
		when(mockHttpServletRequest.getSession()).thenReturn(mockHttpSession);

		announcementsBannerService.markAnnouncementAsRead(mockHttpServletRequest, mockUser, ANNOUNCEMENT_ID_1);

		verify(mockHttpSession, times(1)).setAttribute(AnnouncementsBannerService.DISMISS_ANNOUNCEMENT_SESSION_ATTRIBUTE_PREFIX + ANNOUNCEMENT_ID_1, true);
	}

	private void mockAnnouncementDetail(AnnouncementsEntry entry, long announcementId, boolean dismissedInSession) {
		when(entry.getEntryId()).thenReturn(announcementId);
		announcements.add(entry);
		when(mockHttpSession.getAttribute(AnnouncementsBannerService.DISMISS_ANNOUNCEMENT_SESSION_ATTRIBUTE_PREFIX + announcementId)).thenReturn(dismissedInSession);
	}

	private void mockAnnouncementsRetrieval() throws PortalException {
		when(AnnouncementsUtil.getAnnouncementScopes(mockUser)).thenReturn(mockScopes);
		when(mockAnnouncementsEntryLocalService.getEntries(USER_ID, mockScopes, false, AnnouncementsFlagConstants.NOT_HIDDEN, QueryUtil.ALL_POS, QueryUtil.ALL_POS)).thenReturn(announcements);
	}

	private void mockUserDetails(boolean defaultUser) {
		when(mockUser.getUserId()).thenReturn(USER_ID);
		when(mockUser.isDefaultUser()).thenReturn(defaultUser);
	}
}
