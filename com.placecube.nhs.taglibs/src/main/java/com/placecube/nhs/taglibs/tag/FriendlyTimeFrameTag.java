package com.placecube.nhs.taglibs.tag;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.taglib.util.IncludeTag;
import com.placecube.nhs.taglibs.context.ServletContextUtil;

public class FriendlyTimeFrameTag extends IncludeTag {

	private Date startDate;
	private Date endDate;

	@Override
	public int doStartTag() {
		setAttributeNamespace("nhs-dates-ui:friendlyTimeFrame");
		return EVAL_BODY_INCLUDE;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
	}

	@Override
	protected String getPage() {
		return "/META-INF/taglibs/nhs-dates-ui/friendlyTimeFrame/view.jsp";
	}

	@Override
	protected void setAttributes(HttpServletRequest request) {
		LocalDate endLocalDate = Validator.isNull(endDate) ? LocalDate.now() : getLocalDateFromDate(endDate);
		LocalDate startLocalDate = getLocalDateFromDate(startDate);

		Period period = Period.between(startLocalDate, endLocalDate);
		String timeframe = getTimeframeString(request, period);
		request.setAttribute("timeFrame", timeframe);
	}

	private LocalDate getLocalDateFromDate(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	private String getTimeframeString(HttpServletRequest request, Period period) {
		StringBuilder timeFrame = new StringBuilder();
		int years = period.getYears();
		if (years == 1) {
			timeFrame.append(LanguageUtil.format(request, "x-year", 1));
			timeFrame.append(StringPool.SPACE);
		} else if (years > 1) {
			timeFrame.append(LanguageUtil.format(request, "x-years", years));
			timeFrame.append(StringPool.SPACE);
		}

		int months = period.getMonths();
		if (months == 1) {
			timeFrame.append(LanguageUtil.format(request, "x-month", 1));
			timeFrame.append(StringPool.SPACE);
		} else if (months > 1) {
			timeFrame.append(LanguageUtil.format(request, "x-months", months));
			timeFrame.append(StringPool.SPACE);
		}
		return timeFrame.toString().toLowerCase();
	}
}
