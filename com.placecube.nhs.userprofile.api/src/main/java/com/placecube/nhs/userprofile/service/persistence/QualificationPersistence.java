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

import com.placecube.nhs.userprofile.exception.NoSuchQualificationException;
import com.placecube.nhs.userprofile.model.Qualification;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the qualification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QualificationUtil
 * @generated
 */
@ProviderType
public interface QualificationPersistence
	extends BasePersistence<Qualification> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link QualificationUtil} to access the qualification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the qualifications where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching qualifications
	 */
	public java.util.List<Qualification> findByUuid(String uuid);

	/**
	 * Returns a range of all the qualifications where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QualificationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of qualifications
	 * @param end the upper bound of the range of qualifications (not inclusive)
	 * @return the range of matching qualifications
	 */
	public java.util.List<Qualification> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the qualifications where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QualificationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of qualifications
	 * @param end the upper bound of the range of qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching qualifications
	 */
	public java.util.List<Qualification> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Qualification>
			orderByComparator);

	/**
	 * Returns an ordered range of all the qualifications where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QualificationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of qualifications
	 * @param end the upper bound of the range of qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching qualifications
	 */
	public java.util.List<Qualification> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Qualification>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first qualification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification
	 * @throws NoSuchQualificationException if a matching qualification could not be found
	 */
	public Qualification findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Qualification>
				orderByComparator)
		throws NoSuchQualificationException;

	/**
	 * Returns the first qualification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification, or <code>null</code> if a matching qualification could not be found
	 */
	public Qualification fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Qualification>
			orderByComparator);

	/**
	 * Returns the last qualification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification
	 * @throws NoSuchQualificationException if a matching qualification could not be found
	 */
	public Qualification findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Qualification>
				orderByComparator)
		throws NoSuchQualificationException;

	/**
	 * Returns the last qualification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification, or <code>null</code> if a matching qualification could not be found
	 */
	public Qualification fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Qualification>
			orderByComparator);

	/**
	 * Returns the qualifications before and after the current qualification in the ordered set where uuid = &#63;.
	 *
	 * @param qualificationId the primary key of the current qualification
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next qualification
	 * @throws NoSuchQualificationException if a qualification with the primary key could not be found
	 */
	public Qualification[] findByUuid_PrevAndNext(
			long qualificationId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Qualification>
				orderByComparator)
		throws NoSuchQualificationException;

	/**
	 * Removes all the qualifications where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of qualifications where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching qualifications
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the qualifications where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching qualifications
	 */
	public java.util.List<Qualification> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the qualifications where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QualificationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of qualifications
	 * @param end the upper bound of the range of qualifications (not inclusive)
	 * @return the range of matching qualifications
	 */
	public java.util.List<Qualification> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the qualifications where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QualificationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of qualifications
	 * @param end the upper bound of the range of qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching qualifications
	 */
	public java.util.List<Qualification> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Qualification>
			orderByComparator);

	/**
	 * Returns an ordered range of all the qualifications where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QualificationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of qualifications
	 * @param end the upper bound of the range of qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching qualifications
	 */
	public java.util.List<Qualification> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Qualification>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first qualification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification
	 * @throws NoSuchQualificationException if a matching qualification could not be found
	 */
	public Qualification findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Qualification>
				orderByComparator)
		throws NoSuchQualificationException;

	/**
	 * Returns the first qualification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification, or <code>null</code> if a matching qualification could not be found
	 */
	public Qualification fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Qualification>
			orderByComparator);

	/**
	 * Returns the last qualification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification
	 * @throws NoSuchQualificationException if a matching qualification could not be found
	 */
	public Qualification findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Qualification>
				orderByComparator)
		throws NoSuchQualificationException;

	/**
	 * Returns the last qualification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification, or <code>null</code> if a matching qualification could not be found
	 */
	public Qualification fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Qualification>
			orderByComparator);

	/**
	 * Returns the qualifications before and after the current qualification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param qualificationId the primary key of the current qualification
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next qualification
	 * @throws NoSuchQualificationException if a qualification with the primary key could not be found
	 */
	public Qualification[] findByUuid_C_PrevAndNext(
			long qualificationId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Qualification>
				orderByComparator)
		throws NoSuchQualificationException;

	/**
	 * Removes all the qualifications where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of qualifications where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching qualifications
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the qualifications where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching qualifications
	 */
	public java.util.List<Qualification> findByUserId(long userId);

	/**
	 * Returns a range of all the qualifications where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QualificationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of qualifications
	 * @param end the upper bound of the range of qualifications (not inclusive)
	 * @return the range of matching qualifications
	 */
	public java.util.List<Qualification> findByUserId(
		long userId, int start, int end);

	/**
	 * Returns an ordered range of all the qualifications where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QualificationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of qualifications
	 * @param end the upper bound of the range of qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching qualifications
	 */
	public java.util.List<Qualification> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Qualification>
			orderByComparator);

	/**
	 * Returns an ordered range of all the qualifications where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QualificationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of qualifications
	 * @param end the upper bound of the range of qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching qualifications
	 */
	public java.util.List<Qualification> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Qualification>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first qualification in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification
	 * @throws NoSuchQualificationException if a matching qualification could not be found
	 */
	public Qualification findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Qualification>
				orderByComparator)
		throws NoSuchQualificationException;

	/**
	 * Returns the first qualification in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification, or <code>null</code> if a matching qualification could not be found
	 */
	public Qualification fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Qualification>
			orderByComparator);

	/**
	 * Returns the last qualification in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification
	 * @throws NoSuchQualificationException if a matching qualification could not be found
	 */
	public Qualification findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Qualification>
				orderByComparator)
		throws NoSuchQualificationException;

	/**
	 * Returns the last qualification in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification, or <code>null</code> if a matching qualification could not be found
	 */
	public Qualification fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Qualification>
			orderByComparator);

	/**
	 * Returns the qualifications before and after the current qualification in the ordered set where userId = &#63;.
	 *
	 * @param qualificationId the primary key of the current qualification
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next qualification
	 * @throws NoSuchQualificationException if a qualification with the primary key could not be found
	 */
	public Qualification[] findByUserId_PrevAndNext(
			long qualificationId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Qualification>
				orderByComparator)
		throws NoSuchQualificationException;

	/**
	 * Removes all the qualifications where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of qualifications where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching qualifications
	 */
	public int countByUserId(long userId);

	/**
	 * Caches the qualification in the entity cache if it is enabled.
	 *
	 * @param qualification the qualification
	 */
	public void cacheResult(Qualification qualification);

	/**
	 * Caches the qualifications in the entity cache if it is enabled.
	 *
	 * @param qualifications the qualifications
	 */
	public void cacheResult(java.util.List<Qualification> qualifications);

	/**
	 * Creates a new qualification with the primary key. Does not add the qualification to the database.
	 *
	 * @param qualificationId the primary key for the new qualification
	 * @return the new qualification
	 */
	public Qualification create(long qualificationId);

	/**
	 * Removes the qualification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param qualificationId the primary key of the qualification
	 * @return the qualification that was removed
	 * @throws NoSuchQualificationException if a qualification with the primary key could not be found
	 */
	public Qualification remove(long qualificationId)
		throws NoSuchQualificationException;

	public Qualification updateImpl(Qualification qualification);

	/**
	 * Returns the qualification with the primary key or throws a <code>NoSuchQualificationException</code> if it could not be found.
	 *
	 * @param qualificationId the primary key of the qualification
	 * @return the qualification
	 * @throws NoSuchQualificationException if a qualification with the primary key could not be found
	 */
	public Qualification findByPrimaryKey(long qualificationId)
		throws NoSuchQualificationException;

	/**
	 * Returns the qualification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param qualificationId the primary key of the qualification
	 * @return the qualification, or <code>null</code> if a qualification with the primary key could not be found
	 */
	public Qualification fetchByPrimaryKey(long qualificationId);

	/**
	 * Returns all the qualifications.
	 *
	 * @return the qualifications
	 */
	public java.util.List<Qualification> findAll();

	/**
	 * Returns a range of all the qualifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QualificationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualifications
	 * @param end the upper bound of the range of qualifications (not inclusive)
	 * @return the range of qualifications
	 */
	public java.util.List<Qualification> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the qualifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QualificationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualifications
	 * @param end the upper bound of the range of qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of qualifications
	 */
	public java.util.List<Qualification> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Qualification>
			orderByComparator);

	/**
	 * Returns an ordered range of all the qualifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QualificationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualifications
	 * @param end the upper bound of the range of qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of qualifications
	 */
	public java.util.List<Qualification> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Qualification>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the qualifications from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of qualifications.
	 *
	 * @return the number of qualifications
	 */
	public int countAll();

}