package leetcodeZoho3;

import java.util.*;

public class MinimumPathSum {
	public static void main(String[] args) {
		// Example triangle
		List<List<Integer>> triangle = Arrays.asList(Arrays.asList(2), 
				Arrays.asList(3, 4), Arrays.asList(6, 5, 7),
				Arrays.asList(4, 1, 8, 3));

		int minSum = minimumTotal(triangle);
		System.out.println("Minimum path sum: " + minSum);
	}

	public static int minimumTotal(List<List<Integer>> triangle) {
		int numRows = triangle.size();
		Integer[][] memo = new Integer[numRows][numRows];
		return findMinPath(triangle, 0, 0, memo);
	}

	private static int findMinPath(List<List<Integer>> triangle, int row, int col, Integer[][] memo) {
		// Base case: if we're at the bottom row
		if (row == triangle.size() - 1) {
			return triangle.get(row).get(col);
		}

		// Check if the result is already memoized
		if (memo[row][col] != null) {
			return memo[row][col];
		}

		// Recursive case: move to the next row
		int leftPath = findMinPath(triangle, row + 1, col, memo);
		int rightPath = findMinPath(triangle, row + 1, col + 1, memo);

		// Calculate the minimum path sum for this cell
		memo[row][col] = triangle.get(row).get(col) + Math.min(leftPath, rightPath);
		return memo[row][col];
	}
}
