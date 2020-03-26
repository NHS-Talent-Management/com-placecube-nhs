package com.placecube.nhs.user.profile.lifecyclelistener;

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
import com.placecube.nhs.user.profile.constants.WebContentArticles;
import com.placecube.nhs.user.profile.service.WebContentService;

@Component(immediate = true, service = PortalInstanceLifecycleListener.class)
public class ProfileLifecycleListener extends BasePortalInstanceLifecycleListener {

	private static final Log LOG = LogFactoryUtil.getLog(ProfileLifecycleListener.class);

	@Reference
	private WebContentService webContentService;

	@Override
	public void portalInstanceRegistered(Company company) throws Exception {
		long companyId = company.getCompanyId();
		LOG.info("Initialising profile for companyId: " + companyId);

		ServiceContext serviceContext = webContentService.getServiceContext(company.getGroup());

		JournalFolder journalFolder = webContentService.addFolder(serviceContext);

		webContentService.addArticle(WebContentArticles.EXPERIENCE, journalFolder, serviceContext);
		webContentService.addArticle(WebContentArticles.PROFESSIONAL_BODY, journalFolder, serviceContext);
		webContentService.addArticle(WebContentArticles.PROFILE_DETAILS, journalFolder, serviceContext);
		webContentService.addArticle(WebContentArticles.QUALIFICATION, journalFolder, serviceContext);

		LOG.info("Configuration finished for profile for companyId: " + companyId);
	}

	@Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-")
	protected void setModuleServiceLifecycle(ModuleServiceLifecycle moduleServiceLifecycle) {
		return;
	}

}
