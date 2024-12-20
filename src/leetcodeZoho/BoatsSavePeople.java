package leetcodeZoho;

import java.util.Arrays;

//leetcode.com/problems/boats-to-save-people/
public class BoatsSavePeople {
	public static void main(String[] args) {
		int[] people = { 1,2,2};
		int limit = 3;
		System.out.println(numRescueBoats(people, limit));
	}

	public static int numRescueBoats(int[] people, int limit) {
		Arrays.sort(people);
		int start = 0, end = people.length - 1;
		int count = 0;
		while (start <= end) {
			if (people[start] + people[end] <= limit) {
				start++;
			}
			end--;
			count++;
		}
		return count;
	}
}