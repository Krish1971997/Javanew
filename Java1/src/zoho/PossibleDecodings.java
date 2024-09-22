/*
 *Let 1 represent ‘A’, 2 represents ‘B’, etc. Given a digit sequence, 
count the number of possible decodings of the given digit sequence.

Examples:

Input: digits[] = “121”
Output: 3 // The possible decodings are “ABA”, “AU”, “LA”

Input: digits[] = “1234” Output: 3

// The possible decodings are “ABCD”, “LCD”, “AWD”
 */
package zoho;

import java.util.*;

//A naive recursive Java implementation
//to count number of decodings that
//can be formed from a given digit sequence

public class PossibleDecodings {

	// recurring function to find
	// ways in how many ways a
	// string can be decoded of length
	// greater than 0 and starting with
	// digit 1 and greater.
	static int countDecoding(char[] digits, int n) {
		// base cases
		if (n == 0 || n == 1)
			return 1;

		// for base condition "01123" should return 0
		if (digits[0] == '0')
			return 0;

		// Initialize count
		int count = 0;

		// If the last digit is not 0, then
		// last digit must add to
		// the number of words
		if (digits[n - 1] > '0')
			count = countDecoding(digits, n - 1);

		// If the last two digits form a number
		// smaller than or equal to 26,
		// then consider last two digits and recur
		if (digits[n - 2] == '1' || (digits[n - 2] == '2' && digits[n - 1] < '7'))
			count += countDecoding(digits, n - 2);

		return count;
	}

	// Given a digit sequence of length n,
	// returns count of possible decodings by
	// replacing 1 with A, 2 with B, ... 26 with Z
	static int countWays(char[] digits, int n) {
		if (n == 0 || (n == 1 && digits[0] == '0'))
			return 0;
		return countDecoding(digits, n);
	}

	// Driver code
	public static void main(String[] args) {
		char digits[] = { '1', '2', '3', '4' };
		int n = digits.length;
		System.out.printf("Count is %d", countWays(digits, n));
	}
}

/**public class PossibleDecodings {
	public static void main(String[] args) {
		char ch='A'; int passingvalue=0;
		Map<Integer, Character> decode=new HashMap<>();
		List<String> list=new ArrayList<>();
		String concat=""; 
		for (int i = 1; i <= 26; i++,ch++) {
			decode.put(i, ch);
		}
		
		//int digits[] = {1,2,1};
		String digits[] = {"1","2","1"};
		for (int i = 0; i < digits.length; i++) {
			passingvalue=Integer.parseInt(digits[i]);
			Character value=decode.get(passingvalue);
			concat+=value;
		}
		for (int i = 0,j=i+1; j < digits.length; i++) {
			digits[i]+digits[j]
		}
		
		Character value=decode.get(1);
		System.out.println("length"+digits.length);
		System.out.println("Value "+value);
		System.out.println("Concat "+concat);
		
		for (Map.Entry<Integer, Character> entry : decode.entrySet()) {
			Integer key = entry.getKey();
			Character val = entry.getValue();
			System.out.println(key+" ---> "+val);
			
		}
	}
}
*/