package com.placecube.nhs.talentdashboard.web.portlet;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.placecube.nhs.talentdashboard.web.constants.MVCCommandKeys;
import com.placecube.nhs.talentdashboard.web.constants.PortletKeys;
import com.placecube.nhs.talentdashboard.web.model.NudgeNotification;
import com.placecube.nhs.talentdashboard.web.model.SearchFilter;
import com.placecube.nhs.talentdashboard.web.service.TalentDashboardService;
import com.placecube.nhs.talentdashboard.web.service.ValidationService;

@Component(immediate = true, property = { "javax.portlet.name=" + PortletKeys.TALENT_DASHBOARD, "mvc.command.name=" + MVCCommandKeys.SEND_NUDGE }, service = MVCActionCommand.class)
public class SendNudgeMVCActionCommand extends BaseMVCActionCommand {

	@Reference
	private TalentDashboardService talentDashboardService;

	@Reference
	private ValidationService validationService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		Locale locale = user.getLocale();

		NudgeNotification nudgeNotification = talentDashboardService.getNudgeNotification(actionRequest);
		talentDashboardService.updateNudgeNotificationWithSelectedValues(actionRequest, nudgeNotification);

		Map<String, String> validationErrors = validationService.getValidationErrors(nudgeNotification, locale);

		if (validationErrors.isEmpty()) {
			List<SearchFilter> searchFilters = talentDashboardService.getSearchFilters(actionRequest, themeDisplay.getCompany(), locale, true);
			List<Long> userIds = talentDashboardService.executeSearchForUserIds(themeDisplay, searchFilters);
			talentDashboardService.createEmailNotification(user, nudgeNotification, userIds);
			actionResponse.getRenderParameters().setValue("keepFilters", "true");
		} else {
			actionRequest.setAttribute("validationErrors", validationErrors);
			actionRequest.setAttribute("nudgeNotification", nudgeNotification);
			actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandKeys.SEND_NUDGE);
		}
	}

}
