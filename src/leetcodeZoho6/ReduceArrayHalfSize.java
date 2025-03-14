package leetcodeZoho6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/reduce-array-size-to-the-half/description
public class ReduceArrayHalfSize {
	public static void main(String[] args) {
		int[] arr = { 3, 3, 3, 3, 5, 5, 5, 2, 2, 7 };
		// int[] arr= {7,7,7,7};
		System.out.println(find(arr));
	}

	private static int find(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		List<Integer> list = new ArrayList<>(map.values());
		//list.sort(Collections.reverseOrder());

		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});

		int halfSize = arr.length / 2;
		int setsize = 0;
		int sum = 0;

		for (Integer integer : list) {
			sum += integer;
			setsize++;

			if (sum >= halfSize) {
				break;
			}
		}

		return setsize;
	}
}
