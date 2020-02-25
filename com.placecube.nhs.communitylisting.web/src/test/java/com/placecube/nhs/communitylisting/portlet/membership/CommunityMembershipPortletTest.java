package com.placecube.nhs.communitylisting.portlet.membership;

import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.lang.reflect.Method;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.placecube.nhs.communitylisting.service.RetrievalService;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(JUnitParamsRunner.class)
@PrepareForTest({ MVCPortlet.class })
public class CommunityMembershipPortletTest extends PowerMockito {

	@InjectMocks
	private CommunityMembershipPortlet communityMembershipPortlet;

	@Mock
	private RetrievalService mockRetrievalService;

	@Mock
	private RenderRequest mockRenderRequest;

	@Mock
	private RenderResponse mockRenderResponse;

	@Mock
	private ThemeDisplay mockThemeDisplay;

	@Mock
	private User mockUser;

	@Before
	public void setUp() throws Exception {
		mockCallToSuper();
	}

	@Test
	public void render_WhenUserIsNotSignedIn_ThenSetsGuestTrueAsRequestAttribute() throws Exception {
		when(mockRenderRequest.getAttribute(WebKeys.THEME_DISPLAY)).thenReturn(mockThemeDisplay);
		when(mockThemeDisplay.isSignedIn()).thenReturn(false);

		communityMembershipPortlet.render(mockRenderRequest, mockRenderResponse);

		verify(mockRenderRequest, times(1)).setAttribute("isGuest", true);
	}

	@Test
	public void render_WhenUserIsNotSignedIn_ThenDoesNotSetIsSiteMemberRequestAttribute() throws Exception {
		when(mockRenderRequest.getAttribute(WebKeys.THEME_DISPLAY)).thenReturn(mockThemeDisplay);
		when(mockThemeDisplay.isSignedIn()).thenReturn(false);

		communityMembershipPortlet.render(mockRenderRequest, mockRenderResponse);

		verify(mockRenderRequest, times(1)).setAttribute(eq("isGuest"), anyBoolean());
		verifyZeroInteractions(mockRetrievalService);
	}

	@Test
	public void render_WhenUserIsSignedIn_ThenSetsGuestFalseAsRequestAttribute() throws Exception {
		when(mockRenderRequest.getAttribute(WebKeys.THEME_DISPLAY)).thenReturn(mockThemeDisplay);
		when(mockThemeDisplay.isSignedIn()).thenReturn(true);

		communityMembershipPortlet.render(mockRenderRequest, mockRenderResponse);

		verify(mockRenderRequest, times(1)).setAttribute("isGuest", false);
	}

	@Test
	@Parameters({ "true", "false" })
	public void render_WhenUserIsSignedIn_ThenSetsIsSiteMemberAsRequestAttribute(boolean isSiteMember) throws Exception {
		Long groupId = 123l;
		when(mockRenderRequest.getAttribute(WebKeys.THEME_DISPLAY)).thenReturn(mockThemeDisplay);
		when(mockThemeDisplay.isSignedIn()).thenReturn(true);
		when(mockThemeDisplay.getUser()).thenReturn(mockUser);
		when(mockThemeDisplay.getScopeGroupId()).thenReturn(groupId);
		when(mockRetrievalService.isGroupMember(mockUser, groupId)).thenReturn(isSiteMember);

		communityMembershipPortlet.render(mockRenderRequest, mockRenderResponse);

		verify(mockRenderRequest, times(1)).setAttribute("isSiteMember", isSiteMember);
	}

	@SuppressWarnings("rawtypes")
	private void mockCallToSuper() throws Exception {
		Class[] cArg = new Class[2];
		cArg[0] = RenderRequest.class;
		cArg[1] = RenderResponse.class;
		Method superRenderMethod = MVCPortlet.class.getMethod("render", cArg);
		MemberModifier.suppress(superRenderMethod);
	}
}
