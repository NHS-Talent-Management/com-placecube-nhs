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

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.placecube.nhs.notification.constants.NotificationType;
import com.placecube.nhs.notification.model.UserNotificationPreference;
import com.placecube.nhs.notification.service.persistence.UserNotificationPreferencePK;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for UserNotificationPreference. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see UserNotificationPreferenceLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface UserNotificationPreferenceLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserNotificationPreferenceLocalServiceUtil} to access the user notification preference local service. Add custom service methods to <code>com.placecube.nhs.notification.service.impl.UserNotificationPreferenceLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * Adds the user notification preference to the database. Also notifies the appropriate model listeners.
	 *
	 * @param userNotificationPreference the user notification preference
	 * @return the user notification preference that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public UserNotificationPreference addUserNotificationPreference(
		UserNotificationPreference userNotificationPreference);

	/**
	 * Creates or updates a user notification preference for the given
	 * notification type
	 *
	 * @param userId the user to configure the notificaiton preference for
	 * @param notificationType the notification type
	 * @param enabled if notifications for the type should be enabled or not
	 * @return the configured UserNotificationPreference
	 */
	public UserNotificationPreference configureNotificationPreference(
		long userId, NotificationType notificationType, boolean enabled);

	/**
	 * Creates a new user notification preference with the primary key. Does not add the user notification preference to the database.
	 *
	 * @param userNotificationPreferencePK the primary key for the new user notification preference
	 * @return the new user notification preference
	 */
	@Transactional(enabled = false)
	public UserNotificationPreference createUserNotificationPreference(
		UserNotificationPreferencePK userNotificationPreferencePK);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the user notification preference from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userNotificationPreference the user notification preference
	 * @return the user notification preference that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public UserNotificationPreference deleteUserNotificationPreference(
		UserNotificationPreference userNotificationPreference);

	/**
	 * Deletes the user notification preference with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userNotificationPreferencePK the primary key of the user notification preference
	 * @return the user notification preference that was removed
	 * @throws PortalException if a user notification preference with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public UserNotificationPreference deleteUserNotificationPreference(
			UserNotificationPreferencePK userNotificationPreferencePK)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public UserNotificationPreference fetchUserNotificationPreference(
		UserNotificationPreferencePK userNotificationPreferencePK);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns all the notification preferences for the user
	 *
	 * @param userId the userId
	 * @return list of all configured notification preferences, both enabled and
	 disabled
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserNotificationPreference> getByUserId(long userId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Returns the user notification preference with the primary key.
	 *
	 * @param userNotificationPreferencePK the primary key of the user notification preference
	 * @return the user notification preference
	 * @throws PortalException if a user notification preference with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public UserNotificationPreference getUserNotificationPreference(
			UserNotificationPreferencePK userNotificationPreferencePK)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserNotificationPreference> getUserNotificationPreferences(
		int start, int end);

	/**
	 * Returns the number of user notification preferences.
	 *
	 * @return the number of user notification preferences
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getUserNotificationPreferencesCount();

	/**
	 * Checks if the user has a notification enabled for the type
	 *
	 * @param userId the userId
	 * @param notificationType the notificaiton type
	 * @return true if the user has a notification enabled for the specified
	 type, false otherwise
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasNotificationEnabledForType(
		long userId, NotificationType notificationType);

	/**
	 * Updates the user notification preference in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param userNotificationPreference the user notification preference
	 * @return the user notification preference that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public UserNotificationPreference updateUserNotificationPreference(
		UserNotificationPreference userNotificationPreference);

}