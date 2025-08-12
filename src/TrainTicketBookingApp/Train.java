package TrainTicketBookingApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeSet;

class InvalidDestinationException extends Exception {
	public InvalidDestinationException() {
		System.out.println("Destination must be greater than source or different from source.\n");
	}
}

public class Train {

	private final List<String> stoppages;
	private static final int MAX_SEATS = 8;
	private static final int MAX_WAITING_SEATS = 2;
	private final Map<String, List<Integer>> ticketToDifferentDestinations = new HashMap<>();
	private int currentWaitingList = 0;
	private int pnrNum = 0;
	private final Map<Integer, Ticket> totalTicketInfo = new HashMap<>();
	private boolean isTrainWaitingListAvailable = false;
	private final Queue<Ticket> pnrQueue = new LinkedList<>();
	private static final List<String> summary = new ArrayList<>();

	public Train(List<String> stoppages) {
		this.stoppages = stoppages;

		for (int i = 0; i < stoppages.size(); i++) {
			List<Integer> numOfTickets = new ArrayList<>();
			for (int j = 0; j < stoppages.size(); j++) {
				numOfTickets.add(i < j ? MAX_SEATS : 0);
			}
			ticketToDifferentDestinations.put(stoppages.get(i), numOfTickets);
		}
	}

	public int getAvailability(String source, String destination) throws InvalidDestinationException {
		if ((destination.compareTo(source) < 0) || source.equals(destination)) {
			throw new InvalidDestinationException();
		}

		List<Integer> noOfSeatAvailableList = ticketToDifferentDestinations.get(source);
		int numOfSeats = MAX_SEATS;

		int sourceIndex = stoppages.indexOf(source);
		int destinationIndex = stoppages.indexOf(destination);

		for (int i = sourceIndex + 1; i <= destinationIndex; i++) {
			numOfSeats = Math.min(noOfSeatAvailableList.get(i), numOfSeats);
		}
		return numOfSeats;
	}

	public int generatePnr() {
		return ++pnrNum;
	}

	public boolean getTrainWaitingListStatus() {
		return isTrainWaitingListAvailable;
	}

	public Ticket bookTicket(User user) {
		String ticketSource = user.getUserSource();
		String ticketDestination = user.getUserDestination();
		int ticketCount = user.getNoOfTickets();

		try {
			int currentAvailable = getAvailability(ticketSource, ticketDestination);
			int avlReservedTickets = MAX_WAITING_SEATS - currentWaitingList;

			if (ticketCount > currentAvailable || ticketCount > avlReservedTickets) {
				System.out.println("No tickets available");
				// summary(new Ticket(), "No tickets available", new TreeSet<>());
				// setEntryType(false);
				return null;
			}

			if (currentAvailable >= ticketCount) {
				System.out.println("Ticket booked successfully");
				updateTicketAvailability(ticketSource, ticketDestination, ticketCount, "TicketBooking");

				int pnrGeneratedNum = generatePnr();
				List<Integer> seats = seatsAssign(ticketCount, currentAvailable);
				Ticket ticket = new Ticket(pnrGeneratedNum, ticketSource, ticketDestination, ticketCount,
						TrainBookingStatus.Booked, seats);
				totalTicketInfo.put(pnrGeneratedNum, ticket);
				// summary(ticket, "booking", new TreeSet<>(seats));
				return ticket;
			} else if (currentWaitingList + ticketCount <= MAX_WAITING_SEATS) {
				System.out.println("You have been added to the waiting list");
				int pnrGeneratedNum = generatePnr();
				// List<Integer> seats = new ArrayList<>();
				isTrainWaitingListAvailable = true;
				currentWaitingList += ticketCount;

				// for (int i = 0; i < ticketCount; i++) {
				// seats.add(i + 1);
				// }

				Ticket ticket = new Ticket(pnrGeneratedNum, ticketSource, ticketDestination, ticketCount,
						TrainBookingStatus.WaitingList, null);
				totalTicketInfo.put(pnrGeneratedNum, ticket);
				pnrQueue.add(ticket);
				// summary(ticket, "WL", new TreeSet<>(seats));
				return ticket;
			} else {
				System.out.println("No tickets available");
				// summary(new Ticket(), "No tickets available", new TreeSet<>());
				return null;
			}
		} catch (Exception e) {
		}
		return null;
	}

	public void updateTicketAvailability(String source, String destination, int count, String callingFrom) {
		int sourceIndex = stoppages.indexOf(source);
		int destinationIndex = stoppages.indexOf(destination);

		for (int i = 0; i < stoppages.size(); i++) {
			List<Integer> noOfSeatAvailableList = ticketToDifferentDestinations.get(stoppages.get(i));

			for (int j = 0; j < noOfSeatAvailableList.size(); j++) {
				if (i < j && j >= sourceIndex && j <= destinationIndex) {
					int numOfSeats = noOfSeatAvailableList.get(j);
					if ("FromTicketCancellation".equals(callingFrom)) {
						numOfSeats += count;
					} else if ("TicketBooking".equals(callingFrom)) {
						numOfSeats -= count;
					}
					noOfSeatAvailableList.set(j, Math.max(0, numOfSeats));
				}
			}
			ticketToDifferentDestinations.put(stoppages.get(i), noOfSeatAvailableList);
		}
	}

