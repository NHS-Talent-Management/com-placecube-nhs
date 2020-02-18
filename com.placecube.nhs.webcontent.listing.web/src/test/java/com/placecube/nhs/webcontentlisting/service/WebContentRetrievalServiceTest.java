package com.placecube.nhs.webcontentlisting.service;

import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalArticleDisplay;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.journal.util.JournalContent;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.pfiks.journal.content.service.JournalContentRendererService;
import com.placecube.nhs.search.utils.SearchService;
import com.placecube.nhs.taglib.az.model.AZEntry;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ AZEntry.class })
public class WebContentRetrievalServiceTest extends PowerMockito {

	private static final long COMPANY_ID = 1;
	private static final String STRUCTURE_KEY = "structureKeyValu";
	private static final int MAX_ITEMS = 22;
	private static final long GROUP_ID = 24;
	private static final String ARTICLE_ID = "articleIdValue";
	private static final String TEMPLATE_KEY = "templateKey";

	@InjectMocks
	private WebContentRetrievalService webContentRetrievalService;

	@Mock
	private JournalArticleLocalService mockJournalArticleLocalService;

	@Mock
	private JournalContent mockJournalContent;

	@Mock
	private JournalContentRendererService mockJournalContentRendererService;

	@Mock
	private SearchService mockSearchService;

	@Mock
	private SearchContext mockSearchContext;

	@Mock
	private BooleanClause<Query> mockBooleanClause;

	@Mock
	private Document mockDocument;

	@Mock
	private ThemeDisplay mockThemeDisplay;

	@Mock
	private AZEntry mockAZEntry;

	@Mock
	private JournalArticle mockJournalArticle;

	@Mock
	private JournalArticleDisplay mockJournalArticleDisplay;

	@Before
	public void setUp() {
		mockStatic(AZEntry.class);
	}

	@Test
	public void getSearchContext_WhenNoError_ThenReturnsTheSearchContext() {
		when(mockSearchService.getSearchContext(COMPANY_ID)).thenReturn(mockSearchContext);

		SearchContext result = webContentRetrievalService.getSearchContext(COMPANY_ID, STRUCTURE_KEY, MAX_ITEMS);

		assertThat(result, sameInstance(mockSearchContext));
	}

	@Test
	public void getSearchContext_WhenMaxItemsIsNotGreaterThanZero_ThenDoesNotConfigureStartAndEnd() {
		when(mockSearchService.getSearchContext(COMPANY_ID)).thenReturn(mockSearchContext);

		webContentRetrievalService.getSearchContext(COMPANY_ID, STRUCTURE_KEY, 0);

		verify(mockSearchContext, never()).setStart(anyInt());
		verify(mockSearchContext, never()).setEnd(anyInt());
	}

	@Test
	public void getSearchContext_WhenMaxItemsIsGreaterThanZero_ThenConfigureStartAndEnd() {
		when(mockSearchService.getSearchContext(COMPANY_ID)).thenReturn(mockSearchContext);

		webContentRetrievalService.getSearchContext(COMPANY_ID, STRUCTURE_KEY, MAX_ITEMS);

		verify(mockSearchContext, times(1)).setStart(0);
		verify(mockSearchContext, times(1)).setEnd(MAX_ITEMS);
	}

	@Test
	public void getSearchContext_WhenNoError_ThenConfiguresJournalArticleAsEntryClassNames() {
		when(mockSearchService.getSearchContext(COMPANY_ID)).thenReturn(mockSearchContext);

		webContentRetrievalService.getSearchContext(COMPANY_ID, STRUCTURE_KEY, MAX_ITEMS);

		verify(mockSearchContext, times(1)).setEntryClassNames(new String[] { JournalArticle.class.getName() });
		verify(mockSearchContext, times(1)).setEnd(MAX_ITEMS);
	}

	@Test
	public void getSearchContext_WhenNoError_ThenConfiguresTheBooleanClauses() {
		when(mockSearchService.getSearchContext(COMPANY_ID)).thenReturn(mockSearchContext);
		when(mockSearchService.getStringQuery("ddmStructureKey", STRUCTURE_KEY, BooleanClauseOccur.MUST)).thenReturn(mockBooleanClause);

		webContentRetrievalService.getSearchContext(COMPANY_ID, STRUCTURE_KEY, MAX_ITEMS);

		verify(mockSearchService, times(1)).configureBooleanClauses(mockSearchContext, mockBooleanClause);
	}

	@Test
	public void getSearchResults_WhenNoError_ThenReturnsTheSearchResults() throws SearchException {
		Document[] documents = new Document[] { mockDocument };
		when(mockSearchService.getSearchResults(mockSearchContext, JournalArticle.class.getName())).thenReturn(documents);

		Document[] results = webContentRetrievalService.getSearchResults(mockSearchContext);

		assertThat(results, sameInstance(documents));
	}

	@Test
	public void getAZEntryFromSearchResult_WhenNoError_ThenReturnsAZEntry() throws PortalException {
		String currentURL = "currentURLValue";
		String journalURL = "journalURLValue";
		String title = "titleValue";
		String languageId = "languageIdValue";
		when(mockDocument.get(Field.GROUP_ID)).thenReturn(String.valueOf(GROUP_ID));
		when(mockDocument.get(Field.ARTICLE_ID)).thenReturn(ARTICLE_ID);
		when(mockJournalArticleLocalService.getLatestArticle(GROUP_ID, ARTICLE_ID)).thenReturn(mockJournalArticle);
		when(mockThemeDisplay.getURLCurrent()).thenReturn(currentURL);
		when(mockJournalContentRendererService.getFriendlyURL(mockJournalArticle)).thenReturn(journalURL);
		when(mockThemeDisplay.getLanguageId()).thenReturn(languageId);
		when(mockJournalArticle.getTitle(languageId)).thenReturn(title);
		when(AZEntry.init(title, currentURL + journalURL)).thenReturn(mockAZEntry);

		AZEntry result = webContentRetrievalService.getAZEntryFromSearchResult(mockDocument, mockThemeDisplay);

		assertThat(result, sameInstance(mockAZEntry));
	}

	@Test
	public void getJournalArticleDisplayFromSearchResult_WhenNoError_ThenReturnsJournalArticleDisplay() throws PortalException {
		String languageId = "languageIdValue";
		when(mockDocument.get(Field.GROUP_ID)).thenReturn(String.valueOf(GROUP_ID));
		when(mockDocument.get(Field.ARTICLE_ID)).thenReturn(ARTICLE_ID);
		when(mockThemeDisplay.getLanguageId()).thenReturn(languageId);
		when(mockJournalContent.getDisplay(GROUP_ID, ARTICLE_ID, TEMPLATE_KEY, null, languageId, 0, null, mockThemeDisplay)).thenReturn(mockJournalArticleDisplay);

		JournalArticleDisplay result = webContentRetrievalService.getJournalArticleDisplayFromSearchResult(mockDocument, mockThemeDisplay, TEMPLATE_KEY);

		assertThat(result, sameInstance(mockJournalArticleDisplay));
	}
}
