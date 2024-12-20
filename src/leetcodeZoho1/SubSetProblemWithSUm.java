package leetcodeZoho1;

import java.util.ArrayList;

public class SubSetProblemWithSUm {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };
		int target = 5;
		find(arr, target, 0, new ArrayList<>());
	}

	static void find(int[] arr, int target, int index, ArrayList<Integer> list) {
		if (target == 0) {
			System.out.println(list);
			return;
		}

		if (index == arr.length) {
			return;
		}
		if (target<0) {
			return;
		}
		list.add(arr[index]);
		find(arr, target - arr[index], index + 1, list);
		list.remove(list.size() - 1);
		find(arr, target, index + 1, list);
	}
}
