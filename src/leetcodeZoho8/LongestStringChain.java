package leetcodeZoho8;

import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {

	// Memoization map: string → longest chain from this string
	Map<String, Integer> memo = new HashMap<>();

	public static void main(String[] args) {
		LongestStringChain sol = new LongestStringChain();

		String[] words1 = { "abc", "cat", "dog", "the", "end", "dear" };
		System.out.println(sol.longestChain(words1)); // 4

		sol.memo.clear();
		String[] words2 = { "ab", "bc", "cd", "de", "ef" };
		System.out.println(sol.longestChain(words2)); // 5
	}

	public int longestChain(String[] words) {
		int maxLength = 1;

		for (String word : words) {
			maxLength = Math.max(maxLength, dfs(word, words));
		}

		return maxLength;
	}

	private int dfs(String current, String[] words) {
		// Already computed? Cache-லிருந்து எடு!
		if (memo.containsKey(current)) {
			return memo.get(current);
		}

		char lastChar = current.charAt(current.length() - 1);
		int best = 1; // At least this string itself

		for (String next : words) {
			// next string-ஓட first char == current string-ஓட last char?
			if (next.charAt(0) == lastChar && !next.equals(current)) {
				int chainLen = 1 + dfs(next, words);
				best = Math.max(best, chainLen);
			}
		}

		memo.put(current, best);
		return best;
	}
}