package leetcodeZoho6;

import java.util.*;
//need to learn
public class MeetingConflictChecker {

    // Function to check if any new meeting overlaps with existing meetings
    public static boolean hasConflict(List<int[]> existing, List<int[]> newMeetings) {
        for (int[] newMeeting : newMeetings) {
            for (int[] existingMeeting : existing) {
                if (isOverlap(existingMeeting, newMeeting)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Check if two intervals overlap
    private static boolean isOverlap(int[] a, int[] b) {
        return a[0] < b[1] && b[0] < a[1]; // exclusive overlap
    }

    // Merge intervals
    public static List<int[]> mergeMeetings(List<int[]> meetings) {
        if (meetings.isEmpty()) return new ArrayList<>();

        // Sort by start time
        meetings.sort(Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();
        int[] current = meetings.get(0);

        for (int i = 1; i < meetings.size(); i++) {
            int[] next = meetings.get(i);
            if (current[1] >= next[0]) { // overlap or adjacent
                current[1] = Math.max(current[1], next[1]);
            } else {
                merged.add(current);
                current = next;
            }
        }
        merged.add(current);
        return merged;
    }

    public static void main(String[] args) {
        // 🧪 Test Case 1
        List<int[]> existing1 = Arrays.asList(new int[]{1, 3}, new int[]{5, 7}, new int[]{8, 12});
        List<int[]> new1 = Arrays.asList(new int[]{6, 9});

        processMeetings(existing1, new1);

        // 🧪 Test Case 2
        List<int[]> existing2 = Arrays.asList(new int[]{1, 3}, new int[]{5, 7}, new int[]{8, 12});
        List<int[]> new2 = Arrays.asList(new int[]{3, 5});

        processMeetings(existing2, new2);
    }

    public static void processMeetings(List<int[]> existing, List<int[]> newMeetings) {
        // Clone to avoid modifying original input
        List<int[]> schedule = new ArrayList<>(existing);
        if (hasConflict(schedule, newMeetings)) {
            System.out.println("Conflict");
        } else {
            schedule.addAll(newMeetings);
            List<int[]> merged = mergeMeetings(schedule);
            System.out.print("[");
            for (int i = 0; i < merged.size(); i++) {
                int[] interval = merged.get(i);
                System.out.print(Arrays.toString(interval));
                if (i != merged.size() - 1) System.out.print(", ");
            }
            System.out.println("]");
        }
    }
}
