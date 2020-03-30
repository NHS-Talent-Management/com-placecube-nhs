package com.placecube.nhs.announcementsbanner.web.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.announcements.kernel.model.AnnouncementsEntry;
import com.liferay.announcements.kernel.model.AnnouncementsFlagConstants;
import com.liferay.announcements.kernel.service.AnnouncementsEntryLocalService;
import com.liferay.announcements.kernel.service.AnnouncementsFlagLocalService;
import com.liferay.announcements.kernel.util.AnnouncementsUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.GetterUtil;

@Component(immediate = true, service = AnnouncementsBannerService.class)
public class AnnouncementsBannerService {

	private static final Log LOG = LogFactoryUtil.getLog(AnnouncementsBannerService.class);

	static final String DISMISS_ANNOUNCEMENT_SESSION_ATTRIBUTE_PREFIX = "dismiss-announcement-";

	@Reference
	private AnnouncementsEntryLocalService announcementsEntryLocalService;

	@Reference
	private AnnouncementsFlagLocalService announcementsFlagLocalService;

	public List<AnnouncementsEntry> getUnreadAnnouncements(HttpServletRequest httpServletRequest, User user) throws PortletException {
		try {
			List<AnnouncementsEntry> entries = announcementsEntryLocalService.getEntries(user.getUserId(), AnnouncementsUtil.getAnnouncementScopes(user), false, AnnouncementsFlagConstants.NOT_HIDDEN,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS);

			if (user.isDefaultUser()) {
				HttpSession session = httpServletRequest.getSession();
				return entries.stream().filter(entry -> unreadAnnouncement(entry, session)).collect(Collectors.toList());
			}

			return entries;
		} catch (Exception e) {
			throw new PortletException(e);
		}
	}

	public void markAnnouncementAsRead(HttpServletRequest httpServletRequest, User user, long announcementsEntryId) {
		if (user.isDefaultUser()) {
			LOG.debug("Adding session attribute to dismiss announcement " + announcementsEntryId);
			httpServletRequest.getSession().setAttribute(DISMISS_ANNOUNCEMENT_SESSION_ATTRIBUTE_PREFIX + announcementsEntryId, true);
		} else {
			LOG.debug("Marking announcement " + announcementsEntryId + " as hidden for userId: " + user.getUserId());
			announcementsFlagLocalService.addFlag(user.getUserId(), announcementsEntryId, AnnouncementsFlagConstants.HIDDEN);
		}
	}

	private boolean unreadAnnouncement(AnnouncementsEntry entry, HttpSession session) {
		return !GetterUtil.getBoolean(session.getAttribute(DISMISS_ANNOUNCEMENT_SESSION_ATTRIBUTE_PREFIX + entry.getEntryId()), false);
	}
}
