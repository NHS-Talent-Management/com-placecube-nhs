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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link UserNotificationPreference}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserNotificationPreference
 * @generated
 */
@ProviderType
public class UserNotificationPreferenceWrapper
	extends BaseModelWrapper<UserNotificationPreference>
	implements UserNotificationPreference,
			   ModelWrapper<UserNotificationPreference> {

	public UserNotificationPreferenceWrapper(
		UserNotificationPreference userNotificationPreference) {

		super(userNotificationPreference);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("userId", getUserId());
		attributes.put("notificationType", getNotificationType());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("enabled", isEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Integer notificationType = (Integer)attributes.get("notificationType");

		if (notificationType != null) {
			setNotificationType(notificationType);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Boolean enabled = (Boolean)attributes.get("enabled");

		if (enabled != null) {
			setEnabled(enabled);
		}
	}

	/**
	 * Returns the create date of this user notification preference.
	 *
	 * @return the create date of this user notification preference
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the enabled of this user notification preference.
	 *
	 * @return the enabled of this user notification preference
	 */
	@Override
	public boolean getEnabled() {
		return model.getEnabled();
	}

	/**
	 * Returns the modified date of this user notification preference.
	 *
	 * @return the modified date of this user notification preference
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the notification type of this user notification preference.
	 *
	 * @return the notification type of this user notification preference
	 */
	@Override
	public int getNotificationType() {
		return model.getNotificationType();
	}

	/**
	 * Returns the primary key of this user notification preference.
	 *
	 * @return the primary key of this user notification preference
	 */
	@Override
	public com.placecube.nhs.notification.service.persistence.
		UserNotificationPreferencePK getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this user notification preference.
	 *
	 * @return the user ID of this user notification preference
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this user notification preference.
	 *
	 * @return the user uuid of this user notification preference
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this user notification preference.
	 *
	 * @return the uuid of this user notification preference
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this user notification preference is enabled.
	 *
	 * @return <code>true</code> if this user notification preference is enabled; <code>false</code> otherwise
	 */
	@Override
	public boolean isEnabled() {
		return model.isEnabled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the create date of this user notification preference.
	 *
	 * @param createDate the create date of this user notification preference
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this user notification preference is enabled.
	 *
	 * @param enabled the enabled of this user notification preference
	 */
	@Override
	public void setEnabled(boolean enabled) {
		model.setEnabled(enabled);
	}

	/**
	 * Sets the modified date of this user notification preference.
	 *
	 * @param modifiedDate the modified date of this user notification preference
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the notification type of this user notification preference.
	 *
	 * @param notificationType the notification type of this user notification preference
	 */
	@Override
	public void setNotificationType(int notificationType) {
		model.setNotificationType(notificationType);
	}

	/**
	 * Sets the primary key of this user notification preference.
	 *
	 * @param primaryKey the primary key of this user notification preference
	 */
	@Override
	public void setPrimaryKey(
		com.placecube.nhs.notification.service.persistence.
			UserNotificationPreferencePK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this user notification preference.
	 *
	 * @param userId the user ID of this user notification preference
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this user notification preference.
	 *
	 * @param userUuid the user uuid of this user notification preference
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this user notification preference.
	 *
	 * @param uuid the uuid of this user notification preference
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected UserNotificationPreferenceWrapper wrap(
		UserNotificationPreference userNotificationPreference) {

		return new UserNotificationPreferenceWrapper(
			userNotificationPreference);
	}

}