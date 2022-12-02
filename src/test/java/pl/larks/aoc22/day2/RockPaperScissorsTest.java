package pl.larks.aoc22.day2;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import pl.larks.aoc22.utils.FileUtils;

class RockPaperScissorsTest {

	FileUtils fu = new FileUtils();

	@Test
	void Part1ComputeRoundsOutcomesSumWhenExampleFile() {

		RockPaperScissors rps = new RockPaperScissors();
		final String fileName = "inputs/day2/d2_1_example.txt";
		fu.printInputStream(fileName);

		final List<String> list = fu.loadFileToList(fileName);

		final Long outcomesSum = rps.computeRoundsOutcomesSum(list);
		System.out.println("outcomesSum = " + outcomesSum);

		Assertions.assertThat(outcomesSum).isEqualTo(15);
	}

	@Test
	void Part1ComputeRoundsOutcomesSumWhenInputFile() {

		RockPaperScissors rps = new RockPaperScissors();
		final String fileName = "inputs/day2/d2_1_input.txt";

		final List<String> list = fu.loadFileToList(fileName);

		final Long outcomesSum = rps.computeRoundsOutcomesSum(list);
		System.out.println("outcomesSum = " + outcomesSum);

		Assertions.assertThat(outcomesSum).isEqualTo(12645L);
	}

	@Test
	void Part2ComputeRoundsOutcomesSumWhenExampleFile() {

		RockPaperScissors rps = new RockPaperScissors();
		final String fileName = "inputs/day2/d2_1_example.txt";
		fu.printInputStream(fileName);

		final List<String> list = fu.loadFileToList(fileName);

		final Long outcomesSum = rps.computeAnotherRoundsOutcomesSum(list);
		System.out.println("outcomesSum = " + outcomesSum);

		Assertions.assertThat(outcomesSum).isEqualTo(12);
	}

	@Test
	void Part2ComputeRoundsOutcomesSumWhenInputFile() {

		RockPaperScissors rps = new RockPaperScissors();
		final String fileName = "inputs/day2/d2_1_input.txt";

		final List<String> list = fu.loadFileToList(fileName);

		final Long outcomesSum = rps.computeAnotherRoundsOutcomesSum(list);
		System.out.println("outcomesSum = " + outcomesSum);

		Assertions.assertThat(outcomesSum).isEqualTo(11756);
	}
}