package com.placecube.nhs.userprivacy.search;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.placecube.nhs.userprivacy.constants.UserPrivacyConstants;
import com.placecube.nhs.userprivacy.model.UserPrivacy;
import com.placecube.nhs.userprivacy.service.UserPrivacyLocalService;

@Component(immediate = true, property = "indexer.class.name=com.liferay.portal.kernel.model.User", service = ModelDocumentContributor.class)
public class UserModelDocumentContributor implements ModelDocumentContributor<User> {

	@Reference
	private UserPrivacyLocalService userPrivacyLocalService;

	@Override
	public void contribute(Document document, User user) {
		List<UserPrivacy> userPrivacySettings = userPrivacyLocalService.getByUserId(user.getUserId());

		for (UserPrivacy userPrivacy : userPrivacySettings) {
			String privacyFieldName = UserPrivacyConstants.getPrivacyFieldName(userPrivacy.getFieldId());
			String[] values = StringUtil.split(userPrivacy.getRoleIds(), UserPrivacyConstants.ROLE_IDS_SEPARATOR);
			document.addKeyword(privacyFieldName, values);
		}
	}

}
