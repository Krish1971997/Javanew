package leetcodeZoho;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

	public static void main(String[] args) {
		String s1 = "egg";
		String s2 = "add";
		if (isIsomorphic(s1, s2))
			System.out.println("True");
		else
			System.out.println("False");
		String s3 = "foo";
		String s4 = "bar";
		if (isIsomorphic(s3, s4))
			System.out.println("True");
		else
			System.out.println("False");
	}

	public static boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		Map<Character, Character> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char sChar = s.charAt(i);
			char tChar = t.charAt(i);
			if (!map.containsKey(sChar)) {
				if (!map.containsValue(tChar)) {
					map.put(sChar, tChar);
				} else
					return false;
			} else {
				char value = map.get(sChar);
				if (value != tChar) {
					return false;
				}
			}
		}
		return true;
	}
}
