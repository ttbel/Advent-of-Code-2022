package pl.larks.aoc22.day4;

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

	class Section {

		int from;
		int to;

		public Section(String range) {

			final String[] split = range.split("-");
			this.from = Integer.parseInt(split[0]);
			this.to = Integer.parseInt(split[1]);
		}

		public boolean isFullyContaining(Section other) {

			return this.from <= other.from && other.to <= this.to;
		}
	}
}
