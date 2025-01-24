package leetcodeZoho5_dp;

import java.util.HashSet;

public class NonCommonCharacters {
	public static void main(String[] args) {
		String str1 = "abcde";
		String str2 = "acdfg";

		System.out.println("Non-common characters: " + findNonCommonCharacters(str1, str2));
	}

	public static String findNonCommonCharacters(String str1, String str2) {
		HashSet<Character> set1 = new HashSet<>();
		HashSet<Character> set2 = new HashSet<>();

		for (char c : str1.toCharArray()) {
			set1.add(c);
		}

		for (char c : str2.toCharArray()) {
			set2.add(c);
		}

		StringBuilder result = new StringBuilder();

		for (char c : set1) {
			if (!set2.contains(c)) {
				result.append(c);
			}
		}

		for (char c : set2) {
			if (!set1.contains(c)) {
				result.append(c);
			}
		}

		return result.toString();
	}
}
