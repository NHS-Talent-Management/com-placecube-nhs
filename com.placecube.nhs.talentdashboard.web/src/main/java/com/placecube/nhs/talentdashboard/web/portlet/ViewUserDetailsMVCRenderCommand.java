package com.placecube.nhs.talentdashboard.web.portlet;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.placecube.nhs.talentdashboard.web.constants.MVCCommandKeys;
import com.placecube.nhs.talentdashboard.web.constants.PortletKeys;
import com.placecube.nhs.talentdashboard.web.service.TalentDashboardService;

@Component(immediate = true, property = { "javax.portlet.name=" + PortletKeys.TALENT_DASHBOARD, "mvc.command.name=" + MVCCommandKeys.USER_DETAILS, }, service = MVCRenderCommand.class)
public class ViewUserDetailsMVCRenderCommand implements MVCRenderCommand {

	@Reference
	private TalentDashboardService talentDashboardService;

	@Reference
	private UserLocalService userLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long userId = ParamUtil.getLong(renderRequest, "userId");
			renderRequest.setAttribute("userResult", userLocalService.getUser(userId));
			renderRequest.setAttribute("availableFilters", talentDashboardService.getSearchFilters(renderRequest, themeDisplay.getCompany(), themeDisplay.getLocale(), true));
			return "/talentdashboard/user-details.jsp";
		} catch (Exception e) {
			throw new PortletException(e);
		}
	}

}