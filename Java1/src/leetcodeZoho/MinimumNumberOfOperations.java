package leetcodeZoho;

public class MinimumNumberOfOperations {

	public int minOperations(String current, String correct) {
		int currHours = Integer.parseInt(current.substring(0, 2));
		int currMinutes = Integer.parseInt(current.substring(3));

		int correctHours = Integer.parseInt(correct.substring(0, 2));
		int correctMinutes = Integer.parseInt(correct.substring(3));

		int currTotalMinutes = currHours * 60 + currMinutes;
		int correctTotalMinutes = correctHours * 60 + correctMinutes;

		int diffMinutes = Math.abs(currTotalMinutes - correctTotalMinutes);

		int operations = 0;
		int[] options = { 60, 15, 5, 1 };
		for (int option : options) {
			operations += diffMinutes / option;
			diffMinutes %= option;
		}

		return operations;
	}

	public static void main(String[] args) {
		MinimumNumberOfOperations solution = new MinimumNumberOfOperations();

		String current1 = "02:30";
		String correct1 = "04:35";
		System.out.println(solution.minOperations(current1, correct1)); // Output: 3

		String current2 = "11:00";
		String correct2 = "11:01";
		System.out.println(solution.minOperations(current2, correct2)); // Output: 1
	}
}