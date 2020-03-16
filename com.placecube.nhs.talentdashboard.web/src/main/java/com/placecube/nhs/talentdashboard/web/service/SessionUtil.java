package com.placecube.nhs.talentdashboard.web.service;

import java.util.LinkedList;
import java.util.List;

import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.util.Validator;
import com.placecube.nhs.talentdashboard.web.model.SearchFilter;
import com.placecube.nhs.talentdashboard.web.model.TalentSearchContext;

@Component(immediate = true, service = SessionUtil.class)
public class SessionUtil {

	private static final String SESSION_AVAILABLE_FILTERS = "sessionAvailableFilters";
	private static final String SESSION_TALENT_DASHBOARD_CONTEXT = "sessionTalentDashboardContext";

	@SuppressWarnings("unchecked")
	public List<SearchFilter> getSearchFiltersFromSession(PortletRequest portletRequest, boolean readFromSession) {
		if (!readFromSession) {
			return new LinkedList<>();
		}

		List<SearchFilter> results = (List<SearchFilter>) portletRequest.getPortletSession().getAttribute(SESSION_AVAILABLE_FILTERS);
		return Validator.isNull(results) ? new LinkedList<>() : results;
	}

	public TalentSearchContext getTalentSearchContextFromSession(PortletRequest portletRequest, boolean readFromSession) {
		if (!readFromSession) {
			return new TalentSearchContext();
		}

		TalentSearchContext talentSearchContext = (TalentSearchContext) portletRequest.getPortletSession().getAttribute(SESSION_TALENT_DASHBOARD_CONTEXT);
		return Validator.isNull(talentSearchContext) ? new TalentSearchContext() : talentSearchContext;
	}

	public void saveSearchFiltersInSession(PortletRequest portletRequest, List<SearchFilter> searchFilters) {
		searchFilters.sort((o1, o2) -> o1.getFieldLabel().compareTo(o2.getFieldLabel()));
		portletRequest.getPortletSession().setAttribute(SESSION_AVAILABLE_FILTERS, searchFilters);
	}

	public void saveTalentSearchInSession(PortletRequest portletRequest, TalentSearchContext talentSearchContext) {
		portletRequest.getPortletSession().setAttribute(SESSION_TALENT_DASHBOARD_CONTEXT, talentSearchContext);
	}

}
