package leetcodeZoho5_dp;

public class MinMaxConsecutiveOnes {
	public static int[] findMinMaxConsecutiveOnes(int[] arr) {
		int maxOnes = 0, minOnes = Integer.MAX_VALUE, currentCount = 0;
		boolean hasOnes = false;

		for (int num : arr) {
			if (num == 1) {
				currentCount++;
				hasOnes = true;
			} else {
				if (currentCount > 0) {
					maxOnes = Math.max(maxOnes, currentCount);
					minOnes = Math.min(minOnes, currentCount);
					currentCount = 0;
				}
			}
		}

		// Check for last sequence
		if (currentCount > 0) {
			maxOnes = Math.max(maxOnes, currentCount);
			minOnes = Math.min(minOnes, currentCount);
		}

		return hasOnes ? new int[] { minOnes, maxOnes } : new int[] { -1, -1 };
	}

	public static void main(String[] args) {
		int[] arr = { 1, 1, 0, 1, 1, 1, 0, 1 };
		int[] result = findMinMaxConsecutiveOnes(arr);
		System.out.println("Min Consecutive Ones: " + result[0]);
		System.out.println("Max Consecutive Ones: " + result[1]);
	}
}
