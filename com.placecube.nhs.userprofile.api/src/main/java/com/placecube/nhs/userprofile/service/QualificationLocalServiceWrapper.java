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
 * Provides a wrapper for {@link QualificationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see QualificationLocalService
 * @generated
 */
@ProviderType
public class QualificationLocalServiceWrapper
	implements QualificationLocalService,
			   ServiceWrapper<QualificationLocalService> {

	public QualificationLocalServiceWrapper(
		QualificationLocalService qualificationLocalService) {

		_qualificationLocalService = qualificationLocalService;
	}

	/**
	 * Adds the qualification to the database. Also notifies the appropriate model listeners.
	 *
	 * @param qualification the qualification
	 * @return the qualification that was added
	 */
	@Override
	public com.placecube.nhs.userprofile.model.Qualification addQualification(
		com.placecube.nhs.userprofile.model.Qualification qualification) {

		return _qualificationLocalService.addQualification(qualification);
	}

	/**
	 * Creates a new qualification with the primary key. Does not add the qualification to the database.
	 *
	 * @param qualificationId the primary key for the new qualification
	 * @return the new qualification
	 */
	@Override
	public com.placecube.nhs.userprofile.model.Qualification
		createQualification(long qualificationId) {

		return _qualificationLocalService.createQualification(qualificationId);
	}

	@Override
	public com.placecube.nhs.userprofile.model.Qualification
		createQualification(
			com.liferay.portal.kernel.model.User user, String place,
			String qualification, java.util.Date fromDate,
			java.util.Date toDate) {

		return _qualificationLocalService.createQualification(
			user, place, qualification, fromDate, toDate);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _qualificationLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the qualification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param qualificationId the primary key of the qualification
	 * @return the qualification that was removed
	 * @throws PortalException if a qualification with the primary key could not be found
	 */
	@Override
	public com.placecube.nhs.userprofile.model.Qualification
			deleteQualification(long qualificationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _qualificationLocalService.deleteQualification(qualificationId);
	}

	/**
	 * Deletes the qualification from the database. Also notifies the appropriate model listeners.
	 *
	 * @param qualification the qualification
	 * @return the qualification that was removed
	 */
	@Override
	public com.placecube.nhs.userprofile.model.Qualification
		deleteQualification(
			com.placecube.nhs.userprofile.model.Qualification qualification) {

		return _qualificationLocalService.deleteQualification(qualification);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _qualificationLocalService.dynamicQuery();
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

		return _qualificationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.placecube.nhs.userprofile.model.impl.QualificationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _qualificationLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.placecube.nhs.userprofile.model.impl.QualificationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _qualificationLocalService.dynamicQuery(
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

		return _qualificationLocalService.dynamicQueryCount(dynamicQuery);
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

		return _qualificationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.placecube.nhs.userprofile.model.Qualification fetchQualification(
		long qualificationId) {

		return _qualificationLocalService.fetchQualification(qualificationId);
	}

	/**
	 * Returns the qualification with the matching UUID and company.
	 *
	 * @param uuid the qualification's UUID
	 * @param companyId the primary key of the company
	 * @return the matching qualification, or <code>null</code> if a matching qualification could not be found
	 */
	@Override
	public com.placecube.nhs.userprofile.model.Qualification
		fetchQualificationByUuidAndCompanyId(String uuid, long companyId) {

		return _qualificationLocalService.fetchQualificationByUuidAndCompanyId(
			uuid, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _qualificationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _qualificationLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _qualificationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _qualificationLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _qualificationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the qualification with the primary key.
	 *
	 * @param qualificationId the primary key of the qualification
	 * @return the qualification
	 * @throws PortalException if a qualification with the primary key could not be found
	 */
	@Override
	public com.placecube.nhs.userprofile.model.Qualification getQualification(
			long qualificationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _qualificationLocalService.getQualification(qualificationId);
	}

	/**
	 * Returns the qualification with the matching UUID and company.
	 *
	 * @param uuid the qualification's UUID
	 * @param companyId the primary key of the company
	 * @return the matching qualification
	 * @throws PortalException if a matching qualification could not be found
	 */
	@Override
	public com.placecube.nhs.userprofile.model.Qualification
			getQualificationByUuidAndCompanyId(String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _qualificationLocalService.getQualificationByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of all the qualifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.placecube.nhs.userprofile.model.impl.QualificationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualifications
	 * @param end the upper bound of the range of qualifications (not inclusive)
	 * @return the range of qualifications
	 */
	@Override
	public java.util.List<com.placecube.nhs.userprofile.model.Qualification>
		getQualifications(int start, int end) {

		return _qualificationLocalService.getQualifications(start, end);
	}

	@Override
	public java.util.List<com.placecube.nhs.userprofile.model.Qualification>
		getQualifications(long userId) {

		return _qualificationLocalService.getQualifications(userId);
	}

	/**
	 * Returns the number of qualifications.
	 *
	 * @return the number of qualifications
	 */
	@Override
	public int getQualificationsCount() {
		return _qualificationLocalService.getQualificationsCount();
	}

	/**
	 * Updates the qualification in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param qualification the qualification
	 * @return the qualification that was updated
	 */
	@Override
	public com.placecube.nhs.userprofile.model.Qualification
		updateQualification(
			com.placecube.nhs.userprofile.model.Qualification qualification) {

		return _qualificationLocalService.updateQualification(qualification);
	}

	@Override
	public QualificationLocalService getWrappedService() {
		return _qualificationLocalService;
	}

	@Override
	public void setWrappedService(
		QualificationLocalService qualificationLocalService) {

		_qualificationLocalService = qualificationLocalService;
	}

	private QualificationLocalService _qualificationLocalService;

}