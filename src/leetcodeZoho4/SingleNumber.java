package leetcodeZoho4;

public class SingleNumber {

	public static void main(String[] args) {
		int[] nums = { 4, 1, 2, 1, 2 };
		System.out.println(singleNumber(nums)); // Output: 4
	}

	public static int singleNumber(int[] nums) {
		int result = 0;
		for (int num : nums) {
			result ^= num; // XOR operation
			// result= 4^1^2^1^2 means
			// result =4^0 ^0
			// result=4
		}
		return result; // The single number
	}
}


/** What is XOR?
The XOR operation compares the binary representation of two numbers and returns a new number where:

A bit is 1 if the corresponding bits in the two numbers are different.
A bit is 0 if the corresponding bits in the two numbers are the same.
For example:

Copy code
5 = 0101 (binary)
3 = 0011 (binary)
---------------
XOR: 0110 = 6 (binary)
 * */