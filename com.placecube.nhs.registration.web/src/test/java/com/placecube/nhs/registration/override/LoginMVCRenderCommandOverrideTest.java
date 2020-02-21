package com.placecube.nhs.registration.override;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import java.io.IOException;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.util.Portal;
import com.placecube.nhs.registration.configuration.RegistrationCompanyConfiguration;

public class LoginMVCRenderCommandOverrideTest extends PowerMockito {

	private static final Long COMPANY_ID = 22l;
	private static final Long GROUP_ID = 11l;
	private static final String DEFAULT_RENDER_COMMAND_RESULT = "expectedValue";
	private static final String LAYOUT_URL = "LAYOUT_URL";
	private static final String GROUP_URL = "GROUP_URL";
	private static final String PUBLIC_URL = "PUBLIC_URL";
	private static final String PORTAL_URL = "PORTAL_URL";
	private static final String REGISTRATION_URL = "registrationURLValue";

	@InjectMocks
	private LoginMVCRenderCommandOverride loginMVCRenderCommandOverride;

	@Mock
	private ConfigurationProvider mockConfigurationProvider;

	@Mock
	private GroupLocalService mockGroupLocalService;

	@Mock
	private LayoutLocalService mockLayoutLocalService;

	@Mock
	private Portal mockPortal;

	@Mock
	private RenderRequest mockRenderRequest;

	@Mock
	private RenderResponse mockRenderResponse;

	@Mock
	private HttpServletResponse mockHttpServletResponse;

	@Mock
	private MVCRenderCommand mockMVCRenderCommand;

	@Mock
	private Layout mockLayout;

	@Mock
	private RegistrationCompanyConfiguration mockRegistrationCompanyConfiguration;

	@Mock
	private Group mockGroup;

	@Before
	public void setUp() {
		initMocks(this);
		loginMVCRenderCommandOverride.setMvcActionCommand(mockMVCRenderCommand);
	}

	@Test
	public void render_WhenRegistrationURLIsNotValid_ThenReturnsTheDefaultRenderCommand() throws Exception {
		when(mockPortal.getCompanyId(mockRenderRequest)).thenReturn(COMPANY_ID);
		when(mockConfigurationProvider.getCompanyConfiguration(RegistrationCompanyConfiguration.class, COMPANY_ID)).thenReturn(mockRegistrationCompanyConfiguration);
		when(mockRegistrationCompanyConfiguration.registrationFullPageURL()).thenReturn(StringPool.BLANK);
		when(mockMVCRenderCommand.render(mockRenderRequest, mockRenderResponse)).thenReturn(DEFAULT_RENDER_COMMAND_RESULT);

		String result = loginMVCRenderCommandOverride.render(mockRenderRequest, mockRenderResponse);

		assertThat(result, equalTo(DEFAULT_RENDER_COMMAND_RESULT));
	}

	@Test
	public void render_WhenRegistrationURLIsValidAndExceptionRetrievingGuestGroup_ThenReturnsTheDefaultRenderCommand() throws Exception {
		mockValidConfiguration();
		when(mockPortal.getCompanyId(mockRenderRequest)).thenReturn(COMPANY_ID);
		when(mockGroupLocalService.getGroup(COMPANY_ID, GroupConstants.GUEST)).thenThrow(new PortalException());
		when(mockMVCRenderCommand.render(mockRenderRequest, mockRenderResponse)).thenReturn(DEFAULT_RENDER_COMMAND_RESULT);

		String result = loginMVCRenderCommandOverride.render(mockRenderRequest, mockRenderResponse);

		assertThat(result, equalTo(DEFAULT_RENDER_COMMAND_RESULT));
	}

