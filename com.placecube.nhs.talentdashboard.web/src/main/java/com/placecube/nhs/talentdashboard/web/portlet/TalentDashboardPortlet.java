package com.placecube.nhs.talentdashboard.web.portlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.Portal;
import com.placecube.nhs.talentdashboard.web.constants.PortletKeys;

@Component(immediate = true, property = { "com.liferay.fragment.entry.processor.portlet.alias=talentdashboard", "com.liferay.portlet.css-class-wrapper=portlet-nhs-maximized portlet-talentdashboard",
		"com.liferay.portlet.display-category=category.nhs", "com.liferay.portlet.instanceable=false", "javax.portlet.resource-bundle=content.Language", "javax.portlet.init-param.template-path=/",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "javax.portlet.security-role-ref=power-user,user", "javax.portlet.name=" + PortletKeys.TALENT_DASHBOARD }, service = Portlet.class)
public class TalentDashboardPortlet extends MVCPortlet {

	@Reference
	private Portal portal;

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		try {
			renderRequest.setAttribute("webContentGroupId", portal.getCompany(renderRequest).getGroupId());
			super.render(renderRequest, renderResponse);
		} catch (Exception e) {
			throw new PortletException(e);
		}
	}
}