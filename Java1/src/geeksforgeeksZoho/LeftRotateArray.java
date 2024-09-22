package geeksforgeeksZoho;

public class LeftRotateArray {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		int shiftBy = 4;

		System.out.println("Original Array:");
		printArray(arr);

		leftRotateArray(arr, shiftBy);

		System.out.println("Array after Left Rotation:");
		printArray(arr);
	}

	private static void leftRotateArray(int[] arr, int shiftBy) {
		int n = arr.length;

		reverseArray(arr, 0, shiftBy - 1);   //{2, 1, 3, 4, 5}
		reverseArray(arr, shiftBy, n - 1);   //{2, 1, 5, 4, 3}
		reverseArray(arr, 0, n - 1);            //{3, 4, 5, 1, 2}
	}

	private static void reverseArray(int[] arr, int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	private static void printArray(int[] arr) {
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
}
