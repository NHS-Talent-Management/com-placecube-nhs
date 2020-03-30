package com.placecube.nhs.announcementsbanner.web.portlet;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import com.placecube.nhs.announcementsbanner.web.constants.MVCCommandKeys;
import com.placecube.nhs.announcementsbanner.web.constants.PortletKeys;
import com.placecube.nhs.announcementsbanner.web.service.AnnouncementsBannerService;

@Component(immediate = true, property = { "javax.portlet.name=" + PortletKeys.ANNOUNCEMENTS_BANNER, "mvc.command.name=" + MVCCommandKeys.READ_ANNOUNCEMENT }, service = MVCResourceCommand.class)
public class DismissAnnouncementMVCResourceCommand extends BaseMVCResourceCommand {

	@Reference
	private AnnouncementsBannerService announcementsBannerService;

	@Reference
	private Portal portal;

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long announcementsEntryId = ParamUtil.getLong(resourceRequest, "announcementsEntryId");

		announcementsBannerService.markAnnouncementAsRead(portal.getHttpServletRequest(resourceRequest), themeDisplay.getUser(), announcementsEntryId);
	}

}
