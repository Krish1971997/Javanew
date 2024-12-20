package leetcodeZoho2;

import java.util.Arrays;

public class ShortestDistanceToTargetString {

	public static int closetTarget(String[] words, String target, int startIndex) {
		int n = words.length;
		int ans = n;
		for (int i = 0; i < n; ++i) {
			String w = words[i];
			if (w.equals(target)) {
				int t = Math.abs(i - startIndex);
				ans = Math.min(ans, Math.min(t, n - t));
				// ans=Math.min(t, ans);
			}
		}
		return ans == n ? -1 : ans;
	}

	public static void main(String[] args) {
		String[] words1 = { "hello", "i", "am", "leetcode", "hello" };
		String target1 = "hello";
		int startIndex1 = 2;
		System.out.println("Input: words = " + Arrays.toString(words1) + ", target = \"" + target1 + "\", startIndex = "
				+ startIndex1);
		System.out.println("Output: " + closetTarget(words1, target1, startIndex1));

		String[] words2 = { "a", "b", "leetcode" };
		String target2 = "leetcode";
		int startIndex2 = 0;
		System.out.println("Input: words = " + Arrays.toString(words2) + ", target = \"" + target2 + "\", startIndex = "
				+ startIndex2);
		System.out.println("Output: " + closetTarget(words2, target2, startIndex2));

	}
}