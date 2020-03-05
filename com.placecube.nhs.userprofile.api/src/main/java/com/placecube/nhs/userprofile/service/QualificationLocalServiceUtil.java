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
 * Provides the local service utility for Qualification. This utility wraps
 * <code>com.placecube.nhs.userprofile.service.impl.QualificationLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see QualificationLocalService
 * @generated
 */
@ProviderType
public class QualificationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.placecube.nhs.userprofile.service.impl.QualificationLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the qualification to the database. Also notifies the appropriate model listeners.
	 *
	 * @param qualification the qualification
	 * @return the qualification that was added
	 */
	public static com.placecube.nhs.userprofile.model.Qualification
		addQualification(
			com.placecube.nhs.userprofile.model.Qualification qualification) {

		return getService().addQualification(qualification);
	}

	/**
	 * Creates a new qualification with the primary key. Does not add the qualification to the database.
	 *
	 * @param qualificationId the primary key for the new qualification
	 * @return the new qualification
	 */
	public static com.placecube.nhs.userprofile.model.Qualification
		createQualification(long qualificationId) {

		return getService().createQualification(qualificationId);
	}

	public static com.placecube.nhs.userprofile.model.Qualification
		createQualification(
			com.liferay.portal.kernel.model.User user, String place,
			String qualification, java.util.Date fromDate,
			java.util.Date toDate) {

		return getService().createQualification(
			user, place, qualification, fromDate, toDate);
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

	/**
	 * Deletes the qualification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param qualificationId the primary key of the qualification
	 * @return the qualification that was removed
	 * @throws PortalException if a qualification with the primary key could not be found
	 */
	public static com.placecube.nhs.userprofile.model.Qualification
			deleteQualification(long qualificationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteQualification(qualificationId);
	}

	/**
	 * Deletes the qualification from the database. Also notifies the appropriate model listeners.
	 *
	 * @param qualification the qualification
	 * @return the qualification that was removed
	 */
	public static com.placecube.nhs.userprofile.model.Qualification
		deleteQualification(
			com.placecube.nhs.userprofile.model.Qualification qualification) {

		return getService().deleteQualification(qualification);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.placecube.nhs.userprofile.model.impl.QualificationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.placecube.nhs.userprofile.model.impl.QualificationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.placecube.nhs.userprofile.model.Qualification
		fetchQualification(long qualificationId) {

		return getService().fetchQualification(qualificationId);
	}

	/**
	 * Returns the qualification with the matching UUID and company.
	 *
	 * @param uuid the qualification's UUID
	 * @param companyId the primary key of the company
	 * @return the matching qualification, or <code>null</code> if a matching qualification could not be found
	 */
	public static com.placecube.nhs.userprofile.model.Qualification
		fetchQualificationByUuidAndCompanyId(String uuid, long companyId) {

		return getService().fetchQualificationByUuidAndCompanyId(
			uuid, companyId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	 * Returns the qualification with the primary key.
	 *
	 * @param qualificationId the primary key of the qualification
	 * @return the qualification
	 * @throws PortalException if a qualification with the primary key could not be found
	 */
	public static com.placecube.nhs.userprofile.model.Qualification
			getQualification(long qualificationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getQualification(qualificationId);
	}

	/**
	 * Returns the qualification with the matching UUID and company.
	 *
	 * @param uuid the qualification's UUID
	 * @param companyId the primary key of the company
	 * @return the matching qualification
	 * @throws PortalException if a matching qualification could not be found
	 */
	public static com.placecube.nhs.userprofile.model.Qualification
			getQualificationByUuidAndCompanyId(String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getQualificationByUuidAndCompanyId(uuid, companyId);
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
	public static java.util.List
		<com.placecube.nhs.userprofile.model.Qualification> getQualifications(
			int start, int end) {

		return getService().getQualifications(start, end);
	}

	public static java.util.List
		<com.placecube.nhs.userprofile.model.Qualification> getQualifications(
			long userId) {

		return getService().getQualifications(userId);
	}

	/**
	 * Returns the number of qualifications.
	 *
	 * @return the number of qualifications
	 */
	public static int getQualificationsCount() {
		return getService().getQualificationsCount();
	}

	/**
	 * Updates the qualification in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param qualification the qualification
	 * @return the qualification that was updated
	 */
	public static com.placecube.nhs.userprofile.model.Qualification
		updateQualification(
			com.placecube.nhs.userprofile.model.Qualification qualification) {

		return getService().updateQualification(qualification);
	}

	public static QualificationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<QualificationLocalService, QualificationLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			QualificationLocalService.class);

		ServiceTracker<QualificationLocalService, QualificationLocalService>
			serviceTracker =
				new ServiceTracker
					<QualificationLocalService, QualificationLocalService>(
						bundle.getBundleContext(),
						QualificationLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}