package com.placecube.nhs.navigationmenu.service;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.dynamic.data.mapping.model.DDMTemplate;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.NavItem;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.StringUtil;
import com.placecube.digitalplace.initializer.service.DigitalPlaceInitializer;
import com.placecube.nhs.navigationmenu.constants.NavigationMenuWidgetTemplate;

@Component(immediate = true, service = NavItemTemplateService.class)
public class NavItemTemplateService {

	@Reference
	private DigitalPlaceInitializer digitalPlaceInitializer;

	@Reference
	private Portal portal;

	public DDMTemplate getOrCreateWidgetTemplate(ServiceContext serviceContext, NavigationMenuWidgetTemplate widgetTemplate) throws PortalException {
		try {
			String script = StringUtil.read(getClass().getClassLoader(), "com/placecube/nhs/navigationmenu/dependencies/widgettemplate/" + widgetTemplate.getKey() + ".ftl");
			long classNameId = portal.getClassNameId(NavItem.class);
			return digitalPlaceInitializer.getOrCreateWidgetTemplate(classNameId, widgetTemplate.getKey(), widgetTemplate.getName(), script, serviceContext);
		} catch (Exception e) {
			throw new PortalException(e);
		}
	}

	public ServiceContext getServiceContext(Group group) throws PortalException {
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setScopeGroupId(group.getGroupId());
		serviceContext.setCompanyId(group.getCompanyId());
		serviceContext.setUserId(group.getCreatorUserId());
		serviceContext.setLanguageId(group.getDefaultLanguageId());
		return serviceContext;
	}
}
