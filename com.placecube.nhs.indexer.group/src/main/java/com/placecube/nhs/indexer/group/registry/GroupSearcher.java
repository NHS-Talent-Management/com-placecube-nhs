package com.placecube.nhs.indexer.group.registry;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.search.BaseSearcher;
import com.liferay.portal.kernel.search.Field;

@Component(immediate = true, property = "model.class.name=com.liferay.portal.kernel.model.Group", service = BaseSearcher.class)
public class GroupSearcher extends BaseSearcher {

	private static final String CLASS_NAME = Group.class.getName();

	public GroupSearcher() {
		setDefaultSelectedFieldNames(Field.ASSET_TAG_NAMES, Field.COMPANY_ID, Field.CONTENT, Field.GROUP_ID, Field.ASSET_CATEGORY_IDS, Field.TITLE, Field.UID);
		setFilterSearch(true);
		setPermissionAware(true);
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

}