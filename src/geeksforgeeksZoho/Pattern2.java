package geeksforgeeksZoho;

public class Pattern2 {
	
/*			1
	  	  2 4
	 	3 5 7
	6 8 10 12
9 11 13 15 17
	 	 */

public static void main(String[] args) {
	int n = 5;
	int a = 1;
	int b = 2;
	for (int i = 0; i < n; i++) {
		for (int j = 1; j < n-i; j++) {
			System.out.print("  ");
		}
		
		if (i % 2 == 0) {
			for (int j = 0; j <= i; j++) {
				System.out.print(a + " ");
				a = a + 2;
			}
		} else {
			for (int j = 0; j <= i; j++) {
				System.out.print(b + " ");
				b = b + 2;
			}
		}
		System.out.println();
	}
}
}
