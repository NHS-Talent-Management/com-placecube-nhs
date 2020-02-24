package com.placecube.nhs.registration.constants;

import com.liferay.portal.kernel.util.PortletKeys;

public final class OverrideLoginKeys {

	public static final String CREATE_ACCOUNT_CLASS_NAME = "com.liferay.login.web.internal.portlet.action.CreateAccountMVCRenderCommand";

	public static final String FAST_LOGIN_PORTLET_KEY = PortletKeys.FAST_LOGIN;

	public static final String LOGIN_PORTLET_KEY = PortletKeys.LOGIN;

	public static final String MVC_COMMAND_NAME = "/login/create_account";

	private OverrideLoginKeys() {
		return;
	}
}
