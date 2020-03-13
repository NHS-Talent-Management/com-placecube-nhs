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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link TalentSearch}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TalentSearch
 * @generated
 */
@ProviderType
public class TalentSearchWrapper
	extends BaseModelWrapper<TalentSearch>
	implements TalentSearch, ModelWrapper<TalentSearch> {

	public TalentSearchWrapper(TalentSearch talentSearch) {
		super(talentSearch);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("talentSearchId", getTalentSearchId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("typeId", getTypeId());
		attributes.put("categoryId", getCategoryId());
		attributes.put("queryFilter", getQueryFilter());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long talentSearchId = (Long)attributes.get("talentSearchId");

		if (talentSearchId != null) {
			setTalentSearchId(talentSearchId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long typeId = (Long)attributes.get("typeId");

		if (typeId != null) {
			setTypeId(typeId);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		String queryFilter = (String)attributes.get("queryFilter");

		if (queryFilter != null) {
			setQueryFilter(queryFilter);
		}
	}

	/**
	 * Returns the category ID of this talent search.
	 *
	 * @return the category ID of this talent search
	 */
	@Override
	public long getCategoryId() {
		return model.getCategoryId();
	}

	/**
	 * Returns the company ID of this talent search.
	 *
	 * @return the company ID of this talent search
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this talent search.
	 *
	 * @return the create date of this talent search
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the modified date of this talent search.
	 *
	 * @return the modified date of this talent search
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this talent search.
	 *
	 * @return the name of this talent search
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this talent search.
	 *
	 * @return the primary key of this talent search
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the query filter of this talent search.
	 *
	 * @return the query filter of this talent search
	 */
	@Override
	public String getQueryFilter() {
		return model.getQueryFilter();
	}

	/**
	 * Returns the talent search ID of this talent search.
	 *
	 * @return the talent search ID of this talent search
	 */
	@Override
	public long getTalentSearchId() {
		return model.getTalentSearchId();
	}

	/**
	 * Returns the type ID of this talent search.
	 *
	 * @return the type ID of this talent search
	 */
	@Override
	public long getTypeId() {
		return model.getTypeId();
	}

	/**
	 * Returns the user ID of this talent search.
	 *
	 * @return the user ID of this talent search
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this talent search.
	 *
	 * @return the user uuid of this talent search
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this talent search.
	 *
	 * @return the uuid of this talent search
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
	 * Sets the category ID of this talent search.
	 *
	 * @param categoryId the category ID of this talent search
	 */
	@Override
	public void setCategoryId(long categoryId) {
		model.setCategoryId(categoryId);
	}

	/**
	 * Sets the company ID of this talent search.
	 *
	 * @param companyId the company ID of this talent search
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this talent search.
	 *
	 * @param createDate the create date of this talent search
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the modified date of this talent search.
	 *
	 * @param modifiedDate the modified date of this talent search
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this talent search.
	 *
	 * @param name the name of this talent search
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this talent search.
	 *
	 * @param primaryKey the primary key of this talent search
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the query filter of this talent search.
	 *
	 * @param queryFilter the query filter of this talent search
	 */
	@Override
	public void setQueryFilter(String queryFilter) {
		model.setQueryFilter(queryFilter);
	}

	/**
	 * Sets the talent search ID of this talent search.
	 *
	 * @param talentSearchId the talent search ID of this talent search
	 */
	@Override
	public void setTalentSearchId(long talentSearchId) {
		model.setTalentSearchId(talentSearchId);
	}

	/**
	 * Sets the type ID of this talent search.
	 *
	 * @param typeId the type ID of this talent search
	 */
	@Override
	public void setTypeId(long typeId) {
		model.setTypeId(typeId);
	}

	/**
	 * Sets the user ID of this talent search.
	 *
	 * @param userId the user ID of this talent search
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this talent search.
	 *
	 * @param userUuid the user uuid of this talent search
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this talent search.
	 *
	 * @param uuid the uuid of this talent search
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
	protected TalentSearchWrapper wrap(TalentSearch talentSearch) {
		return new TalentSearchWrapper(talentSearch);
	}

}