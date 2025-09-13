package zProgrammingRound;

public class PathWithMaximumGold {
	private static final int[][] DIRECTIONS = { { -1, 1 }, { 0, 1 }, { 1, 1 } };

	public static void main(String[] args) {
		//int[][] grid = { { 0, 1, 3 }, { 1, 4, 2 }, { 0, 2, 5 } };
		int[][] grid = {
	            {10, 10, 2, 0, 20, 4},
	            {1, 0, 0, 30, 2, 5},
	            {0, 10, 4, 0, 2, 0},
	            {1, 0, 2, 20, 0, 4},
	            {0, 2, 0, 0, 0, 0}
	        };
		PathWithMaximumGold solution = new PathWithMaximumGold();
		int maxgold = solution.getMaximumGold(grid);
		System.out.println("Maximum Gold Collected: " + maxgold);
	}

	public int getMaximumGold(int[][] grid) {
		int maxGold = 0;

		for (int i = 0; i < grid.length; i++) {
			maxGold = Math.max(maxGold, dfs(grid, i, 0));
		}

		return maxGold;
	}

	private int dfs(int[][] grid, int row, int col) {
		if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
			return 0;
		}

		int gold = grid[row][col];
		grid[row][col] = 0;

		int maxGold = 0;
		for (int[] direction : DIRECTIONS) { // modify start
			int newRow = row + direction[0];
			int newCol = col + direction[1];
			maxGold = Math.max(maxGold, dfs(grid, newRow, newCol));
		} // modify

		/**
		 * maxGold = Math.max(maxGold, collectGold(grid, i - 1, j + 1)); // second
		 * method maxGold = Math.max(maxGold, collectGold(grid, i, j + 1)); maxGold =
		 * Math.max(maxGold, collectGold(grid, i + 1, j + 1));
		 */

		grid[row][col] = gold;
		return gold + maxGold;
	}
}
