package geeksforgeeksZoho_1;

import java.util.Arrays;

public class ArraySortProblem {
/*	public static void main(String[] args) {
		int arr[] = { 0, 1, 2, 3, 4, 5, 6, 7 };
		Arrays.toString(sortArray(arr));
	}

	private static int[] sortArray(int[] arr) {
		int even[] = new int[arr.length / 2];
		int odd[] = new int[arr.length / 2];

		int i = 0;
		int j = arr.length - 1 / 2;
		for (int k = 0; k < arr.length; k++) {
			if (i % 2 == 0) {
				arr[k] = even[i];
				i++;

			} else {
				arr[k] = odd[j];
				j--;
			}
		}
		return arr;
	} */
	
	//public class FindDuplicates {

	    public static void main(String[] args) {
	        int[] arr1 = {1, 2, 3, 6, 3, 6, 1};
	        findDuplicates(arr1);

	        int[] arr2 = {1, 2, 3, 4, 3};
	        findDuplicates(arr2);
	    }

	    public static void findDuplicates(int[] arr) {
	        System.out.print("Duplicate elements: ");
	        for (int i = 0; i < arr.length; i++) {
	            int index = Math.abs(arr[i]) % arr.length;

	            if (arr[index] < 0) {
	                System.out.print(Math.abs(arr[i]) + " ");
	            } else {
	                arr[index] = -arr[index];
	            }
	        }
	        System.out.println();
	    }
}
