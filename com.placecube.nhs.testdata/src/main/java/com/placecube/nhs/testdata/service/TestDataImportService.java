package com.placecube.nhs.testdata.service;

import java.util.List;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetCategoryConstants;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryLocalService;
import com.liferay.asset.kernel.service.AssetVocabularyLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactory;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Validator;

@Component(immediate = true, service = TestDataImportService.class)
public class TestDataImportService {

	private static final Log LOG = LogFactoryUtil.getLog(TestDataImportService.class);

	@Reference
	private AssetCategoryLocalService assetCategoryLocalService;

	@Reference
	private AssetVocabularyLocalService assetVocabularyLocalService;

	@Reference
	private GroupLocalService groupLocalService;

	@Reference
	private ImportUtil importUtil;

	@Reference
	private PermissionCheckerFactory permissionCheckerFactory;

	@Reference
	private RoleLocalService roleLocalService;

	@Reference
	private UserLocalService userLocalService;

	private Bundle bundle;

	@Activate
	protected void activate(BundleContext bundleContext) {
		bundle = bundleContext.getBundle();
	}

	public ServiceContext getServiceContext(Group group) throws PortalException {
		try {
			ServiceContext serviceContext = new ServiceContext();

			serviceContext.setAddGroupPermissions(true);
			serviceContext.setAddGuestPermissions(true);
			serviceContext.setCompanyId(group.getCompanyId());
			serviceContext.setLanguageId(group.getDefaultLanguageId());
			serviceContext.setScopeGroupId(group.getGroupId());

			long userId = getUserId(group);
			serviceContext.setUserId(userId);

			return serviceContext;
		} catch (Exception e) {
			throw new PortalException("Exception creating ServiceContext", e);
		}
	}

	public AssetVocabulary importAssetVocabulary(ServiceContext serviceContext) throws Exception {
		JSONObject jsonObject = importUtil.getJSONObject("com/placecube/nhs/testdata/dependencies/vocabulary/community-of-interest.json");

		String vocabularyName = jsonObject.getString("vocabularyName");
		AssetVocabulary assetVocabulary = assetVocabularyLocalService.fetchGroupVocabulary(serviceContext.getScopeGroupId(), vocabularyName);
		if (Validator.isNull(assetVocabulary)) {
			assetVocabulary = assetVocabularyLocalService.addVocabulary(serviceContext.getUserId(), serviceContext.getScopeGroupId(), vocabularyName, serviceContext);

		}

		JSONArray rootCategories = jsonObject.getJSONArray("categories");

		for (int i = 0; i < rootCategories.length(); i++) {
			importUtil.importCategory(assetVocabulary.getVocabularyId(), rootCategories.getJSONObject(i), AssetCategoryConstants.DEFAULT_PARENT_CATEGORY_ID, serviceContext);
		}
		return assetVocabulary;

	}

	public void importGroups(ServiceContext serviceContext, AssetVocabulary assetVocabulary) throws Exception {
		JSONArray groupsToImport = importUtil.getJSONArray("com/placecube/nhs/testdata/dependencies/groups/communities.json", "groups");
		List<AssetCategory> categories = assetVocabulary.getCategories();
		for (int rootGroupIndex = 0; rootGroupIndex < groupsToImport.length(); rootGroupIndex++) {
			JSONObject rootGroupToImport = groupsToImport.getJSONObject(rootGroupIndex);
			importUtil.importGroup(rootGroupToImport, categories, serviceContext);
		}
	}

	private long getUserId(Group group) {
		long userId = group.getCreatorUserId();
		try {
			Role adminRole = roleLocalService.getRole(group.getCompanyId(), RoleConstants.ADMINISTRATOR);
			List<User> adminUsers = userLocalService.getRoleUsers(adminRole.getRoleId());
			if (!adminUsers.isEmpty()) {
				User user = adminUsers.get(0);
				userId = user.getUserId();
				PermissionChecker permissionChecker = permissionCheckerFactory.create(user);
				PermissionThreadLocal.setPermissionChecker(permissionChecker);
			}
		} catch (Exception e) {
			LOG.error(e);
		}
		return userId;
	}
}
