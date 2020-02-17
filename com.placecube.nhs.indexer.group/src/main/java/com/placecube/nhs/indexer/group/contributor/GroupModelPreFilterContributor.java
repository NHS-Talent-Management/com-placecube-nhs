package com.placecube.nhs.indexer.group.contributor;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.search.spi.model.query.contributor.ModelPreFilterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchSettings;

@Component(immediate = true, property = "indexer.class.name=com.liferay.portal.kernel.model.Group", service = ModelPreFilterContributor.class)
public class GroupModelPreFilterContributor implements ModelPreFilterContributor {

	@Override
	public void contribute(BooleanFilter booleanFilter, ModelSearchSettings modelSearchSettings, SearchContext searchContext) {
		booleanFilter.addRequiredTerm(Field.HIDDEN, false);
		booleanFilter.addRequiredTerm(Field.TYPE, Group.class.getName());
	}

}