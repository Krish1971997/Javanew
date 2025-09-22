package l2Programming;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program2 {
	public static void main(String[] args) {
		// int[] arr= {1,1,2,3,4};
		// int[] arr = { 1, 2, 2, 3, 3, 3, 4, 4, 4, 4 };

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of the array:");
		int length = sc.nextInt();
		int[] arr = new int[length];
		System.out.println("Enter the " + length + " numbers");
		for (int i = 0; i < length; i++) {
			arr[i] = sc.nextInt();
		}

		Map<Integer, Integer> frequency = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			frequency.put(arr[i], frequency.getOrDefault(arr[i], 0) + 1);
		}

		Map<Integer, Integer> sumMap = new HashMap<>();
		for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
			Integer key = entry.getValue();
			Integer val = entry.getKey();
			sumMap.put(key, sumMap.getOrDefault(key, 0) + key * val);
		}

		for (Map.Entry<Integer, Integer> entry : sumMap.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());

		}

	}

}
