package com.placecube.nhs.taglib.forms.context;

import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = ServletContextUtil.class)
public class ServletContextUtil {

	private static ServletContextUtil instance;

	private ServletContext servletContext;

	public static final ServletContext getServletContext() {
		return instance.servletContext;
	}

	@Activate
	protected void activate() {
		instance = this;
	}

	@Deactivate
	protected void deactivate() {
		instance = null;
	}

	@Reference(target = "(osgi.web.symbolicname=com.placecube.nhs.taglib.forms)", unbind = "-")
	protected void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

}