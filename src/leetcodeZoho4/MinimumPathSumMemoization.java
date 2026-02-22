package leetcodeZoho4;

import java.util.*;

public class MinimumPathSumMemoization {
    public static void main(String[] args) {
        List<List<Integer>> triangle = Arrays.asList(
            Arrays.asList(2),
            Arrays.asList(1, 4),
            Arrays.asList(2, 5, 7),
            Arrays.asList(4, 1, 8, 3)
        );
        

        int minSum = minimumTotal(triangle);
        System.out.println("Minimum path sum: " + minSum);
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int numRows = triangle.size();
        Integer[][] memo = new Integer[numRows][numRows];
        return findMinPath(triangle, 0, 0, memo);
    }

    private static int findMinPath(List<List<Integer>> triangle, int row, int col, Integer[][] memo) {
        // Base case: if we're at the bottom row
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }

        if (memo[row][col] != null) {
            return memo[row][col];
        }

        int leftPath = findMinPath(triangle, row + 1, col, memo);
        int rightPath = findMinPath(triangle, row + 1, col + 1, memo);

        // Calculate the minimum path sum for this cell
        return memo[row][col] = triangle.get(row).get(col) + Math.min(leftPath, rightPath);
    }
}