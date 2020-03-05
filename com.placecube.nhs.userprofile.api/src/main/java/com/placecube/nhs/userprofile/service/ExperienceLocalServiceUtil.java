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

package com.placecube.nhs.userprofile.service;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Experience. This utility wraps
 * <code>com.placecube.nhs.userprofile.service.impl.ExperienceLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ExperienceLocalService
 * @generated
 */
@ProviderType
public class ExperienceLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.placecube.nhs.userprofile.service.impl.ExperienceLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the experience to the database. Also notifies the appropriate model listeners.
	 *
	 * @param experience the experience
	 * @return the experience that was added
	 */
	public static com.placecube.nhs.userprofile.model.Experience addExperience(
		com.placecube.nhs.userprofile.model.Experience experience) {

		return getService().addExperience(experience);
	}

	/**
	 * Creates a new experience with the primary key. Does not add the experience to the database.
	 *
	 * @param experienceId the primary key for the new experience
	 * @return the new experience
	 */
	public static com.placecube.nhs.userprofile.model.Experience
		createExperience(long experienceId) {

		return getService().createExperience(experienceId);
	}

	public static com.placecube.nhs.userprofile.model.Experience
		createExperience(
			com.liferay.portal.kernel.model.User user, String placeOfWork,
			String role, boolean current, java.util.Date fromDate,
			java.util.Date toDate) {

		return getService().createExperience(
			user, placeOfWork, role, current, fromDate, toDate);
	}

	/**
	 * Deletes the experience from the database. Also notifies the appropriate model listeners.
	 *
	 * @param experience the experience
	 * @return the experience that was removed
	 */
	public static com.placecube.nhs.userprofile.model.Experience
		deleteExperience(
			com.placecube.nhs.userprofile.model.Experience experience) {

		return getService().deleteExperience(experience);
	}

	/**
	 * Deletes the experience with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param experienceId the primary key of the experience
	 * @return the experience that was removed
	 * @throws PortalException if a experience with the primary key could not be found
	 */
	public static com.placecube.nhs.userprofile.model.Experience
			deleteExperience(long experienceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteExperience(experienceId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.placecube.nhs.userprofile.model.impl.ExperienceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.placecube.nhs.userprofile.model.impl.ExperienceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.placecube.nhs.userprofile.model.Experience
		fetchExperience(long experienceId) {

		return getService().fetchExperience(experienceId);
	}

	/**
	 * Returns the experience with the matching UUID and company.
	 *
	 * @param uuid the experience's UUID
	 * @param companyId the primary key of the company
	 * @return the matching experience, or <code>null</code> if a matching experience could not be found
	 */
	public static com.placecube.nhs.userprofile.model.Experience
		fetchExperienceByUuidAndCompanyId(String uuid, long companyId) {

		return getService().fetchExperienceByUuidAndCompanyId(uuid, companyId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the experience with the primary key.
	 *
	 * @param experienceId the primary key of the experience
	 * @return the experience
	 * @throws PortalException if a experience with the primary key could not be found
	 */
	public static com.placecube.nhs.userprofile.model.Experience getExperience(
			long experienceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getExperience(experienceId);
	}

	/**
	 * Returns the experience with the matching UUID and company.
	 *
	 * @param uuid the experience's UUID
	 * @param companyId the primary key of the company
	 * @return the matching experience
	 * @throws PortalException if a matching experience could not be found
	 */
	public static com.placecube.nhs.userprofile.model.Experience
			getExperienceByUuidAndCompanyId(String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getExperienceByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of all the experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.placecube.nhs.userprofile.model.impl.ExperienceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of experiences
	 * @param end the upper bound of the range of experiences (not inclusive)
	 * @return the range of experiences
	 */
	public static java.util.List<com.placecube.nhs.userprofile.model.Experience>
		getExperiences(int start, int end) {

		return getService().getExperiences(start, end);
	}

	public static java.util.List<com.placecube.nhs.userprofile.model.Experience>
		getExperiences(long userId) {

		return getService().getExperiences(userId);
	}

	/**
	 * Returns the number of experiences.
	 *
	 * @return the number of experiences
	 */
	public static int getExperiencesCount() {
		return getService().getExperiencesCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the experience in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param experience the experience
	 * @return the experience that was updated
	 */
	public static com.placecube.nhs.userprofile.model.Experience
		updateExperience(
			com.placecube.nhs.userprofile.model.Experience experience) {

		return getService().updateExperience(experience);
	}

	public static com.placecube.nhs.userprofile.model.Experience
			updateExperience(
				long experienceId, String placeOfWork, String role,
				boolean current, java.util.Date fromDate, java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateExperience(
			experienceId, placeOfWork, role, current, fromDate, toDate);
	}

	public static ExperienceLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ExperienceLocalService, ExperienceLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ExperienceLocalService.class);

		ServiceTracker<ExperienceLocalService, ExperienceLocalService>
			serviceTracker =
				new ServiceTracker
					<ExperienceLocalService, ExperienceLocalService>(
						bundle.getBundleContext(), ExperienceLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}