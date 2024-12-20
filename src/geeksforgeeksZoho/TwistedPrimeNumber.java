package geeksforgeeksZoho;

public class TwistedPrimeNumber {

	public static void main(String[] args) {
		int n = 97;
		if (isPrime(n)) {
			boolean ans = isreverse(n);
			if (ans)
				System.out.println("Twisted prime number");
			else
				System.out.println("Twisted prime not number");
		}
	}

	public static boolean isPrime(int n) {
		for (int i = 2; i < n / 2; i++) {
			if (n % i == 0) 
				return false;
		}
		return true;
	}

	public static boolean isreverse(int n) {
		int sum = 0;
		while (n > 0) {
			sum = sum * 10 + n % 10;
			n = n / 10;
		}
		return isPrime(sum);
	}
}
