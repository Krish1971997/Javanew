package leetcodeZoho7;

public class CropSubMatrix {
	// Function to set submatrix values to 0
	public static void cropAndZero(int[][] matrix, int r1, int c1, int r2, int c2) {
		for (int i = r1; i <= r2; i++) {
			for (int j = c1; j <= c2; j++) {
				matrix[i][j] = 0;
			}
		}
	}

	// Print helper
	public static void printMatrix(int[][] matrix) {
		for (int[] row : matrix) {
			for (int val : row) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

		System.out.println("Original Matrix:");
		printMatrix(matrix);

		// Crop submatrix from (1,1) to (2,2)
		cropAndZero(matrix, 1, 1, 2, 2);

		System.out.println("\nAfter Cropping:");
		printMatrix(matrix);
	}
}
