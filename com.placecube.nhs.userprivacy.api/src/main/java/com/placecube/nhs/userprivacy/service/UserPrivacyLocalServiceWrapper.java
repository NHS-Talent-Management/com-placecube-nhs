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

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link UserPrivacyLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserPrivacyLocalService
 * @generated
 */
@ProviderType
public class UserPrivacyLocalServiceWrapper
	implements UserPrivacyLocalService,
			   ServiceWrapper<UserPrivacyLocalService> {

	public UserPrivacyLocalServiceWrapper(
		UserPrivacyLocalService userPrivacyLocalService) {

		_userPrivacyLocalService = userPrivacyLocalService;
	}

	/**
	 * Adds the user privacy to the database. Also notifies the appropriate model listeners.
	 *
	 * @param userPrivacy the user privacy
	 * @return the user privacy that was added
	 */
	@Override
	public com.placecube.nhs.userprivacy.model.UserPrivacy addUserPrivacy(
		com.placecube.nhs.userprivacy.model.UserPrivacy userPrivacy) {

		return _userPrivacyLocalService.addUserPrivacy(userPrivacy);
	}

	/**
	 * Creates a new user privacy with the primary key. Does not add the user privacy to the database.
	 *
	 * @param userPrivacyId the primary key for the new user privacy
	 * @return the new user privacy
	 */
	@Override
	public com.placecube.nhs.userprivacy.model.UserPrivacy createUserPrivacy(
		long userPrivacyId) {

		return _userPrivacyLocalService.createUserPrivacy(userPrivacyId);
	}

	/**
	 * Removes all the privacy settings for the company for the given fieldId
	 *
	 * @param companyId the comapnyId
	 * @param fieldId the fieldId
	 */
	@Override
	public void deleteByFieldId(long companyId, String fieldId) {
		_userPrivacyLocalService.deleteByFieldId(companyId, fieldId);
	}

	/**
	 * Removes all the privacy settings for the user
	 *
	 * @param userId the userId to remove settings from
	 */
	@Override
	public void deleteByUserId(long userId) {
		_userPrivacyLocalService.deleteByUserId(userId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userPrivacyLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the user privacy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userPrivacyId the primary key of the user privacy
	 * @return the user privacy that was removed
	 * @throws PortalException if a user privacy with the primary key could not be found
	 */
	@Override
	public com.placecube.nhs.userprivacy.model.UserPrivacy deleteUserPrivacy(
			long userPrivacyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userPrivacyLocalService.deleteUserPrivacy(userPrivacyId);
	}

	/**
	 * Deletes the user privacy from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userPrivacy the user privacy
	 * @return the user privacy that was removed
	 */
	@Override
	public com.placecube.nhs.userprivacy.model.UserPrivacy deleteUserPrivacy(
		com.placecube.nhs.userprivacy.model.UserPrivacy userPrivacy) {

		return _userPrivacyLocalService.deleteUserPrivacy(userPrivacy);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userPrivacyLocalService.dynamicQuery();
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

		return _userPrivacyLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _userPrivacyLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _userPrivacyLocalService.dynamicQuery(
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

		return _userPrivacyLocalService.dynamicQueryCount(dynamicQuery);
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

		return _userPrivacyLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.placecube.nhs.userprivacy.model.UserPrivacy fetchUserPrivacy(
		long userPrivacyId) {

		return _userPrivacyLocalService.fetchUserPrivacy(userPrivacyId);
	}

	/**
	 * Returns the user privacy with the matching UUID and company.
	 *
	 * @param uuid the user privacy's UUID
	 * @param companyId the primary key of the company
	 * @return the matching user privacy, or <code>null</code> if a matching user privacy could not be found
	 */
	@Override
	public com.placecube.nhs.userprivacy.model.UserPrivacy
		fetchUserPrivacyByUuidAndCompanyId(String uuid, long companyId) {

		return _userPrivacyLocalService.fetchUserPrivacyByUuidAndCompanyId(
			uuid, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _userPrivacyLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the UserPrivacy settings for the specified user
	 *
	 * @param userId the userId to retrieve settings for
	 * @return list of privacy settings for the user
	 */
	@Override
	public java.util.List<com.placecube.nhs.userprivacy.model.UserPrivacy>
		getByUserId(long userId) {

		return _userPrivacyLocalService.getByUserId(userId);
	}

	/**
	 * Returns a set of distinct fieldIds that are configured in the company
	 * with privacy values
	 *
	 * @param companyId the companyId
	 * @return set of unique fieldIds
	 */
	@Override
	public java.util.Set<String> getConfiguredPrivacyFieldIds(long companyId) {
		return _userPrivacyLocalService.getConfiguredPrivacyFieldIds(companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _userPrivacyLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _userPrivacyLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userPrivacyLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userPrivacyLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.placecube.nhs.userprivacy.model.UserPrivacy>
		getUserPrivacies(int start, int end) {

		return _userPrivacyLocalService.getUserPrivacies(start, end);
	}

	/**
	 * Returns the number of user privacies.
	 *
	 * @return the number of user privacies
	 */
	@Override
	public int getUserPrivaciesCount() {
		return _userPrivacyLocalService.getUserPrivaciesCount();
	}

	/**
	 * Returns the user privacy with the primary key.
	 *
	 * @param userPrivacyId the primary key of the user privacy
	 * @return the user privacy
	 * @throws PortalException if a user privacy with the primary key could not be found
	 */
	@Override
	public com.placecube.nhs.userprivacy.model.UserPrivacy getUserPrivacy(
			long userPrivacyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userPrivacyLocalService.getUserPrivacy(userPrivacyId);
	}

	/**
	 * Returns the user privacy with the matching UUID and company.
	 *
	 * @param uuid the user privacy's UUID
	 * @param companyId the primary key of the company
	 * @return the matching user privacy
	 * @throws PortalException if a matching user privacy could not be found
	 */
	@Override
	public com.placecube.nhs.userprivacy.model.UserPrivacy
			getUserPrivacyByUuidAndCompanyId(String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userPrivacyLocalService.getUserPrivacyByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a Long array of privacy roleIds
	 *
	 * @param userId the userId
	 * @param userPrivacyFieldId the userPrivacyFieldId
	 */
	@Override
	public long[] getUserPrivacyRoleIds(
		long userId, String userPrivacyFieldId) {

		return _userPrivacyLocalService.getUserPrivacyRoleIds(
			userId, userPrivacyFieldId);
	}

	/**
	 * Update UserPrivacy or create if not exist
	 *
	 * @param userId the userId
	 * @param userPrivacyFieldId the userPrivacyFieldId
	 * @param companyId the companyId
	 * @param roleIds the roleIds
	 * @return UserPrivacy model updated or created
	 */
	@Override
	public com.placecube.nhs.userprivacy.model.UserPrivacy updateUserPrivacy(
		long userId, String userPrivacyFieldId, long companyId,
		java.util.List<Long> roleIds) {

		return _userPrivacyLocalService.updateUserPrivacy(
			userId, userPrivacyFieldId, companyId, roleIds);
	}

	/**
	 * Updates the user privacy in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param userPrivacy the user privacy
	 * @return the user privacy that was updated
	 */
	@Override
	public com.placecube.nhs.userprivacy.model.UserPrivacy updateUserPrivacy(
		com.placecube.nhs.userprivacy.model.UserPrivacy userPrivacy) {

		return _userPrivacyLocalService.updateUserPrivacy(userPrivacy);
	}

	@Override
	public UserPrivacyLocalService getWrappedService() {
		return _userPrivacyLocalService;
	}

	@Override
	public void setWrappedService(
		UserPrivacyLocalService userPrivacyLocalService) {

		_userPrivacyLocalService = userPrivacyLocalService;
	}

	private UserPrivacyLocalService _userPrivacyLocalService;

}