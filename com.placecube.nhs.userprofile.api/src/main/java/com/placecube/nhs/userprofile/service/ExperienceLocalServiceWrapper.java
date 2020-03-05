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

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link ExperienceLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ExperienceLocalService
 * @generated
 */
@ProviderType
public class ExperienceLocalServiceWrapper
	implements ExperienceLocalService, ServiceWrapper<ExperienceLocalService> {

	public ExperienceLocalServiceWrapper(
		ExperienceLocalService experienceLocalService) {

		_experienceLocalService = experienceLocalService;
	}

	/**
	 * Adds the experience to the database. Also notifies the appropriate model listeners.
	 *
	 * @param experience the experience
	 * @return the experience that was added
	 */
	@Override
	public com.placecube.nhs.userprofile.model.Experience addExperience(
		com.placecube.nhs.userprofile.model.Experience experience) {

		return _experienceLocalService.addExperience(experience);
	}

	/**
	 * Creates a new experience with the primary key. Does not add the experience to the database.
	 *
	 * @param experienceId the primary key for the new experience
	 * @return the new experience
	 */
	@Override
	public com.placecube.nhs.userprofile.model.Experience createExperience(
		long experienceId) {

		return _experienceLocalService.createExperience(experienceId);
	}

	@Override
	public com.placecube.nhs.userprofile.model.Experience createExperience(
		com.liferay.portal.kernel.model.User user, String placeOfWork,
		String role, boolean current, java.util.Date fromDate,
		java.util.Date toDate) {

		return _experienceLocalService.createExperience(
			user, placeOfWork, role, current, fromDate, toDate);
	}

	/**
	 * Deletes the experience from the database. Also notifies the appropriate model listeners.
	 *
	 * @param experience the experience
	 * @return the experience that was removed
	 */
	@Override
	public com.placecube.nhs.userprofile.model.Experience deleteExperience(
		com.placecube.nhs.userprofile.model.Experience experience) {

		return _experienceLocalService.deleteExperience(experience);
	}

	/**
	 * Deletes the experience with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param experienceId the primary key of the experience
	 * @return the experience that was removed
	 * @throws PortalException if a experience with the primary key could not be found
	 */
	@Override
	public com.placecube.nhs.userprofile.model.Experience deleteExperience(
			long experienceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _experienceLocalService.deleteExperience(experienceId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _experienceLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _experienceLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _experienceLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _experienceLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _experienceLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _experienceLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _experienceLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.placecube.nhs.userprofile.model.Experience fetchExperience(
		long experienceId) {

		return _experienceLocalService.fetchExperience(experienceId);
	}

	/**
	 * Returns the experience with the matching UUID and company.
	 *
	 * @param uuid the experience's UUID
	 * @param companyId the primary key of the company
	 * @return the matching experience, or <code>null</code> if a matching experience could not be found
	 */
	@Override
	public com.placecube.nhs.userprofile.model.Experience
		fetchExperienceByUuidAndCompanyId(String uuid, long companyId) {

		return _experienceLocalService.fetchExperienceByUuidAndCompanyId(
			uuid, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _experienceLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the experience with the primary key.
	 *
	 * @param experienceId the primary key of the experience
	 * @return the experience
	 * @throws PortalException if a experience with the primary key could not be found
	 */
	@Override
	public com.placecube.nhs.userprofile.model.Experience getExperience(
			long experienceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _experienceLocalService.getExperience(experienceId);
	}

	/**
	 * Returns the experience with the matching UUID and company.
	 *
	 * @param uuid the experience's UUID
	 * @param companyId the primary key of the company
	 * @return the matching experience
	 * @throws PortalException if a matching experience could not be found
	 */
	@Override
	public com.placecube.nhs.userprofile.model.Experience
			getExperienceByUuidAndCompanyId(String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _experienceLocalService.getExperienceByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<com.placecube.nhs.userprofile.model.Experience>
		getExperiences(int start, int end) {

		return _experienceLocalService.getExperiences(start, end);
	}

	@Override
	public java.util.List<com.placecube.nhs.userprofile.model.Experience>
		getExperiences(long userId) {

		return _experienceLocalService.getExperiences(userId);
	}

	/**
	 * Returns the number of experiences.
	 *
	 * @return the number of experiences
	 */
	@Override
	public int getExperiencesCount() {
		return _experienceLocalService.getExperiencesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _experienceLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _experienceLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _experienceLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _experienceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the experience in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param experience the experience
	 * @return the experience that was updated
	 */
	@Override
	public com.placecube.nhs.userprofile.model.Experience updateExperience(
		com.placecube.nhs.userprofile.model.Experience experience) {

		return _experienceLocalService.updateExperience(experience);
	}

	@Override
	public com.placecube.nhs.userprofile.model.Experience updateExperience(
			long experienceId, String placeOfWork, String role, boolean current,
			java.util.Date fromDate, java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _experienceLocalService.updateExperience(
			experienceId, placeOfWork, role, current, fromDate, toDate);
	}

	@Override
	public ExperienceLocalService getWrappedService() {
		return _experienceLocalService;
	}

	@Override
	public void setWrappedService(
		ExperienceLocalService experienceLocalService) {

		_experienceLocalService = experienceLocalService;
	}

	private ExperienceLocalService _experienceLocalService;

}