package leetcodeZoho;

public class Z_LastCountingValleys {

	static int countingValleys(int steps, String path) {
		int level = 0; // Start at sea level
		int valleys = 0;

		for (char step : path.toCharArray()) {
			if (step == 'U') {
				level++; // Going uphill
				if (level == 0) {
					valleys++; // Finished a valley
				}
			} else if (step == 'D') {
				level--; // Going downhill
			}
		}
		return valleys;
	}

	public static void main(String[] args) {
		int steps = 8;
		String path = "UDDDUDUU";
		int result = countingValleys(steps, path);
		System.out.println("Number of valleys: " + result); // Output: 1
	}
}
