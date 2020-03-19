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

package com.placecube.nhs.userprivacy.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.placecube.nhs.userprivacy.constants.UserPrivacyConstants;
import com.placecube.nhs.userprivacy.model.UserPrivacy;
import com.placecube.nhs.userprivacy.service.base.UserPrivacyLocalServiceBaseImpl;

/**
 * The implementation of the user privacy local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.placecube.nhs.userprivacy.service.UserPrivacyLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserPrivacyLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.placecube.nhs.userprivacy.model.UserPrivacy", service = AopService.class)
public class UserPrivacyLocalServiceImpl extends UserPrivacyLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>com.placecube.nhs.userprivacy.service.UserPrivacyLocalService</
	 * code> via injection or a
	 * <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.placecube.nhs.userprivacy.service.UserPrivacyLocalServiceUtil</
	 * code>.
	 */

	/**
	 * Returns the UserPrivacy settings for the specified user
	 *
	 * @param userId the userId to retrieve settings for
	 * @return list of privacy settings for the user
	 */
	@Override
	public List<UserPrivacy> getByUserId(long userId) {
		return userPrivacyPersistence.findByUserId(userId);
	}

	/**
	 * Removes all the privacy settings for the user
	 *
	 * @param userId the userId to remove settings from
	 */
	@Override
	public void deleteByUserId(long userId) {
		userPrivacyPersistence.removeByUserId(userId);
	}

	/**
	 * Removes all the privacy settings for the company for the given fieldId
	 *
	 * @param companyId the comapnyId
	 * @param fieldId the fieldId
	 */
	@Override
	public void deleteByFieldId(long companyId, String fieldId) {
		userPrivacyPersistence.removeByCompanyIdFieldId(companyId, fieldId);
	}

	/**
	 * Returns a set of distinct fieldIds that are configured in the company
	 * with privacy values
	 *
	 * @param companyId the companyId
	 * @return set of unique fieldIds
	 */
	@Override
	public Set<String> getConfiguredPrivacyFieldIds(long companyId) {
		DynamicQuery dynamicQuery = userPrivacyLocalService.dynamicQuery();
		dynamicQuery.add(RestrictionsFactoryUtil.eq("companyId", companyId));
		dynamicQuery.setProjection(ProjectionFactoryUtil.property("fieldId"));
		List<String> privacyFieldIds = userPrivacyLocalService.dynamicQuery(dynamicQuery);
		return new HashSet<>(privacyFieldIds);
	}

	/**
	 * Returns a long array of privacy roleIds
	 * 
	 * @param userId the userId
	 * @param userPrivacyFieldId the userPrivacyFieldId
	 */
	public long[] getUserPrivacyRoleIds(long userId, String userPrivacyFieldId) {
		long[] roleIds = new long[0];
		UserPrivacy userPrivacy = userPrivacyPersistence.fetchByUserIdFieldId(userId, userPrivacyFieldId);
		String[] roleIdsAsString;
		if (Validator.isNotNull(userPrivacy)) {
			roleIdsAsString = StringUtil.split(userPrivacy.getRoleIds(), UserPrivacyConstants.ROLE_IDS_SEPARATOR);
			roleIds = Arrays.stream(roleIdsAsString).mapToLong(i -> Long.valueOf(i)).toArray();
		}
		return roleIds;
	}

	/**
	 * Update UserPrivacy or create if not exist
	 * 
	 * @param userId the userId
	 * @param userPrivacyFieldId the userPrivacyFieldId
	 * @param companyId the companyId
	 * @param roleIds the roleIds
	 * @return UserPrivacy model updated or created
	 */
	public UserPrivacy updateUserPrivacy(long userId, String userPrivacyFieldId, long companyId, List<Long> roleIds) {
		String roleIdsValues = roleIds.stream().map(String::valueOf).collect(Collectors.joining(UserPrivacyConstants.ROLE_IDS_SEPARATOR));
		UserPrivacy userPrivacy = userPrivacyPersistence.fetchByUserIdFieldId(userId, userPrivacyFieldId);
		if (Validator.isNotNull(userPrivacy)) {
			userPrivacy.setModifiedDate(new Date());
			userPrivacy.setRoleIds(roleIdsValues);
		} else {
			userPrivacy = userPrivacyLocalService.createUserPrivacy(counterLocalService.increment(UserPrivacy.class.getName(), 1));
			userPrivacy.setCompanyId(companyId);
			userPrivacy.setCreateDate(new Date());
			userPrivacy.setFieldId(userPrivacyFieldId);
			userPrivacy.setModifiedDate(new Date());
			userPrivacy.setRoleIds(roleIdsValues);
			userPrivacy.setUserId(userId);
		}
		return userPrivacyPersistence.update(userPrivacy);
	}
}