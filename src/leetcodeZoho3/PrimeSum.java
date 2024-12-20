package leetcodeZoho3;

public class PrimeSum {
	public static void main(String[] args) {
		int limit = 100;
		int sum = 0;

		for (int i = 2; i <= limit; i++) {
			if (isPrime(i))
				sum += i;
		}

		System.out.println("Sum of all prime numbers from 2 to 100: " + sum);
	}

	public static int customSqrt(int num) {
		if (num == 0) {
			return 0;
		}

		int low = 0;
		int high = num;
		int mid;

		while (low < high) {
			mid = (low + high) / 2;
			int sqaure = mid * mid;
			if (sqaure == num)
				return mid;
			else if (sqaure > num) {
				high = mid - 1;
			} else
				low = mid + 1;
		}
		return (low + high) / 2;
	}

	public static boolean isPrime(int num) {
		if (num <= 1) {
			return false;
		}
		if (num == 2) {
			return true; // 2 is the only even prime number
		}
		if (num % 2 == 0) {
			return false; // Even numbers other than 2 are not prime
		}

		int sqrtNum = customSqrt(num); // Use custom sqrt method
		for (int i = 3; i <= sqrtNum; i += 2) {
			if (num % i == 0) {
				return false;
			}
		}

		return true;
	}
}
