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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link UserPrivacy}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserPrivacy
 * @generated
 */
@ProviderType
public class UserPrivacyWrapper
	extends BaseModelWrapper<UserPrivacy>
	implements UserPrivacy, ModelWrapper<UserPrivacy> {

	public UserPrivacyWrapper(UserPrivacy userPrivacy) {
		super(userPrivacy);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("userPrivacyId", getUserPrivacyId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("fieldId", getFieldId());
		attributes.put("roleIds", getRoleIds());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long userPrivacyId = (Long)attributes.get("userPrivacyId");

		if (userPrivacyId != null) {
			setUserPrivacyId(userPrivacyId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String fieldId = (String)attributes.get("fieldId");

		if (fieldId != null) {
			setFieldId(fieldId);
		}

		String roleIds = (String)attributes.get("roleIds");

		if (roleIds != null) {
			setRoleIds(roleIds);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	 * Returns the company ID of this user privacy.
	 *
	 * @return the company ID of this user privacy
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this user privacy.
	 *
	 * @return the create date of this user privacy
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the field ID of this user privacy.
	 *
	 * @return the field ID of this user privacy
	 */
	@Override
	public String getFieldId() {
		return model.getFieldId();
	}

	/**
	 * Returns the modified date of this user privacy.
	 *
	 * @return the modified date of this user privacy
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this user privacy.
	 *
	 * @return the primary key of this user privacy
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the role IDs of this user privacy.
	 *
	 * @return the role IDs of this user privacy
	 */
	@Override
	public String getRoleIds() {
		return model.getRoleIds();
	}

	/**
	 * Returns the user ID of this user privacy.
	 *
	 * @return the user ID of this user privacy
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user privacy ID of this user privacy.
	 *
	 * @return the user privacy ID of this user privacy
	 */
	@Override
	public long getUserPrivacyId() {
		return model.getUserPrivacyId();
	}

	/**
	 * Returns the user uuid of this user privacy.
	 *
	 * @return the user uuid of this user privacy
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this user privacy.
	 *
	 * @return the uuid of this user privacy
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
	 * Sets the company ID of this user privacy.
	 *
	 * @param companyId the company ID of this user privacy
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this user privacy.
	 *
	 * @param createDate the create date of this user privacy
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the field ID of this user privacy.
	 *
	 * @param fieldId the field ID of this user privacy
	 */
	@Override
	public void setFieldId(String fieldId) {
		model.setFieldId(fieldId);
	}

	/**
	 * Sets the modified date of this user privacy.
	 *
	 * @param modifiedDate the modified date of this user privacy
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this user privacy.
	 *
	 * @param primaryKey the primary key of this user privacy
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the role IDs of this user privacy.
	 *
	 * @param roleIds the role IDs of this user privacy
	 */
	@Override
	public void setRoleIds(String roleIds) {
		model.setRoleIds(roleIds);
	}

	/**
	 * Sets the user ID of this user privacy.
	 *
	 * @param userId the user ID of this user privacy
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user privacy ID of this user privacy.
	 *
	 * @param userPrivacyId the user privacy ID of this user privacy
	 */
	@Override
	public void setUserPrivacyId(long userPrivacyId) {
		model.setUserPrivacyId(userPrivacyId);
	}

	/**
	 * Sets the user uuid of this user privacy.
	 *
	 * @param userUuid the user uuid of this user privacy
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this user privacy.
	 *
	 * @param uuid the uuid of this user privacy
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
	protected UserPrivacyWrapper wrap(UserPrivacy userPrivacy) {
		return new UserPrivacyWrapper(userPrivacy);
	}

}