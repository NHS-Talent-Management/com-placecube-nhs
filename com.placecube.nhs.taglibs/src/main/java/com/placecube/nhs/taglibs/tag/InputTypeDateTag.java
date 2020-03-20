package com.placecube.nhs.taglibs.tag;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.taglib.util.IncludeTag;
import com.placecube.nhs.taglibs.context.ServletContextUtil;

public class InputTypeDateTag extends IncludeTag {

	private String portletNamespace;
	private String fieldName;
	private String fieldHint;
	private String fieldLabel;
	private Date fieldValue;
	private String errorMessage;
	private boolean hideDay;
	private boolean hideMonth;

	@Override
	public int doStartTag() {
		setAttributeNamespace("nhs-forms-ui:input-date");
		return EVAL_BODY_INCLUDE;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void setFieldHint(String fieldHint) {
		this.fieldHint = fieldHint;
	}

	public void setFieldLabel(String fieldLabel) {
		this.fieldLabel = fieldLabel;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public void setFieldValue(Date fieldValue) {
		this.fieldValue = fieldValue;
	}

	public void setHideDay(boolean hideDay) {
		this.hideDay = hideDay;
	}

	public void setHideMonth(boolean hideMonth) {
		this.hideMonth = hideMonth;
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		super.setPageContext(pageContext);
		setServletContext(ServletContextUtil.getServletContext());
	}

	public void setPortletNamespace(String portletNamespace) {
		this.portletNamespace = portletNamespace;
	}

	@Override
	protected void cleanUp() {
		super.cleanUp();
		portletNamespace = null;
		fieldName = null;
		fieldLabel = null;
		fieldHint = null;
		fieldValue = null;
		errorMessage = null;
		hideDay = false;
		hideMonth = false;
	}

	@Override
	protected String getPage() {
		return "/META-INF/taglibs/nhs-forms-ui/date/view.jsp";
	}

	@Override
	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute("portletNamespace", portletNamespace);
		request.setAttribute("fieldName", fieldName);
		request.setAttribute("fieldLabel", fieldLabel);
		request.setAttribute("fieldHint", fieldHint);
		request.setAttribute("errorMessage", errorMessage);
		request.setAttribute("hideDay", hideDay);
		request.setAttribute("hideMonth", hideMonth);

		if (Validator.isNotNull(fieldValue)) {
			LocalDate localDate = Instant.ofEpochMilli(fieldValue.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
			request.setAttribute("dayValue", localDate.getDayOfMonth());
			request.setAttribute("monthValue", localDate.getMonthValue());
			request.setAttribute("yearValue", localDate.getYear());
		} else {
			request.setAttribute("dayValue", StringPool.BLANK);
			request.setAttribute("monthValue", StringPool.BLANK);
			request.setAttribute("yearValue", StringPool.BLANK);
		}
	}

}
