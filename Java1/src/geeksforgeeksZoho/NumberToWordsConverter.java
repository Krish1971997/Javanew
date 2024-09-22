package geeksforgeeksZoho;

public class NumberToWordsConverter {

	private static final String[] units = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
			"Nine" };

	private static final String[] teens = { "", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
			"Seventeen", "Eighteen", "Nineteen" };

	private static final String[] tens = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
			"Eighty", "Ninety" };

	private static final String[] thousands = { "", "Thousand", "Million", "Billion", "Trillion" };

	public static String convertToWords(int number) {
		if (number == 0) {
			return "Zero";
		}

		int i = 0;
		String words = "";

		while (number > 0) {
			if (number % 1000 != 0) {
				words = convertChunkToWords(number % 1000) + thousands[i] + " " + words;
			}
			number /= 1000;
			i++;
		}
		return words.trim();
	}

	private static String convertChunkToWords(int number) {
		if (number == 0) {
			return "";
		}

		String words = "";

		if (number >= 100) {
			words += units[number / 100] + " Hundred ";
			number %= 100;
		}

		if (number > 0) {
			if (number >= 11 && number <= 19) {
				words += teens[number - 10] + " ";
			} else {
				words += tens[number / 10] + " ";
				number %= 10;

				if (number > 0) {
					words += units[number] + " ";
				}
			}
		}

		return words;
	}

	public static void main(String[] args) {
		// Examples
		int num1 = 237764;
		int num2 = 345;

		System.out.println(num1 + " in words: " + convertToWords(num1));
		System.out.println(num2 + " in words: " + convertToWords(num2));
	}
}
