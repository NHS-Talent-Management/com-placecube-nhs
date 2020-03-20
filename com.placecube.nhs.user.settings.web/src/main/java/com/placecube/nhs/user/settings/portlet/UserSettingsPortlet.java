package com.placecube.nhs.user.settings.portlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.placecube.nhs.user.settings.constants.PortletKeys;

@Component(immediate = true, property = { "com.liferay.fragment.entry.processor.portlet.alias=user-privacy", "com.liferay.portlet.css-class-wrapper=portlet-user-profile portlet-user-settings",
		"com.liferay.portlet.display-category=category.nhs", "com.liferay.portlet.instanceable=false", "javax.portlet.resource-bundle=content.Language", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.security-role-ref=power-user,user", "javax.portlet.name=" + PortletKeys.USER_SETTINGS, }, service = Portlet.class)
public class UserSettingsPortlet extends MVCPortlet {
}
