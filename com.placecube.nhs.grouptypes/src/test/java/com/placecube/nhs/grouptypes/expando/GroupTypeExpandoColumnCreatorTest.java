package com.placecube.nhs.grouptypes.expando;

import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.MockitoAnnotations.initMocks;

import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;

import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.pfiks.expando.creator.ExpandoColumnCreatorInputStreamService;
import com.pfiks.expando.exception.ExpandoColumnCreationException;

public class GroupTypeExpandoColumnCreatorTest extends PowerMockito {

	@InjectMocks
	private GroupTypeExpandoColumnCreator groupTypeExpandoColumnCreator;

	@Mock
	private ExpandoColumnCreatorInputStreamService mockExpandoColumnCreatorInputStreamService;

	@Mock
	private ExpandoColumn mockExpandoColumn;

	@Mock
	private Company mockCompany;

	@Before
	public void setUp() {
		initMocks(this);
	}

	@Test
	public void create_WhenNoError_ThenReturnsTheCreatedExpandoColumn() throws ExpandoColumnCreationException {
		when(mockExpandoColumnCreatorInputStreamService.createExpandoColumn(eq(mockCompany), eq(Group.class.getName()), any(InputStream.class))).thenReturn(mockExpandoColumn);

		ExpandoColumn result = groupTypeExpandoColumnCreator.create(mockCompany);

		assertThat(result, sameInstance(mockExpandoColumn));
	}

	@Test(expected = ExpandoColumnCreationException.class)
	public void create_WhenExceptionCreatingColumn_ThenThrowsExpandoColumnCreationException() throws ExpandoColumnCreationException {
		when(mockExpandoColumnCreatorInputStreamService.createExpandoColumn(eq(mockCompany), eq(Group.class.getName()), any(InputStream.class)))
				.thenThrow(new ExpandoColumnCreationException(StringPool.BLANK));

		groupTypeExpandoColumnCreator.create(mockCompany);
	}
}
