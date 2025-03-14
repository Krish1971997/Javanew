package leetcodeZoho5_dp;

import java.util.Arrays;

public class SortArray {
	public static void main(String[] args) {
		int[] arr = { 2, 4, 6, 8, 9, 7, 5, 3, 1 };
		int j = 0;

		// move odd numbers to left and even numbers to right
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0) {
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				j++;
			}
		}
		// sort odd numbers in ascending
		for (int i = 0; i < j - 1; i++) {
			for (int k = 1; k < j - i; k++) {
				if (arr[k - 1] < arr[k]) {
					int temp = arr[k - 1];
					arr[k - 1] = arr[k];
					arr[k] = temp;
				}
			}
		}

		// sort even numbers descending
		for (int i = 0; i < arr.length - j - 1; i++) {
			for (int k = j; k < arr.length - i; k++) {
				if (arr[k - 1] > arr[k]) {
					int temp = arr[k - 1];
					arr[k - 1] = arr[k];
					arr[k] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}