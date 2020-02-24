package com.placecube.nhs.registration.portlet;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;

import com.liferay.captcha.util.CaptchaUtil;
import com.liferay.portal.kernel.model.PasswordPolicy;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.placecube.nhs.registration.service.RegistrationService;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ CaptchaUtil.class })
@PowerMockRunnerDelegate(JUnitParamsRunner.class)
public class RegistrationMVCRenderCommandTest extends PowerMockito {

	private static final Long COMPANY_ID = 11l;

	@InjectMocks
	private RegistrationMVCRenderCommand registrationMVCRenderCommand;

	@Mock
	private RegistrationService mockRegistrationService;

	@Mock
	private RenderRequest mockRenderRequest;

	@Mock
	private RenderResponse mockRenderResponse;

	@Mock
	private PasswordPolicy mockPasswordPolicy;

	@Mock
	private ThemeDisplay mockThemeDisplay;

	@Mock
	private PermissionChecker mockPermissionChecker;

	@Before
	public void setUp() throws Exception {
		mockStatic(CaptchaUtil.class);
	}

	@Test
	public void render_WhenUserIsSignedInAndIsNotCompanyAdmin_ThenDoesNotSetAnyRequestAttribute() throws Exception {
		mockThemeDisplayDetails(true);
		mockCompanyAdminDetails(false);

		registrationMVCRenderCommand.render(mockRenderRequest, mockRenderResponse);

		verify(mockRenderRequest, never()).setAttribute(anyString(), anyString());
	}

	@Test
	public void render_WhenUserIsSignedInAndIsNotCompanyAdmin_ThenReturnsLoggedInView() throws Exception {
		mockThemeDisplayDetails(true);
		mockCompanyAdminDetails(false);

		String result = registrationMVCRenderCommand.render(mockRenderRequest, mockRenderResponse);

		assertThat(result, equalTo("/logged-in-view.jsp"));
	}

	@Test
	@Parameters({ "true,true", "false,true", "false,false" })
	public void render_WhenUserIsNotSignedInOrIsSignedInAndIsCompanyAdminAndNoPasswordPolicyFound_ThenDoesNotSetPasswordPolicyDescriptionAsRequestAttribute(boolean isSignedIn, boolean isAdmin)
			throws Exception {
		mockThemeDisplayDetails(isSignedIn);
		mockCompanyAdminDetails(isAdmin);
		when(mockRegistrationService.getDefaultPasswordPolicy(mockRenderRequest)).thenReturn(Optional.empty());

		registrationMVCRenderCommand.render(mockRenderRequest, mockRenderResponse);

		verify(mockRenderRequest, never()).setAttribute(eq("passwordPolicyDescription"), anyString());
	}

	@Test
	@Parameters({ "true,true", "false,true", "false,false" })
	public void render_WhenUserIsNotSignedOrIsSignedInAndIsCompanyAdminInAndPasswordPolicyFound_ThenSetsPasswordPolicyDescriptionAsRequestAttribute(boolean isSignedIn, boolean isAdmin)
			throws Exception {
		mockThemeDisplayDetails(isSignedIn);
		mockCompanyAdminDetails(isAdmin);
		when(mockRegistrationService.getDefaultPasswordPolicy(mockRenderRequest)).thenReturn(Optional.of(mockPasswordPolicy));
		String passwordPolicyDescription = "passwordPolicyDescriptionValue";
		when(mockPasswordPolicy.getDescription()).thenReturn(passwordPolicyDescription);

		registrationMVCRenderCommand.render(mockRenderRequest, mockRenderResponse);

		verify(mockRenderRequest, times(1)).setAttribute("passwordPolicyDescription", passwordPolicyDescription);
	}

	@Test
	@Parameters({ "true,true,true", "true,true,false", "false,true,true", "false,true,false", "false,false,true", "false,false,false" })
	public void render_WhenUserIsNotSignedInOrIsSignedInAndIsCompanyAdmin_ThenSetsCaptchaEnabledAsRequestAttribute(boolean isSignedIn, boolean isAdmin, boolean captchaEnabled) throws Exception {
		mockThemeDisplayDetails(false);
		when(CaptchaUtil.isEnabled(mockRenderRequest)).thenReturn(captchaEnabled);
		when(mockRegistrationService.getDefaultPasswordPolicy(mockRenderRequest)).thenReturn(Optional.empty());

		registrationMVCRenderCommand.render(mockRenderRequest, mockRenderResponse);

		verify(mockRenderRequest, times(1)).setAttribute("captchaEnabled", captchaEnabled);
	}

	@Test
	@Parameters({ "true,true", "false,true", "false,false" })
	public void render_WhenUserIsNotSignedInOrIsSignedInAndIsCompanyAdmin_ThenReturnsViewJSP(boolean isSignedIn, boolean isAdmin) throws Exception {
		mockThemeDisplayDetails(isSignedIn);
		mockCompanyAdminDetails(isAdmin);
		when(mockRegistrationService.getDefaultPasswordPolicy(mockRenderRequest)).thenReturn(Optional.empty());

		String result = registrationMVCRenderCommand.render(mockRenderRequest, mockRenderResponse);

		assertThat(result, equalTo("/view.jsp"));
	}

	private void mockThemeDisplayDetails(boolean signedIn) {
		when(mockRenderRequest.getAttribute(WebKeys.THEME_DISPLAY)).thenReturn(mockThemeDisplay);
		when(mockThemeDisplay.isSignedIn()).thenReturn(signedIn);
	}

	private void mockCompanyAdminDetails(boolean isAdmin) {
		when(mockThemeDisplay.getPermissionChecker()).thenReturn(mockPermissionChecker);
		when(mockThemeDisplay.getCompanyId()).thenReturn(COMPANY_ID);
		when(mockPermissionChecker.isCompanyAdmin(COMPANY_ID)).thenReturn(isAdmin);
	}
}
