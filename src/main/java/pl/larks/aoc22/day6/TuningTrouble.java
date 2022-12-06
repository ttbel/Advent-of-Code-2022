package pl.larks.aoc22.day6;

public class TuningTrouble {

	int part1GetEndOfMarker(String ds) {

		int marker = 0;
		int i = 0;
		while (!allCharsAreDifferent(ds, i)) {
			i++;
		}
		marker = i + 3 + 1;
		return marker;
	}

	private boolean allCharsAreDifferent(String ds, int i) {

		if (ds.charAt(i) != ds.charAt(i + 1) && ds.charAt(i) != ds.charAt(i + 2) && ds.charAt(i) != ds.charAt(i + 3)
				&& ds.charAt(i + 1) != ds.charAt(i + 2) && ds.charAt(i + 1) != ds.charAt(i + 3)
				&& ds.charAt(i + 2) != ds.charAt(i + 3)) {
			return true;
		}

		return false;
	}
}
