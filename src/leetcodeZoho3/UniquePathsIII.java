package leetcodeZoho3;

public class UniquePathsIII {
	private int totalPaths = 0;
	private int emptySquares = 0;
	private int startX, startY;

	public int uniquePathsIII(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;

		// Count the total number of empty squares and find the start point
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (grid[r][c] == 0) {
					emptySquares++;
				} else if (grid[r][c] == 1) {
					startX = r;
					startY = c;
				}
			}
		}

		// Start the DFS from the starting point
		dfs(grid, startX, startY, -1); // Start with -1 since the start square is not empty

		return totalPaths;
	}

	private void dfs(int[][] grid, int x, int y, int count) {
		// Base cases
		if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == -1) {
			return; // Out of bounds or hit an obstacle
		}

		if (grid[x][y] == 2) { // Reached the end point
			if (count == emptySquares) { // Check if we've visited all empty squares
				totalPaths++;
			}
			return;
		}

		// Mark the square as visited by setting it to -1
		int temp = grid[x][y];
		grid[x][y] = -1;

		// Explore all 4 possible directions (up, down, left, right)
		dfs(grid, x + 1, y, count + 1);
		dfs(grid, x - 1, y, count + 1);
		dfs(grid, x, y + 1, count + 1);
		dfs(grid, x, y - 1, count + 1);

		// Backtrack: Unmark the square
		grid[x][y] = temp;
	}

	public static void main(String[] args) {
		UniquePathsIII solution = new UniquePathsIII();
		int[][] grid = { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 2, -1 } };
		System.out.println(solution.uniquePathsIII(grid)); // Output: 2
	}
}
