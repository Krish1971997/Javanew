package leetcodeZoho3;

import java.util.ArrayList;
import java.util.List;

public class GroupFormation {

	public static void main(String[] args) {
		int[] arr = { 3, 6, 7, 2, 9 }; // Example 1
		int x = 3;
		findGroups(arr, x);

		int[] arr2 = { 2, 1, 3, 4 }; // Example 2
		x = 3;
		findGroups(arr2, x);
	}

	public static void findGroups(int[] arr, int x) {
		List<List<Integer>> validGroups = new ArrayList<>();

		// Finding all groups of size 2
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if ((arr[i] + arr[j]) % x == 0) {
					List<Integer> group = new ArrayList<>();
					group.add(arr[i]);
					group.add(arr[j]);
					validGroups.add(group);
				}
			}
		}

		// Finding all groups of size 3
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				for (int k = j + 1; k < arr.length; k++) {
					if ((arr[i] + arr[j] + arr[k]) % x == 0) {
						List<Integer> group = new ArrayList<>();
						group.add(arr[i]);
						group.add(arr[j]);
						group.add(arr[k]);
						validGroups.add(group);
					}
				}
			}
		}

		// Printing the results
		System.out.println("Number of valid groups: " + validGroups.size());
		System.out.println("Valid groups:");
		for (List<Integer> group : validGroups) {
			System.out.println(group);
		}
	}
}
