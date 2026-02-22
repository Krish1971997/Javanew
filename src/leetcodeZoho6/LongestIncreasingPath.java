package leetcodeZoho6;

public class LongestIncreasingPath {
	private static final int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	private static int rows, cols;

	public static void main(String[] args) {
		int[][] matrix = { { 9, 9, 4 }, 
						   { 6, 6, 8 }, 
						   { 2, 1, 1 } };

		LongestIncreasingPath lip = new LongestIncreasingPath();
		int result = lip.longestIncreasingPath(matrix);
		System.out.println("Longest Increasing Path Length: " + result);
	}

	public int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;

		rows = matrix.length;
		cols = matrix[0].length;
		int[][] mem = new int[rows][cols];
		int max = 0;

		// Start DFS from every cell
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				max = Math.max(max, dfs(matrix, i, j, mem));
			}
		}
		// System.out.println("Test");

		return max;
	}

	private int dfs(int[][] matrix, int row, int col, int[][] mem) {
		if (mem[row][col] != 0)
			return mem[row][col];

		int max = 1;

		for (int[] dir : directions) {
			int newRow = row + dir[0];
			int newCol = col + dir[1];

			if (isValid(matrix, row, col, newRow, newCol)) {
				max = Math.max(max, 1 + dfs(matrix, newRow, newCol, mem));
			}
		}

		mem[row][col] = max;
		return max;
	}

	private boolean isValid(int[][] matrix, int row, int col, int newRow, int newCol) {
		return newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
				&& matrix[newRow][newCol] > matrix[row][col];
	}
}
