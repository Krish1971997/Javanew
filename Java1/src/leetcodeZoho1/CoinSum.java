package leetcodeZoho1;

import java.util.ArrayList;

public class CoinSum {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 5 };
		find(arr, 11, new ArrayList<>());
	}

	static int find(int arr[], int target, ArrayList<Integer> list) {

		if (target == 0) {
			System.out.println(list);
			return 1;
		}
		if (target < 0) {
			return 0;
		}

		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
			count = count + find(arr, target - arr[i], list);
			list.remove(list.size()-1);
		}
		return count;
	}
}
