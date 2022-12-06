package pl.larks.aoc22.day5;

import java.util.List;
import java.util.Stack;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import pl.larks.aoc22.utils.FileUtils;

class SupplyStacksTest {

	FileUtils fu = new FileUtils();

	@Test
	void part1WhenExample() {

		final String fileName = "inputs/day5/d5_1_example.txt";
		List<String> list = fu.loadFileToList(fileName);
		fu.printInputStream(fileName);

		SupplyStacks supplyStacks = new SupplyStacks();
		Pair<List<Stack<Character>>, List<Triple<Integer, Integer, Integer>>> inputData = supplyStacks.readInput(list);
		System.out.println("inputData = " + inputData);

		supplyStacks.executeMovements(inputData);
		String topCrates = supplyStacks.getTopCrates(inputData.getLeft());
		System.out.println("topCrates = " + topCrates);
		Assertions.assertThat(topCrates.toString()).isEqualTo("CMZ");
	}

	@Test
	void part1WhenInput() {

		final String fileName = "inputs/day5/d5_1_input.txt";
		List<String> list = fu.loadFileToList(fileName);
		fu.printInputStream(fileName);

		SupplyStacks supplyStacks = new SupplyStacks();
		Pair<List<Stack<Character>>, List<Triple<Integer, Integer, Integer>>> inputData = supplyStacks.readInput(list);
		System.out.println("inputData = " + inputData);

		supplyStacks.executeMovements(inputData);
		String topCrates = supplyStacks.getTopCrates(inputData.getLeft());
		System.out.println("topCrates = " + topCrates);
		Assertions.assertThat(topCrates.toString()).isEqualTo("CFFHVVHNC");
	}

	@Test
	void part2WhenExample() {

		final String fileName = "inputs/day5/d5_1_example.txt";
		List<String> list = fu.loadFileToList(fileName);
		fu.printInputStream(fileName);

		SupplyStacks supplyStacks = new SupplyStacks();
		Pair<List<Stack<Character>>, List<Triple<Integer, Integer, Integer>>> inputData = supplyStacks.readInput(list);
		System.out.println("inputData = " + inputData);

		supplyStacks.executeMovementsAllCratesAtOnce(inputData);
		String topCrates = supplyStacks.getTopCrates(inputData.getLeft());
		System.out.println("topCrates = " + topCrates);
		Assertions.assertThat(topCrates.toString()).isEqualTo("MCD");
	}

	@Test
	void part2WhenInput() {

		final String fileName = "inputs/day5/d5_1_input.txt";
		List<String> list = fu.loadFileToList(fileName);
		fu.printInputStream(fileName);

		SupplyStacks supplyStacks = new SupplyStacks();
		Pair<List<Stack<Character>>, List<Triple<Integer, Integer, Integer>>> inputData = supplyStacks.readInput(list);
		System.out.println("inputData = " + inputData);

		supplyStacks.executeMovementsAllCratesAtOnce(inputData);
		String topCrates = supplyStacks.getTopCrates(inputData.getLeft());
		System.out.println("topCrates = " + topCrates);
		Assertions.assertThat(topCrates.toString()).isEqualTo("FSZWBPTBG");
	}
}