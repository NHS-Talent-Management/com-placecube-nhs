package com.placecube.nhs.announcementsbanner.web.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.announcements.kernel.model.AnnouncementsEntry;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import com.placecube.nhs.announcementsbanner.web.constants.PortletKeys;
import com.placecube.nhs.announcementsbanner.web.service.AnnouncementsBannerService;

@Component(immediate = true, property = { "com.liferay.portlet.css-class-wrapper=portlet-announcements-banner", "com.liferay.portlet.header-portlet-javascript=/js/announcements-banner.js",
		"com.liferay.portlet.add-default-resource=true", "com.liferay.portlet.display-category=category.hidden", "com.liferay.portlet.instanceable=false", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/announcements-banner/view.jsp", "javax.portlet.name=" + PortletKeys.ANNOUNCEMENTS_BANNER, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user", "javax.portlet.supports.mime-type=text/html" }, service = Portlet.class)
public class AnnouncementsBannerPortlet extends MVCPortlet {

	@Reference
	private AnnouncementsBannerService announcementsBannerService;

	@Reference
	private Portal portal;

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		List<AnnouncementsEntry> entries = announcementsBannerService.getUnreadAnnouncements(portal.getHttpServletRequest(renderRequest), themeDisplay.getUser());
		if (entries.isEmpty()) {
			renderRequest.setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.TRUE);
		} else {
			renderRequest.setAttribute("announcements", entries);
		}

		super.render(renderRequest, renderResponse);
	}

}