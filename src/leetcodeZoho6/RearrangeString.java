
package leetcodeZoho6;

import java.util.*;
//need to learn
public class RearrangeString {

	public static String rearrange(String s) {
		// Step 1: Count frequency of each character
		Map<Character, Integer> freqMap = new HashMap<>();
		for (char c : s.toCharArray()) {
			freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
		}

		// Step 2: Max heap based on character frequency
		PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));
		maxHeap.addAll(freqMap.keySet());

		StringBuilder result = new StringBuilder();
		Character prev = null;
		int prevCount = 0;

		// Step 3: Build result string
		while (!maxHeap.isEmpty()) {
			char current = maxHeap.poll();
			result.append(current);

			// If there was a previous character with remaining count, add it back to heap
			if (prev != null && prevCount > 0) {
				maxHeap.offer(prev);
			}

			freqMap.put(current, freqMap.get(current) - 1);
			prev = current;
			prevCount = freqMap.get(current);
		}

		// Step 4: Validate result
		return result.length() == s.length() ? result.toString() : "";
	}

	public static void main(String[] args) {
		System.out.println(rearrange("aab")); // aba
		System.out.println(rearrange("aaab")); // ""
		System.out.println(rearrange("aaabbc")); // e.g. "ababac"
	}
}
