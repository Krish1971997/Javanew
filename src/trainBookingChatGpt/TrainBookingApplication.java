package trainBookingChatGpt;

import java.util.*;

//Enum for representing stations
enum Station {
 A, B, C, D, E
}

//Ticket class to represent a ticket
class Ticket {
 private static int pnrCounter = 1;
 private int pnr;
 private Station source;
 private Station destination;
 private int numSeats;
 private String status;
 private List<String> seatNumbers;

 public Ticket(Station source, Station destination, int numSeats) {
     this.pnr = pnrCounter++;
     this.source = source;
     this.destination = destination;
     this.numSeats = numSeats;
     this.status = "Booked";
     this.seatNumbers = new ArrayList<>();
 }

 public int getPnr() {
     return pnr;
 }

 public Station getSource() {
     return source;
 }

 public Station getDestination() {
     return destination;
 }

 public int getNumSeats() {
     return numSeats;
 }

 public String getStatus() {
     return status;
 }

 public void cancelSeats(int seats) {
     this.numSeats -= seats;
     if (this.numSeats == 0) {
         this.status = "Cancelled";
     }
 }

 public void setSeatNumbers(List<String> seatNumbers) {
     this.seatNumbers = seatNumbers;
 }

 public List<String> getSeatNumbers() {
     return seatNumbers;
 }

 @Override
 public String toString() {
     return "PNR " + pnr + ", " + source + " to " + destination + ", Seats: " + seatNumbers + ", Status: " + status;
 }
}

//Train class to manage the booking and cancellation of tickets
class Train {
 private static final int TOTAL_SEATS = 8;
 private static final int WAITING_LIST_CAPACITY = 2;
 private Map<Integer, Ticket> tickets;
 private Queue<Ticket> waitingList;
 private boolean[] seats;

 public Train() {
     this.tickets = new HashMap<>();
     this.waitingList = new LinkedList<>();
     this.seats = new boolean[TOTAL_SEATS];
 }

 public void bookTicket(Station source, Station destination, int numSeats) {
     if (numSeats <= 0 || numSeats > TOTAL_SEATS) {
         System.out.println("Invalid number of seats requested.");
         return;
     }

     int availableSeats = countAvailableSeats(source, destination);
     if (availableSeats >= numSeats) {
         allocateSeats(source, destination, numSeats);
     } else if (waitingList.size() < WAITING_LIST_CAPACITY) {
         allocateWaitingList(source, destination, numSeats);
     } else {
         System.out.println("No seats available.");
     }
 }

 public void cancelTicket(int pnr, int numSeats) {
     Ticket ticket = tickets.get(pnr);
     if (ticket == null) {
         System.out.println("Invalid PNR.");
         return;
     }

     if (numSeats <= 0 || numSeats > ticket.getNumSeats()) {
         System.out.println("Invalid number of seats to cancel.");
         return;
     }

     ticket.cancelSeats(numSeats);
     System.out.println(ticket);

     // Update seat allocation
     if (ticket.getStatus().equals("Cancelled")) {
         for (String seat : ticket.getSeatNumbers()) {
             if (seat.startsWith("WL")) {
                 waitingList.remove(ticket);
             } else {
                 int seatIndex = Integer.parseInt(seat) - 1;
                 seats[seatIndex] = false;
             }
         }
         tickets.remove(pnr);
     }

     moveFromWaitingList();
 }

 public void printChart() {
     System.out.println("Booking Summary:");
     for (Ticket ticket : tickets.values()) {
         System.out.println(ticket);
     }

     System.out.println("\nChart:");
     System.out.println("\tA\tB\tC\tD\tE");
     for (int i = 0; i < TOTAL_SEATS; i++) {
         System.out.print((i + 1) + "\t");
         for (Station station : Station.values()) {
             if (seats[i]) {
                 System.out.print("*\t");
             } else {
                 System.out.print("\t");
             }
         }
         System.out.println();
     }
 }

 private int countAvailableSeats(Station source, Station destination) {
     int count = 0;
     for (boolean seat : seats) {
         if (!seat) {
             count++;
         }
     }
     return count;
 }

 private void allocateSeats(Station source, Station destination, int numSeats) {
     Ticket ticket = new Ticket(source, destination, numSeats);
     List<String> seatNumbers = new ArrayList<>();

     for (int i = 0; i < seats.length && seatNumbers.size() < numSeats; i++) {
         if (!seats[i]) {
             seats[i] = true;
             seatNumbers.add(String.valueOf(i + 1));
         }
     }

     ticket.setSeatNumbers(seatNumbers);
     tickets.put(ticket.getPnr(), ticket);
     System.out.println(ticket);
 }

 private void allocateWaitingList(Station source, Station destination, int numSeats) {
     Ticket ticket = new Ticket(source, destination, numSeats);
     List<String> seatNumbers = new ArrayList<>();

     for (int i = 1; i <= numSeats; i++) {
         seatNumbers.add("WL" + waitingList.size() + 1);
     }

     ticket.setSeatNumbers(seatNumbers);
     waitingList.add(ticket);
     tickets.put(ticket.getPnr(), ticket);
     System.out.println(ticket);
 }

 private void moveFromWaitingList() {
     for (Iterator<Ticket> it = waitingList.iterator(); it.hasNext();) {
         Ticket waitingTicket = it.next();
         if (countAvailableSeats(waitingTicket.getSource(), waitingTicket.getDestination()) >= waitingTicket.getNumSeats()) {
             allocateSeats(waitingTicket.getSource(), waitingTicket.getDestination(), waitingTicket.getNumSeats());
             it.remove();
         }
     }
 }
}

//Main class to run the application
public class TrainBookingApplication {
 public static void main(String[] args) {
     Train train = new Train();
     Scanner scanner = new Scanner(System.in);

     while (true) {
         System.out.println("Enter command:");
         String command = scanner.nextLine();
         String[] parts = command.split(",");
         switch (parts[0]) {
             case "book":
                 train.bookTicket(Station.valueOf(parts[1]), Station.valueOf(parts[2]), Integer.parseInt(parts[3]));
                 break;
             case "cancel":
                 train.cancelTicket(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                 break;
             case "chart":
                 train.printChart();
                 break;
             default:
                 System.out.println("Invalid command.");
         }
     }
 }
}
