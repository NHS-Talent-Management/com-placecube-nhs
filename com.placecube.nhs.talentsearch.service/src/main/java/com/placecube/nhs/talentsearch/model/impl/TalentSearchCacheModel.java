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

package com.placecube.nhs.talentsearch.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.placecube.nhs.talentsearch.model.TalentSearch;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing TalentSearch in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class TalentSearchCacheModel
	implements CacheModel<TalentSearch>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TalentSearchCacheModel)) {
			return false;
		}

		TalentSearchCacheModel talentSearchCacheModel =
			(TalentSearchCacheModel)obj;

		if (talentSearchId == talentSearchCacheModel.talentSearchId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, talentSearchId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", talentSearchId=");
		sb.append(talentSearchId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", typeId=");
		sb.append(typeId);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", queryFilter=");
		sb.append(queryFilter);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TalentSearch toEntityModel() {
		TalentSearchImpl talentSearchImpl = new TalentSearchImpl();

		if (uuid == null) {
			talentSearchImpl.setUuid("");
		}
		else {
			talentSearchImpl.setUuid(uuid);
		}

		talentSearchImpl.setTalentSearchId(talentSearchId);
		talentSearchImpl.setCompanyId(companyId);
		talentSearchImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			talentSearchImpl.setCreateDate(null);
		}
		else {
			talentSearchImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			talentSearchImpl.setModifiedDate(null);
		}
		else {
			talentSearchImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			talentSearchImpl.setName("");
		}
		else {
			talentSearchImpl.setName(name);
		}

		talentSearchImpl.setTypeId(typeId);
		talentSearchImpl.setCategoryId(categoryId);

		if (queryFilter == null) {
			talentSearchImpl.setQueryFilter("");
		}
		else {
			talentSearchImpl.setQueryFilter(queryFilter);
		}

		talentSearchImpl.resetOriginalValues();

		return talentSearchImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		talentSearchId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();

		typeId = objectInput.readLong();

		categoryId = objectInput.readLong();
		queryFilter = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(talentSearchId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(typeId);

		objectOutput.writeLong(categoryId);

		if (queryFilter == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(queryFilter);
		}
	}

	public String uuid;
	public long talentSearchId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String name;
	public long typeId;
	public long categoryId;
	public String queryFilter;

}