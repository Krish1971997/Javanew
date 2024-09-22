package geeksforgeeksZoho;

public class FirstLargestElementArray {
	public static void main(String[] args) {
		int a[] = { 3, 5, 7, 8, 10, 35, 123 };
		System.out.println(findFirstLargestElement(a));
	}

	private static int findFirstLargestElement(int[] a) {
		int first = Integer.MIN_VALUE;
		for (int i : a) {
			if (first < i)
				first = i;
		}
		return first;
	}
}
