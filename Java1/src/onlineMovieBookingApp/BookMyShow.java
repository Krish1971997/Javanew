package onlineMovieBookingApp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class BookMyShow {
	ArrayList<Theater> theaters;
	static HashMap<String, ArrayList<Show>> movieMap;

	private void generateMovieMap() {
		for (Theater theater : theaters) {
			ArrayList<Show> showArray = theater.getShows();
			for (Show show : showArray) {
				if (show != null) {
					if (movieMap.containsKey(show.getMovie().getName())) {
						movieMap.get(show.getMovie().getName()).add(show);
					} else {
						ArrayList<Show> movieShowList = new ArrayList<>();
						movieShowList.add(show);
						movieMap.put(show.getMovie().getName(), movieShowList);
					}
				}
			}
		}
	}

	public BookMyShow(ArrayList<Theater> theaters) {
		this.theaters = theaters;
		this.movieMap = new HashMap<>();
		generateMovieMap();
// System.out.println(movieMap);
	}

	public static ArrayList<Show> searchShows(String movieName) {
		if (movieMap.containsKey(movieName)) {
			return movieMap.get(movieName);
		} else
			return null;
	}

	public static void main(String[] args) {
// Creating Guest User --> Piyush
		GuestUser piyush = new GuestUser("Piyush");
		RegisteredUser ayush = new RegisteredUser("Ayush");
		RegisteredUser saurabh = new RegisteredUser("Saurabh");
		System.out.println(piyush.getName());
		System.out.println(ayush.getName());
		System.out.println(saurabh.getName());
// Creating Movie object --> Iron Man
		Movie ironMan = new Movie("Iron Man", Language.ENGLISH, Genre.ACTION);
		Movie avengers = new Movie("Avengers: End Game", Language.ENGLISH, Genre.ACTION);
		Movie walkToRemember = new Movie("The Walk To Remember", Language.ENGLISH, Genre.ROMANCE);
		Movie housefull = new Movie("HouseFull 2", Language.HINDI, Genre.COMEDY);
		System.out.println(ironMan);
		System.out.println(avengers);
		System.out.println(walkToRemember);
		System.out.println(housefull);
// Creating Theater
		Theater pvr_gip = new Theater("PVR", "GIP Noida", 30);
		Theater big_cinema = new Theater("Big Cinema", "Sector 137 Noida", 40);
		System.out.println(pvr_gip);
		System.out.println(big_cinema);
		Show show1 = null, show2 = null, show3 = null, show4 = null;
		SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMM dd, yyyyHH:mm:ss a");
		try {
			String dateInString = "Friday, Jun 7, 2024 09:00:00 AM";
			Date date = formatter.parse(dateInString);
			show1 = new Show(date, ironMan, pvr_gip);
			System.out.println(show1);
			dateInString = "Friday, Jun 7, 2024 12:00:00 PM";
			date = formatter.parse(dateInString);
			show2 = new Show(date, housefull, pvr_gip);
			System.out.println(show2);
// BIG-CINEMA
			dateInString = "Friday, Jun 7, 2024 09:00:00 AM";
			date = formatter.parse(dateInString);
			show3 = new Show(date, walkToRemember, big_cinema);
			System.out.println(show3);
// BIG-CINEMA
			dateInString = "Friday, Jun 7, 2024 12:00:00 PM";
			date = formatter.parse(dateInString);
			show4 = new Show(date, walkToRemember, big_cinema);
			System.out.println(show4);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		ArrayList<Theater> theaterArrayList = new ArrayList<>();
		theaterArrayList.add(pvr_gip);
		theaterArrayList.add(big_cinema);
		System.out.println("Thetre list :" + theaterArrayList);
		BookMyShow bookMyShow = new BookMyShow(theaterArrayList);
		ArrayList<Show> searchedShow = BookMyShow.searchShows("Iron Man");
		Show bookingShow = searchedShow.get(0);
		System.out.println("bookingShow : " + bookingShow);
		TicketBookingThread t1 = new TicketBookingThread(bookingShow, ayush, 10);
		TicketBookingThread t2 = new TicketBookingThread(bookingShow, saurabh, 10);
		TicketBookingThread t3 = new TicketBookingThread(bookingShow, saurabh, 10);
		t1.start();
		t2.start();
		t3.start();
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Ticket ayush_ticket = t1.getTicket();
		Ticket saurabh_ticket = t2.getTicket();
		Ticket saurabh_ticket2 = t3.getTicket();
		System.out.println(ayush_ticket);
		System.out.println(saurabh_ticket);
		System.out.println(saurabh_ticket2);
		searchedShow = BookMyShow.searchShows("HouseFull 2");
		bookingShow = searchedShow.get(0);
		TicketBookingThread t4 = new TicketBookingThread(bookingShow, ayush, 15);
		TicketBookingThread t5 = new TicketBookingThread(bookingShow, saurabh, 10);
// t5.start();
		t4.start();
		try {
			t4.join();
			t5.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Ticket ayushNewTicket = t4.getTicket();
// Ticket saurabhNewTicket = t5.getTicket();
		System.out.println(ayushNewTicket);
// System.out.println(saurabhNewTicket);
	}
}

enum Genre {
	ACTION, ROMANCE, COMEDY, THRILLER, HORROR
}

class GuestUser extends User {
	public GuestUser(String name) {
		super(name);
	}

	public void register(String username, String password) {
	}
}

enum Language {
	TELUGU, TAMIL, ENGLISH, HINDI
}

class Movie {
	private String name;
	private float rating = 0.0f;
	private Language language;
	private Genre genre;

	public Movie(String name, Language language, Genre genre) {
		this.name = name;
		this.language = language;
		this.genre = genre;
	}

	public String getName() {
		return name;
	}

	public float getRating() {
		return rating;
	}

	public Language getLanguage() {
		return language;
	}

	public Genre getGenre() {
		return genre;
	}

	@Override
	public String toString() {
		return "Movie [name=" + name + ", language=" + language + ", genre=" + genre + "]";
	}
}

class RegisteredUser extends User {
	public ArrayList<Ticket> bookingHistory;

	public RegisteredUser(String name) {
		super(name);
		this.bookingHistory = new ArrayList<>();
	}

	public void cancelTicket(Ticket ticket) {
	}
}