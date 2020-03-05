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

package com.placecube.nhs.userprofile.model;

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
public class ExperienceSoap implements Serializable {

	public static ExperienceSoap toSoapModel(Experience model) {
		ExperienceSoap soapModel = new ExperienceSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setExperienceId(model.getExperienceId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPlaceOfWork(model.getPlaceOfWork());
		soapModel.setRole(model.getRole());
		soapModel.setCurrent(model.isCurrent());
		soapModel.setFromDate(model.getFromDate());
		soapModel.setToDate(model.getToDate());

		return soapModel;
	}

	public static ExperienceSoap[] toSoapModels(Experience[] models) {
		ExperienceSoap[] soapModels = new ExperienceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ExperienceSoap[][] toSoapModels(Experience[][] models) {
		ExperienceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ExperienceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ExperienceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ExperienceSoap[] toSoapModels(List<Experience> models) {
		List<ExperienceSoap> soapModels = new ArrayList<ExperienceSoap>(
			models.size());

		for (Experience model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ExperienceSoap[soapModels.size()]);
	}

	public ExperienceSoap() {
	}

	public long getPrimaryKey() {
		return _experienceId;
	}

	public void setPrimaryKey(long pk) {
		setExperienceId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getExperienceId() {
		return _experienceId;
	}

	public void setExperienceId(long experienceId) {
		_experienceId = experienceId;
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

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
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

	public String getPlaceOfWork() {
		return _placeOfWork;
	}

	public void setPlaceOfWork(String placeOfWork) {
		_placeOfWork = placeOfWork;
	}

	public String getRole() {
		return _role;
	}

	public void setRole(String role) {
		_role = role;
	}

	public boolean getCurrent() {
		return _current;
	}

	public boolean isCurrent() {
		return _current;
	}

	public void setCurrent(boolean current) {
		_current = current;
	}

	public Date getFromDate() {
		return _fromDate;
	}

	public void setFromDate(Date fromDate) {
		_fromDate = fromDate;
	}

	public Date getToDate() {
		return _toDate;
	}

	public void setToDate(Date toDate) {
		_toDate = toDate;
	}

	private String _uuid;
	private long _experienceId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _placeOfWork;
	private String _role;
	private boolean _current;
	private Date _fromDate;
	private Date _toDate;

}