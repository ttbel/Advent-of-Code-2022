package pl.larks.aoc22.day6;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import pl.larks.aoc22.utils.FileUtils;

class TuningTroubleTest {

	TuningTrouble t = new TuningTrouble();
	FileUtils fu = new FileUtils();

	@Test
	void part1GetEndOfMarkerWhenExample() {

		String ds = "mjqjpqmgbljsphdztnvjfqwrcgsmlb";
		int actual = t.part1GetEndOfMarker(ds);

		assertThat(actual).isEqualTo(7);
	}

	@Test
	void part1GetEndOfMarkerWhenInput() {

		final String fileName = "inputs/day6/d6_1_input.txt";
		List<String> list = fu.loadFileToList(fileName);
		fu.printInputStream(fileName);
		String ds = list.get(0);
		int actual = t.part1GetEndOfMarker(ds);

		assertThat(actual).isEqualTo(1142);
	}
}