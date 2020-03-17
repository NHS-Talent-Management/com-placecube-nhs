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

package com.placecube.nhs.userprivacy.model;

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
public class UserPrivacySoap implements Serializable {

	public static UserPrivacySoap toSoapModel(UserPrivacy model) {
		UserPrivacySoap soapModel = new UserPrivacySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setUserPrivacyId(model.getUserPrivacyId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setFieldId(model.getFieldId());
		soapModel.setRoleIds(model.getRoleIds());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static UserPrivacySoap[] toSoapModels(UserPrivacy[] models) {
		UserPrivacySoap[] soapModels = new UserPrivacySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserPrivacySoap[][] toSoapModels(UserPrivacy[][] models) {
		UserPrivacySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserPrivacySoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserPrivacySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserPrivacySoap[] toSoapModels(List<UserPrivacy> models) {
		List<UserPrivacySoap> soapModels = new ArrayList<UserPrivacySoap>(
			models.size());

		for (UserPrivacy model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserPrivacySoap[soapModels.size()]);
	}

	public UserPrivacySoap() {
	}

	public long getPrimaryKey() {
		return _userPrivacyId;
	}

	public void setPrimaryKey(long pk) {
		setUserPrivacyId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getUserPrivacyId() {
		return _userPrivacyId;
	}

	public void setUserPrivacyId(long userPrivacyId) {
		_userPrivacyId = userPrivacyId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getFieldId() {
		return _fieldId;
	}

	public void setFieldId(String fieldId) {
		_fieldId = fieldId;
	}

	public String getRoleIds() {
		return _roleIds;
	}

	public void setRoleIds(String roleIds) {
		_roleIds = roleIds;
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

	private String _uuid;
	private long _userPrivacyId;
	private long _companyId;
	private long _userId;
	private String _fieldId;
	private String _roleIds;
	private Date _createDate;
	private Date _modifiedDate;

}