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

package com.placecube.nhs.userprofile.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.placecube.nhs.userprofile.model.ProfessionalBody;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the professional body service. This utility wraps <code>com.placecube.nhs.userprofile.service.persistence.impl.ProfessionalBodyPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProfessionalBodyPersistence
 * @generated
 */
@ProviderType
public class ProfessionalBodyUtil {

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
	public static void clearCache(ProfessionalBody professionalBody) {
		getPersistence().clearCache(professionalBody);
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
	public static Map<Serializable, ProfessionalBody> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProfessionalBody> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProfessionalBody> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProfessionalBody> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProfessionalBody> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProfessionalBody update(ProfessionalBody professionalBody) {
		return getPersistence().update(professionalBody);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProfessionalBody update(
		ProfessionalBody professionalBody, ServiceContext serviceContext) {

		return getPersistence().update(professionalBody, serviceContext);
	}

	/**
	 * Returns all the professional bodies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching professional bodies
	 */
	public static List<ProfessionalBody> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the professional bodies where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProfessionalBodyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of professional bodies
	 * @param end the upper bound of the range of professional bodies (not inclusive)
	 * @return the range of matching professional bodies
	 */
	public static List<ProfessionalBody> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the professional bodies where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProfessionalBodyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of professional bodies
	 * @param end the upper bound of the range of professional bodies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching professional bodies
	 */
	public static List<ProfessionalBody> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProfessionalBody> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the professional bodies where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProfessionalBodyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of professional bodies
	 * @param end the upper bound of the range of professional bodies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching professional bodies
	 */
	public static List<ProfessionalBody> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProfessionalBody> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first professional body in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching professional body
	 * @throws NoSuchProfessionalBodyException if a matching professional body could not be found
	 */
	public static ProfessionalBody findByUuid_First(
			String uuid, OrderByComparator<ProfessionalBody> orderByComparator)
		throws com.placecube.nhs.userprofile.exception.
			NoSuchProfessionalBodyException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first professional body in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching professional body, or <code>null</code> if a matching professional body could not be found
	 */
	public static ProfessionalBody fetchByUuid_First(
		String uuid, OrderByComparator<ProfessionalBody> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last professional body in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching professional body
	 * @throws NoSuchProfessionalBodyException if a matching professional body could not be found
	 */
	public static ProfessionalBody findByUuid_Last(
			String uuid, OrderByComparator<ProfessionalBody> orderByComparator)
		throws com.placecube.nhs.userprofile.exception.
			NoSuchProfessionalBodyException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last professional body in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching professional body, or <code>null</code> if a matching professional body could not be found
	 */
	public static ProfessionalBody fetchByUuid_Last(
		String uuid, OrderByComparator<ProfessionalBody> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the professional bodies before and after the current professional body in the ordered set where uuid = &#63;.
	 *
	 * @param professionalBodyId the primary key of the current professional body
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next professional body
	 * @throws NoSuchProfessionalBodyException if a professional body with the primary key could not be found
	 */
	public static ProfessionalBody[] findByUuid_PrevAndNext(
			long professionalBodyId, String uuid,
			OrderByComparator<ProfessionalBody> orderByComparator)
		throws com.placecube.nhs.userprofile.exception.
			NoSuchProfessionalBodyException {

		return getPersistence().findByUuid_PrevAndNext(
			professionalBodyId, uuid, orderByComparator);
	}

	/**
	 * Removes all the professional bodies where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of professional bodies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching professional bodies
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the professional bodies where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching professional bodies
	 */
	public static List<ProfessionalBody> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the professional bodies where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProfessionalBodyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of professional bodies
	 * @param end the upper bound of the range of professional bodies (not inclusive)
	 * @return the range of matching professional bodies
	 */
	public static List<ProfessionalBody> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the professional bodies where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProfessionalBodyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of professional bodies
	 * @param end the upper bound of the range of professional bodies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching professional bodies
	 */
	public static List<ProfessionalBody> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProfessionalBody> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the professional bodies where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProfessionalBodyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of professional bodies
	 * @param end the upper bound of the range of professional bodies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching professional bodies
	 */
	public static List<ProfessionalBody> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProfessionalBody> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first professional body in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching professional body
	 * @throws NoSuchProfessionalBodyException if a matching professional body could not be found
	 */
	public static ProfessionalBody findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProfessionalBody> orderByComparator)
		throws com.placecube.nhs.userprofile.exception.
			NoSuchProfessionalBodyException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first professional body in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching professional body, or <code>null</code> if a matching professional body could not be found
	 */
	public static ProfessionalBody fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProfessionalBody> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last professional body in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching professional body
	 * @throws NoSuchProfessionalBodyException if a matching professional body could not be found
	 */
	public static ProfessionalBody findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProfessionalBody> orderByComparator)
		throws com.placecube.nhs.userprofile.exception.
			NoSuchProfessionalBodyException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last professional body in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching professional body, or <code>null</code> if a matching professional body could not be found
	 */
	public static ProfessionalBody fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProfessionalBody> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the professional bodies before and after the current professional body in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param professionalBodyId the primary key of the current professional body
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next professional body
	 * @throws NoSuchProfessionalBodyException if a professional body with the primary key could not be found
	 */
	public static ProfessionalBody[] findByUuid_C_PrevAndNext(
			long professionalBodyId, String uuid, long companyId,
			OrderByComparator<ProfessionalBody> orderByComparator)
		throws com.placecube.nhs.userprofile.exception.
			NoSuchProfessionalBodyException {

		return getPersistence().findByUuid_C_PrevAndNext(
			professionalBodyId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the professional bodies where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of professional bodies where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching professional bodies
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the professional bodies where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching professional bodies
	 */
	public static List<ProfessionalBody> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the professional bodies where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProfessionalBodyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of professional bodies
	 * @param end the upper bound of the range of professional bodies (not inclusive)
	 * @return the range of matching professional bodies
	 */
	public static List<ProfessionalBody> findByUserId(
		long userId, int start, int end) {

		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the professional bodies where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProfessionalBodyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of professional bodies
	 * @param end the upper bound of the range of professional bodies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching professional bodies
	 */
	public static List<ProfessionalBody> findByUserId(
		long userId, int start, int end,
		OrderByComparator<ProfessionalBody> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the professional bodies where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProfessionalBodyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of professional bodies
	 * @param end the upper bound of the range of professional bodies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching professional bodies
	 */
	public static List<ProfessionalBody> findByUserId(
		long userId, int start, int end,
		OrderByComparator<ProfessionalBody> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first professional body in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching professional body
	 * @throws NoSuchProfessionalBodyException if a matching professional body could not be found
	 */
	public static ProfessionalBody findByUserId_First(
			long userId, OrderByComparator<ProfessionalBody> orderByComparator)
		throws com.placecube.nhs.userprofile.exception.
			NoSuchProfessionalBodyException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first professional body in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching professional body, or <code>null</code> if a matching professional body could not be found
	 */
	public static ProfessionalBody fetchByUserId_First(
		long userId, OrderByComparator<ProfessionalBody> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last professional body in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching professional body
	 * @throws NoSuchProfessionalBodyException if a matching professional body could not be found
	 */
	public static ProfessionalBody findByUserId_Last(
			long userId, OrderByComparator<ProfessionalBody> orderByComparator)
		throws com.placecube.nhs.userprofile.exception.
			NoSuchProfessionalBodyException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last professional body in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching professional body, or <code>null</code> if a matching professional body could not be found
	 */
	public static ProfessionalBody fetchByUserId_Last(
		long userId, OrderByComparator<ProfessionalBody> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the professional bodies before and after the current professional body in the ordered set where userId = &#63;.
	 *
	 * @param professionalBodyId the primary key of the current professional body
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next professional body
	 * @throws NoSuchProfessionalBodyException if a professional body with the primary key could not be found
	 */
	public static ProfessionalBody[] findByUserId_PrevAndNext(
			long professionalBodyId, long userId,
			OrderByComparator<ProfessionalBody> orderByComparator)
		throws com.placecube.nhs.userprofile.exception.
			NoSuchProfessionalBodyException {

		return getPersistence().findByUserId_PrevAndNext(
			professionalBodyId, userId, orderByComparator);
	}

	/**
	 * Removes all the professional bodies where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of professional bodies where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching professional bodies
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Caches the professional body in the entity cache if it is enabled.
	 *
	 * @param professionalBody the professional body
	 */
	public static void cacheResult(ProfessionalBody professionalBody) {
		getPersistence().cacheResult(professionalBody);
	}

	/**
	 * Caches the professional bodies in the entity cache if it is enabled.
	 *
	 * @param professionalBodies the professional bodies
	 */
	public static void cacheResult(List<ProfessionalBody> professionalBodies) {
		getPersistence().cacheResult(professionalBodies);
	}

	/**
	 * Creates a new professional body with the primary key. Does not add the professional body to the database.
	 *
	 * @param professionalBodyId the primary key for the new professional body
	 * @return the new professional body
	 */
	public static ProfessionalBody create(long professionalBodyId) {
		return getPersistence().create(professionalBodyId);
	}

	/**
	 * Removes the professional body with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param professionalBodyId the primary key of the professional body
	 * @return the professional body that was removed
	 * @throws NoSuchProfessionalBodyException if a professional body with the primary key could not be found
	 */
	public static ProfessionalBody remove(long professionalBodyId)
		throws com.placecube.nhs.userprofile.exception.
			NoSuchProfessionalBodyException {

		return getPersistence().remove(professionalBodyId);
	}

	public static ProfessionalBody updateImpl(
		ProfessionalBody professionalBody) {

		return getPersistence().updateImpl(professionalBody);
	}

	/**
	 * Returns the professional body with the primary key or throws a <code>NoSuchProfessionalBodyException</code> if it could not be found.
	 *
	 * @param professionalBodyId the primary key of the professional body
	 * @return the professional body
	 * @throws NoSuchProfessionalBodyException if a professional body with the primary key could not be found
	 */
	public static ProfessionalBody findByPrimaryKey(long professionalBodyId)
		throws com.placecube.nhs.userprofile.exception.
			NoSuchProfessionalBodyException {

		return getPersistence().findByPrimaryKey(professionalBodyId);
	}

	/**
	 * Returns the professional body with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param professionalBodyId the primary key of the professional body
	 * @return the professional body, or <code>null</code> if a professional body with the primary key could not be found
	 */
	public static ProfessionalBody fetchByPrimaryKey(long professionalBodyId) {
		return getPersistence().fetchByPrimaryKey(professionalBodyId);
	}

	/**
	 * Returns all the professional bodies.
	 *
	 * @return the professional bodies
	 */
	public static List<ProfessionalBody> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the professional bodies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProfessionalBodyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of professional bodies
	 * @param end the upper bound of the range of professional bodies (not inclusive)
	 * @return the range of professional bodies
	 */
	public static List<ProfessionalBody> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the professional bodies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProfessionalBodyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of professional bodies
	 * @param end the upper bound of the range of professional bodies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of professional bodies
	 */
	public static List<ProfessionalBody> findAll(
		int start, int end,
		OrderByComparator<ProfessionalBody> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the professional bodies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProfessionalBodyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of professional bodies
	 * @param end the upper bound of the range of professional bodies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of professional bodies
	 */
	public static List<ProfessionalBody> findAll(
		int start, int end,
		OrderByComparator<ProfessionalBody> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the professional bodies from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of professional bodies.
	 *
	 * @return the number of professional bodies
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProfessionalBodyPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ProfessionalBodyPersistence, ProfessionalBodyPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ProfessionalBodyPersistence.class);

		ServiceTracker<ProfessionalBodyPersistence, ProfessionalBodyPersistence>
			serviceTracker =
				new ServiceTracker
					<ProfessionalBodyPersistence, ProfessionalBodyPersistence>(
						bundle.getBundleContext(),
						ProfessionalBodyPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}