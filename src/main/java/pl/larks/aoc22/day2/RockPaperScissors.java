package pl.larks.aoc22.day2;

import java.util.List;

public class RockPaperScissors {

	public Long computeRoundsOutcomesSum(List<String> rounds) {

		Long sum = 0L;
		for (String round : rounds) {
			final String[] e = round.split(" ");
		}

		return sum;
	}

	public enum Shape {

		ROCK(1), PAPER(2), SCISSORS(3);

		int value;

		Shape(int value) {

			this.value = value;
		}
	}

	public enum RoundOutcome {
		LOST(0), DRAW(3), WON(6);
		int value;

		RoundOutcome(int value) {

			this.value = value;
		}
	}
}
