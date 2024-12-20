package leetcodeZoho1;

import java.util.ArrayList;
import java.util.List;

public class GenerateIPAddress {
	public static void main(String[] args) {
		String s = "1921680150";
		List<String> result = restoreIpAddresses(s);
		for (String ip : result) {
			System.out.println(ip);
		}
	}

	public static List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<>();
		if (s == null || s.length() < 4 || s.length() > 12) {
			return result;
		}
		backtrack(result, s, "", 0, 0);
		return result;
	}

	private static void backtrack(List<String> result, String s, String current, int start, int segment) {
		if (segment == 4 && start == s.length()) {
			result.add(current.substring(0, current.length() - 1)); // Remove the last dot
			return;
		}
		if (segment == 4 || start == s.length()) {
			return;
		}
		for (int len = 1; len <= 3; len++) {
			if (start + len > s.length()) {
				break;
			}
			String part = s.substring(start, start + len);
			if ((part.startsWith("0") && part.length() > 1) || (len == 3 && Integer.parseInt(part) > 255)) {
				continue;
			}
			backtrack(result, s, current + part + ".", start + len, segment + 1);
		}
	}
}
