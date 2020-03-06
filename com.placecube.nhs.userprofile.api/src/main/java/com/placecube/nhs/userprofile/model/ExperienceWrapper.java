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
 * This class is a wrapper for {@link Experience}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Experience
 * @generated
 */
@ProviderType
public class ExperienceWrapper
	extends BaseModelWrapper<Experience>
	implements Experience, ModelWrapper<Experience> {

	public ExperienceWrapper(Experience experience) {
		super(experience);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("experienceId", getExperienceId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("placeOfWork", getPlaceOfWork());
		attributes.put("role", getRole());
		attributes.put("current", isCurrent());
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

		Long experienceId = (Long)attributes.get("experienceId");

		if (experienceId != null) {
			setExperienceId(experienceId);
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

		String placeOfWork = (String)attributes.get("placeOfWork");

		if (placeOfWork != null) {
			setPlaceOfWork(placeOfWork);
		}

		String role = (String)attributes.get("role");

		if (role != null) {
			setRole(role);
		}

		Boolean current = (Boolean)attributes.get("current");

		if (current != null) {
			setCurrent(current);
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
	 * Returns the company ID of this experience.
	 *
	 * @return the company ID of this experience
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this experience.
	 *
	 * @return the create date of this experience
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the current of this experience.
	 *
	 * @return the current of this experience
	 */
	@Override
	public boolean getCurrent() {
		return model.getCurrent();
	}

	/**
	 * Returns the experience ID of this experience.
	 *
	 * @return the experience ID of this experience
	 */
	@Override
	public long getExperienceId() {
		return model.getExperienceId();
	}

	/**
	 * Returns the from date of this experience.
	 *
	 * @return the from date of this experience
	 */
	@Override
	public Date getFromDate() {
		return model.getFromDate();
	}

	/**
	 * Returns the modified date of this experience.
	 *
	 * @return the modified date of this experience
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the place of work of this experience.
	 *
	 * @return the place of work of this experience
	 */
	@Override
	public String getPlaceOfWork() {
		return model.getPlaceOfWork();
	}

	/**
	 * Returns the primary key of this experience.
	 *
	 * @return the primary key of this experience
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the role of this experience.
	 *
	 * @return the role of this experience
	 */
	@Override
	public String getRole() {
		return model.getRole();
	}

	/**
	 * Returns the to date of this experience.
	 *
	 * @return the to date of this experience
	 */
	@Override
	public Date getToDate() {
		return model.getToDate();
	}

	/**
	 * Returns the user ID of this experience.
	 *
	 * @return the user ID of this experience
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this experience.
	 *
	 * @return the user name of this experience
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this experience.
	 *
	 * @return the user uuid of this experience
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this experience.
	 *
	 * @return the uuid of this experience
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the validated of this experience.
	 *
	 * @return the validated of this experience
	 */
	@Override
	public boolean getValidated() {
		return model.getValidated();
	}

	/**
	 * Returns <code>true</code> if this experience is current.
	 *
	 * @return <code>true</code> if this experience is current; <code>false</code> otherwise
	 */
	@Override
	public boolean isCurrent() {
		return model.isCurrent();
	}

	/**
	 * Returns <code>true</code> if this experience is validated.
	 *
	 * @return <code>true</code> if this experience is validated; <code>false</code> otherwise
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
	 * Sets the company ID of this experience.
	 *
	 * @param companyId the company ID of this experience
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this experience.
	 *
	 * @param createDate the create date of this experience
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this experience is current.
	 *
	 * @param current the current of this experience
	 */
	@Override
	public void setCurrent(boolean current) {
		model.setCurrent(current);
	}

	/**
	 * Sets the experience ID of this experience.
	 *
	 * @param experienceId the experience ID of this experience
	 */
	@Override
	public void setExperienceId(long experienceId) {
		model.setExperienceId(experienceId);
	}

	/**
	 * Sets the from date of this experience.
	 *
	 * @param fromDate the from date of this experience
	 */
	@Override
	public void setFromDate(Date fromDate) {
		model.setFromDate(fromDate);
	}

	/**
	 * Sets the modified date of this experience.
	 *
	 * @param modifiedDate the modified date of this experience
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the place of work of this experience.
	 *
	 * @param placeOfWork the place of work of this experience
	 */
	@Override
	public void setPlaceOfWork(String placeOfWork) {
		model.setPlaceOfWork(placeOfWork);
	}

	/**
	 * Sets the primary key of this experience.
	 *
	 * @param primaryKey the primary key of this experience
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the role of this experience.
	 *
	 * @param role the role of this experience
	 */
	@Override
	public void setRole(String role) {
		model.setRole(role);
	}

	/**
	 * Sets the to date of this experience.
	 *
	 * @param toDate the to date of this experience
	 */
	@Override
	public void setToDate(Date toDate) {
		model.setToDate(toDate);
	}

	/**
	 * Sets the user ID of this experience.
	 *
	 * @param userId the user ID of this experience
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this experience.
	 *
	 * @param userName the user name of this experience
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this experience.
	 *
	 * @param userUuid the user uuid of this experience
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this experience.
	 *
	 * @param uuid the uuid of this experience
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets whether this experience is validated.
	 *
	 * @param validated the validated of this experience
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
	protected ExperienceWrapper wrap(Experience experience) {
		return new ExperienceWrapper(experience);
	}

}