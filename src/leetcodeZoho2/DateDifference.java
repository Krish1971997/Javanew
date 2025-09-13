package leetcodeZoho2;

public class DateDifference {
	private static final int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static int daysBetweenDates(String date1, String date2) {
		int numberOfDays1 = numberOfDays(date1);
		int numberOfDays2 = numberOfDays(date2);
		return Math.abs(numberOfDays2 - numberOfDays1);
	}

	public static int numberOfDays(String date) {
		int year = Integer.parseInt(date.substring(0, 4));
		int month = Integer.parseInt(date.substring(5, 7));
		int day = Integer.parseInt(date.substring(8, 10));

		int totalDays = 0;

		for (int i = 1971; i < year; i++) {
			if (isLeapYear(i)) {
				totalDays += 366;
			} else {
				totalDays += 365;
			}
		}

		for (int i = 0; i < month - 1; i++) {
			totalDays += months[i];
			if (i == 1 && isLeapYear(year)) { // feb month
				totalDays++;
			}
		}

		return totalDays + day;
	}

	public static boolean isLeapYear(int year) {
		return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
	}

	public static void main(String[] args) {
		String dt1 = "2025-05-25";
		String dt2 = "2025-04-20";
		System.out.println("Days between dates: " + daysBetweenDates(dt1, dt2));

		dt1 = "2000-02-10";
		dt2 = "2000-03-10";
		System.out.println("Days between dates: " + daysBetweenDates(dt1, dt2));

		dt1 = "2000-02-10";
		dt2 = "2000-02-10";
		System.out.println("Days between dates: " + daysBetweenDates(dt1, dt2));

		dt1 = "2000-02-01";
		dt2 = "2004-02-01";
		System.out.println("Days between dates: " + daysBetweenDates(dt1, dt2));
	}
}
