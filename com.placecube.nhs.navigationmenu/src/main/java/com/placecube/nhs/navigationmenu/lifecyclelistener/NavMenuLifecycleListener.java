package com.placecube.nhs.navigationmenu.lifecyclelistener;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.instance.lifecycle.BasePortalInstanceLifecycleListener;
import com.liferay.portal.instance.lifecycle.PortalInstanceLifecycleListener;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.service.ServiceContext;
import com.placecube.nhs.navigationmenu.constants.NavigationMenuWidgetTemplate;
import com.placecube.nhs.navigationmenu.service.NavItemTemplateService;

@Component(immediate = true, service = PortalInstanceLifecycleListener.class)
public class NavMenuLifecycleListener extends BasePortalInstanceLifecycleListener {

	private static final Log LOG = LogFactoryUtil.getLog(NavMenuLifecycleListener.class);

	@Reference
	private NavItemTemplateService navItemTemplateService;

	@Override
	public void portalInstanceRegistered(Company company) throws Exception {
		long companyId = company.getCompanyId();
		LOG.info("Initialising nav menu for companyId: " + companyId);

		ServiceContext serviceContext = navItemTemplateService.getServiceContext(company.getGroup());

		navItemTemplateService.getOrCreateWidgetTemplate(serviceContext, NavigationMenuWidgetTemplate.HEADER);

		LOG.info("Configuration finished for nav menu for companyId: " + companyId);
	}

	@Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-")
	protected void setModuleServiceLifecycle(ModuleServiceLifecycle moduleServiceLifecycle) {
		return;
	}

}
