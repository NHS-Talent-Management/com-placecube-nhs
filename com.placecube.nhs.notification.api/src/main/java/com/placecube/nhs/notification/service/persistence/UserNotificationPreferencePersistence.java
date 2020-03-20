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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.placecube.nhs.notification.exception.NoSuchUserNotificationPreferenceException;
import com.placecube.nhs.notification.model.UserNotificationPreference;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the user notification preference service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserNotificationPreferenceUtil
 * @generated
 */
@ProviderType
public interface UserNotificationPreferencePersistence
	extends BasePersistence<UserNotificationPreference> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserNotificationPreferenceUtil} to access the user notification preference persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the user notification preferences where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user notification preferences
	 */
	public java.util.List<UserNotificationPreference> findByUuid(String uuid);

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
	public java.util.List<UserNotificationPreference> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<UserNotificationPreference> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<UserNotificationPreference> orderByComparator);

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
	public java.util.List<UserNotificationPreference> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<UserNotificationPreference> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first user notification preference in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user notification preference
	 * @throws NoSuchUserNotificationPreferenceException if a matching user notification preference could not be found
	 */
	public UserNotificationPreference findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserNotificationPreference> orderByComparator)
		throws NoSuchUserNotificationPreferenceException;

	/**
	 * Returns the first user notification preference in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user notification preference, or <code>null</code> if a matching user notification preference could not be found
	 */
	public UserNotificationPreference fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<UserNotificationPreference> orderByComparator);

	/**
	 * Returns the last user notification preference in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user notification preference
	 * @throws NoSuchUserNotificationPreferenceException if a matching user notification preference could not be found
	 */
	public UserNotificationPreference findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserNotificationPreference> orderByComparator)
		throws NoSuchUserNotificationPreferenceException;

	/**
	 * Returns the last user notification preference in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user notification preference, or <code>null</code> if a matching user notification preference could not be found
	 */
	public UserNotificationPreference fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<UserNotificationPreference> orderByComparator);

	/**
	 * Returns the user notification preferences before and after the current user notification preference in the ordered set where uuid = &#63;.
	 *
	 * @param userNotificationPreferencePK the primary key of the current user notification preference
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user notification preference
	 * @throws NoSuchUserNotificationPreferenceException if a user notification preference with the primary key could not be found
	 */
	public UserNotificationPreference[] findByUuid_PrevAndNext(
			UserNotificationPreferencePK userNotificationPreferencePK,
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserNotificationPreference> orderByComparator)
		throws NoSuchUserNotificationPreferenceException;

	/**
	 * Removes all the user notification preferences where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of user notification preferences where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user notification preferences
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the user notification preference where userId = &#63; and notificationType = &#63; and enabled = &#63; or throws a <code>NoSuchUserNotificationPreferenceException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @param notificationType the notification type
	 * @param enabled the enabled
	 * @return the matching user notification preference
	 * @throws NoSuchUserNotificationPreferenceException if a matching user notification preference could not be found
	 */
	public UserNotificationPreference findByUserIdTypeEnabled(
			long userId, String notificationType, boolean enabled)
		throws NoSuchUserNotificationPreferenceException;

	/**
	 * Returns the user notification preference where userId = &#63; and notificationType = &#63; and enabled = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param notificationType the notification type
	 * @param enabled the enabled
	 * @return the matching user notification preference, or <code>null</code> if a matching user notification preference could not be found
	 */
	public UserNotificationPreference fetchByUserIdTypeEnabled(
		long userId, String notificationType, boolean enabled);

	/**
	 * Returns the user notification preference where userId = &#63; and notificationType = &#63; and enabled = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param notificationType the notification type
	 * @param enabled the enabled
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching user notification preference, or <code>null</code> if a matching user notification preference could not be found
	 */
	public UserNotificationPreference fetchByUserIdTypeEnabled(
		long userId, String notificationType, boolean enabled,
		boolean retrieveFromCache);

	/**
	 * Removes the user notification preference where userId = &#63; and notificationType = &#63; and enabled = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param notificationType the notification type
	 * @param enabled the enabled
	 * @return the user notification preference that was removed
	 */
	public UserNotificationPreference removeByUserIdTypeEnabled(
			long userId, String notificationType, boolean enabled)
		throws NoSuchUserNotificationPreferenceException;

	/**
	 * Returns the number of user notification preferences where userId = &#63; and notificationType = &#63; and enabled = &#63;.
	 *
	 * @param userId the user ID
	 * @param notificationType the notification type
	 * @param enabled the enabled
	 * @return the number of matching user notification preferences
	 */
	public int countByUserIdTypeEnabled(
		long userId, String notificationType, boolean enabled);

	/**
	 * Returns all the user notification preferences where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching user notification preferences
	 */
	public java.util.List<UserNotificationPreference> findByuserId(long userId);

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
	public java.util.List<UserNotificationPreference> findByuserId(
		long userId, int start, int end);

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
	public java.util.List<UserNotificationPreference> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<UserNotificationPreference> orderByComparator);

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
	public java.util.List<UserNotificationPreference> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<UserNotificationPreference> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first user notification preference in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user notification preference
	 * @throws NoSuchUserNotificationPreferenceException if a matching user notification preference could not be found
	 */
	public UserNotificationPreference findByuserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserNotificationPreference> orderByComparator)
		throws NoSuchUserNotificationPreferenceException;

	/**
	 * Returns the first user notification preference in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user notification preference, or <code>null</code> if a matching user notification preference could not be found
	 */
	public UserNotificationPreference fetchByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator
			<UserNotificationPreference> orderByComparator);

	/**
	 * Returns the last user notification preference in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user notification preference
	 * @throws NoSuchUserNotificationPreferenceException if a matching user notification preference could not be found
	 */
	public UserNotificationPreference findByuserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserNotificationPreference> orderByComparator)
		throws NoSuchUserNotificationPreferenceException;

	/**
	 * Returns the last user notification preference in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user notification preference, or <code>null</code> if a matching user notification preference could not be found
	 */
	public UserNotificationPreference fetchByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator
			<UserNotificationPreference> orderByComparator);

	/**
	 * Returns the user notification preferences before and after the current user notification preference in the ordered set where userId = &#63;.
	 *
	 * @param userNotificationPreferencePK the primary key of the current user notification preference
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user notification preference
	 * @throws NoSuchUserNotificationPreferenceException if a user notification preference with the primary key could not be found
	 */
	public UserNotificationPreference[] findByuserId_PrevAndNext(
			UserNotificationPreferencePK userNotificationPreferencePK,
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UserNotificationPreference> orderByComparator)
		throws NoSuchUserNotificationPreferenceException;

	/**
	 * Removes all the user notification preferences where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByuserId(long userId);

	/**
	 * Returns the number of user notification preferences where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user notification preferences
	 */
	public int countByuserId(long userId);

	/**
	 * Caches the user notification preference in the entity cache if it is enabled.
	 *
	 * @param userNotificationPreference the user notification preference
	 */
	public void cacheResult(
		UserNotificationPreference userNotificationPreference);

	/**
	 * Caches the user notification preferences in the entity cache if it is enabled.
	 *
	 * @param userNotificationPreferences the user notification preferences
	 */
	public void cacheResult(
		java.util.List<UserNotificationPreference> userNotificationPreferences);

	/**
	 * Creates a new user notification preference with the primary key. Does not add the user notification preference to the database.
	 *
	 * @param userNotificationPreferencePK the primary key for the new user notification preference
	 * @return the new user notification preference
	 */
	public UserNotificationPreference create(
		UserNotificationPreferencePK userNotificationPreferencePK);

	/**
	 * Removes the user notification preference with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userNotificationPreferencePK the primary key of the user notification preference
	 * @return the user notification preference that was removed
	 * @throws NoSuchUserNotificationPreferenceException if a user notification preference with the primary key could not be found
	 */
	public UserNotificationPreference remove(
			UserNotificationPreferencePK userNotificationPreferencePK)
		throws NoSuchUserNotificationPreferenceException;

	public UserNotificationPreference updateImpl(
		UserNotificationPreference userNotificationPreference);

	/**
	 * Returns the user notification preference with the primary key or throws a <code>NoSuchUserNotificationPreferenceException</code> if it could not be found.
	 *
	 * @param userNotificationPreferencePK the primary key of the user notification preference
	 * @return the user notification preference
	 * @throws NoSuchUserNotificationPreferenceException if a user notification preference with the primary key could not be found
	 */
	public UserNotificationPreference findByPrimaryKey(
			UserNotificationPreferencePK userNotificationPreferencePK)
		throws NoSuchUserNotificationPreferenceException;

	/**
	 * Returns the user notification preference with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userNotificationPreferencePK the primary key of the user notification preference
	 * @return the user notification preference, or <code>null</code> if a user notification preference with the primary key could not be found
	 */
	public UserNotificationPreference fetchByPrimaryKey(
		UserNotificationPreferencePK userNotificationPreferencePK);

	/**
	 * Returns all the user notification preferences.
	 *
	 * @return the user notification preferences
	 */
	public java.util.List<UserNotificationPreference> findAll();

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
	public java.util.List<UserNotificationPreference> findAll(
		int start, int end);

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
	public java.util.List<UserNotificationPreference> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<UserNotificationPreference> orderByComparator);

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
	public java.util.List<UserNotificationPreference> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<UserNotificationPreference> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the user notification preferences from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of user notification preferences.
	 *
	 * @return the number of user notification preferences
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}