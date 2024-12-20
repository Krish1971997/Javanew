package leetcodeZoho4;

public class SingleNumber1 {

	public static void main(String[] args) {
		int[] nums = { 4, 1, 2, 1, 2 };
		System.out.println(findSingleNonDuplicate(nums));
	}

	private static int findSingleNonDuplicate(int[] nums) {
		int left = 0;
		int len = nums.length;
		int right = len - 1;

		while (left < right) {
			int mid = (left + right) / 2;
			if (mid % 2 == 1)
				mid--;
			if (nums[mid] == nums[mid + 1]) {
				left = left + mid + 2;
			} else
				right = mid;

		}
		return nums[right];
	}
}
