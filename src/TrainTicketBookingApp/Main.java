package TrainTicketBookingApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	final static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		List<String> stoppages = new ArrayList<>();
		stoppages.add("A");
		stoppages.add("B");
		stoppages.add("C");
		stoppages.add("D");
		stoppages.add("E");
		Train train = new Train(stoppages);

		while (true) {
			System.out.println("Enter command to Book or cacel or chart or Enter 0 to exit");
			String command = sc.next();

			if ("chart".equalsIgnoreCase(command)) {
				//train.summaryPrint();
				train.chart();
			} else if ("0".equals(command)) {
				System.out.println("Exited from application");
				System.exit(0);
			} else {
				String[] arr = command.split(",");
				if (arr.length == 4 && arr[0].equalsIgnoreCase("book")) {
					String source = arr[1].toUpperCase();
					String destination = arr[2].toUpperCase();
					int noOfTickets = Integer.parseInt(arr[3]);
					User book = new User(source, destination, noOfTickets);
					Ticket ticket = train.bookTicket(book);
					System.out.println(ticket);
					
				} else if (arr.length == 3 && arr[0].equalsIgnoreCase("cancel")) {
					int pnr = Integer.parseInt(arr[1]);
					int noOfTickets = Integer.parseInt(arr[2]);
					Ticket ticket = train.cancelTicket(pnr, noOfTickets);
					System.out.println(ticket);
				}
			}
		}
	}
}