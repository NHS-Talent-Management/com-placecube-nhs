package com.placecube.nhs.indexer.group.listener;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;

import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistry;
import com.liferay.portal.kernel.search.SearchException;

public class GroupListenerTest extends PowerMockito {

	@InjectMocks
	private GroupListener groupListener;

	@Mock
	private IndexerRegistry mockIndexerRegistry;

	@Mock
	private Group mockGroup;

	@Mock
	private Indexer mockIndexer;

	@Before
	public void setUp() {
		initMocks(this);
	}

	@Test
	public void onAfterRemove_WhenException_ThenNoErrorIsThrown() throws SearchException {
		when(mockIndexerRegistry.getIndexer(Group.class.getName())).thenReturn(mockIndexer);
		doThrow(new SearchException()).when(mockIndexer).delete(mockGroup);

		try {
			groupListener.onAfterRemove(mockGroup);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void onAfterRemove_WhenNoError_ThenRemovesTheDocument() throws SearchException {
		when(mockIndexerRegistry.getIndexer(Group.class.getName())).thenReturn(mockIndexer);

		groupListener.onAfterRemove(mockGroup);

		verify(mockIndexer, times(1)).delete(mockGroup);
	}

}
