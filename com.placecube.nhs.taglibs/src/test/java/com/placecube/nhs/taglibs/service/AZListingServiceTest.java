package com.placecube.nhs.taglibs.service;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

import com.placecube.nhs.taglibs.model.AZEntry;

public class AZListingServiceTest extends PowerMockito {

	@InjectMocks
	private AZListingService azListingService;

	@Mock
	private Map<String, List<AZEntry>> mockEntries;

	@Mock
	private AZEntry mockAZEntry_A;

	@Mock
	private AZEntry mockAZEntry_A2;

	@Mock
	private AZEntry mockAZEntry_B;

	@Mock
	private AZEntry mockAZEntry_C;

	@Mock
	private AZEntry mockAZEntry_C2;

	@Mock
	private List<AZEntry> mockResultsA;

	@Mock
	private List<AZEntry> mockResultsB;

	@Mock
	private List<AZEntry> mockResultsC;

	@Before
	public void setUp() {
		initMocks(this);
	}

	@Test
	public void initializeMapAtoZ_WhenNoError_ThenReturnsAMapWithAtoZKeysAndEmtpyValues() {
		Map<String, List<AZEntry>> results = azListingService.initializeMapAtoZ();

		assertThat(results.keySet(), contains("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"));
		assertThat(results.get("A"), empty());
		assertThat(results.get("B"), empty());
		assertThat(results.get("C"), empty());
		assertThat(results.get("D"), empty());
		assertThat(results.get("E"), empty());
		assertThat(results.get("F"), empty());
		assertThat(results.get("G"), empty());
		assertThat(results.get("H"), empty());
		assertThat(results.get("I"), empty());
		assertThat(results.get("J"), empty());
		assertThat(results.get("K"), empty());
		assertThat(results.get("L"), empty());
		assertThat(results.get("M"), empty());
		assertThat(results.get("N"), empty());
		assertThat(results.get("O"), empty());
		assertThat(results.get("P"), empty());
		assertThat(results.get("Q"), empty());
		assertThat(results.get("R"), empty());
		assertThat(results.get("S"), empty());
		assertThat(results.get("T"), empty());
		assertThat(results.get("U"), empty());
		assertThat(results.get("V"), empty());
		assertThat(results.get("W"), empty());
		assertThat(results.get("U"), empty());
		assertThat(results.get("X"), empty());
		assertThat(results.get("Y"), empty());
		assertThat(results.get("Z"), empty());
	}

	@Test
	public void populateMapWithEntries_WhenEntriesAreNull_ThenNoChangesAreMadeToTheResults() {
		azListingService.populateMapWithEntries(mockEntries, null);

		verifyZeroInteractions(mockEntries);
	}

	@Test
	public void populateMapWithEntries_WhenEntriesAreEmpty_ThenNoChangesAreMadeToTheResults() {
		azListingService.populateMapWithEntries(mockEntries, Collections.emptyList());

		verifyZeroInteractions(mockEntries);
	}

	@Test
	public void populateMapWithEntries_WhenEntriesAreValid_ThenSavesTheEntriesInTheMapBasedOnTheirInitials() {
		List<AZEntry> entries = new ArrayList<>();
		mockEntry(entries, mockAZEntry_A, "a");
		mockEntry(entries, mockAZEntry_A2, "A");
		mockEntry(entries, mockAZEntry_B, "B");
		mockEntry(entries, mockAZEntry_C, "C");
		mockEntry(entries, mockAZEntry_C2, "c");
		when(mockEntries.get("A")).thenReturn(mockResultsA);
		when(mockEntries.get("B")).thenReturn(mockResultsB);
		when(mockEntries.get("C")).thenReturn(mockResultsC);

		azListingService.populateMapWithEntries(mockEntries, entries);

		InOrder inOrder = Mockito.inOrder(mockEntries, mockResultsA, mockResultsB, mockResultsC);
		inOrder.verify(mockResultsA, times(1)).add(mockAZEntry_A);
		inOrder.verify(mockEntries, times(1)).put("A", mockResultsA);
		inOrder.verify(mockResultsA, times(1)).add(mockAZEntry_A2);
		inOrder.verify(mockEntries, times(1)).put("A", mockResultsA);
		inOrder.verify(mockResultsB, times(1)).add(mockAZEntry_B);
		inOrder.verify(mockEntries, times(1)).put("B", mockResultsB);
		inOrder.verify(mockResultsC, times(1)).add(mockAZEntry_C);
		inOrder.verify(mockEntries, times(1)).put("C", mockResultsC);
		inOrder.verify(mockResultsC, times(1)).add(mockAZEntry_C2);
		inOrder.verify(mockEntries, times(1)).put("C", mockResultsC);
	}

	private void mockEntry(List<AZEntry> entries, AZEntry azEntry, String entryInitial) {
		when(azEntry.getInitial()).thenReturn(entryInitial);
		entries.add(azEntry);
	}
}
