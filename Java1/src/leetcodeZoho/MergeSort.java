package leetcodeZoho;

public class MergeSort {
	
	public static void main(String[] args) {
		//int arr[]= {38,27,42,2,9,54,3};
		int arr[]= {22,32,17,49,46,7,41,4,27,14};
		mergeSort(arr, arr.length);
		for (int i : arr) {
			System.out.print(i+", ");
		}
	}
	public static void mergeSort(int[] arr, int numberOfElements) {
		if (numberOfElements < 2) {
			return;
		}

		// Find the middle position and create left and right partitions
		int mid = numberOfElements / 2;
		int[] leftArr = new int[mid];
		int[] rightArr = new int[numberOfElements - mid];

		// Fill up the partitions
		for (int i = 0; i < mid; i++) {
			leftArr[i] = arr[i];
		}

		for (int i = mid; i < numberOfElements; i++) {
			rightArr[i - mid] = arr[i];
		}

		// Apply merge sort on the left parition
		mergeSort(leftArr, mid);

		// Apply merge sort on the right partition
		mergeSort(rightArr, numberOfElements - mid);

		// Finally merge the partitions
		merge(arr, leftArr, rightArr, mid, numberOfElements - mid);
	}

	private static void merge(int[] arr, int[] leftArr, int[] rightArr, int left, int right) {
		int i = 0, j = 0, k = 0;

		// Merge arrays based on the smaller values
		while (i < left && j < right) {
			if (leftArr[i] <= rightArr[j]) {
				arr[k++] = leftArr[i++];
			} else {
				arr[k++] = rightArr[j++];
			}
		}

		// Fill out remaining values if any
		while (i < left) {
			arr[k++] = leftArr[i++];
		}
		while (j < right) {
			arr[k++] = rightArr[j++];
		}
	}

}
