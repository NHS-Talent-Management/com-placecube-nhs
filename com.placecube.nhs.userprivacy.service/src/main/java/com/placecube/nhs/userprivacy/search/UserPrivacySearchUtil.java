package com.placecube.nhs.userprivacy.search;

import java.util.Arrays;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.TermsFilter;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.placecube.nhs.userprivacy.constants.UserPrivacyConstants;

@Component(immediate = true, service = UserPrivacySearchUtil.class)
public class UserPrivacySearchUtil {

	private static final Log LOG = LogFactoryUtil.getLog(UserPrivacySearchUtil.class);

	@Reference
	private UserLocalService userLocalService;

	public String[] getCurrentUserRoleIds(SearchContext searchContext) {
		try {
			User user = userLocalService.getUser(searchContext.getUserId());
			long[] roleIds = user.getRoleIds();
			return Arrays.stream(ArrayUtil.toArray(roleIds)).map(String::valueOf).toArray(String[]::new);
		} catch (Exception e) {
			LOG.debug(e);
			LOG.warn("Configuring restrictive privacy settings as unable to retrieve user " + e.getMessage());
			return new String[] { "-1" };
		}
	}

	public String getClauseQueryString(BooleanClause<Query> booleanClause) {
		return booleanClause.getClause().toString();
	}

	public BooleanFilter getBooleanFilterForPrivacyFields(String[] currentUserRoleIds, List<String> privacyFields) {
		BooleanFilter booleanFilter = new BooleanFilter();
		for (String privacyField : privacyFields) {
			LOG.debug("Adding privacy restrictions for field: " + privacyField);
			TermsFilter privacyTermFilters = new TermsFilter(UserPrivacyConstants.getPrivacyFieldName(privacyField));
			privacyTermFilters.addValues(currentUserRoleIds);
			booleanFilter.add(privacyTermFilters);
		}
		return booleanFilter;
	}

}
