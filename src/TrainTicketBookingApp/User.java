package TrainTicketBookingApp;

public class User {
	private final String userSource;
	private final String userDestination;
	private final int noOfTickets;

	public User(String source, String destination, int noOfTickets) {
		this.userSource = source;
		this.userDestination = destination;
		this.noOfTickets = noOfTickets;
	}

	public String getUserSource() {
		return userSource;
	}

	public String getUserDestination() {
		return userDestination;
	}

	public int getNoOfTickets() {
		return noOfTickets;
	}
}
