package com.placecube.nhs.webcontentlisting.portlet.az;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.placecube.nhs.webcontentlisting.constants.PortletKeys;
import com.placecube.nhs.webcontentlisting.portlet.az.configuration.AZWebContentPortletInstanceConfiguration;
import com.placecube.nhs.webcontentlisting.service.WebContentListingService;

@Component(immediate = true, property = { "com.liferay.fragment.entry.processor.portlet.alias=webcontentlisting-az",
		"com.liferay.portlet.css-class-wrapper=portlet-webcontentlisting portlet-webcontentlisting-az", "com.liferay.portlet.display-category=category.nhs", "com.liferay.portlet.instanceable=false",
		"javax.portlet.resource-bundle=content.Language", "javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/az/view.jsp",
		"javax.portlet.security-role-ref=power-user,user", "javax.portlet.name=" + PortletKeys.AZ, "javax.portlet.init-param.add-process-action-success-action=false" }, service = Portlet.class)
public class AZWebContentPortlet extends MVCPortlet {

	private static final Log LOG = LogFactoryUtil.getLog(AZWebContentPortlet.class);

	@Reference
	private WebContentListingService webcontentListingService;

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

			AZWebContentPortletInstanceConfiguration azConfiguration = webcontentListingService.getAZConfiguration(themeDisplay);

			renderRequest.setAttribute("articles", webcontentListingService.getAllWebContents(themeDisplay, azConfiguration.structureKey()));
		} catch (Exception e) {
			LOG.debug(e);
			LOG.error(e.getMessage());
		}
		super.render(renderRequest, renderResponse);
	}
}