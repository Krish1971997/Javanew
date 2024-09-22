package zoho2ndround.secondRound;

public class Program4 {
	static long repeatedString(String s, long n) {
		long countOfA = 0;
		long length = s.length();

		for (int i = 0; i < length; i++) {
			if (s.charAt(i) == 'a')
				countOfA++;
		}
		long repetitions = n / length; 
		long totalCount = repetitions * countOfA;
		long remainder = n % length;

		for (int i = 0; i < remainder; i++) {
			if (s.charAt(i) == 'a')
				totalCount++;
		}
		return totalCount;
	}

	public static void main(String[] args) {
		String s = "aba"; // Example string
		long n = 10; // Example length
		long result = repeatedString(s, n);
		System.out.println("Number of 'a's in the repeated string: " + result);
	}
}
