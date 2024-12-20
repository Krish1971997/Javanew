package statickeyword;

import java.util.HashMap;

public class Program2 {
	public static void main(String[] args) {
		int[] arr = { 10, 20, 20, 10, 10, 30, 50, 10, 20 };
		System.out.println(find(arr));
	}

	private static int find(int[] arr) {
		int max = Integer.MIN_VALUE;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] != arr[i + 1]) {
				if (map.containsKey(arr[i])) {
					int value = map.get(arr[i]) + 1;
					map.put(arr[i], value);

					if (max < value) 
						max = value;
				} else {
					map.put(arr[i], 1);
				}
			}
		}
		return max;

	}

}
