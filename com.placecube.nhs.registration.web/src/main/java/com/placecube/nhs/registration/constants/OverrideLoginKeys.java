package com.placecube.nhs.registration.constants;

public final class OverrideLoginKeys {

	public static final String CREATE_ACCOUNT_CLASS_NAME = "com.liferay.login.web.internal.portlet.action.CreateAccountMVCRenderCommand";

	public static final String FAST_LOGIN_PORTLET_KEY = "com_liferay_login_web_portlet_FastLoginPortlet";

	public static final String LOGIN_PORTLET_KEY = "com_liferay_login_web_portlet_LoginPortlet";

	public static final String MVC_COMMAND_NAME = "/login/create_account";

	private OverrideLoginKeys() {
		return;
	}
}
