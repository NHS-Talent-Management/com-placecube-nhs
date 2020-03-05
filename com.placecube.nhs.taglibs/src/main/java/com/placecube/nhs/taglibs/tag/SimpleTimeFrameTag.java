package com.placecube.nhs.taglibs.tag;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.taglib.util.IncludeTag;
import com.placecube.nhs.taglibs.context.ServletContextUtil;

public class SimpleTimeFrameTag extends IncludeTag {

	private Date startDate;
	private Date endDate;

	@Override
	protected void cleanUp() {
		super.cleanUp();
		startDate = null;
		endDate = null;
	}

	@Override
	public int doStartTag() {
		setAttributeNamespace("nhs-dates-ui:simpleTimeFrame");
		return EVAL_BODY_INCLUDE;
	}

	@Override
	protected String getPage() {
		return "/META-INF/taglibs/nhs-dates-ui/simpleTimeFrame/view.jsp";
	}

	@Override
	protected void setAttributes(HttpServletRequest request) {
		LocalDate endLocalDate = Validator.isNull(endDate) ? LocalDate.now() : getLocalDateFromDate(endDate);
		LocalDate startLocalDate = getLocalDateFromDate(startDate);
		request.setAttribute("timeFrame", LanguageUtil.format(request, "date-from-x-to-x", new String[] { String.valueOf(startLocalDate.getYear()), String.valueOf(endLocalDate.getYear()) }));
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		super.setPageContext(pageContext);
		setServletContext(ServletContextUtil.getServletContext());
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	private LocalDate getLocalDateFromDate(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
}
