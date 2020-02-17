package com.placecube.nhs.testdata.lifecycle;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.portal.instance.lifecycle.BasePortalInstanceLifecycleListener;
import com.liferay.portal.instance.lifecycle.PortalInstanceLifecycleListener;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.service.ServiceContext;
import com.pfiks.expando.creator.ExpandoColumnCreator;
import com.placecube.nhs.testdata.service.TestDataImportService;

@Component(immediate = true, service = PortalInstanceLifecycleListener.class)
public class TestDataLifecycleListener extends BasePortalInstanceLifecycleListener {

	@Reference
	private TestDataImportService testDataImportService;

	@Reference(target = "(expandocolumn.creator=group.grouptype)")
	private ExpandoColumnCreator expandoColumnCreator;

	@Override
	public void portalInstanceRegistered(Company company) throws Exception {
		Group globalGroup = company.getGroup();

		expandoColumnCreator.create(company);

		ServiceContext serviceContext = testDataImportService.getServiceContext(globalGroup);

		AssetVocabulary assetVocabulary = testDataImportService.importAssetVocabulary(serviceContext);
		testDataImportService.importGroups(serviceContext, assetVocabulary);
	}

	@Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-")
	protected void setModuleServiceLifecycle(ModuleServiceLifecycle moduleServiceLifecycle) {
		return;
	}

}
