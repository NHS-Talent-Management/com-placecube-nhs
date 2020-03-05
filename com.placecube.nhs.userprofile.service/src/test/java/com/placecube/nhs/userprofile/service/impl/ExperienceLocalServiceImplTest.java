package com.placecube.nhs.userprofile.service.impl;

import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.model.User;
import com.placecube.nhs.userprofile.model.Experience;
import com.placecube.nhs.userprofile.service.ExperienceLocalService;
import com.placecube.nhs.userprofile.service.persistence.ExperiencePersistence;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(JUnitParamsRunner.class)
public class ExperienceLocalServiceImplTest extends PowerMockito {

	@InjectMocks
	private ExperienceLocalServiceImpl experienceLocalServiceImpl;

	@Mock
	private ExperienceLocalService mockExperienceLocalService;

	@Mock
	private Experience mockExperience1;

	@Mock
	private Experience mockExperience2;

	@Mock
	private CounterLocalService mockCounterLocalService;

	@Mock
	private ExperiencePersistence mockExperiencePersistence;

	@Mock
	private User mockUser;

	@Mock
	private Date mockDateFrom;

	@Mock
	private Date mockDateTo;

	@Test
	@Parameters({ "true", "false" })
	public void createExperience_WhenNoError_ThenReturnsTheAddedExperience(boolean current) {
		long nextId = 123l;
		when(mockCounterLocalService.increment(Experience.class.getName(), 1)).thenReturn(nextId);
		when(mockExperienceLocalService.createExperience(nextId)).thenReturn(mockExperience1);
		when(mockExperienceLocalService.addExperience(mockExperience1)).thenReturn(mockExperience2);

		Experience result = experienceLocalServiceImpl.createExperience(mockUser, "placeOfWorkValue", "roleValue", current, mockDateFrom, mockDateTo);

		assertThat(result, sameInstance(mockExperience2));
	}

	@Test
	@Parameters({ "true", "false" })
	public void createExperience_WhenNoError_ThenConfiguresTheExperience(boolean current) {
		long nextId = 123l;
		long userId = 456;
		String userName = "userNameValue";
		when(mockUser.getFullName()).thenReturn(userName);
		when(mockUser.getUserId()).thenReturn(userId);
		when(mockCounterLocalService.increment(Experience.class.getName(), 1)).thenReturn(nextId);
		when(mockExperienceLocalService.createExperience(nextId)).thenReturn(mockExperience1);

		experienceLocalServiceImpl.createExperience(mockUser, "placeOfWorkValue", "roleValue", current, mockDateFrom, mockDateTo);

		InOrder inOrder = Mockito.inOrder(mockExperience1, mockExperienceLocalService);
		inOrder.verify(mockExperience1, times(1)).setUserId(userId);
		inOrder.verify(mockExperience1, times(1)).setUserName(userName);
		inOrder.verify(mockExperience1, times(1)).setPlaceOfWork("placeOfWorkValue");
		inOrder.verify(mockExperience1, times(1)).setRole("roleValue");
		inOrder.verify(mockExperience1, times(1)).setCurrent(current);
		inOrder.verify(mockExperience1, times(1)).setFromDate(mockDateFrom);
		inOrder.verify(mockExperience1, times(1)).setToDate(mockDateTo);
		inOrder.verify(mockExperienceLocalService, times(1)).addExperience(mockExperience1);
	}

	@Test
	public void getExperiences_WhenNoError_ThenReturnsExperiencesForTheUser() {
		long userId = 123;
		List<Experience> experiences = new ArrayList<>();
		experiences.add(mockExperience1);
		experiences.add(mockExperience2);
		when(mockExperiencePersistence.findByUserId(userId)).thenReturn(experiences);

		List<Experience> results = experienceLocalServiceImpl.getExperiences(userId);

		assertThat(results, sameInstance(experiences));
	}
}
