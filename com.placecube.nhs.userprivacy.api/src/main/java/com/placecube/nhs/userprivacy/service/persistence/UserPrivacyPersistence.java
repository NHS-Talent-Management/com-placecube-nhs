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

package com.placecube.nhs.userprivacy.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.placecube.nhs.userprivacy.exception.NoSuchUserPrivacyException;
import com.placecube.nhs.userprivacy.model.UserPrivacy;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the user privacy service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserPrivacyUtil
 * @generated
 */
@ProviderType
public interface UserPrivacyPersistence extends BasePersistence<UserPrivacy> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserPrivacyUtil} to access the user privacy persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the user privacies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user privacies
	 */
	public java.util.List<UserPrivacy> findByUuid(String uuid);

	/**
	 * Returns a range of all the user privacies where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPrivacyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user privacies
	 * @param end the upper bound of the range of user privacies (not inclusive)
	 * @return the range of matching user privacies
	 */
	public java.util.List<UserPrivacy> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the user privacies where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPrivacyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user privacies
	 * @param end the upper bound of the range of user privacies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user privacies
	 */
	public java.util.List<UserPrivacy> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserPrivacy>
			orderByComparator);

	/**
	 * Returns an ordered range of all the user privacies where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPrivacyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user privacies
	 * @param end the upper bound of the range of user privacies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching user privacies
	 */
	public java.util.List<UserPrivacy> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserPrivacy>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first user privacy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user privacy
	 * @throws NoSuchUserPrivacyException if a matching user privacy could not be found
	 */
	public UserPrivacy findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<UserPrivacy>
				orderByComparator)
		throws NoSuchUserPrivacyException;

	/**
	 * Returns the first user privacy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user privacy, or <code>null</code> if a matching user privacy could not be found
	 */
	public UserPrivacy fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserPrivacy>
			orderByComparator);

	/**
	 * Returns the last user privacy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user privacy
	 * @throws NoSuchUserPrivacyException if a matching user privacy could not be found
	 */
	public UserPrivacy findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<UserPrivacy>
				orderByComparator)
		throws NoSuchUserPrivacyException;

	/**
	 * Returns the last user privacy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user privacy, or <code>null</code> if a matching user privacy could not be found
	 */
	public UserPrivacy fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserPrivacy>
			orderByComparator);

	/**
	 * Returns the user privacies before and after the current user privacy in the ordered set where uuid = &#63;.
	 *
	 * @param userPrivacyPK the primary key of the current user privacy
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user privacy
	 * @throws NoSuchUserPrivacyException if a user privacy with the primary key could not be found
	 */
	public UserPrivacy[] findByUuid_PrevAndNext(
			UserPrivacyPK userPrivacyPK, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<UserPrivacy>
				orderByComparator)
		throws NoSuchUserPrivacyException;

	/**
	 * Removes all the user privacies where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of user privacies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user privacies
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the user privacies where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching user privacies
	 */
	public java.util.List<UserPrivacy> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the user privacies where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPrivacyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user privacies
	 * @param end the upper bound of the range of user privacies (not inclusive)
	 * @return the range of matching user privacies
	 */
	public java.util.List<UserPrivacy> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the user privacies where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPrivacyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user privacies
	 * @param end the upper bound of the range of user privacies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user privacies
	 */
	public java.util.List<UserPrivacy> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserPrivacy>
			orderByComparator);

	/**
	 * Returns an ordered range of all the user privacies where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPrivacyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user privacies
	 * @param end the upper bound of the range of user privacies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching user privacies
	 */
	public java.util.List<UserPrivacy> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserPrivacy>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first user privacy in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user privacy
	 * @throws NoSuchUserPrivacyException if a matching user privacy could not be found
	 */
	public UserPrivacy findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<UserPrivacy>
				orderByComparator)
		throws NoSuchUserPrivacyException;

	/**
	 * Returns the first user privacy in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user privacy, or <code>null</code> if a matching user privacy could not be found
	 */
	public UserPrivacy fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<UserPrivacy>
			orderByComparator);

	/**
	 * Returns the last user privacy in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user privacy
	 * @throws NoSuchUserPrivacyException if a matching user privacy could not be found
	 */
	public UserPrivacy findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<UserPrivacy>
				orderByComparator)
		throws NoSuchUserPrivacyException;

	/**
	 * Returns the last user privacy in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user privacy, or <code>null</code> if a matching user privacy could not be found
	 */
	public UserPrivacy fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<UserPrivacy>
			orderByComparator);

	/**
	 * Returns the user privacies before and after the current user privacy in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param userPrivacyPK the primary key of the current user privacy
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user privacy
	 * @throws NoSuchUserPrivacyException if a user privacy with the primary key could not be found
	 */
	public UserPrivacy[] findByUuid_C_PrevAndNext(
			UserPrivacyPK userPrivacyPK, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<UserPrivacy>
				orderByComparator)
		throws NoSuchUserPrivacyException;

	/**
	 * Removes all the user privacies where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of user privacies where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching user privacies
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the user privacies where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching user privacies
	 */
	public java.util.List<UserPrivacy> findByUserId(long userId);

	/**
	 * Returns a range of all the user privacies where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPrivacyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user privacies
	 * @param end the upper bound of the range of user privacies (not inclusive)
	 * @return the range of matching user privacies
	 */
	public java.util.List<UserPrivacy> findByUserId(
		long userId, int start, int end);

	/**
	 * Returns an ordered range of all the user privacies where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPrivacyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user privacies
	 * @param end the upper bound of the range of user privacies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user privacies
	 */
	public java.util.List<UserPrivacy> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserPrivacy>
			orderByComparator);

	/**
	 * Returns an ordered range of all the user privacies where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPrivacyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user privacies
	 * @param end the upper bound of the range of user privacies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching user privacies
	 */
	public java.util.List<UserPrivacy> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserPrivacy>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first user privacy in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user privacy
	 * @throws NoSuchUserPrivacyException if a matching user privacy could not be found
	 */
	public UserPrivacy findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<UserPrivacy>
				orderByComparator)
		throws NoSuchUserPrivacyException;

	/**
	 * Returns the first user privacy in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user privacy, or <code>null</code> if a matching user privacy could not be found
	 */
	public UserPrivacy fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<UserPrivacy>
			orderByComparator);

	/**
	 * Returns the last user privacy in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user privacy
	 * @throws NoSuchUserPrivacyException if a matching user privacy could not be found
	 */
	public UserPrivacy findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<UserPrivacy>
				orderByComparator)
		throws NoSuchUserPrivacyException;

	/**
	 * Returns the last user privacy in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user privacy, or <code>null</code> if a matching user privacy could not be found
	 */
	public UserPrivacy fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<UserPrivacy>
			orderByComparator);

	/**
	 * Returns the user privacies before and after the current user privacy in the ordered set where userId = &#63;.
	 *
	 * @param userPrivacyPK the primary key of the current user privacy
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user privacy
	 * @throws NoSuchUserPrivacyException if a user privacy with the primary key could not be found
	 */
	public UserPrivacy[] findByUserId_PrevAndNext(
			UserPrivacyPK userPrivacyPK, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<UserPrivacy>
				orderByComparator)
		throws NoSuchUserPrivacyException;

	/**
	 * Removes all the user privacies where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of user privacies where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user privacies
	 */
	public int countByUserId(long userId);

	/**
	 * Returns all the user privacies where companyId = &#63; and fieldId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @return the matching user privacies
	 */
	public java.util.List<UserPrivacy> findByCompanyIdFieldId(
		long companyId, String fieldId);

	/**
	 * Returns a range of all the user privacies where companyId = &#63; and fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPrivacyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of user privacies
	 * @param end the upper bound of the range of user privacies (not inclusive)
	 * @return the range of matching user privacies
	 */
	public java.util.List<UserPrivacy> findByCompanyIdFieldId(
		long companyId, String fieldId, int start, int end);

	/**
	 * Returns an ordered range of all the user privacies where companyId = &#63; and fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPrivacyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of user privacies
	 * @param end the upper bound of the range of user privacies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user privacies
	 */
	public java.util.List<UserPrivacy> findByCompanyIdFieldId(
		long companyId, String fieldId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserPrivacy>
			orderByComparator);

	/**
	 * Returns an ordered range of all the user privacies where companyId = &#63; and fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPrivacyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of user privacies
	 * @param end the upper bound of the range of user privacies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching user privacies
	 */
	public java.util.List<UserPrivacy> findByCompanyIdFieldId(
		long companyId, String fieldId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserPrivacy>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first user privacy in the ordered set where companyId = &#63; and fieldId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user privacy
	 * @throws NoSuchUserPrivacyException if a matching user privacy could not be found
	 */
	public UserPrivacy findByCompanyIdFieldId_First(
			long companyId, String fieldId,
			com.liferay.portal.kernel.util.OrderByComparator<UserPrivacy>
				orderByComparator)
		throws NoSuchUserPrivacyException;

	/**
	 * Returns the first user privacy in the ordered set where companyId = &#63; and fieldId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user privacy, or <code>null</code> if a matching user privacy could not be found
	 */
	public UserPrivacy fetchByCompanyIdFieldId_First(
		long companyId, String fieldId,
		com.liferay.portal.kernel.util.OrderByComparator<UserPrivacy>
			orderByComparator);

	/**
	 * Returns the last user privacy in the ordered set where companyId = &#63; and fieldId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user privacy
	 * @throws NoSuchUserPrivacyException if a matching user privacy could not be found
	 */
	public UserPrivacy findByCompanyIdFieldId_Last(
			long companyId, String fieldId,
			com.liferay.portal.kernel.util.OrderByComparator<UserPrivacy>
				orderByComparator)
		throws NoSuchUserPrivacyException;

	/**
	 * Returns the last user privacy in the ordered set where companyId = &#63; and fieldId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user privacy, or <code>null</code> if a matching user privacy could not be found
	 */
	public UserPrivacy fetchByCompanyIdFieldId_Last(
		long companyId, String fieldId,
		com.liferay.portal.kernel.util.OrderByComparator<UserPrivacy>
			orderByComparator);

	/**
	 * Returns the user privacies before and after the current user privacy in the ordered set where companyId = &#63; and fieldId = &#63;.
	 *
	 * @param userPrivacyPK the primary key of the current user privacy
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user privacy
	 * @throws NoSuchUserPrivacyException if a user privacy with the primary key could not be found
	 */
	public UserPrivacy[] findByCompanyIdFieldId_PrevAndNext(
			UserPrivacyPK userPrivacyPK, long companyId, String fieldId,
			com.liferay.portal.kernel.util.OrderByComparator<UserPrivacy>
				orderByComparator)
		throws NoSuchUserPrivacyException;

	/**
	 * Removes all the user privacies where companyId = &#63; and fieldId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 */
	public void removeByCompanyIdFieldId(long companyId, String fieldId);

	/**
	 * Returns the number of user privacies where companyId = &#63; and fieldId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @return the number of matching user privacies
	 */
	public int countByCompanyIdFieldId(long companyId, String fieldId);

	/**
	 * Caches the user privacy in the entity cache if it is enabled.
	 *
	 * @param userPrivacy the user privacy
	 */
	public void cacheResult(UserPrivacy userPrivacy);

	/**
	 * Caches the user privacies in the entity cache if it is enabled.
	 *
	 * @param userPrivacies the user privacies
	 */
	public void cacheResult(java.util.List<UserPrivacy> userPrivacies);

	/**
	 * Creates a new user privacy with the primary key. Does not add the user privacy to the database.
	 *
	 * @param userPrivacyPK the primary key for the new user privacy
	 * @return the new user privacy
	 */
	public UserPrivacy create(UserPrivacyPK userPrivacyPK);

	/**
	 * Removes the user privacy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userPrivacyPK the primary key of the user privacy
	 * @return the user privacy that was removed
	 * @throws NoSuchUserPrivacyException if a user privacy with the primary key could not be found
	 */
	public UserPrivacy remove(UserPrivacyPK userPrivacyPK)
		throws NoSuchUserPrivacyException;

	public UserPrivacy updateImpl(UserPrivacy userPrivacy);

	/**
	 * Returns the user privacy with the primary key or throws a <code>NoSuchUserPrivacyException</code> if it could not be found.
	 *
	 * @param userPrivacyPK the primary key of the user privacy
	 * @return the user privacy
	 * @throws NoSuchUserPrivacyException if a user privacy with the primary key could not be found
	 */
	public UserPrivacy findByPrimaryKey(UserPrivacyPK userPrivacyPK)
		throws NoSuchUserPrivacyException;

	/**
	 * Returns the user privacy with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userPrivacyPK the primary key of the user privacy
	 * @return the user privacy, or <code>null</code> if a user privacy with the primary key could not be found
	 */
	public UserPrivacy fetchByPrimaryKey(UserPrivacyPK userPrivacyPK);

	/**
	 * Returns all the user privacies.
	 *
	 * @return the user privacies
	 */
	public java.util.List<UserPrivacy> findAll();

	/**
	 * Returns a range of all the user privacies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPrivacyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user privacies
	 * @param end the upper bound of the range of user privacies (not inclusive)
	 * @return the range of user privacies
	 */
	public java.util.List<UserPrivacy> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the user privacies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPrivacyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user privacies
	 * @param end the upper bound of the range of user privacies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user privacies
	 */
	public java.util.List<UserPrivacy> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserPrivacy>
			orderByComparator);

	/**
	 * Returns an ordered range of all the user privacies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPrivacyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user privacies
	 * @param end the upper bound of the range of user privacies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of user privacies
	 */
	public java.util.List<UserPrivacy> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserPrivacy>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the user privacies from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of user privacies.
	 *
	 * @return the number of user privacies
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}