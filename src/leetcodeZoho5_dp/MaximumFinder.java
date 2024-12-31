package leetcodeZoho5_dp;

import java.util.*;

public class MaximumFinder {

	private static boolean isPrime(int num) {
		if (num <= 1)
			return false;
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	// Function to find the N elements that make the maximum sum
	public static List<Integer> findMaxSumElements(List<Integer> nums, int N) {
		List<Integer> result = new ArrayList<>();
		int index = 0;
		int count = 0;

		while (index < nums.size() && count < N) {
			int current = nums.get(index);

			if (isPrime(current)) {
				// If it's a prime number, add it to the result and skip the next element
				result.add(current);
				count++;
				index += 2;
			} else if (current % 2 == 0 && current != 2) {
				// If it's an even number other than 2, add it and the next element
				if (index + 1 < nums.size() && count + 2 <= N) {
					result.add(current);
					result.add(nums.get(index + 1));
					count += 2;
				} else {
					break; // Not enough space to add both
				}
				index += 2;
			} else {
				// Otherwise, just add the current number
				result.add(current);
				count++;
				index++;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(3, 5, 8, 2, 10, 15, 7, 6, 12, 4, 9);
		int N = 5;

		List<Integer> result = findMaxSumElements(nums, N);
		System.out.println("Maximum sum combination: " + result);
	}
}
