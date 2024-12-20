package leetcodeZoho5_dp;

import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateComparator implements Comparator<String> {

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	@Override
	public int compare(String date1, String date2) {
		LocalDate localDate1 = LocalDate.parse(date1, formatter);
		LocalDate localDate2 = LocalDate.parse(date2, formatter);

		return localDate1.compareTo(localDate2);
	}

	public static void main(String[] args) {
		List<String> dates = Arrays.asList("2024-12-06", "2022-05-15", "2023-08-01", "2021-11-10");

		Collections.sort(dates, new DateComparator());

		System.out.println("Sorted Dates (oldest first):");
		for (String date : dates) {
			System.out.println(date);
		}
	}
}
