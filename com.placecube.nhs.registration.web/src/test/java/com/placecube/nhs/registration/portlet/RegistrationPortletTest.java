package com.placecube.nhs.registration.portlet;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;

import java.lang.reflect.Method;
import java.util.Optional;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;

import com.liferay.captcha.util.CaptchaUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.model.PasswordPolicy;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.util.Portal;
import com.placecube.nhs.registration.service.RegistrationService;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ MVCPortlet.class, CaptchaUtil.class })
@PowerMockRunnerDelegate(JUnitParamsRunner.class)
public class RegistrationPortletTest extends PowerMockito {

	private static final Long COMPANY_ID = 11l;
	private static final Long GROUP_ID = 22l;

	@InjectMocks
	private RegistrationPortlet registrationPortlet;

	@Mock
	private RegistrationService mockRegistrationService;

	@Mock
	private GroupLocalService mockGroupLocalService;

	@Mock
	private Portal mockPortal;

	@Mock
	private RenderRequest mockRenderRequest;

	@Mock
	private RenderResponse mockRenderResponse;

	@Mock
	private Group mockGroup;

	@Mock
	private PasswordPolicy mockPasswordPolicy;

	@Before
	public void setUp() throws Exception {
		mockStatic(CaptchaUtil.class);
		mockCallToSuper();
	}

	@Test(expected = PortletException.class)
	public void render_WhenExceptionCheckingAccountCreation_ThenThrowsPortletException() throws Exception {
		doThrow(new PortletException()).when(mockRegistrationService).checkAccountCreationEnabled(mockRenderRequest);

		registrationPortlet.render(mockRenderRequest, mockRenderResponse);
	}

	@Test(expected = PortletException.class)
	public void render_WhenNoErrorCheckingAccountCreationAndExceptionRetrievingGroup_ThenThrowsPortletException() throws Exception {
		when(mockPortal.getCompanyId(mockRenderRequest)).thenReturn(COMPANY_ID);
		when(mockGroupLocalService.getGroup(COMPANY_ID, GroupConstants.GUEST)).thenThrow(new PortalException());

		registrationPortlet.render(mockRenderRequest, mockRenderResponse);
	}

	@Test
	public void render_WhenNoError_ThenSetsWebContentGroupIdAsRequestAttributeAfterCheckingForAccountCreation() throws Exception {
		mockGroupDetails();
		when(mockRegistrationService.getDefaultPasswordPolicy(mockRenderRequest)).thenReturn(Optional.empty());

		registrationPortlet.render(mockRenderRequest, mockRenderResponse);

		InOrder inOrder = inOrder(mockRegistrationService, mockRenderRequest);
		inOrder.verify(mockRegistrationService, times(1)).checkAccountCreationEnabled(mockRenderRequest);
		inOrder.verify(mockRenderRequest, times(1)).setAttribute("webContentGroupId", GROUP_ID);
	}

	@Test
	public void render_WhenNoPasswordPolicyFound_ThenDoesNotSetPasswordPolicyDescriptionAsRequestAttribute() throws Exception {
		mockGroupDetails();
		when(mockRegistrationService.getDefaultPasswordPolicy(mockRenderRequest)).thenReturn(Optional.empty());

		registrationPortlet.render(mockRenderRequest, mockRenderResponse);

		InOrder inOrder = inOrder(mockRegistrationService, mockRenderRequest);
		inOrder.verify(mockRegistrationService, times(1)).checkAccountCreationEnabled(mockRenderRequest);
		inOrder.verify(mockRenderRequest, never()).setAttribute(eq("passwordPolicyDescription"), anyString());
	}

	@Test
	public void render_WhenPasswordPolicyFound_ThenSetsPasswordPolicyDescriptionAsRequestAttribute() throws Exception {
		mockGroupDetails();
		when(mockRegistrationService.getDefaultPasswordPolicy(mockRenderRequest)).thenReturn(Optional.of(mockPasswordPolicy));
		String passwordPolicyDescription = "passwordPolicyDescriptionValue";
		when(mockPasswordPolicy.getDescription()).thenReturn(passwordPolicyDescription);

		registrationPortlet.render(mockRenderRequest, mockRenderResponse);

		InOrder inOrder = inOrder(mockRegistrationService, mockRenderRequest);
		inOrder.verify(mockRegistrationService, times(1)).checkAccountCreationEnabled(mockRenderRequest);
		inOrder.verify(mockRenderRequest, times(1)).setAttribute("passwordPolicyDescription", passwordPolicyDescription);
	}

	@Test
	@Parameters({ "true", "false" })
	public void render_WhenNoError_ThenSetsCaptchaEnabledAsRequestAttribute(boolean captchaEnabled) throws Exception {
		mockGroupDetails();
		when(CaptchaUtil.isEnabled(mockRenderRequest)).thenReturn(captchaEnabled);
		when(mockRegistrationService.getDefaultPasswordPolicy(mockRenderRequest)).thenReturn(Optional.empty());

		registrationPortlet.render(mockRenderRequest, mockRenderResponse);

		InOrder inOrder = inOrder(mockRegistrationService, mockRenderRequest);
		inOrder.verify(mockRegistrationService, times(1)).checkAccountCreationEnabled(mockRenderRequest);
		inOrder.verify(mockRenderRequest, times(1)).setAttribute("captchaEnabled", captchaEnabled);
	}

	@SuppressWarnings("rawtypes")
	private void mockCallToSuper() throws Exception {
		Class[] cArg = new Class[2];
		cArg[0] = RenderRequest.class;
		cArg[1] = RenderResponse.class;
		Method superRenderMethod = MVCPortlet.class.getMethod("render", cArg);
		MemberModifier.suppress(superRenderMethod);
	}

	private void mockGroupDetails() throws PortalException {
		when(mockPortal.getCompanyId(mockRenderRequest)).thenReturn(COMPANY_ID);
		when(mockGroupLocalService.getGroup(COMPANY_ID, GroupConstants.GUEST)).thenReturn(mockGroup);
		when(mockGroup.getGroupId()).thenReturn(GROUP_ID);
	}

}
