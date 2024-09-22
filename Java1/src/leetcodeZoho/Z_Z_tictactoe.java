package leetcodeZoho;

//not touch
public class Z_Z_tictactoe {
	public String tictactoe(int[][] moves) {
		int[][] board = new int[3][3];

		for (int i = 0; i < moves.length; i++) {
			int player = i % 2 == 0 ? 1 : -1; // Player 1 starts, and alternates between 1 and -1
			int row = moves[i][0];
			int col = moves[i][1];
			board[row][col] = player;

			// Check rows, columns, and diagonals for a win
			if (checkRows(board, player) || checkColumns(board, player) || checkDiagonals(board, player)) {
				return player == 1 ? "A" : "B"; // If player 1 wins, return "A"; otherwise, return "B"
			}
		}

		// If no one wins and the board is not full, the game is ongoing
		if (moves.length < 9) {
			return "Pending";
		}

		// If no one wins and the board is full, it's a draw
		return "Draw";
	}

	private boolean checkRows(int[][] board, int player) {
		for (int i = 0; i < 3; i++) {
			if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
				return true;
			}
		}
		return false;
	}

	private boolean checkColumns(int[][] board, int player) {
		for (int i = 0; i < 3; i++) {
			if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
				return true;
			}
		}
		return false;
	}

	private boolean checkDiagonals(int[][] board, int player) {
		return (board[0][0] == player && board[1][1] == player && board[2][2] == player)
				|| (board[0][2] == player && board[1][1] == player && board[2][0] == player);
	}
}
