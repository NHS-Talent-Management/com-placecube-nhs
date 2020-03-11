package com.placecube.nhs.readiness.service.impl;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;

import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoTableConstants;
import com.liferay.expando.kernel.service.ExpandoColumnLocalService;
import com.liferay.expando.kernel.service.ExpandoValueLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.placecube.nhs.readiness.configuration.ReadinessInstanceConfiguration;
import com.placecube.nhs.readiness.model.ReadinessQuestion;
import com.placecube.nhs.readiness.model.impl.ModelFactoryBuilder;

public class ReadinessServiceImplTest extends PowerMockito {

	private static final long COLUMN_ID_1 = 10;
	private static final long USER_ID = 30;
	private static final Long COMPANY_ID = 20l;
	private static final String NAME = "name1";
	private static final long COLUMN_ID_2 = 23230;
	private static final long COLUMN_ID_3 = 8790;
	private static final String VALUE = "value";

	@InjectMocks
	private ReadinessServiceImpl readinessServiceImpl;

	@Mock
	private ConfigurationProvider mockConfigurationProvider;

	@Mock
	private ExpandoColumnLocalService mockExpandoColumnLocalService;

	@Mock
	private ExpandoValueLocalService mockExpandoValueLocalService;

	@Mock
	private ModelFactoryBuilder mockModelFactoryBuilder;

	@Mock
	private ReadinessInstanceConfiguration mockReadinessInstanceConfiguration;

	@Mock
	private User mockUser;

	@Mock
	private ExpandoColumn mockExpandoColumn;

	@Mock
	private ReadinessQuestion mockReadinessQuestion1;

	@Mock
	private ReadinessQuestion mockReadinessQuestion2;

	@Mock
	private ReadinessQuestion mockReadinessQuestion3;

	@Mock
	private Company mockCompany;

	@Before
	public void setUp() {
		initMocks(this);
	}

	@Test
	public void deleteAnswer_WhenNoError_ThenDeletesTheExpandoValue() throws PortalException {
		when(mockExpandoColumnLocalService.getColumn(COLUMN_ID_1)).thenReturn(mockExpandoColumn);
		when(mockExpandoColumn.getCompanyId()).thenReturn(COMPANY_ID);
		when(mockExpandoColumn.getName()).thenReturn(NAME);

		readinessServiceImpl.deleteAnswer(COLUMN_ID_1, USER_ID);

		verify(mockExpandoValueLocalService, times(1)).deleteValue(COMPANY_ID, User.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME, NAME, USER_ID);
	}

	@Test(expected = PortalException.class)
	public void deleteAnswer_WhenExceptionRetrievingTheColumn_ThenThrowsPortalException() throws PortalException {
		when(mockExpandoColumnLocalService.getColumn(COLUMN_ID_1)).thenThrow(new PortalException());

		readinessServiceImpl.deleteAnswer(COLUMN_ID_1, USER_ID);
	}

	@Test(expected = PortalException.class)
	public void deleteAnswer_WhenExceptionDeletingTheValue_ThenThrowsPortalException() throws PortalException {
		when(mockExpandoColumnLocalService.getColumn(COLUMN_ID_1)).thenReturn(mockExpandoColumn);
		when(mockExpandoColumn.getCompanyId()).thenReturn(COMPANY_ID);
		when(mockExpandoColumn.getName()).thenReturn(NAME);
		doThrow(new PortalException()).when(mockExpandoValueLocalService).deleteValue(COMPANY_ID, User.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME, NAME, USER_ID);

		readinessServiceImpl.deleteAnswer(COLUMN_ID_1, USER_ID);
	}

	@Test
	public void getCloseURL_WhenNoError_ThenReturnsTheQuestionnaireCloseURL() throws PortalException {
		String expected = "expectedValue";
		when(mockConfigurationProvider.getCompanyConfiguration(ReadinessInstanceConfiguration.class, COMPANY_ID)).thenReturn(mockReadinessInstanceConfiguration);
		when(mockReadinessInstanceConfiguration.questionnaireCloseURL()).thenReturn(expected);

		String result = readinessServiceImpl.getCloseURL(COMPANY_ID);

		assertThat(result, equalTo(expected));
	}

