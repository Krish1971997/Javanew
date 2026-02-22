package leetcodeZoho8;

import java.util.Scanner;

public class BinaryAddition {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter first binary number: ");
		String b1 = sc.next(); //1010

		System.out.print("Enter second binary number: ");
		String b2 = sc.next(); //1101

		String result = addBinary(b1, b2);
		System.out.println("Sum = " + result);
	}

	public static String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();

		int i = a.length() - 1;
		int j = b.length() - 1;
		int carry = 0;

		while (i >= 0 || j >= 0 || carry == 1) {

			int sum = carry;

			if (i >= 0)
				sum += a.charAt(i--) - '0';

			if (j >= 0)
				sum += b.charAt(j--) - '0';

			sb.append(sum % 2); // remainder
			carry = sum / 2; // carry
		}

		return sb.reverse().toString();
	}
}