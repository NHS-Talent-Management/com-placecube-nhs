package com.placecube.nhs.taglibs.tag;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import com.liferay.taglib.util.IncludeTag;
import com.placecube.nhs.taglibs.context.ServletContextUtil;

public class ErrorSummaryTag extends IncludeTag {

	private String portletNamespace;
	private Map<String, String> errors;

	@Override
	protected void cleanUp() {
		super.cleanUp();
		portletNamespace = null;
		errors = new HashMap<>();
	}

	@Override
	public int doStartTag() {
		setAttributeNamespace("nhs-forms-ui:errorSummary");
		return EVAL_BODY_INCLUDE;
	}

	@Override
	protected String getPage() {
		return "/META-INF/taglibs/nhs-forms-ui/error-summary/view.jsp";
	}

	@Override
	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute("portletNamespace", portletNamespace);
		request.setAttribute("errors", errors);
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		super.setPageContext(pageContext);
		setServletContext(ServletContextUtil.getServletContext());
	}

	public void setPortletNamespace(String portletNamespace) {
		this.portletNamespace = portletNamespace;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

}
