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

package com.placecube.nhs.talentsearch.model;

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
public class TalentSearchSoap implements Serializable {

	public static TalentSearchSoap toSoapModel(TalentSearch model) {
		TalentSearchSoap soapModel = new TalentSearchSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setTalentSearchId(model.getTalentSearchId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setTypeId(model.getTypeId());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setQueryFilter(model.getQueryFilter());

		return soapModel;
	}

	public static TalentSearchSoap[] toSoapModels(TalentSearch[] models) {
		TalentSearchSoap[] soapModels = new TalentSearchSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TalentSearchSoap[][] toSoapModels(TalentSearch[][] models) {
		TalentSearchSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TalentSearchSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TalentSearchSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TalentSearchSoap[] toSoapModels(List<TalentSearch> models) {
		List<TalentSearchSoap> soapModels = new ArrayList<TalentSearchSoap>(
			models.size());

		for (TalentSearch model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TalentSearchSoap[soapModels.size()]);
	}

	public TalentSearchSoap() {
	}

	public long getPrimaryKey() {
		return _talentSearchId;
	}

	public void setPrimaryKey(long pk) {
		setTalentSearchId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getTalentSearchId() {
		return _talentSearchId;
	}

	public void setTalentSearchId(long talentSearchId) {
		_talentSearchId = talentSearchId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public long getTypeId() {
		return _typeId;
	}

	public void setTypeId(long typeId) {
		_typeId = typeId;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public String getQueryFilter() {
		return _queryFilter;
	}

	public void setQueryFilter(String queryFilter) {
		_queryFilter = queryFilter;
	}

	private String _uuid;
	private long _talentSearchId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private long _typeId;
	private long _categoryId;
	private String _queryFilter;

}