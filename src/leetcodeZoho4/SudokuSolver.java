package leetcodeZoho4;

public class SudokuSolver {

    // Size of the Sudoku board
    private static final int SIZE = 9;

    // Method to solve the Sudoku board
    public boolean solveSudoku(int[][] board) {
        // Iterate through the board to find an empty cell (denoted by 0)
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) {
                    // Try numbers 1 through 9 in the empty cell
                    for (int num = 1; num <= 9; num++) {
                        if (isSafe(board, row, col, num)) {
                            // Place the number in the cell
                            board[row][col] = num;
                            
                            // Recursively try to solve the rest of the board
                            if (solveSudoku(board)) {
                                return true; // Solution found
                            }
                            
                            // Backtrack if placing num doesn't lead to a solution
                            board[row][col] = 0;
                        }
                    }
                    return false; // No number between 1-9 is valid in this cell
                }
            }
        }
        return true; // The board is solved
    }

    // Method to check if placing a number in a cell is valid
    private boolean isSafe(int[][] board, int row, int col, int num) {
        // Check if the number is not present in the current row, column, or 3x3 subgrid
        return !isInRow(board, row, num) &&
               !isInCol(board, col, num) &&
               !isInBox(board, row - row % 3, col - col % 3, num);
    }

    // Check if the number is in the current row
    private boolean isInRow(int[][] board, int row, int num) {
        for (int col = 0; col < SIZE; col++) {
            if (board[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    // Check if the number is in the current column
    private boolean isInCol(int[][] board, int col, int num) {
        for (int row = 0; row < SIZE; row++) {
            if (board[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    // Check if the number is in the current 3x3 subgrid
    private boolean isInBox(int[][] board, int startRow, int startCol, int num) {
        for (int row = 0; row < 3	; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row + startRow][col + startCol] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    // Method to print the Sudoku board
    public void printBoard(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Example Sudoku board with some pre-filled cells (0 denotes an empty cell)
        int[][] board = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        SudokuSolver solver = new SudokuSolver();
        if (solver.solveSudoku(board)) {
            System.out.println("Sudoku solved successfully:");
            solver.printBoard(board);
        } else {
            System.out.println("No solution exists.");
        }
    }
}
