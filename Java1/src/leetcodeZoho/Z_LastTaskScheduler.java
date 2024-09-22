package leetcodeZoho;

import java.util.Arrays;

public class Z_LastTaskScheduler {
	public static void main(String[] args) {
		Z_LastTaskScheduler scheduler = new Z_LastTaskScheduler();
		char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B','C','C','C' };
		int n = 4;
		// char[] tasks = {'A','A','A', 'B','B','B'}; int n = 3;
		System.out.println("Least number of units of times: " + scheduler.leastInterval(tasks, n)); // Output: 8
	}

	public int leastInterval(char[] tasks, int n) {
		int[] frequencies = new int[26];
		for (char task : tasks) {
			frequencies[task - 'A']++;
		}
		Arrays.sort(frequencies);
		int maxFrequency = frequencies[25] - 1;
		int idleSlots = maxFrequency * n;
		for (int i = 24; i >= 0; i--) {
			idleSlots -= Math.min(frequencies[i], maxFrequency);
		}
		return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
	}
}
