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

package com.placecube.nhs.userprivacy.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.placecube.nhs.userprivacy.model.UserPrivacy;
import com.placecube.nhs.userprivacy.service.persistence.UserPrivacyPK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing UserPrivacy in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class UserPrivacyCacheModel
	implements CacheModel<UserPrivacy>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserPrivacyCacheModel)) {
			return false;
		}

		UserPrivacyCacheModel userPrivacyCacheModel =
			(UserPrivacyCacheModel)obj;

		if (userPrivacyPK.equals(userPrivacyCacheModel.userPrivacyPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userPrivacyPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", fieldId=");
		sb.append(fieldId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", roleIds=");
		sb.append(roleIds);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserPrivacy toEntityModel() {
		UserPrivacyImpl userPrivacyImpl = new UserPrivacyImpl();

		if (uuid == null) {
			userPrivacyImpl.setUuid("");
		}
		else {
			userPrivacyImpl.setUuid(uuid);
		}

		userPrivacyImpl.setUserId(userId);

		if (fieldId == null) {
			userPrivacyImpl.setFieldId("");
		}
		else {
			userPrivacyImpl.setFieldId(fieldId);
		}

		userPrivacyImpl.setCompanyId(companyId);

		if (roleIds == null) {
			userPrivacyImpl.setRoleIds("");
		}
		else {
			userPrivacyImpl.setRoleIds(roleIds);
		}

		if (createDate == Long.MIN_VALUE) {
			userPrivacyImpl.setCreateDate(null);
		}
		else {
			userPrivacyImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			userPrivacyImpl.setModifiedDate(null);
		}
		else {
			userPrivacyImpl.setModifiedDate(new Date(modifiedDate));
		}

		userPrivacyImpl.resetOriginalValues();

		return userPrivacyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		userId = objectInput.readLong();
		fieldId = objectInput.readUTF();

		companyId = objectInput.readLong();
		roleIds = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		userPrivacyPK = new UserPrivacyPK(userId, fieldId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(userId);

		if (fieldId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fieldId);
		}

		objectOutput.writeLong(companyId);

		if (roleIds == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(roleIds);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long userId;
	public String fieldId;
	public long companyId;
	public String roleIds;
	public long createDate;
	public long modifiedDate;
	public transient UserPrivacyPK userPrivacyPK;

}