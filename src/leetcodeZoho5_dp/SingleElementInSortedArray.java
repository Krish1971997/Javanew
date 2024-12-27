package leetcodeZoho5_dp;

public class SingleElementInSortedArray {
	public static int singleNonDuplicate(int[] nums) {
		int left = 0, right = nums.length - 1;

		while (left < right) {
			int mid = (left+right) / 2;

			// Ensure `mid` is even for comparison
			if (mid % 2 == 1) {
				mid--;
			}

			// Check if the pair is valid
			if (nums[mid] == nums[mid + 1]) {
				left = mid + 2; // Move to the right half
			} else {
				right = mid; // Move to the left half
			}
		}

		return nums[left]; // `left` points to the single element
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2, 2, 3, 3, 4, 8, 8 };
		System.out.println("The single non-duplicate element is: " + singleNonDuplicate(nums));
	}
}
