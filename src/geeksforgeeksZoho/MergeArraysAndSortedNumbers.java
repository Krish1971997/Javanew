package geeksforgeeksZoho;

import java.util.Map;
import java.util.TreeMap;

public class MergeArraysAndSortedNumbers {
	public static void main(String[] args) {
		int arr1[] = { 10,1 };
		int arr2[] = { 2, 3,40 };

		int length = arr1.length + arr2.length;
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int i = 0, j = 0; i < length; i++) {
			if (i < arr1.length) {
				map.put(arr1[i], 0);
			} else if (j < arr2.length) {
				map.put(arr2[j], 0);
				j++;
			}
		}

		int i = 0, j = 0;
		for (Map.Entry<Integer, Integer> treemap : map.entrySet()) {
			if (i < arr1.length) {
				arr1[i] = treemap.getKey();
				i++;
			} else if (j < arr2.length) {
				arr2[j] = treemap.getKey();
				j++;
			}
		}
		
		printarray(arr1);
		printarray(arr2);
	}
	
	public static void printarray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if(i<arr.length-1)
				System.out.print(",");
		}
		System.out.println();
	}
}
