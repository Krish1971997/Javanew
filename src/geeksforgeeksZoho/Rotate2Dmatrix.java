package geeksforgeeksZoho;

public class Rotate2Dmatrix {
	public static void main(String[] args) {
		//int[][] matrix1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] matrix2 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		System.out.println("Original Matrix 1:");
		//printMatrix(matrix1);

		//rotateMatrixClockwise(matrix1);

		//System.out.println("\nRotated Matrix 1:");
		//printMatrix(matrix1);

		System.out.println("\nOriginal Matrix 2:");
		printMatrix(matrix2);

		rotateMatrixClockwise(matrix2);

		System.out.println("\nRotated Matrix 2:");
		printMatrix(matrix2);
	}

	public static void rotateMatrixClockwise(int[][] matrix) {
		int rows = matrix.length, cols = matrix[0].length;

		if (rows != cols) {
			System.out.println("Input matrix is not a square matrix. Rotation is not possible.");
			return;
		}

		for (int i = 0; i < rows / 2; i++) {
			for (int j = i; j < rows - i - 1; j++) { 
				int temp = matrix[i][j];

				matrix[i][j] = matrix[rows - 1 - j][i];

				matrix[rows - 1 - j][i] = matrix[rows - 1 - i][cols - 1 - j];

				matrix[rows - 1 - i][cols - 1 - j] = matrix[j][cols - 1 - i];

				matrix[j][cols - 1 - i] = temp;
			}
		}
	}

	public static void printMatrix(int[][] matrix) {
		for (int[] row : matrix) {
			for (int num : row) 
				System.out.print(num + " ");
			System.out.println();
		}
	}
}
