package leetcodeZoho;

public class Pattern1Zoho {
	public static void main(String[] args) {
		int n = 7, m = 8;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
					System.out.print("* ");
				} else if (i + j == i + 1 || i + j == j + 1 ||
						i + j == n + j - 1 || i + j == n + i - 2){
					System.out.print("0 ");
				} else
					System.out.print("* ");
			}
			System.out.println();
		}
	}

}
