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
		int left = 1;
		int right = 1000000000; // max possible value

		while (left < right) {
			int mid = left + (right - left) / 2;

			if (canRob(nums, k, mid)) {
				right = mid; // mid-ஐ குறைக்க பாக்கலாம்
			} else {
				left = mid + 1; // mid போதாது, அதிகப்படுத்தணும்
			}
		}

		return left;
	}

	// capability-க்கு உள்ளே k வீடுகளை rob பண்ண முடியுமா?
	private static boolean canRob(int[] nums, int k, int capability) {
		int count = 0;
		int i = 0;

		while (i < nums.length) {
			if (nums[i] <= capability) {
				count++; // இந்த வீட்டை rob பண்ணலாம்
				i += 2; // adjacent skip பண்ணு
			} else {
				i++; // இந்த வீடு capability-ஐ தாண்டுது, skip
			}
		}

		return count >= k;
	}
}
