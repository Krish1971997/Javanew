package leetcodeZoho6;

import java.util.Scanner;

public class ConnectFour {
	private static final int ROWS = 6;
	private static final int COLS = 7;
	private static final char EMPTY = '.';
	private static final char PLAYER_ONE = 'X';
	private static final char PLAYER_TWO = 'O';

	private char[][] board;

	public ConnectFour() {
		board = new char[ROWS][COLS];
		initializeBoard();
	}

	private void initializeBoard() {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				board[i][j] = EMPTY;
			}
		}
	}

	private void printBoard() {
		for (char[] row : board) {
			for (char cell : row) {
				System.out.print(cell + " ");
			}
			System.out.println();
		}
		System.out.println("1 2 3 4 5 6 7"); // Column numbers
	}

	private boolean dropPiece(int col, char player) {
		if (col < 0 || col >= COLS || board[0][col] != EMPTY) {
			return false; // Invalid move
		}

		for (int i = ROWS - 1; i >= 0; i--) {
			if (board[i][col] == EMPTY) {
				board[i][col] = player;
				return true;
			}
		}
		return false;
	} 

	private boolean checkWin(char player) {
		// Check horizontal
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j <= COLS - 4; j++) {
				if (board[i][j] == player && board[i][j + 1] == player && board[i][j + 2] == player
						&& board[i][j + 3] == player) {
					return true;
				}
			}
		}

		// Check vertical
		for (int i = 0; i <= ROWS - 4; i++) {
			for (int j = 0; j < COLS; j++) {
				if (board[i][j] == player && board[i + 1][j] == player && board[i + 2][j] == player
						&& board[i + 3][j] == player) {
					return true;
				}
			}
		}

		// Check diagonals
		for (int i = 0; i <= ROWS - 4; i++) {
			for (int j = 0; j <= COLS - 4; j++) {
				if (board[i][j] == player && board[i + 1][j + 1] == player && board[i + 2][j + 2] == player
						&& board[i + 3][j + 3] == player) {
					return true;
				}
			}
		}

		for (int i = 0; i <= ROWS - 4; i++) {
			for (int j = 3; j < COLS; j++) {
				if (board[i][j] == player && board[i + 1][j - 1] == player && board[i + 2][j - 2] == player
						&& board[i + 3][j - 3] == player) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean isBoardFull() {
		for (int j = 0; j < COLS; j++) {
			if (board[0][j] == EMPTY) {
				return false;
			}
		}
		return true;
	}

	public void playGame() {
		Scanner scanner = new Scanner(System.in);
		char currentPlayer = PLAYER_ONE;

		while (true) {
			printBoard();
			System.out.println("Player " + currentPlayer + ", enter a column (1-7): ");
			int col = scanner.nextInt() - 1;

			if (!dropPiece(col, currentPlayer)) {
				System.out.println("Invalid move! Try again.");
				continue;
			}

			if (checkWin(currentPlayer)) {
				printBoard();
				System.out.println("Player " + currentPlayer + " wins! 🎉");
				break; 
			}

			if (isBoardFull()) {
				printBoard();
				System.out.println("It's a draw! 🤝");
				break;
			}

			currentPlayer = (currentPlayer == PLAYER_ONE) ? PLAYER_TWO : PLAYER_ONE;
		}
		scanner.close();
	}

	public static void main(String[] args) {
		ConnectFour game = new ConnectFour();
		game.playGame();
	}
}
