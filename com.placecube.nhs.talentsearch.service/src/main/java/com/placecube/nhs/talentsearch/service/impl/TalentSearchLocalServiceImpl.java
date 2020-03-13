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

package com.placecube.nhs.talentsearch.service.impl;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.model.User;
import com.placecube.nhs.talentsearch.model.TalentSearch;
import com.placecube.nhs.talentsearch.service.base.TalentSearchLocalServiceBaseImpl;

/**
 * The implementation of the talent search local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.placecube.nhs.talentsearch.service.TalentSearchLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TalentSearchLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.placecube.nhs.talentsearch.model.TalentSearch", service = AopService.class)
public class TalentSearchLocalServiceImpl extends TalentSearchLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>com.placecube.nhs.talentsearch.service.TalentSearchLocalService</
	 * code> via injection or a
	 * <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.placecube.nhs.talentsearch.service.TalentSearchLocalServiceUtil
	 * </code>.
	 */

	public TalentSearch createTalentSearch(User user, String name, long typeId, long categoryId, String queryFilter) {
		long talentSearchId = counterLocalService.increment(TalentSearch.class.getName(), 1);
		TalentSearch talentSearch = talentSearchLocalService.createTalentSearch(talentSearchId);
		talentSearch.setUserId(user.getUserId());
		talentSearch.setCompanyId(user.getCompanyId());
		talentSearch.setName(name);
		talentSearch.setTypeId(typeId);
		talentSearch.setCategoryId(categoryId);
		talentSearch.setQueryFilter(queryFilter);
		return talentSearchLocalService.addTalentSearch(talentSearch);
	}
}