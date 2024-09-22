package zoho2ndround.secondRound;

public class Program3 {

	public static void main(String[] args) {
		double num = 3.25;

		int wholePart = (int) num;
		double fractionalPart = num - wholePart;
		int numerator = (int) (fractionalPart * 100); //25
		int gcd = gcd(numerator, 100); //25
		numerator = numerator / gcd;
		int denominator = 100 / gcd;

		System.out.println(wholePart + " " + numerator + "/" + denominator);
	}

	public static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}
}
