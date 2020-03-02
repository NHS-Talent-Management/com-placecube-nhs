package com.placecube.nhs.taglib.forms.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import com.liferay.taglib.util.IncludeTag;
import com.placecube.nhs.taglib.forms.context.ServletContextUtil;

public class TextAreaTag extends IncludeTag {

	private String portletNamespace;
	private String fieldName;
	private String fieldLabel;
	private String fieldValue;
	private String errorMessage;
	private int fieldRows;

	@Override
	protected void cleanUp() {
		super.cleanUp();
		portletNamespace = null;
		fieldName = null;
		fieldLabel = null;
		fieldValue = null;
		errorMessage = null;
		fieldRows = 5;
	}

	@Override
	public int doStartTag() {
		setAttributeNamespace("nhs-forms-ui:textarea");
		return EVAL_BODY_INCLUDE;
	}

	@Override
	protected String getPage() {
		return "/META-INF/taglibs/nhs-forms-ui/textarea/view.jsp";
	}

	@Override
	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute("portletNamespace", portletNamespace);
		request.setAttribute("fieldName", fieldName);
		request.setAttribute("fieldLabel", fieldLabel);
		request.setAttribute("fieldValue", fieldValue);
		request.setAttribute("errorMessage", errorMessage);
		request.setAttribute("fieldRows", fieldRows);
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		super.setPageContext(pageContext);
		setServletContext(ServletContextUtil.getServletContext());
	}

	public void setPortletNamespace(String portletNamespace) {
		this.portletNamespace = portletNamespace;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public void setFieldLabel(String fieldLabel) {
		this.fieldLabel = fieldLabel;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void setFieldRows(int fieldRows) {
		this.fieldRows = fieldRows;
	}

}
