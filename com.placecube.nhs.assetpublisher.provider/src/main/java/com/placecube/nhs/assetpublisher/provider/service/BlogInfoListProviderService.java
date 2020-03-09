package com.placecube.nhs.assetpublisher.provider.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.blogs.model.BlogsEntry;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.Portal;
import com.placecube.nhs.search.utils.SearchService;

@Component(immediate = true, service = BlogInfoListProviderService.class)
public class BlogInfoListProviderService {

	private static final Log LOG = LogFactoryUtil.getLog(BlogInfoListProviderService.class);

	@Reference
	private AssetEntryLocalService assetEntryLocalService;

	@Reference
	private Portal portal;

	@Reference
	private SearchService searchService;

	public List<AssetEntry> getAssetEntriesByClassPKs(long companyId, List<Long> classPKs) {
		if (classPKs.isEmpty()) {
			return Collections.emptyList();
		}

		DynamicQuery dQuery = assetEntryLocalService.dynamicQuery();
		dQuery.add(RestrictionsFactoryUtil.eq("companyId", companyId));
		dQuery.add(RestrictionsFactoryUtil.eq("classNameId", portal.getClassNameId(BlogsEntry.class)));
		dQuery.add(RestrictionsFactoryUtil.in("classPK", classPKs));

		List<AssetEntry> results = ListUtil.copy(assetEntryLocalService.dynamicQuery(dQuery, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null));
		results.sort((o1, o2) -> o2.getPublishDate().compareTo(o1.getPublishDate()));
		return results;
	}

	public List<Long> getAssetEntryIds(long companyId, int start, int end) {
		try {
			String indexerClassName = BlogsEntry.class.getName();
			SearchContext searchContext = searchService.getSearchContext(companyId);
			searchContext.setEntryClassNames(new String[] { indexerClassName });

			configurePagination(start, end, searchContext);
			searchContext.setSorts(new Sort(Field.PUBLISH_DATE, true));

			Document[] searchResults = searchService.getSearchResults(searchContext, indexerClassName);
			return Arrays.asList(searchResults).stream().map(document -> GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK))).collect(Collectors.toList());
		} catch (SearchException e) {
			LOG.debug(e);
			return Collections.emptyList();
		}
	}

	private void configurePagination(int start, int end, SearchContext searchContext) {
		if (start > 0 || end > 0) {
			searchContext.setStart(start);
			searchContext.setEnd(end);
		}
	}

}