	@Test(expected = PortalException.class)
	public void getCloseURL_WhenExceptionRetrievingConfiguration_ThenThrowsPortalException() throws PortalException {
		when(mockConfigurationProvider.getCompanyConfiguration(ReadinessInstanceConfiguration.class, COMPANY_ID)).thenThrow(new ConfigurationException());

		readinessServiceImpl.getCloseURL(COMPANY_ID);
	}

	@Test(expected = PortalException.class)
	public void getQuestion_WhenNoQuestionsFound_ThenThrowsPortalException() throws Exception {
		when(mockUser.getCompanyId()).thenReturn(COMPANY_ID);
		when(mockConfigurationProvider.getCompanyConfiguration(ReadinessInstanceConfiguration.class, COMPANY_ID)).thenReturn(mockReadinessInstanceConfiguration);
		when(mockReadinessInstanceConfiguration.questions()).thenReturn(null);

		readinessServiceImpl.getQuestion(COLUMN_ID_1, mockUser);
	}

	@Test(expected = PortalException.class)
	public void getQuestion_WhenNoQuestionFoundWithTheGivenId_ThenThrowsPortalException() throws Exception {
		String[] questions = new String[] { "questionName1=Question title 1", "questionName2=Question title 2", "questionName3=Question title 3" };
		when(mockUser.getCompanyId()).thenReturn(COMPANY_ID);
		when(mockConfigurationProvider.getCompanyConfiguration(ReadinessInstanceConfiguration.class, COMPANY_ID)).thenReturn(mockReadinessInstanceConfiguration);
		when(mockReadinessInstanceConfiguration.questions()).thenReturn(questions);
		mockQuestion("questionName1=Question title 1", COLUMN_ID_1, mockReadinessQuestion1, 0);
		mockQuestion("questionName2=Question title 2", COLUMN_ID_2, mockReadinessQuestion2, 1);
		mockQuestion("questionName3=Question title 3", COLUMN_ID_3, mockReadinessQuestion3, 2);

		readinessServiceImpl.getQuestion(456789456789l, mockUser);
	}

	@Test
	public void getQuestion_WhenQuestionFoundWithTheGivenId_ThenReturnsTheQuestion() throws Exception {
		String[] questions = new String[] { "questionName1=Question title 1", "questionName2=Question title 2", "questionName3=Question title 3" };
		when(mockUser.getCompanyId()).thenReturn(COMPANY_ID);
		when(mockConfigurationProvider.getCompanyConfiguration(ReadinessInstanceConfiguration.class, COMPANY_ID)).thenReturn(mockReadinessInstanceConfiguration);
		when(mockReadinessInstanceConfiguration.questions()).thenReturn(questions);
		mockQuestion("questionName1=Question title 1", COLUMN_ID_1, mockReadinessQuestion1, 0);
		mockQuestion("questionName2=Question title 2", COLUMN_ID_2, mockReadinessQuestion2, 1);
		mockQuestion("questionName3=Question title 3", COLUMN_ID_3, mockReadinessQuestion3, 2);

		ReadinessQuestion result = readinessServiceImpl.getQuestion(COLUMN_ID_2, mockUser);

		assertThat(result, equalTo(mockReadinessQuestion2));
	}

	@Test(expected = PortalException.class)
	public void getQuestions_WhenNoQuestionsFound_ThenThrowsPortalException() throws Exception {
		when(mockUser.getCompanyId()).thenReturn(COMPANY_ID);
		when(mockConfigurationProvider.getCompanyConfiguration(ReadinessInstanceConfiguration.class, COMPANY_ID)).thenReturn(mockReadinessInstanceConfiguration);
		when(mockReadinessInstanceConfiguration.questions()).thenReturn(null);

		readinessServiceImpl.getQuestions(mockUser);
	}

	@Test(expected = PortalException.class)
	public void getQuestions_WhenNoQuestionConfigured_ThenThrowsPortalException() throws Exception {
		when(mockUser.getCompanyId()).thenReturn(COMPANY_ID);
		when(mockConfigurationProvider.getCompanyConfiguration(ReadinessInstanceConfiguration.class, COMPANY_ID)).thenReturn(mockReadinessInstanceConfiguration);
		when(mockReadinessInstanceConfiguration.questions()).thenReturn(new String[0]);

		readinessServiceImpl.getQuestions(mockUser);
	}

