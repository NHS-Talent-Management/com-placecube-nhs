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
 * This class is a wrapper for {@link ProfessionalBody}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProfessionalBody
 * @generated
 */
@ProviderType
public class ProfessionalBodyWrapper
	extends BaseModelWrapper<ProfessionalBody>
	implements ProfessionalBody, ModelWrapper<ProfessionalBody> {

	public ProfessionalBodyWrapper(ProfessionalBody professionalBody) {
		super(professionalBody);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("professionalBodyId", getProfessionalBodyId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("location", getLocation());
		attributes.put("expiryDate", getExpiryDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long professionalBodyId = (Long)attributes.get("professionalBodyId");

		if (professionalBodyId != null) {
			setProfessionalBodyId(professionalBodyId);
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

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}

		Date expiryDate = (Date)attributes.get("expiryDate");

		if (expiryDate != null) {
			setExpiryDate(expiryDate);
		}
	}

	/**
	 * Returns the company ID of this professional body.
	 *
	 * @return the company ID of this professional body
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this professional body.
	 *
	 * @return the create date of this professional body
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the expiry date of this professional body.
	 *
	 * @return the expiry date of this professional body
	 */
	@Override
	public Date getExpiryDate() {
		return model.getExpiryDate();
	}

	/**
	 * Returns the location of this professional body.
	 *
	 * @return the location of this professional body
	 */
	@Override
	public String getLocation() {
		return model.getLocation();
	}

	/**
	 * Returns the modified date of this professional body.
	 *
	 * @return the modified date of this professional body
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this professional body.
	 *
	 * @return the primary key of this professional body
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the professional body ID of this professional body.
	 *
	 * @return the professional body ID of this professional body
	 */
	@Override
	public long getProfessionalBodyId() {
		return model.getProfessionalBodyId();
	}

	/**
	 * Returns the title of this professional body.
	 *
	 * @return the title of this professional body
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user ID of this professional body.
	 *
	 * @return the user ID of this professional body
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this professional body.
	 *
	 * @return the user name of this professional body
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this professional body.
	 *
	 * @return the user uuid of this professional body
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this professional body.
	 *
	 * @return the uuid of this professional body
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
	 * Sets the company ID of this professional body.
	 *
	 * @param companyId the company ID of this professional body
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this professional body.
	 *
	 * @param createDate the create date of this professional body
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the expiry date of this professional body.
	 *
	 * @param expiryDate the expiry date of this professional body
	 */
	@Override
	public void setExpiryDate(Date expiryDate) {
		model.setExpiryDate(expiryDate);
	}

	/**
	 * Sets the location of this professional body.
	 *
	 * @param location the location of this professional body
	 */
	@Override
	public void setLocation(String location) {
		model.setLocation(location);
	}

	/**
	 * Sets the modified date of this professional body.
	 *
	 * @param modifiedDate the modified date of this professional body
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this professional body.
	 *
	 * @param primaryKey the primary key of this professional body
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the professional body ID of this professional body.
	 *
	 * @param professionalBodyId the professional body ID of this professional body
	 */
	@Override
	public void setProfessionalBodyId(long professionalBodyId) {
		model.setProfessionalBodyId(professionalBodyId);
	}

	/**
	 * Sets the title of this professional body.
	 *
	 * @param title the title of this professional body
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this professional body.
	 *
	 * @param userId the user ID of this professional body
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this professional body.
	 *
	 * @param userName the user name of this professional body
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this professional body.
	 *
	 * @param userUuid the user uuid of this professional body
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this professional body.
	 *
	 * @param uuid the uuid of this professional body
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
	protected ProfessionalBodyWrapper wrap(ProfessionalBody professionalBody) {
		return new ProfessionalBodyWrapper(professionalBody);
	}

}