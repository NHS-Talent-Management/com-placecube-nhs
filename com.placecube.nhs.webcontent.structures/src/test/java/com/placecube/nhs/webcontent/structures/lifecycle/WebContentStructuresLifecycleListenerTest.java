package com.placecube.nhs.webcontent.structures.lifecycle;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;

import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.ServiceContext;
import com.placecube.nhs.webcontent.structures.constants.WebContentStructure;
import com.placecube.nhs.webcontent.structures.service.ImportService;

public class WebContentStructuresLifecycleListenerTest extends PowerMockito {

	@InjectMocks
	private WebContentStructuresLifecycleListener webContentStructuresLifecycleListener;

	@Mock
	private ImportService mockImportService;

	@Mock
	private Company mockCompany;

	@Mock
	private ServiceContext mockServiceContext;

	@Mock
	private Group mockGroup;

	@Before
	public void setUp() {
		initMocks(this);
	}

	@Test
	public void portalInstanceRegistered_WHenNoError_ThenCreatesStructures() throws Exception {
		when(mockCompany.getGroup()).thenReturn(mockGroup);
		when(mockImportService.getServiceContext(mockGroup)).thenReturn(mockServiceContext);

		webContentStructuresLifecycleListener.portalInstanceRegistered(mockCompany);

		verify(mockImportService, times(1)).addStructureAndTemplates(mockServiceContext, WebContentStructure.COURSE);
		verify(mockImportService, times(1)).addStructureAndTemplates(mockServiceContext, WebContentStructure.JOB);
	}

}
