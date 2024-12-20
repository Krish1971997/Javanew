package leetcodeZoho1;

public class LongestIncreasingSubsequence_optimize {

	static int maxsum;

	public static void main(String[] args) {
		int[] nums = { 1, 5, 3, 7 };
		System.out.println(find(nums));
	}

	static int find(int[] nums) {

		if (nums == null || nums.length == 0)
			return 0;

		int[] mem = new int[nums.length];
		mem[0] = 1;
		int maxlen = 1;
		for (int i = 1; i < nums.length; i++) {
			mem[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					mem[i] = Math.max(mem[i], mem[j] + 1);
				}
			}
			maxlen = Math.max(maxlen, mem[i]);
		}
		return maxlen;
	}
}
