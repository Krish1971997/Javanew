package leetcodeZoho3;

import java.util.Arrays;

/*
 * sort the array odd numbers in ascending and even numbers in descending.
I/p 5 8 11 6 2 1 7
O/p 1 5 7 11 8 6 2
 * */
public class SortingArray {

	public static void main(String[] args) {
		int[] arr = { 5, 8, 11, 6, 2, 1, 7 };
		find(arr);
	}

	private static void find(int[] arr) {
		int[] res = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		Arrays.fill(res, -1);
		for (int i = 0,k=0, j = res.length - 1; i < arr.length; i++) {
			if(res[i]==-1 && i < arr.length) {
				if (arr[i] % 2 == 0)
					res[j--] = arr[i];
				else
					res[k++] = arr[i];
			}
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(res));
	}
}
