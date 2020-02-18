package com.placecube.nhs.webcontent.structures.service;

import java.io.IOException;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.model.DDMTemplate;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalService;
import com.liferay.dynamic.data.mapping.service.DDMTemplateLocalService;
import com.liferay.dynamic.data.mapping.util.DefaultDDMStructureHelper;
import com.liferay.journal.model.JournalArticle;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.placecube.nhs.webcontent.structures.constants.WebContentStructure;

@Component(immediate = true, service = ImportService.class)
public class ImportService {

	private static final String BASE_IMPORT_PATH = "com/placecube/nhs/webcontent/structures/dependencies/ddm/";

	@Reference
	private DefaultDDMStructureHelper defaultDDMStructureHelper;

	@Reference
	private DDMTemplateLocalService ddmTemplateLocalService;

	@Reference
	private DDMStructureLocalService ddmStructureLocalService;

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
				BASE_IMPORT_PATH + webContentStructure.getStructureKey() + "/" + webContentStructure.getStructureKey() + ".xml", serviceContext);

		DDMStructure ddmStructure = ddmStructureLocalService.getStructure(groupId, journalClassNameId, webContentStructure.getStructureKey());

		createTemplate(serviceContext, webContentStructure.getStructureKey(), webContentStructure.getFullDisplayTemplateKey(), journalClassNameId, ddmStructure);
		createTemplate(serviceContext, webContentStructure.getStructureKey(), webContentStructure.getListingTemplateKey(), journalClassNameId, ddmStructure);
	}

	private void createTemplate(ServiceContext serviceContext, String structureKey, String templateKey, long journalClassNameId, DDMStructure ddmStructure) throws IOException, PortalException {
		long structureClassNameId = portal.getClassNameId(DDMStructure.class.getName());
		DDMTemplate template = ddmTemplateLocalService.fetchTemplate(serviceContext.getScopeGroupId(), structureClassNameId, templateKey);

		if (Validator.isNull(template)) {
			Map<Locale, String> nameMap = Collections.singletonMap(serviceContext.getLocale(), templateKey);
			String script = StringUtil.read(getClass().getClassLoader(), BASE_IMPORT_PATH + structureKey + "/" + templateKey + ".ftl");

			ddmTemplateLocalService.addTemplate(serviceContext.getUserId(), serviceContext.getScopeGroupId(), structureClassNameId, ddmStructure.getStructureId(), journalClassNameId, templateKey,
					nameMap, null, "display", null, "ftl", script, true, false, StringPool.BLANK, null, serviceContext);
		}
	}
}
