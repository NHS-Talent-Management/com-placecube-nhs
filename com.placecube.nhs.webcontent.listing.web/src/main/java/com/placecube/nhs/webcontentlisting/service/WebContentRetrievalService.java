package com.placecube.nhs.webcontentlisting.service;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalArticleDisplay;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.journal.util.JournalContent;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.pfiks.journal.content.service.JournalContentRendererService;
import com.placecube.nhs.search.utils.SearchService;
import com.placecube.nhs.taglib.az.model.AZEntry;

@Component(immediate = true, service = WebContentRetrievalService.class)
public class WebContentRetrievalService {

	@Reference
	private JournalArticleLocalService journalArticleLocalService;

	@Reference
	private JournalContent journalContent;

	@Reference
	private JournalContentRendererService journalContentRendererService;

	@Reference
	private SearchService searchService;

	public SearchContext getSearchContext(long companyId, String structureKey, int maxItemsToDisplay) {
		SearchContext searchContext = searchService.getSearchContext(companyId);
		if (maxItemsToDisplay > 0) {
			searchContext.setStart(0);
			searchContext.setEnd(maxItemsToDisplay);
		}
		searchContext.setEntryClassNames(new String[] { JournalArticle.class.getName() });
		searchContext.setSorts(searchService.getSortOnDate(Field.CREATE_DATE, true));

		searchService.configureBooleanClauses(searchContext, searchService.getStringQuery("ddmStructureKey", structureKey, BooleanClauseOccur.MUST));

		return searchContext;
	}

	public Document[] getSearchResults(SearchContext searchContext) throws SearchException {
		return searchService.getSearchResults(searchContext, JournalArticle.class.getName());
	}

	public AZEntry getAZEntryFromSearchResult(Document document, ThemeDisplay themeDisplay, String currentPageURL) throws PortalException {
		long groupId = GetterUtil.getLong(document.get(Field.GROUP_ID));
		String articleId = GetterUtil.getString(document.get(Field.ARTICLE_ID));
		JournalArticle journalArticle = journalArticleLocalService.getLatestArticle(groupId, articleId);
		String viewURL = currentPageURL + journalContentRendererService.getFriendlyURL(journalArticle);
		return AZEntry.init(journalArticle.getTitle(themeDisplay.getLanguageId()), viewURL);
	}

	public JournalArticleDisplay getJournalArticleDisplayFromSearchResult(Document document, ThemeDisplay themeDisplay, String templateKey) {
		long groupId = GetterUtil.getLong(document.get(Field.GROUP_ID));
		String articleId = GetterUtil.getString(document.get(Field.ARTICLE_ID));
		return journalContent.getDisplay(groupId, articleId, templateKey, null, themeDisplay.getLanguageId(), 0, null, themeDisplay);
	}

}
