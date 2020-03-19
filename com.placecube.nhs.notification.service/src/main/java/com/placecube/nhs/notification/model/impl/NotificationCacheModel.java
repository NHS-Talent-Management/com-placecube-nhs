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

import com.placecube.nhs.notification.model.Notification;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Notification in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class NotificationCacheModel
	implements CacheModel<Notification>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NotificationCacheModel)) {
			return false;
		}

		NotificationCacheModel notificationCacheModel =
			(NotificationCacheModel)obj;

		if (notificationId == notificationCacheModel.notificationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, notificationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", notificationId=");
		sb.append(notificationId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", notificationType=");
		sb.append(notificationType);
		sb.append(", summary=");
		sb.append(summary);
		sb.append(", body=");
		sb.append(body);
		sb.append(", receiverUserIds=");
		sb.append(receiverUserIds);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Notification toEntityModel() {
		NotificationImpl notificationImpl = new NotificationImpl();

		if (uuid == null) {
			notificationImpl.setUuid("");
		}
		else {
			notificationImpl.setUuid(uuid);
		}

		notificationImpl.setNotificationId(notificationId);
		notificationImpl.setCompanyId(companyId);
		notificationImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			notificationImpl.setCreateDate(null);
		}
		else {
			notificationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			notificationImpl.setModifiedDate(null);
		}
		else {
			notificationImpl.setModifiedDate(new Date(modifiedDate));
		}

		notificationImpl.setStatus(status);
		notificationImpl.setNotificationType(notificationType);

		if (summary == null) {
			notificationImpl.setSummary("");
		}
		else {
			notificationImpl.setSummary(summary);
		}

		if (body == null) {
			notificationImpl.setBody("");
		}
		else {
			notificationImpl.setBody(body);
		}

		if (receiverUserIds == null) {
			notificationImpl.setReceiverUserIds("");
		}
		else {
			notificationImpl.setReceiverUserIds(receiverUserIds);
		}

		notificationImpl.resetOriginalValues();

		return notificationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		notificationId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		notificationType = objectInput.readInt();
		summary = objectInput.readUTF();
		body = objectInput.readUTF();
		receiverUserIds = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(notificationId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(status);

		objectOutput.writeInt(notificationType);

		if (summary == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(summary);
		}

		if (body == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(body);
		}

		if (receiverUserIds == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(receiverUserIds);
		}
	}

	public String uuid;
	public long notificationId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public int status;
	public int notificationType;
	public String summary;
	public String body;
	public String receiverUserIds;

}