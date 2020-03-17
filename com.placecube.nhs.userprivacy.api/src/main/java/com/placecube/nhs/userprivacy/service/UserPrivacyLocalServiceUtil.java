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

package com.placecube.nhs.userprivacy.service;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for UserPrivacy. This utility wraps
 * <code>com.placecube.nhs.userprivacy.service.impl.UserPrivacyLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see UserPrivacyLocalService
 * @generated
 */
@ProviderType
public class UserPrivacyLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.placecube.nhs.userprivacy.service.impl.UserPrivacyLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the user privacy to the database. Also notifies the appropriate model listeners.
	 *
	 * @param userPrivacy the user privacy
	 * @return the user privacy that was added
	 */
	public static com.placecube.nhs.userprivacy.model.UserPrivacy
		addUserPrivacy(
			com.placecube.nhs.userprivacy.model.UserPrivacy userPrivacy) {

		return getService().addUserPrivacy(userPrivacy);
	}

	/**
	 * Creates a new user privacy with the primary key. Does not add the user privacy to the database.
	 *
	 * @param userPrivacyId the primary key for the new user privacy
	 * @return the new user privacy
	 */
	public static com.placecube.nhs.userprivacy.model.UserPrivacy
		createUserPrivacy(long userPrivacyId) {

		return getService().createUserPrivacy(userPrivacyId);
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
	 * Deletes the user privacy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userPrivacyId the primary key of the user privacy
	 * @return the user privacy that was removed
	 * @throws PortalException if a user privacy with the primary key could not be found
	 */
	public static com.placecube.nhs.userprivacy.model.UserPrivacy
			deleteUserPrivacy(long userPrivacyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteUserPrivacy(userPrivacyId);
	}

	/**
	 * Deletes the user privacy from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userPrivacy the user privacy
	 * @return the user privacy that was removed
	 */
	public static com.placecube.nhs.userprivacy.model.UserPrivacy
		deleteUserPrivacy(
			com.placecube.nhs.userprivacy.model.UserPrivacy userPrivacy) {

		return getService().deleteUserPrivacy(userPrivacy);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.placecube.nhs.userprivacy.model.impl.UserPrivacyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.placecube.nhs.userprivacy.model.impl.UserPrivacyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.placecube.nhs.userprivacy.model.UserPrivacy
		fetchUserPrivacy(long userPrivacyId) {

		return getService().fetchUserPrivacy(userPrivacyId);
	}

	/**
	 * Returns the user privacy with the matching UUID and company.
	 *
	 * @param uuid the user privacy's UUID
	 * @param companyId the primary key of the company
	 * @return the matching user privacy, or <code>null</code> if a matching user privacy could not be found
	 */
	public static com.placecube.nhs.userprivacy.model.UserPrivacy
		fetchUserPrivacyByUuidAndCompanyId(String uuid, long companyId) {

		return getService().fetchUserPrivacyByUuidAndCompanyId(uuid, companyId);
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
	 * Returns a range of all the user privacies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.placecube.nhs.userprivacy.model.impl.UserPrivacyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user privacies
	 * @param end the upper bound of the range of user privacies (not inclusive)
	 * @return the range of user privacies
	 */
	public static java.util.List
		<com.placecube.nhs.userprivacy.model.UserPrivacy> getUserPrivacies(
			int start, int end) {

		return getService().getUserPrivacies(start, end);
	}

	/**
	 * Returns the number of user privacies.
	 *
	 * @return the number of user privacies
	 */
	public static int getUserPrivaciesCount() {
		return getService().getUserPrivaciesCount();
	}

	/**
	 * Returns the user privacy with the primary key.
	 *
	 * @param userPrivacyId the primary key of the user privacy
	 * @return the user privacy
	 * @throws PortalException if a user privacy with the primary key could not be found
	 */
	public static com.placecube.nhs.userprivacy.model.UserPrivacy
			getUserPrivacy(long userPrivacyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getUserPrivacy(userPrivacyId);
	}

	/**
	 * Returns the user privacy with the matching UUID and company.
	 *
	 * @param uuid the user privacy's UUID
	 * @param companyId the primary key of the company
	 * @return the matching user privacy
	 * @throws PortalException if a matching user privacy could not be found
	 */
	public static com.placecube.nhs.userprivacy.model.UserPrivacy
			getUserPrivacyByUuidAndCompanyId(String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getUserPrivacyByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Updates the user privacy in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param userPrivacy the user privacy
	 * @return the user privacy that was updated
	 */
	public static com.placecube.nhs.userprivacy.model.UserPrivacy
		updateUserPrivacy(
			com.placecube.nhs.userprivacy.model.UserPrivacy userPrivacy) {

		return getService().updateUserPrivacy(userPrivacy);
	}

	public static UserPrivacyLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<UserPrivacyLocalService, UserPrivacyLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(UserPrivacyLocalService.class);

		ServiceTracker<UserPrivacyLocalService, UserPrivacyLocalService>
			serviceTracker =
				new ServiceTracker
					<UserPrivacyLocalService, UserPrivacyLocalService>(
						bundle.getBundleContext(),
						UserPrivacyLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}