package com.placecube.nhs.indexer.group.listener;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.search.IndexerRegistry;
import com.liferay.portal.kernel.search.SearchException;

@Component(immediate = true, service = ModelListener.class)
public class GroupListener extends BaseModelListener<Group> {

	private static final Log LOG = LogFactoryUtil.getLog(GroupListener.class);

	@Reference
	private IndexerRegistry indexerRegistry;

	@Override
	public void onAfterRemove(Group group) {
		try {
			indexerRegistry.getIndexer(Group.class.getName()).delete(group);
		} catch (SearchException e) {
			LOG.debug(e);
			LOG.error("Unable to remove group from index  " + e.getMessage());
		}
	}

}
