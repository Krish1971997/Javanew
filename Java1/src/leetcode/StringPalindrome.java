package leetcode;


import java.util.*;

public class StringPalindrome {
	static Scanner s=new Scanner(System.in);
	public static void main(String args[]){
		String S=s.next();
		Solution ob = new Solution();
		System.out.println(ob.isPalindrome(S));
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
