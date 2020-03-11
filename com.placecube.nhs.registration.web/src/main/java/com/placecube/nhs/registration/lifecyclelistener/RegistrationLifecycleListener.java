package com.placecube.nhs.registration.lifecyclelistener;

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
import com.placecube.nhs.registration.constants.WebContentArticles;
import com.placecube.nhs.registration.service.RegistrationSetupService;

@Component(immediate = true, service = PortalInstanceLifecycleListener.class)
public class RegistrationLifecycleListener extends BasePortalInstanceLifecycleListener {

	private static final Log LOG = LogFactoryUtil.getLog(RegistrationLifecycleListener.class);

	@Reference
	private RegistrationSetupService registrationSetupService;

	@Override
	public void portalInstanceRegistered(Company company) throws Exception {
		long companyId = company.getCompanyId();
		LOG.info("Initialising Registration for companyId: " + companyId);

		ServiceContext serviceContext = registrationSetupService.getServiceContext(company.getGroup());

		JournalFolder journalFolder = registrationSetupService.addFolder(serviceContext);
		registrationSetupService.addArticle(WebContentArticles.REGISTRATION_CONFIRMATION_PAGE, journalFolder, serviceContext);
		registrationSetupService.addArticle(WebContentArticles.REGISTRATION_INTRO_TEXT, journalFolder, serviceContext);
		registrationSetupService.addArticle(WebContentArticles.REGISTRATION_BOTTOM_TEXT, journalFolder, serviceContext);

		LOG.info("Configuration finished for Registration for companyId: " + companyId);
	}

	@Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-")
	protected void setModuleServiceLifecycle(ModuleServiceLifecycle moduleServiceLifecycle) {
		return;
	}

}
