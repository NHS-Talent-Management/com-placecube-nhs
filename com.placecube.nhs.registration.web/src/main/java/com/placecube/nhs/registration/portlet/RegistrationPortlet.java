package com.placecube.nhs.registration.portlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.util.Portal;
import com.placecube.nhs.registration.constants.PortletKeys;
import com.placecube.nhs.registration.service.RegistrationService;

@Component(immediate = true, property = { "com.liferay.fragment.entry.processor.portlet.alias=registration", "com.liferay.portlet.css-class-wrapper=portlet-registration",
		"com.liferay.portlet.display-category=category.nhs", "com.liferay.portlet.instanceable=false", "javax.portlet.resource-bundle=content.Language", "javax.portlet.init-param.template-path=/",
		"javax.portlet.security-role-ref=power-user,user", "javax.portlet.name=" + PortletKeys.REGISTRATION,
		"javax.portlet.init-param.add-process-action-success-action=false" }, service = Portlet.class)
public class RegistrationPortlet extends MVCPortlet {

	@Reference
	private GroupLocalService groupLocalService;

	@Reference
	private Portal portal;

	@Reference
	private RegistrationService registrationService;

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		registrationService.checkAccountCreationEnabled(renderRequest);

		try {
			Group group = groupLocalService.getGroup(portal.getCompanyId(renderRequest), GroupConstants.GUEST);
			renderRequest.setAttribute("webContentGroupId", group.getGroupId());
			super.render(renderRequest, renderResponse);
		} catch (Exception e) {
			throw new PortletException(e);
		}
	}
}