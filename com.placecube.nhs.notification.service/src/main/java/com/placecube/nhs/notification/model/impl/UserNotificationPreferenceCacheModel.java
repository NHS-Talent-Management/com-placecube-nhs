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

package com.placecube.nhs.notification.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.placecube.nhs.notification.model.UserNotificationPreference;
import com.placecube.nhs.notification.service.persistence.UserNotificationPreferencePK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing UserNotificationPreference in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class UserNotificationPreferenceCacheModel
	implements CacheModel<UserNotificationPreference>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserNotificationPreferenceCacheModel)) {
			return false;
		}

		UserNotificationPreferenceCacheModel
			userNotificationPreferenceCacheModel =
				(UserNotificationPreferenceCacheModel)obj;

		if (userNotificationPreferencePK.equals(
				userNotificationPreferenceCacheModel.
					userNotificationPreferencePK)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userNotificationPreferencePK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", notificationType=");
		sb.append(notificationType);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", enabled=");
		sb.append(enabled);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserNotificationPreference toEntityModel() {
		UserNotificationPreferenceImpl userNotificationPreferenceImpl =
			new UserNotificationPreferenceImpl();

		if (uuid == null) {
			userNotificationPreferenceImpl.setUuid("");
		}
		else {
			userNotificationPreferenceImpl.setUuid(uuid);
		}

		userNotificationPreferenceImpl.setUserId(userId);
		userNotificationPreferenceImpl.setNotificationType(notificationType);

		if (createDate == Long.MIN_VALUE) {
			userNotificationPreferenceImpl.setCreateDate(null);
		}
		else {
			userNotificationPreferenceImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			userNotificationPreferenceImpl.setModifiedDate(null);
		}
		else {
			userNotificationPreferenceImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		userNotificationPreferenceImpl.setEnabled(enabled);

		userNotificationPreferenceImpl.resetOriginalValues();

		return userNotificationPreferenceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		userId = objectInput.readLong();

		notificationType = objectInput.readInt();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		enabled = objectInput.readBoolean();

		userNotificationPreferencePK = new UserNotificationPreferencePK(
			userId, notificationType);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(userId);

		objectOutput.writeInt(notificationType);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeBoolean(enabled);
	}

	public String uuid;
	public long userId;
	public int notificationType;
	public long createDate;
	public long modifiedDate;
	public boolean enabled;
	public transient UserNotificationPreferencePK userNotificationPreferencePK;

}