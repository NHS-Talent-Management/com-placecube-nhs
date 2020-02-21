package com.placecube.nhs.template.utils;

import java.util.Optional;

import javax.portlet.PortletRequest;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.portlet.PortletURLFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;

@Component(immediate = true, service = URLService.class)
public class URLService {

	private static final Log LOG = LogFactoryUtil.getLog(URLService.class);

	static final String CREATE_ACCOUNT_MVC_RENDER_COMMAND_NAME = "/login/create_account";
	static final String LOGIN_PORTLET_KEY = "com_liferay_login_web_portlet_LoginPortlet";

	@Reference
	private PortletURLFactory portletURLFactory;

	public String getCurrentFullURL(ThemeDisplay themeDisplay) {
		Layout layout = themeDisplay.getLayout();
		String basePath = layout.isPrivateLayout() ? themeDisplay.getPathFriendlyURLPrivateGroup() : themeDisplay.getPathFriendlyURLPublic();
		return basePath + layout.getGroup().getFriendlyURL() + layout.getFriendlyURL();
	}

	public Optional<String> getRegistrationURL(HttpServletRequest httpServletRequest, ThemeDisplay themeDisplay) {
		try {
			LiferayPortletURL liferayPortletURL = portletURLFactory.create(httpServletRequest, LOGIN_PORTLET_KEY, PortletRequest.RENDER_PHASE);
			liferayPortletURL.setWindowState(WindowState.MAXIMIZED);
			liferayPortletURL.setParameter("mvcRenderCommandName", CREATE_ACCOUNT_MVC_RENDER_COMMAND_NAME);
			return Optional.of(liferayPortletURL.toString());
		} catch (Exception e) {
			LOG.debug(e);
			LOG.error("Unable to get registration url " + e.getMessage());
			return Optional.empty();
		}
	}

}
