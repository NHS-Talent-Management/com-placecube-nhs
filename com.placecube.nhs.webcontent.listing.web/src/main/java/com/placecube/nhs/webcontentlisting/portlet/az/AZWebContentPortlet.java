package com.placecube.nhs.webcontentlisting.portlet.az;

import java.io.IOException;
import java.util.Optional;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Portal;
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
	private Portal portal;

	@Reference
	private WebContentListingService webcontentListingService;

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

			AZWebContentPortletInstanceConfiguration configuration = webcontentListingService.getAZConfiguration(themeDisplay, false);

			String currentPageURL = portal.getLayoutFullURL(themeDisplay.getLayout(), themeDisplay);

			Optional<BooleanClause<Query>> queryOnMatchingCategories = webcontentListingService.getQueryOnMatchingCategories(themeDisplay.getCompanyId(), configuration.matchingCategories(),
					themeDisplay.getScopeGroupId());

			renderRequest.setAttribute("articles", webcontentListingService.getAllWebContents(themeDisplay, currentPageURL, configuration.structureKey(), queryOnMatchingCategories));
		} catch (ConfigurationException e) {
			LOG.debug(e);
			renderRequest.setAttribute("invalidConfiguration", true);
		} catch (Exception e) {
			throw new PortletException(e);
		}
		super.render(renderRequest, renderResponse);
	}
}