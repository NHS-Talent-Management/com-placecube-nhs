package com.placecube.nhs.registration.lifecyclelistener;

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
import com.placecube.nhs.registration.constants.WebContentArticles;
import com.placecube.nhs.registration.service.RegistrationSetupService;

public class RegistrationLifecycleListenerTest extends PowerMockito {

	private static final long COMPANY_ID = 10;

	@InjectMocks
	private RegistrationLifecycleListener registrationLifecycleListener;

	@Mock
	private RegistrationSetupService registrationSetupService;

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

		registrationLifecycleListener.portalInstanceRegistered(mockCompany);
	}

	@Test(expected = PortalException.class)
	public void portalInstanceRegistered_WhenExceptionAddingFolder_ThenThrowsPortalException() throws Exception {
		mockServiceContextDetails();
		when(registrationSetupService.addFolder(mockServiceContext)).thenThrow(new PortalException());

		registrationLifecycleListener.portalInstanceRegistered(mockCompany);
	}

	@Test(expected = Exception.class)
	public void portalInstanceRegistered_WhenExceptionAddingRegistrationConfirmationPageArticle_ThenThrowsException() throws Exception {
		mockServiceContextDetails();
		when(registrationSetupService.addFolder(mockServiceContext)).thenReturn(mockJournalFolder);
		doThrow(new Exception()).when(registrationSetupService).addArticle(WebContentArticles.REGISTRATION_CONFIRMATION_PAGE, mockJournalFolder, mockServiceContext);

		registrationLifecycleListener.portalInstanceRegistered(mockCompany);
	}

	@Test
	public void portalInstanceRegistered_WhenNoError_ThenRegistrationConfirmationPageArticle() throws Exception {
		mockServiceContextDetails();
		when(registrationSetupService.addFolder(mockServiceContext)).thenReturn(mockJournalFolder);

		registrationLifecycleListener.portalInstanceRegistered(mockCompany);

		verify(registrationSetupService, times(1)).addArticle(WebContentArticles.REGISTRATION_CONFIRMATION_PAGE, mockJournalFolder, mockServiceContext);
	}

	@Test(expected = Exception.class)
	public void portalInstanceRegistered_WhenExceptionAddingRegistrationIntroTextArticle_ThenThrowsException() throws Exception {
		mockServiceContextDetails();
		when(registrationSetupService.addFolder(mockServiceContext)).thenReturn(mockJournalFolder);
		doThrow(new Exception()).when(registrationSetupService).addArticle(WebContentArticles.REGISTRATION_INTRO_TEXT, mockJournalFolder, mockServiceContext);

		registrationLifecycleListener.portalInstanceRegistered(mockCompany);
	}

	@Test
	public void portalInstanceRegistered_WhenNoError_ThenRegistrationIntroTextArticle() throws Exception {
		mockServiceContextDetails();
		when(registrationSetupService.addFolder(mockServiceContext)).thenReturn(mockJournalFolder);

		registrationLifecycleListener.portalInstanceRegistered(mockCompany);

		verify(registrationSetupService, times(1)).addArticle(WebContentArticles.REGISTRATION_INTRO_TEXT, mockJournalFolder, mockServiceContext);
	}

	@Test(expected = Exception.class)
	public void portalInstanceRegistered_WhenExceptionAddingRegistrationBottomTextArticle_ThenThrowsException() throws Exception {
		mockServiceContextDetails();
		when(registrationSetupService.addFolder(mockServiceContext)).thenReturn(mockJournalFolder);
		doThrow(new Exception()).when(registrationSetupService).addArticle(WebContentArticles.REGISTRATION_BOTTOM_TEXT, mockJournalFolder, mockServiceContext);

		registrationLifecycleListener.portalInstanceRegistered(mockCompany);
	}

	@Test
	public void portalInstanceRegistered_WhenNoError_ThenRegistrationBottomTextArticle() throws Exception {
		mockServiceContextDetails();
		when(registrationSetupService.addFolder(mockServiceContext)).thenReturn(mockJournalFolder);

		registrationLifecycleListener.portalInstanceRegistered(mockCompany);

		verify(registrationSetupService, times(1)).addArticle(WebContentArticles.REGISTRATION_BOTTOM_TEXT, mockJournalFolder, mockServiceContext);
	}

	private void mockServiceContextDetails() throws PortalException {
		when(mockCompany.getCompanyId()).thenReturn(COMPANY_ID);
		when(mockGroupLocalService.getGroup(COMPANY_ID, GroupConstants.GUEST)).thenReturn(mockGroup);
		when(registrationSetupService.getServiceContext(mockGroup)).thenReturn(mockServiceContext);
	}
}
