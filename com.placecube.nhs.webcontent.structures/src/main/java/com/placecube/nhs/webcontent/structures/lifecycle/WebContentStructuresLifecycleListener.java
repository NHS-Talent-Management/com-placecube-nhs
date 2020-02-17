package com.placecube.nhs.webcontent.structures.lifecycle;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.instance.lifecycle.BasePortalInstanceLifecycleListener;
import com.liferay.portal.instance.lifecycle.PortalInstanceLifecycleListener;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.service.ServiceContext;
import com.placecube.nhs.webcontent.structures.constants.WebContentStructure;
import com.placecube.nhs.webcontent.structures.service.ImportService;

@Component(immediate = true, service = PortalInstanceLifecycleListener.class)
public class WebContentStructuresLifecycleListener extends BasePortalInstanceLifecycleListener {

	@Reference
	private ImportService importService;

	@Override
	public void portalInstanceRegistered(Company company) throws Exception {
		Group globalGroup = company.getGroup();

		ServiceContext serviceContext = importService.getServiceContext(globalGroup);

		importService.addStructureAndTemplates(serviceContext, WebContentStructure.COURSE);
	}

	@Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-")
	protected void setModuleServiceLifecycle(ModuleServiceLifecycle moduleServiceLifecycle) {
		return;
	}

}
