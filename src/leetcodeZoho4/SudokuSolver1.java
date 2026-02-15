package leetcodeZoho4;

//working
public class SudokuSolver1 {

	private static final int SIZE = 9;

	public void solveSudoku(int[][] board) {
		solve(board);
	}

	private boolean solve(int[][] board) {
		for (int row = 0; row < SIZE; row++) {
			for (int col = 0; col < SIZE; col++) {
				if (board[row][col] == 0) {
					for (int num = 1; num <= SIZE; num++) {
						if (isValid(board, row, col, num)) {
							board[row][col] = num; // Place the number
							if (solve(board)) { // Recursively solve the rest
								return true;
							}
							board[row][col] = 0; // Undo if not solvable
						}
					}
					return false; // Return false if no valid number found
				}
			}
		}
		return true; // Puzzle solved
	}

	private boolean isValid(int[][] board, int row, int col, int num) {
		for (int i = 0; i < SIZE; i++) {
			if (board[row][i] == num)
				return false; // Check row
			if (board[i][col] == num)
				return false; // Check column
			if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == num)
				return false; // Check 3x3 grid
		}
		return true;
	}

	public static void main(String[] args) {
		SudokuSolver1 solver = new SudokuSolver1();
		int[][] board = { { 5, 9, 0, 3, 0, 0, 8, 7, 2 }, { 1, 8, 6, 4, 0, 2, 9, 5, 3 }, { 7, 3, 2, 0, 0, 0, 0, 0, 1 },
				{ 2, 1, 0, 6, 0, 7, 3, 0, 0 }, { 6, 0, 0, 5, 4, 0, 1, 0, 0 }, { 0, 4, 9, 2, 0, 0, 0, 6, 5 },
				{ 3, 6, 8, 9, 0, 5, 4, 1, 0 }, { 0, 5, 1, 0, 6, 4, 2, 3, 8 }, { 4, 2, 0, 0, 0, 3, 5, 9, 0 } };
		solver.solveSudoku(board);

		for (int[] row : board) {
			for (int c : row) {
				System.out.print(c + " ");
			}
			System.out.println();
		}
	}
}
