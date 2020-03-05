package com.placecube.nhs.taglibs.context;

import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import com.placecube.nhs.taglibs.service.AZListingService;

@Component(immediate = true, service = ServletContextUtil.class)
public class ServletContextUtil {

	private static ServletContextUtil instance;

	private AZListingService azListingService;
	private ServletContext servletContext;

	public static final ServletContext getServletContext() {
		return instance.servletContext;
	}

	public static final AZListingService getAZListingService() {
		return instance.azListingService;
	}

	@Activate
	protected void activate() {
		instance = this;
	}

	@Deactivate
	protected void deactivate() {
		instance = null;
	}

	@Reference(target = "(osgi.web.symbolicname=com.placecube.nhs.taglibs)", unbind = "-")
	protected void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	@Reference(unbind = "-")
	protected void setAZListingService(AZListingService azListingService) {
		this.azListingService = azListingService;
	}

}