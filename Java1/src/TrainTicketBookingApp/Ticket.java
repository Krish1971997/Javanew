package TrainTicketBookingApp;

import java.util.List;

public class Ticket {
	private int pnr;
	private String source;
	private String destination;
	private int noOfTickets;
	private boolean isConfirmed;
	private boolean isWaitinglist;
	private List<Integer> seatNums;

	public Ticket(int pnr, String source, String destination, int noOfTickets, boolean isConfirmed,
			boolean isWaitinglist, List<Integer> seatNums) {
		super();
		this.pnr = pnr;
		this.source = source;
		this.destination = destination;
		this.noOfTickets = noOfTickets;
		this.isConfirmed = isConfirmed;
		this.isWaitinglist = isWaitinglist;
		this.seatNums = seatNums;
	}

	public Ticket() {
	}

	public int getPnr() {
		return pnr;
	}

	public String getSource() {
		return source;
	}

	public String getDestination() {
		return destination;
	}

	public int getNoOfTickets() {
		return noOfTickets;
	}

	public void setNoOfTickets(int noOfTickets) {
		this.noOfTickets = noOfTickets;
	}

	public boolean isConfirmed() {
		return isConfirmed;
	}

	public void setConfirmed(boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}

	public void setWaitinglist(boolean isWaitinglist) {
		this.isWaitinglist = isWaitinglist;
	}

	public List<Integer> getSeatNums() {
		return seatNums;
	}

	public void setSeatNums(List<Integer> seatNums) {
		this.seatNums = seatNums;
	}

	@Override
	public String toString() {
		return "Ticket [pnr=" + pnr + ", source=" + source + ", destination=" + destination + ",noOfTickets="
				+ noOfTickets + ", isConfirmed=" + isConfirmed + ", isWaitinglist=" + isWaitinglist + ",seatNums="
				+ seatNums + "]";
	}
}