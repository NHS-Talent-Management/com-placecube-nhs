package com.placecube.nhs.readiness.web.lifefycle;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.liferay.journal.model.JournalFolder;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.StringUtil;
import com.placecube.digitalplace.journal.service.JournalArticleCreationService;
import com.placecube.nhs.readiness.web.constants.WebContentArticles;

@RunWith(PowerMockRunner.class)
@PrepareForTest(StringUtil.class)
public class ReadinessSetupServiceTest extends PowerMockito {

	@InjectMocks
	private ReadinessSetupService readinessSetupService;

	@Mock
	private JournalArticleCreationService mockJournalArticleCreationService;

	@Mock
	private JournalFolder mockJournalFolder;

	@Mock
	private ServiceContext mockServiceContext;

	@Mock
	private Group mockGroup;

	@Before
	public void setUp() {
		mockStatic(StringUtil.class);
	}

	@Test
	public void addArticle_WhenNoError_ThenCreatesTheArticle() throws Exception {
		String articleContent = "articleContent";
		WebContentArticles webContent = WebContentArticles.CAREER_READINESS;
		when(StringUtil.read(getClass().getClassLoader(), "com/placecube/nhs/readiness/dependencies/webcontent/" + webContent.getArticleId() + ".xml")).thenReturn(articleContent);

		readinessSetupService.addArticle(webContent, mockJournalFolder, mockServiceContext);

		verify(mockJournalArticleCreationService, times(1)).getOrCreateBasicWebContentArticle(webContent.getArticleId(), webContent.getArticleTitle(), articleContent, mockJournalFolder,
				mockServiceContext);
	}

	@Test(expected = PortalException.class)
	public void addArticle_WhenExceptionReadingArticleContent_ThenThrowsPortalException() throws Exception {
		WebContentArticles webContent = WebContentArticles.CAREER_READINESS;
		when(StringUtil.read(getClass().getClassLoader(), "com/placecube/nhs/readiness/dependencies/webcontent/" + webContent.getArticleId() + ".xml")).thenThrow(new IOException());

		readinessSetupService.addArticle(webContent, mockJournalFolder, mockServiceContext);
	}

	@Test(expected = PortalException.class)
	public void addArticle_WhenExceptionCreatingArticle_ThenThrowsPortalException() throws Exception {
		String articleContent = "articleContent";
		WebContentArticles webContent = WebContentArticles.CAREER_READINESS;
		when(StringUtil.read(getClass().getClassLoader(), "com/placecube/nhs/readiness/dependencies/webcontent/" + webContent.getArticleId() + ".xml")).thenReturn(articleContent);
		when(mockJournalArticleCreationService.getOrCreateBasicWebContentArticle(webContent.getArticleId(), webContent.getArticleTitle(), articleContent, mockJournalFolder, mockServiceContext))
				.thenThrow(new PortalException());

		readinessSetupService.addArticle(webContent, mockJournalFolder, mockServiceContext);
	}

	@Test
	public void addFolder_WhenNoError_ThenReturnsTheFolder() throws PortalException {
		when(mockJournalArticleCreationService.getOrCreateJournalFolder("Readiness Questionnaire", mockServiceContext)).thenReturn(mockJournalFolder);

		JournalFolder result = readinessSetupService.addFolder(mockServiceContext);

		assertThat(result, sameInstance(mockJournalFolder));
	}

	@Test(expected = PortalException.class)
	public void addFolder_WhenExceptionCreatingTheFolder_ThenThrowsPortalException() throws PortalException {
		when(mockJournalArticleCreationService.getOrCreateJournalFolder("Readiness Questionnaire", mockServiceContext)).thenThrow(new PortalException());

		readinessSetupService.addFolder(mockServiceContext);
	}

	@Test
	public void getServiceContext_WhenNoError_ThenReturnsServiceContextWithGroupIdConfigured() {
		Long expected = 11l;
		when(mockGroup.getGroupId()).thenReturn(expected);

		ServiceContext result = readinessSetupService.getServiceContext(mockGroup);

		assertThat(result.getScopeGroupId(), equalTo(expected));
	}

	@Test
	public void getServiceContext_WhenNoError_ThenReturnsServiceContextWithCompanyIdConfigured() {
		Long expected = 11l;
		when(mockGroup.getCompanyId()).thenReturn(expected);

		ServiceContext result = readinessSetupService.getServiceContext(mockGroup);

		assertThat(result.getCompanyId(), equalTo(expected));
	}

	@Test
	public void getServiceContext_WhenNoError_ThenReturnsServiceContextWithUserIdConfigured() {
		Long expected = 11l;
		when(mockGroup.getCreatorUserId()).thenReturn(expected);

		ServiceContext result = readinessSetupService.getServiceContext(mockGroup);

		assertThat(result.getUserId(), equalTo(expected));
	}

	@Test
	public void getServiceContext_WhenNoError_ThenReturnsServiceContextWithLanguageIdConfigured() {
		String expected = "expectedValue";
		when(mockGroup.getDefaultLanguageId()).thenReturn(expected);

		ServiceContext result = readinessSetupService.getServiceContext(mockGroup);

		assertThat(result.getLanguageId(), equalTo(expected));
	}

}
