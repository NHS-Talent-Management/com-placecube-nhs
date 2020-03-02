package com.placecube.nhs.readiness.web.lifefycle;

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
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.placecube.nhs.readiness.web.constants.WebContentArticles;

public class ReadinessLifecycleListenerTest extends PowerMockito {

	private static final Long COMPANY_ID = 15l;

	@InjectMocks
	private ReadinessLifecycleListener readinessLifecycleListener;

	@Mock
	private ReadinessSetupService mockReadinessSetupService;

	@Mock
	private GroupLocalService mockGroupLocalService;

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
	public void portalInstanceRegistered_WhenExceptionRetrievingTheGuestGroup_ThenThrowsPortalException() throws Exception {
		when(mockCompany.getCompanyId()).thenReturn(COMPANY_ID);
		when(mockGroupLocalService.getGroup(COMPANY_ID, GroupConstants.GUEST)).thenThrow(new PortalException());

		readinessLifecycleListener.portalInstanceRegistered(mockCompany);
	}

	@Test(expected = PortalException.class)
	public void portalInstanceRegistered_WhenExceptionAddingFolder_ThenThrowsPortalException() throws Exception {
		mockServiceContextDetails();
		when(mockReadinessSetupService.addFolder(mockServiceContext)).thenThrow(new PortalException());

		readinessLifecycleListener.portalInstanceRegistered(mockCompany);
	}

	@Test(expected = Exception.class)
	public void portalInstanceRegistered_WhenExceptionAddingCareerReadinessArticle_ThenThrowsException() throws Exception {
		mockServiceContextDetails();
		when(mockReadinessSetupService.addFolder(mockServiceContext)).thenReturn(mockJournalFolder);
		doThrow(new Exception()).when(mockReadinessSetupService).addArticle(WebContentArticles.CAREER_READINESS, mockJournalFolder, mockServiceContext);

		readinessLifecycleListener.portalInstanceRegistered(mockCompany);
	}

	@Test
	public void portalInstanceRegistered_WhenNoError_ThenAddsCareerReadinessArticle() throws Exception {
		mockServiceContextDetails();
		when(mockReadinessSetupService.addFolder(mockServiceContext)).thenReturn(mockJournalFolder);

		readinessLifecycleListener.portalInstanceRegistered(mockCompany);

		verify(mockReadinessSetupService, times(1)).addArticle(WebContentArticles.CAREER_READINESS, mockJournalFolder, mockServiceContext);
	}

	@Test(expected = Exception.class)
	public void portalInstanceRegistered_WhenExceptionAddingReadinessQuestionnaireCompletedArticle_ThenThrowsException() throws Exception {
		mockServiceContextDetails();
		when(mockReadinessSetupService.addFolder(mockServiceContext)).thenReturn(mockJournalFolder);
		doThrow(new Exception()).when(mockReadinessSetupService).addArticle(WebContentArticles.READINESS_QUESTIONNAIRE_COMPLETED, mockJournalFolder, mockServiceContext);

		readinessLifecycleListener.portalInstanceRegistered(mockCompany);
	}

	@Test
	public void portalInstanceRegistered_WhenNoError_ThenAddsReadinessQuestionnaireCompletedArticle() throws Exception {
		mockServiceContextDetails();
		when(mockReadinessSetupService.addFolder(mockServiceContext)).thenReturn(mockJournalFolder);

		readinessLifecycleListener.portalInstanceRegistered(mockCompany);

		verify(mockReadinessSetupService, times(1)).addArticle(WebContentArticles.READINESS_QUESTIONNAIRE_COMPLETED, mockJournalFolder, mockServiceContext);
	}

	private void mockServiceContextDetails() throws PortalException {
		when(mockCompany.getCompanyId()).thenReturn(COMPANY_ID);
		when(mockGroupLocalService.getGroup(COMPANY_ID, GroupConstants.GUEST)).thenReturn(mockGroup);
		when(mockReadinessSetupService.getServiceContext(mockGroup)).thenReturn(mockServiceContext);
	}

}
