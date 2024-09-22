package zoho;

import java.util.HashSet;

public class UnionOfTwoArrays {

	public static void main(String[] args) {
		int a[] = { 85, 25, 1, 32, 54, 6 };
		int b[] = { 85, 2 };
		int n = doUnion(a, b, a.length, b.length);
		System.out.println(n);

	}

	private static int doUnion(int[] a, int[] b, int length, int length2) {
		HashSet<Integer> set = new HashSet<Integer>();

		for (int integer : a)
			set.add(integer);
		for (int integer : b)
			set.add(integer);

		return set.size();
	}

}
