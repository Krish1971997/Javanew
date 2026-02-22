package leetcodeZoho6;

public class CountServersThatCommunicate {
	public static void main(String[] args) {
		int[][] grid = { { 1, 1, 0, 0 }, 
						 { 0, 0, 1, 0 }, 
						 { 0, 0, 1, 0 }, 
						 { 0, 0, 0, 1 } };
		System.out.println(countServers(grid)); // Expected output: 4
	}

	public static int countServers(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;

		int[] rowCount = new int[rows];
		int[] colCount = new int[cols];

		// First pass to count the number of servers in each row and column
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == 1) {
					rowCount[i]++;
					colCount[j]++;
				}
			}
		}

		// Second pass to count how many servers can communicate
		int result = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				// A server can communicate if it's not isolated in both row and column
				if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) {
					result++;
				}
			}
		}

		return result;
	}
}
