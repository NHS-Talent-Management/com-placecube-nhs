package com.placecube.nhs.taglibs.tag;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import com.liferay.taglib.util.IncludeTag;
import com.placecube.nhs.taglibs.context.ServletContextUtil;

public class SimpleTimeFrameTag extends IncludeTag {

	private Date startDate;
	private Date endDate;
	private String format;

	@Override
	public int doStartTag() {
		setAttributeNamespace("nhs-dates-ui:simpleTimeFrame");
		return EVAL_BODY_INCLUDE;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		super.setPageContext(pageContext);
		setServletContext(ServletContextUtil.getServletContext());
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Override
	protected void cleanUp() {
		super.cleanUp();
		startDate = null;
		endDate = null;
		format = null;
	}

	@Override
	protected String getPage() {
		return "/META-INF/taglibs/nhs-dates-ui/simpleTimeFrame/view.jsp";
	}

	@Override
	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute("startDate", startDate);
		request.setAttribute("endDate", endDate);
		request.setAttribute("format", format);
	}

}
