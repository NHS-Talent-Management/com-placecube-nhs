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

package com.placecube.nhs.talentsearch.service;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for TalentSearch. This utility wraps
 * <code>com.placecube.nhs.talentsearch.service.impl.TalentSearchLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TalentSearchLocalService
 * @generated
 */
@ProviderType
public class TalentSearchLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.placecube.nhs.talentsearch.service.impl.TalentSearchLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the talent search to the database. Also notifies the appropriate model listeners.
	 *
	 * @param talentSearch the talent search
	 * @return the talent search that was added
	 */
	public static com.placecube.nhs.talentsearch.model.TalentSearch
		addTalentSearch(
			com.placecube.nhs.talentsearch.model.TalentSearch talentSearch) {

		return getService().addTalentSearch(talentSearch);
	}

	/**
	 * Creates a new talent search with the primary key. Does not add the talent search to the database.
	 *
	 * @param talentSearchId the primary key for the new talent search
	 * @return the new talent search
	 */
	public static com.placecube.nhs.talentsearch.model.TalentSearch
		createTalentSearch(long talentSearchId) {

		return getService().createTalentSearch(talentSearchId);
	}

	public static com.placecube.nhs.talentsearch.model.TalentSearch
		createTalentSearch(
			com.liferay.portal.kernel.model.User user, String name, long typeId,
			long categoryId, String queryFilter) {

		return getService().createTalentSearch(
			user, name, typeId, categoryId, queryFilter);
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
	 * Deletes the talent search with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param talentSearchId the primary key of the talent search
	 * @return the talent search that was removed
	 * @throws PortalException if a talent search with the primary key could not be found
	 */
	public static com.placecube.nhs.talentsearch.model.TalentSearch
			deleteTalentSearch(long talentSearchId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteTalentSearch(talentSearchId);
	}

	/**
	 * Deletes the talent search from the database. Also notifies the appropriate model listeners.
	 *
	 * @param talentSearch the talent search
	 * @return the talent search that was removed
	 */
	public static com.placecube.nhs.talentsearch.model.TalentSearch
		deleteTalentSearch(
			com.placecube.nhs.talentsearch.model.TalentSearch talentSearch) {

		return getService().deleteTalentSearch(talentSearch);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.placecube.nhs.talentsearch.model.impl.TalentSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.placecube.nhs.talentsearch.model.impl.TalentSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.placecube.nhs.talentsearch.model.TalentSearch
		fetchTalentSearch(long talentSearchId) {

		return getService().fetchTalentSearch(talentSearchId);
	}

	/**
	 * Returns the talent search with the matching UUID and company.
	 *
	 * @param uuid the talent search's UUID
	 * @param companyId the primary key of the company
	 * @return the matching talent search, or <code>null</code> if a matching talent search could not be found
	 */
	public static com.placecube.nhs.talentsearch.model.TalentSearch
		fetchTalentSearchByUuidAndCompanyId(String uuid, long companyId) {

		return getService().fetchTalentSearchByUuidAndCompanyId(
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
	 * Returns the talent search with the primary key.
	 *
	 * @param talentSearchId the primary key of the talent search
	 * @return the talent search
	 * @throws PortalException if a talent search with the primary key could not be found
	 */
	public static com.placecube.nhs.talentsearch.model.TalentSearch
			getTalentSearch(long talentSearchId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTalentSearch(talentSearchId);
	}

	/**
	 * Returns the talent search with the matching UUID and company.
	 *
	 * @param uuid the talent search's UUID
	 * @param companyId the primary key of the company
	 * @return the matching talent search
	 * @throws PortalException if a matching talent search could not be found
	 */
	public static com.placecube.nhs.talentsearch.model.TalentSearch
			getTalentSearchByUuidAndCompanyId(String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTalentSearchByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of all the talent searchs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.placecube.nhs.talentsearch.model.impl.TalentSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of talent searchs
	 * @param end the upper bound of the range of talent searchs (not inclusive)
	 * @return the range of talent searchs
	 */
	public static java.util.List
		<com.placecube.nhs.talentsearch.model.TalentSearch> getTalentSearchs(
			int start, int end) {

		return getService().getTalentSearchs(start, end);
	}

	/**
	 * Returns the number of talent searchs.
	 *
	 * @return the number of talent searchs
	 */
	public static int getTalentSearchsCount() {
		return getService().getTalentSearchsCount();
	}

	/**
	 * Updates the talent search in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param talentSearch the talent search
	 * @return the talent search that was updated
	 */
	public static com.placecube.nhs.talentsearch.model.TalentSearch
		updateTalentSearch(
			com.placecube.nhs.talentsearch.model.TalentSearch talentSearch) {

		return getService().updateTalentSearch(talentSearch);
	}

	public static TalentSearchLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TalentSearchLocalService, TalentSearchLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TalentSearchLocalService.class);

		ServiceTracker<TalentSearchLocalService, TalentSearchLocalService>
			serviceTracker =
				new ServiceTracker
					<TalentSearchLocalService, TalentSearchLocalService>(
						bundle.getBundleContext(),
						TalentSearchLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}