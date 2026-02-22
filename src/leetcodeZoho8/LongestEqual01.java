package leetcodeZoho8;

import java.util.*;

public class LongestEqual01 {

	public static void findLongest(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		int maxLen = 0;
		int start = -1, end = -1;

		map.put(0, -1); // Important base case

		for (int i = 0; i < arr.length; i++) {

			// Convert 0 to -1
			sum += (arr[i] == 0) ? -1 : 1;

			if (map.containsKey(sum)) {
				int prevIndex = map.get(sum);
				int length = i - prevIndex;

				if (length > maxLen) {
					maxLen = length;
					start = prevIndex + 1;
					end = i;
				}
			} else {
				map.put(sum, i);
			}
		}

		System.out.println("Start Index: " + start);
		System.out.println("End Index: " + end);
		System.out.println("Length: " + maxLen);
	}

	public static void main(String[] args) {
		int[] arr = { 0, 1, 0, 1, 1, 1, 0, 0 };
		findLongest(arr);
	}
}