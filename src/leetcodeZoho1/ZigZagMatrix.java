package leetcodeZoho1;

import java.util.*;

public class ZigZagMatrix {
    public static void printZigZagMatrix(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return;
        int n = matrix[0].length;

        boolean goingUp = true;
        for (int i = 0; i < m + n - 1; i++) {
            if (goingUp) {
                int row = i < m ? i : m - 1;
                int col = i < m ? 0 : i - m + 1;
                while (row >= 0 && col < n) {
                    System.out.print(matrix[row][col] + " ");
                    row--;
                    col++;
                }
            } else {
                int row = i < n ? 0 : i - n + 1;
                int col = i < n ? i : n - 1;
                while (row < m && col >= 0) {
                    System.out.print(matrix[row][col] + " ");
                    row++;
                    col--;
                }
            }
            goingUp = !goingUp;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Input:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("\nOutput:");
        printZigZagMatrix(matrix);
    }
}
