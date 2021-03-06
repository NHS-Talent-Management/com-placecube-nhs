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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Experience service. Represents a row in the &quot;NHS_Experience&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.placecube.nhs.userprofile.model.impl.ExperienceModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.placecube.nhs.userprofile.model.impl.ExperienceImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Experience
 * @generated
 */
@ProviderType
public interface ExperienceModel
	extends BaseModel<Experience>, ShardedModel, StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a experience model instance should use the {@link Experience} interface instead.
	 */

	/**
	 * Returns the primary key of this experience.
	 *
	 * @return the primary key of this experience
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this experience.
	 *
	 * @param primaryKey the primary key of this experience
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this experience.
	 *
	 * @return the uuid of this experience
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this experience.
	 *
	 * @param uuid the uuid of this experience
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the experience ID of this experience.
	 *
	 * @return the experience ID of this experience
	 */
	public long getExperienceId();

	/**
	 * Sets the experience ID of this experience.
	 *
	 * @param experienceId the experience ID of this experience
	 */
	public void setExperienceId(long experienceId);

	/**
	 * Returns the company ID of this experience.
	 *
	 * @return the company ID of this experience
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this experience.
	 *
	 * @param companyId the company ID of this experience
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this experience.
	 *
	 * @return the user ID of this experience
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this experience.
	 *
	 * @param userId the user ID of this experience
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this experience.
	 *
	 * @return the user uuid of this experience
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this experience.
	 *
	 * @param userUuid the user uuid of this experience
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this experience.
	 *
	 * @return the user name of this experience
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this experience.
	 *
	 * @param userName the user name of this experience
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this experience.
	 *
	 * @return the create date of this experience
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this experience.
	 *
	 * @param createDate the create date of this experience
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this experience.
	 *
	 * @return the modified date of this experience
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this experience.
	 *
	 * @param modifiedDate the modified date of this experience
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the place of work of this experience.
	 *
	 * @return the place of work of this experience
	 */
	@AutoEscape
	public String getPlaceOfWork();

	/**
	 * Sets the place of work of this experience.
	 *
	 * @param placeOfWork the place of work of this experience
	 */
	public void setPlaceOfWork(String placeOfWork);

	/**
	 * Returns the role of this experience.
	 *
	 * @return the role of this experience
	 */
	@AutoEscape
	public String getRole();

	/**
	 * Sets the role of this experience.
	 *
	 * @param role the role of this experience
	 */
	public void setRole(String role);

	/**
	 * Returns the current of this experience.
	 *
	 * @return the current of this experience
	 */
	public boolean getCurrent();

	/**
	 * Returns <code>true</code> if this experience is current.
	 *
	 * @return <code>true</code> if this experience is current; <code>false</code> otherwise
	 */
	public boolean isCurrent();

	/**
	 * Sets whether this experience is current.
	 *
	 * @param current the current of this experience
	 */
	public void setCurrent(boolean current);

	/**
	 * Returns the from date of this experience.
	 *
	 * @return the from date of this experience
	 */
	public Date getFromDate();

	/**
	 * Sets the from date of this experience.
	 *
	 * @param fromDate the from date of this experience
	 */
	public void setFromDate(Date fromDate);

	/**
	 * Returns the to date of this experience.
	 *
	 * @return the to date of this experience
	 */
	public Date getToDate();

	/**
	 * Sets the to date of this experience.
	 *
	 * @param toDate the to date of this experience
	 */
	public void setToDate(Date toDate);

	/**
	 * Returns the validated of this experience.
	 *
	 * @return the validated of this experience
	 */
	public boolean getValidated();

	/**
	 * Returns <code>true</code> if this experience is validated.
	 *
	 * @return <code>true</code> if this experience is validated; <code>false</code> otherwise
	 */
	public boolean isValidated();

	/**
	 * Sets whether this experience is validated.
	 *
	 * @param validated the validated of this experience
	 */
	public void setValidated(boolean validated);

}