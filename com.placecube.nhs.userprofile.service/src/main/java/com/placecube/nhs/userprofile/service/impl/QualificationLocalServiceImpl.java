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

package com.placecube.nhs.userprofile.service.impl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.model.User;
import com.placecube.nhs.userprofile.model.Qualification;
import com.placecube.nhs.userprofile.service.base.QualificationLocalServiceBaseImpl;

/**
 * The implementation of the qualification local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.placecube.nhs.userprofile.service.QualificationLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QualificationLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.placecube.nhs.userprofile.model.Qualification", service = AopService.class)
public class QualificationLocalServiceImpl extends QualificationLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>com.placecube.nhs.userprofile.service.QualificationLocalService</
	 * code> via injection or a
	 * <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.placecube.nhs.userprofile.service.QualificationLocalServiceUtil
	 * </code>.
	 */

	@Override
	public Qualification createQualification(User user, String place, String qualification, Date fromDate, Date toDate) {
		Qualification experience = qualificationLocalService.createQualification(counterLocalService.increment(Qualification.class.getName(), 1));
		experience.setUserId(user.getUserId());
		experience.setUserName(user.getFullName());
		experience.setPlace(place);
		experience.setQualification(qualification);
		experience.setFromDate(fromDate);
		experience.setToDate(toDate);
		return qualificationLocalService.addQualification(experience);
	}

	@Override
	public List<Qualification> getQualifications(long userId) {
		return qualificationPersistence.findByUserId(userId);
	}
}