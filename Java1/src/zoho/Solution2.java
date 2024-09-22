package zoho;

public class Solution2 {

	static int n=6;
	public static void main(String[] args) {
		String temp="0";
		space(n);
		System.out.print(temp);
		space(n);
		System.out.println();
		for (int i = 1; i < n; i++) {
			temp=i+temp+i;
			space(n);
			System.out.print(temp);
			space(n);
			System.out.println();
		}
	}
	
	public static void space(int n) {
		for (int i = n; i >0; i--) {
			System.out.print(" ");
		}
	}
}
