
package leetcodeZoho3;

public class ClosestNumberInSortedArray {

	public static int findClosest(int[] arr, int target) {
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException("Array is empty or null");
		}

		int left = 0, right = arr.length - 1;

		if (target <= arr[left]) {
			//System.out.println("line 13");
			return arr[left];
		}

		if (target >= arr[right]) {
			//System.out.println("line 18");
			return arr[right];
		}

		while (left <= right) {
			int mid = (left + right) / 2;

			if (arr[mid] == target)
				return arr[mid];
			if (target < arr[mid])
				right = mid - 1;
			else
				left = mid + 1;
		}

		if (Math.abs(arr[left] - target) < Math.abs(arr[right] - target)) {
			return arr[left];
		} else {
			return arr[right];
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, 5, 6, 8, 9 };
		int target = 7;
		System.out.println("Closest number to " + target + " is " + findClosest(arr, target)); // Output: 6
	}
}
