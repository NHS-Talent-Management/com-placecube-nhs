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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.placecube.nhs.userprofile.model.Experience;
import com.placecube.nhs.userprofile.service.base.ExperienceLocalServiceBaseImpl;

/**
 * The implementation of the experience local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.placecube.nhs.userprofile.service.ExperienceLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExperienceLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.placecube.nhs.userprofile.model.Experience", service = AopService.class)
public class ExperienceLocalServiceImpl extends ExperienceLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>com.placecube.nhs.userprofile.service.ExperienceLocalService</code>
	 * via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or
	 * use
	 * <code>com.placecube.nhs.userprofile.service.ExperienceLocalServiceUtil</
	 * code>.
	 */

	@Override
	public Experience createExperience(User user, String placeOfWork, String role, boolean current, Date fromDate, Date toDate) {
		Experience experience = experienceLocalService.createExperience(counterLocalService.increment(Experience.class.getName(), 1));
		experience.setUserId(user.getUserId());
		experience.setUserName(user.getFullName());
		experience.setPlaceOfWork(placeOfWork);
		experience.setRole(role);
		experience.setCurrent(current);
		experience.setFromDate(fromDate);
		experience.setToDate(current ? null : toDate);
		return experienceLocalService.addExperience(experience);
	}

	@Override
	public List<Experience> getExperiences(long userId) {
		return experiencePersistence.findByUserId(userId);
	}

	@Override
	public Experience updateExperience(long experienceId, String placeOfWork, String role, boolean current, Date fromDate, Date toDate) throws PortalException {
		Experience experience = experienceLocalService.getExperience(experienceId);
		experience.setPlaceOfWork(placeOfWork);
		experience.setRole(role);
		experience.setCurrent(current);
		experience.setFromDate(fromDate);
		experience.setToDate(current ? null : toDate);
		return experienceLocalService.updateExperience(experience);
	}

}