package zoho3ndround_final;

import java.util.List;

public class TrainSeats {
	List<Character> list;
	int noOfSeats;
	String status;
	
	public TrainSeats(List<Character> list, int noOfSeats, String status) {
		this.list = list;
		this.noOfSeats = noOfSeats;
		this.status = status;
	}
	
	public List<Character> getList() {
		return list;
	}
	public void setList(List<Character> list) {
		this.list = list;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TrainSeats [list=" + list + ", noOfSeats=" + noOfSeats + ", status=" + status + "]";
	}
	
	
	
	
}
