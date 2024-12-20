package leetcodeZoho4;

import java.util.Arrays;

public class Edit_Distance {
	public static void main(String[] args) {
		String S1 = "abd";
		String S2 = "acb";
		int m = S1.length();
		int n = S2.length();
		int mem[][] = new int[m][n];

		for (int i = 0; i < mem.length; i++) {
			Arrays.fill(mem[i], -1);
		}

		System.out.println("Max insertation and deletion " + find(S1, S2, 0, 0, mem));
	}

	public static int find(String s1, String s2, int i, int j, int[][] mem) {

		if (i == s1.length())
			return s2.length() - j;

		if (j == s2.length())
			return s1.length() - i;

		if (mem[i][j] != -1)
			return mem[i][j];

		if (s1.charAt(i) == s2.charAt(j))
			return mem[i][j] = find(s1, s2, i + 1, j + 1, mem);

		else {
			int insert = 1 + find(s1, s2, i, j + 1, mem);
			int delete = 1 + find(s1, s2, i + 1, j, mem);
			int replace = 1 + find(s1, s2, i + 1, j + 1, mem);
			mem[i][j] = Math.min(insert, Math.min(delete, replace));
		}
		return mem[i][j];
	}

}
