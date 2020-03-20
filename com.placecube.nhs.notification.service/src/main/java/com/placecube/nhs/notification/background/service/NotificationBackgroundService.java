package com.placecube.nhs.notification.background.service;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalFolder;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.background.task.service.BackgroundTaskLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.CompanyConstants;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.StringUtil;
import com.pfiks.mail.service.MailService;
import com.placecube.digitalplace.journal.service.JournalArticleCreationService;
import com.placecube.nhs.notification.background.constants.NotificationBackgroundConstants;
import com.placecube.nhs.notification.background.task.NotificationBackgroundTaskExecutor;
import com.placecube.nhs.notification.constants.NotificationType;
import com.placecube.nhs.notification.model.Notification;
import com.placecube.nhs.notification.service.UserNotificationPreferenceLocalService;

@Component(immediate = true, service = NotificationBackgroundService.class)
public class NotificationBackgroundService {

	private static final Log LOG = LogFactoryUtil.getLog(NotificationBackgroundService.class);

	@Reference
	private BackgroundTaskLocalService backgroundTaskLocalService;

	@Reference
	private CompanyLocalService companyLocalService;

	@Reference
	private JournalArticleCreationService journalArticleCreationService;

	@Reference
	private JournalArticleLocalService journalArticleLocalService;

	@Reference
	private MailService mailService;

	@Reference
	private UserLocalService userLocalService;

	@Reference
	private UserNotificationPreferenceLocalService userNotificationPreferenceLocalService;

	public void addArticle(String webContentId, JournalFolder journalFolder, ServiceContext serviceContext) throws PortalException {
		try {
			String articleContent = StringUtil.read(getClass().getClassLoader(), "com/placecube/nhs/notification/service/dependencies/webcontent/" + webContentId + ".xml");
			journalArticleCreationService.getOrCreateBasicWebContentArticle(webContentId, webContentId, articleContent, journalFolder, serviceContext);
		} catch (Exception e) {
			throw new PortalException(e);
		}
	}

	public JournalFolder addFolder(ServiceContext serviceContext) throws PortalException {
		return journalArticleCreationService.getOrCreateJournalFolder("Notifications", serviceContext);
	}

	public void createBackgroundTask(User user, Notification notification) throws PortalException {
		long notificationId = notification.getNotificationId();
		Map<String, Serializable> taskContextMap = new HashMap<>();
		taskContextMap.put(NotificationBackgroundConstants.NOTIFICATION_ID, notificationId);
		backgroundTaskLocalService.addBackgroundTask(user.getUserId(), CompanyConstants.SYSTEM, "NOTIFICATION_" + notificationId, NotificationBackgroundTaskExecutor.class.getName(), taskContextMap,
				new ServiceContext());
	}

	public Set<User> getReceiverUserIdsForNotificationType(Notification notification) {
		Set<User> results = new HashSet<>();

		List<Long> userIds = Arrays.asList(StringUtil.split(notification.getReceiverUserIds(), StringPool.SEMICOLON)).stream().map(Long::valueOf).collect(Collectors.toList());
		NotificationType notificationType = NotificationType.getByKey(notification.getNotificationType());

		for (Long userId : userIds) {
			if (userNotificationPreferenceLocalService.hasNotificationEnabledForType(userId, notificationType)) {
				results.add(userLocalService.fetchUser(userId));
			}
		}

		results.remove(null);
		return results;
	}

	public ServiceContext getServiceContext(Group group) {
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setScopeGroupId(group.getGroupId());
		serviceContext.setCompanyId(group.getCompanyId());
		serviceContext.setUserId(group.getCreatorUserId());
		serviceContext.setLanguageId(group.getDefaultLanguageId());
		return serviceContext;
	}

	public void sendEmailNotifications(long companyId, String subject, String body, Set<User> receiverUsers) throws PortalException {
		Company company = companyLocalService.getCompany(companyId);
		long globalGroupId = company.getGroupId();

		String portalURL = company.getPortalURL(globalGroupId);

		JournalArticle journalArticle = journalArticleLocalService.getLatestArticle(globalGroupId, NotificationBackgroundConstants.NOTIFICATION_EMAIL_WEBCONTENT_ID);
		String articleContent = journalArticleLocalService.getArticleContent(journalArticle, journalArticle.getDDMTemplateKey(), StringPool.BLANK, journalArticle.getDefaultLanguageId(), null, null);

		String emailBody = StringUtil.replace(articleContent, new String[] { NotificationBackgroundConstants.EMAIL_COMPANY_PLACEHOLDER, NotificationBackgroundConstants.EMAIL_PORTAL_URL_PLACEHOLDER,
				NotificationBackgroundConstants.EMAIL_BODY_PLACEHOLDER }, new String[] { company.getName(), portalURL, body });

		for (User user : receiverUsers) {
			notifyUser(subject, emailBody, user);
		}
	}

	private void notifyUser(String subject, String emailBody, User user) {
		try {
			mailService.sendEmail(user, subject, emailBody);
		} catch (Exception e) {
			LOG.error("Unable to notify user " + user.getUserId() + " - " + e.getMessage());
			LOG.debug(e);
		}
	}

}
