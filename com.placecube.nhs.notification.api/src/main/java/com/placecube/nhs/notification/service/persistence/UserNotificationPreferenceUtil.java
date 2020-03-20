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

package com.placecube.nhs.notification.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.placecube.nhs.notification.model.UserNotificationPreference;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the user notification preference service. This utility wraps <code>com.placecube.nhs.notification.service.persistence.impl.UserNotificationPreferencePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserNotificationPreferencePersistence
 * @generated
 */
@ProviderType
public class UserNotificationPreferenceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(
		UserNotificationPreference userNotificationPreference) {

		getPersistence().clearCache(userNotificationPreference);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, UserNotificationPreference>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserNotificationPreference> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserNotificationPreference> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserNotificationPreference> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserNotificationPreference> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserNotificationPreference update(
		UserNotificationPreference userNotificationPreference) {

		return getPersistence().update(userNotificationPreference);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserNotificationPreference update(
		UserNotificationPreference userNotificationPreference,
		ServiceContext serviceContext) {

		return getPersistence().update(
			userNotificationPreference, serviceContext);
	}

	/**
	 * Returns all the user notification preferences where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user notification preferences
	 */
	public static List<UserNotificationPreference> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the user notification preferences where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserNotificationPreferenceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user notification preferences
	 * @param end the upper bound of the range of user notification preferences (not inclusive)
	 * @return the range of matching user notification preferences
	 */
	public static List<UserNotificationPreference> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the user notification preferences where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserNotificationPreferenceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user notification preferences
	 * @param end the upper bound of the range of user notification preferences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user notification preferences
	 */
	public static List<UserNotificationPreference> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserNotificationPreference> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user notification preferences where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserNotificationPreferenceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user notification preferences
	 * @param end the upper bound of the range of user notification preferences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching user notification preferences
	 */
	public static List<UserNotificationPreference> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserNotificationPreference> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first user notification preference in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user notification preference
	 * @throws NoSuchUserNotificationPreferenceException if a matching user notification preference could not be found
	 */
	public static UserNotificationPreference findByUuid_First(
			String uuid,
			OrderByComparator<UserNotificationPreference> orderByComparator)
		throws com.placecube.nhs.notification.exception.
			NoSuchUserNotificationPreferenceException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first user notification preference in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user notification preference, or <code>null</code> if a matching user notification preference could not be found
	 */
	public static UserNotificationPreference fetchByUuid_First(
		String uuid,
		OrderByComparator<UserNotificationPreference> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last user notification preference in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user notification preference
	 * @throws NoSuchUserNotificationPreferenceException if a matching user notification preference could not be found
	 */
	public static UserNotificationPreference findByUuid_Last(
			String uuid,
			OrderByComparator<UserNotificationPreference> orderByComparator)
		throws com.placecube.nhs.notification.exception.
			NoSuchUserNotificationPreferenceException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last user notification preference in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user notification preference, or <code>null</code> if a matching user notification preference could not be found
	 */
	public static UserNotificationPreference fetchByUuid_Last(
		String uuid,
		OrderByComparator<UserNotificationPreference> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the user notification preferences before and after the current user notification preference in the ordered set where uuid = &#63;.
	 *
	 * @param userNotificationPreferencePK the primary key of the current user notification preference
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user notification preference
	 * @throws NoSuchUserNotificationPreferenceException if a user notification preference with the primary key could not be found
	 */
	public static UserNotificationPreference[] findByUuid_PrevAndNext(
			UserNotificationPreferencePK userNotificationPreferencePK,
			String uuid,
			OrderByComparator<UserNotificationPreference> orderByComparator)
		throws com.placecube.nhs.notification.exception.
			NoSuchUserNotificationPreferenceException {

		return getPersistence().findByUuid_PrevAndNext(
			userNotificationPreferencePK, uuid, orderByComparator);
	}

	/**
	 * Removes all the user notification preferences where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of user notification preferences where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user notification preferences
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the user notification preference where userId = &#63; and notificationType = &#63; and enabled = &#63; or throws a <code>NoSuchUserNotificationPreferenceException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @param notificationType the notification type
	 * @param enabled the enabled
	 * @return the matching user notification preference
	 * @throws NoSuchUserNotificationPreferenceException if a matching user notification preference could not be found
	 */
	public static UserNotificationPreference findByUserIdTypeEnabled(
			long userId, String notificationType, boolean enabled)
		throws com.placecube.nhs.notification.exception.
			NoSuchUserNotificationPreferenceException {

		return getPersistence().findByUserIdTypeEnabled(
			userId, notificationType, enabled);
	}

	/**
	 * Returns the user notification preference where userId = &#63; and notificationType = &#63; and enabled = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param notificationType the notification type
	 * @param enabled the enabled
	 * @return the matching user notification preference, or <code>null</code> if a matching user notification preference could not be found
	 */
	public static UserNotificationPreference fetchByUserIdTypeEnabled(
		long userId, String notificationType, boolean enabled) {

		return getPersistence().fetchByUserIdTypeEnabled(
			userId, notificationType, enabled);
	}

	/**
	 * Returns the user notification preference where userId = &#63; and notificationType = &#63; and enabled = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param notificationType the notification type
	 * @param enabled the enabled
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching user notification preference, or <code>null</code> if a matching user notification preference could not be found
	 */
	public static UserNotificationPreference fetchByUserIdTypeEnabled(
		long userId, String notificationType, boolean enabled,
		boolean retrieveFromCache) {

		return getPersistence().fetchByUserIdTypeEnabled(
			userId, notificationType, enabled, retrieveFromCache);
	}

	/**
	 * Removes the user notification preference where userId = &#63; and notificationType = &#63; and enabled = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param notificationType the notification type
	 * @param enabled the enabled
	 * @return the user notification preference that was removed
	 */
	public static UserNotificationPreference removeByUserIdTypeEnabled(
			long userId, String notificationType, boolean enabled)
		throws com.placecube.nhs.notification.exception.
			NoSuchUserNotificationPreferenceException {

		return getPersistence().removeByUserIdTypeEnabled(
			userId, notificationType, enabled);
	}

	/**
	 * Returns the number of user notification preferences where userId = &#63; and notificationType = &#63; and enabled = &#63;.
	 *
	 * @param userId the user ID
	 * @param notificationType the notification type
	 * @param enabled the enabled
	 * @return the number of matching user notification preferences
	 */
	public static int countByUserIdTypeEnabled(
		long userId, String notificationType, boolean enabled) {

		return getPersistence().countByUserIdTypeEnabled(
			userId, notificationType, enabled);
	}

	/**
	 * Returns all the user notification preferences where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching user notification preferences
	 */
	public static List<UserNotificationPreference> findByuserId(long userId) {
		return getPersistence().findByuserId(userId);
	}

	/**
	 * Returns a range of all the user notification preferences where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserNotificationPreferenceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user notification preferences
	 * @param end the upper bound of the range of user notification preferences (not inclusive)
	 * @return the range of matching user notification preferences
	 */
	public static List<UserNotificationPreference> findByuserId(
		long userId, int start, int end) {

		return getPersistence().findByuserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the user notification preferences where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserNotificationPreferenceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user notification preferences
	 * @param end the upper bound of the range of user notification preferences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user notification preferences
	 */
	public static List<UserNotificationPreference> findByuserId(
		long userId, int start, int end,
		OrderByComparator<UserNotificationPreference> orderByComparator) {

		return getPersistence().findByuserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user notification preferences where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserNotificationPreferenceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user notification preferences
	 * @param end the upper bound of the range of user notification preferences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching user notification preferences
	 */
	public static List<UserNotificationPreference> findByuserId(
		long userId, int start, int end,
		OrderByComparator<UserNotificationPreference> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByuserId(
			userId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first user notification preference in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user notification preference
	 * @throws NoSuchUserNotificationPreferenceException if a matching user notification preference could not be found
	 */
	public static UserNotificationPreference findByuserId_First(
			long userId,
			OrderByComparator<UserNotificationPreference> orderByComparator)
		throws com.placecube.nhs.notification.exception.
			NoSuchUserNotificationPreferenceException {

		return getPersistence().findByuserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first user notification preference in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user notification preference, or <code>null</code> if a matching user notification preference could not be found
	 */
	public static UserNotificationPreference fetchByuserId_First(
		long userId,
		OrderByComparator<UserNotificationPreference> orderByComparator) {

		return getPersistence().fetchByuserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last user notification preference in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user notification preference
	 * @throws NoSuchUserNotificationPreferenceException if a matching user notification preference could not be found
	 */
	public static UserNotificationPreference findByuserId_Last(
			long userId,
			OrderByComparator<UserNotificationPreference> orderByComparator)
		throws com.placecube.nhs.notification.exception.
			NoSuchUserNotificationPreferenceException {

		return getPersistence().findByuserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last user notification preference in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user notification preference, or <code>null</code> if a matching user notification preference could not be found
	 */
	public static UserNotificationPreference fetchByuserId_Last(
		long userId,
		OrderByComparator<UserNotificationPreference> orderByComparator) {

		return getPersistence().fetchByuserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the user notification preferences before and after the current user notification preference in the ordered set where userId = &#63;.
	 *
	 * @param userNotificationPreferencePK the primary key of the current user notification preference
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user notification preference
	 * @throws NoSuchUserNotificationPreferenceException if a user notification preference with the primary key could not be found
	 */
	public static UserNotificationPreference[] findByuserId_PrevAndNext(
			UserNotificationPreferencePK userNotificationPreferencePK,
			long userId,
			OrderByComparator<UserNotificationPreference> orderByComparator)
		throws com.placecube.nhs.notification.exception.
			NoSuchUserNotificationPreferenceException {

		return getPersistence().findByuserId_PrevAndNext(
			userNotificationPreferencePK, userId, orderByComparator);
	}

	/**
	 * Removes all the user notification preferences where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByuserId(long userId) {
		getPersistence().removeByuserId(userId);
	}

	/**
	 * Returns the number of user notification preferences where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user notification preferences
	 */
	public static int countByuserId(long userId) {
		return getPersistence().countByuserId(userId);
	}

	/**
	 * Caches the user notification preference in the entity cache if it is enabled.
	 *
	 * @param userNotificationPreference the user notification preference
	 */
	public static void cacheResult(
		UserNotificationPreference userNotificationPreference) {

		getPersistence().cacheResult(userNotificationPreference);
	}

	/**
	 * Caches the user notification preferences in the entity cache if it is enabled.
	 *
	 * @param userNotificationPreferences the user notification preferences
	 */
	public static void cacheResult(
		List<UserNotificationPreference> userNotificationPreferences) {

		getPersistence().cacheResult(userNotificationPreferences);
	}

	/**
	 * Creates a new user notification preference with the primary key. Does not add the user notification preference to the database.
	 *
	 * @param userNotificationPreferencePK the primary key for the new user notification preference
	 * @return the new user notification preference
	 */
	public static UserNotificationPreference create(
		UserNotificationPreferencePK userNotificationPreferencePK) {

		return getPersistence().create(userNotificationPreferencePK);
	}

	/**
	 * Removes the user notification preference with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userNotificationPreferencePK the primary key of the user notification preference
	 * @return the user notification preference that was removed
	 * @throws NoSuchUserNotificationPreferenceException if a user notification preference with the primary key could not be found
	 */
	public static UserNotificationPreference remove(
			UserNotificationPreferencePK userNotificationPreferencePK)
		throws com.placecube.nhs.notification.exception.
			NoSuchUserNotificationPreferenceException {

		return getPersistence().remove(userNotificationPreferencePK);
	}

	public static UserNotificationPreference updateImpl(
		UserNotificationPreference userNotificationPreference) {

		return getPersistence().updateImpl(userNotificationPreference);
	}

	/**
	 * Returns the user notification preference with the primary key or throws a <code>NoSuchUserNotificationPreferenceException</code> if it could not be found.
	 *
	 * @param userNotificationPreferencePK the primary key of the user notification preference
	 * @return the user notification preference
	 * @throws NoSuchUserNotificationPreferenceException if a user notification preference with the primary key could not be found
	 */
	public static UserNotificationPreference findByPrimaryKey(
			UserNotificationPreferencePK userNotificationPreferencePK)
		throws com.placecube.nhs.notification.exception.
			NoSuchUserNotificationPreferenceException {

		return getPersistence().findByPrimaryKey(userNotificationPreferencePK);
	}

	/**
	 * Returns the user notification preference with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userNotificationPreferencePK the primary key of the user notification preference
	 * @return the user notification preference, or <code>null</code> if a user notification preference with the primary key could not be found
	 */
	public static UserNotificationPreference fetchByPrimaryKey(
		UserNotificationPreferencePK userNotificationPreferencePK) {

		return getPersistence().fetchByPrimaryKey(userNotificationPreferencePK);
	}

	/**
	 * Returns all the user notification preferences.
	 *
	 * @return the user notification preferences
	 */
	public static List<UserNotificationPreference> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the user notification preferences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserNotificationPreferenceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user notification preferences
	 * @param end the upper bound of the range of user notification preferences (not inclusive)
	 * @return the range of user notification preferences
	 */
	public static List<UserNotificationPreference> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the user notification preferences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserNotificationPreferenceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user notification preferences
	 * @param end the upper bound of the range of user notification preferences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user notification preferences
	 */
	public static List<UserNotificationPreference> findAll(
		int start, int end,
		OrderByComparator<UserNotificationPreference> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user notification preferences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserNotificationPreferenceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user notification preferences
	 * @param end the upper bound of the range of user notification preferences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of user notification preferences
	 */
	public static List<UserNotificationPreference> findAll(
		int start, int end,
		OrderByComparator<UserNotificationPreference> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the user notification preferences from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of user notification preferences.
	 *
	 * @return the number of user notification preferences
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static UserNotificationPreferencePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<UserNotificationPreferencePersistence,
		 UserNotificationPreferencePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			UserNotificationPreferencePersistence.class);

		ServiceTracker
			<UserNotificationPreferencePersistence,
			 UserNotificationPreferencePersistence> serviceTracker =
				new ServiceTracker
					<UserNotificationPreferencePersistence,
					 UserNotificationPreferencePersistence>(
						 bundle.getBundleContext(),
						 UserNotificationPreferencePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}