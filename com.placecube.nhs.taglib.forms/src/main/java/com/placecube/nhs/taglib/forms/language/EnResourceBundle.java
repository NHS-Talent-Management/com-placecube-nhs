package com.placecube.nhs.taglib.forms.language;

import java.util.Enumeration;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.language.UTF8Control;

@Component(immediate = true, property = { "language.id=en", "language.id=en_GB", "language.id=en_US", "language.id=en_AU" }, service = ResourceBundle.class)
public class EnResourceBundle extends ResourceBundle {

	private final ResourceBundle resourceBundle = ResourceBundle.getBundle("content.Language", UTF8Control.INSTANCE);

	@Override
	public Enumeration<String> getKeys() {
		return resourceBundle.getKeys();
	}

	@Override
	protected Object handleGetObject(String key) {
		return resourceBundle.getObject(key);
	}

}