package prepinsta;

import java.io.*;
import java.util.*;

public class StringPalindrome {
	public static void main(String args[]) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(read.readLine());
		while (t-- > 0) {
			String S = read.readLine();

			Solution ob = new Solution();
			System.out.println(ob.isPalindrome(S));
		}
	}
}

class Solution {
	int isPalindrome(String S) {
		String palindrome = "";
		for (int i = S.length() - 1; i >= 0; i--) {
			palindrome += S.charAt(i);
		}
		return palindrome.equals(S) ? 1 : 0;

	}
};
