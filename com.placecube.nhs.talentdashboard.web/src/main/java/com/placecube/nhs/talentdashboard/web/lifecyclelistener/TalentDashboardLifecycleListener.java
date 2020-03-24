package com.placecube.nhs.talentdashboard.web.lifecyclelistener;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.journal.model.JournalFolder;
import com.liferay.portal.instance.lifecycle.BasePortalInstanceLifecycleListener;
import com.liferay.portal.instance.lifecycle.PortalInstanceLifecycleListener;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.service.ServiceContext;
import com.placecube.nhs.talentdashboard.web.constants.WebContentArticles;
import com.placecube.nhs.talentdashboard.web.service.TalentDashboardWebcontentService;

@Component(immediate = true, service = PortalInstanceLifecycleListener.class)
public class TalentDashboardLifecycleListener extends BasePortalInstanceLifecycleListener {

	private static final Log LOG = LogFactoryUtil.getLog(TalentDashboardLifecycleListener.class);

	@Reference
	private TalentDashboardWebcontentService talentDashboardWebContentService;

	@Override
	public void portalInstanceRegistered(Company company) throws Exception {
		long companyId = company.getCompanyId();
		LOG.info("Initialising Talent Dashboard for companyId: " + companyId);

		ServiceContext serviceContext = talentDashboardWebContentService.getServiceContext(company.getGroup());

		JournalFolder journalFolder = talentDashboardWebContentService.addFolder(serviceContext);
		talentDashboardWebContentService.addArticle(WebContentArticles.TALENT_DASHBOARD_FILTERS_TEXT, journalFolder, serviceContext);
		talentDashboardWebContentService.addArticle(WebContentArticles.TALENT_DASHBOARD_INTRO_TEXT, journalFolder, serviceContext);
		talentDashboardWebContentService.addArticle(WebContentArticles.TALENT_DASHBOARD_NUDGE_TEXT, journalFolder, serviceContext);

		LOG.info("Configuration finished for Talent Dashboard for companyId: " + companyId);
	}

	@Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-")
	protected void setModuleServiceLifecycle(ModuleServiceLifecycle moduleServiceLifecycle) {
		return;
	}

}
