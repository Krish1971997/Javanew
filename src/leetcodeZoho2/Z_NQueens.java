package leetcodeZoho2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Z_NQueens {
	    public List<List<String>> solveNQueens(int n) {
	        List<List<String>> results = new ArrayList<>();
	        int[] queens = new int[n]; // queens[i] represents the column index of the queen in row i
	        Arrays.fill(queens, -1);   // Initialize all queens to be not placed (-1)
	        solveNQueensHelper(results, queens, 0, n);
	        return results;
	    }
	    
	    private void solveNQueensHelper(List<List<String>> results, int[] queens, int row, int n) {
	        if (row == n) {
	            results.add(generateSolution(queens, n));
	            return;
	        }
	        
	        for (int col = 0; col < n; col++) {
	            if (isValid(queens, row, col)) {
	                queens[row] = col;  // Place queen at (row, col)
	                solveNQueensHelper(results, queens, row + 1, n); // Recur to place queen in the next row
	                queens[row] = -1;   // Backtrack: remove queen from (row, col)
	            }
	        }
	    }
	    
	    private boolean isValid(int[] queens, int row, int col) {
	        for (int i = 0; i < row; i++) {
	            if (queens[i] == col ||               // Same column check
	                queens[i] - i == col - row ||     // Diagonal \ check
	                queens[i] + i == col + row) {     // Diagonal / check
	                return false;
	            }
	        }
	        return true;
	    }
	    
	    private List<String> generateSolution(int[] queens, int n) {
	        List<String> solution = new ArrayList<>();
	        for (int row = 0; row < n; row++) {
	            char[] chars = new char[n];
	            Arrays.fill(chars, '.');
	            chars[queens[row]] = 'Q';
	            solution.add(new String(chars));
	        }
	        return solution;
	    }
	    
	    public static void main(String[] args) {
	    	Z_NQueens nQueens = new Z_NQueens();
	        int n = 4; // Example: Solve for 4 queens
	        List<List<String>> solutions = nQueens.solveNQueens(n);
	        for (List<String> solution : solutions) {
	            System.out.println("Solution:");
	            for (String row : solution) {
	                System.out.println(row);
	            }
	            System.out.println();
	        }
	    }
	}
