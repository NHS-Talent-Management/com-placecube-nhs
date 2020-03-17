package com.placecube.nhs.readiness.model.impl;

import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;

import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoTableConstants;
import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.service.ExpandoColumnLocalService;
import com.liferay.expando.kernel.service.ExpandoValueLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.placecube.nhs.readiness.model.ReadinessQuestion;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ReadinessQuestionImpl.class)
public class ModelFactoryBuilderTest extends PowerMockito {

	private static final int INDEX = 10;
	private static final long TABLE_ID = 20;
	private static final long COMPANY_ID = 30;
	private static final long USER_ID = 40;
	private static final long COLUMN_ID = 50;
	private static final Locale LOCALE = Locale.CANADA_FRENCH;
	private static final String QUESTION_TITLE = "question Title";
	private static final String NAME = "columnName";
	private static final String LOCALISED_NAME = "column localised Name";
	private static final String USER_EXANDO_VALUE = "selectedValue";
	private static final String DEFAULT_DATA = "availableValue1,availableValue2";

	@InjectMocks
	private ModelFactoryBuilder modelFactoryBuilder;

	@Mock
	private ExpandoColumnLocalService mockExpandoColumnLocalService;

	@Mock
	private ExpandoValueLocalService mockExpandoValueLocalService;

	@Mock
	private User mockUser;

	@Mock
	private ExpandoColumn mockExpandoColumn;

	@Mock
	private ExpandoValue mockExpandoValue;

	@Mock
	private Company mockCompany;

	@Mock
	private ReadinessQuestionImpl mockReadinessQuestionImpl;

	@Before
	public void setUp() {
		mockStatic(ReadinessQuestionImpl.class);
	}

	@Test
	public void getQuestion_WithCompanyParameter_WhenNoError_ThenReturnsTheQuestionConfigured() throws PortalException {
		mockCompanyDetails();
		mockColumnDetails();
		when(ReadinessQuestionImpl.init(mockExpandoColumn, LOCALE, QUESTION_TITLE, INDEX + 1, StringPool.BLANK)).thenReturn(mockReadinessQuestionImpl);

		ReadinessQuestion result = modelFactoryBuilder.getQuestion(mockCompany, INDEX, NAME + "=" + QUESTION_TITLE);

		assertThat(result, sameInstance(mockReadinessQuestionImpl));
	}

	@Test
	public void getQuestion_WithUserParameter_WhenNoErrorAndExpandoValueFoundForUser_ThenReturnsTheQuestionConfigured() {
		mockUserDetails();
		mockColumnDetails();
		when(mockExpandoValueLocalService.getValue(TABLE_ID, COLUMN_ID, USER_ID)).thenReturn(mockExpandoValue);
		when(mockExpandoValue.getData()).thenReturn(USER_EXANDO_VALUE);
		when(ReadinessQuestionImpl.init(mockExpandoColumn, LOCALE, QUESTION_TITLE, INDEX + 1, USER_EXANDO_VALUE)).thenReturn(mockReadinessQuestionImpl);

		ReadinessQuestion result = modelFactoryBuilder.getQuestion(mockUser, INDEX, NAME + "=" + QUESTION_TITLE);

		assertThat(result, sameInstance(mockReadinessQuestionImpl));
	}

	@Test
	public void getQuestion_WithUserParameter_WhenNoErrorAndNoExpandoValueFoundForUser_ThenReturnsTheQuestionConfigured() {
		mockUserDetails();
		mockColumnDetails();
		when(mockExpandoValueLocalService.getValue(TABLE_ID, COLUMN_ID, USER_ID)).thenReturn(null);
		when(ReadinessQuestionImpl.init(mockExpandoColumn, LOCALE, QUESTION_TITLE, INDEX + 1, StringPool.BLANK)).thenReturn(mockReadinessQuestionImpl);

		ReadinessQuestion result = modelFactoryBuilder.getQuestion(mockUser, INDEX, NAME + "=" + QUESTION_TITLE);

		assertThat(result, sameInstance(mockReadinessQuestionImpl));
	}

	private void mockColumnDetails() {
		when(mockExpandoColumnLocalService.getColumn(COMPANY_ID, User.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME, NAME)).thenReturn(mockExpandoColumn);
		when(mockExpandoColumn.getTableId()).thenReturn(TABLE_ID);
		when(mockExpandoColumn.getColumnId()).thenReturn(COLUMN_ID);
	}

	private void mockCompanyDetails() throws PortalException {
		when(mockCompany.getCompanyId()).thenReturn(COMPANY_ID);
		when(mockCompany.getLocale()).thenReturn(LOCALE);
	}

	private void mockUserDetails() {
		when(mockUser.getCompanyId()).thenReturn(COMPANY_ID);
		when(mockUser.getLocale()).thenReturn(LOCALE);
		when(mockUser.getUserId()).thenReturn(USER_ID);
	}

}
