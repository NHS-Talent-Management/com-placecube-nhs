package com.placecube.nhs.readiness.model.impl;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.placecube.nhs.readiness.model.ReadinessQuestion;

@RunWith(PowerMockRunner.class)
@PrepareForTest(LanguageUtil.class)
public class ReadinessQuestionImplTest extends PowerMockito {

	private static final int INDEX = 10;
	private static final long COLUMN_ID = 50;
	private static final Locale LOCALE = Locale.CANADA_FRENCH;
	private static final String QUESTION_TITLE = "question Title";
	private static final String NAME = "columnName";
	private static final String LOCALISED_NAME = "column localised Name";
	private static final String USER_ANSWER = "selectedValue";
	private static final String DEFAULT_DATA = "availableValue1,availableValue2";

	@Mock
	private ExpandoColumn mockExpandoColumn;

	@Before
	public void setUp() {
		mockStatic(LanguageUtil.class);
		mockExpandoColumnDetails();
	}

	@Test
	public void init_WhenNoError_ThenSetsQuestionIdWithTheExpandoColumnId() {
		ReadinessQuestion result = ReadinessQuestionImpl.init(mockExpandoColumn, LOCALE, QUESTION_TITLE, INDEX, USER_ANSWER);

		assertThat(result.getQuestionId(), equalTo(COLUMN_ID));
	}

	@Test
	public void init_WhenNoError_ThenSetsQuestionIdWithTheExpandoColumnName() throws PortalException {
		ReadinessQuestion result = ReadinessQuestionImpl.init(mockExpandoColumn, LOCALE, QUESTION_TITLE, INDEX, USER_ANSWER);

		assertThat(result.getQuestionName(), equalTo(NAME));
	}

	@Test
	public void init_WhenNoError_ThenSetsQuestionIdWithTheSearchableExpandoColumnName() throws PortalException {
		ReadinessQuestion result = ReadinessQuestionImpl.init(mockExpandoColumn, LOCALE, QUESTION_TITLE, INDEX, USER_ANSWER);

		assertThat(result.getQuestionSearchableName(), equalTo("expando__keyword__custom_fields__" + NAME));
	}

	@Test
	public void init_WhenNoError_ThenSetsQuestionIdWithTheExpandoColumnAvailableValuesConfigured() {
		ReadinessQuestion result = ReadinessQuestionImpl.init(mockExpandoColumn, LOCALE, QUESTION_TITLE, INDEX, USER_ANSWER);

		assertThat(result.getAvailableAnswers(), equalTo(DEFAULT_DATA.split(StringPool.COMMA)));
	}

	@Test
	public void init_WhenNoError_ThenSetsQuestionIdWithTheExpandoColumnLocalisedName() throws PortalException {
		ReadinessQuestion result = ReadinessQuestionImpl.init(mockExpandoColumn, LOCALE, QUESTION_TITLE, INDEX, USER_ANSWER);

		assertThat(result.getQuestionShortTitle(), equalTo(LOCALISED_NAME));
	}

	@Test
	public void init_WhenNoError_ThenSetsQuestionIdWithTheSpecifiedQuestionTitle() throws PortalException {
		ReadinessQuestion result = ReadinessQuestionImpl.init(mockExpandoColumn, LOCALE, QUESTION_TITLE, INDEX, USER_ANSWER);

		assertThat(result.getQuestionTitle(), equalTo(QUESTION_TITLE));
	}

	@Test
	public void init_WhenNoError_ThenSetsQuestionIdWithTheIndex() throws PortalException {
		ReadinessQuestion result = ReadinessQuestionImpl.init(mockExpandoColumn, LOCALE, QUESTION_TITLE, INDEX, USER_ANSWER);

		assertThat(result.getIndex(), equalTo(INDEX));
	}

	@Test
	public void init_WhenNoError_ThenSetsQuestionIdWithTheUserAnswerConfiguredWithEmptyString() throws PortalException {
		ReadinessQuestion result = ReadinessQuestionImpl.init(mockExpandoColumn, LOCALE, QUESTION_TITLE, INDEX, USER_ANSWER);

		assertThat(result.getUserAnswer(), equalTo(StringPool.BLANK));
	}

	private void mockExpandoColumnDetails() {
		when(mockExpandoColumn.getColumnId()).thenReturn(COLUMN_ID);
		when(mockExpandoColumn.getName()).thenReturn(NAME);
		when(LanguageUtil.get(LOCALE, NAME)).thenReturn(LOCALISED_NAME);
		when(mockExpandoColumn.getDefaultData()).thenReturn(DEFAULT_DATA);
	}
}
