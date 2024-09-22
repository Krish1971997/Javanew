package leetcodeZoho2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Meeting {
	int start;
	int end;
	int idx;

	public Meeting(int start, int end, int idx) {
		super();
		this.start = start;
		this.end = end;
		this.idx = idx;
	}	 
	
	@Override
	public int hashCode() {
        return Objects.hash(start, end, idx);
	}

}

public class MaximumMeetingInOneRoom {

	public static void main(String[] args) {
		// int[] start= {1,3,0,5,8,5};
		int[] start = { 75250, 50074, 43659, 8931, 11273, 27545, 50879, 77924 };
//		int finish[]= {2,4,6,7,9,9};
		int end[] = { 112960, 114515, 81825, 93424, 54316, 35533, 73383, 160252 };

		System.out.println(find(start, end));
	}

	public static List<Integer> find(int[] start, int[] end) {
		int n = start.length;

		List<Meeting> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(new Meeting(start[i], end[i], i + 1));
		}

		//Collections.sort(list);
		list.sort((o1, o2) -> o1.end-o2.end);
		List<Integer> result = new ArrayList<>();
		int lasttime = 0;
		for (Meeting meeting : list) {
			if (meeting.start > lasttime) {
				result.add(meeting.idx);
				lasttime = meeting.end;
			}
		}
		return result;
	}
}
