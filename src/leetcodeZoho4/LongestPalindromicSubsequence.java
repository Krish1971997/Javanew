package leetcodeZoho4;

import java.util.Arrays;

public class LongestPalindromicSubsequence {
	public static void main(String[] args) {
		LongestPalindromicSubsequence lcs = new LongestPalindromicSubsequence();
		String S1 = "ababa";
		int m = S1.length();
		int mem[] = new int[m];

			Arrays.fill(mem, -1);

		System.out.println("Length of Palindromic sequence is " + lcs.find(S1, 0, m - 1, mem));
	}
	
	public int find(String s1, int i, int j, int[] mem) {
		if (i ==j)
			return 1;
		
		if(i > j)
			return 0;

		if (mem[i] != -1)
			return mem[i];

		if (s1.charAt(i) == s1.charAt(j))
			return mem[i] = 2 + find(s1, i+1, j - 1, mem);
		else {
			int left = find(s1, i, j - 1, mem);
			int right = find(s1,i + 1, j, mem);
			return mem[i] = Math.max(left, right);
		}
	}
}
