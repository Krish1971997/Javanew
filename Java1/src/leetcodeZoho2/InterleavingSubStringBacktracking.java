package leetcodeZoho2;

import java.util.Arrays;

public class InterleavingSubStringBacktracking {
	public static void main(String[] args) {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";

		int[][] mem = new int[s3.length() + 1][s3.length() + 1];
		for (int i = 0; i < mem.length; i++) {
			Arrays.fill(mem[i], -1);
		}  
		System.out.println(find(s1, s2, s3, 0, 0, 0, mem));
	}

	public static boolean find(String s1, String s2, String s3, int i, int j, int k, int[][] mem) {
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}

		if (i == s1.length() && j == s2.length()) {
			return true;
		}

		if (mem[i][j] != -1) {
			return mem[i][j] == 1 ? true : false;
		}

		if ((i < s1.length() && j < s2.length()) && (s1.charAt(i) == s3.charAt(k)) && (s2.charAt(j) == s3.charAt(k))) {
			boolean res = find(s1, s2, s3, i + 1, j, k + 1, mem) || find(s1, s2, s3, i, j + 1, k + 1, mem);
			mem[i][j] = res ? 1 : 0;
			return res;
		}

		if (i<s1.length()&&s1.charAt(i) == s3.charAt(k)) {
			boolean res = find(s1, s2, s3, i + 1, j, k + 1, mem);
			mem[i][j] = res ? 1 : 0;
			return res;
		}
		
		if (j<s2.length()&& s2.charAt(j) == s3.charAt(k)) {
			boolean res = find(s1, s2, s3, i, j+1, k + 1, mem);
			mem[i][j] = res ? 1 : 0;
			return res;
		}
		return false;
	}
}