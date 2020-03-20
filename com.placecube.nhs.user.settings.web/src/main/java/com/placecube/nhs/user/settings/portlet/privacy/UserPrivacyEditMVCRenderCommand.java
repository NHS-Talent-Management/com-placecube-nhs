package com.placecube.nhs.user.settings.portlet.privacy;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.placecube.nhs.user.settings.constants.MVCCommandKeys;
import com.placecube.nhs.user.settings.constants.PortletKeys;
import com.placecube.nhs.user.settings.constants.UserPrivacyPage;
import com.placecube.nhs.user.settings.service.UserPrivacyService;

@Component(immediate = true, property = { "javax.portlet.name=" + PortletKeys.USER_SETTINGS, "mvc.command.name=" + MVCCommandKeys.USER_PRIVACY_UPDATE }, service = MVCRenderCommand.class)
public class UserPrivacyEditMVCRenderCommand implements MVCRenderCommand {

	@Reference
	private UserPrivacyService userPrivacyService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Company company = themeDisplay.getCompany();
		UserPrivacyPage userPrivacyPage = UserPrivacyPage.valueOf(ParamUtil.getString(renderRequest, "userPrivacyPage"));

		renderRequest.setAttribute("privacySelectedValue", userPrivacyService.getSelectedValue(themeDisplay.getUserId(), userPrivacyPage, company));
		renderRequest.setAttribute("privacyOptions", userPrivacyService.getUserPrivacyOptions(company.getCompanyId()));
		renderRequest.setAttribute("userPrivacyPage", userPrivacyPage);

		return "/user-privacy/edit.jsp";
	}
}
