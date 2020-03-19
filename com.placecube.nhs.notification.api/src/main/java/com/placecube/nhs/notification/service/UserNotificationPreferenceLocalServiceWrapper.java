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

package com.placecube.nhs.notification.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link UserNotificationPreferenceLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserNotificationPreferenceLocalService
 * @generated
 */
@ProviderType
public class UserNotificationPreferenceLocalServiceWrapper
	implements UserNotificationPreferenceLocalService,
			   ServiceWrapper<UserNotificationPreferenceLocalService> {

	public UserNotificationPreferenceLocalServiceWrapper(
		UserNotificationPreferenceLocalService
			userNotificationPreferenceLocalService) {

		_userNotificationPreferenceLocalService =
			userNotificationPreferenceLocalService;
	}

	/**
	 * Adds the user notification preference to the database. Also notifies the appropriate model listeners.
	 *
	 * @param userNotificationPreference the user notification preference
	 * @return the user notification preference that was added
	 */
	@Override
	public com.placecube.nhs.notification.model.UserNotificationPreference
		addUserNotificationPreference(
			com.placecube.nhs.notification.model.UserNotificationPreference
				userNotificationPreference) {

		return _userNotificationPreferenceLocalService.
			addUserNotificationPreference(userNotificationPreference);
	}

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
	public com.placecube.nhs.notification.model.UserNotificationPreference
		configureNotificationPreference(
			long userId,
			com.placecube.nhs.notification.constants.NotificationType
				notificationType,
			boolean enabled) {

		return _userNotificationPreferenceLocalService.
			configureNotificationPreference(userId, notificationType, enabled);
	}

	/**
	 * Creates a new user notification preference with the primary key. Does not add the user notification preference to the database.
	 *
	 * @param userNotificationPreferencePK the primary key for the new user notification preference
	 * @return the new user notification preference
	 */
	@Override
	public com.placecube.nhs.notification.model.UserNotificationPreference
		createUserNotificationPreference(
			com.placecube.nhs.notification.service.persistence.
				UserNotificationPreferencePK userNotificationPreferencePK) {

		return _userNotificationPreferenceLocalService.
			createUserNotificationPreference(userNotificationPreferencePK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userNotificationPreferenceLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the user notification preference from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userNotificationPreference the user notification preference
	 * @return the user notification preference that was removed
	 */
	@Override
	public com.placecube.nhs.notification.model.UserNotificationPreference
		deleteUserNotificationPreference(
			com.placecube.nhs.notification.model.UserNotificationPreference
				userNotificationPreference) {

		return _userNotificationPreferenceLocalService.
			deleteUserNotificationPreference(userNotificationPreference);
	}

	/**
	 * Deletes the user notification preference with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userNotificationPreferencePK the primary key of the user notification preference
	 * @return the user notification preference that was removed
	 * @throws PortalException if a user notification preference with the primary key could not be found
	 */
	@Override
	public com.placecube.nhs.notification.model.UserNotificationPreference
			deleteUserNotificationPreference(
				com.placecube.nhs.notification.service.persistence.
					UserNotificationPreferencePK userNotificationPreferencePK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userNotificationPreferenceLocalService.
			deleteUserNotificationPreference(userNotificationPreferencePK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userNotificationPreferenceLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _userNotificationPreferenceLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.placecube.nhs.notification.model.impl.UserNotificationPreferenceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _userNotificationPreferenceLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.placecube.nhs.notification.model.impl.UserNotificationPreferenceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _userNotificationPreferenceLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _userNotificationPreferenceLocalService.dynamicQueryCount(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _userNotificationPreferenceLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.placecube.nhs.notification.model.UserNotificationPreference
		fetchUserNotificationPreference(
			com.placecube.nhs.notification.service.persistence.
				UserNotificationPreferencePK userNotificationPreferencePK) {

		return _userNotificationPreferenceLocalService.
			fetchUserNotificationPreference(userNotificationPreferencePK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _userNotificationPreferenceLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _userNotificationPreferenceLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userNotificationPreferenceLocalService.
			getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userNotificationPreferenceLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the user notification preference with the primary key.
	 *
	 * @param userNotificationPreferencePK the primary key of the user notification preference
	 * @return the user notification preference
	 * @throws PortalException if a user notification preference with the primary key could not be found
	 */
	@Override
	public com.placecube.nhs.notification.model.UserNotificationPreference
			getUserNotificationPreference(
				com.placecube.nhs.notification.service.persistence.
					UserNotificationPreferencePK userNotificationPreferencePK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userNotificationPreferenceLocalService.
			getUserNotificationPreference(userNotificationPreferencePK);
	}

	/**
	 * Returns a range of all the user notification preferences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.placecube.nhs.notification.model.impl.UserNotificationPreferenceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user notification preferences
	 * @param end the upper bound of the range of user notification preferences (not inclusive)
	 * @return the range of user notification preferences
	 */
	@Override
	public java.util.List
		<com.placecube.nhs.notification.model.UserNotificationPreference>
			getUserNotificationPreferences(int start, int end) {

		return _userNotificationPreferenceLocalService.
			getUserNotificationPreferences(start, end);
	}

	/**
	 * Returns the number of user notification preferences.
	 *
	 * @return the number of user notification preferences
	 */
	@Override
	public int getUserNotificationPreferencesCount() {
		return _userNotificationPreferenceLocalService.
			getUserNotificationPreferencesCount();
	}

	@Override
	public boolean hasNotificationEnabledForType(
		long userId,
		com.placecube.nhs.notification.constants.NotificationType
			notificationType) {

		return _userNotificationPreferenceLocalService.
			hasNotificationEnabledForType(userId, notificationType);
	}

	/**
	 * Updates the user notification preference in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param userNotificationPreference the user notification preference
	 * @return the user notification preference that was updated
	 */
	@Override
	public com.placecube.nhs.notification.model.UserNotificationPreference
		updateUserNotificationPreference(
			com.placecube.nhs.notification.model.UserNotificationPreference
				userNotificationPreference) {

		return _userNotificationPreferenceLocalService.
			updateUserNotificationPreference(userNotificationPreference);
	}

	@Override
	public UserNotificationPreferenceLocalService getWrappedService() {
		return _userNotificationPreferenceLocalService;
	}

	@Override
	public void setWrappedService(
		UserNotificationPreferenceLocalService
			userNotificationPreferenceLocalService) {

		_userNotificationPreferenceLocalService =
			userNotificationPreferenceLocalService;
	}

	private UserNotificationPreferenceLocalService
		_userNotificationPreferenceLocalService;

}