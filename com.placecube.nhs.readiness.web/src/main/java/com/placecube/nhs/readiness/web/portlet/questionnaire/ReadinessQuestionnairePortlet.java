package com.placecube.nhs.readiness.web.portlet.questionnaire;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.placecube.nhs.readiness.web.constants.PortletKeys;

@Component(immediate = true, property = { "com.liferay.portlet.add-default-resource=true", "com.liferay.fragment.entry.processor.portlet.alias=profilereadiness-view",
		"com.liferay.portlet.css-class-wrapper=portlet-profilereadiness portlet-profilereadiness-view", "com.liferay.portlet.display-category=category.nhs", "com.liferay.portlet.instanceable=false",
		"javax.portlet.resource-bundle=content.Language", "javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/", "javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.name=" + PortletKeys.READINESS_QUESTIONNAIRE, "javax.portlet.init-param.add-process-action-success-action=false" }, service = Portlet.class)
public class ReadinessQuestionnairePortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		if (!themeDisplay.isSignedIn()) {
			throw new PortletException(new PrincipalException());
		}

		super.render(renderRequest, renderResponse);
	}
}