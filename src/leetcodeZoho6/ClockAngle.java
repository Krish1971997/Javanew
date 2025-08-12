package leetcodeZoho6;

//https://leetcode.com/problems/angle-between-hands-of-a-clock/description/

public class ClockAngle {
	public static void main(String[] args) {
		int hour = 12, minute = 30;
		System.out.println(findAngleClock(hour, minute));
	}

	private static double findAngleClock(int hour, int minute) {
		hour = hour % 12;

		System.out.println(hour);
		double minutes = minute * 6;

		System.out.println(minutes);
		double hours = hour * 30 + minute * 0.5;
		System.out.println(hours);

		double diff = Math.abs(minutes - hours);
		System.out.println(diff);

		return Math.min(diff, 360 - diff);
	}

}
