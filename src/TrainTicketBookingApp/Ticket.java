package TrainTicketBookingApp;

import java.util.List;

public class Ticket {
	private int pnr;
	private String source;
	private String destination;
	private int noOfTickets;
	private TrainBookingStatus bookstatus;
	private List<Integer> seatNums;

	public Ticket(int pnr, String source, String destination, int noOfTickets, TrainBookingStatus bookstatus,
			List<Integer> seatNums) {
		super();
		this.pnr = pnr;
		this.source = source;
		this.destination = destination;
		this.noOfTickets = noOfTickets;
		this.bookstatus = bookstatus;
		this.seatNums = seatNums;
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

	public TrainBookingStatus getBookstatus() {
		return bookstatus;
	}

	public void setBookstatus(TrainBookingStatus bookstatus) {
		this.bookstatus = bookstatus;
	}

	public List<Integer> getSeatNums() {
		return seatNums;
	}

	public void setSeatNums(List<Integer> seatNums) {
		this.seatNums = seatNums;
	}

	@Override
	public String toString() {
		return "Ticket [pnr=" + pnr + ", source=" + source + ", destination=" + destination + ", noOfTickets="
				+ noOfTickets + ", bookstatus=" + bookstatus + ", seatNums=" + seatNums + "]";
	}

}