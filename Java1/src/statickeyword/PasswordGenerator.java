package statickeyword;

import java.util.Scanner;

public class PasswordGenerator {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter the password length: ");
		int length=sc.nextInt();
		String letter="abcdefghijklmnopqrstuvwxyz"
				+ "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
				+ "0123456789"
				+ "!@#$%^&*()_-+=<>?";
		
		StringBuilder sb=new StringBuilder();
		System.out.println(letter.length());
		for (int i = 0; i < length; i++) {
			int n=(int)(letter.length()*Math.random());
			sb.append(letter.charAt(n));
		}
		System.out.println("Password ---> "+sb.toString());
	}
}
