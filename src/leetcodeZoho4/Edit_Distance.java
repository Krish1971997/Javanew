package leetcodeZoho4;

import java.util.Arrays;

public class Edit_Distance {
	public static void main(String[] args) {
		String S1 = "horse";  //Convert S1 = "horse" to S2 = "ros" using minimum operations:
		String S2 = "ros";
//		int m = S1.length();
//		int n = S2.length();
//		int mem[][] = new int[m][n];
//
//		for (int i = 0; i < mem.length; i++) {
//			Arrays.fill(mem[i], -1);
//		}

		//System.out.println("Max insertation and deletion " + find(S1, S2, 0, 0, mem));
		System.out.println("Max insertation and deletion " + minDistance(S1, S2));
	}
	
	static int minDistance(String word1, String word2) {

	    int m = word1.length();
	    int n = word2.length();

	    // dp[i][j] := min operations to convert word1 to word2
	    int[][] costDP = new int[m + 1][n + 1];

	    // Initialize DP matrix
	    for (int i = 1; i <= m; ++i) 
	    	costDP[i][0] = i;
	    
	    for (int j = 1; j <= n; ++j) 
	    	costDP[0][j] = j;

	    for (int i = 1; i <= m; ++i)
	      for (int j = 1; j <= n; ++j)

	        //same characters
	        if (word1.charAt(i - 1) == word2.charAt(j - 1))
	          // Copy from top left
	          costDP[i][j] = costDP[i - 1][j - 1];
	        else {
	          // Get minimum of all 3 neighbors
	          int topLeft = costDP[i - 1][j - 1];
	          int top = costDP[i - 1][j];
	          int left = costDP[i][j - 1];
	          costDP[i][j] = Math.min(topLeft, Math.min(top, left)) + 1;
	        }

	    return costDP[m][n];
	    
	  }
/*	public static int find(String s1, String s2, int i, int j, int[][] mem) {

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
	} */
}
