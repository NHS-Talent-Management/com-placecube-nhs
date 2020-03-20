package com.placecube.nhs.taglibs.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import com.liferay.taglib.util.IncludeTag;
import com.placecube.nhs.taglibs.context.ServletContextUtil;

public class InputTypeTextTag extends IncludeTag {

	private String portletNamespace;
	private String fieldName;
	private String fieldLabel;
	private String fieldValue;
	private String errorMessage;
	private boolean showAsPassword;

	@Override
	public int doStartTag() {
		setAttributeNamespace("nhs-forms-ui:input-text");
		return EVAL_BODY_INCLUDE;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void setFieldLabel(String fieldLabel) {
		this.fieldLabel = fieldLabel;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		super.setPageContext(pageContext);
		setServletContext(ServletContextUtil.getServletContext());
	}

	public void setPortletNamespace(String portletNamespace) {
		this.portletNamespace = portletNamespace;
	}

	public void setShowAsPassword(boolean showAsPassword) {
		this.showAsPassword = showAsPassword;
	}

	@Override
	protected void cleanUp() {
		super.cleanUp();
		portletNamespace = null;
		fieldName = null;
		fieldLabel = null;
		fieldValue = null;
		errorMessage = null;
		showAsPassword = false;
	}

	@Override
	protected String getPage() {
		return "/META-INF/taglibs/nhs-forms-ui/input-text/view.jsp";
	}

	@Override
	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute("portletNamespace", portletNamespace);
		request.setAttribute("fieldName", fieldName);
		request.setAttribute("fieldLabel", fieldLabel);
		request.setAttribute("fieldValue", fieldValue);
		request.setAttribute("errorMessage", errorMessage);
		request.setAttribute("showAsPassword", showAsPassword);
	}

}
