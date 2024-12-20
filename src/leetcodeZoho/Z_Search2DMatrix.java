package leetcodeZoho;

public class Z_Search2DMatrix {

	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;

		int numRows = matrix.length;
		int numCols = matrix[0].length;

		int row = 0;
		int col = numCols - 1;

		while (row < numRows && col >= 0) {
			if (matrix[row][col] == target)
				return true;
			else if (matrix[row][col] < target)
				row++; 
			else
				col--; 
		}
		return false;
	}

	public static void main(String[] args) {

		int[][] matrix = { { 1, 3, 5, 7 }, 
						{ 10, 11, 16, 20 }, 
						{ 23, 30, 34, 60 } };
		int target = 34;
		System.out.println("Does the matrix contain " + target + "? " + searchMatrix(matrix, target));
	}
}
