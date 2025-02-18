package leetcodeZoho4;

import java.util.Arrays;

//From rajesh bro 
//WORKING
public class WildcardPatternMatching11 {

	public static void main(String[] args) {
		String s1 = "XZXY";
		String s2 = "X**?";
	int[][] mem = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i < mem.length; i++) {
			Arrays.fill(mem[i], -1);
		}
		System.out.println(find(s1, s2, 0, 0, mem));
	}

	public static boolean find(String s1, String s2, int i, int j, int[][] mem) {
		if (i == s1.length() && j == s2.length())
			return true;

		if (j == s2.length())
			return false;

		if (mem[i][j] != -1) {
			return mem[i][j] == 1 ? true : false;
		}

		if (s2.charAt(j) == '*') {
			boolean res = find(s1, s2, i, j + 1, mem) || 
						(i < s1.length() && find(s1, s2, i + 1, j, mem));
			mem[i][j] = res ? 1 : 0;
			return res;
		}

		if ((i < s1.length() && s1.charAt(i) == s2.charAt(j) || s2.charAt(j) == '?')) {
			boolean res = find(s1, s2, i + 1, j + 1, mem);
			mem[i][j] = res ? 1 : 0;
			return res;
		}
		return false;
	}

}
