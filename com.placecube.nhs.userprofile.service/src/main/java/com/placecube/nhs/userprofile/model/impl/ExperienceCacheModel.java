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

package com.placecube.nhs.userprofile.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.placecube.nhs.userprofile.model.Experience;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Experience in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class ExperienceCacheModel
	implements CacheModel<Experience>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ExperienceCacheModel)) {
			return false;
		}

		ExperienceCacheModel experienceCacheModel = (ExperienceCacheModel)obj;

		if (experienceId == experienceCacheModel.experienceId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, experienceId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", experienceId=");
		sb.append(experienceId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", placeOfWork=");
		sb.append(placeOfWork);
		sb.append(", role=");
		sb.append(role);
		sb.append(", current=");
		sb.append(current);
		sb.append(", fromDate=");
		sb.append(fromDate);
		sb.append(", toDate=");
		sb.append(toDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Experience toEntityModel() {
		ExperienceImpl experienceImpl = new ExperienceImpl();

		if (uuid == null) {
			experienceImpl.setUuid("");
		}
		else {
			experienceImpl.setUuid(uuid);
		}

		experienceImpl.setExperienceId(experienceId);
		experienceImpl.setCompanyId(companyId);
		experienceImpl.setUserId(userId);

		if (userName == null) {
			experienceImpl.setUserName("");
		}
		else {
			experienceImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			experienceImpl.setCreateDate(null);
		}
		else {
			experienceImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			experienceImpl.setModifiedDate(null);
		}
		else {
			experienceImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (placeOfWork == null) {
			experienceImpl.setPlaceOfWork("");
		}
		else {
			experienceImpl.setPlaceOfWork(placeOfWork);
		}

		if (role == null) {
			experienceImpl.setRole("");
		}
		else {
			experienceImpl.setRole(role);
		}

		experienceImpl.setCurrent(current);

		if (fromDate == Long.MIN_VALUE) {
			experienceImpl.setFromDate(null);
		}
		else {
			experienceImpl.setFromDate(new Date(fromDate));
		}

		if (toDate == Long.MIN_VALUE) {
			experienceImpl.setToDate(null);
		}
		else {
			experienceImpl.setToDate(new Date(toDate));
		}

		experienceImpl.resetOriginalValues();

		return experienceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		experienceId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		placeOfWork = objectInput.readUTF();
		role = objectInput.readUTF();

		current = objectInput.readBoolean();
		fromDate = objectInput.readLong();
		toDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(experienceId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (placeOfWork == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(placeOfWork);
		}

		if (role == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(role);
		}

		objectOutput.writeBoolean(current);
		objectOutput.writeLong(fromDate);
		objectOutput.writeLong(toDate);
	}

	public String uuid;
	public long experienceId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String placeOfWork;
	public String role;
	public boolean current;
	public long fromDate;
	public long toDate;

}