package pl.larks.aoc22.day6;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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

	@ParameterizedTest
	@MethodSource("part2TestsArguments")
	void part2GetEndOfMessageMarkerWhenExample(String ds, int expectedMessageMarker) {

		int actual = t.part2GetEndOfMessageMarker(ds);

		assertThat(actual).isEqualTo(expectedMessageMarker);
	}

	private static Stream<Arguments> part2TestsArguments() {

		return Stream.of(
				Arguments.of("mjqjpqmgbljsphdztnvjfqwrcgsmlb", 19),
				Arguments.of("bvwbjplbgvbhsrlpgdmjqwftvncz", 23),
				Arguments.of("nppdvjthqldpwncqszvftbrmjlhg", 23),
				Arguments.of("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 29),
				Arguments.of("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 26)
		);
	}

	@Test
	void part2GetEndOfMessageMarkerWhenInput() {

		final String fileName = "inputs/day6/d6_1_input.txt";
		List<String> list = fu.loadFileToList(fileName);
		fu.printInputStream(fileName);
		String ds = list.get(0);
		int actual = t.part2GetEndOfMessageMarker(ds);

		assertThat(actual).isEqualTo(2803);
	}
}