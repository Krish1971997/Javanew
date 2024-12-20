package geeksforgeeksZoho;

public class LeapYear {
	public static void main(String[] args) {
		int year = 1904;
		if ((year % 400 == 0) || (year % 100 != 0 && year % 4 == 0)) {
			System.out.println("Leap year");
		} else
			System.out.println("Not Leap year");
	}
}
