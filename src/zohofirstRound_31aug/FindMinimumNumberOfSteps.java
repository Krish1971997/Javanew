package zohofirstRound_31aug;

import java.util.HashMap;
import java.util.Map;

/*public class FindMinimumNumberOfSteps {

	static int stepsCount = Integer.MAX_VALUE;

	public static void main(String[] args) {
		System.out.println("Dimensions of Dungeon");
		char arr[][] = new char[5][4];
		int arow = 2;
		int acol = 0;
		arr[arow][acol] = 'A';
		int grow = 3;
		int gcol = 3;
		arr[grow][gcol] = 'G';
		findMinimumStep(arr, arow, acol, grow, gcol, 0, false);
		System.out.println(stepsCount);
	}

	private static void findMinimumStep(char[][] arr, int arow, int acol, int grow, int gcol, int steps, boolean b) {
		if (grow == arow && acol == gcol) {
			if (stepsCount > steps)
				stepsCount = steps;
			return;
		}

		if ((!b && grow == arow) || (gcol == acol))
			return;
		if (arow > grow) {
			findMinimumStep(arr, --arow, acol, grow, gcol, ++steps, false);
		} else if (arow < grow)
			findMinimumStep(arr, ++arow, acol, grow, gcol, ++steps, false);

		if (acol > gcol) {
			findMinimumStep(arr, arow, --acol, grow, gcol, ++steps, true);
		} else if (acol < gcol)
			findMinimumStep(arr, arow, ++acol, grow, gcol, ++steps, true);
	}
}
*/

public class FindMinimumNumberOfSteps {

	static int stepsCount = Integer.MAX_VALUE;
	static Map<String, Integer> memo = new HashMap<>();

	public static void main(String[] args) {
		System.out.println("Dimensions of Dungeon");
		char arr[][] = new char[5][4]; // 5x4 grid
		int arow = 1; // Starting row
		int acol = 2; // Starting column
		arr[arow][acol] = 'A'; // Mark starting point
		int grow = 3; // Goal row
		int gcol = 0; // Goal column
		arr[grow][gcol] = 'G'; // Mark goal point

		findMinimumStep(arr, arow, acol, grow, gcol, 0);
		System.out.println("Minimum Steps: " + stepsCount);
	}

	private static void findMinimumStep(char[][] arr, int arow, int acol, int grow, int gcol, int steps) {
		// Base case: If we reach the goal
		if (arow == grow && acol == gcol) {
			stepsCount = Math.min(stepsCount, steps);
			return;
		}

		// Check boundaries (stay within array limits)
		if (arow < 0 || arow >= arr.length || acol < 0 || acol >= arr[0].length) {
			return;
		}

		// If current steps exceed the minimum already found, no need to explore further
		if (steps >= stepsCount) {
			return;
		}

		// Generate a key for memoization
		String key = arow + "," + acol;

		// Memoization: If we've visited this cell with fewer or equal steps, stop
		// exploring
		if (memo.containsKey(key) && memo.get(key) <= steps) {
			return;
		}

		// Save the current state in the memoization map
		memo.put(key, steps);

		// Explore all possible directions (Up, Down, Left, Right)
		findMinimumStep(arr, arow - 1, acol, grow, gcol, steps + 1); // Up
		findMinimumStep(arr, arow + 1, acol, grow, gcol, steps + 1); // Down
		findMinimumStep(arr, arow, acol - 1, grow, gcol, steps + 1); // Left
		findMinimumStep(arr, arow, acol + 1, grow, gcol, steps + 1); // Right
	}
}
