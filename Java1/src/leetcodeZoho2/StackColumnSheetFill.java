package leetcodeZoho2;

import java.util.Arrays;

public class StackColumnSheetFill {
	public static void main(String[] args) {
		int[] arr = { 5, 3, 8, 6, 2, 7, 4, 1 };
		int rows = 4; // Number of rows in the matrix
		int cols = 2; // Number of columns in the matrix

		System.out.println("Original array: " + Arrays.toString(arr));

		// Step 1: Sort the array
		Arrays.sort(arr);

		System.out.println("Sorted array: " + Arrays.toString(arr));

		// Step 2: Fill the matrix column-wise
		int[][] matrix = new int[rows][cols];
		fillMatrixColumnWise(matrix, arr, rows, cols);

		// Step 3: Print the matrix
		System.out.println("Matrix filled column-wise:");
		printMatrix(matrix);
	}

	public static void fillMatrixColumnWise(int[][] matrix, int[] arr, int rows, int cols) {
		int index = 0;
		for (int col = 0; col < cols; col++) {
			for (int row = 0; row < rows; row++) {
				if (index < arr.length) {
					matrix[row][col] = arr[index++];
				}
			}
		}
	}

	public static void printMatrix(int[][] matrix) {
		for (int[] row : matrix) {
			for (int val : row) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}
}
