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

package com.placecube.nhs.notification.service.persistence.impl;

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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import com.placecube.nhs.notification.exception.NoSuchUserNotificationPreferenceException;
import com.placecube.nhs.notification.model.UserNotificationPreference;
import com.placecube.nhs.notification.model.impl.UserNotificationPreferenceImpl;
import com.placecube.nhs.notification.model.impl.UserNotificationPreferenceModelImpl;
import com.placecube.nhs.notification.service.persistence.UserNotificationPreferencePK;
import com.placecube.nhs.notification.service.persistence.UserNotificationPreferencePersistence;
import com.placecube.nhs.notification.service.persistence.impl.constants.NHS_NotificationPersistenceConstants;

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
 * The persistence implementation for the user notification preference service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = UserNotificationPreferencePersistence.class)
@ProviderType
public class UserNotificationPreferencePersistenceImpl
	extends BasePersistenceImpl<UserNotificationPreference>
	implements UserNotificationPreferencePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>UserNotificationPreferenceUtil</code> to access the user notification preference persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		UserNotificationPreferenceImpl.class.getName();

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
	 * Returns all the user notification preferences where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user notification preferences
	 */
	@Override
	public List<UserNotificationPreference> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserNotificationPreference> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<UserNotificationPreference> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserNotificationPreference> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<UserNotificationPreference> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserNotificationPreference> orderByComparator,
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

		List<UserNotificationPreference> list = null;

		if (retrieveFromCache) {
			list = (List<UserNotificationPreference>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserNotificationPreference userNotificationPreference :
						list) {

					if (!uuid.equals(userNotificationPreference.getUuid())) {
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

			query.append(_SQL_SELECT_USERNOTIFICATIONPREFERENCE_WHERE);

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
				query.append(UserNotificationPreferenceModelImpl.ORDER_BY_JPQL);
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
					list = (List<UserNotificationPreference>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserNotificationPreference>)QueryUtil.list(
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
	 * Returns the first user notification preference in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user notification preference
	 * @throws NoSuchUserNotificationPreferenceException if a matching user notification preference could not be found
	 */
	@Override
	public UserNotificationPreference findByUuid_First(
			String uuid,
			OrderByComparator<UserNotificationPreference> orderByComparator)
		throws NoSuchUserNotificationPreferenceException {

		UserNotificationPreference userNotificationPreference =
			fetchByUuid_First(uuid, orderByComparator);

		if (userNotificationPreference != null) {
			return userNotificationPreference;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchUserNotificationPreferenceException(msg.toString());
	}

	/**
	 * Returns the first user notification preference in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user notification preference, or <code>null</code> if a matching user notification preference could not be found
	 */
	@Override
	public UserNotificationPreference fetchByUuid_First(
		String uuid,
		OrderByComparator<UserNotificationPreference> orderByComparator) {

		List<UserNotificationPreference> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user notification preference in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user notification preference
	 * @throws NoSuchUserNotificationPreferenceException if a matching user notification preference could not be found
	 */
	@Override
	public UserNotificationPreference findByUuid_Last(
			String uuid,
			OrderByComparator<UserNotificationPreference> orderByComparator)
		throws NoSuchUserNotificationPreferenceException {

		UserNotificationPreference userNotificationPreference =
			fetchByUuid_Last(uuid, orderByComparator);

		if (userNotificationPreference != null) {
			return userNotificationPreference;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchUserNotificationPreferenceException(msg.toString());
	}

	/**
	 * Returns the last user notification preference in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user notification preference, or <code>null</code> if a matching user notification preference could not be found
	 */
	@Override
	public UserNotificationPreference fetchByUuid_Last(
		String uuid,
		OrderByComparator<UserNotificationPreference> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<UserNotificationPreference> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public UserNotificationPreference[] findByUuid_PrevAndNext(
			UserNotificationPreferencePK userNotificationPreferencePK,
			String uuid,
			OrderByComparator<UserNotificationPreference> orderByComparator)
		throws NoSuchUserNotificationPreferenceException {

		uuid = Objects.toString(uuid, "");

		UserNotificationPreference userNotificationPreference =
			findByPrimaryKey(userNotificationPreferencePK);

		Session session = null;

		try {
			session = openSession();

			UserNotificationPreference[] array =
				new UserNotificationPreferenceImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, userNotificationPreference, uuid, orderByComparator,
				true);

			array[1] = userNotificationPreference;

			array[2] = getByUuid_PrevAndNext(
				session, userNotificationPreference, uuid, orderByComparator,
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

	protected UserNotificationPreference getByUuid_PrevAndNext(
		Session session, UserNotificationPreference userNotificationPreference,
		String uuid,
		OrderByComparator<UserNotificationPreference> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERNOTIFICATIONPREFERENCE_WHERE);

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
			query.append(UserNotificationPreferenceModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						userNotificationPreference)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<UserNotificationPreference> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user notification preferences where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (UserNotificationPreference userNotificationPreference :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(userNotificationPreference);
		}
	}

	/**
	 * Returns the number of user notification preferences where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user notification preferences
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERNOTIFICATIONPREFERENCE_WHERE);

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
		"userNotificationPreference.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(userNotificationPreference.uuid IS NULL OR userNotificationPreference.uuid = '')";

	private FinderPath _finderPathFetchByUserIdTypeEnabled;
	private FinderPath _finderPathCountByUserIdTypeEnabled;

	/**
	 * Returns the user notification preference where userId = &#63; and notificationType = &#63; and enabled = &#63; or throws a <code>NoSuchUserNotificationPreferenceException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @param notificationType the notification type
	 * @param enabled the enabled
	 * @return the matching user notification preference
	 * @throws NoSuchUserNotificationPreferenceException if a matching user notification preference could not be found
	 */
	@Override
	public UserNotificationPreference findByUserIdTypeEnabled(
			long userId, String notificationType, boolean enabled)
		throws NoSuchUserNotificationPreferenceException {

		UserNotificationPreference userNotificationPreference =
			fetchByUserIdTypeEnabled(userId, notificationType, enabled);

		if (userNotificationPreference == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", notificationType=");
			msg.append(notificationType);

			msg.append(", enabled=");
			msg.append(enabled);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchUserNotificationPreferenceException(msg.toString());
		}

		return userNotificationPreference;
	}

	/**
	 * Returns the user notification preference where userId = &#63; and notificationType = &#63; and enabled = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param notificationType the notification type
	 * @param enabled the enabled
	 * @return the matching user notification preference, or <code>null</code> if a matching user notification preference could not be found
	 */
	@Override
	public UserNotificationPreference fetchByUserIdTypeEnabled(
		long userId, String notificationType, boolean enabled) {

		return fetchByUserIdTypeEnabled(
			userId, notificationType, enabled, true);
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
	@Override
	public UserNotificationPreference fetchByUserIdTypeEnabled(
		long userId, String notificationType, boolean enabled,
		boolean retrieveFromCache) {

		notificationType = Objects.toString(notificationType, "");

		Object[] finderArgs = new Object[] {userId, notificationType, enabled};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByUserIdTypeEnabled, finderArgs, this);
		}

		if (result instanceof UserNotificationPreference) {
			UserNotificationPreference userNotificationPreference =
				(UserNotificationPreference)result;

			if ((userId != userNotificationPreference.getUserId()) ||
				!Objects.equals(
					notificationType,
					userNotificationPreference.getNotificationType()) ||
				(enabled != userNotificationPreference.isEnabled())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_USERNOTIFICATIONPREFERENCE_WHERE);

			query.append(_FINDER_COLUMN_USERIDTYPEENABLED_USERID_2);

			boolean bindNotificationType = false;

			if (notificationType.isEmpty()) {
				query.append(
					_FINDER_COLUMN_USERIDTYPEENABLED_NOTIFICATIONTYPE_3);
			}
			else {
				bindNotificationType = true;

				query.append(
					_FINDER_COLUMN_USERIDTYPEENABLED_NOTIFICATIONTYPE_2);
			}

			query.append(_FINDER_COLUMN_USERIDTYPEENABLED_ENABLED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindNotificationType) {
					qPos.add(notificationType);
				}

				qPos.add(enabled);

				List<UserNotificationPreference> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByUserIdTypeEnabled, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"UserNotificationPreferencePersistenceImpl.fetchByUserIdTypeEnabled(long, String, boolean, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					UserNotificationPreference userNotificationPreference =
						list.get(0);

					result = userNotificationPreference;

					cacheResult(userNotificationPreference);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchByUserIdTypeEnabled, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (UserNotificationPreference)result;
		}
	}

	/**
	 * Removes the user notification preference where userId = &#63; and notificationType = &#63; and enabled = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param notificationType the notification type
	 * @param enabled the enabled
	 * @return the user notification preference that was removed
	 */
	@Override
	public UserNotificationPreference removeByUserIdTypeEnabled(
			long userId, String notificationType, boolean enabled)
		throws NoSuchUserNotificationPreferenceException {

		UserNotificationPreference userNotificationPreference =
			findByUserIdTypeEnabled(userId, notificationType, enabled);

		return remove(userNotificationPreference);
	}

	/**
	 * Returns the number of user notification preferences where userId = &#63; and notificationType = &#63; and enabled = &#63;.
	 *
	 * @param userId the user ID
	 * @param notificationType the notification type
	 * @param enabled the enabled
	 * @return the number of matching user notification preferences
	 */
	@Override
	public int countByUserIdTypeEnabled(
		long userId, String notificationType, boolean enabled) {

		notificationType = Objects.toString(notificationType, "");

		FinderPath finderPath = _finderPathCountByUserIdTypeEnabled;

		Object[] finderArgs = new Object[] {userId, notificationType, enabled};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_USERNOTIFICATIONPREFERENCE_WHERE);

			query.append(_FINDER_COLUMN_USERIDTYPEENABLED_USERID_2);

			boolean bindNotificationType = false;

			if (notificationType.isEmpty()) {
				query.append(
					_FINDER_COLUMN_USERIDTYPEENABLED_NOTIFICATIONTYPE_3);
			}
			else {
				bindNotificationType = true;

				query.append(
					_FINDER_COLUMN_USERIDTYPEENABLED_NOTIFICATIONTYPE_2);
			}

			query.append(_FINDER_COLUMN_USERIDTYPEENABLED_ENABLED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindNotificationType) {
					qPos.add(notificationType);
				}

				qPos.add(enabled);

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

	private static final String _FINDER_COLUMN_USERIDTYPEENABLED_USERID_2 =
		"userNotificationPreference.id.userId = ? AND ";

	private static final String
		_FINDER_COLUMN_USERIDTYPEENABLED_NOTIFICATIONTYPE_2 =
			"userNotificationPreference.id.notificationType = ? AND ";

	private static final String
		_FINDER_COLUMN_USERIDTYPEENABLED_NOTIFICATIONTYPE_3 =
			"(userNotificationPreference.id.notificationType IS NULL OR userNotificationPreference.id.notificationType = '') AND ";

	private static final String _FINDER_COLUMN_USERIDTYPEENABLED_ENABLED_2 =
		"userNotificationPreference.enabled = ?";

	private FinderPath _finderPathWithPaginationFindByuserId;
	private FinderPath _finderPathWithoutPaginationFindByuserId;
	private FinderPath _finderPathCountByuserId;

	/**
	 * Returns all the user notification preferences where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching user notification preferences
	 */
	@Override
	public List<UserNotificationPreference> findByuserId(long userId) {
		return findByuserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserNotificationPreference> findByuserId(
		long userId, int start, int end) {

		return findByuserId(userId, start, end, null);
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
	@Override
	public List<UserNotificationPreference> findByuserId(
		long userId, int start, int end,
		OrderByComparator<UserNotificationPreference> orderByComparator) {

		return findByuserId(userId, start, end, orderByComparator, true);
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
	@Override
	public List<UserNotificationPreference> findByuserId(
		long userId, int start, int end,
		OrderByComparator<UserNotificationPreference> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByuserId;
			finderArgs = new Object[] {userId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByuserId;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<UserNotificationPreference> list = null;

		if (retrieveFromCache) {
			list = (List<UserNotificationPreference>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserNotificationPreference userNotificationPreference :
						list) {

					if ((userId != userNotificationPreference.getUserId())) {
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

			query.append(_SQL_SELECT_USERNOTIFICATIONPREFERENCE_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(UserNotificationPreferenceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<UserNotificationPreference>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserNotificationPreference>)QueryUtil.list(
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
	 * Returns the first user notification preference in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user notification preference
	 * @throws NoSuchUserNotificationPreferenceException if a matching user notification preference could not be found
	 */
	@Override
	public UserNotificationPreference findByuserId_First(
			long userId,
			OrderByComparator<UserNotificationPreference> orderByComparator)
		throws NoSuchUserNotificationPreferenceException {

		UserNotificationPreference userNotificationPreference =
			fetchByuserId_First(userId, orderByComparator);

		if (userNotificationPreference != null) {
			return userNotificationPreference;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchUserNotificationPreferenceException(msg.toString());
	}

	/**
	 * Returns the first user notification preference in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user notification preference, or <code>null</code> if a matching user notification preference could not be found
	 */
	@Override
	public UserNotificationPreference fetchByuserId_First(
		long userId,
		OrderByComparator<UserNotificationPreference> orderByComparator) {

		List<UserNotificationPreference> list = findByuserId(
			userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user notification preference in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user notification preference
	 * @throws NoSuchUserNotificationPreferenceException if a matching user notification preference could not be found
	 */
	@Override
	public UserNotificationPreference findByuserId_Last(
			long userId,
			OrderByComparator<UserNotificationPreference> orderByComparator)
		throws NoSuchUserNotificationPreferenceException {

		UserNotificationPreference userNotificationPreference =
			fetchByuserId_Last(userId, orderByComparator);

		if (userNotificationPreference != null) {
			return userNotificationPreference;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchUserNotificationPreferenceException(msg.toString());
	}

	/**
	 * Returns the last user notification preference in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user notification preference, or <code>null</code> if a matching user notification preference could not be found
	 */
	@Override
	public UserNotificationPreference fetchByuserId_Last(
		long userId,
		OrderByComparator<UserNotificationPreference> orderByComparator) {

		int count = countByuserId(userId);

		if (count == 0) {
			return null;
		}

		List<UserNotificationPreference> list = findByuserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public UserNotificationPreference[] findByuserId_PrevAndNext(
			UserNotificationPreferencePK userNotificationPreferencePK,
			long userId,
			OrderByComparator<UserNotificationPreference> orderByComparator)
		throws NoSuchUserNotificationPreferenceException {

		UserNotificationPreference userNotificationPreference =
			findByPrimaryKey(userNotificationPreferencePK);

		Session session = null;

		try {
			session = openSession();

			UserNotificationPreference[] array =
				new UserNotificationPreferenceImpl[3];

			array[0] = getByuserId_PrevAndNext(
				session, userNotificationPreference, userId, orderByComparator,
				true);

			array[1] = userNotificationPreference;

			array[2] = getByuserId_PrevAndNext(
				session, userNotificationPreference, userId, orderByComparator,
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

	protected UserNotificationPreference getByuserId_PrevAndNext(
		Session session, UserNotificationPreference userNotificationPreference,
		long userId,
		OrderByComparator<UserNotificationPreference> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERNOTIFICATIONPREFERENCE_WHERE);

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
			query.append(UserNotificationPreferenceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						userNotificationPreference)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<UserNotificationPreference> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user notification preferences where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByuserId(long userId) {
		for (UserNotificationPreference userNotificationPreference :
				findByuserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(userNotificationPreference);
		}
	}

	/**
	 * Returns the number of user notification preferences where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user notification preferences
	 */
	@Override
	public int countByuserId(long userId) {
		FinderPath finderPath = _finderPathCountByuserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERNOTIFICATIONPREFERENCE_WHERE);

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
		"userNotificationPreference.id.userId = ?";

	public UserNotificationPreferencePersistenceImpl() {
		setModelClass(UserNotificationPreference.class);

		setModelImplClass(UserNotificationPreferenceImpl.class);
		setModelPKClass(UserNotificationPreferencePK.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the user notification preference in the entity cache if it is enabled.
	 *
	 * @param userNotificationPreference the user notification preference
	 */
	@Override
	public void cacheResult(
		UserNotificationPreference userNotificationPreference) {

		entityCache.putResult(
			entityCacheEnabled, UserNotificationPreferenceImpl.class,
			userNotificationPreference.getPrimaryKey(),
			userNotificationPreference);

		finderCache.putResult(
			_finderPathFetchByUserIdTypeEnabled,
			new Object[] {
				userNotificationPreference.getUserId(),
				userNotificationPreference.getNotificationType(),
				userNotificationPreference.isEnabled()
			},
			userNotificationPreference);

		userNotificationPreference.resetOriginalValues();
	}

	/**
	 * Caches the user notification preferences in the entity cache if it is enabled.
	 *
	 * @param userNotificationPreferences the user notification preferences
	 */
	@Override
	public void cacheResult(
		List<UserNotificationPreference> userNotificationPreferences) {

		for (UserNotificationPreference userNotificationPreference :
				userNotificationPreferences) {

			if (entityCache.getResult(
					entityCacheEnabled, UserNotificationPreferenceImpl.class,
					userNotificationPreference.getPrimaryKey()) == null) {

				cacheResult(userNotificationPreference);
			}
			else {
				userNotificationPreference.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user notification preferences.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserNotificationPreferenceImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user notification preference.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		UserNotificationPreference userNotificationPreference) {

		entityCache.removeResult(
			entityCacheEnabled, UserNotificationPreferenceImpl.class,
			userNotificationPreference.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(UserNotificationPreferenceModelImpl)userNotificationPreference,
			true);
	}

	@Override
	public void clearCache(
		List<UserNotificationPreference> userNotificationPreferences) {

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserNotificationPreference userNotificationPreference :
				userNotificationPreferences) {

			entityCache.removeResult(
				entityCacheEnabled, UserNotificationPreferenceImpl.class,
				userNotificationPreference.getPrimaryKey());

			clearUniqueFindersCache(
				(UserNotificationPreferenceModelImpl)userNotificationPreference,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		UserNotificationPreferenceModelImpl
			userNotificationPreferenceModelImpl) {

		Object[] args = new Object[] {
			userNotificationPreferenceModelImpl.getUserId(),
			userNotificationPreferenceModelImpl.getNotificationType(),
			userNotificationPreferenceModelImpl.isEnabled()
		};

		finderCache.putResult(
			_finderPathCountByUserIdTypeEnabled, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUserIdTypeEnabled, args,
			userNotificationPreferenceModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		UserNotificationPreferenceModelImpl userNotificationPreferenceModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				userNotificationPreferenceModelImpl.getUserId(),
				userNotificationPreferenceModelImpl.getNotificationType(),
				userNotificationPreferenceModelImpl.isEnabled()
			};

			finderCache.removeResult(_finderPathCountByUserIdTypeEnabled, args);
			finderCache.removeResult(_finderPathFetchByUserIdTypeEnabled, args);
		}

		if ((userNotificationPreferenceModelImpl.getColumnBitmask() &
			 _finderPathFetchByUserIdTypeEnabled.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				userNotificationPreferenceModelImpl.getOriginalUserId(),
				userNotificationPreferenceModelImpl.
					getOriginalNotificationType(),
				userNotificationPreferenceModelImpl.getOriginalEnabled()
			};

			finderCache.removeResult(_finderPathCountByUserIdTypeEnabled, args);
			finderCache.removeResult(_finderPathFetchByUserIdTypeEnabled, args);
		}
	}

	/**
	 * Creates a new user notification preference with the primary key. Does not add the user notification preference to the database.
	 *
	 * @param userNotificationPreferencePK the primary key for the new user notification preference
	 * @return the new user notification preference
	 */
	@Override
	public UserNotificationPreference create(
		UserNotificationPreferencePK userNotificationPreferencePK) {

		UserNotificationPreference userNotificationPreference =
			new UserNotificationPreferenceImpl();

		userNotificationPreference.setNew(true);
		userNotificationPreference.setPrimaryKey(userNotificationPreferencePK);

		String uuid = PortalUUIDUtil.generate();

		userNotificationPreference.setUuid(uuid);

		return userNotificationPreference;
	}

	/**
	 * Removes the user notification preference with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userNotificationPreferencePK the primary key of the user notification preference
	 * @return the user notification preference that was removed
	 * @throws NoSuchUserNotificationPreferenceException if a user notification preference with the primary key could not be found
	 */
	@Override
	public UserNotificationPreference remove(
			UserNotificationPreferencePK userNotificationPreferencePK)
		throws NoSuchUserNotificationPreferenceException {

		return remove((Serializable)userNotificationPreferencePK);
	}

	/**
	 * Removes the user notification preference with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user notification preference
	 * @return the user notification preference that was removed
	 * @throws NoSuchUserNotificationPreferenceException if a user notification preference with the primary key could not be found
	 */
	@Override
	public UserNotificationPreference remove(Serializable primaryKey)
		throws NoSuchUserNotificationPreferenceException {

		Session session = null;

		try {
			session = openSession();

			UserNotificationPreference userNotificationPreference =
				(UserNotificationPreference)session.get(
					UserNotificationPreferenceImpl.class, primaryKey);

			if (userNotificationPreference == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserNotificationPreferenceException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(userNotificationPreference);
		}
		catch (NoSuchUserNotificationPreferenceException nsee) {
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
	protected UserNotificationPreference removeImpl(
		UserNotificationPreference userNotificationPreference) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userNotificationPreference)) {
				userNotificationPreference =
					(UserNotificationPreference)session.get(
						UserNotificationPreferenceImpl.class,
						userNotificationPreference.getPrimaryKeyObj());
			}

			if (userNotificationPreference != null) {
				session.delete(userNotificationPreference);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userNotificationPreference != null) {
			clearCache(userNotificationPreference);
		}

		return userNotificationPreference;
	}

	@Override
	public UserNotificationPreference updateImpl(
		UserNotificationPreference userNotificationPreference) {

		boolean isNew = userNotificationPreference.isNew();

		if (!(userNotificationPreference instanceof
				UserNotificationPreferenceModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(userNotificationPreference.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					userNotificationPreference);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in userNotificationPreference proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom UserNotificationPreference implementation " +
					userNotificationPreference.getClass());
		}

		UserNotificationPreferenceModelImpl
			userNotificationPreferenceModelImpl =
				(UserNotificationPreferenceModelImpl)userNotificationPreference;

		if (Validator.isNull(userNotificationPreference.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			userNotificationPreference.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (userNotificationPreference.getCreateDate() == null)) {
			if (serviceContext == null) {
				userNotificationPreference.setCreateDate(now);
			}
			else {
				userNotificationPreference.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!userNotificationPreferenceModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				userNotificationPreference.setModifiedDate(now);
			}
			else {
				userNotificationPreference.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (userNotificationPreference.isNew()) {
				session.save(userNotificationPreference);

				userNotificationPreference.setNew(false);
			}
			else {
				userNotificationPreference =
					(UserNotificationPreference)session.merge(
						userNotificationPreference);
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
			Object[] args = new Object[] {
				userNotificationPreferenceModelImpl.getUuid()
			};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				userNotificationPreferenceModelImpl.getUserId()
			};

			finderCache.removeResult(_finderPathCountByuserId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByuserId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((userNotificationPreferenceModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					userNotificationPreferenceModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {
					userNotificationPreferenceModelImpl.getUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((userNotificationPreferenceModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByuserId.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					userNotificationPreferenceModelImpl.getOriginalUserId()
				};

				finderCache.removeResult(_finderPathCountByuserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByuserId, args);

				args = new Object[] {
					userNotificationPreferenceModelImpl.getUserId()
				};

				finderCache.removeResult(_finderPathCountByuserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByuserId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, UserNotificationPreferenceImpl.class,
			userNotificationPreference.getPrimaryKey(),
			userNotificationPreference, false);

		clearUniqueFindersCache(userNotificationPreferenceModelImpl, false);
		cacheUniqueFindersCache(userNotificationPreferenceModelImpl);

		userNotificationPreference.resetOriginalValues();

		return userNotificationPreference;
	}

	/**
	 * Returns the user notification preference with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user notification preference
	 * @return the user notification preference
	 * @throws NoSuchUserNotificationPreferenceException if a user notification preference with the primary key could not be found
	 */
	@Override
	public UserNotificationPreference findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserNotificationPreferenceException {

		UserNotificationPreference userNotificationPreference =
			fetchByPrimaryKey(primaryKey);

		if (userNotificationPreference == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserNotificationPreferenceException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return userNotificationPreference;
	}

	/**
	 * Returns the user notification preference with the primary key or throws a <code>NoSuchUserNotificationPreferenceException</code> if it could not be found.
	 *
	 * @param userNotificationPreferencePK the primary key of the user notification preference
	 * @return the user notification preference
	 * @throws NoSuchUserNotificationPreferenceException if a user notification preference with the primary key could not be found
	 */
	@Override
	public UserNotificationPreference findByPrimaryKey(
			UserNotificationPreferencePK userNotificationPreferencePK)
		throws NoSuchUserNotificationPreferenceException {

		return findByPrimaryKey((Serializable)userNotificationPreferencePK);
	}

	/**
	 * Returns the user notification preference with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userNotificationPreferencePK the primary key of the user notification preference
	 * @return the user notification preference, or <code>null</code> if a user notification preference with the primary key could not be found
	 */
	@Override
	public UserNotificationPreference fetchByPrimaryKey(
		UserNotificationPreferencePK userNotificationPreferencePK) {

		return fetchByPrimaryKey((Serializable)userNotificationPreferencePK);
	}

	/**
	 * Returns all the user notification preferences.
	 *
	 * @return the user notification preferences
	 */
	@Override
	public List<UserNotificationPreference> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserNotificationPreference> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<UserNotificationPreference> findAll(
		int start, int end,
		OrderByComparator<UserNotificationPreference> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<UserNotificationPreference> findAll(
		int start, int end,
		OrderByComparator<UserNotificationPreference> orderByComparator,
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

		List<UserNotificationPreference> list = null;

		if (retrieveFromCache) {
			list = (List<UserNotificationPreference>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_USERNOTIFICATIONPREFERENCE);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERNOTIFICATIONPREFERENCE;

				if (pagination) {
					sql = sql.concat(
						UserNotificationPreferenceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserNotificationPreference>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserNotificationPreference>)QueryUtil.list(
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
	 * Removes all the user notification preferences from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserNotificationPreference userNotificationPreference :
				findAll()) {

			remove(userNotificationPreference);
		}
	}

	/**
	 * Returns the number of user notification preferences.
	 *
	 * @return the number of user notification preferences
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(
					_SQL_COUNT_USERNOTIFICATIONPREFERENCE);

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
		return "userNotificationPreferencePK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_USERNOTIFICATIONPREFERENCE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return UserNotificationPreferenceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user notification preference persistence.
	 */
	@Activate
	public void activate() {
		UserNotificationPreferenceModelImpl.setEntityCacheEnabled(
			entityCacheEnabled);
		UserNotificationPreferenceModelImpl.setFinderCacheEnabled(
			finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			UserNotificationPreferenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			UserNotificationPreferenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			UserNotificationPreferenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			UserNotificationPreferenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			UserNotificationPreferenceModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUserIdTypeEnabled = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			UserNotificationPreferenceImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUserIdTypeEnabled",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Boolean.class.getName()
			},
			UserNotificationPreferenceModelImpl.USERID_COLUMN_BITMASK |
			UserNotificationPreferenceModelImpl.
				NOTIFICATIONTYPE_COLUMN_BITMASK |
			UserNotificationPreferenceModelImpl.ENABLED_COLUMN_BITMASK);

		_finderPathCountByUserIdTypeEnabled = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdTypeEnabled",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Boolean.class.getName()
			});

		_finderPathWithPaginationFindByuserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			UserNotificationPreferenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByuserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			UserNotificationPreferenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuserId",
			new String[] {Long.class.getName()},
			UserNotificationPreferenceModelImpl.USERID_COLUMN_BITMASK);

		_finderPathCountByuserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserId",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(UserNotificationPreferenceImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = NHS_NotificationPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.placecube.nhs.notification.model.UserNotificationPreference"),
			true);
	}

	@Override
	@Reference(
		target = NHS_NotificationPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = NHS_NotificationPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_USERNOTIFICATIONPREFERENCE =
		"SELECT userNotificationPreference FROM UserNotificationPreference userNotificationPreference";

	private static final String _SQL_SELECT_USERNOTIFICATIONPREFERENCE_WHERE =
		"SELECT userNotificationPreference FROM UserNotificationPreference userNotificationPreference WHERE ";

	private static final String _SQL_COUNT_USERNOTIFICATIONPREFERENCE =
		"SELECT COUNT(userNotificationPreference) FROM UserNotificationPreference userNotificationPreference";

	private static final String _SQL_COUNT_USERNOTIFICATIONPREFERENCE_WHERE =
		"SELECT COUNT(userNotificationPreference) FROM UserNotificationPreference userNotificationPreference WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"userNotificationPreference.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No UserNotificationPreference exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No UserNotificationPreference exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		UserNotificationPreferencePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});
	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"userId", "notificationType"});

}