package leetcodeZoho6;

class LuckyNumber {
	static boolean isLucky(int n, int counter) {
		if (n < counter)
			return true; // If position is never removed
		if (n % counter == 0)
			return false; // If removed in this step
		return isLucky(n - (n / counter), counter + 1);
	}

	public static void main(String[] args) {
		int num = 19; // Example number
		if (isLucky(num, 2))
			System.out.println(num + " is a Lucky Number.");
		else
			System.out.println(num + " is NOT a Lucky Number.");
	}
}
