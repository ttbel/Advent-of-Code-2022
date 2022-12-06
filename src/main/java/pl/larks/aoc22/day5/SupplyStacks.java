package pl.larks.aoc22.day5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;

public class SupplyStacks {

	private static List<Triple<Integer, Integer, Integer>> fillMovements(List<String> list, int i) {

		List<Triple<Integer, Integer, Integer>> movements = new ArrayList<>();
		for (i++; i < list.size(); i++) {

			String[] m = list.get(i).split(" ");
			movements.add(Triple.of(Integer.parseInt(m[1]), Integer.parseInt(m[3]), Integer.parseInt(m[5])));
		}
		return movements;
	}

	private static void fillStackFromReversedLists(List<Stack<Character>> stocks) {

		for (int j = 0; j < stocks.size(); j++) {
			Stack<Character> stack = new Stack<>();
			Collections.reverse(stocks.get(j));
			stocks.get(j).stream().forEachOrdered(v -> stack.add(v));
		}
	}

	String part1(List<String> list) {

		final String result = "ABC";

		return result;
	}

	public Pair<List<Stack<Character>>, List<Triple<Integer, Integer, Integer>>> readInput(List<String> list) {

		List<Stack<Character>> stocks = prepareStocks();
		List<Triple<Integer, Integer, Integer>> movements = new ArrayList<>();

		int i;
		for (i = 0; list.get(i).charAt(1) != '1' && !list.get(i).isEmpty() && i < list.size(); i++) {

			extractStockLine(list.get(i), stocks);
		}
		i++;
		movements = fillMovements(list, i);

		fillStackFromReversedLists(stocks);

		return Pair.of(stocks, movements);
	}

	private List<Stack<Character>> prepareStocks() {

		List<Stack<Character>> stocks = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			stocks.add(new Stack<Character>());
		}
		return stocks;
	}

	private void extractStockLine(String s, List<Stack<Character>> stocks) {

		for (int i = 0, y = 1; i < 10 && y < s.length(); i++, y += 4) {
			if (s.charAt(y) != ' ') {
				stocks.get(i).add(s.charAt(y));
			}
		}
	}

	public void executeMovements(Pair<List<Stack<Character>>, List<Triple<Integer, Integer, Integer>>> inputData) {

		final List<Stack<Character>> stacks = inputData.getLeft();
		for (Triple<Integer, Integer, Integer> move : inputData.getRight()) {
			for (int i = 0; i < move.getLeft(); i++) {
				Character crate = stacks.get(move.getMiddle() - 1).pop();
				stacks.get(move.getRight() - 1).push(crate);
			}
		}
	}

	public void executeMovementsAllCratesAtOnce(
			Pair<List<Stack<Character>>, List<Triple<Integer, Integer, Integer>>> inputData) {

		final List<Stack<Character>> stacks = inputData.getLeft();
		for (Triple<Integer, Integer, Integer> move : inputData.getRight()) {
			Stack<Character> temp = new Stack();
			for (int i = 0; i < move.getLeft(); i++) {
				Character crate = stacks.get(move.getMiddle() - 1).pop();
				temp.push(crate);
			}
			System.out.println("stacks before = " + stacks);
			for (int i = 0; !temp.empty(); i++) {
				stacks.get(move.getRight() - 1).push(temp.pop());
			}
			System.out.println("stacks after= " + stacks);
		}
	}

	public String getTopCrates(List<Stack<Character>> left) {

		String topCrates = "";
		for (int i = 0; i < left.size(); i++) {
			if (!left.get(i).isEmpty()) {

				topCrates += left.get(i).pop();
			}
		}
		return topCrates.trim();
	}
}
