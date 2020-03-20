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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the UserPrivacy service. Represents a row in the &quot;NHS_Privacy_UserPrivacy&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see UserPrivacyModel
 * @generated
 */
@ImplementationClassName(
	"com.placecube.nhs.userprivacy.model.impl.UserPrivacyImpl"
)
@ProviderType
public interface UserPrivacy extends PersistedModel, UserPrivacyModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.placecube.nhs.userprivacy.model.impl.UserPrivacyImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<UserPrivacy, Long> USER_ID_ACCESSOR =
		new Accessor<UserPrivacy, Long>() {

			@Override
			public Long get(UserPrivacy userPrivacy) {
				return userPrivacy.getUserId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<UserPrivacy> getTypeClass() {
				return UserPrivacy.class;
			}

		};
	public static final Accessor<UserPrivacy, String> FIELD_ID_ACCESSOR =
		new Accessor<UserPrivacy, String>() {

			@Override
			public String get(UserPrivacy userPrivacy) {
				return userPrivacy.getFieldId();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<UserPrivacy> getTypeClass() {
				return UserPrivacy.class;
			}

		};

}