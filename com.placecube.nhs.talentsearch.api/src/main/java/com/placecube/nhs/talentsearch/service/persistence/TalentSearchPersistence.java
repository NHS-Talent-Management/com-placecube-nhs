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

package com.placecube.nhs.talentsearch.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.placecube.nhs.talentsearch.exception.NoSuchTalentSearchException;
import com.placecube.nhs.talentsearch.model.TalentSearch;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the talent search service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TalentSearchUtil
 * @generated
 */
@ProviderType
public interface TalentSearchPersistence extends BasePersistence<TalentSearch> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TalentSearchUtil} to access the talent search persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the talent searchs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching talent searchs
	 */
	public java.util.List<TalentSearch> findByUuid(String uuid);

	/**
	 * Returns a range of all the talent searchs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TalentSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of talent searchs
	 * @param end the upper bound of the range of talent searchs (not inclusive)
	 * @return the range of matching talent searchs
	 */
	public java.util.List<TalentSearch> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the talent searchs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TalentSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of talent searchs
	 * @param end the upper bound of the range of talent searchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching talent searchs
	 */
	public java.util.List<TalentSearch> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TalentSearch>
			orderByComparator);

	/**
	 * Returns an ordered range of all the talent searchs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TalentSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of talent searchs
	 * @param end the upper bound of the range of talent searchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching talent searchs
	 */
	public java.util.List<TalentSearch> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TalentSearch>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first talent search in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching talent search
	 * @throws NoSuchTalentSearchException if a matching talent search could not be found
	 */
	public TalentSearch findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TalentSearch>
				orderByComparator)
		throws NoSuchTalentSearchException;

	/**
	 * Returns the first talent search in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching talent search, or <code>null</code> if a matching talent search could not be found
	 */
	public TalentSearch fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TalentSearch>
			orderByComparator);

	/**
	 * Returns the last talent search in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching talent search
	 * @throws NoSuchTalentSearchException if a matching talent search could not be found
	 */
	public TalentSearch findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TalentSearch>
				orderByComparator)
		throws NoSuchTalentSearchException;

	/**
	 * Returns the last talent search in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching talent search, or <code>null</code> if a matching talent search could not be found
	 */
	public TalentSearch fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TalentSearch>
			orderByComparator);

	/**
	 * Returns the talent searchs before and after the current talent search in the ordered set where uuid = &#63;.
	 *
	 * @param talentSearchId the primary key of the current talent search
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next talent search
	 * @throws NoSuchTalentSearchException if a talent search with the primary key could not be found
	 */
	public TalentSearch[] findByUuid_PrevAndNext(
			long talentSearchId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TalentSearch>
				orderByComparator)
		throws NoSuchTalentSearchException;

	/**
	 * Removes all the talent searchs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of talent searchs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching talent searchs
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the talent searchs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching talent searchs
	 */
	public java.util.List<TalentSearch> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the talent searchs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TalentSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of talent searchs
	 * @param end the upper bound of the range of talent searchs (not inclusive)
	 * @return the range of matching talent searchs
	 */
	public java.util.List<TalentSearch> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the talent searchs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TalentSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of talent searchs
	 * @param end the upper bound of the range of talent searchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching talent searchs
	 */
	public java.util.List<TalentSearch> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TalentSearch>
			orderByComparator);

	/**
	 * Returns an ordered range of all the talent searchs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TalentSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of talent searchs
	 * @param end the upper bound of the range of talent searchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching talent searchs
	 */
	public java.util.List<TalentSearch> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TalentSearch>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first talent search in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching talent search
	 * @throws NoSuchTalentSearchException if a matching talent search could not be found
	 */
	public TalentSearch findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TalentSearch>
				orderByComparator)
		throws NoSuchTalentSearchException;

	/**
	 * Returns the first talent search in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching talent search, or <code>null</code> if a matching talent search could not be found
	 */
	public TalentSearch fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TalentSearch>
			orderByComparator);

	/**
	 * Returns the last talent search in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching talent search
	 * @throws NoSuchTalentSearchException if a matching talent search could not be found
	 */
	public TalentSearch findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TalentSearch>
				orderByComparator)
		throws NoSuchTalentSearchException;

	/**
	 * Returns the last talent search in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching talent search, or <code>null</code> if a matching talent search could not be found
	 */
	public TalentSearch fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TalentSearch>
			orderByComparator);

	/**
	 * Returns the talent searchs before and after the current talent search in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param talentSearchId the primary key of the current talent search
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next talent search
	 * @throws NoSuchTalentSearchException if a talent search with the primary key could not be found
	 */
	public TalentSearch[] findByUuid_C_PrevAndNext(
			long talentSearchId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TalentSearch>
				orderByComparator)
		throws NoSuchTalentSearchException;

	/**
	 * Removes all the talent searchs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of talent searchs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching talent searchs
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the talent searchs where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching talent searchs
	 */
	public java.util.List<TalentSearch> findByUserId(long userId);

	/**
	 * Returns a range of all the talent searchs where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TalentSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of talent searchs
	 * @param end the upper bound of the range of talent searchs (not inclusive)
	 * @return the range of matching talent searchs
	 */
	public java.util.List<TalentSearch> findByUserId(
		long userId, int start, int end);

	/**
	 * Returns an ordered range of all the talent searchs where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TalentSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of talent searchs
	 * @param end the upper bound of the range of talent searchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching talent searchs
	 */
	public java.util.List<TalentSearch> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TalentSearch>
			orderByComparator);

	/**
	 * Returns an ordered range of all the talent searchs where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TalentSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of talent searchs
	 * @param end the upper bound of the range of talent searchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching talent searchs
	 */
	public java.util.List<TalentSearch> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TalentSearch>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first talent search in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching talent search
	 * @throws NoSuchTalentSearchException if a matching talent search could not be found
	 */
	public TalentSearch findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<TalentSearch>
				orderByComparator)
		throws NoSuchTalentSearchException;

	/**
	 * Returns the first talent search in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching talent search, or <code>null</code> if a matching talent search could not be found
	 */
	public TalentSearch fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<TalentSearch>
			orderByComparator);

	/**
	 * Returns the last talent search in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching talent search
	 * @throws NoSuchTalentSearchException if a matching talent search could not be found
	 */
	public TalentSearch findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<TalentSearch>
				orderByComparator)
		throws NoSuchTalentSearchException;

	/**
	 * Returns the last talent search in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching talent search, or <code>null</code> if a matching talent search could not be found
	 */
	public TalentSearch fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<TalentSearch>
			orderByComparator);

	/**
	 * Returns the talent searchs before and after the current talent search in the ordered set where userId = &#63;.
	 *
	 * @param talentSearchId the primary key of the current talent search
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next talent search
	 * @throws NoSuchTalentSearchException if a talent search with the primary key could not be found
	 */
	public TalentSearch[] findByUserId_PrevAndNext(
			long talentSearchId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<TalentSearch>
				orderByComparator)
		throws NoSuchTalentSearchException;

	/**
	 * Removes all the talent searchs where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of talent searchs where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching talent searchs
	 */
	public int countByUserId(long userId);

	/**
	 * Caches the talent search in the entity cache if it is enabled.
	 *
	 * @param talentSearch the talent search
	 */
	public void cacheResult(TalentSearch talentSearch);

	/**
	 * Caches the talent searchs in the entity cache if it is enabled.
	 *
	 * @param talentSearchs the talent searchs
	 */
	public void cacheResult(java.util.List<TalentSearch> talentSearchs);

	/**
	 * Creates a new talent search with the primary key. Does not add the talent search to the database.
	 *
	 * @param talentSearchId the primary key for the new talent search
	 * @return the new talent search
	 */
	public TalentSearch create(long talentSearchId);

	/**
	 * Removes the talent search with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param talentSearchId the primary key of the talent search
	 * @return the talent search that was removed
	 * @throws NoSuchTalentSearchException if a talent search with the primary key could not be found
	 */
	public TalentSearch remove(long talentSearchId)
		throws NoSuchTalentSearchException;

	public TalentSearch updateImpl(TalentSearch talentSearch);

	/**
	 * Returns the talent search with the primary key or throws a <code>NoSuchTalentSearchException</code> if it could not be found.
	 *
	 * @param talentSearchId the primary key of the talent search
	 * @return the talent search
	 * @throws NoSuchTalentSearchException if a talent search with the primary key could not be found
	 */
	public TalentSearch findByPrimaryKey(long talentSearchId)
		throws NoSuchTalentSearchException;

	/**
	 * Returns the talent search with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param talentSearchId the primary key of the talent search
	 * @return the talent search, or <code>null</code> if a talent search with the primary key could not be found
	 */
	public TalentSearch fetchByPrimaryKey(long talentSearchId);

	/**
	 * Returns all the talent searchs.
	 *
	 * @return the talent searchs
	 */
	public java.util.List<TalentSearch> findAll();

	/**
	 * Returns a range of all the talent searchs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TalentSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of talent searchs
	 * @param end the upper bound of the range of talent searchs (not inclusive)
	 * @return the range of talent searchs
	 */
	public java.util.List<TalentSearch> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the talent searchs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TalentSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of talent searchs
	 * @param end the upper bound of the range of talent searchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of talent searchs
	 */
	public java.util.List<TalentSearch> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TalentSearch>
			orderByComparator);

	/**
	 * Returns an ordered range of all the talent searchs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TalentSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of talent searchs
	 * @param end the upper bound of the range of talent searchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of talent searchs
	 */
	public java.util.List<TalentSearch> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TalentSearch>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the talent searchs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of talent searchs.
	 *
	 * @return the number of talent searchs
	 */
	public int countAll();

}