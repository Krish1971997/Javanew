package zoho;

/**
 * Write a program to give the following output for the given input
 * 
 * Eg 1: Input: a1b10 Output: abbbbbbbbbb Eg: 2: Input: b3c6d15 Output:
 * bbbccccccddddddddddddddd The number varies from 1 to 99.
 */
public class Solution3_a1b3c10 {
	/**public static void main(String[] args) {
		String s = "a10b2c5";
		String letter = "";
		int j = -1;
		int digit = 0;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isAlphabetic(s.charAt(i))) {
				letter += s.charAt(i);
				j++;
			} else {
				digit = Character.getNumericValue(s.charAt(i));
				if (i + 1 < s.length()) {
					if (Character.isDigit(s.charAt(i + 1))) {
						String a = String.valueOf(digit);
						a += s.charAt(i + 1);
						digit = Integer.parseInt(a);
					}
				}
				for (int k = 0; k < digit; k++) {
					System.out.print(letter.charAt(j));
				}
			}
		}
	} */
	
	 public static void main(String[] args) {
	        String s = "a10b2c5";
	        StringBuilder result = new StringBuilder(); // Use StringBuilder for efficient string concatenation

	        for (int i = 0; i < s.length(); i++) {
	            char currentChar = s.charAt(i);
	            if (Character.isAlphabetic(currentChar)) {
	                result.append(currentChar); // Append letters to the result
	            } else {
	                int digit = 0;
	                while (i < s.length() && Character.isDigit(s.charAt(i))) {
	                    digit = digit * 10 + Character.getNumericValue(s.charAt(i));
	                    i++;
	                }
	                i--; // Move back one position to process the character after the digit
	                for (int j = 1; j < digit; j++) {
	                    result.append(result.charAt(result.length() - 1));
	                    // Repeat the last character 'digit' times
	                }
	            }
	        }

	        System.out.println(result.toString());
	 }
}
