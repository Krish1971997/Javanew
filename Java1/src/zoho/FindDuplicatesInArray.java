package zoho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

//https://practice.geeksforgeeks.org/problems/find-duplicates-in-an-array/1?page=1&sortBy=submissions
public class FindDuplicatesInArray {

	public static void main(String[] args) {
		int arr[] = {2,3,1,2,3,3,3,3};
		ArrayList<Integer> arr1 = duplicates(arr, arr.length);
		System.out.println(arr1);
	}

	public static ArrayList<Integer> duplicates(int arr[], int n) {
	/*	ArrayList<Integer> list = new ArrayList<Integer>();
		Arrays.sort(arr);
		boolean noDuplicates = true;
		if (n > 0) {
			for (int i = 1; i < arr.length; i++) {
				int first = arr[i - 1];
				if (arr[i] == first & !list.contains(arr[i])) {
					list.add(arr[i]);
					noDuplicates = false;
				}
			}
			if (noDuplicates)
				list.add(-1);
		}
		return list; */
		ArrayList<Integer> result = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			int index = arr[i] % n; // Calculate the index
			arr[index] += n; // Increment the value at index by n
		}
		
		for (int i = 0; i < n; i++) {
			if ((arr[i] / n) > 1)
				result.add(i);
		}

		if (result.isEmpty()) 
			result.add(-1);

		return result;

				
		
	}

}
