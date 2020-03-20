/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.placecube.nhs.notification.service.impl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.placecube.nhs.notification.constants.NotificationType;
import com.placecube.nhs.notification.exception.NoSuchUserNotificationPreferenceException;
import com.placecube.nhs.notification.model.UserNotificationPreference;
import com.placecube.nhs.notification.service.base.UserNotificationPreferenceLocalServiceBaseImpl;
import com.placecube.nhs.notification.service.persistence.UserNotificationPreferencePK;

/**
 * The implementation of the user notification preference local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.placecube.nhs.notification.service.UserNotificationPreferenceLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserNotificationPreferenceLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.placecube.nhs.notification.model.UserNotificationPreference", service = AopService.class)
public class UserNotificationPreferenceLocalServiceImpl extends UserNotificationPreferenceLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>com.placecube.nhs.notification.service.
	 * UserNotificationPreferenceLocalService</code> via injection or a
	 * <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.placecube.nhs.notification.service.
	 * UserNotificationPreferenceLocalServiceUtil</code>.
	 */

	private static final Log LOG = LogFactoryUtil.getLog(UserNotificationPreferenceLocalServiceImpl.class);

	/**
	 * Creates or updates a user notification preference for the given
	 * notification type
	 *
	 * @param userId the user to configure the notificaiton preference for
	 * @param notificationType the notification type
	 * @param enabled if notifications for the type should be enabled or not
	 * @return the configured UserNotificationPreference
	 */
	@Override
	public UserNotificationPreference configureNotificationPreference(long userId, NotificationType notificationType, boolean enabled) {
		UserNotificationPreferencePK userNotificationPreferencePK = new UserNotificationPreferencePK(userId, notificationType.getKey());
		UserNotificationPreference userNotificationPreference = getOrCreatePreference(userNotificationPreferencePK);
		userNotificationPreference.setEnabled(enabled);
		return userNotificationPreferenceLocalService.updateUserNotificationPreference(userNotificationPreference);
	}

	/**
	 * Returns all the notification preferences for the user
	 *
	 * @param userId the userId
	 * @return list of all configured notification preferences, both enabled and
	 *         disabled
	 */
	@Override
	public List<UserNotificationPreference> getByUserId(long userId) {
		return userNotificationPreferencePersistence.findByuserId(userId);
	}

	@Override
	/**
	 * Checks if the user has a notification enabled for the type
	 *
	 * @param userId the userId
	 * @param notificationType the notificaiton type
	 * @return true if the user has a notification enabled for the specified
	 *         type, false otherwise
	 */
	public boolean hasNotificationEnabledForType(long userId, NotificationType notificationType) {
		try {
			userNotificationPreferencePersistence.findByUserIdTypeEnabled(userId, notificationType.getKey(), true);
			return true;
		} catch (NoSuchUserNotificationPreferenceException e) {
			LOG.debug(e);
			return false;
		}
	}

	private UserNotificationPreference getOrCreatePreference(UserNotificationPreferencePK userNotificationPreferencePK) {
		UserNotificationPreference userNotificationPreference = userNotificationPreferenceLocalService.fetchUserNotificationPreference(userNotificationPreferencePK);
		if (Validator.isNull(userNotificationPreference)) {
			userNotificationPreference = userNotificationPreferenceLocalService.createUserNotificationPreference(userNotificationPreferencePK);
		}
		return userNotificationPreference;
	}
}