	@Test
	public void render_WhenRegistrationURLIsValidAndExceptionRetrievingLayout_ThenReturnsTheDefaultRenderCommand() throws Exception {
		mockValidConfiguration();
		when(mockPortal.getCompanyId(mockRenderRequest)).thenReturn(COMPANY_ID);
		when(mockGroupLocalService.getGroup(COMPANY_ID, GroupConstants.GUEST)).thenReturn(mockGroup);
		when(mockGroup.getGroupId()).thenReturn(GROUP_ID);
		when(mockLayoutLocalService.getFriendlyURLLayout(GROUP_ID, false, "/create-account")).thenThrow(new PortalException());
		when(mockMVCRenderCommand.render(mockRenderRequest, mockRenderResponse)).thenReturn(DEFAULT_RENDER_COMMAND_RESULT);

		String result = loginMVCRenderCommandOverride.render(mockRenderRequest, mockRenderResponse);

		assertThat(result, equalTo(DEFAULT_RENDER_COMMAND_RESULT));
	}

	@Test
	public void render_WhenRegistrationURLIsValidAndExceptionSendingRedirect_ThenReturnsTheDefaultRenderCommand() throws Exception {
		mockValidConfiguration();
		mockRedirectDetails();
		mockURLs();
		doThrow(new IOException()).when(mockHttpServletResponse).sendRedirect(PORTAL_URL + PUBLIC_URL + GROUP_URL + LAYOUT_URL);
		when(mockMVCRenderCommand.render(mockRenderRequest, mockRenderResponse)).thenReturn(DEFAULT_RENDER_COMMAND_RESULT);

		String result = loginMVCRenderCommandOverride.render(mockRenderRequest, mockRenderResponse);

		assertThat(result, equalTo(DEFAULT_RENDER_COMMAND_RESULT));
	}

	@Test
	public void render_WhenRegistrationURLIsValidAndNoError_ThenSendsRedirectToTheCreateAccountLayout() throws Exception {
		mockValidConfiguration();
		mockRedirectDetails();
		mockURLs();

		loginMVCRenderCommandOverride.render(mockRenderRequest, mockRenderResponse);

		verify(mockHttpServletResponse, times(1)).sendRedirect(PORTAL_URL + PUBLIC_URL + GROUP_URL + LAYOUT_URL);
	}

	@Test
	public void render_WhenNoError_ThenReturnsEmptyString() throws Exception {
		mockValidConfiguration();
		mockRedirectDetails();
		mockURLs();

		String result = loginMVCRenderCommandOverride.render(mockRenderRequest, mockRenderResponse);

		assertThat(result, equalTo(StringPool.BLANK));
	}

	private void mockRedirectDetails() throws PortalException {
		when(mockPortal.getCompanyId(mockRenderRequest)).thenReturn(COMPANY_ID);
		when(mockGroupLocalService.getGroup(COMPANY_ID, GroupConstants.GUEST)).thenReturn(mockGroup);
		when(mockGroup.getGroupId()).thenReturn(GROUP_ID);
		when(mockLayoutLocalService.getFriendlyURLLayout(GROUP_ID, false, REGISTRATION_URL)).thenReturn(mockLayout);
	}

	private void mockURLs() {
		when(mockPortal.getPortalURL(mockRenderRequest)).thenReturn(PORTAL_URL);
		when(mockPortal.getPathFriendlyURLPublic()).thenReturn(PUBLIC_URL);
		when(mockGroup.getFriendlyURL()).thenReturn(GROUP_URL);
		when(mockLayout.getFriendlyURL()).thenReturn(LAYOUT_URL);
		when(mockPortal.getHttpServletResponse(mockRenderResponse)).thenReturn(mockHttpServletResponse);
	}

	private void mockValidConfiguration() throws ConfigurationException {
		when(mockConfigurationProvider.getCompanyConfiguration(RegistrationCompanyConfiguration.class, COMPANY_ID)).thenReturn(mockRegistrationCompanyConfiguration);
		when(mockRegistrationCompanyConfiguration.registrationFullPageURL()).thenReturn(REGISTRATION_URL);
	}
}
