package com.placecube.nhs.registration.override;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;
import com.placecube.nhs.registration.configuration.RegistrationCompanyConfiguration;
import com.placecube.nhs.registration.constants.OverrideLoginKeys;

@Component(property = { "javax.portlet.name=" + OverrideLoginKeys.FAST_LOGIN_PORTLET_KEY, "javax.portlet.name=" + OverrideLoginKeys.LOGIN_PORTLET_KEY,
		"mvc.command.name=" + OverrideLoginKeys.MVC_COMMAND_NAME, "service.ranking:Integer=100" }, service = MVCRenderCommand.class)
public class LoginMVCRenderCommandOverride implements MVCRenderCommand {

	private static final Log LOG = LogFactoryUtil.getLog(LoginMVCRenderCommandOverride.class);

	private MVCRenderCommand mvcRenderCommand;

	@Reference
	private ConfigurationProvider configurationProvider;

	@Reference
	private GroupLocalService groupLocalService;

	@Reference
	private LayoutLocalService layoutLocalService;

	@Reference
	private Portal portal;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		try {
			long companyId = portal.getCompanyId(renderRequest);
			RegistrationCompanyConfiguration configuration = configurationProvider.getCompanyConfiguration(RegistrationCompanyConfiguration.class, companyId);
			if (Validator.isNotNull(configuration.registrationFullPageURL())) {
				Group guestGroup = groupLocalService.getGroup(companyId, GroupConstants.GUEST);
				Layout friendlyURLLayout = layoutLocalService.getFriendlyURLLayout(guestGroup.getGroupId(), false, configuration.registrationFullPageURL());
				String redirect = portal.getPortalURL(renderRequest).concat(portal.getPathFriendlyURLPublic()).concat(guestGroup.getFriendlyURL()).concat(friendlyURLLayout.getFriendlyURL());
				portal.getHttpServletResponse(renderResponse).sendRedirect(redirect);
				return StringPool.BLANK;
			}
		} catch (Exception e) {
			LOG.error(e);
		}
		return mvcRenderCommand.render(renderRequest, renderResponse);
	}

	@Reference(target = "(&(mvc.command.name=" + OverrideLoginKeys.MVC_COMMAND_NAME + ")(javax.portlet.name=" + OverrideLoginKeys.LOGIN_PORTLET_KEY + ")" + "(javax.portlet.name="
			+ OverrideLoginKeys.FAST_LOGIN_PORTLET_KEY + ")" + "(component.name=" + OverrideLoginKeys.CREATE_ACCOUNT_CLASS_NAME + "))")
	protected void setMvcActionCommand(MVCRenderCommand mvcActionCommand) {
		mvcRenderCommand = mvcActionCommand;
	}

}