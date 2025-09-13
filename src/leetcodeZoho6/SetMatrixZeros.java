package leetcodeZoho6;

import java.util.Arrays;

public class SetMatrixZeros {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 0, 6 }, { 7, 8, 9 } };

		setZeroes(matrix);

		// Print result
		for (int[] row : matrix) {
			System.out.println(Arrays.toString(row));
		}
	}

	public static void setZeroes(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		boolean[] rows = new boolean[m];
		boolean[] cols = new boolean[n];

		// Step 1: Mark rows & cols containing 0
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					rows[i] = true;
					cols[j] = true;
				}
			}
		}

		// Step 2: Update matrix
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (rows[i] || cols[j]) {
					matrix[i][j] = 0;
				}
			}
		}
	}
}
