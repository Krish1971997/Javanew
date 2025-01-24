package leetcodeZoho2;

import java.util.Arrays;

public class LongestCommonSubsequence1 {
	public static void main(String[] args) {
		LongestCommonSubsequence1 lcs = new LongestCommonSubsequence1();
		String S1 = "abcde";
		String S2 = "ace";
		int m = S1.length();
		int n = S2.length();
		int mem[][] = new int[m][n];

		for (int i = 0; i < mem.length; i++) {
			Arrays.fill(mem[i], -1);
		}

		System.out.println("Length of Longest Comman sequence is " 
		+ lcs.find(S1, S2, 0, 0, mem));
	}
	
	public int find(String s1, String s2, int i, int j, int[][] mem) {
		if (i == s1.length() || j == s2.length())
			return 0;

		if (mem[i][j] != -1)
			return mem[i][j];

		if (s1.charAt(i) == s2.charAt(j))
			return mem[i][j] = 1 + find(s1, s2, i + 1, j + 1, mem);
		else {
			int left = find(s1, s2, i, j + 1, mem);
			int right = find(s1, s2, i + 1, j, mem);
			return mem[i][j] = Math.max(left, right);
		}
	}

}
