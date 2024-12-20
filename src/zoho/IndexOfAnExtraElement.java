package zoho;

//https://practice.geeksforgeeks.org/problems/index-of-an-extra-element/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

public class IndexOfAnExtraElement {

	public static void main(String[] args) {
		/*int[] A = { 2, 4, 6, 8, 9, 10, 12 };
		int B[] = { 2, 4, 6, 8, 10, 12 };
		int N = 7; */
		
		int []A= {1,2,3,4};
		int []B= {1,2,3};
		int N=4;
		int index = findExtra(A, B, N);
		System.out.println("index --> " + index);

	}

	private static int findExtra(int[] a, int[] b, int n) {
		int low = 0, mid = 0;
		int high = n - 1, index = 0;

		while (low <= high) {
			mid = (low + high) / 2;
			if (mid<n-1&& a[mid] == b[mid]) {
				low = mid + 1;
			} else {
				index = mid;
				high = mid - 1;
			}
		}
		return index;
	}
}
