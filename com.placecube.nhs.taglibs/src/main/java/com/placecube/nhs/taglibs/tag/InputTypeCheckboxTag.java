package com.placecube.nhs.taglibs.tag;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import com.liferay.taglib.util.IncludeTag;
import com.placecube.nhs.taglibs.context.ServletContextUtil;

public class InputTypeCheckboxTag extends IncludeTag {

	private String portletNamespace;
	private String fieldName;
	private String fieldHint;
	private String fieldLabel;
	private Map<String, String> fieldOptions;
	private String fieldValue;
	private String errorMessage;

	@Override
	protected void cleanUp() {
		super.cleanUp();
		portletNamespace = null;
		fieldOptions = new HashMap<>();
		fieldName = null;
		fieldHint = null;
		fieldLabel = null;
		fieldValue = null;
		errorMessage = null;
	}

	@Override
	public int doStartTag() {
		setAttributeNamespace("nhs-forms-ui:checkbox");
		return EVAL_BODY_INCLUDE;
	}

	@Override
	protected String getPage() {
		return "/META-INF/taglibs/nhs-forms-ui/checkbox/view.jsp";
	}

	@Override
	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute("portletNamespace", portletNamespace);
		request.setAttribute("fieldName", fieldName);
		request.setAttribute("fieldHint", fieldHint);
		request.setAttribute("fieldLabel", fieldLabel);
		request.setAttribute("fieldValue", fieldValue);
		request.setAttribute("errorMessage", errorMessage);
		request.setAttribute("fieldOptions", fieldOptions);
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

	public void setFieldHint(String fieldHint) {
		this.fieldHint = fieldHint;
	}

	public void setFieldLabel(String fieldLabel) {
		this.fieldLabel = fieldLabel;
	}

	public void setFieldOptions(Map<String, String> fieldOptions) {
		this.fieldOptions = fieldOptions;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
