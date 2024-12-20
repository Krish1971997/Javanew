package zoho;

/**
 * https://www.geeksforgeeks.org/zoho-interview-experience-set-27-off-campus-software-developer/
 * 1. Find the extra element and its index
 * 
 * Input : [ 10, 20, 30, 12, 5 ] [ 10, 5, 30, 20 ] 
 * Output : 12 is the extra element in array 1 at index 4
 * 
 * Input : [ -1, 0, 3, 2 ] [ 3, 4, 0, -1, 2 ] 
 * Output : 4 is the extra element in array 3 at index 5
 */

public class ExtraElementFindArray {
	public static void main(String args[]) {
		int[] arr1 = { 10, 20, 30, 5 };
		int[] arr2 = { 10, 5, 30, 40, 20 };
		int res = extraElement(arr1, arr2);
		System.out.println("Result-->" + res);
	}

	public static int extraElement(int arr1[], int arr2[]) {
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[i] == arr2[j] && arr1[i] != -1) {
					arr1[i] = -1;
					arr2[j] = -1;
				}
			}
		}

		if (arr1.length > arr2.length) {
			for (int i = 0; i < arr1.length; i++) {
				if (arr1[i] != -1)
					return i;
			}
		} else {
			for (int i = 0; i < arr2.length; i++) {
				if (arr2[i] != -1)
					return i;
			}
		}
		return 0;
	}
}