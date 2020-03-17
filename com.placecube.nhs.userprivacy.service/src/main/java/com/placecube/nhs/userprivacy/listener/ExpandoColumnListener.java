package com.placecube.nhs.userprivacy.listener;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoTable;
import com.liferay.expando.kernel.service.ExpandoTableLocalService;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.User;
import com.placecube.nhs.userprivacy.service.UserPrivacyLocalService;

@Component(immediate = true, service = ModelListener.class)
public class ExpandoColumnListener extends BaseModelListener<ExpandoColumn> {

	private static final Log LOG = LogFactoryUtil.getLog(ExpandoColumnListener.class);

	@Reference
	private ExpandoTableLocalService expandoTableLocalService;

	@Reference
	private UserPrivacyLocalService userPrivacyLocalService;

	@Override
	public void onAfterRemove(ExpandoColumn expandoColumn) throws ModelListenerException {
		try {
			ExpandoTable userExpandoTable = expandoTableLocalService.getDefaultTable(expandoColumn.getCompanyId(), User.class.getName());
			if (userExpandoTable.getTableId() == expandoColumn.getTableId()) {
				String expandoFieldId = "expando__keyword__custom_fields__".concat(expandoColumn.getName());
				userPrivacyLocalService.deleteByFieldId(expandoColumn.getCompanyId(), expandoFieldId);
			}
		} catch (Exception e) {
			LOG.debug(e);
		}
	}

}
