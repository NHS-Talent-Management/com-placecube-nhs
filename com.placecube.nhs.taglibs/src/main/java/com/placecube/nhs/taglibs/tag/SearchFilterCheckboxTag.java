package com.placecube.nhs.taglibs.tag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import com.liferay.taglib.util.IncludeTag;
import com.placecube.nhs.taglibs.context.ServletContextUtil;

public class SearchFilterCheckboxTag extends IncludeTag {

	private String portletNamespace;
	private String fieldName;
	private String fieldLabel;
	private String updateFilterSearchURL;
	private Map<String, String> fieldOptions;
	private List<String> fieldSelectedValues;

	@Override
	public int doStartTag() {
		setAttributeNamespace("nhs-search-ui:filter-checkbox");
		return EVAL_BODY_INCLUDE;
	}

	public void setFieldLabel(String fieldLabel) {
		this.fieldLabel = fieldLabel;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public void setFieldOptions(Map<String, String> fieldOptions) {
		this.fieldOptions = fieldOptions;
	}

	public void setFieldSelectedValues(List<String> fieldSelectedValues) {
		this.fieldSelectedValues = fieldSelectedValues;
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		super.setPageContext(pageContext);
		setServletContext(ServletContextUtil.getServletContext());
	}

	public void setPortletNamespace(String portletNamespace) {
		this.portletNamespace = portletNamespace;
	}

	public void setUpdateFilterSearchURL(String updateFilterSearchURL) {
		this.updateFilterSearchURL = updateFilterSearchURL;
	}

	@Override
	protected void cleanUp() {
		super.cleanUp();
		portletNamespace = null;
		fieldOptions = new HashMap<>();
		fieldName = null;
		fieldSelectedValues = new ArrayList<>();
		fieldLabel = null;
		updateFilterSearchURL = null;
	}

	@Override
	protected String getPage() {
		return "/META-INF/taglibs/nhs-search-ui/filter-checkbox/view.jsp";
	}

	@Override
	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute("portletNamespace", portletNamespace);
		request.setAttribute("fieldName", fieldName);
		request.setAttribute("fieldSelectedValues", fieldSelectedValues);
		request.setAttribute("fieldLabel", fieldLabel);
		request.setAttribute("fieldOptions", fieldOptions);
		request.setAttribute("updateFilterSearchURL", updateFilterSearchURL);
	}

}
