package zProgrammingRound;

public class Program4 {
	public static void main(String[] args) {
		// DBAABDAB
		// ABDAADBDAABB
		StringBuilder str = new StringBuilder("ABDAADBDAABB");
		removeAdjacentDuplicates(str);
	}

	private static void removeAdjacentDuplicates(StringBuilder str) {

		int i = 1;
		while (i < str.length()) {
			if (str.charAt(i - 1) == str.charAt(i)) {
				// Remove adjacent duplicates
				str.delete(i - 1, i + 1);
				// Step back to check for new adjacent duplicates created
				if (i > 1)
					i--;
			} else {
				i++;
			}
		}
		System.out.println(str.toString());
	}
}
