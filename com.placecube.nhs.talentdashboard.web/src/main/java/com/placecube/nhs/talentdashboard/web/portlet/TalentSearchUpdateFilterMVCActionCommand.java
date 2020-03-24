package com.placecube.nhs.talentdashboard.web.portlet;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.placecube.nhs.taglibs.model.SearchFilter;
import com.placecube.nhs.talentdashboard.web.constants.MVCCommandKeys;
import com.placecube.nhs.talentdashboard.web.constants.PortletKeys;
import com.placecube.nhs.talentdashboard.web.service.TalentDashboardService;

@Component(immediate = true, property = { "javax.portlet.name=" + PortletKeys.TALENT_DASHBOARD, "mvc.command.name=" + MVCCommandKeys.UPDATE_FILTER }, service = MVCActionCommand.class)
public class TalentSearchUpdateFilterMVCActionCommand extends BaseMVCActionCommand {

	@Reference
	private TalentDashboardService talentDashboardService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		List<SearchFilter> availableFilters = talentDashboardService.getSearchFilters(actionRequest, themeDisplay.getCompany(), themeDisplay.getUser().getLocale(), true);
		talentDashboardService.updateFiltersWithSingleSelectedValue(actionRequest, availableFilters);

		actionResponse.getRenderParameters().setValue("keepFilters", "true");

		hideDefaultSuccessMessage(actionRequest);
	}

}
