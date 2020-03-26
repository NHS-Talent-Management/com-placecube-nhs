package com.placecube.nhs.setup.lifecyclelistener;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.instance.lifecycle.BasePortalInstanceLifecycleListener;
import com.liferay.portal.instance.lifecycle.PortalInstanceLifecycleListener;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.service.ServiceContext;
import com.placecube.nhs.setup.constants.WebContentArticles;
import com.placecube.nhs.setup.service.WebContentSetupService;

@Component(immediate = true, service = PortalInstanceLifecycleListener.class)
public class SetupLifecycleListener extends BasePortalInstanceLifecycleListener {

	private static final Log LOG = LogFactoryUtil.getLog(SetupLifecycleListener.class);

	@Reference
	private WebContentSetupService webContentSetupService;

	@Override
	public void portalInstanceRegistered(Company company) throws Exception {
		long companyId = company.getCompanyId();
		LOG.info("Initialising setup for companyId: " + companyId);

		ServiceContext serviceContext = webContentSetupService.getServiceContext(company.getGroup());

		webContentSetupService.addArticle(WebContentArticles.FOOTER, serviceContext);

		LOG.info("Configuration finished for setup for companyId: " + companyId);
	}

	@Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-")
	protected void setModuleServiceLifecycle(ModuleServiceLifecycle moduleServiceLifecycle) {
		return;
	}

}
