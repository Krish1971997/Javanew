package leetcodeZoho5_dp;

//Working
public class NumberOfIslands {
	public static void main(String[] args) {
		char[][] grid = { { '1', '1', '0', '0', '0' }, 
						  { '1', '1', '0', '0', '0' }, 
						  { '0', '0', '1', '0', '0' },
						  { '0', '0', '0', '1', '1' } };
		System.out.println("Number of islands: " + numIslands(grid)); // Output: 1
	}

	public static int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;

		int m = grid.length;
		int n = grid[0].length;
		int count = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// If we find land (1)
				if (grid[i][j] == '1') {
					count++;
					dfs(grid, i, j, m, n); // Mark the island as visited
				}
			}
		}

		return count;
	}

	// DFS function to visit the connected land
	private static void dfs(char[][] grid, int i, int j, int m, int n) {
		if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {
			return;
		}

		// Mark the current cell as visited (water)
		grid[i][j] = '0';

		// four directions (up, down, left, right)
		dfs(grid, i - 1, j, m, n); // up
		dfs(grid, i + 1, j, m, n); // down
		dfs(grid, i, j - 1, m, n); // left
		dfs(grid, i, j + 1, m, n); // right
	}
}
