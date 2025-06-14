package leetcodeZoho5_dp;

public class ZMatrixValidator {

	public static boolean isZMatrix(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (row == 0 || row == rows - 1) { //first row and last row
					if (matrix[row][col] == 0) {
						return false;
					}
				} else if (rows-1 == row + col) { //cross X
					if (matrix[row][col] == 0) {
						return false;
					}
				} else {
					if (matrix[row][col] != 0) { 
						return false;
					}
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		// Test cases
		int[][] testCase1 = { { 1, 2, 3 }, { 0, 1, 0 }, { 1, 2, 2 } };
		int[][] testCase2 = { { 1, 1 }, { 0, 0 } };
		int[][] testCase3 = { { 1, 1 }, { 1, 1 } };
		// int[][] testCase4 = { { 1, 2, 3, 4 }, { 0, 0, 1, 0 }, { 0, 1, 0, 0 }, { 1, 2,
		// 3, 4 } };
		int[][] testCase4 = { { 1, 2, 3, 1 }, { 0, 0, 7, 0 }, { 0, 5, 0, 0 }, { 6, 1, 3, 9 } };

		System.out.println("Test Case 1: " + isZMatrix(testCase1)); // Expected: true
		System.out.println("Test Case 2: " + isZMatrix(testCase2)); // Expected: false
		System.out.println("Test Case 3: " + isZMatrix(testCase3)); // Expected: true
		System.out.println("Test Case 4: " + isZMatrix(testCase4)); // Expected: false
	}
}
