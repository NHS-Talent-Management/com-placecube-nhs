package com.placecube.nhs.readiness.lifecycle;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;

import com.liferay.journal.model.JournalFolder;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.ServiceContext;
import com.placecube.nhs.readiness.constants.WebContentArticles;
import com.placecube.nhs.readiness.service.impl.ReadinessWebContentService;

public class ReadinessLifecycleListenerTest extends PowerMockito {

	private static final Long COMPANY_ID = 15l;

	@InjectMocks
	private ReadinessLifecycleListener readinessLifecycleListener;

	@Mock
	private ReadinessWebContentService mockReadinessWebContentService;

	@Mock
	private Company mockCompany;

	@Mock
	private Group mockGroup;

	@Mock
	private ServiceContext mockServiceContext;

	@Mock
	private JournalFolder mockJournalFolder;

	@Before
	public void setUp() {
		initMocks(this);
	}

	@Test(expected = PortalException.class)
	public void portalInstanceRegistered_WhenExceptionRetrievingThGroup_ThenThrowsPortalException() throws Exception {
		when(mockCompany.getCompanyId()).thenReturn(COMPANY_ID);
		when(mockCompany.getGroup()).thenThrow(new PortalException());

		readinessLifecycleListener.portalInstanceRegistered(mockCompany);
	}

	@Test(expected = PortalException.class)
	public void portalInstanceRegistered_WhenExceptionAddingFolder_ThenThrowsPortalException() throws Exception {
		mockServiceContextDetails();
		when(mockReadinessWebContentService.addFolder(mockServiceContext)).thenThrow(new PortalException());

		readinessLifecycleListener.portalInstanceRegistered(mockCompany);
	}

	@Test(expected = Exception.class)
	public void portalInstanceRegistered_WhenExceptionAddingIntroReadinessArticle_ThenThrowsException() throws Exception {
		mockServiceContextDetails();
		when(mockReadinessWebContentService.addFolder(mockServiceContext)).thenReturn(mockJournalFolder);
		doThrow(new Exception()).when(mockReadinessWebContentService).addArticle(WebContentArticles.READINESS_QUESTIONNAIRE_INTRO, mockJournalFolder, mockServiceContext);

		readinessLifecycleListener.portalInstanceRegistered(mockCompany);
	}

	@Test
	public void portalInstanceRegistered_WhenNoError_ThenAddsIntroReadinessArticle() throws Exception {
		mockServiceContextDetails();
		when(mockReadinessWebContentService.addFolder(mockServiceContext)).thenReturn(mockJournalFolder);

		readinessLifecycleListener.portalInstanceRegistered(mockCompany);

		verify(mockReadinessWebContentService, times(1)).addArticle(WebContentArticles.READINESS_QUESTIONNAIRE_INTRO, mockJournalFolder, mockServiceContext);
	}

	@Test(expected = Exception.class)
	public void portalInstanceRegistered_WhenExceptionAddingReadinessQuestionnaireCompletedArticle_ThenThrowsException() throws Exception {
		mockServiceContextDetails();
		when(mockReadinessWebContentService.addFolder(mockServiceContext)).thenReturn(mockJournalFolder);
		doThrow(new Exception()).when(mockReadinessWebContentService).addArticle(WebContentArticles.READINESS_QUESTIONNAIRE_COMPLETED, mockJournalFolder, mockServiceContext);

		readinessLifecycleListener.portalInstanceRegistered(mockCompany);
	}

	@Test
	public void portalInstanceRegistered_WhenNoError_ThenAddsReadinessQuestionnaireCompletedArticle() throws Exception {
		mockServiceContextDetails();
		when(mockReadinessWebContentService.addFolder(mockServiceContext)).thenReturn(mockJournalFolder);

		readinessLifecycleListener.portalInstanceRegistered(mockCompany);

		verify(mockReadinessWebContentService, times(1)).addArticle(WebContentArticles.READINESS_QUESTIONNAIRE_COMPLETED, mockJournalFolder, mockServiceContext);
	}

	private void mockServiceContextDetails() throws PortalException {
		when(mockCompany.getCompanyId()).thenReturn(COMPANY_ID);
		when(mockCompany.getGroup()).thenReturn(mockGroup);
		when(mockReadinessWebContentService.getServiceContext(mockGroup)).thenReturn(mockServiceContext);
	}

}
