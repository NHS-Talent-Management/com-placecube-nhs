package com.placecube.nhs.taglib.az.tag;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import com.liferay.taglib.util.IncludeTag;
import com.placecube.nhs.taglib.az.context.ServletContextUtil;
import com.placecube.nhs.taglib.az.model.AZEntry;
import com.placecube.nhs.taglib.az.service.AZListingService;

public class AZListingTag extends IncludeTag {

	private String portletNamespace;
	private String noValuesFoundMessage;
	private List<AZEntry> items;

	@Override
	protected void cleanUp() {
		super.cleanUp();
		portletNamespace = null;
		noValuesFoundMessage = null;
		items = new ArrayList<>();
	}

	@Override
	public int doStartTag() {
		setAttributeNamespace("nhs-az-ui:azListing");
		return EVAL_BODY_INCLUDE;
	}

	@Override
	protected String getPage() {
		return "/META-INF/taglibs/nhs-az-ui/listing/view.jsp";
	}

	@Override
	protected void setAttributes(HttpServletRequest request) {
		AZListingService azListingService = ServletContextUtil.getAZListingService();

		Map<String, List<AZEntry>> results = azListingService.initializeMapAtoZ();
		azListingService.populateMapWithEntries(results, items);

		request.setAttribute("portletNamespace", portletNamespace);
		request.setAttribute("noValuesFoundMessage", noValuesFoundMessage);
		request.setAttribute("azListingItems", results);
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		super.setPageContext(pageContext);
		setServletContext(ServletContextUtil.getServletContext());
	}

	public void setPortletNamespace(String portletNamespace) {
		this.portletNamespace = portletNamespace;
	}

	public void setNoValuesFoundMessage(String noValuesFoundMessage) {
		this.noValuesFoundMessage = noValuesFoundMessage;
	}

	public void setItems(List<AZEntry> items) {
		this.items = items;
	}

}
