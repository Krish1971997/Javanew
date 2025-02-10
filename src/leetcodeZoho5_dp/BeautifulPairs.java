package leetcodeZoho5_dp;

import java.util.*;

public class BeautifulPairs {
    public static int countBeautifulPairs(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n]; // DP array to store count of increasing pairs
        Arrays.fill(dp, 0);

        int totalPairs = 0;

        // DP Transition
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] += (dp[j] + 1); // Add valid subsequence count
                }
            }
            totalPairs += dp[i]; // Accumulate result
        }

        return totalPairs;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println("Total Beautiful Pairs: " + countBeautifulPairs(arr));
    }
}
