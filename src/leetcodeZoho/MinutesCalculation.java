package leetcodeZoho;

public class MinutesCalculation {
	public int minOperations(String current, String correct) {
		int currHours = Integer.parseInt(current.substring(0, 2));
		int currMinutes = Integer.parseInt(current.substring(3, 5));
		int currSeconds = Integer.parseInt(current.substring(6));

		int correctHours = Integer.parseInt(correct.substring(0, 2));
		int correctMinutes = Integer.parseInt(correct.substring(3, 5));
		int correctSeconds = Integer.parseInt(correct.substring(6));

		int currTotalMinutes = currHours * 60 + currMinutes * 60 + currSeconds;
		int correctTotalMinutes = correctHours * 60 + correctMinutes * 60 + correctSeconds;

		int diffMinutes = Math.abs(currTotalMinutes - correctTotalMinutes);
		return diffMinutes;
	}

	public static void main(String[] args) {
		MinutesCalculation solution = new MinutesCalculation();

		String current1 = "02:30:05";
		String correct1 = "02:30:10";
		System.out.println(solution.minOperations(current1, correct1)); // Output: 3

		String current2 = "11:00:20";
		String correct2 = "11:01:30";
		System.out.println(solution.minOperations(current2, correct2)); // Output: 1
	}
}
