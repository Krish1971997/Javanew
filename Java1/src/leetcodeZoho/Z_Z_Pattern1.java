package leetcodeZoho;
//Not touch
public class Z_Z_Pattern1 {
	public static void main(String[] args) {
		int n = 5;

		int top = 0, bot = n - 1, left = 0, right = n - 1;
		int[][] arr = new int[n][n];
		int m = 1;

		while (true) {
			// Fill top row
			for (int i = top, h = 0; i <= bot; i++, h++) {
				int k = top + h, l = left + h;
				arr[k][l] = m++;
			}
			bot--;
			left++;

			if (bot < top || left > right)
				break;

			// Fill rightmost column
			for (int i = bot; i >= top; i--) {
				arr[i][right] = m++;
			}
			right--;

			if (bot < top || left > right)
				break;

			// Fill bottom row
			for (int i = right; i >= left; i--) {
				arr[top][i] = m++;
			}
			top++;
			left++;
			bot--;

			if (bot < top || left > right)
				break;
		}

		// Print the generated matrix
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] != 0)
					System.out.print(arr[i][j] + " ");
				else
					System.out.print("   ");
			}
			System.out.println();
		}
	}
}
