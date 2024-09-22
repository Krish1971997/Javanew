package zohofirstRound_31aug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program5 {
	public static void main(String[] args) {
		int nums[] = { 8, 2, 2, 4, 5, 6, 3 };
		int target = 9;
		List<List<Integer>> list = backtracking(nums, target);
		for (List<Integer> list2 : list) {
			System.out.println(list2);
		}
	}

	private static List<List<Integer>> backtracking(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		findUniqueCombinations(nums, target, new ArrayList<>(), result, 0);
		return result;
	}

	private static void findUniqueCombinations(int[] nums, int target, List<Integer> current, List<List<Integer>> result,
			int index) {

		if(target==0) {
			result.add(new ArrayList<>(current));
			return;
		}
		if (target < 0)
			return;
		if (index >= nums.length)
			return;
		for (int i = index; i < nums.length; i++) {
			if (i > index && nums[i] == nums[i - 1])
				continue;

			current.add(nums[i]);
			findUniqueCombinations(nums, target - nums[i], current, result, i + 1);
			current.remove(current.size() - 1);
		}
	}
}
