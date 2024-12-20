package zsecondround;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Program6 {
	public static void main(String[] args) {
		int[][] arr = { { 10, 13 },{ 9, 10 }, { 10, 12 }, { 11, 12 } };
		findNonOverLappingTask(arr);
	}

	private static void findNonOverLappingTask(int[][] arr) {
		List<Meeting> meeting = new ArrayList<Meeting>();
		for (int i = 0; i < arr.length; i++)
			meeting.add(new Meeting(arr[i][0], arr[i][1]));
		
		Collections.sort(meeting,new Comparator<Meeting>() {
			@Override
			public int compare(Meeting m1, Meeting m2) {
				if(m1.end==m2.end) {
					if(m1.start>m2.start) 
						return 1;
					else return -1;
				}
				return m1.end>m2.end?1:-1;
			}});

		int lastMeeting = 0;
		for (int i = 0; i < meeting.size(); i++) {
			if (meeting.get(i).start >= lastMeeting) {
				System.out.println(meeting.get(i));
				lastMeeting = meeting.get(i).end;
			}
		}
	}
}

class Meeting {
	int start;
	int end;

	Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {
		return "[" + start + "," + end + "]";
	}
}
