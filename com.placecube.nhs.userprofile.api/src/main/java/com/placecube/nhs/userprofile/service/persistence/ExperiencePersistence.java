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

import com.placecube.nhs.userprofile.exception.NoSuchExperienceException;
import com.placecube.nhs.userprofile.model.Experience;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the experience service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExperienceUtil
 * @generated
 */
@ProviderType
public interface ExperiencePersistence extends BasePersistence<Experience> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ExperienceUtil} to access the experience persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the experiences where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching experiences
	 */
	public java.util.List<Experience> findByUuid(String uuid);

	/**
	 * Returns a range of all the experiences where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ExperienceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of experiences
	 * @param end the upper bound of the range of experiences (not inclusive)
	 * @return the range of matching experiences
	 */
	public java.util.List<Experience> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the experiences where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ExperienceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of experiences
	 * @param end the upper bound of the range of experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching experiences
	 */
	public java.util.List<Experience> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Experience>
			orderByComparator);

	/**
	 * Returns an ordered range of all the experiences where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ExperienceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of experiences
	 * @param end the upper bound of the range of experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching experiences
	 */
	public java.util.List<Experience> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Experience>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first experience in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experience
	 * @throws NoSuchExperienceException if a matching experience could not be found
	 */
	public Experience findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Experience>
				orderByComparator)
		throws NoSuchExperienceException;

	/**
	 * Returns the first experience in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experience, or <code>null</code> if a matching experience could not be found
	 */
	public Experience fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Experience>
			orderByComparator);

	/**
	 * Returns the last experience in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experience
	 * @throws NoSuchExperienceException if a matching experience could not be found
	 */
	public Experience findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Experience>
				orderByComparator)
		throws NoSuchExperienceException;

	/**
	 * Returns the last experience in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experience, or <code>null</code> if a matching experience could not be found
	 */
	public Experience fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Experience>
			orderByComparator);

	/**
	 * Returns the experiences before and after the current experience in the ordered set where uuid = &#63;.
	 *
	 * @param experienceId the primary key of the current experience
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next experience
	 * @throws NoSuchExperienceException if a experience with the primary key could not be found
	 */
	public Experience[] findByUuid_PrevAndNext(
			long experienceId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Experience>
				orderByComparator)
		throws NoSuchExperienceException;

	/**
	 * Removes all the experiences where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of experiences where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching experiences
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the experiences where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching experiences
	 */
	public java.util.List<Experience> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the experiences where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ExperienceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of experiences
	 * @param end the upper bound of the range of experiences (not inclusive)
	 * @return the range of matching experiences
	 */
	public java.util.List<Experience> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the experiences where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ExperienceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of experiences
	 * @param end the upper bound of the range of experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching experiences
	 */
	public java.util.List<Experience> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Experience>
			orderByComparator);

	/**
	 * Returns an ordered range of all the experiences where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ExperienceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of experiences
	 * @param end the upper bound of the range of experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching experiences
	 */
	public java.util.List<Experience> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Experience>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first experience in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experience
	 * @throws NoSuchExperienceException if a matching experience could not be found
	 */
	public Experience findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Experience>
				orderByComparator)
		throws NoSuchExperienceException;

	/**
	 * Returns the first experience in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experience, or <code>null</code> if a matching experience could not be found
	 */
	public Experience fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Experience>
			orderByComparator);

	/**
	 * Returns the last experience in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experience
	 * @throws NoSuchExperienceException if a matching experience could not be found
	 */
	public Experience findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Experience>
				orderByComparator)
		throws NoSuchExperienceException;

	/**
	 * Returns the last experience in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experience, or <code>null</code> if a matching experience could not be found
	 */
	public Experience fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Experience>
			orderByComparator);

	/**
	 * Returns the experiences before and after the current experience in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param experienceId the primary key of the current experience
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next experience
	 * @throws NoSuchExperienceException if a experience with the primary key could not be found
	 */
	public Experience[] findByUuid_C_PrevAndNext(
			long experienceId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Experience>
				orderByComparator)
		throws NoSuchExperienceException;

	/**
	 * Removes all the experiences where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of experiences where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching experiences
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the experiences where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching experiences
	 */
	public java.util.List<Experience> findByUserId(long userId);

	/**
	 * Returns a range of all the experiences where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ExperienceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of experiences
	 * @param end the upper bound of the range of experiences (not inclusive)
	 * @return the range of matching experiences
	 */
	public java.util.List<Experience> findByUserId(
		long userId, int start, int end);

	/**
	 * Returns an ordered range of all the experiences where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ExperienceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of experiences
	 * @param end the upper bound of the range of experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching experiences
	 */
	public java.util.List<Experience> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Experience>
			orderByComparator);

	/**
	 * Returns an ordered range of all the experiences where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ExperienceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of experiences
	 * @param end the upper bound of the range of experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching experiences
	 */
	public java.util.List<Experience> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Experience>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first experience in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experience
	 * @throws NoSuchExperienceException if a matching experience could not be found
	 */
	public Experience findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Experience>
				orderByComparator)
		throws NoSuchExperienceException;

	/**
	 * Returns the first experience in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experience, or <code>null</code> if a matching experience could not be found
	 */
	public Experience fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Experience>
			orderByComparator);

	/**
	 * Returns the last experience in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experience
	 * @throws NoSuchExperienceException if a matching experience could not be found
	 */
	public Experience findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Experience>
				orderByComparator)
		throws NoSuchExperienceException;

	/**
	 * Returns the last experience in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experience, or <code>null</code> if a matching experience could not be found
	 */
	public Experience fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Experience>
			orderByComparator);

	/**
	 * Returns the experiences before and after the current experience in the ordered set where userId = &#63;.
	 *
	 * @param experienceId the primary key of the current experience
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next experience
	 * @throws NoSuchExperienceException if a experience with the primary key could not be found
	 */
	public Experience[] findByUserId_PrevAndNext(
			long experienceId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Experience>
				orderByComparator)
		throws NoSuchExperienceException;

	/**
	 * Removes all the experiences where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of experiences where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching experiences
	 */
	public int countByUserId(long userId);

	/**
	 * Caches the experience in the entity cache if it is enabled.
	 *
	 * @param experience the experience
	 */
	public void cacheResult(Experience experience);

	/**
	 * Caches the experiences in the entity cache if it is enabled.
	 *
	 * @param experiences the experiences
	 */
	public void cacheResult(java.util.List<Experience> experiences);

	/**
	 * Creates a new experience with the primary key. Does not add the experience to the database.
	 *
	 * @param experienceId the primary key for the new experience
	 * @return the new experience
	 */
	public Experience create(long experienceId);

	/**
	 * Removes the experience with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param experienceId the primary key of the experience
	 * @return the experience that was removed
	 * @throws NoSuchExperienceException if a experience with the primary key could not be found
	 */
	public Experience remove(long experienceId)
		throws NoSuchExperienceException;

	public Experience updateImpl(Experience experience);

	/**
	 * Returns the experience with the primary key or throws a <code>NoSuchExperienceException</code> if it could not be found.
	 *
	 * @param experienceId the primary key of the experience
	 * @return the experience
	 * @throws NoSuchExperienceException if a experience with the primary key could not be found
	 */
	public Experience findByPrimaryKey(long experienceId)
		throws NoSuchExperienceException;

	/**
	 * Returns the experience with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param experienceId the primary key of the experience
	 * @return the experience, or <code>null</code> if a experience with the primary key could not be found
	 */
	public Experience fetchByPrimaryKey(long experienceId);

	/**
	 * Returns all the experiences.
	 *
	 * @return the experiences
	 */
	public java.util.List<Experience> findAll();

	/**
	 * Returns a range of all the experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ExperienceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of experiences
	 * @param end the upper bound of the range of experiences (not inclusive)
	 * @return the range of experiences
	 */
	public java.util.List<Experience> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ExperienceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of experiences
	 * @param end the upper bound of the range of experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of experiences
	 */
	public java.util.List<Experience> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Experience>
			orderByComparator);

	/**
	 * Returns an ordered range of all the experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ExperienceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of experiences
	 * @param end the upper bound of the range of experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of experiences
	 */
	public java.util.List<Experience> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Experience>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the experiences from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of experiences.
	 *
	 * @return the number of experiences
	 */
	public int countAll();

}