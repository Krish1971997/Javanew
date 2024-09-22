package zoho3ndround_final;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TrainticketBookingsystem {
	private static final int MAX_CONFIRMED_SEATS = 8;
	static Map<Integer, List<Character>> tickets = new LinkedHashMap<>();
	static final char SOURCE_LOCATION = 'A';
	static final char DESTINATION_LOCATION = 'E';
	private static Map<Integer, List<Character>> chart = new LinkedHashMap<>();
	private static Map<Integer, TrainSeats> main = new LinkedHashMap<>();
	private static List<String> printData = new ArrayList<String>();
	static int PNR = 1;

	TrainticketBookingsystem() {
		ticketstart();
	}

	public static void main(String[] args) {
		TrainticketBookingsystem train = new TrainticketBookingsystem();
		train.bookSeats('B', 'D', 2);
		train.bookSeats('A', 'E', 2);
		train.bookSeats('A', 'B', 2);
		print(tickets);
		print(chart);
		printMain(main);
	}

	public void ticketstart() {
		List<Character> arraylist = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			arraylist.add((char) (65 + i));
		}

		for (int i = 1; i <= 10; i++) {
			tickets.put(i, new ArrayList<>(arraylist));
		}
	}

	public void bookSeats(char source, char destination, int numSeats) {
		if (numSeats <= 0 || numSeats > MAX_CONFIRMED_SEATS) {
			System.out.println("Invalid number of seats");
			return;
		}

		if (isValidStation(source) && isValidStation(destination)) {
			for (Map.Entry<Integer, List<Character>> entry : tickets.entrySet()) {
				List<Character> seatList = entry.getValue();
				if (seatList.contains(source) && seatList.contains(destination)) {
					int startIndex = seatList.indexOf(source);
					int endIndex = seatList.indexOf(destination);

					int check = destination - source;
					if (seatList.size() >= check && startIndex < endIndex) {
						// Store the booked seats in the chart map
						List<Character> bookedSeats = seatList.subList(startIndex, endIndex + 1);
						chart.put(entry.getKey(), new ArrayList<>(bookedSeats));

						// Remove values between source and destination
						seatList.subList(startIndex, endIndex + 1).clear();
						System.out.println("Seats booked successfully!");
						TrainSeats trainseats=new TrainSeats(bookedSeats, numSeats, "Confirmed");
						main.put(PNR,trainseats);
						PNR++;
						return;
					}
				}
			}
		} else {
			System.out.println("Invalid source or destination station");
		}
	}
	
	public static void mainMap() {
		
	}

	private static boolean isValidStation(char station) {
		return station >= SOURCE_LOCATION && station <= DESTINATION_LOCATION;
	}

	public static void print(Map<Integer, List<Character>> map) {
		System.out.println("\nPrint the values:");
		for (Map.Entry<Integer, List<Character>> entry : map.entrySet()) {
			List<Character> seatList = entry.getValue();
			for (Character character : seatList) {
				System.out.println("Key : " + entry.getKey() + character);
			}
		}
	}
	
	public static void printMain(Map<Integer, TrainSeats> map) {
		System.out.println("\nPrint the values:");
		for (Entry<Integer, TrainSeats> entry : map.entrySet()) {
			TrainSeats seatList = entry.getValue();
			//seatList.toString();
		}
	}
}
