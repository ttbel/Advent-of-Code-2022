package pl.larks.aoc22.day4;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import pl.larks.aoc22.utils.FileUtils;

class CampCleanupTest {

	private final FileUtils fu = new FileUtils();
	private final CampCleanup cc = new CampCleanup();

	@Test
	void p1GetOverlappingSectionsCountWhenExample() {

		final String fileName = "inputs/day4/d4_1_example.txt";
		List<String> list = fu.loadFileToList(fileName);
		fu.printInputStream(fileName);

		Long actual = cc.p1GetOverlappingSectionsCount(list);

		assertThat(actual).isEqualTo(2);
	}

	@Test
	void p1GetOverlappingSectionsCountWhenInput() {

		final String fileName = "inputs/day4/d4_1_input.txt";
		List<String> list = fu.loadFileToList(fileName);
		fu.printInputStream(fileName);

		Long actual = cc.p1GetOverlappingSectionsCount(list);

		assertThat(actual).isEqualTo(534);
	}
}