package geeksforgeeksZoho_1;

import java.util.Arrays;

//https://leetcode.com/problems/sort-even-and-odd-indices-independently/description/

public class SortArraySamePosition {
	public static void main(String[] args) {
		int[] arr = { 3, 4, 5, 8, 7, 6, 9, 2 };
		sortNumbers(arr);
	}

	private static void sortNumbers(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if ((arr[i] % 2 == 0 && arr[j] % 2 == 0 && arr[i] > arr[j])
						||(arr[i]%2 != 0 && arr[j]%2 != 0 && arr[i] < arr[j])) {
					int temp = arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
