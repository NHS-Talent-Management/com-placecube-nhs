package com.placecube.nhs.communitylisting.portlet.membership;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.placecube.nhs.communitylisting.service.RetrievalService;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ PropsUtil.class, ParamUtil.class })
public class CommunityMembershipMVCActionCommandTest extends PowerMockito {

	private static final long GROUP_ID = 20;
	private static final long USER_ID = 10;

	@InjectMocks
	private CommunityMembershipMVCActionCommand communityMembershipMVCActionCommand;

	@Mock
	private RetrievalService mockRetrievalService;

	@Mock
	private GroupLocalService mockGroupLocalService;

	@Mock
	private ActionRequest mockActionRequest;

	@Mock
	private ActionResponse mockActionResponse;

	@Mock
	private ThemeDisplay mockThemeDisplay;

	@Mock
	private User mockUser;

	@Before
	public void setUp() {
		mockStatic(PropsUtil.class, ParamUtil.class);
	}

	@Test
	public void doProcessAction_WhenUserIsGroupMemberAndCommandIsNotLeave_ThenNoActionIsPerformed() throws Exception {
		mockDetails("otherCMD", true);

		communityMembershipMVCActionCommand.doProcessAction(mockActionRequest, mockActionResponse);

		verifyZeroInteractions(mockGroupLocalService);
	}

	@Test
	public void doProcessAction_WhenUserIsGroupMemberAndCommandIsLeave_ThenRemovesTheUserFromTheGroup() throws Exception {
		mockDetails("leave", true);

		communityMembershipMVCActionCommand.doProcessAction(mockActionRequest, mockActionResponse);

		verify(mockGroupLocalService, times(1)).unsetUserGroups(USER_ID, new long[] { GROUP_ID });
	}

	@Test
	public void doProcessAction_WhenUserIsNotGroupMemberAndCommandIsNotJoin_ThenNoActionIsPerformed() throws Exception {
		mockDetails("otherCMD", false);

		communityMembershipMVCActionCommand.doProcessAction(mockActionRequest, mockActionResponse);

		verifyZeroInteractions(mockGroupLocalService);
	}

	@Test
	public void doProcessAction_WhenUserIsNotGroupMemberAndCommandIsJoin_ThenAddsTheUserToTheGroup() throws Exception {
		mockDetails("join", false);

		communityMembershipMVCActionCommand.doProcessAction(mockActionRequest, mockActionResponse);

		verify(mockGroupLocalService, times(1)).addUserGroup(USER_ID, GROUP_ID);
	}

	private void mockDetails(String cmd, boolean isGroupMember) {
		when(ParamUtil.getString(mockActionRequest, "cmd")).thenReturn(cmd);
		when(mockActionRequest.getAttribute(WebKeys.THEME_DISPLAY)).thenReturn(mockThemeDisplay);
		when(mockThemeDisplay.getUser()).thenReturn(mockUser);
		when(mockThemeDisplay.getScopeGroupId()).thenReturn(GROUP_ID);
		when(mockRetrievalService.isGroupMember(mockUser, GROUP_ID)).thenReturn(isGroupMember);
		when(mockUser.getUserId()).thenReturn(USER_ID);
	}

}
