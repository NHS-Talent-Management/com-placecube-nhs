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

package com.placecube.nhs.notification.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the UserNotificationPreference service. Represents a row in the &quot;NHS_Notification_UserNotificationPreference&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see UserNotificationPreferenceModel
 * @generated
 */
@ImplementationClassName(
	"com.placecube.nhs.notification.model.impl.UserNotificationPreferenceImpl"
)
@ProviderType
public interface UserNotificationPreference
	extends PersistedModel, UserNotificationPreferenceModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.placecube.nhs.notification.model.impl.UserNotificationPreferenceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<UserNotificationPreference, Long>
		USER_ID_ACCESSOR = new Accessor<UserNotificationPreference, Long>() {

			@Override
			public Long get(
				UserNotificationPreference userNotificationPreference) {

				return userNotificationPreference.getUserId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<UserNotificationPreference> getTypeClass() {
				return UserNotificationPreference.class;
			}

		};
	public static final Accessor<UserNotificationPreference, String>
		NOTIFICATION_TYPE_ACCESSOR =
			new Accessor<UserNotificationPreference, String>() {

				@Override
				public String get(
					UserNotificationPreference userNotificationPreference) {

					return userNotificationPreference.getNotificationType();
				}

				@Override
				public Class<String> getAttributeClass() {
					return String.class;
				}

				@Override
				public Class<UserNotificationPreference> getTypeClass() {
					return UserNotificationPreference.class;
				}

			};

}