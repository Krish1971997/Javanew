package leetcodeZoho4;

import java.util.HashMap;
import java.util.Map;

public class WildcardPatternMatching {
	    public static void main(String[] args) {
	        String s1 = "aaaab";
	        String s2 = "a*b";
	        System.out.println(isMatch(s1, s2));
	    }

	    public static boolean isMatch(String s1, String s2) {
	        // Use a map for memoization
	        Map<String, Boolean> memo = new HashMap<>();
	        return isMatchHelper(s1, s2, 0, 0, memo);
	    }

	    private static boolean isMatchHelper(String s1, String s2, int i, int j, Map<String, Boolean> memo) {
	        // Base case: If both strings are completely matched
	        if (i == s1.length() && j == s2.length()) {
	            return true;
	        }

	        // If pattern is exhausted but string is not
	        if (j == s2.length()) {
	            return false;
	        }

	        // Create a unique key for the current state
	        String key = i + "," + j;
	        if (memo.containsKey(key)) {
	            return memo.get(key);
	        }

	        boolean match = false;

	        // Handle '*' wildcard
	        if (j + 1 < s2.length() && s2.charAt(j + 1) == '*') {
	            // Skip '*' and the preceding character OR
	            // Match the preceding character with current character of s1 and keep '*' active
	            match = isMatchHelper(s1, s2, i, j + 2, memo) ||
	                    (i < s1.length() && (s1.charAt(i) == s2.charAt(j) || s2.charAt(j) == '.') &&
	                            isMatchHelper(s1, s2, i + 1, j, memo));
	        }
	        // Handle '.' wildcard or direct character match
	        else if (i < s1.length() && (s1.charAt(i) == s2.charAt(j) || s2.charAt(j) == '.')) {
	            match = isMatchHelper(s1, s2, i + 1, j + 1, memo);
	        }

	        // Store the result in the memoization table
	        memo.put(key, match);
	        return match;
	    }
	}
