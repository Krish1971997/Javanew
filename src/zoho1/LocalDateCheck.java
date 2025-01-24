package zoho1;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LocalDateCheck {
	public static void main(String[] args) {
		LocalDate currentDate = LocalDate.now();
		String date1="2025-01-24";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date =LocalDate.parse(date1, formatter);
        System.out.println("Local date -> "+date);
        String currentDateString = currentDate.format(formatter);

        // Parse the formatted string back into a Date object
        Date installationDate = parseDate(currentDateString);
        System.out.println(installationDate);
	}
	private static Date parseDate(String dateStr) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		} catch (Exception e) {
			return null;
		}
	}
}
