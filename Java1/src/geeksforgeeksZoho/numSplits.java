package geeksforgeeksZoho;

import java.util.*;

class numSplits {
	public static int numberSplits(String s) {
		final int n = s.length();
		int ans = 0;
		int[] prefix = new int[n];
		int[] suffix = new int[n];
		Set<Character> seen = new HashSet<>();

		for (int i = 0; i < n; ++i) {
			seen.add(s.charAt(i));
			prefix[i] = seen.size();
		}
		seen.clear();

		for (int i = n - 1; i >= 0; --i) {
			seen.add(s.charAt(i));
			suffix[i] = seen.size();
		}
		System.out.println(Arrays.toString(prefix));
		System.out.println(Arrays.toString(suffix));

		for (int i = 1; i< n; ++i)
			if (prefix[i-1] == suffix[i])
				++ans;
		return ans;
	}

	public static void main(String[] args) {
		String s = "aacaba";
		System.out.println(numberSplits(s));
	}
}