	@Test(expected = PortalException.class)
	public void getQuestions_WhenQuestionConfiguredWithEmptyValue_ThenThrowsPortalException() throws Exception {
		when(mockUser.getCompanyId()).thenReturn(COMPANY_ID);
		when(mockConfigurationProvider.getCompanyConfiguration(ReadinessInstanceConfiguration.class, COMPANY_ID)).thenReturn(mockReadinessInstanceConfiguration);
		when(mockReadinessInstanceConfiguration.questions()).thenReturn(new String[] { StringPool.BLANK });

		readinessServiceImpl.getQuestions(mockUser);
	}

	@Test
	public void getQuestions_WhenQuestionsConfigured_ThenReturnsTheQuestions() throws Exception {
		String[] questions = new String[] { "questionName1=Question title 1", "questionName2=Question title 2", "questionName3=Question title 3" };
		when(mockUser.getCompanyId()).thenReturn(COMPANY_ID);
		when(mockConfigurationProvider.getCompanyConfiguration(ReadinessInstanceConfiguration.class, COMPANY_ID)).thenReturn(mockReadinessInstanceConfiguration);
		when(mockReadinessInstanceConfiguration.questions()).thenReturn(questions);
		mockQuestion("questionName1=Question title 1", COLUMN_ID_1, mockReadinessQuestion1, 0);
		mockQuestion("questionName2=Question title 2", COLUMN_ID_2, mockReadinessQuestion2, 1);
		mockQuestion("questionName3=Question title 3", COLUMN_ID_3, mockReadinessQuestion3, 2);

		List<ReadinessQuestion> results = readinessServiceImpl.getQuestions(mockUser);

		assertThat(results, contains(mockReadinessQuestion1, mockReadinessQuestion2, mockReadinessQuestion3));
	}

	@Test(expected = PortalException.class)
	public void updateAnswer_WhenExceptionRetrievingColumn_ThenThrowsPortalException() throws PortalException {
		when(mockExpandoColumnLocalService.getColumn(COLUMN_ID_1)).thenThrow(new PortalException());

		readinessServiceImpl.updateAnswer(COLUMN_ID_1, USER_ID, VALUE);
	}

	@Test(expected = PortalException.class)
	public void updateAnswer_WhenValueIsNotAccepted_ThenThrowsPortalException() throws PortalException {
		when(mockExpandoColumnLocalService.getColumn(COLUMN_ID_1)).thenReturn(mockExpandoColumn);
		when(mockExpandoColumn.getDefaultData()).thenReturn("someOther,values");

		readinessServiceImpl.updateAnswer(COLUMN_ID_1, USER_ID, VALUE);
	}

	@Test(expected = PortalException.class)
	public void updateAnswer_WhenValueIsAcceptedAndExceptionUpdatingTheValue_ThenThrowsPortalException() throws PortalException {
		when(mockExpandoColumnLocalService.getColumn(COLUMN_ID_1)).thenReturn(mockExpandoColumn);
		when(mockExpandoColumn.getDefaultData()).thenReturn("someOther,values," + VALUE + ",andAnother one");
		when(mockExpandoColumn.getCompanyId()).thenReturn(COMPANY_ID);
		when(mockExpandoColumn.getName()).thenReturn(NAME);
		when(mockExpandoValueLocalService.addValue(COMPANY_ID, User.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME, NAME, USER_ID, new String[] { VALUE })).thenThrow(new PortalException());

		readinessServiceImpl.updateAnswer(COLUMN_ID_1, USER_ID, VALUE);
	}

	@Test
	public void updateAnswer_WhenValueIsAccepted_ThenUpdatesTheValue() throws PortalException {
		when(mockExpandoColumnLocalService.getColumn(COLUMN_ID_1)).thenReturn(mockExpandoColumn);
		when(mockExpandoColumn.getDefaultData()).thenReturn("someOther,values," + VALUE + ",andAnother one");
		when(mockExpandoColumn.getCompanyId()).thenReturn(COMPANY_ID);
		when(mockExpandoColumn.getName()).thenReturn(NAME);

		readinessServiceImpl.updateAnswer(COLUMN_ID_1, USER_ID, VALUE);

		verify(mockExpandoValueLocalService, times(1)).addValue(COMPANY_ID, User.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME, NAME, USER_ID, new String[] { VALUE });
	}

