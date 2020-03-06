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
public class QualificationSoap implements Serializable {

	public static QualificationSoap toSoapModel(Qualification model) {
		QualificationSoap soapModel = new QualificationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setQualificationId(model.getQualificationId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPlace(model.getPlace());
		soapModel.setQualification(model.getQualification());
		soapModel.setFromDate(model.getFromDate());
		soapModel.setToDate(model.getToDate());
		soapModel.setValidated(model.isValidated());

		return soapModel;
	}

	public static QualificationSoap[] toSoapModels(Qualification[] models) {
		QualificationSoap[] soapModels = new QualificationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static QualificationSoap[][] toSoapModels(Qualification[][] models) {
		QualificationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new QualificationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new QualificationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static QualificationSoap[] toSoapModels(List<Qualification> models) {
		List<QualificationSoap> soapModels = new ArrayList<QualificationSoap>(
			models.size());

		for (Qualification model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new QualificationSoap[soapModels.size()]);
	}

	public QualificationSoap() {
	}

	public long getPrimaryKey() {
		return _qualificationId;
	}

	public void setPrimaryKey(long pk) {
		setQualificationId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getQualificationId() {
		return _qualificationId;
	}

	public void setQualificationId(long qualificationId) {
		_qualificationId = qualificationId;
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

	public String getPlace() {
		return _place;
	}

	public void setPlace(String place) {
		_place = place;
	}

	public String getQualification() {
		return _qualification;
	}

	public void setQualification(String qualification) {
		_qualification = qualification;
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

	public boolean getValidated() {
		return _validated;
	}

	public boolean isValidated() {
		return _validated;
	}

	public void setValidated(boolean validated) {
		_validated = validated;
	}

	private String _uuid;
	private long _qualificationId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _place;
	private String _qualification;
	private Date _fromDate;
	private Date _toDate;
	private boolean _validated;

}