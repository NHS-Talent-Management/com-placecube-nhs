package com.placecube.nhs.webcontent.structures.service;

import java.io.IOException;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.model.DDMTemplate;
import com.liferay.dynamic.data.mapping.service.DDMTemplateLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

@Component(immediate = true, service = ImportUtil.class)
public class ImportUtil {

	@Reference
	private DDMTemplateLocalService ddmTemplateLocalService;

	@Reference
	private Portal portal;

	public void createTemplate(ServiceContext serviceContext, String structureKey, String templateKey, long journalClassNameId, DDMStructure ddmStructure) throws IOException, PortalException {
		long structureClassNameId = portal.getClassNameId(DDMStructure.class.getName());
		DDMTemplate template = ddmTemplateLocalService.fetchTemplate(serviceContext.getScopeGroupId(), structureClassNameId, templateKey);

		if (Validator.isNull(template)) {
			Map<Locale, String> nameMap = Collections.singletonMap(serviceContext.getLocale(), templateKey);
			String script = StringUtil.read(getClass().getClassLoader(), "com/placecube/nhs/webcontent/structures/dependencies/ddm/" + structureKey + "/" + templateKey + ".ftl");

			ddmTemplateLocalService.addTemplate(serviceContext.getUserId(), serviceContext.getScopeGroupId(), structureClassNameId, ddmStructure.getStructureId(), journalClassNameId, templateKey,
					nameMap, null, "display", null, "ftl", script, true, false, StringPool.BLANK, null, serviceContext);
		}
	}
}
