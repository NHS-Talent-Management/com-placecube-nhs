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

import com.placecube.nhs.userprofile.model.ProfessionalBody;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing ProfessionalBody in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class ProfessionalBodyCacheModel
	implements CacheModel<ProfessionalBody>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProfessionalBodyCacheModel)) {
			return false;
		}

		ProfessionalBodyCacheModel professionalBodyCacheModel =
			(ProfessionalBodyCacheModel)obj;

		if (professionalBodyId ==
				professionalBodyCacheModel.professionalBodyId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, professionalBodyId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", professionalBodyId=");
		sb.append(professionalBodyId);
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
		sb.append(", title=");
		sb.append(title);
		sb.append(", registrationNumber=");
		sb.append(registrationNumber);
		sb.append(", lastUpdateDate=");
		sb.append(lastUpdateDate);
		sb.append(", revalidationDate=");
		sb.append(revalidationDate);
		sb.append(", validated=");
		sb.append(validated);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProfessionalBody toEntityModel() {
		ProfessionalBodyImpl professionalBodyImpl = new ProfessionalBodyImpl();

		if (uuid == null) {
			professionalBodyImpl.setUuid("");
		}
		else {
			professionalBodyImpl.setUuid(uuid);
		}

		professionalBodyImpl.setProfessionalBodyId(professionalBodyId);
		professionalBodyImpl.setCompanyId(companyId);
		professionalBodyImpl.setUserId(userId);

		if (userName == null) {
			professionalBodyImpl.setUserName("");
		}
		else {
			professionalBodyImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			professionalBodyImpl.setCreateDate(null);
		}
		else {
			professionalBodyImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			professionalBodyImpl.setModifiedDate(null);
		}
		else {
			professionalBodyImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			professionalBodyImpl.setTitle("");
		}
		else {
			professionalBodyImpl.setTitle(title);
		}

		if (registrationNumber == null) {
			professionalBodyImpl.setRegistrationNumber("");
		}
		else {
			professionalBodyImpl.setRegistrationNumber(registrationNumber);
		}

		if (lastUpdateDate == Long.MIN_VALUE) {
			professionalBodyImpl.setLastUpdateDate(null);
		}
		else {
			professionalBodyImpl.setLastUpdateDate(new Date(lastUpdateDate));
		}

		if (revalidationDate == Long.MIN_VALUE) {
			professionalBodyImpl.setRevalidationDate(null);
		}
		else {
			professionalBodyImpl.setRevalidationDate(
				new Date(revalidationDate));
		}

		professionalBodyImpl.setValidated(validated);

		professionalBodyImpl.resetOriginalValues();

		return professionalBodyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		professionalBodyId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		title = objectInput.readUTF();
		registrationNumber = objectInput.readUTF();
		lastUpdateDate = objectInput.readLong();
		revalidationDate = objectInput.readLong();

		validated = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(professionalBodyId);

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

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (registrationNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(registrationNumber);
		}

		objectOutput.writeLong(lastUpdateDate);
		objectOutput.writeLong(revalidationDate);

		objectOutput.writeBoolean(validated);
	}

	public String uuid;
	public long professionalBodyId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String title;
	public String registrationNumber;
	public long lastUpdateDate;
	public long revalidationDate;
	public boolean validated;

}