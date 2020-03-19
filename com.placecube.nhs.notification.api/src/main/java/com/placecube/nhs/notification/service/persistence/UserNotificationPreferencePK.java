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

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class UserNotificationPreferencePK
	implements Comparable<UserNotificationPreferencePK>, Serializable {

	public long userId;
	public int notificationType;

	public UserNotificationPreferencePK() {
	}

	public UserNotificationPreferencePK(long userId, int notificationType) {
		this.userId = userId;
		this.notificationType = notificationType;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(int notificationType) {
		this.notificationType = notificationType;
	}

	@Override
	public int compareTo(UserNotificationPreferencePK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (userId < pk.userId) {
			value = -1;
		}
		else if (userId > pk.userId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (notificationType < pk.notificationType) {
			value = -1;
		}
		else if (notificationType > pk.notificationType) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserNotificationPreferencePK)) {
			return false;
		}

		UserNotificationPreferencePK pk = (UserNotificationPreferencePK)obj;

		if ((userId == pk.userId) &&
			(notificationType == pk.notificationType)) {

			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, userId);
		hashCode = HashUtil.hash(hashCode, notificationType);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("userId=");

		sb.append(userId);
		sb.append(", notificationType=");

		sb.append(notificationType);

		sb.append("}");

		return sb.toString();
	}

}