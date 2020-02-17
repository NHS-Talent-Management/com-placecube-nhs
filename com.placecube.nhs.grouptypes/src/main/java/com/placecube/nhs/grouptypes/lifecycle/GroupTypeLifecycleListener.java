package com.placecube.nhs.grouptypes.lifecycle;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.instance.lifecycle.BasePortalInstanceLifecycleListener;
import com.liferay.portal.instance.lifecycle.PortalInstanceLifecycleListener;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.pfiks.expando.creator.ExpandoColumnCreator;

@Component(immediate = true, service = PortalInstanceLifecycleListener.class)
public class GroupTypeLifecycleListener extends BasePortalInstanceLifecycleListener {

	@Reference(target = "(expandocolumn.creator=group.grouptype)")
	private ExpandoColumnCreator expandoColumnCreator;

	@Override
	public void portalInstanceRegistered(Company company) throws Exception {
		expandoColumnCreator.create(company);
	}

	@Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-")
	protected void setModuleServiceLifecycle(ModuleServiceLifecycle moduleServiceLifecycle) {
		return;
	}

}
