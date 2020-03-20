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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.placecube.nhs.userprivacy.model.UserPrivacy;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the user privacy service. This utility wraps <code>com.placecube.nhs.userprivacy.service.persistence.impl.UserPrivacyPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserPrivacyPersistence
 * @generated
 */
@ProviderType
public class UserPrivacyUtil {

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
	public static void clearCache(UserPrivacy userPrivacy) {
		getPersistence().clearCache(userPrivacy);
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
	public static Map<Serializable, UserPrivacy> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserPrivacy> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserPrivacy> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserPrivacy> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserPrivacy> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserPrivacy update(UserPrivacy userPrivacy) {
		return getPersistence().update(userPrivacy);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserPrivacy update(
		UserPrivacy userPrivacy, ServiceContext serviceContext) {

		return getPersistence().update(userPrivacy, serviceContext);
	}

	/**
	 * Returns all the user privacies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user privacies
	 */
	public static List<UserPrivacy> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<UserPrivacy> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<UserPrivacy> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserPrivacy> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<UserPrivacy> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserPrivacy> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first user privacy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user privacy
	 * @throws NoSuchUserPrivacyException if a matching user privacy could not be found
	 */
	public static UserPrivacy findByUuid_First(
			String uuid, OrderByComparator<UserPrivacy> orderByComparator)
		throws com.placecube.nhs.userprivacy.exception.
			NoSuchUserPrivacyException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first user privacy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user privacy, or <code>null</code> if a matching user privacy could not be found
	 */
	public static UserPrivacy fetchByUuid_First(
		String uuid, OrderByComparator<UserPrivacy> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last user privacy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user privacy
	 * @throws NoSuchUserPrivacyException if a matching user privacy could not be found
	 */
	public static UserPrivacy findByUuid_Last(
			String uuid, OrderByComparator<UserPrivacy> orderByComparator)
		throws com.placecube.nhs.userprivacy.exception.
			NoSuchUserPrivacyException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last user privacy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user privacy, or <code>null</code> if a matching user privacy could not be found
	 */
	public static UserPrivacy fetchByUuid_Last(
		String uuid, OrderByComparator<UserPrivacy> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the user privacies before and after the current user privacy in the ordered set where uuid = &#63;.
	 *
	 * @param userPrivacyPK the primary key of the current user privacy
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user privacy
	 * @throws NoSuchUserPrivacyException if a user privacy with the primary key could not be found
	 */
	public static UserPrivacy[] findByUuid_PrevAndNext(
			UserPrivacyPK userPrivacyPK, String uuid,
			OrderByComparator<UserPrivacy> orderByComparator)
		throws com.placecube.nhs.userprivacy.exception.
			NoSuchUserPrivacyException {

		return getPersistence().findByUuid_PrevAndNext(
			userPrivacyPK, uuid, orderByComparator);
	}

	/**
	 * Removes all the user privacies where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of user privacies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user privacies
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the user privacies where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching user privacies
	 */
	public static List<UserPrivacy> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<UserPrivacy> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<UserPrivacy> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UserPrivacy> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<UserPrivacy> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UserPrivacy> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first user privacy in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user privacy
	 * @throws NoSuchUserPrivacyException if a matching user privacy could not be found
	 */
	public static UserPrivacy findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<UserPrivacy> orderByComparator)
		throws com.placecube.nhs.userprivacy.exception.
			NoSuchUserPrivacyException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first user privacy in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user privacy, or <code>null</code> if a matching user privacy could not be found
	 */
	public static UserPrivacy fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<UserPrivacy> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last user privacy in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user privacy
	 * @throws NoSuchUserPrivacyException if a matching user privacy could not be found
	 */
	public static UserPrivacy findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<UserPrivacy> orderByComparator)
		throws com.placecube.nhs.userprivacy.exception.
			NoSuchUserPrivacyException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last user privacy in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user privacy, or <code>null</code> if a matching user privacy could not be found
	 */
	public static UserPrivacy fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<UserPrivacy> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static UserPrivacy[] findByUuid_C_PrevAndNext(
			UserPrivacyPK userPrivacyPK, String uuid, long companyId,
			OrderByComparator<UserPrivacy> orderByComparator)
		throws com.placecube.nhs.userprivacy.exception.
			NoSuchUserPrivacyException {

		return getPersistence().findByUuid_C_PrevAndNext(
			userPrivacyPK, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the user privacies where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of user privacies where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching user privacies
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the user privacies where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching user privacies
	 */
	public static List<UserPrivacy> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

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
	public static List<UserPrivacy> findByUserId(
		long userId, int start, int end) {

		return getPersistence().findByUserId(userId, start, end);
	}

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
	public static List<UserPrivacy> findByUserId(
		long userId, int start, int end,
		OrderByComparator<UserPrivacy> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

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
	public static List<UserPrivacy> findByUserId(
		long userId, int start, int end,
		OrderByComparator<UserPrivacy> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first user privacy in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user privacy
	 * @throws NoSuchUserPrivacyException if a matching user privacy could not be found
	 */
	public static UserPrivacy findByUserId_First(
			long userId, OrderByComparator<UserPrivacy> orderByComparator)
		throws com.placecube.nhs.userprivacy.exception.
			NoSuchUserPrivacyException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first user privacy in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user privacy, or <code>null</code> if a matching user privacy could not be found
	 */
	public static UserPrivacy fetchByUserId_First(
		long userId, OrderByComparator<UserPrivacy> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last user privacy in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user privacy
	 * @throws NoSuchUserPrivacyException if a matching user privacy could not be found
	 */
	public static UserPrivacy findByUserId_Last(
			long userId, OrderByComparator<UserPrivacy> orderByComparator)
		throws com.placecube.nhs.userprivacy.exception.
			NoSuchUserPrivacyException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last user privacy in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user privacy, or <code>null</code> if a matching user privacy could not be found
	 */
	public static UserPrivacy fetchByUserId_Last(
		long userId, OrderByComparator<UserPrivacy> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the user privacies before and after the current user privacy in the ordered set where userId = &#63;.
	 *
	 * @param userPrivacyPK the primary key of the current user privacy
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user privacy
	 * @throws NoSuchUserPrivacyException if a user privacy with the primary key could not be found
	 */
	public static UserPrivacy[] findByUserId_PrevAndNext(
			UserPrivacyPK userPrivacyPK, long userId,
			OrderByComparator<UserPrivacy> orderByComparator)
		throws com.placecube.nhs.userprivacy.exception.
			NoSuchUserPrivacyException {

		return getPersistence().findByUserId_PrevAndNext(
			userPrivacyPK, userId, orderByComparator);
	}

	/**
	 * Removes all the user privacies where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of user privacies where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user privacies
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Returns all the user privacies where companyId = &#63; and fieldId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @return the matching user privacies
	 */
	public static List<UserPrivacy> findByCompanyIdFieldId(
		long companyId, String fieldId) {

		return getPersistence().findByCompanyIdFieldId(companyId, fieldId);
	}

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
	public static List<UserPrivacy> findByCompanyIdFieldId(
		long companyId, String fieldId, int start, int end) {

		return getPersistence().findByCompanyIdFieldId(
			companyId, fieldId, start, end);
	}

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
	public static List<UserPrivacy> findByCompanyIdFieldId(
		long companyId, String fieldId, int start, int end,
		OrderByComparator<UserPrivacy> orderByComparator) {

		return getPersistence().findByCompanyIdFieldId(
			companyId, fieldId, start, end, orderByComparator);
	}

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
	public static List<UserPrivacy> findByCompanyIdFieldId(
		long companyId, String fieldId, int start, int end,
		OrderByComparator<UserPrivacy> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByCompanyIdFieldId(
			companyId, fieldId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first user privacy in the ordered set where companyId = &#63; and fieldId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user privacy
	 * @throws NoSuchUserPrivacyException if a matching user privacy could not be found
	 */
	public static UserPrivacy findByCompanyIdFieldId_First(
			long companyId, String fieldId,
			OrderByComparator<UserPrivacy> orderByComparator)
		throws com.placecube.nhs.userprivacy.exception.
			NoSuchUserPrivacyException {

		return getPersistence().findByCompanyIdFieldId_First(
			companyId, fieldId, orderByComparator);
	}

	/**
	 * Returns the first user privacy in the ordered set where companyId = &#63; and fieldId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user privacy, or <code>null</code> if a matching user privacy could not be found
	 */
	public static UserPrivacy fetchByCompanyIdFieldId_First(
		long companyId, String fieldId,
		OrderByComparator<UserPrivacy> orderByComparator) {

		return getPersistence().fetchByCompanyIdFieldId_First(
			companyId, fieldId, orderByComparator);
	}

	/**
	 * Returns the last user privacy in the ordered set where companyId = &#63; and fieldId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user privacy
	 * @throws NoSuchUserPrivacyException if a matching user privacy could not be found
	 */
	public static UserPrivacy findByCompanyIdFieldId_Last(
			long companyId, String fieldId,
			OrderByComparator<UserPrivacy> orderByComparator)
		throws com.placecube.nhs.userprivacy.exception.
			NoSuchUserPrivacyException {

		return getPersistence().findByCompanyIdFieldId_Last(
			companyId, fieldId, orderByComparator);
	}

	/**
	 * Returns the last user privacy in the ordered set where companyId = &#63; and fieldId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user privacy, or <code>null</code> if a matching user privacy could not be found
	 */
	public static UserPrivacy fetchByCompanyIdFieldId_Last(
		long companyId, String fieldId,
		OrderByComparator<UserPrivacy> orderByComparator) {

		return getPersistence().fetchByCompanyIdFieldId_Last(
			companyId, fieldId, orderByComparator);
	}

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
	public static UserPrivacy[] findByCompanyIdFieldId_PrevAndNext(
			UserPrivacyPK userPrivacyPK, long companyId, String fieldId,
			OrderByComparator<UserPrivacy> orderByComparator)
		throws com.placecube.nhs.userprivacy.exception.
			NoSuchUserPrivacyException {

		return getPersistence().findByCompanyIdFieldId_PrevAndNext(
			userPrivacyPK, companyId, fieldId, orderByComparator);
	}

	/**
	 * Removes all the user privacies where companyId = &#63; and fieldId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 */
	public static void removeByCompanyIdFieldId(
		long companyId, String fieldId) {

		getPersistence().removeByCompanyIdFieldId(companyId, fieldId);
	}

	/**
	 * Returns the number of user privacies where companyId = &#63; and fieldId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @return the number of matching user privacies
	 */
	public static int countByCompanyIdFieldId(long companyId, String fieldId) {
		return getPersistence().countByCompanyIdFieldId(companyId, fieldId);
	}

	/**
	 * Caches the user privacy in the entity cache if it is enabled.
	 *
	 * @param userPrivacy the user privacy
	 */
	public static void cacheResult(UserPrivacy userPrivacy) {
		getPersistence().cacheResult(userPrivacy);
	}

	/**
	 * Caches the user privacies in the entity cache if it is enabled.
	 *
	 * @param userPrivacies the user privacies
	 */
	public static void cacheResult(List<UserPrivacy> userPrivacies) {
		getPersistence().cacheResult(userPrivacies);
	}

	/**
	 * Creates a new user privacy with the primary key. Does not add the user privacy to the database.
	 *
	 * @param userPrivacyPK the primary key for the new user privacy
	 * @return the new user privacy
	 */
	public static UserPrivacy create(UserPrivacyPK userPrivacyPK) {
		return getPersistence().create(userPrivacyPK);
	}

	/**
	 * Removes the user privacy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userPrivacyPK the primary key of the user privacy
	 * @return the user privacy that was removed
	 * @throws NoSuchUserPrivacyException if a user privacy with the primary key could not be found
	 */
	public static UserPrivacy remove(UserPrivacyPK userPrivacyPK)
		throws com.placecube.nhs.userprivacy.exception.
			NoSuchUserPrivacyException {

		return getPersistence().remove(userPrivacyPK);
	}

	public static UserPrivacy updateImpl(UserPrivacy userPrivacy) {
		return getPersistence().updateImpl(userPrivacy);
	}

	/**
	 * Returns the user privacy with the primary key or throws a <code>NoSuchUserPrivacyException</code> if it could not be found.
	 *
	 * @param userPrivacyPK the primary key of the user privacy
	 * @return the user privacy
	 * @throws NoSuchUserPrivacyException if a user privacy with the primary key could not be found
	 */
	public static UserPrivacy findByPrimaryKey(UserPrivacyPK userPrivacyPK)
		throws com.placecube.nhs.userprivacy.exception.
			NoSuchUserPrivacyException {

		return getPersistence().findByPrimaryKey(userPrivacyPK);
	}

	/**
	 * Returns the user privacy with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userPrivacyPK the primary key of the user privacy
	 * @return the user privacy, or <code>null</code> if a user privacy with the primary key could not be found
	 */
	public static UserPrivacy fetchByPrimaryKey(UserPrivacyPK userPrivacyPK) {
		return getPersistence().fetchByPrimaryKey(userPrivacyPK);
	}

	/**
	 * Returns all the user privacies.
	 *
	 * @return the user privacies
	 */
	public static List<UserPrivacy> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<UserPrivacy> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<UserPrivacy> findAll(
		int start, int end, OrderByComparator<UserPrivacy> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<UserPrivacy> findAll(
		int start, int end, OrderByComparator<UserPrivacy> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the user privacies from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of user privacies.
	 *
	 * @return the number of user privacies
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static UserPrivacyPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<UserPrivacyPersistence, UserPrivacyPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(UserPrivacyPersistence.class);

		ServiceTracker<UserPrivacyPersistence, UserPrivacyPersistence>
			serviceTracker =
				new ServiceTracker
					<UserPrivacyPersistence, UserPrivacyPersistence>(
						bundle.getBundleContext(), UserPrivacyPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}