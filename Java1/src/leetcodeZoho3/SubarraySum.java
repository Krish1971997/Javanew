package leetcodeZoho3;

import java.util.*;

public class SubarraySum {
	public static int[] findSubarrayWithSum(int[] arr, int sum) {
		int currentSum = 0;
		int start = 0;

		Map<Integer, Integer> map = new HashMap<>();

		for (int end = 0; end < arr.length; end++) {
			currentSum += arr[end];
			if (currentSum == sum)
				return new int[] { start + 1, end + 1 };

			if (map.containsKey(currentSum - sum)) {
				start = map.get(currentSum - sum) + 1;
				return new int[] { start + 1, end + 1 };
			}

			map.put(currentSum, end);
		}

		return new int[] { -1 };
	}

	public static void main(String[] args) {
		int[] arr1 = { 15, 2, 4, 8, 9, 5, 10, 23 };
		int sum1 = 23;
		System.out.println(Arrays.toString(findSubarrayWithSum(arr1, sum1))); // Output: [2, 5]

		int[] arr2 = { 1, 4, 0, 0, 3, 10, 5 };
		int sum2 = 7;
		System.out.println(Arrays.toString(findSubarrayWithSum(arr2, sum2))); // Output: [2, 5]

		int[] arr3 = { 1, 4 };
		int sum3 = 0;
		System.out.println(Arrays.toString(findSubarrayWithSum(arr3, sum3))); // Output: [-1]
	}
}
