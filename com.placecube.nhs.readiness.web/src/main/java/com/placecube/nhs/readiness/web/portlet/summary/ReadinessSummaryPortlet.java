package com.placecube.nhs.readiness.web.portlet.summary;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.placecube.nhs.readiness.service.ReadinessService;
import com.placecube.nhs.readiness.web.constants.PortletKeys;

@Component(immediate = true, property = { "com.liferay.fragment.entry.processor.portlet.alias=profilereadiness-view",
		"com.liferay.portlet.css-class-wrapper=portlet-profilereadiness portlet-profilereadiness-view", "com.liferay.portlet.display-category=category.nhs", "com.liferay.portlet.instanceable=false",
		"javax.portlet.resource-bundle=content.Language", "javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/readiness-summary/view.jsp",
		"javax.portlet.security-role-ref=power-user,user", "javax.portlet.name=" + PortletKeys.READINESS_SUMMARY,
		"javax.portlet.init-param.add-process-action-success-action=false" }, service = Portlet.class)
public class ReadinessSummaryPortlet extends MVCPortlet {

	@Reference
	private ReadinessService readinessService;

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		if (themeDisplay.isSignedIn()) {
			addQuestions(renderRequest, themeDisplay);
		} else {
			throw new PortletException("Must be signed in");
		}

		super.render(renderRequest, renderResponse);
	}

	private void addQuestions(RenderRequest renderRequest, ThemeDisplay themeDisplay) throws PortletException {
		try {
			renderRequest.setAttribute("questions", readinessService.getQuestions(themeDisplay.getUser()));
		} catch (Exception e) {
			throw new PortletException(e);
		}
	}
}