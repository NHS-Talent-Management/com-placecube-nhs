package com.placecube.nhs.talentdashboard.web.portlet;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.placecube.nhs.talentdashboard.web.constants.MVCCommandKeys;
import com.placecube.nhs.talentdashboard.web.constants.PortletKeys;
import com.placecube.nhs.talentdashboard.web.service.TalentDashboardService;

@Component(immediate = true, property = { "javax.portlet.name=" + PortletKeys.TALENT_DASHBOARD, "mvc.command.name=" + MVCCommandKeys.SEND_NUDGE, }, service = MVCRenderCommand.class)
public class SendNudgeMVCRenderCommand implements MVCRenderCommand {

	@Reference
	private TalentDashboardService talentDashboardService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		renderRequest.setAttribute("availableFilters", talentDashboardService.getSearchFilters(renderRequest, themeDisplay.getCompany(), themeDisplay.getLocale(), true));
		renderRequest.setAttribute("nudgeNotification", talentDashboardService.getNudgeNotification(renderRequest));
		renderRequest.setAttribute("validationErrors", renderRequest.getAttribute("validationErrors"));

		return "/talentdashboard/send-nudge.jsp";
	}

}