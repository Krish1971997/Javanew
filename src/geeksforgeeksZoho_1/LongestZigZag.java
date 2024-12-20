package geeksforgeeksZoho_1;

public class LongestZigZag {
	public static int longestZigZag(int[] arr) {
		int n = arr.length;
		int[] up = new int[n];
		int[] down = new int[n];

		for (int i = 0; i < n; i++) {
			up[i] = 1;
			down[i] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					up[i] = Math.max(up[i], down[j] + 1);
				} else if (arr[i] < arr[j]) {
					down[i] = Math.max(down[i], up[j] + 1);
				}
			}
		}
		return Math.max(up[n - 1], down[n - 1]);
	}

	public static void main(String[] args) {
		int[] arr = { 1, 7, 4, 9, 2, 5 };
		System.out.println(longestZigZag(arr));
	}
}
