package leetcodeZoho2;

import java.util.*;

public class TopKFrequentElements {

	public static List<Integer> topKFrequent(int[] nums, int k) {
		// Step 1: Build the frequency map
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		for (int num : nums) {
			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
		}

		// Step 2: Use a priority queue (min-heap) to keep the top K elements
		PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

		for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
			minHeap.add(entry);
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}

		// Step 3: Extract the elements from the heap in the correct order
		LinkedList<Integer> result = new LinkedList<>();
		while (!minHeap.isEmpty()) {
			result.addFirst(minHeap.poll().getKey());
		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 5 };
		int k = 2;
		List<Integer> topKElements = topKFrequent(nums, k);
		System.out.println("Top " + k + " frequent elements: " + topKElements);
	}
}
