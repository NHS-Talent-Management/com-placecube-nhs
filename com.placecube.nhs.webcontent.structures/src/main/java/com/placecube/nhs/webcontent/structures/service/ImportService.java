package com.placecube.nhs.webcontent.structures.service;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalService;
import com.liferay.dynamic.data.mapping.util.DefaultDDMStructureHelper;
import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Portal;
import com.placecube.nhs.webcontent.structures.constants.WebContentStructure;

@Component(immediate = true, service = ImportService.class)
public class ImportService {

	@Reference
	private DefaultDDMStructureHelper defaultDDMStructureHelper;

	@Reference
	private DDMStructureLocalService ddmStructureLocalService;

	@Reference
	private ImportUtil importUtil;

	@Reference
	private Portal portal;

	public ServiceContext getServiceContext(Group group) {
		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setAddGroupPermissions(true);
		serviceContext.setAddGuestPermissions(true);
		serviceContext.setCompanyId(group.getCompanyId());
		serviceContext.setLanguageId(group.getDefaultLanguageId());
		serviceContext.setScopeGroupId(group.getGroupId());
		serviceContext.setUserId(group.getCreatorUserId());

		return serviceContext;
	}

	public void addStructureAndTemplates(ServiceContext serviceContext, WebContentStructure webContentStructure) throws Exception {
		long journalClassNameId = portal.getClassNameId(JournalArticle.class);

		long groupId = serviceContext.getScopeGroupId();

		defaultDDMStructureHelper.addDDMStructures(serviceContext.getUserId(), groupId, journalClassNameId, getClass().getClassLoader(),
				"com/placecube/nhs/webcontent/structures/dependencies/ddm/" + webContentStructure.getStructureKey() + "/" + webContentStructure.getStructureKey() + ".xml", serviceContext);

		DDMStructure ddmStructure = ddmStructureLocalService.getStructure(groupId, journalClassNameId, webContentStructure.getStructureKey());

		importUtil.createTemplate(serviceContext, webContentStructure.getStructureKey(), webContentStructure.getFullDisplayTemplateKey(), journalClassNameId, ddmStructure);
		importUtil.createTemplate(serviceContext, webContentStructure.getStructureKey(), webContentStructure.getListingTemplateKey(), journalClassNameId, ddmStructure);
	}

}
