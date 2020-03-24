package com.placecube.nhs.taglibs.tag;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import com.liferay.taglib.util.IncludeTag;
import com.placecube.nhs.taglibs.context.ServletContextUtil;
import com.placecube.nhs.taglibs.model.SearchFilter;

public class ActiveFiltersTag extends IncludeTag {

	private String portletNamespace;
	private String updateFilterSearchURL;
	private List<SearchFilter> filtersSelected;

	@Override
	public int doStartTag() {
		setAttributeNamespace("nhs-search-ui:active-filters");
		return EVAL_BODY_INCLUDE;
	}

	public void setFiltersSelected(List<SearchFilter> filtersSelected) {
		this.filtersSelected = filtersSelected;
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
		filtersSelected = new ArrayList<>();
		updateFilterSearchURL = null;
	}

	@Override
	protected String getPage() {
		return "/META-INF/taglibs/nhs-search-ui/active-filters/view.jsp";
	}

	@Override
	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute("showActiveFilters", filtersSelected.stream().filter(SearchFilter::isActive).findFirst().isPresent());
		request.setAttribute("portletNamespace", portletNamespace);
		request.setAttribute("filtersSelected", filtersSelected);
		request.setAttribute("updateFilterSearchURL", updateFilterSearchURL);
	}

}
