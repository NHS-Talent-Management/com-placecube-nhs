package com.placecube.nhs.notification.lifecyclelistener;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.journal.model.JournalFolder;
import com.liferay.portal.instance.lifecycle.BasePortalInstanceLifecycleListener;
import com.liferay.portal.instance.lifecycle.PortalInstanceLifecycleListener;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.service.ServiceContext;
import com.placecube.nhs.notification.background.constants.NotificationBackgroundConstants;
import com.placecube.nhs.notification.background.service.NotificationBackgroundService;

@Component(immediate = true, service = PortalInstanceLifecycleListener.class)
public class NotificationLifecycleListener extends BasePortalInstanceLifecycleListener {

	private static final Log LOG = LogFactoryUtil.getLog(NotificationLifecycleListener.class);

	@Reference
	private NotificationBackgroundService notificationBackgroundService;

	@Override
	public void portalInstanceRegistered(Company company) throws Exception {
		long companyId = company.getCompanyId();
		LOG.info("Initialising Notifications for companyId: " + companyId);

		ServiceContext serviceContext = notificationBackgroundService.getServiceContext(company.getGroup());

		JournalFolder journalFolder = notificationBackgroundService.addFolder(serviceContext);
		notificationBackgroundService.addArticle(NotificationBackgroundConstants.NOTIFICATION_EMAIL_WEBCONTENT_ID, journalFolder, serviceContext);

		LOG.info("Configuration finished for Notifications for companyId: " + companyId);
	}

	@Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-")
	protected void setModuleServiceLifecycle(ModuleServiceLifecycle moduleServiceLifecycle) {
		return;
	}

}
