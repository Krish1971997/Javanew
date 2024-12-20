package leetcodeZoho2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Z13_PartitionSubsetSum {
	public static void main(String[] args) {

	/*	Scanner s = new Scanner(System.in);
		System.out.println("Enter the Array length : ");
		int length = s.nextInt();
		int arr[] = new int[length];
		System.out.println("Enter Array elments : ");

		for (int i = 0; i < length; i++) {
			arr[i] = s.nextInt();
		}
*/
		// int arr[]= {1,5,11,5};
		 int arr[] = { 1, 6, 8, 3, 4 };

		partionProblem(arr);
	}

	private static void partionProblem(int[] arr) {
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();

		if (partionCheck(arr, list1, list2))
			System.out.println("The array can be partioned as " + list1 + " and " + list2);
		else
			System.out.println("The array cannot be partioned into equal sum sets");
	}

	private static boolean partionCheck(int[] arr, List<Integer> list1, List<Integer> list2) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++)
			sum += arr[i];

		if (sum % 2 != 0)
			return false;

		return splitPartion(arr, sum / 2, list1, list2, 0);
	}

	private static boolean splitPartion(int[] arr, int target, List<Integer> list1, List<Integer> list2, int idx) {

		if (target == 0) {
			for (int i = idx; i < arr.length; i++) {
				list2.add(arr[i]);
			}
			return true;
		}

		if (target < 0 || idx >= arr.length)
			return false;

		list1.add(arr[idx]);
		if (splitPartion(arr, target - arr[idx], list1, list2, idx + 1))
			return true;
		list1.remove(list1.size() - 1);

		list2.add(arr[idx]);
		if (splitPartion(arr, target, list1, list2, idx + 1))
			return true;
		list2.remove(list2.size() - 1);

		return false;
	}
}
