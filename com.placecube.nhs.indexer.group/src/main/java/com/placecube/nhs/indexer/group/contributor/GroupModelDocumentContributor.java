package com.placecube.nhs.indexer.group.contributor;

import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetCategoryLocalService;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.placecube.nhs.indexer.group.constants.GroupIndexerFields;

@Component(immediate = true, property = "indexer.class.name=com.liferay.portal.kernel.model.Group", service = ModelDocumentContributor.class)
public class GroupModelDocumentContributor implements ModelDocumentContributor<Group> {

	private static final Log LOG = LogFactoryUtil.getLog(GroupModelDocumentContributor.class);

	@Reference
	private AssetCategoryLocalService assetCategoryLocalService;

	@Reference
	private AssetEntryLocalService assetEntryLocalService;

	@Override
	public void contribute(Document document, Group group) {
		boolean isValidSite = isValidSite(group);

		document.addKeyword(Field.HIDDEN, !isValidSite);

		if (isValidSite) {
			document.addKeyword(Field.TYPE, group.getClassName());
			document.addKeyword(Field.UID, group.getUuid());
			document.addKeyword(Field.COMPANY_ID, group.getCompanyId());
			document.addKeyword(Field.GROUP_ID, group.getGroupId());
			document.addKeyword(Field.STATUS, group.isActive() ? WorkflowConstants.STATUS_APPROVED : WorkflowConstants.STATUS_INACTIVE);
			document.addKeyword(GroupIndexerFields.GROUP_TYPE, group.getType());
			document.addKeyword(Field.URL, group.getFriendlyURL());

			addCategorizationFields(document, group);

			String defaultLanguageId = group.getDefaultLanguageId();
			String name = HtmlUtil.extractText(group.getName(defaultLanguageId));
			String description = HtmlUtil.extractText(group.getDescription(defaultLanguageId));

			document.addText(Field.NAME, name);
			document.addText(Field.TITLE, name);
			document.addKeyword(Field.DESCRIPTION, description);
			document.addText(Field.CONTENT, description);

			String[] availableLanguageIds = group.getAvailableLanguageIds();

			for (String languageId : availableLanguageIds) {
				document.addText(LocalizationUtil.getLocalizedName(Field.CONTENT, languageId), description);
				document.addText(LocalizationUtil.getLocalizedName(Field.TITLE, languageId), name);
			}
		}
		LOG.info("Indexing group: " + document);
	}

	private void addCategorizationFields(Document document, Group group) {
		try {
			AssetEntry assetEntry = assetEntryLocalService.getEntry(Group.class.getName(), group.getGroupId());
			document.addKeyword(Field.ASSET_CATEGORY_IDS, assetEntry.getCategoryIds());
			List<String> categoryNames = assetEntry.getCategories().stream().map(AssetCategory::getName).collect(Collectors.toList());
			document.addKeyword(Field.ASSET_CATEGORY_TITLES, categoryNames.toArray(new String[categoryNames.size()]));
			document.addKeyword(Field.ASSET_TAG_NAMES, assetEntry.getTagNames());
		} catch (PortalException e) {
			LOG.debug(e);
			LOG.error("Unable to retrieve categorization fields " + e.getMessage());
		}
	}

	private boolean isValidSite(Group group) {
		return group.isSite() && group.isActive() && !group.isGuest();
	}

}
