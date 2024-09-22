package leetcodeZoho3;

import java.util.*;

public class TopKFrequentElements {
	public static void main(String[] args) {
		int[] nums1 = { 1, 1, 1, 2, 2, 3 };
		int k1 = 2;
		System.out.println(topKFrequent(nums1, k1)); // Output: [1, 2]

		int[] nums2 = { 1 };
		int k2 = 1;
		System.out.println(topKFrequent(nums2, k2)); // Output: [1]
	}

	public static List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		for (int num : nums)
			frequencyMap.put(num, getOrDefault(frequencyMap, num, 0) + 1);

		int n = nums.length;
		List<Integer>[] bucket = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++)
			bucket[i] = new ArrayList<>();

		for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
			int num = entry.getKey();
			int freq = entry.getValue();
			bucket[freq].add(num);
		}

		List<Integer> topK = new ArrayList<>();
		for (int i = n; i >= 0 && topK.size() < k; i--) {
			if (!bucket[i].isEmpty())
				topK.addAll(bucket[i]);
		}

		return topK;
	}

	public static int getOrDefault(Map<Integer, Integer> map, int key, int defaultKey) {
		return map.get(key) != null ? map.get(key) : defaultKey;
	}
}
