package leetcodeZoho2;

public class ThirdQuestion {
	static int[][] direction = new int[][] { { 1, 0 }, { 0, 1 }, { -1, -1 }, { 1, 1 } };

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 2 }, { 5, 2, 1, 5 }, { 1, 3, 1, 5 }, { 2, 2, 1, 10 } };
		int k = 3;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				max = Math.max(max, dfs(matrix, i, j, k));
			}
		}
		System.out.println(max);
	}

	static int dfs(int[][] matrix, int row, int col, int k) {
		if (k == 0)
			return 1;
		if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length)
			return 1;
		int maxProduct = Integer.MIN_VALUE;

		for (int i = 0; i < direction.length; i++) {
			int newR = row + direction[i][0];
			int newC = col + direction[i][1];

			int product = matrix[row][col] * dfs(matrix, newR, newC, k - 1);
			maxProduct = Math.max(maxProduct, product);
		}
		return maxProduct;
	}
}
