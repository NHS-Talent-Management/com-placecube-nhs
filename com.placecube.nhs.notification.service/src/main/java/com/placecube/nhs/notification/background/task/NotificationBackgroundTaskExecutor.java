package com.placecube.nhs.notification.background.task;

import java.util.Set;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskResult;
import com.liferay.portal.kernel.backgroundtask.BaseBackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.display.BackgroundTaskDisplay;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.placecube.nhs.notification.background.constants.NotificationBackgroundConstants;
import com.placecube.nhs.notification.background.service.NotificationBackgroundService;
import com.placecube.nhs.notification.constants.NotificationType;
import com.placecube.nhs.notification.model.Notification;
import com.placecube.nhs.notification.service.NotificationLocalService;

@Component(immediate = true, property = "background.task.executor.class.name=com.placecube.nhs.notification.background.task.NotificationBackgroundTaskExecutor", service = BackgroundTaskExecutor.class)
public class NotificationBackgroundTaskExecutor extends BaseBackgroundTaskExecutor {

	private static final Log LOG = LogFactoryUtil.getLog(NotificationBackgroundTaskExecutor.class);

	@Reference
	private NotificationLocalService notificationLocalService;

	@Reference
	private NotificationBackgroundService notificationBackgroundService;

	@Override
	public BackgroundTaskExecutor clone() {
		return this;
	}

	@Override
	public BackgroundTaskResult execute(BackgroundTask backgroundTask) throws Exception {
		Notification notification = getNotification(backgroundTask);

		int notificationStatus = WorkflowConstants.STATUS_INCOMPLETE;

		if (NotificationType.EMAIL.getKey() == notification.getNotificationType()) {
			notificationStatus = processEmailNotification(backgroundTask, notification);
		}

		setNotificationAsApproved(notification, notificationStatus);

		return BackgroundTaskResult.SUCCESS;
	}

	@Override
	public BackgroundTaskDisplay getBackgroundTaskDisplay(BackgroundTask backgroundTask) {
		return null;
	}

	private Notification getNotification(BackgroundTask backgroundTask) throws PortalException {
		long notificationId = GetterUtil.getLong(backgroundTask.getTaskContextMap().get(NotificationBackgroundConstants.NOTIFICATION_ID));
		return notificationLocalService.getNotification(notificationId);
	}

	private int processEmailNotification(BackgroundTask backgroundTask, Notification notification) {
		try {
			Set<User> users = notificationBackgroundService.getReceiverUserIdsForNotificationType(notification);
			notificationBackgroundService.sendEmailNotifications(backgroundTask.getCompanyId(), notification.getSummary(), notification.getBody(), users);
			return WorkflowConstants.STATUS_APPROVED;
		} catch (Exception e) {
			LOG.debug(e);
			LOG.error("Unable to process notification " + e.getMessage());
			return WorkflowConstants.STATUS_DENIED;
		}
	}

	private void setNotificationAsApproved(Notification notification, int notificationStatus) {
		notification.setStatus(notificationStatus);
		notificationLocalService.updateNotification(notification);
	}

}
