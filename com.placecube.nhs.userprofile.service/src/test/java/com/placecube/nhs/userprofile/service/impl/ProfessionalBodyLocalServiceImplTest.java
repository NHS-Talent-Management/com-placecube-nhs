package com.placecube.nhs.userprofile.service.impl;

import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.model.User;
import com.placecube.nhs.userprofile.model.ProfessionalBody;
import com.placecube.nhs.userprofile.service.ProfessionalBodyLocalService;
import com.placecube.nhs.userprofile.service.persistence.ProfessionalBodyPersistence;

public class ProfessionalBodyLocalServiceImplTest extends PowerMockito {

	@InjectMocks
	private ProfessionalBodyLocalServiceImpl professionalBodyLocalServiceImpl;

	@Mock
	private ProfessionalBodyLocalService mockProfessionalBodyLocalService;

	@Mock
	private ProfessionalBody mockProfessionalBody1;

	@Mock
	private ProfessionalBody mockProfessionalBody2;

	@Mock
	private CounterLocalService mockCounterLocalService;

	@Mock
	private ProfessionalBodyPersistence mockProfessionalBodyPersistence;

	@Mock
	private User mockUser;

	@Mock
	private Date mockDateLastUpdate;

	@Mock
	private Date mockDateRevalidation;

	@Before
	public void setUp() {
		initMocks(this);
	}

	@Test
	public void createProfessionalBody_WhenNoError_ThenReturnsTheAddedProfessionalBody() {
		long nextId = 123l;
		when(mockCounterLocalService.increment(ProfessionalBody.class.getName(), 1)).thenReturn(nextId);
		when(mockProfessionalBodyLocalService.createProfessionalBody(nextId)).thenReturn(mockProfessionalBody1);
		when(mockProfessionalBodyLocalService.addProfessionalBody(mockProfessionalBody1)).thenReturn(mockProfessionalBody2);

		ProfessionalBody result = professionalBodyLocalServiceImpl.createProfessionalBody(mockUser, "titleValue", "registrationNumberValue", mockDateLastUpdate, mockDateRevalidation);

		assertThat(result, sameInstance(mockProfessionalBody2));
	}

	@Test
	public void createProfessionalBody_WhenNoError_ThenConfiguresTheProfessionalBody() {
		long nextId = 123l;
		long userId = 456;
		String userName = "userNameValue";
		when(mockUser.getFullName()).thenReturn(userName);
		when(mockUser.getUserId()).thenReturn(userId);
		when(mockCounterLocalService.increment(ProfessionalBody.class.getName(), 1)).thenReturn(nextId);
		when(mockProfessionalBodyLocalService.createProfessionalBody(nextId)).thenReturn(mockProfessionalBody1);

		professionalBodyLocalServiceImpl.createProfessionalBody(mockUser, "titleValue", "registrationNumberValue", mockDateLastUpdate, mockDateRevalidation);

		InOrder inOrder = Mockito.inOrder(mockProfessionalBody1, mockProfessionalBodyLocalService);
		inOrder.verify(mockProfessionalBody1, times(1)).setUserId(userId);
		inOrder.verify(mockProfessionalBody1, times(1)).setUserName(userName);
		inOrder.verify(mockProfessionalBody1, times(1)).setTitle("titleValue");
		inOrder.verify(mockProfessionalBody1, times(1)).setRegistrationNumber("registrationNumberValue");
		inOrder.verify(mockProfessionalBody1, times(1)).setLastUpdateDate(mockDateLastUpdate);
		inOrder.verify(mockProfessionalBody1, times(1)).setRevalidationDate(mockDateRevalidation);
		inOrder.verify(mockProfessionalBodyLocalService, times(1)).addProfessionalBody(mockProfessionalBody1);
	}

	@Test
	public void getProfessionalBodies_WhenNoError_ThenReturnsProfessionalBodiesForTheUser() {
		long userId = 123;
		List<ProfessionalBody> professionalBodys = new ArrayList<>();
		professionalBodys.add(mockProfessionalBody1);
		professionalBodys.add(mockProfessionalBody2);
		when(mockProfessionalBodyPersistence.findByUserId(userId)).thenReturn(professionalBodys);

		List<ProfessionalBody> results = professionalBodyLocalServiceImpl.getProfessionalBodies(userId);

		assertThat(results, sameInstance(professionalBodys));
	}

}
