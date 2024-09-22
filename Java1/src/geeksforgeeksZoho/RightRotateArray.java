package geeksforgeeksZoho;

public class RightRotateArray {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		int shiftBy = 2;

		System.out.println("Original Array:");
		printArray(arr);

		rightRotateArray(arr, shiftBy);

		System.out.println("Array after Right Rotation:");
		printArray(arr);
	}

	private static void rightRotateArray(int[] arr, int shiftBy) {
		int n = arr.length;

		reverseArray(arr, 0, n - shiftBy - 1);  //{3, 2, 1, 4, 5}
		reverseArray(arr, n - shiftBy, n - 1);  //{3, 2, 1, 5, 4}
		reverseArray(arr, 0, n - 1);                 //{4, 5, 1, 2, 3}
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
