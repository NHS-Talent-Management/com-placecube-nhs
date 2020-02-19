package com.placecube.nhs.template.utils;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.theme.ThemeDisplay;

@Component(immediate = true, service = URLService.class)
public class URLService {

	public String getCurrentFullURL(ThemeDisplay themeDisplay) {
		Layout layout = themeDisplay.getLayout();
		return layout.isPrivateLayout() ? themeDisplay.getPathFriendlyURLPrivateGroup() : themeDisplay.getPathFriendlyURLPublic() + layout.getGroup().getFriendlyURL() + layout.getFriendlyURL();
	}

}
