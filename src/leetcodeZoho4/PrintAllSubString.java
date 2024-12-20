package leetcodeZoho4;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubString {

	public static void main(String[] args) {
		String s1 = "ab";
		String s2 = "cd";
		find(s1, s2, 0, 0, new ArrayList<>());
	}

	private static void find(String s1, String s2, int i, int j, List<String> list) {

		if (i == s1.length() && j == s2.length()) {
			System.out.println(list);
			return;
		}

		if (i < s1.length()) {
			list.add("" + s1.charAt(i));
			find(s1, s2, i + 1, j, list);
			list.remove(list.size() - 1);
		}

		if (j < s2.length()) {
			list.add("" + s2.charAt(j));
			find(s1, s2, i, j + 1, list);
			list.remove(list.size() - 1);
		}
	}
}
