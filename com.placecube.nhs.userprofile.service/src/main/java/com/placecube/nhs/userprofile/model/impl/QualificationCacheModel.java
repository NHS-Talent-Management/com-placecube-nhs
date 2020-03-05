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

import com.placecube.nhs.userprofile.model.Qualification;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Qualification in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class QualificationCacheModel
	implements CacheModel<Qualification>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof QualificationCacheModel)) {
			return false;
		}

		QualificationCacheModel qualificationCacheModel =
			(QualificationCacheModel)obj;

		if (qualificationId == qualificationCacheModel.qualificationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, qualificationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", qualificationId=");
		sb.append(qualificationId);
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
		sb.append(", place=");
		sb.append(place);
		sb.append(", qualification=");
		sb.append(qualification);
		sb.append(", fromDate=");
		sb.append(fromDate);
		sb.append(", toDate=");
		sb.append(toDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Qualification toEntityModel() {
		QualificationImpl qualificationImpl = new QualificationImpl();

		if (uuid == null) {
			qualificationImpl.setUuid("");
		}
		else {
			qualificationImpl.setUuid(uuid);
		}

		qualificationImpl.setQualificationId(qualificationId);
		qualificationImpl.setCompanyId(companyId);
		qualificationImpl.setUserId(userId);

		if (userName == null) {
			qualificationImpl.setUserName("");
		}
		else {
			qualificationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			qualificationImpl.setCreateDate(null);
		}
		else {
			qualificationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			qualificationImpl.setModifiedDate(null);
		}
		else {
			qualificationImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (place == null) {
			qualificationImpl.setPlace("");
		}
		else {
			qualificationImpl.setPlace(place);
		}

		if (qualification == null) {
			qualificationImpl.setQualification("");
		}
		else {
			qualificationImpl.setQualification(qualification);
		}

		if (fromDate == Long.MIN_VALUE) {
			qualificationImpl.setFromDate(null);
		}
		else {
			qualificationImpl.setFromDate(new Date(fromDate));
		}

		if (toDate == Long.MIN_VALUE) {
			qualificationImpl.setToDate(null);
		}
		else {
			qualificationImpl.setToDate(new Date(toDate));
		}

		qualificationImpl.resetOriginalValues();

		return qualificationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		qualificationId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		place = objectInput.readUTF();
		qualification = objectInput.readUTF();
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

		objectOutput.writeLong(qualificationId);

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

		if (place == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(place);
		}

		if (qualification == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(qualification);
		}

		objectOutput.writeLong(fromDate);
		objectOutput.writeLong(toDate);
	}

	public String uuid;
	public long qualificationId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String place;
	public String qualification;
	public long fromDate;
	public long toDate;

}