package leetcodeZoho;

public class Z_Z_FIndMaxSum {
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {

		int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int rows = mat.length;
		int cols = mat[0].length;
		int i = 0;
		int j = 0;
		int sum = mat[i][j];
		find(mat, rows, cols, i, j, sum);
		System.out.println(max);
	}

	static void find(int[][] mat, int rows, int cols, int i, int j, int sum) {
		if (i == rows - 1 && j == cols - 1) {
			if (sum > max) {
				max = sum;
			}
		}
		if (i >= rows || j >= cols) {
			return;
		}
		if (j < cols - 1) {
			find(mat, rows, cols, i, j + 1, sum + mat[i][j + 1]);
		}
		if (i < rows - 1) {
			find(mat, rows, cols, i + 1, j, sum + mat[i + 1][j]);
		}
	}
}