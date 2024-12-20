package geeksforgeeksZoho;

public class SecondLargestElementInArray {
	public static void main(String[] args) {
		int a[] = { 3, 5, 7, 8, 10, 35, 123 };
		System.out.println(findSecondLargestElement(a));
	}

	private static int findSecondLargestElement(int[] a) {
		int first = Integer.MIN_VALUE;
		int second = Integer.MIN_VALUE;
		for (int i : a) {
			if (first < i) {
				second = first;
				first = i;
			} else if (second < i && first != i)
				second = i;
		}
		return second;

	}

}
