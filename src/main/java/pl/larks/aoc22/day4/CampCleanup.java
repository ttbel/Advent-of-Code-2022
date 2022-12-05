package pl.larks.aoc22.day4;

import static java.lang.Integer.parseInt;

import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

public class CampCleanup {

	public Long p1GetFullyContainSectionsCount(List<String> list) {

		Long fullyContainSectionsCount = 0L;
		fullyContainSectionsCount = list.stream().map(l -> {
					final String[] split = l.split(",");
					Pair pair = Pair.of(split[0], split[1]);
					return pair;
				})
				.map(pair -> Pair.of(new Section(pair.getLeft().toString()), new Section(pair.getRight().toString())))
				.filter(p -> p.getLeft().isFullyContaining(p.getRight()) || p.getRight().isFullyContaining(p.getLeft()))
				.count();

		System.out.println("FullyContainSectionsCount = " + fullyContainSectionsCount);
		return fullyContainSectionsCount;
	}

	public Long p1OverlappingSectionsCount(List<String> list) {

		Long overlappingSectionsCount = 0L;
		overlappingSectionsCount = list.stream().map(l -> {
					final String[] split = l.split(",");
					Pair pair = Pair.of(split[0], split[1]);
					return pair;
				})
				.map(pair -> Pair.of(new Section(pair.getLeft().toString()), new Section(pair.getRight().toString())))
				.peek(p -> System.out.println("p = " + p))
				.peek(p -> System.out.println(
						"r = " + (p.getLeft().isOverlapping(p.getRight()) || p.getRight().isOverlapping(p.getLeft()))))
				.filter(p -> p.getLeft().isOverlapping(p.getRight()) || p.getRight().isOverlapping(p.getLeft()))
				.count();

		System.out.println("OverlappingSectionsCount = " + overlappingSectionsCount);
		return overlappingSectionsCount;
	}

	class Section {

		int from;
		int to;

		public Section(String range) {

			final String[] split = range.split("-");
			this.from = parseInt(split[0]);
			this.to = parseInt(split[1]);
		}

		public boolean isFullyContaining(Section other) {

			return this.from <= other.from && other.to <= this.to;
		}

		public boolean isOverlapping(Section other) {

			return this.from <= other.from && this.to >= other.from;
		}

		@Override public String toString() {

			return "Section{ " + from + "-" + to + " }";
		}
	}
}
