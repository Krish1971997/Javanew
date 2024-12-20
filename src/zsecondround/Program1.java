package zsecondround;

public class Program1 {
	public static void main(String[] args) {
		int n=1234;
		System.out.println(findSumOfDigits(n));
	}

	private static int findSumOfDigits(int n) {
		int sum=0;
		while(n>0) {
			sum+=n%10;
			n=n/10;
		}
		return sum;
	}

}
