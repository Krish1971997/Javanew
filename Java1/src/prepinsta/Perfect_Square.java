package prepinsta;

import java.util.Scanner;

public class Perfect_Square {
	
	static Scanner s=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter the number");
		int x=s.nextInt();
		if(isPerfectSquare(x))
			System.out.println("The number is perfect");
		else
			System.out.println("The number is not perfect");
	}
	
	public static boolean isPerfectSquare(int x)
	{
		int sr=(int)(Math.sqrt(x));
		return (sr*sr==x);
	}
	
}
