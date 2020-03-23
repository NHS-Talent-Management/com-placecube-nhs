package com.placecube.nhs.user.profile.portlet.professionalbodies;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.placecube.nhs.user.profile.constants.PortletKeys;

@Component(immediate = true, property = { "com.liferay.fragment.entry.processor.portlet.alias=user-profile-professional-bodies",
		"com.liferay.portlet.css-class-wrapper=portlet-nhs-maximized portlet-user-profile portlet-user-profile-professional-bodies", "com.liferay.portlet.display-category=category.nhs",
		"com.liferay.portlet.instanceable=false", "javax.portlet.resource-bundle=content.Language", "javax.portlet.init-param.template-path=/", "javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.name=" + PortletKeys.USER_PROFILE_PROFESSIONAL_BODIES, "javax.portlet.init-param.add-process-action-success-action=false" }, service = Portlet.class)
public class UserProfileProfessionalBodiesPortlet extends MVCPortlet {
}