package com.placecube.nhs.readiness.web.portlet.questionnaire;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.placecube.nhs.readiness.web.constants.PortletKeys;

@Component(immediate = true, property = { "com.liferay.portlet.add-default-resource=true", "com.liferay.fragment.entry.processor.portlet.alias=profilereadiness-view",
		"com.liferay.portlet.css-class-wrapper=portlet-profilereadiness portlet-profilereadiness-view", "com.liferay.portlet.display-category=category.nhs", "com.liferay.portlet.instanceable=false",
		"javax.portlet.resource-bundle=content.Language", "javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/", "javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.name=" + PortletKeys.READINESS_QUESTIONNAIRE, "javax.portlet.init-param.add-process-action-success-action=false" }, service = Portlet.class)
public class ReadinessQuestionnairePortlet extends MVCPortlet {

}