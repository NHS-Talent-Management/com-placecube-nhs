package com.placecube.nhs.readiness.web.service;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.portlet.PortletException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.placecube.nhs.readiness.model.ReadinessQuestion;
import com.placecube.nhs.readiness.service.ReadinessService;

public class ReadinessQuestionnaireServiceTest extends PowerMockito {

	@InjectMocks
	private ReadinessQuestionnaireService readinessQuestionnaireService;

	@Mock
	private GroupLocalService mockGroupLocalService;

	@Mock
	private ReadinessService mockreadinessService;

	@Mock
	private ThemeDisplay mockThemeDisplay;

	@Mock
	private Group mockGroup;

	@Mock
	private User mockUser;

	@Mock
	private ReadinessQuestion mockReadinessQuestion1;

	@Mock
	private ReadinessQuestion mockReadinessQuestion2;

	@Before
	public void setUp() {
		initMocks(this);
	}

	@Test(expected = PortletException.class)
	public void getWebContentGroupId_WhenExceptionRetrievingGroup_ThenThrowsPortletException() throws Exception {
		long companyId = 123;
		when(mockThemeDisplay.getCompanyId()).thenReturn(companyId);
		when(mockGroupLocalService.getGroup(companyId, GroupConstants.GUEST)).thenThrow(new PortalException());

		readinessQuestionnaireService.getWebContentGroupId(mockThemeDisplay);
	}

	@Test
	public void getWebContentGroupId_WhenNoError_TheNReturnsTheGuestGroupId() throws Exception {
		long companyId = 123;
		long groupId = 456l;
		when(mockThemeDisplay.getCompanyId()).thenReturn(companyId);
		when(mockGroupLocalService.getGroup(companyId, GroupConstants.GUEST)).thenReturn(mockGroup);
		when(mockGroup.getGroupId()).thenReturn(groupId);

		long result = readinessQuestionnaireService.getWebContentGroupId(mockThemeDisplay);

		assertThat(result, equalTo(groupId));
	}

	@Test(expected = PortletException.class)
	public void getQuestions_WhenExceptionRetrievingQuestions_ThenThrowsPortletException() throws Exception {
		when(mockThemeDisplay.getUser()).thenReturn(mockUser);
		when(mockreadinessService.getQuestions(mockUser)).thenThrow(new PortalException());

		readinessQuestionnaireService.getQuestions(mockThemeDisplay);
	}

	@Test
	public void getQuestions_WhenNoError_ThenReturnsTheQuestionsForTheUser() throws Exception {
		when(mockThemeDisplay.getUser()).thenReturn(mockUser);
		List<ReadinessQuestion> questions = new ArrayList<>();
		questions.add(mockReadinessQuestion1);
		when(mockreadinessService.getQuestions(mockUser)).thenReturn(questions);

		List<ReadinessQuestion> results = readinessQuestionnaireService.getQuestions(mockThemeDisplay);

		assertThat(results, sameInstance(questions));
	}

	@Test
	public void getQuestionWithIndex_WhenQuestionFound_ThenReturnsOptionalWithTheQuestionWithTheMatchingIndex() {
		Integer index1 = 456;
		Integer index2 = 123;
		List<ReadinessQuestion> questions = new ArrayList<>();
		questions.add(mockReadinessQuestion1);
		questions.add(mockReadinessQuestion2);
		when(mockReadinessQuestion1.getIndex()).thenReturn(index1);
		when(mockReadinessQuestion2.getIndex()).thenReturn(index2);

		Optional<ReadinessQuestion> result = readinessQuestionnaireService.getQuestionWithIndex(questions, index2);

		assertThat(result.get(), sameInstance(mockReadinessQuestion2));
	}

	@Test
	public void getQuestionWithIndex_WhenQuestionNotFound_ThenReturnsEmptyOptional() {
		Integer index1 = 456;
		Integer index2 = 123;
		List<ReadinessQuestion> questions = new ArrayList<>();
		questions.add(mockReadinessQuestion1);
		questions.add(mockReadinessQuestion2);
		when(mockReadinessQuestion1.getIndex()).thenReturn(index1);
		when(mockReadinessQuestion2.getIndex()).thenReturn(index2);

		Optional<ReadinessQuestion> result = readinessQuestionnaireService.getQuestionWithIndex(questions, 789456);

		assertThat(result.isPresent(), equalTo(false));
	}

}
