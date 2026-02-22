package leetcodeZoho7;

public class CurrencyDenomination {

	public static void findDenominations(int amount) {
		int[] notes = { 1000, 500, 100, 50, 20, 10 };

		for (int note : notes) {
			if (amount >= note) {
				int count = amount / note;
				System.out.println(note + " -> " + count);
				amount = amount % note;
			}
		}
	}

	public static void main(String[] args) {
		int amount = 1700;
		findDenominations(amount);
	}
}
