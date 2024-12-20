package leetcodeZoho4;

public class RotatedArraySearch {

	public static int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (nums[mid] == target)
				return mid;

			if (nums[left] <= nums[mid]) {
				// Check if the target lies in the sorted left half
				if (nums[left] <= target && target < nums[mid])
					right = mid - 1;
				else
					left = mid + 1;
			}
			// Otherwise, the right half must be sorted
			else {
				// Check if the target lies in the sorted right half
				if (nums[mid] < target && target <= nums[right])
					left = mid + 1;
				else
					right = mid - 1;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 }; // Rotated sorted array
		int target = 0;

		int result = search(nums, target);

		if (result != -1) {
			System.out.println("Target " + target + " found at index " + result);
		} else {
			System.out.println("Target " + target + " not found.");
		}
	}
}
