package leetcodeZoho5_dp;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = { 10, 7, 8, 9, 1, 5 };
		System.out.println("Original Array: " + Arrays.toString(arr));

		quickSort(arr, 0, arr.length - 1);

		System.out.println("Sorted Array: " + Arrays.toString(arr));
	}

	static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int pivotIndex = partition(arr, low, high);

			quickSort(arr, low, pivotIndex - 1);
			quickSort(arr, pivotIndex + 1, high);
		}
	}

	static int partition(int[] arr, int low, int high) {
		int pivot = arr[high]; // Choosing last element as pivot
		int i = low - 1; // Index for smaller element

		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j); // Swap elements
			}
		}

		swap(arr, i + 1, high); // Move pivot to correct position
		return i + 1;
	}

	// Function to swap two elements in an array
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
