package leetcodeZoho3;

public class MaximumSumOfAnHourglass {
	public static void main(String[] args) {
		int[][] grid= {{6,2,1,3},{4,2,1,5},{9,2,8,7},{4,1,2,9}};
		System.out.println(maxSum(grid));
	}

	public static int maxSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		if (m < 3 || n < 3) {
			return 0;
		}

		int maxSum = Integer.MIN_VALUE; 

		for (int i = 1; i < m - 1; i++) {
			for (int j = 1; j < n - 1; j++) {
				int currentSum = grid[i - 1][j - 1] + grid[i - 1][j] + grid[i - 1][j + 1] // Top row
						+ grid[i][j] 
						+ grid[i + 1][j - 1] + grid[i + 1][j] + grid[i + 1][j + 1]; // Bottom row

				maxSum = Math.max(maxSum, currentSum);
			}
		}

		return maxSum;
	}
}
