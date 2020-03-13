package com.placecube.nhs.taglibs.tag;

import java.io.Serializable;
import java.util.Arrays;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.taglib.util.IncludeTag;
import com.placecube.nhs.taglibs.context.ServletContextUtil;

public class UserViewExpandoTag extends IncludeTag {

	private String expandoFieldName;
	private String expandoFieldLabel;
	private User user;

	@Override
	public int doStartTag() {
		setAttributeNamespace("nhs-user-ui:view-expando");
		return EVAL_BODY_INCLUDE;
	}

	public void setExpandoFieldLabel(String expandoFieldLabel) {
		this.expandoFieldLabel = expandoFieldLabel;
	}

	public void setExpandoFieldName(String expandoFieldName) {
		this.expandoFieldName = expandoFieldName;
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		super.setPageContext(pageContext);
		setServletContext(ServletContextUtil.getServletContext());
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	protected void cleanUp() {
		super.cleanUp();
		expandoFieldName = null;
		expandoFieldLabel = null;
		user = null;
	}

	@Override
	protected String getPage() {
		return "/META-INF/taglibs/nhs-user-ui/view-expando/view.jsp";
	}

	@Override
	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute("expandoFieldLabel", expandoFieldLabel);
		Serializable expandoValue = user.getExpandoBridge().getAttribute(expandoFieldName, false);
		if (expandoValue instanceof String[]) {
			String[] stringValues = GetterUtil.getStringValues(expandoValue, new String[0]);
			request.setAttribute("expandoFieldValue", Arrays.asList(stringValues).stream().collect(Collectors.joining(StringPool.NEW_LINE)));
		} else if (expandoValue instanceof String) {
			request.setAttribute("expandoFieldValue", GetterUtil.getString(expandoValue));
		}
	}

}
