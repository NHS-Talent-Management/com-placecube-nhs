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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link Qualification}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Qualification
 * @generated
 */
@ProviderType
public class QualificationWrapper
	extends BaseModelWrapper<Qualification>
	implements Qualification, ModelWrapper<Qualification> {

	public QualificationWrapper(Qualification qualification) {
		super(qualification);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("qualificationId", getQualificationId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("place", getPlace());
		attributes.put("qualification", getQualification());
		attributes.put("fromDate", getFromDate());
		attributes.put("toDate", getToDate());
		attributes.put("validated", isValidated());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long qualificationId = (Long)attributes.get("qualificationId");

		if (qualificationId != null) {
			setQualificationId(qualificationId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String place = (String)attributes.get("place");

		if (place != null) {
			setPlace(place);
		}

		String qualification = (String)attributes.get("qualification");

		if (qualification != null) {
			setQualification(qualification);
		}

		Date fromDate = (Date)attributes.get("fromDate");

		if (fromDate != null) {
			setFromDate(fromDate);
		}

		Date toDate = (Date)attributes.get("toDate");

		if (toDate != null) {
			setToDate(toDate);
		}

		Boolean validated = (Boolean)attributes.get("validated");

		if (validated != null) {
			setValidated(validated);
		}
	}

	/**
	 * Returns the company ID of this qualification.
	 *
	 * @return the company ID of this qualification
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this qualification.
	 *
	 * @return the create date of this qualification
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the from date of this qualification.
	 *
	 * @return the from date of this qualification
	 */
	@Override
	public Date getFromDate() {
		return model.getFromDate();
	}

	/**
	 * Returns the modified date of this qualification.
	 *
	 * @return the modified date of this qualification
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the place of this qualification.
	 *
	 * @return the place of this qualification
	 */
	@Override
	public String getPlace() {
		return model.getPlace();
	}

	/**
	 * Returns the primary key of this qualification.
	 *
	 * @return the primary key of this qualification
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the qualification of this qualification.
	 *
	 * @return the qualification of this qualification
	 */
	@Override
	public String getQualification() {
		return model.getQualification();
	}

	/**
	 * Returns the qualification ID of this qualification.
	 *
	 * @return the qualification ID of this qualification
	 */
	@Override
	public long getQualificationId() {
		return model.getQualificationId();
	}

	/**
	 * Returns the to date of this qualification.
	 *
	 * @return the to date of this qualification
	 */
	@Override
	public Date getToDate() {
		return model.getToDate();
	}

	/**
	 * Returns the user ID of this qualification.
	 *
	 * @return the user ID of this qualification
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this qualification.
	 *
	 * @return the user name of this qualification
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this qualification.
	 *
	 * @return the user uuid of this qualification
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this qualification.
	 *
	 * @return the uuid of this qualification
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the validated of this qualification.
	 *
	 * @return the validated of this qualification
	 */
	@Override
	public boolean getValidated() {
		return model.getValidated();
	}

	/**
	 * Returns <code>true</code> if this qualification is validated.
	 *
	 * @return <code>true</code> if this qualification is validated; <code>false</code> otherwise
	 */
	@Override
	public boolean isValidated() {
		return model.isValidated();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this qualification.
	 *
	 * @param companyId the company ID of this qualification
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this qualification.
	 *
	 * @param createDate the create date of this qualification
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the from date of this qualification.
	 *
	 * @param fromDate the from date of this qualification
	 */
	@Override
	public void setFromDate(Date fromDate) {
		model.setFromDate(fromDate);
	}

	/**
	 * Sets the modified date of this qualification.
	 *
	 * @param modifiedDate the modified date of this qualification
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the place of this qualification.
	 *
	 * @param place the place of this qualification
	 */
	@Override
	public void setPlace(String place) {
		model.setPlace(place);
	}

	/**
	 * Sets the primary key of this qualification.
	 *
	 * @param primaryKey the primary key of this qualification
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the qualification of this qualification.
	 *
	 * @param qualification the qualification of this qualification
	 */
	@Override
	public void setQualification(String qualification) {
		model.setQualification(qualification);
	}

	/**
	 * Sets the qualification ID of this qualification.
	 *
	 * @param qualificationId the qualification ID of this qualification
	 */
	@Override
	public void setQualificationId(long qualificationId) {
		model.setQualificationId(qualificationId);
	}

	/**
	 * Sets the to date of this qualification.
	 *
	 * @param toDate the to date of this qualification
	 */
	@Override
	public void setToDate(Date toDate) {
		model.setToDate(toDate);
	}

	/**
	 * Sets the user ID of this qualification.
	 *
	 * @param userId the user ID of this qualification
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this qualification.
	 *
	 * @param userName the user name of this qualification
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this qualification.
	 *
	 * @param userUuid the user uuid of this qualification
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this qualification.
	 *
	 * @param uuid the uuid of this qualification
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets whether this qualification is validated.
	 *
	 * @param validated the validated of this qualification
	 */
	@Override
	public void setValidated(boolean validated) {
		model.setValidated(validated);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected QualificationWrapper wrap(Qualification qualification) {
		return new QualificationWrapper(qualification);
	}

}