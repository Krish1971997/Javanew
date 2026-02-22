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
		double minutes = minute * 6;  //360/60 =6 mins

		System.out.println(minutes);
		double hours = hour * 30 + minute * 0.5;   // 360 = 12 = 30 min then  ==> 30/60 = 0.5 min
		System.out.println(hours);

		double diff = Math.abs(minutes - hours);
		System.out.println(diff);

		return Math.min(diff, 360 - diff);
	}
	
//முக்கியம்: 1 minute move ஆவதற்கு hour hand 0.5 degrees move ஆகும்.ஏன்?
//1 hour = 30°
//அதாவது 60 minutes = 30°
//அப்படின்னா 1 minute = 30 / 60 = 0.5°

}
