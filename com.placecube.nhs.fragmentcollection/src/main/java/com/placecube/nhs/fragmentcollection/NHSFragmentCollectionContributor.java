package com.placecube.nhs.fragmentcollection;

import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.fragment.contributor.BaseFragmentCollectionContributor;
import com.liferay.fragment.contributor.FragmentCollectionContributor;

@Component(service = FragmentCollectionContributor.class)
public class NHSFragmentCollectionContributor extends BaseFragmentCollectionContributor {

	@Reference(target = "(osgi.web.symbolicname=com.placecube.nhs.fragmentcollection)")
	ServletContext servletContext;

	@Override
	public String getFragmentCollectionKey() {
		return "NHS";
	}

	@Override
	public ServletContext getServletContext() {
		return servletContext;
	}

}