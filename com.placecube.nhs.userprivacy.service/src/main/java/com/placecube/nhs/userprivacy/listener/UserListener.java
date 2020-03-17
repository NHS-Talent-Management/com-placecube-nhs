package com.placecube.nhs.userprivacy.listener;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.User;
import com.placecube.nhs.userprivacy.service.UserPrivacyLocalService;

@Component(immediate = true, service = ModelListener.class)
public class UserListener extends BaseModelListener<User> {

	@Reference
	private UserPrivacyLocalService userPrivacyLocalService;

	@Override
	public void onAfterRemove(User user) throws ModelListenerException {
		userPrivacyLocalService.deleteByUserId(user.getUserId());
	}

}
