package leetcodeZoho5_dp;

public class Knapsack {

    // Function to solve 0/1 Knapsack problem using Top-Down Approach (Memoization)
    public static int knapSack(int W, int[] weights, int[] values, int n) {
        // Create a memoization table to store results of subproblems
        int[][] memo = new int[n + 1][W + 1];

        // Initialize memoization table with -1, which represents uncomputed values
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                memo[i][w] = -1;
            }
        }

        // Start the recursion and memoization
        return knapSackHelper(W, weights, values, n, memo);
    }

    // Helper function for recursion with memoization
    public static int knapSackHelper(int W, int[] weights, int[] values, int n, int[][] memo) {
        // Base case: No items left or no remaining capacity
        if (n == 0 || W == 0) {
            return 0;
        }

        // If this subproblem has been solved before, return the stored result
        if (memo[n][W] != -1) {
            return memo[n][W];
        }

        // If the current item's weight is greater than the remaining capacity, exclude it
        if (weights[n - 1] > W) {
            return memo[n][W] = knapSackHelper(W, weights, values, n - 1, memo);
        } else {
            // Return the maximum of including or excluding the current item
            int includeItem = values[n - 1] + knapSackHelper(W - weights[n - 1], weights, values, n - 1, memo);
            int excludeItem = knapSackHelper(W, weights, values, n - 1, memo);
            return memo[n][W] = Math.max(includeItem, excludeItem);
        }
    }

    public static void main(String[] args) {
        int[] values = {60, 100, 120}; // Values of the items
        int[] weights = {10, 20, 30}; // Weights of the items
        int W = 50; // Maximum weight capacity of the knapsack
        int n = values.length; // Number of items

        // Call the knapSack function to get the maximum value using top-down approach
        int maxValue = knapSack(W, weights, values, n);

        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
}
