package leetcodeZoho6;

import java.util.*;

public class LongestIncreasingPath {
	private static final int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	private static int rows, cols;

	public static void main(String[] args) {
		int[][] matrix = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };

		LongestIncreasingPath lip = new LongestIncreasingPath();
		int result = lip.longestIncreasingPath(matrix);
		System.out.println("Longest Increasing Path Length: " + result);
	}

	public int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;

		rows = matrix.length;
		cols = matrix[0].length;
		int[][] dp = new int[rows][cols];
		int max = 0;

		// Start DFS from every cell
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				max = Math.max(max, dfs(matrix, i, j, dp));
			}
		}
		//System.out.println("Test");

		return max;
	}

	private int dfs(int[][] matrix, int i, int j, int[][] dp) {
		if (dp[i][j] != 0)
			return dp[i][j];

		int max = 1;

		for (int[] dir : directions) {
			int x = i + dir[0], y = j + dir[1];

			if (x >= 0 && x < rows && y >= 0 && y < cols && matrix[x][y] > matrix[i][j]) {
				max = Math.max(max, 1 + dfs(matrix, x, y, dp));
			}
		}

		dp[i][j] = max;
		return max;
	}
}
