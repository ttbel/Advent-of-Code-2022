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
		} else if (shapePair.getLeft().equals(Shape.PAPER) && shapePair.getRight().equals(Shape.SCISSORS)) {
			return RoundOutcome.WON;
		} else if (shapePair.getLeft().equals(Shape.SCISSORS) && shapePair.getRight().equals(Shape.ROCK)) {
			return RoundOutcome.WON;
		}
		return RoundOutcome.LOST;
	}

	public Long computeAnotherRoundsOutcomesSum(List<String> list) {

		Long sum = 0L;
		for (String round : list) {
			final String[] e = round.split(" ");
			Long result = computeSingleRoundResultV2(e);
			sum += result;
		}

		return sum;
	}

	private Long computeSingleRoundResultV2(String[] e) {

		Long result = 0L;

		final Pair<Shape, RoundOutcome> pair = decodeShapesAndROundOutcome(e);
		Shape resultShape = computeShapeFromOutcome(pair);
		result += resultShape.value;
		result += pair.getRight().value;
		return result;
	}

	private Pair<Shape, RoundOutcome> decodeShapesAndROundOutcome(String[] e) {

		return Pair.of(decode(e[0]), decodeOutcome(e[1]));
	}

	private Shape computeShapeFromOutcome(Pair<Shape, RoundOutcome> pair) {

		if (pair.getRight().equals(RoundOutcome.DRAW)) {
			return pair.getLeft();
		} else if (pair.getRight().equals(RoundOutcome.WON)) {
			return findWinnerFor(pair.getLeft());
		}
		return findLoserFor(pair.getLeft());
	}

	private Shape findLoserFor(Shape shape) {

		switch (shape) {
		case ROCK:
			return Shape.SCISSORS;
		case PAPER:
			return Shape.ROCK;
		case SCISSORS:
			return Shape.PAPER;
		}
		return null;
	}

	private Shape findWinnerFor(Shape shape) {

		switch (shape) {
		case ROCK:
			return Shape.PAPER;
		case PAPER:
			return Shape.SCISSORS;
		case SCISSORS:
			return Shape.ROCK;
		}
		return null;
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

	private RoundOutcome decodeOutcome(String code) {

		switch (code) {
		case "X":
			return RoundOutcome.LOST;
		case "Y":
			return RoundOutcome.DRAW;
		case "Z":
			return RoundOutcome.WON;
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
