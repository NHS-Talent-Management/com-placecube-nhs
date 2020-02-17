package com.placecube.nhs.taglib.az.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.util.Validator;
import com.placecube.nhs.taglib.az.model.AZEntry;

@Component(immediate = true, service = AZListingService.class)
public class AZListingService {

	public Map<String, List<AZEntry>> initializeMapAtoZ() {
		Map<String, List<AZEntry>> results = new TreeMap<>();
		List<Character> collect = IntStream.rangeClosed('A', 'Z').mapToObj(var -> (char) var).collect(Collectors.toList());
		for (Character character : collect) {
			results.put(String.valueOf(character), new LinkedList<>());
		}
		return results;
	}

	public void populateMapWithEntries(Map<String, List<AZEntry>> results, List<AZEntry> entries) {
		if (Validator.isNotNull(entries)) {
			for (AZEntry entry : entries) {
				String initial = entry.getInitial();
				List<AZEntry> communitiesForInitial = results.get(initial);
				communitiesForInitial.add(entry);
				results.put(initial, communitiesForInitial);
			}
		}
	}
}
