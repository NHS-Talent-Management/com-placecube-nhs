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
 * Provides the local service utility for ProfessionalBody. This utility wraps
 * <code>com.placecube.nhs.userprofile.service.impl.ProfessionalBodyLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProfessionalBodyLocalService
 * @generated
 */
@ProviderType
public class ProfessionalBodyLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.placecube.nhs.userprofile.service.impl.ProfessionalBodyLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the professional body to the database. Also notifies the appropriate model listeners.
	 *
	 * @param professionalBody the professional body
	 * @return the professional body that was added
	 */
	public static com.placecube.nhs.userprofile.model.ProfessionalBody
		addProfessionalBody(
			com.placecube.nhs.userprofile.model.ProfessionalBody
				professionalBody) {

		return getService().addProfessionalBody(professionalBody);
	}

	/**
	 * Creates a new professional body with the primary key. Does not add the professional body to the database.
	 *
	 * @param professionalBodyId the primary key for the new professional body
	 * @return the new professional body
	 */
	public static com.placecube.nhs.userprofile.model.ProfessionalBody
		createProfessionalBody(long professionalBodyId) {

		return getService().createProfessionalBody(professionalBodyId);
	}

	public static com.placecube.nhs.userprofile.model.ProfessionalBody
		createProfessionalBody(
			com.liferay.portal.kernel.model.User user, String title,
			String location, java.util.Date expiryDate) {

		return getService().createProfessionalBody(
			user, title, location, expiryDate);
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
	 * Deletes the professional body with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param professionalBodyId the primary key of the professional body
	 * @return the professional body that was removed
	 * @throws PortalException if a professional body with the primary key could not be found
	 */
	public static com.placecube.nhs.userprofile.model.ProfessionalBody
			deleteProfessionalBody(long professionalBodyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteProfessionalBody(professionalBodyId);
	}

	/**
	 * Deletes the professional body from the database. Also notifies the appropriate model listeners.
	 *
	 * @param professionalBody the professional body
	 * @return the professional body that was removed
	 */
	public static com.placecube.nhs.userprofile.model.ProfessionalBody
		deleteProfessionalBody(
			com.placecube.nhs.userprofile.model.ProfessionalBody
				professionalBody) {

		return getService().deleteProfessionalBody(professionalBody);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.placecube.nhs.userprofile.model.impl.ProfessionalBodyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.placecube.nhs.userprofile.model.impl.ProfessionalBodyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.placecube.nhs.userprofile.model.ProfessionalBody
		fetchProfessionalBody(long professionalBodyId) {

		return getService().fetchProfessionalBody(professionalBodyId);
	}

	/**
	 * Returns the professional body with the matching UUID and company.
	 *
	 * @param uuid the professional body's UUID
	 * @param companyId the primary key of the company
	 * @return the matching professional body, or <code>null</code> if a matching professional body could not be found
	 */
	public static com.placecube.nhs.userprofile.model.ProfessionalBody
		fetchProfessionalBodyByUuidAndCompanyId(String uuid, long companyId) {

		return getService().fetchProfessionalBodyByUuidAndCompanyId(
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
	 * Returns a range of all the professional bodies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.placecube.nhs.userprofile.model.impl.ProfessionalBodyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of professional bodies
	 * @param end the upper bound of the range of professional bodies (not inclusive)
	 * @return the range of professional bodies
	 */
	public static java.util.List
		<com.placecube.nhs.userprofile.model.ProfessionalBody>
			getProfessionalBodies(int start, int end) {

		return getService().getProfessionalBodies(start, end);
	}

	public static java.util.List
		<com.placecube.nhs.userprofile.model.ProfessionalBody>
			getProfessionalBodies(long userId) {

		return getService().getProfessionalBodies(userId);
	}

	/**
	 * Returns the number of professional bodies.
	 *
	 * @return the number of professional bodies
	 */
	public static int getProfessionalBodiesCount() {
		return getService().getProfessionalBodiesCount();
	}

	/**
	 * Returns the professional body with the primary key.
	 *
	 * @param professionalBodyId the primary key of the professional body
	 * @return the professional body
	 * @throws PortalException if a professional body with the primary key could not be found
	 */
	public static com.placecube.nhs.userprofile.model.ProfessionalBody
			getProfessionalBody(long professionalBodyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getProfessionalBody(professionalBodyId);
	}

	/**
	 * Returns the professional body with the matching UUID and company.
	 *
	 * @param uuid the professional body's UUID
	 * @param companyId the primary key of the company
	 * @return the matching professional body
	 * @throws PortalException if a matching professional body could not be found
	 */
	public static com.placecube.nhs.userprofile.model.ProfessionalBody
			getProfessionalBodyByUuidAndCompanyId(String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getProfessionalBodyByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Updates the professional body in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param professionalBody the professional body
	 * @return the professional body that was updated
	 */
	public static com.placecube.nhs.userprofile.model.ProfessionalBody
		updateProfessionalBody(
			com.placecube.nhs.userprofile.model.ProfessionalBody
				professionalBody) {

		return getService().updateProfessionalBody(professionalBody);
	}

	public static ProfessionalBodyLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ProfessionalBodyLocalService, ProfessionalBodyLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ProfessionalBodyLocalService.class);

		ServiceTracker
			<ProfessionalBodyLocalService, ProfessionalBodyLocalService>
				serviceTracker =
					new ServiceTracker
						<ProfessionalBodyLocalService,
						 ProfessionalBodyLocalService>(
							 bundle.getBundleContext(),
							 ProfessionalBodyLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}