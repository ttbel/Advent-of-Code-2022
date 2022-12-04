package pl.larks.aoc22.day3;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import pl.larks.aoc22.utils.FileUtils;

class RucksackReorganizationTest {

	FileUtils fu = new FileUtils();

	@Test
	void part1GetPriorityOfTheItems() {

		RucksackReorganization r = new RucksackReorganization();

		List<String> input = fu.loadFileToList("inputs/day3/d3_1_example.txt");
		final int priorityOfTheItems = r.getPriorityOfTheItems(input);

		assertThat(priorityOfTheItems).isEqualTo(157);
	}
}