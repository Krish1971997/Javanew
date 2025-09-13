package leetcodeZoho6;

public class HouseRobberIV {
	public static void main(String[] args) {
		int[] nums1 = { 2, 3, 5, 9 };
		int k1 = 2;
		System.out.println(minCapability(nums1, k1)); // 5

		int[] nums2 = { 7, 3, 8, 6, 5, 10 };
		int k2 = 3;
		System.out.println(minCapability(nums2, k2)); // 8
	}

	public static int minCapability(int[] nums, int k) {
		int left = 1, right = 1000000000, ans = -1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (canRob(nums, k, mid)) {
				ans = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return ans;
	}

	private static boolean canRob(int[] nums, int k, int maxVal) {
		int count = 0;
		int i = 0;

		while (i < nums.length) {
			if (nums[i] <= maxVal) {
				count++;
				i += 2; // skip next house (no two adjacent)
			} else {
				i++;
			}
		}

		return count >= k;
	}
}
