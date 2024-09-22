package leetcodeZoho3;

import java.util.HashMap;
import java.util.Map;

public class PalindromeRearrange {
	public static int canFormPalindrome(String S) {
		Map<Character, Integer> frequencyMap = new HashMap<>();

		for (char c : S.toCharArray())
			frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);

		int oddCount = 0;
		for (int count : frequencyMap.values()) {
			if (count % 2 != 0)
				oddCount++;
		}

		if (oddCount > 1)
			return 0;
		return 1;
	}

	public static void main(String[] args) {
		String S = "geeksogeeks";
		int result = canFormPalindrome(S);
		if (result == 1)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
