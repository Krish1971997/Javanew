package geeksforgeeksZoho;

import java.util.HashSet;

public class LongestConsecutiveSequence {
	public static void main(String[] args) {
		int[] nums1 = { 100, 4, 200, 1, 3, 2, 5 };
		System.out.println(longestConsecutive(nums1)); // Output: 4

		int[] nums2 = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
		System.out.println(longestConsecutive(nums2)); // Output: 9
	}

	public static int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		HashSet<Integer> numSet = new HashSet<>();
		for (int num : nums)
			numSet.add(num);

		int longestStreak = 0;
		for (int num : nums) {
			if (!numSet.contains(num - 1)) {
				int currentNum = num;
				int currentStreak = 0;

				while (numSet.contains(currentNum)) {
					currentNum++;
					currentStreak++;
				}
				longestStreak = Math.max(longestStreak, currentStreak);
			}
		}
		return longestStreak;
	}
}
