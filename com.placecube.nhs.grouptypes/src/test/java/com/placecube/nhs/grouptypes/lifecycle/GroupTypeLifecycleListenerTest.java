package com.placecube.nhs.grouptypes.lifecycle;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;

import com.liferay.portal.kernel.model.Company;
import com.pfiks.expando.exception.ExpandoColumnCreationException;
import com.placecube.nhs.grouptypes.expando.GroupTypeExpandoColumnCreator;

public class GroupTypeLifecycleListenerTest extends PowerMockito {

	@InjectMocks
	private GroupTypeLifecycleListener groupTypeLifecycleListener;

	@Mock
	private GroupTypeExpandoColumnCreator mockGroupTypeExpandoColumnCreator;

	@Mock
	private Company mockCompany;

	@Before
	public void setUp() {
		initMocks(this);
	}

	@Test
	public void portalInstanceRegistered_WhenNoError_ThenCreatesTheExpandoColumn() throws Exception {
		groupTypeLifecycleListener.portalInstanceRegistered(mockCompany);

		verify(mockGroupTypeExpandoColumnCreator, times(1)).create(mockCompany);
	}

	@Test(expected = ExpandoColumnCreationException.class)
	public void portalInstanceRegistered_WhenExceptionCreatingColumn_ThenThrowsExpandoColumnCreationException() throws Exception {
		when(mockGroupTypeExpandoColumnCreator.create(mockCompany)).thenThrow(new ExpandoColumnCreationException("msg"));

		groupTypeLifecycleListener.portalInstanceRegistered(mockCompany);

	}

}
