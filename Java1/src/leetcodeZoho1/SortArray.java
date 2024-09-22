package leetcodeZoho1;

//https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
public class SortArray {
	public static void main(String[] args) {
		int[] nums1 = { 0, 1, 2, 0, 1, 2 };
		System.out.print("Input: ");
		printArray(nums1);
		sortArray(nums1);
		System.out.print("Output: ");
		printArray(nums1);

		int[] nums2 = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		System.out.print("\nInput: ");
		printArray(nums2);
		sortArray(nums2);
		System.out.print("Output: ");
		printArray(nums2);
	}

	public static void sortArray(int[] nums) {
		int low = 0;
		int mid = 0;
		int high = nums.length - 1;

		while (mid <= high) {
			switch (nums[mid]) {
			case 0:
				swap(nums, low, mid);
				low++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				swap(nums, mid, high);
				high--;
				break;
			}
		}
	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void printArray(int[] nums) {
		System.out.print("{");
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
			if (i < nums.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("}");
	}
}
