package com.placecube.nhs.user.expando.lifecycle;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.instance.lifecycle.BasePortalInstanceLifecycleListener;
import com.liferay.portal.instance.lifecycle.PortalInstanceLifecycleListener;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.pfiks.expando.creator.ExpandoColumnCreator;

@Component(immediate = true, service = PortalInstanceLifecycleListener.class)
public class UserExpandoLifecycleListener extends BasePortalInstanceLifecycleListener {

	@Reference(target = "(expandocolumn.creator=user.environment)")
	private ExpandoColumnCreator environmentExpandoColumnCreator;

	@Reference(target = "(expandocolumn.creator=user.goal)")
	private ExpandoColumnCreator goalExpandoColumnCreator;

	@Reference(target = "(expandocolumn.creator=user.location)")
	private ExpandoColumnCreator locationExpandoColumnCreator;

	@Reference(target = "(expandocolumn.creator=user.pay-scale)")
	private ExpandoColumnCreator payScaleExpandoColumnCreator;

	@Reference(target = "(expandocolumn.creator=user.professional-area)")
	private ExpandoColumnCreator professionalAreaExpandoColumnCreator;

	@Reference(target = "(expandocolumn.creator=user.readiness)")
	private ExpandoColumnCreator readinessExpandoColumnCreator;

	@Override
	public void portalInstanceRegistered(Company company) throws Exception {
		environmentExpandoColumnCreator.create(company);
		goalExpandoColumnCreator.create(company);
		locationExpandoColumnCreator.create(company);
		payScaleExpandoColumnCreator.create(company);
		professionalAreaExpandoColumnCreator.create(company);
		readinessExpandoColumnCreator.create(company);
	}

	@Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-")
	protected void setModuleServiceLifecycle(ModuleServiceLifecycle moduleServiceLifecycle) {
		return;
	}

}
