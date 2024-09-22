package leetcodeZoho3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(candidates); // Sort to help skip duplicates
		backtrack(result, new ArrayList<>(), candidates, target, 0);
		return result;
	}

	private void backtrack(List<List<Integer>> result, List<Integer> current, int[] candidates, int target, int start) {
		if (target < 0) {
			return; // If target becomes negative, stop exploring further
		}
		if (target == 0) {
			result.add(new ArrayList<>(current)); // Found a valid combination
			return;
		}

		for (int i = start; i < candidates.length; i++) {
			// Skip duplicate numbers
			if (i > start && candidates[i] == candidates[i - 1]) {
				continue;
			}
			current.add(candidates[i]);
			// Move to the next index to avoid reusing the same element
			backtrack(result, current, candidates, target - candidates[i], i + 1);
			current.remove(current.size() - 1); // Backtrack
		}
	}

	public static void main(String[] args) {
		CombinationSum2 solver = new CombinationSum2();
		int[] candidates = { 10, 1, 2, 7, 6, 5, 1, 5 };
		int target = 8;
		List<List<Integer>> result = solver.combinationSum2(candidates, target);
		System.out.println(result); // Output: [[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]
	}
}
