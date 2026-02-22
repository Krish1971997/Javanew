package leetcodeZoho8;

public class LargestTwice {

	public static int dominantIndex(int[] nums) {
		if (nums.length == 1)
			return 0; // Only one element, trivially true

		int maxIndex = 0;

		// Step 1: Largest எது என்று கண்டுபிடி
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[maxIndex]) {
				maxIndex = i;
			}
		}

		// Step 2: Largest × 2 > மற்ற எல்லாரையும் check பண்ணு
		for (int i = 0; i < nums.length; i++) {
			if (i != maxIndex) {
				if (nums[maxIndex] * 2 < nums[i]) {
					return -1; // Condition fail
				}
			}
		}

		return maxIndex;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 6, 1, 0 };
		System.out.println(dominantIndex(arr));
	}
}