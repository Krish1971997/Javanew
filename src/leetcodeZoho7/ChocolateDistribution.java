package leetcodeZoho7;

import java.util.Arrays;
//https://www.geeksforgeeks.org/dsa/chocolate-distribution-problem/
//working
public class ChocolateDistribution {
    public static int findMinDifference(int[] arr, int n, int m) {
        if (m == 0 || n == 0) return 0;
        if (m > n) return -1; // not enough packets

        Arrays.sort(arr); // Step 1: Sort the packets

        int minDiff = Integer.MAX_VALUE;

        // Step 2: Sliding window
        for (int i = 0; i + m - 1 < n; i++) {
            int diff = arr[i + m - 1] - arr[i];
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }

    public static void main(String[] args) {
        int[] arr = {7, 3, 2, 4, 9, 12, 56};
        int m = 3;
        int n = arr.length;

        System.out.println("Minimum difference: " + findMinDifference(arr, n, m));
    }
}
