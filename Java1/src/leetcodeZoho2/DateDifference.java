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

		int totaldays = 0;
		for (int i = 1971; i < year; i++) {
			if ((i % 400 == 0) || (i % 100 != 0 && i % 4 == 0)) {
				totaldays += 366;
			} else {
				totaldays += 365;
			}
		}

		for (int i = 0; i < month - 1; i++) {
			totaldays += months[i];
			if (i == 1 && (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
				totaldays++;
			}
		}
		return totaldays + day;
	}

	public static void main(String[] args) {
		String dt1 = "2014-02-10";
		String dt2 = "2015-03-10";
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
