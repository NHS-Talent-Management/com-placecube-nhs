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

package com.placecube.nhs.notification.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link Notification}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Notification
 * @generated
 */
@ProviderType
public class NotificationWrapper
	extends BaseModelWrapper<Notification>
	implements Notification, ModelWrapper<Notification> {

	public NotificationWrapper(Notification notification) {
		super(notification);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("notificationId", getNotificationId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("notificationType", getNotificationType());
		attributes.put("summary", getSummary());
		attributes.put("body", getBody());
		attributes.put("receiverUserIds", getReceiverUserIds());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long notificationId = (Long)attributes.get("notificationId");

		if (notificationId != null) {
			setNotificationId(notificationId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String notificationType = (String)attributes.get("notificationType");

		if (notificationType != null) {
			setNotificationType(notificationType);
		}

		String summary = (String)attributes.get("summary");

		if (summary != null) {
			setSummary(summary);
		}

		String body = (String)attributes.get("body");

		if (body != null) {
			setBody(body);
		}

		String receiverUserIds = (String)attributes.get("receiverUserIds");

		if (receiverUserIds != null) {
			setReceiverUserIds(receiverUserIds);
		}
	}

	/**
	 * Returns the body of this notification.
	 *
	 * @return the body of this notification
	 */
	@Override
	public String getBody() {
		return model.getBody();
	}

	/**
	 * Returns the company ID of this notification.
	 *
	 * @return the company ID of this notification
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this notification.
	 *
	 * @return the create date of this notification
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the modified date of this notification.
	 *
	 * @return the modified date of this notification
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the notification ID of this notification.
	 *
	 * @return the notification ID of this notification
	 */
	@Override
	public long getNotificationId() {
		return model.getNotificationId();
	}

	/**
	 * Returns the notification type of this notification.
	 *
	 * @return the notification type of this notification
	 */
	@Override
	public String getNotificationType() {
		return model.getNotificationType();
	}

	/**
	 * Returns the primary key of this notification.
	 *
	 * @return the primary key of this notification
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the receiver user IDs of this notification.
	 *
	 * @return the receiver user IDs of this notification
	 */
	@Override
	public String getReceiverUserIds() {
		return model.getReceiverUserIds();
	}

	/**
	 * Returns the status of this notification.
	 *
	 * @return the status of this notification
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the summary of this notification.
	 *
	 * @return the summary of this notification
	 */
	@Override
	public String getSummary() {
		return model.getSummary();
	}

	/**
	 * Returns the user ID of this notification.
	 *
	 * @return the user ID of this notification
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this notification.
	 *
	 * @return the user uuid of this notification
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this notification.
	 *
	 * @return the uuid of this notification
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the body of this notification.
	 *
	 * @param body the body of this notification
	 */
	@Override
	public void setBody(String body) {
		model.setBody(body);
	}

	/**
	 * Sets the company ID of this notification.
	 *
	 * @param companyId the company ID of this notification
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this notification.
	 *
	 * @param createDate the create date of this notification
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the modified date of this notification.
	 *
	 * @param modifiedDate the modified date of this notification
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the notification ID of this notification.
	 *
	 * @param notificationId the notification ID of this notification
	 */
	@Override
	public void setNotificationId(long notificationId) {
		model.setNotificationId(notificationId);
	}

	/**
	 * Sets the notification type of this notification.
	 *
	 * @param notificationType the notification type of this notification
	 */
	@Override
	public void setNotificationType(String notificationType) {
		model.setNotificationType(notificationType);
	}

	/**
	 * Sets the primary key of this notification.
	 *
	 * @param primaryKey the primary key of this notification
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the receiver user IDs of this notification.
	 *
	 * @param receiverUserIds the receiver user IDs of this notification
	 */
	@Override
	public void setReceiverUserIds(String receiverUserIds) {
		model.setReceiverUserIds(receiverUserIds);
	}

	/**
	 * Sets the status of this notification.
	 *
	 * @param status the status of this notification
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the summary of this notification.
	 *
	 * @param summary the summary of this notification
	 */
	@Override
	public void setSummary(String summary) {
		model.setSummary(summary);
	}

	/**
	 * Sets the user ID of this notification.
	 *
	 * @param userId the user ID of this notification
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this notification.
	 *
	 * @param userUuid the user uuid of this notification
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this notification.
	 *
	 * @param uuid the uuid of this notification
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected NotificationWrapper wrap(Notification notification) {
		return new NotificationWrapper(notification);
	}

}