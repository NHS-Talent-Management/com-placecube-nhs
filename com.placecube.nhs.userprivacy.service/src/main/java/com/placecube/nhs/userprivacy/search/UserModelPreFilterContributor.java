package com.placecube.nhs.userprivacy.search;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.search.spi.model.query.contributor.ModelPreFilterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchSettings;
import com.placecube.nhs.userprivacy.service.UserPrivacyLocalService;

@Component(immediate = true, property = "indexer.class.name=com.liferay.portal.kernel.model.User", service = ModelPreFilterContributor.class)
public class UserModelPreFilterContributor implements ModelPreFilterContributor {

	@Reference
	private UserPrivacyLocalService userPrivacyLocalService;

	@Reference
	private UserPrivacySearchUtil userPrivacySearchUtil;

	@Override
	public void contribute(BooleanFilter contextBooleanFilter, ModelSearchSettings modelSearchSettings, SearchContext searchContext) {
		BooleanClause<Query>[] booleanClauses = searchContext.getBooleanClauses();
		if (Validator.isNotNull(booleanClauses)) {

			Set<String> configuredPrivacyFieldIds = userPrivacyLocalService.getConfiguredPrivacyFieldIds(searchContext.getCompanyId());
			String[] currentUserRoleIds = userPrivacySearchUtil.getCurrentUserRoleIds(searchContext);

			for (BooleanClause<Query> booleanClause : booleanClauses) {
				String queryString = userPrivacySearchUtil.getClauseQueryString(booleanClause);

				List<String> privacyFieldsInQuery = configuredPrivacyFieldIds.parallelStream().filter(queryString::contains).collect(Collectors.toList());
				if (!privacyFieldsInQuery.isEmpty()) {
					BooleanFilter booleanFilter = userPrivacySearchUtil.getBooleanFilterForPrivacyFields(currentUserRoleIds, privacyFieldsInQuery);
					contextBooleanFilter.add(booleanFilter, BooleanClauseOccur.MUST);
				}
			}
		}
	}

}