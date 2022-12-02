package pl.larks.aoc22.day1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class CalorieCounting {

	public Long findTheMostCaloriesAndReturnSum(String input) {

		final String[] foods = input.split("\n");
		return findTheMostCaloriesAndReturnSum(List.of(foods));
	}

	public Long findTheMostCaloriesAndReturnSum(List<String> foods) {

		Long max = 0L;
		Long sum = 0L;

		for (String food : foods) {
			if (StringUtils.isEmpty(food)) {
				if (max < sum) {
					max = sum;
				}
				sum = 0L;
			} else {
				sum += Long.parseLong(food);
			}
		}

		return max;
	}

	public Long findThreeTheMostCaloriesAndReturnSum(String input) {

		final String[] foods = input.split("\n");
		Long max;
		Long sum = 0L;
		List<Long> elfsFoodCalories = new ArrayList<>();

		for (String food : foods) {
			if (StringUtils.isEmpty(food)) {
				elfsFoodCalories.add(sum);
				sum = 0L;
			} else {
				sum += Long.parseLong(food);
			}
		}

		elfsFoodCalories.add(sum);

		List<Long> maxList = elfsFoodCalories.stream().sorted(Comparator.reverseOrder()).limit(3)
				.collect(Collectors.toList());
		max = maxList.stream().reduce(0L, Long::sum);
		System.out.println("maxList = " + maxList);
		return max;
	}
}
