package leetcodeZoho3;

import java.util.*;

public class DateDifferenceManual {

	// Days in each month (non-leap year by default)
	static int[] monthDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter From date (dd-mm-yyyy): ");
		String[] from = "25-05-2025".split("-");
		int d1 = Integer.parseInt(from[0]);
		int m1 = Integer.parseInt(from[1]);
		int y1 = Integer.parseInt(from[2]);

		System.out.print("Enter To date (dd-mm-yyyy): ");
		String[] to = "20-04-2025".split("-");
		int d2 = Integer.parseInt(to[0]);
		int m2 = Integer.parseInt(to[1]);
		int y2 = Integer.parseInt(to[2]);

		findDifference(d1, m1, y1, d2, m2, y2);

		sc.close();
	}

	static boolean isLeapYear(int year) {
		if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0))
			return true;
		return false;
	}

	public static void findDifference(int d1, int m1, int y1, int d2, int m2, int y2) {

		if ((y1 > y2) || (y1 == y2 && m1 > m2) || (y1 == y2 && m1 == m2 && d1 > d2)) {
			int tempD = d1, tempM = m1, tempY = y1;
			d1 = d2;
			m1 = m2;
			y1 = y2;
			d2 = tempD;
			m2 = tempM;
			y2 = tempY;
		}

		if (isLeapYear(y2)) {
			monthDays[1] = 29;
		} else {
			monthDays[1] = 28;
		}

		// If day of from-date is greater, borrow days from previous month
		if (d1 > d2) {
			d2 += monthDays[(m2 - 2 + 12) % 12]; // borrow from prev month
			m2 -= 1;
		}

		// If month of from-date is greater, borrow from year
		if (m1 > m2) {
			m2 += 12; //twelve
 			y2 -= 1;
		}

		int finalDay = d2 - d1;
		int finalMonth = m2 - m1;
		int finalYear = y2 - y1;

		System.out.println(finalYear + " years, " + finalMonth + " months, " + finalDay + " days");
	}
}
