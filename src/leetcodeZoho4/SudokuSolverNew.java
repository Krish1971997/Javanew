package leetcodeZoho4;

public class SudokuSolverNew {

	public static void main(String[] args) {
		int[][] board = { { 5, 3, 0, 0, 7, 0, 0, 0, 0 }, { 6, 0, 0, 1, 9, 5, 0, 0, 0 }, { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
				{ 8, 0, 0, 0, 6, 0, 0, 0, 3 }, { 4, 0, 0, 8, 0, 3, 0, 0, 1 }, { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
				{ 0, 6, 0, 0, 0, 0, 2, 8, 0 }, { 0, 0, 0, 4, 1, 9, 0, 0, 5 }, { 0, 0, 0, 0, 8, 0, 0, 7, 9 } };

		solveSudoku(board);
	}

	static void solveSudoku(int[][] arr) {
		int[][] row = new int[10][10];
		int[][] col = new int[10][10];
		int[][] currentGrid = new int[10][10];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] != 0) {
					int val = arr[i][j];
					row[i][val] = 1;
					col[i][val] = 1;

					int subGrid = (i / 3) * 3 + (j / 3);
					currentGrid[subGrid][val] = 1;
				}
			}
		}

		helper(arr, row, col, currentGrid);
		print(arr);
	}

	private static void print(int[][] arr) {
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr.length; col++) {
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}
	}

	private static boolean helper(int[][] arr, int[][] row, int[][] col, int[][] currentGrid) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] == 0) {
					for (int k = 1; k <= 9; k++) {
						if (row[i][k] == 0 && row[j][k] == 0 && currentGrid[(i / 3) * 3 + (j / 3)][k] == 0) {
							arr[i][j] = k;
							row[i][k] = 1;
							col[j][k] = 1;
							currentGrid[(i / 3) * 3 + (j / 3)][k] = 1;

							if (helper(arr, row, col, currentGrid))
								return true;

							arr[i][j] = 0;
							row[i][k] = 0;
							col[j][k] = 0;
							currentGrid[(i / 3) * 3 + (j / 3)][k] = 0;
						}
					}
					return false;

				}
			}
		}
		return true;
	}
}
