package leetcodeZoho;

import java.util.Arrays;

public class ProductOFArrayItself {
	public static void main(String[] args) {
		int[] nums = { 4, 3, 2, 1 };
		//int[] nums = { -1,1,0,-3,3};
		System.out.println(Arrays.toString(productExceptSelf(nums)));
	}

	public static int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int[] prefix = new int[n];
		int[] suffix = new int[n];
		int[] result = new int[n];

		prefix[0] = 1;
		for (int i = 1; i < n; i++)
			prefix[i] = prefix[i - 1] * nums[i - 1];

		System.out.println(Arrays.toString(prefix));
		suffix[n - 1] = 1;
		for (int i = n - 2; i >= 0; i--)
			suffix[i] = suffix[i + 1] * nums[i + 1];

		System.out.println(Arrays.toString(suffix));
		for (int i = 0; i < n; i++) {
			//System.out.println("prefix[i] : "+prefix[i] +"--> suffix[i] :"+suffix[i]);
			result[i] = prefix[i] * suffix[i];
			}
		return result;
	}
}
