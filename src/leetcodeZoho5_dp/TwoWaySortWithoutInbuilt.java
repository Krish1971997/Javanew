package leetcodeZoho5_dp;

public class TwoWaySortWithoutInbuilt {

	// Function to perform two-way sorting without inbuilt functions
	public static void twoWaySort(int[] arr) {
		int n = arr.length;

		// Separate odd and even numbers into two arrays
		int oddCount = 0, evenCount = 0;
		for (int num : arr) {
			if (num % 2 == 0)
				evenCount++;
			else
				oddCount++;
		}

		int[] odd = new int[oddCount];
		int[] even = new int[evenCount];
		int oddIndex = 0, evenIndex = 0;

		for (int num : arr) {
			if (num % 2 == 0)
				even[evenIndex++] = num;
			else
				odd[oddIndex++] = num;
		}

		// Sort odd numbers in descending order
		bubbleSortDescending(odd);

		// Sort even numbers in ascending order
		bubbleSortAscending(even);

		// Merge sorted arrays back into arr
		int i = 0;
		for (int num : odd)
			arr[i++] = num; // Add sorted odd numbers
		for (int num : even)
			arr[i++] = num; // Add sorted even numbers
	}

	// Bubble Sort for Ascending Order
	public static void bubbleSortAscending(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					// Swap
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	// Bubble Sort for Descending Order
	public static void bubbleSortDescending(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] < arr[j + 1]) {
					// Swap
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	// Driver Code
	public static void main(String[] args) {
		int[] arr = { 1, 3, 2, 7, 5, 4 };
		twoWaySort(arr);

		// Print the sorted array
		for (int num : arr) {
			System.out.print(num + " ");
		}
	}
}
