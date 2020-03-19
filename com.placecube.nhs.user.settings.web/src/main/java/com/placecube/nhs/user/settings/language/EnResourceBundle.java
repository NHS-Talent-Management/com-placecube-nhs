package com.placecube.nhs.user.settings.language;

import com.liferay.portal.kernel.language.UTF8Control;
import java.util.Enumeration;
import java.util.ResourceBundle;
import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "language.id=en", "language.id=en_GB", "language.id=en_US", "language.id=en_AU" }, service = ResourceBundle.class)
public class EnResourceBundle extends ResourceBundle {

	private final ResourceBundle resourceBundle = ResourceBundle.getBundle("content.Language", (ResourceBundle.Control) UTF8Control.INSTANCE);

	public Enumeration<String> getKeys() {
		return this.resourceBundle.getKeys();
	}

	protected Object handleGetObject(String key) {
		return this.resourceBundle.getObject(key);
	}
}
