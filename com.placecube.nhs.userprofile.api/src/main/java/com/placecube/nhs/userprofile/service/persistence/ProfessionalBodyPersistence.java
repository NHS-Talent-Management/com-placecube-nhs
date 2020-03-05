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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.placecube.nhs.userprofile.exception.NoSuchProfessionalBodyException;
import com.placecube.nhs.userprofile.model.ProfessionalBody;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the professional body service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProfessionalBodyUtil
 * @generated
 */
@ProviderType
public interface ProfessionalBodyPersistence
	extends BasePersistence<ProfessionalBody> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProfessionalBodyUtil} to access the professional body persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the professional bodies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching professional bodies
	 */
	public java.util.List<ProfessionalBody> findByUuid(String uuid);

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
	public java.util.List<ProfessionalBody> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<ProfessionalBody> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProfessionalBody>
			orderByComparator);

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
	public java.util.List<ProfessionalBody> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProfessionalBody>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first professional body in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching professional body
	 * @throws NoSuchProfessionalBodyException if a matching professional body could not be found
	 */
	public ProfessionalBody findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProfessionalBody>
				orderByComparator)
		throws NoSuchProfessionalBodyException;

	/**
	 * Returns the first professional body in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching professional body, or <code>null</code> if a matching professional body could not be found
	 */
	public ProfessionalBody fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProfessionalBody>
			orderByComparator);

	/**
	 * Returns the last professional body in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching professional body
	 * @throws NoSuchProfessionalBodyException if a matching professional body could not be found
	 */
	public ProfessionalBody findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProfessionalBody>
				orderByComparator)
		throws NoSuchProfessionalBodyException;

	/**
	 * Returns the last professional body in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching professional body, or <code>null</code> if a matching professional body could not be found
	 */
	public ProfessionalBody fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProfessionalBody>
			orderByComparator);

	/**
	 * Returns the professional bodies before and after the current professional body in the ordered set where uuid = &#63;.
	 *
	 * @param professionalBodyId the primary key of the current professional body
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next professional body
	 * @throws NoSuchProfessionalBodyException if a professional body with the primary key could not be found
	 */
	public ProfessionalBody[] findByUuid_PrevAndNext(
			long professionalBodyId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProfessionalBody>
				orderByComparator)
		throws NoSuchProfessionalBodyException;

	/**
	 * Removes all the professional bodies where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of professional bodies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching professional bodies
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the professional bodies where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching professional bodies
	 */
	public java.util.List<ProfessionalBody> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<ProfessionalBody> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<ProfessionalBody> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProfessionalBody>
			orderByComparator);

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
	public java.util.List<ProfessionalBody> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProfessionalBody>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first professional body in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching professional body
	 * @throws NoSuchProfessionalBodyException if a matching professional body could not be found
	 */
	public ProfessionalBody findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProfessionalBody>
				orderByComparator)
		throws NoSuchProfessionalBodyException;

	/**
	 * Returns the first professional body in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching professional body, or <code>null</code> if a matching professional body could not be found
	 */
	public ProfessionalBody fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProfessionalBody>
			orderByComparator);

	/**
	 * Returns the last professional body in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching professional body
	 * @throws NoSuchProfessionalBodyException if a matching professional body could not be found
	 */
	public ProfessionalBody findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProfessionalBody>
				orderByComparator)
		throws NoSuchProfessionalBodyException;

	/**
	 * Returns the last professional body in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching professional body, or <code>null</code> if a matching professional body could not be found
	 */
	public ProfessionalBody fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProfessionalBody>
			orderByComparator);

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
	public ProfessionalBody[] findByUuid_C_PrevAndNext(
			long professionalBodyId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProfessionalBody>
				orderByComparator)
		throws NoSuchProfessionalBodyException;

	/**
	 * Removes all the professional bodies where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of professional bodies where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching professional bodies
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the professional bodies where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching professional bodies
	 */
	public java.util.List<ProfessionalBody> findByUserId(long userId);

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
	public java.util.List<ProfessionalBody> findByUserId(
		long userId, int start, int end);

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
	public java.util.List<ProfessionalBody> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProfessionalBody>
			orderByComparator);

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
	public java.util.List<ProfessionalBody> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProfessionalBody>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first professional body in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching professional body
	 * @throws NoSuchProfessionalBodyException if a matching professional body could not be found
	 */
	public ProfessionalBody findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<ProfessionalBody>
				orderByComparator)
		throws NoSuchProfessionalBodyException;

	/**
	 * Returns the first professional body in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching professional body, or <code>null</code> if a matching professional body could not be found
	 */
	public ProfessionalBody fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<ProfessionalBody>
			orderByComparator);

	/**
	 * Returns the last professional body in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching professional body
	 * @throws NoSuchProfessionalBodyException if a matching professional body could not be found
	 */
	public ProfessionalBody findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<ProfessionalBody>
				orderByComparator)
		throws NoSuchProfessionalBodyException;

	/**
	 * Returns the last professional body in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching professional body, or <code>null</code> if a matching professional body could not be found
	 */
	public ProfessionalBody fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<ProfessionalBody>
			orderByComparator);

	/**
	 * Returns the professional bodies before and after the current professional body in the ordered set where userId = &#63;.
	 *
	 * @param professionalBodyId the primary key of the current professional body
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next professional body
	 * @throws NoSuchProfessionalBodyException if a professional body with the primary key could not be found
	 */
	public ProfessionalBody[] findByUserId_PrevAndNext(
			long professionalBodyId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<ProfessionalBody>
				orderByComparator)
		throws NoSuchProfessionalBodyException;

	/**
	 * Removes all the professional bodies where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of professional bodies where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching professional bodies
	 */
	public int countByUserId(long userId);

	/**
	 * Caches the professional body in the entity cache if it is enabled.
	 *
	 * @param professionalBody the professional body
	 */
	public void cacheResult(ProfessionalBody professionalBody);

	/**
	 * Caches the professional bodies in the entity cache if it is enabled.
	 *
	 * @param professionalBodies the professional bodies
	 */
	public void cacheResult(
		java.util.List<ProfessionalBody> professionalBodies);

	/**
	 * Creates a new professional body with the primary key. Does not add the professional body to the database.
	 *
	 * @param professionalBodyId the primary key for the new professional body
	 * @return the new professional body
	 */
	public ProfessionalBody create(long professionalBodyId);

	/**
	 * Removes the professional body with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param professionalBodyId the primary key of the professional body
	 * @return the professional body that was removed
	 * @throws NoSuchProfessionalBodyException if a professional body with the primary key could not be found
	 */
	public ProfessionalBody remove(long professionalBodyId)
		throws NoSuchProfessionalBodyException;

	public ProfessionalBody updateImpl(ProfessionalBody professionalBody);

	/**
	 * Returns the professional body with the primary key or throws a <code>NoSuchProfessionalBodyException</code> if it could not be found.
	 *
	 * @param professionalBodyId the primary key of the professional body
	 * @return the professional body
	 * @throws NoSuchProfessionalBodyException if a professional body with the primary key could not be found
	 */
	public ProfessionalBody findByPrimaryKey(long professionalBodyId)
		throws NoSuchProfessionalBodyException;

	/**
	 * Returns the professional body with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param professionalBodyId the primary key of the professional body
	 * @return the professional body, or <code>null</code> if a professional body with the primary key could not be found
	 */
	public ProfessionalBody fetchByPrimaryKey(long professionalBodyId);

	/**
	 * Returns all the professional bodies.
	 *
	 * @return the professional bodies
	 */
	public java.util.List<ProfessionalBody> findAll();

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
	public java.util.List<ProfessionalBody> findAll(int start, int end);

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
	public java.util.List<ProfessionalBody> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProfessionalBody>
			orderByComparator);

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
	public java.util.List<ProfessionalBody> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProfessionalBody>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the professional bodies from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of professional bodies.
	 *
	 * @return the number of professional bodies
	 */
	public int countAll();

}