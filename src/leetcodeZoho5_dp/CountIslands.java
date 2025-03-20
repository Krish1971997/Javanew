package leetcodeZoho5_dp;

public class CountIslands {

	public static void main(String[] args) {
		int[][] grid = { { 1, 1, 0, 0, 0 }, 
				  { 1, 1, 0, 0, 0 }, 
				  { 0, 0, 1, 0, 0 },
				  { 0, 0, 0, 1, 1 } };

		int numberOfIslands = countIslands(grid);
		System.out.println("Number of Islands: " + numberOfIslands);
	}

	public static int countIslands(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}

		int rows = grid.length;
		int cols = grid[0].length;
		boolean[][] visited = new boolean[rows][cols];
		int islandCount = 0;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == 1 && !visited[i][j]) {
					islandCount++;
					dfs(grid, visited, i, j);
					// System.out.println();
				}
			}
		}

		return islandCount;
	}

	private static void dfs(int[][] grid, boolean[][] visited, int row, int col) {
		int[] rowDirection = { -1, 1, 0, 0 };
		int[] colDirection = { 0, 0, -1, 1 };

		visited[row][col] = true;

		for (int d = 0; d < 4; d++) {
			int newRow = row + rowDirection[d];
			int newCol = col + colDirection[d];

			if (newRow >= 0 && newCol >= 0)
				System.out.println("New Row,col : (" + newRow + " , " + newCol + ")");

			// Check boundaries and visit unvisited land
			if (newRow >= 0 && newRow < grid.length && newCol >= 0 && 
					newCol < grid[0].length
					&& grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {
				dfs(grid, visited, newRow, newCol);
			}
		}
	}
}