	public Ticket cancelTicket(int pnr, int noOfSeats) {
		Ticket ticket = totalTicketInfo.get(pnr);
		List<Integer> seats = ticket.getSeatNums();
		int confirmedSeats = seats.size();

		if (confirmedSeats < noOfSeats) {
			System.out.println("Please provide proper information.");
			return null;
		}

		ticket.setNoOfTickets(confirmedSeats - noOfSeats);
		// TreeSet<Integer> cancelledSeats = new TreeSet<>();
		for (int i = 0; i < noOfSeats; i++) {
			// cancelledSeats.add(seats.remove(confirmedSeats - i - 1));
			seats.remove(confirmedSeats - i - 1);
		}
		ticket.setSeatNums(seats);

		System.out.println("Cancelled " + noOfSeats + " seats successfully");

		String source = ticket.getSource();
		String destination = ticket.getDestination();
		String from = "FromTicketCancellation";
		updateTicketAvailability(source, destination, noOfSeats, from);

//		summary(ticket, "cancel", cancelledSeats);

		// boolean isWaitingListAvailable = getTrainWaitingListStatus();
		if (isTrainWaitingListAvailable) {
			confirmWaitingList();
		}
		return ticket;
	}

	public void confirmWaitingList() {
		for (Ticket ticket : pnrQueue) {
			int noOfTickets = ticket.getNoOfTickets();
			String destination = ticket.getDestination();
			String source = ticket.getSource();
			int pnr = ticket.getPnr();

			try {
				int currentAvailable = getAvailability(source, destination);

				if (currentAvailable >= noOfTickets) {
					String from = "TicketBooking";
					updateTicketAvailability(source, destination, noOfTickets, from);
					currentWaitingList -= noOfTickets;

					List<Integer> seats = seatsAssign(noOfTickets, currentAvailable);
					ticket.setSeatNums(seats);
					ticket.setBookstatus(TrainBookingStatus.Booked);
					totalTicketInfo.put(pnr, ticket);
					if (pnrQueue.size() == 1)
						isTrainWaitingListAvailable = false;
					pnrQueue.poll();
					// summary(ticket, "booking", new TreeSet<>(seats));
				}
			} catch (InvalidDestinationException e) {
				e.printStackTrace();
			}
		}
	}

	public static void summary(Ticket ticket, String action, TreeSet<Integer> cancelledSeats) {
		StringBuilder sb = new StringBuilder();

		if ("cancel".equalsIgnoreCase(action)) {
			sb.append("PNR ").append(ticket.getPnr()).append(", ").append(ticket.getSource()).append(" to ")
					.append(ticket.getDestination()).append(", Seat Nos: ").append(ticket.getSeatNums())
					.append(" cancelled seats: ").append(cancelledSeats);
		} else if ("booking".equalsIgnoreCase(action)) {
			sb.append("PNR ").append(ticket.getPnr()).append(", ").append(ticket.getSource()).append(" to ")
					.append(ticket.getDestination()).append(", Seat Nos: ").append(ticket.getSeatNums());
		} else if ("WL".equalsIgnoreCase(action)) {
			String res = ticket.getSeatNums().stream().map(seat -> "WL" + seat).reduce((a, b) -> a + ", " + b)
					.orElse("");
			sb.append("PNR ").append(ticket.getPnr()).append(", ").append(ticket.getSource()).append(" to ")
					.append(ticket.getDestination()).append(", Seat Nos: ").append(res);

			/*
			 * else if ("WL".equalsIgnoreCase(string)) { String str = "WL"; String res = "";
			 * for (int i = 0; i < ticket.getSeatNums().size(); i++) { if (i <
			 * ticket.getSeatNums().size() - 1) res += str + ticket.getSeatNums().get(i) +
			 * ","; else res += str + ticket.getSeatNums().get(i); } summary.add("PNR " +
			 * ticket.getPnr() + ", " + ticket.getSource() + " to " +
			 * ticket.getDestination() + ",Seat Nos:" + res);
			 */
		} else {
			sb.append("No tickets available");
		}

		summary.add(sb.toString());
	}

	public void summaryPrint() {
		summary.forEach(System.out::println);
	}

	public void chart() {
		String[][] seatingChart = new String[MAX_SEATS][stoppages.size()];

		for (int i = 0; i < MAX_SEATS; i++) {
			Arrays.fill(seatingChart[i], " ");
		}

		for (Ticket ticket : totalTicketInfo.values()) {
			if (ticket.getBookstatus() == TrainBookingStatus.Booked && ticket.getNoOfTickets() > 0) {
				int sourceIndex = stoppages.indexOf(ticket.getSource());
				int destinationIndex = stoppages.indexOf(ticket.getDestination());

				for (int seatNum : ticket.getSeatNums()) {
					for (int i = sourceIndex; i < destinationIndex; i++)
						seatingChart[seatNum - 1][i] = "*";
				}
			}
		}

		for (String stop : stoppages) {
			System.out.print("\t" + stop);
		}
		System.out.println();

		for (int i = 0; i < MAX_SEATS; i++) {
			System.out.print((i + 1) + "\t");
			for (int j = 0; j < stoppages.size(); j++)
				System.out.print(seatingChart[i][j] + "\t");
			System.out.println();
		}
	}

	public static List<Integer> seatsAssign(int numOfTickets, int currentAvailability) {

		ArrayList<Integer> list = new ArrayList<>();
		int seatNo;
		for (int i = 0; i < numOfTickets; i++) {
			seatNo = MAX_SEATS - currentAvailability + 1;
			currentAvailability--;
			list.add(seatNo);
		}
		System.out.println("list --> " + list);
		return list;
	}
}

