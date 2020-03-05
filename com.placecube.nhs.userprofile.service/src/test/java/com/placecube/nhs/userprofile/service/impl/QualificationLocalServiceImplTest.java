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
import com.placecube.nhs.userprofile.model.Qualification;
import com.placecube.nhs.userprofile.service.QualificationLocalService;
import com.placecube.nhs.userprofile.service.persistence.QualificationPersistence;

public class QualificationLocalServiceImplTest extends PowerMockito {

	@InjectMocks
	private QualificationLocalServiceImpl qualificationLocalServiceImpl;

	@Mock
	private QualificationLocalService mockQualificationLocalService;

	@Mock
	private Qualification mockQualification1;

	@Mock
	private Qualification mockQualification2;

	@Mock
	private CounterLocalService mockCounterLocalService;

	@Mock
	private QualificationPersistence mockQualificationPersistence;

	@Mock
	private User mockUser;

	@Mock
	private Date mockDateFrom;

	@Mock
	private Date mockDateTo;

	@Before
	public void setUp() {
		initMocks(this);
	}

	@Test
	public void createQualification_WhenNoError_ThenReturnsTheAddedQualification() {
		long nextId = 123l;
		when(mockCounterLocalService.increment(Qualification.class.getName(), 1)).thenReturn(nextId);
		when(mockQualificationLocalService.createQualification(nextId)).thenReturn(mockQualification1);
		when(mockQualificationLocalService.addQualification(mockQualification1)).thenReturn(mockQualification2);

		Qualification result = qualificationLocalServiceImpl.createQualification(mockUser, "placeValue", "qualificationValue", mockDateFrom, mockDateTo);

		assertThat(result, sameInstance(mockQualification2));
	}

	@Test
	public void createQualification_WhenNoError_ThenConfiguresTheQualification() {
		long nextId = 123l;
		long userId = 456;
		String userName = "userNameValue";
		when(mockUser.getFullName()).thenReturn(userName);
		when(mockUser.getUserId()).thenReturn(userId);
		when(mockCounterLocalService.increment(Qualification.class.getName(), 1)).thenReturn(nextId);
		when(mockQualificationLocalService.createQualification(nextId)).thenReturn(mockQualification1);

		qualificationLocalServiceImpl.createQualification(mockUser, "placeValue", "qualificationValue", mockDateFrom, mockDateTo);

		InOrder inOrder = Mockito.inOrder(mockQualification1, mockQualificationLocalService);
		inOrder.verify(mockQualification1, times(1)).setUserId(userId);
		inOrder.verify(mockQualification1, times(1)).setUserName(userName);
		inOrder.verify(mockQualification1, times(1)).setPlace("placeValue");
		inOrder.verify(mockQualification1, times(1)).setQualification("qualificationValue");
		inOrder.verify(mockQualification1, times(1)).setFromDate(mockDateFrom);
		inOrder.verify(mockQualification1, times(1)).setToDate(mockDateTo);
		inOrder.verify(mockQualificationLocalService, times(1)).addQualification(mockQualification1);
	}

	@Test
	public void getQualifications_WhenNoError_ThenReturnsQualificationsForTheUser() {
		long userId = 123;
		List<Qualification> qualifications = new ArrayList<>();
		qualifications.add(mockQualification1);
		qualifications.add(mockQualification2);
		when(mockQualificationPersistence.findByUserId(userId)).thenReturn(qualifications);

		List<Qualification> results = qualificationLocalServiceImpl.getQualifications(userId);

		assertThat(results, sameInstance(qualifications));
	}

}
