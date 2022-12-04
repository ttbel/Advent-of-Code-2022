package pl.larks.aoc22.day4;

import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

public class CampCleanup {

	public Long p1GetOverlappingSectionsCount(List<String> list) {

		Long overlappingSectionsCount = 0L;
		overlappingSectionsCount = list.stream().map(l -> {
					final String[] split = l.split(",");
					Pair pair = Pair.of(split[0], split[1]);
					return pair;
				})
				.map(pair -> Pair.of(new Section(pair.getLeft().toString()), new Section(pair.getRight().toString())))
				.filter(p -> p.getLeft().isOverlaping(p.getRight()) || p.getRight().isOverlaping(p.getLeft()))
				.count();

		System.out.println("overlappingSectionsCount = " + overlappingSectionsCount);
		return overlappingSectionsCount;
	}

	class Section {

		int from;
		int to;

		public Section(String range) {

			final String[] split = range.split("-");
			this.from = Integer.parseInt(split[0]);
			this.to = Integer.parseInt(split[1]);
		}

		public boolean isOverlaping(Section other) {

			return this.from <= other.from && other.to <= this.to;
		}
	}
}
