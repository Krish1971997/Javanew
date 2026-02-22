package leetcodeZoho8;

import java.util.*;

public class PairLessThanTarget {

	public static void main(String[] args) {

		int[] arr = { 1, 5, 3, 2 };
		int target = 6;

		Arrays.sort(arr);

		int left = 0;
		int right = arr.length - 1;
		System.out.println(Arrays.toString(arr));

		while (left < right) {

			if (arr[left] + arr[right] < target) {

				// All elements between left and right form valid pairs
				for (int i = left + 1; i <= right; i++) {
					System.out.println("(" + left + "," + i + ")");
				}
				left++;
			} else {
				right--;
			}
		}
	}
}