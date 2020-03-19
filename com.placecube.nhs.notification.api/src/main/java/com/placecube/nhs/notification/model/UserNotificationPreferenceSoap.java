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

import com.placecube.nhs.notification.service.persistence.UserNotificationPreferencePK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class UserNotificationPreferenceSoap implements Serializable {

	public static UserNotificationPreferenceSoap toSoapModel(
		UserNotificationPreference model) {

		UserNotificationPreferenceSoap soapModel =
			new UserNotificationPreferenceSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setUserId(model.getUserId());
		soapModel.setNotificationType(model.getNotificationType());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEnabled(model.isEnabled());

		return soapModel;
	}

	public static UserNotificationPreferenceSoap[] toSoapModels(
		UserNotificationPreference[] models) {

		UserNotificationPreferenceSoap[] soapModels =
			new UserNotificationPreferenceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserNotificationPreferenceSoap[][] toSoapModels(
		UserNotificationPreference[][] models) {

		UserNotificationPreferenceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new UserNotificationPreferenceSoap
					[models.length][models[0].length];
		}
		else {
			soapModels = new UserNotificationPreferenceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserNotificationPreferenceSoap[] toSoapModels(
		List<UserNotificationPreference> models) {

		List<UserNotificationPreferenceSoap> soapModels =
			new ArrayList<UserNotificationPreferenceSoap>(models.size());

		for (UserNotificationPreference model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new UserNotificationPreferenceSoap[soapModels.size()]);
	}

	public UserNotificationPreferenceSoap() {
	}

	public UserNotificationPreferencePK getPrimaryKey() {
		return new UserNotificationPreferencePK(_userId, _notificationType);
	}

	public void setPrimaryKey(UserNotificationPreferencePK pk) {
		setUserId(pk.userId);
		setNotificationType(pk.notificationType);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public int getNotificationType() {
		return _notificationType;
	}

	public void setNotificationType(int notificationType) {
		_notificationType = notificationType;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public boolean getEnabled() {
		return _enabled;
	}

	public boolean isEnabled() {
		return _enabled;
	}

	public void setEnabled(boolean enabled) {
		_enabled = enabled;
	}

	private String _uuid;
	private long _userId;
	private int _notificationType;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _enabled;

}