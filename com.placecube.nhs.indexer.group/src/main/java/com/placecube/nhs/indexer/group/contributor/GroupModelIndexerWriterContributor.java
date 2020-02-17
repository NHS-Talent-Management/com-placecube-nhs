package com.placecube.nhs.indexer.group.contributor;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.IndexerWriterMode;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;

@Component(immediate = true, property = "indexer.class.name=com.liferay.portal.kernel.model.Group", service = ModelIndexerWriterContributor.class)
public class GroupModelIndexerWriterContributor implements ModelIndexerWriterContributor<Group> {

	@Reference
	private GroupLocalService groupLocalService;

	@Reference
	private DynamicQueryBatchIndexingActionableFactory dynamicQueryBatchIndexingActionableFactory;

	@Override
	public void customize(BatchIndexingActionable batchIndexingActionable, ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
		batchIndexingActionable.setPerformActionMethod((Group group) -> {
			Document document = modelIndexerWriterDocumentHelper.getDocument(group);
			batchIndexingActionable.addDocuments(document);
		});
	}

	@Override
	public BatchIndexingActionable getBatchIndexingActionable() {
		return dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(groupLocalService.getIndexableActionableDynamicQuery());
	}

	@Override
	public long getCompanyId(Group group) {
		return group.getCompanyId();
	}

	@Override
	public IndexerWriterMode getIndexerWriterMode(Group group) {
		if (group.isActive() && group.isSite() && !group.isOrganization()) {
			return IndexerWriterMode.UPDATE;
		} else if (group.isCompany() || group.isGuest()) {
			return IndexerWriterMode.SKIP;
		} else {
			return IndexerWriterMode.DELETE;
		}
	}

}
