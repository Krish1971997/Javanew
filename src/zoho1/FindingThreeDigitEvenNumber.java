package zoho1;

import java.util.ArrayList;

public class FindingThreeDigitEvenNumber {
	public static void main(String[] args) {
		int[] digits = { 2, 2, 8, 8, 2 };
		int[] db = new int[10];
		for (int i = 0; i < digits.length; i++) {
			db[digits[i]]++;
		}
		ArrayList<Integer> ar = new ArrayList<Integer>();
		for (int i = 100; i <= 998; i = i + 2) {
			int[] freq = new int[10];
			int num = i;
			int rem;
			while (num > 0) {
				rem = num % 10;
				freq[rem]++;
				num = num / 10;
			}
			boolean ok = checkWithDB(db, freq);
			//System.out.println();
			if (ok) {
				ar.add(i);
			}
		}
		System.out.println(ar);
	}

	private static boolean checkWithDB(int[] db, int[] freq) {
		for (int i = 0; i < 10; i++) {
			if (db[i] < freq[i])
				return false;
		}
		return true;
	}
}
