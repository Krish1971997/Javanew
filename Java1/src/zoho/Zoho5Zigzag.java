package zoho;

import java.util.Arrays;

public class Zoho5Zigzag {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        printZigZag(matrix);
    }

    static void printZigZag(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // Initialize indices for the zigzag traversal
        int row = 0, col = 0;
        boolean goingDown = true; // Start by going down

        while (row < n && col < m) {
            System.out.print(matrix[row][col] + " ");

            if (goingDown) {
                // Move diagonally down
                if (col == 0 || row == n - 1) {
                    goingDown = false; // Change direction
                    if (row == n - 1) {
                        col++; // Move right
                    } else {
                        row++; // Move down
                    }
                } else {
                    row++;
                    col--;
                }
            } else {
                // Move diagonally up
                if (row == 0 || col == m - 1) {
                    goingDown = true; // Change direction
                    if (col == m - 1) {
                        row++; // Move down
                    } else {
                        col++; // Move right
                    }
                } else {
                    row--;
                    col++;
                }
            }
        }
        System.out.println();
    }
}