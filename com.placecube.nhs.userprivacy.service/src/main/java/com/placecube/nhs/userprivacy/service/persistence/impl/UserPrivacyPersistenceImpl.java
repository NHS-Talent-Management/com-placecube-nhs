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

package com.placecube.nhs.userprivacy.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import com.placecube.nhs.userprivacy.exception.NoSuchUserPrivacyException;
import com.placecube.nhs.userprivacy.model.UserPrivacy;
import com.placecube.nhs.userprivacy.model.impl.UserPrivacyImpl;
import com.placecube.nhs.userprivacy.model.impl.UserPrivacyModelImpl;
import com.placecube.nhs.userprivacy.service.persistence.UserPrivacyPK;
import com.placecube.nhs.userprivacy.service.persistence.UserPrivacyPersistence;
import com.placecube.nhs.userprivacy.service.persistence.impl.constants.NHS_PrivacyPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the user privacy service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = UserPrivacyPersistence.class)
@ProviderType
public class UserPrivacyPersistenceImpl
	extends BasePersistenceImpl<UserPrivacy> implements UserPrivacyPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>UserPrivacyUtil</code> to access the user privacy persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		UserPrivacyImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the user privacies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user privacies
	 */
	@Override
	public List<UserPrivacy> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserPrivacy> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<UserPrivacy> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserPrivacy> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<UserPrivacy> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserPrivacy> orderByComparator,
		boolean retrieveFromCache) {

		uuid = Objects.toString(uuid, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByUuid;
			finderArgs = new Object[] {uuid};
		}
		else {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<UserPrivacy> list = null;

		if (retrieveFromCache) {
			list = (List<UserPrivacy>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserPrivacy userPrivacy : list) {
					if (!uuid.equals(userPrivacy.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_USERPRIVACY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(UserPrivacyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<UserPrivacy>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserPrivacy>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first user privacy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user privacy
	 * @throws NoSuchUserPrivacyException if a matching user privacy could not be found
	 */
	@Override
	public UserPrivacy findByUuid_First(
			String uuid, OrderByComparator<UserPrivacy> orderByComparator)
		throws NoSuchUserPrivacyException {

		UserPrivacy userPrivacy = fetchByUuid_First(uuid, orderByComparator);

		if (userPrivacy != null) {
			return userPrivacy;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchUserPrivacyException(msg.toString());
	}

	/**
	 * Returns the first user privacy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user privacy, or <code>null</code> if a matching user privacy could not be found
	 */
	@Override
	public UserPrivacy fetchByUuid_First(
		String uuid, OrderByComparator<UserPrivacy> orderByComparator) {

		List<UserPrivacy> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user privacy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user privacy
	 * @throws NoSuchUserPrivacyException if a matching user privacy could not be found
	 */
	@Override
	public UserPrivacy findByUuid_Last(
			String uuid, OrderByComparator<UserPrivacy> orderByComparator)
		throws NoSuchUserPrivacyException {

		UserPrivacy userPrivacy = fetchByUuid_Last(uuid, orderByComparator);

		if (userPrivacy != null) {
			return userPrivacy;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchUserPrivacyException(msg.toString());
	}

	/**
	 * Returns the last user privacy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user privacy, or <code>null</code> if a matching user privacy could not be found
	 */
	@Override
	public UserPrivacy fetchByUuid_Last(
		String uuid, OrderByComparator<UserPrivacy> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<UserPrivacy> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public UserPrivacy[] findByUuid_PrevAndNext(
			UserPrivacyPK userPrivacyPK, String uuid,
			OrderByComparator<UserPrivacy> orderByComparator)
		throws NoSuchUserPrivacyException {

		uuid = Objects.toString(uuid, "");

		UserPrivacy userPrivacy = findByPrimaryKey(userPrivacyPK);

		Session session = null;

		try {
			session = openSession();

			UserPrivacy[] array = new UserPrivacyImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, userPrivacy, uuid, orderByComparator, true);

			array[1] = userPrivacy;

			array[2] = getByUuid_PrevAndNext(
				session, userPrivacy, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserPrivacy getByUuid_PrevAndNext(
		Session session, UserPrivacy userPrivacy, String uuid,
		OrderByComparator<UserPrivacy> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERPRIVACY_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(UserPrivacyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(userPrivacy)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<UserPrivacy> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user privacies where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (UserPrivacy userPrivacy :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(userPrivacy);
		}
	}

	/**
	 * Returns the number of user privacies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user privacies
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERPRIVACY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"userPrivacy.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(userPrivacy.uuid IS NULL OR userPrivacy.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the user privacies where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching user privacies
	 */
	@Override
	public List<UserPrivacy> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserPrivacy> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<UserPrivacy> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UserPrivacy> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<UserPrivacy> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UserPrivacy> orderByComparator,
		boolean retrieveFromCache) {

		uuid = Objects.toString(uuid, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByUuid_C;
			finderArgs = new Object[] {uuid, companyId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<UserPrivacy> list = null;

		if (retrieveFromCache) {
			list = (List<UserPrivacy>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserPrivacy userPrivacy : list) {
					if (!uuid.equals(userPrivacy.getUuid()) ||
						(companyId != userPrivacy.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_USERPRIVACY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(UserPrivacyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<UserPrivacy>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserPrivacy>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public UserPrivacy findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<UserPrivacy> orderByComparator)
		throws NoSuchUserPrivacyException {

		UserPrivacy userPrivacy = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (userPrivacy != null) {
			return userPrivacy;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchUserPrivacyException(msg.toString());
	}

	/**
	 * Returns the first user privacy in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user privacy, or <code>null</code> if a matching user privacy could not be found
	 */
	@Override
	public UserPrivacy fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<UserPrivacy> orderByComparator) {

		List<UserPrivacy> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public UserPrivacy findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<UserPrivacy> orderByComparator)
		throws NoSuchUserPrivacyException {

		UserPrivacy userPrivacy = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (userPrivacy != null) {
			return userPrivacy;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchUserPrivacyException(msg.toString());
	}

	/**
	 * Returns the last user privacy in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user privacy, or <code>null</code> if a matching user privacy could not be found
	 */
	@Override
	public UserPrivacy fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<UserPrivacy> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<UserPrivacy> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public UserPrivacy[] findByUuid_C_PrevAndNext(
			UserPrivacyPK userPrivacyPK, String uuid, long companyId,
			OrderByComparator<UserPrivacy> orderByComparator)
		throws NoSuchUserPrivacyException {

		uuid = Objects.toString(uuid, "");

		UserPrivacy userPrivacy = findByPrimaryKey(userPrivacyPK);

		Session session = null;

		try {
			session = openSession();

			UserPrivacy[] array = new UserPrivacyImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, userPrivacy, uuid, companyId, orderByComparator, true);

			array[1] = userPrivacy;

			array[2] = getByUuid_C_PrevAndNext(
				session, userPrivacy, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserPrivacy getByUuid_C_PrevAndNext(
		Session session, UserPrivacy userPrivacy, String uuid, long companyId,
		OrderByComparator<UserPrivacy> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_USERPRIVACY_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(UserPrivacyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(userPrivacy)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<UserPrivacy> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user privacies where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (UserPrivacy userPrivacy :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(userPrivacy);
		}
	}

	/**
	 * Returns the number of user privacies where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching user privacies
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERPRIVACY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"userPrivacy.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(userPrivacy.uuid IS NULL OR userPrivacy.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"userPrivacy.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByUserId;
	private FinderPath _finderPathWithoutPaginationFindByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns all the user privacies where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching user privacies
	 */
	@Override
	public List<UserPrivacy> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserPrivacy> findByUserId(long userId, int start, int end) {
		return findByUserId(userId, start, end, null);
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
	@Override
	public List<UserPrivacy> findByUserId(
		long userId, int start, int end,
		OrderByComparator<UserPrivacy> orderByComparator) {

		return findByUserId(userId, start, end, orderByComparator, true);
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
	@Override
	public List<UserPrivacy> findByUserId(
		long userId, int start, int end,
		OrderByComparator<UserPrivacy> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByUserId;
			finderArgs = new Object[] {userId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByUserId;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<UserPrivacy> list = null;

		if (retrieveFromCache) {
			list = (List<UserPrivacy>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserPrivacy userPrivacy : list) {
					if ((userId != userPrivacy.getUserId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_USERPRIVACY_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(UserPrivacyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<UserPrivacy>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserPrivacy>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first user privacy in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user privacy
	 * @throws NoSuchUserPrivacyException if a matching user privacy could not be found
	 */
	@Override
	public UserPrivacy findByUserId_First(
			long userId, OrderByComparator<UserPrivacy> orderByComparator)
		throws NoSuchUserPrivacyException {

		UserPrivacy userPrivacy = fetchByUserId_First(
			userId, orderByComparator);

		if (userPrivacy != null) {
			return userPrivacy;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchUserPrivacyException(msg.toString());
	}

	/**
	 * Returns the first user privacy in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user privacy, or <code>null</code> if a matching user privacy could not be found
	 */
	@Override
	public UserPrivacy fetchByUserId_First(
		long userId, OrderByComparator<UserPrivacy> orderByComparator) {

		List<UserPrivacy> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user privacy in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user privacy
	 * @throws NoSuchUserPrivacyException if a matching user privacy could not be found
	 */
	@Override
	public UserPrivacy findByUserId_Last(
			long userId, OrderByComparator<UserPrivacy> orderByComparator)
		throws NoSuchUserPrivacyException {

		UserPrivacy userPrivacy = fetchByUserId_Last(userId, orderByComparator);

		if (userPrivacy != null) {
			return userPrivacy;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchUserPrivacyException(msg.toString());
	}

	/**
	 * Returns the last user privacy in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user privacy, or <code>null</code> if a matching user privacy could not be found
	 */
	@Override
	public UserPrivacy fetchByUserId_Last(
		long userId, OrderByComparator<UserPrivacy> orderByComparator) {

		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<UserPrivacy> list = findByUserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public UserPrivacy[] findByUserId_PrevAndNext(
			UserPrivacyPK userPrivacyPK, long userId,
			OrderByComparator<UserPrivacy> orderByComparator)
		throws NoSuchUserPrivacyException {

		UserPrivacy userPrivacy = findByPrimaryKey(userPrivacyPK);

		Session session = null;

		try {
			session = openSession();

			UserPrivacy[] array = new UserPrivacyImpl[3];

			array[0] = getByUserId_PrevAndNext(
				session, userPrivacy, userId, orderByComparator, true);

			array[1] = userPrivacy;

			array[2] = getByUserId_PrevAndNext(
				session, userPrivacy, userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserPrivacy getByUserId_PrevAndNext(
		Session session, UserPrivacy userPrivacy, long userId,
		OrderByComparator<UserPrivacy> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERPRIVACY_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(UserPrivacyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(userPrivacy)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<UserPrivacy> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user privacies where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (UserPrivacy userPrivacy :
				findByUserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(userPrivacy);
		}
	}

	/**
	 * Returns the number of user privacies where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user privacies
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERPRIVACY_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"userPrivacy.id.userId = ?";

	private FinderPath _finderPathWithPaginationFindByCompanyIdFieldId;
	private FinderPath _finderPathWithoutPaginationFindByCompanyIdFieldId;
	private FinderPath _finderPathCountByCompanyIdFieldId;

	/**
	 * Returns all the user privacies where companyId = &#63; and fieldId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @return the matching user privacies
	 */
	@Override
	public List<UserPrivacy> findByCompanyIdFieldId(
		long companyId, String fieldId) {

		return findByCompanyIdFieldId(
			companyId, fieldId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserPrivacy> findByCompanyIdFieldId(
		long companyId, String fieldId, int start, int end) {

		return findByCompanyIdFieldId(companyId, fieldId, start, end, null);
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
	@Override
	public List<UserPrivacy> findByCompanyIdFieldId(
		long companyId, String fieldId, int start, int end,
		OrderByComparator<UserPrivacy> orderByComparator) {

		return findByCompanyIdFieldId(
			companyId, fieldId, start, end, orderByComparator, true);
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
	@Override
	public List<UserPrivacy> findByCompanyIdFieldId(
		long companyId, String fieldId, int start, int end,
		OrderByComparator<UserPrivacy> orderByComparator,
		boolean retrieveFromCache) {

		fieldId = Objects.toString(fieldId, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByCompanyIdFieldId;
			finderArgs = new Object[] {companyId, fieldId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByCompanyIdFieldId;
			finderArgs = new Object[] {
				companyId, fieldId, start, end, orderByComparator
			};
		}

		List<UserPrivacy> list = null;

		if (retrieveFromCache) {
			list = (List<UserPrivacy>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserPrivacy userPrivacy : list) {
					if ((companyId != userPrivacy.getCompanyId()) ||
						!fieldId.equals(userPrivacy.getFieldId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_USERPRIVACY_WHERE);

			query.append(_FINDER_COLUMN_COMPANYIDFIELDID_COMPANYID_2);

			boolean bindFieldId = false;

			if (fieldId.isEmpty()) {
				query.append(_FINDER_COLUMN_COMPANYIDFIELDID_FIELDID_3);
			}
			else {
				bindFieldId = true;

				query.append(_FINDER_COLUMN_COMPANYIDFIELDID_FIELDID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(UserPrivacyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindFieldId) {
					qPos.add(fieldId);
				}

				if (!pagination) {
					list = (List<UserPrivacy>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserPrivacy>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public UserPrivacy findByCompanyIdFieldId_First(
			long companyId, String fieldId,
			OrderByComparator<UserPrivacy> orderByComparator)
		throws NoSuchUserPrivacyException {

		UserPrivacy userPrivacy = fetchByCompanyIdFieldId_First(
			companyId, fieldId, orderByComparator);

		if (userPrivacy != null) {
			return userPrivacy;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", fieldId=");
		msg.append(fieldId);

		msg.append("}");

		throw new NoSuchUserPrivacyException(msg.toString());
	}

	/**
	 * Returns the first user privacy in the ordered set where companyId = &#63; and fieldId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user privacy, or <code>null</code> if a matching user privacy could not be found
	 */
	@Override
	public UserPrivacy fetchByCompanyIdFieldId_First(
		long companyId, String fieldId,
		OrderByComparator<UserPrivacy> orderByComparator) {

		List<UserPrivacy> list = findByCompanyIdFieldId(
			companyId, fieldId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public UserPrivacy findByCompanyIdFieldId_Last(
			long companyId, String fieldId,
			OrderByComparator<UserPrivacy> orderByComparator)
		throws NoSuchUserPrivacyException {

		UserPrivacy userPrivacy = fetchByCompanyIdFieldId_Last(
			companyId, fieldId, orderByComparator);

		if (userPrivacy != null) {
			return userPrivacy;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", fieldId=");
		msg.append(fieldId);

		msg.append("}");

		throw new NoSuchUserPrivacyException(msg.toString());
	}

	/**
	 * Returns the last user privacy in the ordered set where companyId = &#63; and fieldId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user privacy, or <code>null</code> if a matching user privacy could not be found
	 */
	@Override
	public UserPrivacy fetchByCompanyIdFieldId_Last(
		long companyId, String fieldId,
		OrderByComparator<UserPrivacy> orderByComparator) {

		int count = countByCompanyIdFieldId(companyId, fieldId);

		if (count == 0) {
			return null;
		}

		List<UserPrivacy> list = findByCompanyIdFieldId(
			companyId, fieldId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public UserPrivacy[] findByCompanyIdFieldId_PrevAndNext(
			UserPrivacyPK userPrivacyPK, long companyId, String fieldId,
			OrderByComparator<UserPrivacy> orderByComparator)
		throws NoSuchUserPrivacyException {

		fieldId = Objects.toString(fieldId, "");

		UserPrivacy userPrivacy = findByPrimaryKey(userPrivacyPK);

		Session session = null;

		try {
			session = openSession();

			UserPrivacy[] array = new UserPrivacyImpl[3];

			array[0] = getByCompanyIdFieldId_PrevAndNext(
				session, userPrivacy, companyId, fieldId, orderByComparator,
				true);

			array[1] = userPrivacy;

			array[2] = getByCompanyIdFieldId_PrevAndNext(
				session, userPrivacy, companyId, fieldId, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserPrivacy getByCompanyIdFieldId_PrevAndNext(
		Session session, UserPrivacy userPrivacy, long companyId,
		String fieldId, OrderByComparator<UserPrivacy> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_USERPRIVACY_WHERE);

		query.append(_FINDER_COLUMN_COMPANYIDFIELDID_COMPANYID_2);

		boolean bindFieldId = false;

		if (fieldId.isEmpty()) {
			query.append(_FINDER_COLUMN_COMPANYIDFIELDID_FIELDID_3);
		}
		else {
			bindFieldId = true;

			query.append(_FINDER_COLUMN_COMPANYIDFIELDID_FIELDID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(UserPrivacyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (bindFieldId) {
			qPos.add(fieldId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(userPrivacy)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<UserPrivacy> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user privacies where companyId = &#63; and fieldId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 */
	@Override
	public void removeByCompanyIdFieldId(long companyId, String fieldId) {
		for (UserPrivacy userPrivacy :
				findByCompanyIdFieldId(
					companyId, fieldId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(userPrivacy);
		}
	}

	/**
	 * Returns the number of user privacies where companyId = &#63; and fieldId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @return the number of matching user privacies
	 */
	@Override
	public int countByCompanyIdFieldId(long companyId, String fieldId) {
		fieldId = Objects.toString(fieldId, "");

		FinderPath finderPath = _finderPathCountByCompanyIdFieldId;

		Object[] finderArgs = new Object[] {companyId, fieldId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERPRIVACY_WHERE);

			query.append(_FINDER_COLUMN_COMPANYIDFIELDID_COMPANYID_2);

			boolean bindFieldId = false;

			if (fieldId.isEmpty()) {
				query.append(_FINDER_COLUMN_COMPANYIDFIELDID_FIELDID_3);
			}
			else {
				bindFieldId = true;

				query.append(_FINDER_COLUMN_COMPANYIDFIELDID_FIELDID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindFieldId) {
					qPos.add(fieldId);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COMPANYIDFIELDID_COMPANYID_2 =
		"userPrivacy.companyId = ? AND ";

	private static final String _FINDER_COLUMN_COMPANYIDFIELDID_FIELDID_2 =
		"userPrivacy.id.fieldId = ?";

	private static final String _FINDER_COLUMN_COMPANYIDFIELDID_FIELDID_3 =
		"(userPrivacy.id.fieldId IS NULL OR userPrivacy.id.fieldId = '')";

	public UserPrivacyPersistenceImpl() {
		setModelClass(UserPrivacy.class);

		setModelImplClass(UserPrivacyImpl.class);
		setModelPKClass(UserPrivacyPK.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the user privacy in the entity cache if it is enabled.
	 *
	 * @param userPrivacy the user privacy
	 */
	@Override
	public void cacheResult(UserPrivacy userPrivacy) {
		entityCache.putResult(
			entityCacheEnabled, UserPrivacyImpl.class,
			userPrivacy.getPrimaryKey(), userPrivacy);

		userPrivacy.resetOriginalValues();
	}

	/**
	 * Caches the user privacies in the entity cache if it is enabled.
	 *
	 * @param userPrivacies the user privacies
	 */
	@Override
	public void cacheResult(List<UserPrivacy> userPrivacies) {
		for (UserPrivacy userPrivacy : userPrivacies) {
			if (entityCache.getResult(
					entityCacheEnabled, UserPrivacyImpl.class,
					userPrivacy.getPrimaryKey()) == null) {

				cacheResult(userPrivacy);
			}
			else {
				userPrivacy.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user privacies.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserPrivacyImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user privacy.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserPrivacy userPrivacy) {
		entityCache.removeResult(
			entityCacheEnabled, UserPrivacyImpl.class,
			userPrivacy.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<UserPrivacy> userPrivacies) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserPrivacy userPrivacy : userPrivacies) {
			entityCache.removeResult(
				entityCacheEnabled, UserPrivacyImpl.class,
				userPrivacy.getPrimaryKey());
		}
	}

	/**
	 * Creates a new user privacy with the primary key. Does not add the user privacy to the database.
	 *
	 * @param userPrivacyPK the primary key for the new user privacy
	 * @return the new user privacy
	 */
	@Override
	public UserPrivacy create(UserPrivacyPK userPrivacyPK) {
		UserPrivacy userPrivacy = new UserPrivacyImpl();

		userPrivacy.setNew(true);
		userPrivacy.setPrimaryKey(userPrivacyPK);

		String uuid = PortalUUIDUtil.generate();

		userPrivacy.setUuid(uuid);

		userPrivacy.setCompanyId(companyProvider.getCompanyId());

		return userPrivacy;
	}

	/**
	 * Removes the user privacy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userPrivacyPK the primary key of the user privacy
	 * @return the user privacy that was removed
	 * @throws NoSuchUserPrivacyException if a user privacy with the primary key could not be found
	 */
	@Override
	public UserPrivacy remove(UserPrivacyPK userPrivacyPK)
		throws NoSuchUserPrivacyException {

		return remove((Serializable)userPrivacyPK);
	}

	/**
	 * Removes the user privacy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user privacy
	 * @return the user privacy that was removed
	 * @throws NoSuchUserPrivacyException if a user privacy with the primary key could not be found
	 */
	@Override
	public UserPrivacy remove(Serializable primaryKey)
		throws NoSuchUserPrivacyException {

		Session session = null;

		try {
			session = openSession();

			UserPrivacy userPrivacy = (UserPrivacy)session.get(
				UserPrivacyImpl.class, primaryKey);

			if (userPrivacy == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserPrivacyException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(userPrivacy);
		}
		catch (NoSuchUserPrivacyException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected UserPrivacy removeImpl(UserPrivacy userPrivacy) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userPrivacy)) {
				userPrivacy = (UserPrivacy)session.get(
					UserPrivacyImpl.class, userPrivacy.getPrimaryKeyObj());
			}

			if (userPrivacy != null) {
				session.delete(userPrivacy);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userPrivacy != null) {
			clearCache(userPrivacy);
		}

		return userPrivacy;
	}

	@Override
	public UserPrivacy updateImpl(UserPrivacy userPrivacy) {
		boolean isNew = userPrivacy.isNew();

		if (!(userPrivacy instanceof UserPrivacyModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(userPrivacy.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(userPrivacy);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in userPrivacy proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom UserPrivacy implementation " +
					userPrivacy.getClass());
		}

		UserPrivacyModelImpl userPrivacyModelImpl =
			(UserPrivacyModelImpl)userPrivacy;

		if (Validator.isNull(userPrivacy.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			userPrivacy.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (userPrivacy.getCreateDate() == null)) {
			if (serviceContext == null) {
				userPrivacy.setCreateDate(now);
			}
			else {
				userPrivacy.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!userPrivacyModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				userPrivacy.setModifiedDate(now);
			}
			else {
				userPrivacy.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (userPrivacy.isNew()) {
				session.save(userPrivacy);

				userPrivacy.setNew(false);
			}
			else {
				userPrivacy = (UserPrivacy)session.merge(userPrivacy);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {userPrivacyModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				userPrivacyModelImpl.getUuid(),
				userPrivacyModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {userPrivacyModelImpl.getUserId()};

			finderCache.removeResult(_finderPathCountByUserId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUserId, args);

			args = new Object[] {
				userPrivacyModelImpl.getCompanyId(),
				userPrivacyModelImpl.getFieldId()
			};

			finderCache.removeResult(_finderPathCountByCompanyIdFieldId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCompanyIdFieldId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((userPrivacyModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					userPrivacyModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {userPrivacyModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((userPrivacyModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					userPrivacyModelImpl.getOriginalUuid(),
					userPrivacyModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					userPrivacyModelImpl.getUuid(),
					userPrivacyModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((userPrivacyModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUserId.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					userPrivacyModelImpl.getOriginalUserId()
				};

				finderCache.removeResult(_finderPathCountByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUserId, args);

				args = new Object[] {userPrivacyModelImpl.getUserId()};

				finderCache.removeResult(_finderPathCountByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUserId, args);
			}

			if ((userPrivacyModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCompanyIdFieldId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					userPrivacyModelImpl.getOriginalCompanyId(),
					userPrivacyModelImpl.getOriginalFieldId()
				};

				finderCache.removeResult(
					_finderPathCountByCompanyIdFieldId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCompanyIdFieldId, args);

				args = new Object[] {
					userPrivacyModelImpl.getCompanyId(),
					userPrivacyModelImpl.getFieldId()
				};

				finderCache.removeResult(
					_finderPathCountByCompanyIdFieldId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCompanyIdFieldId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, UserPrivacyImpl.class,
			userPrivacy.getPrimaryKey(), userPrivacy, false);

		userPrivacy.resetOriginalValues();

		return userPrivacy;
	}

	/**
	 * Returns the user privacy with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user privacy
	 * @return the user privacy
	 * @throws NoSuchUserPrivacyException if a user privacy with the primary key could not be found
	 */
	@Override
	public UserPrivacy findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserPrivacyException {

		UserPrivacy userPrivacy = fetchByPrimaryKey(primaryKey);

		if (userPrivacy == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserPrivacyException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return userPrivacy;
	}

	/**
	 * Returns the user privacy with the primary key or throws a <code>NoSuchUserPrivacyException</code> if it could not be found.
	 *
	 * @param userPrivacyPK the primary key of the user privacy
	 * @return the user privacy
	 * @throws NoSuchUserPrivacyException if a user privacy with the primary key could not be found
	 */
	@Override
	public UserPrivacy findByPrimaryKey(UserPrivacyPK userPrivacyPK)
		throws NoSuchUserPrivacyException {

		return findByPrimaryKey((Serializable)userPrivacyPK);
	}

	/**
	 * Returns the user privacy with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userPrivacyPK the primary key of the user privacy
	 * @return the user privacy, or <code>null</code> if a user privacy with the primary key could not be found
	 */
	@Override
	public UserPrivacy fetchByPrimaryKey(UserPrivacyPK userPrivacyPK) {
		return fetchByPrimaryKey((Serializable)userPrivacyPK);
	}

	/**
	 * Returns all the user privacies.
	 *
	 * @return the user privacies
	 */
	@Override
	public List<UserPrivacy> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserPrivacy> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<UserPrivacy> findAll(
		int start, int end, OrderByComparator<UserPrivacy> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<UserPrivacy> findAll(
		int start, int end, OrderByComparator<UserPrivacy> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<UserPrivacy> list = null;

		if (retrieveFromCache) {
			list = (List<UserPrivacy>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_USERPRIVACY);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERPRIVACY;

				if (pagination) {
					sql = sql.concat(UserPrivacyModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserPrivacy>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserPrivacy>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the user privacies from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserPrivacy userPrivacy : findAll()) {
			remove(userPrivacy);
		}
	}

	/**
	 * Returns the number of user privacies.
	 *
	 * @return the number of user privacies
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USERPRIVACY);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	public Set<String> getCompoundPKColumnNames() {
		return _compoundPKColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "userPrivacyPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_USERPRIVACY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return UserPrivacyModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user privacy persistence.
	 */
	@Activate
	public void activate() {
		UserPrivacyModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		UserPrivacyModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UserPrivacyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UserPrivacyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UserPrivacyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UserPrivacyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			UserPrivacyModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UserPrivacyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UserPrivacyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			UserPrivacyModelImpl.UUID_COLUMN_BITMASK |
			UserPrivacyModelImpl.COMPANYID_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UserPrivacyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UserPrivacyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] {Long.class.getName()},
			UserPrivacyModelImpl.USERID_COLUMN_BITMASK);

		_finderPathCountByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByCompanyIdFieldId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UserPrivacyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyIdFieldId",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCompanyIdFieldId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UserPrivacyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyIdFieldId",
			new String[] {Long.class.getName(), String.class.getName()},
			UserPrivacyModelImpl.COMPANYID_COLUMN_BITMASK |
			UserPrivacyModelImpl.FIELDID_COLUMN_BITMASK);

		_finderPathCountByCompanyIdFieldId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCompanyIdFieldId",
			new String[] {Long.class.getName(), String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(UserPrivacyImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = NHS_PrivacyPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.placecube.nhs.userprivacy.model.UserPrivacy"),
			true);
	}

	@Override
	@Reference(
		target = NHS_PrivacyPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = NHS_PrivacyPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference(service = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_USERPRIVACY =
		"SELECT userPrivacy FROM UserPrivacy userPrivacy";

	private static final String _SQL_SELECT_USERPRIVACY_WHERE =
		"SELECT userPrivacy FROM UserPrivacy userPrivacy WHERE ";

	private static final String _SQL_COUNT_USERPRIVACY =
		"SELECT COUNT(userPrivacy) FROM UserPrivacy userPrivacy";

	private static final String _SQL_COUNT_USERPRIVACY_WHERE =
		"SELECT COUNT(userPrivacy) FROM UserPrivacy userPrivacy WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "userPrivacy.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No UserPrivacy exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No UserPrivacy exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		UserPrivacyPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});
	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"userId", "fieldId"});

}