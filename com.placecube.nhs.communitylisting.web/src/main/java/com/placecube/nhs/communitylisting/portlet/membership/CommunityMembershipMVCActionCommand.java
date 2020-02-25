package com.placecube.nhs.communitylisting.portlet.membership;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.placecube.nhs.communitylisting.constants.MVCCommandKeys;
import com.placecube.nhs.communitylisting.constants.PortletKeys;
import com.placecube.nhs.communitylisting.service.RetrievalService;

@Component(immediate = true, property = { "javax.portlet.name=" + PortletKeys.MEMBERSHIP, "mvc.command.name=" + MVCCommandKeys.UPDATE_MEMBERSHIP }, service = MVCActionCommand.class)

public class CommunityMembershipMVCActionCommand extends BaseMVCActionCommand {

	@Reference
	private GroupLocalService groupLocalService;

	@Reference
	private RetrievalService retrievalService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String cmd = ParamUtil.getString(actionRequest, "cmd");

		long groupId = themeDisplay.getScopeGroupId();
		User user = themeDisplay.getUser();

		boolean isGroupMember = retrievalService.isGroupMember(user, groupId);

		if (isGroupMember && "leave".equals(cmd)) {
			groupLocalService.unsetUserGroups(user.getUserId(), new long[] { groupId });
		} else if (!isGroupMember && "join".equals(cmd)) {
			groupLocalService.addUserGroup(user.getUserId(), groupId);
		}

	}

}
