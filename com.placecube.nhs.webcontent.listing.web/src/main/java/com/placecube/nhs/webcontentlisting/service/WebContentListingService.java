package com.placecube.nhs.webcontentlisting.service;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.dynamic.data.mapping.service.DDMStructureLocalService;
import com.liferay.journal.model.JournalArticleDisplay;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.placecube.nhs.taglib.az.model.AZEntry;
import com.placecube.nhs.webcontentlisting.portlet.az.configuration.AZWebContentPortletInstanceConfiguration;
import com.placecube.nhs.webcontentlisting.portlet.mostpopular.configuration.MostPopularWebContentPortletInstanceConfiguration;

@Component(immediate = true, service = WebContentListingService.class)
public class WebContentListingService {

	private static final Log LOG = LogFactoryUtil.getLog(WebContentListingService.class);

	@Reference
	private DDMStructureLocalService ddmStructureLocalService;

	@Reference
	private WebContentRetrievalService webContentRetrievalService;

	@Reference
	private GroupLocalService groupLocalService;

	public AZWebContentPortletInstanceConfiguration getAZConfiguration(ThemeDisplay themeDisplay, boolean skipValidation) throws ConfigurationException {
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		AZWebContentPortletInstanceConfiguration configuration = portletDisplay.getPortletInstanceConfiguration(AZWebContentPortletInstanceConfiguration.class);
		if (skipValidation || Validator.isNotNull(configuration.structureKey())) {
			return configuration;
		}
		throw new ConfigurationException("Invalid configuration");
	}

	public MostPopularWebContentPortletInstanceConfiguration getMostPopularConfiguration(ThemeDisplay themeDisplay, boolean skipValidation) throws ConfigurationException {
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		MostPopularWebContentPortletInstanceConfiguration configuration = portletDisplay.getPortletInstanceConfiguration(MostPopularWebContentPortletInstanceConfiguration.class);
		if (skipValidation || Validator.isNotNull(configuration.structureKey()) && Validator.isNotNull(configuration.templateKey()) && configuration.maxItemsToDisplay() > 0) {
			return configuration;
		}
		throw new ConfigurationException("Invalid configuration");
	}

	public List<AZEntry> getAllWebContents(ThemeDisplay themeDisplay, String structureKey) throws SearchException {
		List<AZEntry> results = new ArrayList<>();

		SearchContext searchContext = webContentRetrievalService.getSearchContext(themeDisplay.getCompanyId(), structureKey, -1);
		Document[] searchResults = webContentRetrievalService.getSearchResults(searchContext);
		for (Document document : searchResults) {
			try {
				results.add(webContentRetrievalService.getAZEntryFromSearchResult(document, themeDisplay));
			} catch (Exception e) {
				LOG.debug(e);
			}
		}
		return results;
	}

	public List<JournalArticleDisplay> getMostPopularWebContents(ThemeDisplay themeDisplay, Integer maxItemsToDisplay, String structureKey, String templateKey) throws SearchException {
		List<JournalArticleDisplay> results = new ArrayList<>();

		SearchContext searchContext = webContentRetrievalService.getSearchContext(themeDisplay.getCompanyId(), structureKey, maxItemsToDisplay);
		Document[] searchResults = webContentRetrievalService.getSearchResults(searchContext);

		for (Document document : searchResults) {
			try {
				results.add(webContentRetrievalService.getJournalArticleDisplayFromSearchResult(document, themeDisplay, templateKey));
			} catch (Exception e) {
				LOG.debug(e);
			}
		}
		return results;
	}

}
