package com.placecube.nhs.talentdashboard.web.portlet;

import java.util.List;
import java.util.Locale;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.placecube.nhs.talentdashboard.web.constants.MVCCommandKeys;
import com.placecube.nhs.talentdashboard.web.constants.PortletKeys;
import com.placecube.nhs.talentdashboard.web.model.SearchFilter;
import com.placecube.nhs.talentdashboard.web.model.TalentSearchContext;
import com.placecube.nhs.talentdashboard.web.service.TalentDashboardService;

@Component(immediate = true, property = { "javax.portlet.name=" + PortletKeys.TALENT_DASHBOARD, "mvc.command.name=" + MVCCommandKeys.SEARCH, "mvc.command.name=/" }, service = MVCRenderCommand.class)
public class TalentDashboardMVCRenderCommand implements MVCRenderCommand {

	@Reference
	private TalentDashboardService talentDashboardService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Locale locale = themeDisplay.getLocale();

		boolean keepFilters = ParamUtil.getBoolean(renderRequest, "keepFilters", false);

		TalentSearchContext talentSearchContext = talentDashboardService.getFromSession(renderRequest, keepFilters);
		List<SearchFilter> searchFilters = talentDashboardService.getSearchFilters(renderRequest, themeDisplay.getCompany(), locale, keepFilters);

		if (talentSearchContext.isSearchExecuted()) {
			SearchContainer<User> searchContainer = talentDashboardService.getSearchContainer(renderRequest, renderResponse);
			Hits hits = talentDashboardService.executeSearch(themeDisplay, searchFilters, searchContainer.getStart(), searchContainer.getEnd());
			searchContainer.setTotal(hits.getLength());
			searchContainer.setResults(talentDashboardService.getUsersFromSearchResults(hits));
			renderRequest.setAttribute("searchContainer", searchContainer);
		}

		renderRequest.setAttribute("validationErrors", renderRequest.getAttribute("validationErrors"));
		renderRequest.setAttribute("talentSearchContext", talentSearchContext);
		renderRequest.setAttribute("availableTypes", talentDashboardService.getAvailableTypes(renderRequest, locale));
		renderRequest.setAttribute("availableCategories", talentDashboardService.getAvailableCategories(renderRequest, locale));
		renderRequest.setAttribute("availableFilters", searchFilters);

		return "/talentdashboard/view.jsp";
	}

}
