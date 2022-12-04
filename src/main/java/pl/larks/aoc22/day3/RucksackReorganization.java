package pl.larks.aoc22.day3;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class RucksackReorganization {

	int getPriorityOfTheItems(List<String> list) {

		Integer summary = 0;
		for (String rucksack : list) {
			int halfSize = rucksack.length() / 2;
			String r1 = rucksack.substring(0, halfSize);
			String r2 = rucksack.substring(halfSize);
			Set<Character> foundSet = new HashSet<>();

			for (int i = 0; i < r1.length(); i++) {

				Character c = r1.charAt(i);
				if (r2.indexOf(c) != -1) {
					foundSet.add(c);
				}
			}
			final Optional<Integer> priotizeValue = computePriorityzes(foundSet).stream().reduce(Math::addExact);
			summary += priotizeValue.get();
		}

		return summary;
	}

	private Optional<Integer> computePriorityzes(Set<Character> set) {

		return set.stream().map(l -> Character.isUpperCase(l) ? (int) l - (int) 'A' + 27 : (int) l - (int) 'a' + 1)
				.reduce(Math::addExact);
	}
}
