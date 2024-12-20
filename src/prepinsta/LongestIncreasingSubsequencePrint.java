package prepinsta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequencePrint {
	public static void main(String[] args) {
		int[] nums1 = { 1, 5, 3, 7 };
		int[] nums2 = { 10, 22, 9, 33, 21, 50, 41 };

		System.out.println(findLIS(nums1)); // Output: [1, 5, 7] or [1, 3, 7]
		System.out.println(findLIS(nums2)); // Output: [10, 22, 33, 50]
	}

	public static List<Integer> findLIS(int[] nums) {
		int n = nums.length;
		if (n == 0)
			return new ArrayList<>();

		int[] dp = new int[n];
		int[] prev = new int[n];

		// Initialize dp to 1 and prev to -1
		for (int i = 0; i < n; i++) {
			dp[i] = 1;
			prev[i] = -1;
		}

		// Build the dp array
		int maxLen = 1, endIndex = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
					prev[i] = j;
				}
			}
			if (dp[i] > maxLen) {
				maxLen = dp[i];
				endIndex = i;
			}
		}

		// Reconstruct the LIS using the prev array
		List<Integer> lis = new ArrayList<>();
		for (int i = endIndex; i != -1; i = prev[i]) {
			lis.add(nums[i]);
		}
		Collections.reverse(lis);

		return lis;
	}
}
