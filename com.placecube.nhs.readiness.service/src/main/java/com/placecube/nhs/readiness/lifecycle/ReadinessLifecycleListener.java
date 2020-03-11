package com.placecube.nhs.readiness.lifecycle;

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
import com.placecube.nhs.readiness.constants.WebContentArticles;
import com.placecube.nhs.readiness.service.impl.ReadinessWebContentService;

@Component(immediate = true, service = PortalInstanceLifecycleListener.class)
public class ReadinessLifecycleListener extends BasePortalInstanceLifecycleListener {

	private static final Log LOG = LogFactoryUtil.getLog(ReadinessLifecycleListener.class);

	@Reference
	private ReadinessWebContentService readinessWebContentService;

	@Override
	public void portalInstanceRegistered(Company company) throws Exception {
		long companyId = company.getCompanyId();
		LOG.info("Initialising Readiness questionnaire for companyId: " + companyId);

		ServiceContext serviceContext = readinessWebContentService.getServiceContext(company.getGroup());

		JournalFolder journalFolder = readinessWebContentService.addFolder(serviceContext);
		readinessWebContentService.addArticle(WebContentArticles.READINESS_QUESTIONNAIRE_INTRO, journalFolder, serviceContext);
		readinessWebContentService.addArticle(WebContentArticles.READINESS_QUESTIONNAIRE_COMPLETED, journalFolder, serviceContext);

		LOG.info("Configuration finished for Readiness questionnaire for companyId: " + companyId);
	}

	@Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-")
	protected void setModuleServiceLifecycle(ModuleServiceLifecycle moduleServiceLifecycle) {
		return;
	}

}
