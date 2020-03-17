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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
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
}