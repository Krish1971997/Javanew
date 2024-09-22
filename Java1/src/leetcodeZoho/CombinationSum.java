package leetcodeZoho;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		CombinationSum solution = new CombinationSum();
		int[] candidates = { 2, 3, 5 };
		int target = 8;
		List<List<Integer>> result = solution.combinationSum(candidates, target);
		System.out.println("Unique combinations for target " + target + ": ");
		for (List<Integer> combination : result) {
			System.out.println(combination);
		}
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		backtrack(candidates, target, 0, new ArrayList<>(), result);
		return result;
	}

	private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
		if (target == 0) {
			result.add(new ArrayList<>(current));
			return;
		}
		if (target < 0) {
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			current.add(candidates[i]);
			backtrack(candidates, target - candidates[i], i, current, result);
			current.remove(current.size() - 1);
		}
	}
}
