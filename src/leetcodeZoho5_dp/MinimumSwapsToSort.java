package leetcodeZoho5_dp;

import java.util.Arrays;

public class MinimumSwapsToSort {

    public static int minSwaps(int[] arr) {
        int n = arr.length;

        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = arr[i]; // Element value
            pairs[i][1] = i;      // Original index
        }

        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        // Visited array to mark visited indices
        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            // If already visited or already in correct position, skip
            if (visited[i] || pairs[i][1] == i) continue;

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = pairs[j][1]; // Move to the next index in the cycle
                cycleSize++;
            }

            // If cycle size is `n`, we need `n-1` swaps
            if (cycleSize > 1) {
                swaps += (cycleSize - 1);
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        System.out.println("Minimum swaps needed: " + minSwaps(arr)); // Output: 2

        int[] arr2 = {1, 5, 4, 3, 2};
        System.out.println("Minimum swaps needed: " + minSwaps(arr2)); // Output: 2
    }
}
