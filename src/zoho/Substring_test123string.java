package zoho;

public class Substring_test123string {

	/*
	 * 112. Find if a String2 is substring of String1. If it is, return the index of
	 * the first occurrence.else return -1. Eg 1:Input:String 1: test123string
	 * String 2: 123 Output: 4 Eg 2: Input:String 1: testing12 String 2: 1234
	 * Output: -1
	 */

	public static void main(String[] args) {
		String str1 = "testing12", num = "";
		String str2 = "1234";
		int position = 0;
		boolean check = true;
		for (int i = 0; i < str1.length(); i++) {
			if (Character.isDigit(str1.charAt(i))) {
				num += str1.charAt(i);
				if (check) {
					position = i;
					check = false;
				}
			}
		}
		int num1 = Integer.parseInt(num);
		int num2 = Integer.parseInt(str2);
		if (num1 == num2) {
			System.out.println(position);
		} else
			System.out.println("-1");
	}
}
