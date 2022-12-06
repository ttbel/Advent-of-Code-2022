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

	public int part2GetEndOfMessageMarker(String ds) {

		int marker = 0;
		int i = 0;
		while (!all19CharsAreDifferent(ds, i) && i < ds.length() - 18) {
			i++;
		}
		marker = i + 14;
		System.out.println("marker = " + marker + " ds=" + ds);
		return marker;
	}

	private boolean all19CharsAreDifferent(String ds, int i) {

		System.out.println("ds = " + ds);
		for (int k = 0; k < 14; k++) {

			for (int j = 1; j + k < 14; j++) {
				System.out.println(ds.charAt(k) + " - " + ds.charAt(k + j) + "  " + k + " " + j);
				if (ds.charAt(i + k) == ds.charAt(i + k + j)) {
					return false;
				}
			}
		}
		return true;
	}
}
