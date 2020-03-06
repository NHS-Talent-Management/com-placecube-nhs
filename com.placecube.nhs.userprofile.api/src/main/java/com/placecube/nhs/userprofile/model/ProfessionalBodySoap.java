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
public class ProfessionalBodySoap implements Serializable {

	public static ProfessionalBodySoap toSoapModel(ProfessionalBody model) {
		ProfessionalBodySoap soapModel = new ProfessionalBodySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setProfessionalBodyId(model.getProfessionalBodyId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTitle(model.getTitle());
		soapModel.setLocation(model.getLocation());
		soapModel.setExpiryDate(model.getExpiryDate());
		soapModel.setValidated(model.isValidated());

		return soapModel;
	}

	public static ProfessionalBodySoap[] toSoapModels(
		ProfessionalBody[] models) {

		ProfessionalBodySoap[] soapModels =
			new ProfessionalBodySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProfessionalBodySoap[][] toSoapModels(
		ProfessionalBody[][] models) {

		ProfessionalBodySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ProfessionalBodySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProfessionalBodySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProfessionalBodySoap[] toSoapModels(
		List<ProfessionalBody> models) {

		List<ProfessionalBodySoap> soapModels =
			new ArrayList<ProfessionalBodySoap>(models.size());

		for (ProfessionalBody model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProfessionalBodySoap[soapModels.size()]);
	}

	public ProfessionalBodySoap() {
	}

	public long getPrimaryKey() {
		return _professionalBodyId;
	}

	public void setPrimaryKey(long pk) {
		setProfessionalBodyId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getProfessionalBodyId() {
		return _professionalBodyId;
	}

	public void setProfessionalBodyId(long professionalBodyId) {
		_professionalBodyId = professionalBodyId;
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

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getLocation() {
		return _location;
	}

	public void setLocation(String location) {
		_location = location;
	}

	public Date getExpiryDate() {
		return _expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		_expiryDate = expiryDate;
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
	private long _professionalBodyId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private String _location;
	private Date _expiryDate;
	private boolean _validated;

}