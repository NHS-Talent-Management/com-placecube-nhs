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

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link TalentSearchLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TalentSearchLocalService
 * @generated
 */
@ProviderType
public class TalentSearchLocalServiceWrapper
	implements TalentSearchLocalService,
			   ServiceWrapper<TalentSearchLocalService> {

	public TalentSearchLocalServiceWrapper(
		TalentSearchLocalService talentSearchLocalService) {

		_talentSearchLocalService = talentSearchLocalService;
	}

	/**
	 * Adds the talent search to the database. Also notifies the appropriate model listeners.
	 *
	 * @param talentSearch the talent search
	 * @return the talent search that was added
	 */
	@Override
	public com.placecube.nhs.talentsearch.model.TalentSearch addTalentSearch(
		com.placecube.nhs.talentsearch.model.TalentSearch talentSearch) {

		return _talentSearchLocalService.addTalentSearch(talentSearch);
	}

	/**
	 * Creates a new talent search with the primary key. Does not add the talent search to the database.
	 *
	 * @param talentSearchId the primary key for the new talent search
	 * @return the new talent search
	 */
	@Override
	public com.placecube.nhs.talentsearch.model.TalentSearch createTalentSearch(
		long talentSearchId) {

		return _talentSearchLocalService.createTalentSearch(talentSearchId);
	}

	@Override
	public com.placecube.nhs.talentsearch.model.TalentSearch createTalentSearch(
		com.liferay.portal.kernel.model.User user, String name, long typeId,
		long categoryId, String queryFilter) {

		return _talentSearchLocalService.createTalentSearch(
			user, name, typeId, categoryId, queryFilter);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _talentSearchLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the talent search with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param talentSearchId the primary key of the talent search
	 * @return the talent search that was removed
	 * @throws PortalException if a talent search with the primary key could not be found
	 */
	@Override
	public com.placecube.nhs.talentsearch.model.TalentSearch deleteTalentSearch(
			long talentSearchId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _talentSearchLocalService.deleteTalentSearch(talentSearchId);
	}

	/**
	 * Deletes the talent search from the database. Also notifies the appropriate model listeners.
	 *
	 * @param talentSearch the talent search
	 * @return the talent search that was removed
	 */
	@Override
	public com.placecube.nhs.talentsearch.model.TalentSearch deleteTalentSearch(
		com.placecube.nhs.talentsearch.model.TalentSearch talentSearch) {

		return _talentSearchLocalService.deleteTalentSearch(talentSearch);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _talentSearchLocalService.dynamicQuery();
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

		return _talentSearchLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _talentSearchLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _talentSearchLocalService.dynamicQuery(
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

		return _talentSearchLocalService.dynamicQueryCount(dynamicQuery);
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

		return _talentSearchLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.placecube.nhs.talentsearch.model.TalentSearch fetchTalentSearch(
		long talentSearchId) {

		return _talentSearchLocalService.fetchTalentSearch(talentSearchId);
	}

	/**
	 * Returns the talent search with the matching UUID and company.
	 *
	 * @param uuid the talent search's UUID
	 * @param companyId the primary key of the company
	 * @return the matching talent search, or <code>null</code> if a matching talent search could not be found
	 */
	@Override
	public com.placecube.nhs.talentsearch.model.TalentSearch
		fetchTalentSearchByUuidAndCompanyId(String uuid, long companyId) {

		return _talentSearchLocalService.fetchTalentSearchByUuidAndCompanyId(
			uuid, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _talentSearchLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _talentSearchLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _talentSearchLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _talentSearchLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _talentSearchLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the talent search with the primary key.
	 *
	 * @param talentSearchId the primary key of the talent search
	 * @return the talent search
	 * @throws PortalException if a talent search with the primary key could not be found
	 */
	@Override
	public com.placecube.nhs.talentsearch.model.TalentSearch getTalentSearch(
			long talentSearchId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _talentSearchLocalService.getTalentSearch(talentSearchId);
	}

	/**
	 * Returns the talent search with the matching UUID and company.
	 *
	 * @param uuid the talent search's UUID
	 * @param companyId the primary key of the company
	 * @return the matching talent search
	 * @throws PortalException if a matching talent search could not be found
	 */
	@Override
	public com.placecube.nhs.talentsearch.model.TalentSearch
			getTalentSearchByUuidAndCompanyId(String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _talentSearchLocalService.getTalentSearchByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<com.placecube.nhs.talentsearch.model.TalentSearch>
		getTalentSearchs(int start, int end) {

		return _talentSearchLocalService.getTalentSearchs(start, end);
	}

	/**
	 * Returns the number of talent searchs.
	 *
	 * @return the number of talent searchs
	 */
	@Override
	public int getTalentSearchsCount() {
		return _talentSearchLocalService.getTalentSearchsCount();
	}

	/**
	 * Updates the talent search in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param talentSearch the talent search
	 * @return the talent search that was updated
	 */
	@Override
	public com.placecube.nhs.talentsearch.model.TalentSearch updateTalentSearch(
		com.placecube.nhs.talentsearch.model.TalentSearch talentSearch) {

		return _talentSearchLocalService.updateTalentSearch(talentSearch);
	}

	@Override
	public TalentSearchLocalService getWrappedService() {
		return _talentSearchLocalService;
	}

	@Override
	public void setWrappedService(
		TalentSearchLocalService talentSearchLocalService) {

		_talentSearchLocalService = talentSearchLocalService;
	}

	private TalentSearchLocalService _talentSearchLocalService;

}