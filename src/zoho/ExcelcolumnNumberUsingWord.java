package zoho;

public class ExcelcolumnNumberUsingWord {

	public static void main(String[] args) {
		int s = 3;
		System.out.println(columnWordFind(s));
	}

	private static String columnWordFind(int s) {
		StringBuilder sb = new StringBuilder();
		while (s > 0) {
			s--;
			// Decrement the columnNumber by 1 to map 'A' to 1, 'B' to 2, etc.
			// Get the remainder after dividing by 26 to find the current letter.
			System.out.println("S -->" + s);
			System.out.println("(s % 26) --> " + s % 26);
			System.out.println("('A' + (s % 26)) --> " + ('A' + (s % 26)));

			char letter = (char) ('A' + (s % 26));
			sb.insert(0, letter);
			s /= 26;
		}
		return sb.toString();
	}
}