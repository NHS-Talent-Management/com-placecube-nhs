package com.placecube.nhs.talentdashboard.web.portlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.placecube.nhs.talentdashboard.web.constants.PortletKeys;

@Component(immediate = true, property = { "com.liferay.fragment.entry.processor.portlet.alias=talentdashboard", "com.liferay.portlet.css-class-wrapper=portlet-talentdashboard",
		"com.liferay.portlet.display-category=category.nhs", "com.liferay.portlet.instanceable=false", "javax.portlet.resource-bundle=content.Language", "javax.portlet.init-param.template-path=/",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "javax.portlet.security-role-ref=power-user,user", "javax.portlet.name=" + PortletKeys.TALENT_DASHBOARD,
		"javax.portlet.init-param.add-process-action-success-action=false" }, service = Portlet.class)
public class TalentDashboardPortlet extends MVCPortlet {

}