	@Test
	public void updateAnswer_WhenValueIsEmpty_ThenRemovesValue() throws PortalException {
		when(mockExpandoColumnLocalService.getColumn(COLUMN_ID_1)).thenReturn(mockExpandoColumn);
		when(mockExpandoColumn.getDefaultData()).thenReturn("someOther,values," + VALUE + ",andAnother one");
		when(mockExpandoColumn.getCompanyId()).thenReturn(COMPANY_ID);
		when(mockExpandoColumn.getName()).thenReturn(NAME);

		readinessServiceImpl.updateAnswer(COLUMN_ID_1, USER_ID, StringPool.BLANK);

		verify(mockExpandoValueLocalService, times(1)).deleteValue(COMPANY_ID, User.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME, NAME, USER_ID);
	}

	@Test(expected = PortalException.class)
	public void getQuestionnaire_WhenNoQuestionsFound_ThenThrowsPortalException() throws Exception {
		when(mockConfigurationProvider.getCompanyConfiguration(ReadinessInstanceConfiguration.class, COMPANY_ID)).thenReturn(mockReadinessInstanceConfiguration);
		when(mockReadinessInstanceConfiguration.questions()).thenReturn(null);

		readinessServiceImpl.getQuestionnaire(mockCompany);
	}

	@Test(expected = PortalException.class)
	public void getQuestionnaire_WhenNoQuestionConfigured_ThenThrowsPortalException() throws Exception {
		when(mockUser.getCompanyId()).thenReturn(COMPANY_ID);
		when(mockConfigurationProvider.getCompanyConfiguration(ReadinessInstanceConfiguration.class, COMPANY_ID)).thenReturn(mockReadinessInstanceConfiguration);
		when(mockReadinessInstanceConfiguration.questions()).thenReturn(new String[0]);

		readinessServiceImpl.getQuestionnaire(mockCompany);
	}

	@Test(expected = PortalException.class)
	public void getQuestionnaire_WhenQuestionConfiguredWithEmptyValue_ThenThrowsPortalException() throws Exception {
		when(mockCompany.getCompanyId()).thenReturn(COMPANY_ID);
		when(mockConfigurationProvider.getCompanyConfiguration(ReadinessInstanceConfiguration.class, COMPANY_ID)).thenReturn(mockReadinessInstanceConfiguration);
		when(mockReadinessInstanceConfiguration.questions()).thenReturn(new String[] { StringPool.BLANK });

		readinessServiceImpl.getQuestionnaire(mockCompany);
	}

	@Test
	public void getQuestionnaire_WhenQuestionsConfigured_ThenReturnsTheQuestions() throws Exception {
		String[] questions = new String[] { "questionName1=Question title 1", "questionName2=Question title 2", "questionName3=Question title 3" };
		when(mockCompany.getCompanyId()).thenReturn(COMPANY_ID);
		when(mockConfigurationProvider.getCompanyConfiguration(ReadinessInstanceConfiguration.class, COMPANY_ID)).thenReturn(mockReadinessInstanceConfiguration);
		when(mockReadinessInstanceConfiguration.questions()).thenReturn(questions);
		mockCompanyQuestion("questionName1=Question title 1", COLUMN_ID_1, mockReadinessQuestion1, 0);
		mockCompanyQuestion("questionName2=Question title 2", COLUMN_ID_2, mockReadinessQuestion2, 1);
		mockCompanyQuestion("questionName3=Question title 3", COLUMN_ID_3, mockReadinessQuestion3, 2);

		List<ReadinessQuestion> results = readinessServiceImpl.getQuestionnaire(mockCompany);

		assertThat(results, contains(mockReadinessQuestion1, mockReadinessQuestion2, mockReadinessQuestion3));
	}

	private void mockCompanyQuestion(String questionConfig, long columnId, ReadinessQuestion readinessQuestion, int index) throws PortalException {
		when(mockModelFactoryBuilder.getQuestion(mockCompany, index, questionConfig)).thenReturn(readinessQuestion);
		when(readinessQuestion.getQuestionId()).thenReturn(columnId);
	}

	private void mockQuestion(String questionConfig, long columnId, ReadinessQuestion readinessQuestion, int index) {
		when(mockModelFactoryBuilder.getQuestion(mockUser, index, questionConfig)).thenReturn(readinessQuestion);
		when(readinessQuestion.getQuestionId()).thenReturn(columnId);
	}

}
