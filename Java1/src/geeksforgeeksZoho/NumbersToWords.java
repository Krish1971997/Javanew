package geeksforgeeksZoho;

public class NumbersToWords {
	
	private static final String[] units = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
			"Nine" };
	private static final String[] teens = { "", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
			"Seventeen", "Eighteen", "Nineteen" };
	private static final String[] tens = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
			"Eighty", "Ninety" };
	private static final String[] thousands = {
            "", "Thousand", "Million", "Billion", "Trillion"};

	public static void main(String[] args) {
		System.out.println(convertToWords(54694)); 
	}

	public static String convertToWords(int num) {
		if (num == 0) 
			return "Zero";
		return convertToWordsHelper(num);
	}

	private static String convertToWordsHelper(int num) {
		if (num < 10) {
			return units[num];
		} else if (num < 20) {
			return teens[num - 10];
		} else if (num < 100) {
			return tens[num / 10] + " " + convertToWordsHelper(num % 10);
		} else if (num < 1000) {
			return units[num / 100] + " Hundred " + convertToWordsHelper(num % 100);
		} else if (num < 10000) {
			return units[num / 1000] + " Thousand " + convertToWordsHelper(num % 1000);
		} else if (num < 20000) {
			return teens[(num / 1000) - 10] + " Thousand " + convertToWordsHelper(num % 1000);
		} else {
			return tens[num / 10000] + " " + convertToWordsHelper(num % 10000);
		}
	}
}