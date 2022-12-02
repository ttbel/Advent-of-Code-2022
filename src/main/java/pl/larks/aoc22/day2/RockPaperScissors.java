package pl.larks.aoc22.day2;

import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

public class RockPaperScissors {

	public Long computeRoundsOutcomesSum(List<String> rounds) {

		Long sum = 0L;
		for (String round : rounds) {
			final String[] e = round.split(" ");
			int result = computeResult(e);
			sum += result;
		}

		return sum;
	}

	private int computeResult(String[] e) {

		int result = 0;
		final Pair<Shape, Shape> pair = decodeShapes(e);
		RoundOutcome resultOutcome = computeSingleOutcome(pair);
		result += resultOutcome.value;
		result += pair.getRight().value;
		return result;
	}

	private RoundOutcome computeSingleOutcome(Pair<Shape, Shape> shapePair) {

		if (shapePair.getLeft().equals(shapePair.getRight())) {
			return RoundOutcome.DRAW;
		} else if (shapePair.getLeft().equals(Shape.ROCK) && shapePair.getRight().equals(Shape.PAPER)) {
			return RoundOutcome.WON;
		}else if (shapePair.getLeft().equals(Shape.PAPER) && shapePair.getRight().equals(Shape.SCISSORS)) {
			return RoundOutcome.WON;
		}else if (shapePair.getLeft().equals(Shape.SCISSORS) && shapePair.getRight().equals(Shape.ROCK)) {
			return RoundOutcome.WON;
		}
		return RoundOutcome.LOST;
	}

	private Pair<Shape, Shape> decodeShapes(String[] e) {

		return Pair.of(decode(e[0]), decode(e[1]));
	}

	private Shape decode(String code) {

		switch (code) {
		case "A":
		case "X":
			return Shape.ROCK;
		case "B":
		case "Y":
			return Shape.PAPER;
		case "C":
		case "Z":
			return Shape.SCISSORS;
		}
		return null;
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
