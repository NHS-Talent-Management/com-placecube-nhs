package com.placecube.nhs.assetpublisher.provider;

import java.util.List;
import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.info.list.provider.InfoListProvider;
import com.liferay.info.list.provider.InfoListProviderContext;
import com.liferay.info.pagination.Pagination;
import com.liferay.info.sort.Sort;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.util.ResourceBundleLoader;
import com.placecube.nhs.assetpublisher.provider.service.BlogInfoListProviderService;

@Component(immediate = true, service = InfoListProvider.class)
public class CompanyBlogsInfoListProvider implements InfoListProvider<AssetEntry> {

	@Reference
	private BlogInfoListProviderService blogInfoListProviderService;

	@Reference(target = "(bundle.symbolic.name=com.placecube.nhs.assetpublisher.provider)", unbind = "-")
	private ResourceBundleLoader resourceBundleLoader;

	@Override
	public List<AssetEntry> getInfoList(InfoListProviderContext infoListProviderContext) {
		long companyId = infoListProviderContext.getCompany().getCompanyId();
		List<Long> assetEntryIds = blogInfoListProviderService.getAssetEntryIds(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		return blogInfoListProviderService.getAssetEntriesByClassPKs(companyId, assetEntryIds);
	}

	@Override
	public List<AssetEntry> getInfoList(InfoListProviderContext infoListProviderContext, Pagination pagination, Sort sort) {
		long companyId = infoListProviderContext.getCompany().getCompanyId();
		List<Long> assetEntryIds = blogInfoListProviderService.getAssetEntryIds(companyId, pagination.getStart(), pagination.getEnd());
		return blogInfoListProviderService.getAssetEntriesByClassPKs(companyId, assetEntryIds);
	}

	@Override
	public int getInfoListCount(InfoListProviderContext infoListProviderContext) {
		long companyId = infoListProviderContext.getCompany().getCompanyId();
		return blogInfoListProviderService.getAssetEntryIds(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS).size();
	}

	@Override
	public String getLabel(Locale locale) {
		return resourceBundleLoader.loadResourceBundle(locale).getString("company-blog-info-list-provider");
	}

}
