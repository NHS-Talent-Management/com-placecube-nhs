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
import com.placecube.nhs.talentdashboard.web.model.SearchFilter;
import com.placecube.nhs.talentdashboard.web.model.TalentSearchContext;
import com.placecube.nhs.talentdashboard.web.service.TalentDashboardService;

@Component(immediate = true, property = { "javax.portlet.name=" + PortletKeys.TALENT_DASHBOARD, "mvc.command.name=" + MVCCommandKeys.SEARCH }, service = MVCActionCommand.class)
public class TalentSearchSaveMVCActionCommand extends BaseMVCActionCommand {

	@Reference
	private TalentDashboardService talentDashboardService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		Locale locale = user.getLocale();

		List<SearchFilter> availableFilters = talentDashboardService.getSearchFilters(actionRequest, themeDisplay.getCompany(), locale, true);
		talentDashboardService.configureSelectedFilterValues(actionRequest, availableFilters);

		TalentSearchContext talentSearchContext = talentDashboardService.getFromSession(actionRequest, true);
		talentDashboardService.configureTalentSearchDetails(actionRequest, talentSearchContext, availableFilters);

		if (!talentSearchContext.isSearchExecuted()) {
			Map<String, String> validationErrors = talentDashboardService.getValidationErrors(talentSearchContext, locale);
			if (validationErrors.isEmpty()) {
				talentDashboardService.saveSearch(user, talentSearchContext, availableFilters);
			} else {
				actionRequest.setAttribute("validationErrors", validationErrors);
			}
		}
		actionResponse.getRenderParameters().setValue("keepFilters", "true");
	}

}
