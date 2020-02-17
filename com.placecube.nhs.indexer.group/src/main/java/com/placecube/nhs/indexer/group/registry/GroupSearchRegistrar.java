package com.placecube.nhs.indexer.group.registry;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchRegistrarHelper;

@Component(immediate = true, service = {})
public class GroupSearchRegistrar {

	@Reference(target = "(indexer.class.name=com.liferay.portal.kernel.model.Group)")
	private ModelIndexerWriterContributor<Group> modelIndexWriterContributor;

	@Reference
	private ModelSearchRegistrarHelper modelSearchRegistrarHelper;

	private ServiceRegistration<?> serviceRegistration;

	@Activate
	protected void activate(BundleContext bundleContext) {
		serviceRegistration = modelSearchRegistrarHelper.register(Group.class, bundleContext, modelSearchDefinition -> {
			modelSearchDefinition.setDefaultSelectedFieldNames(Field.ASSET_TAG_NAMES, Field.COMPANY_ID, Field.CONTENT, Field.GROUP_ID, Field.URL, Field.ASSET_CATEGORY_IDS, Field.TITLE, Field.UID);
			modelSearchDefinition.setDefaultSelectedLocalizedFieldNames(Field.CONTENT, Field.TITLE);
			modelSearchDefinition.setModelIndexWriteContributor(modelIndexWriterContributor);
		});
	}

	@Deactivate
	protected void deactivate() {
		serviceRegistration.unregister();
	}

}