package statickeyword;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Program7 {

	static List<Stack> list = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		int size=0;
		//int[] space = { 5, 3, 4 };
		int spacelength=3;
		int[] space=new int[spacelength];
		for (int i = 0; i < spacelength; i++) {
			space[i]=sc.nextInt();
		}
		
		int va=Character.getNumericValue(0);
		for (int i = 0; i < space.length; i++) {
			System.out.println("Enter the array");
			Stack<Integer> stack = new Stack<>();
			for (int j = 0; j < space[i]; j++) {
				stack.add(sc.nextInt());
			}
			list.add(stack);
			if(size<stack.size())
				size=stack.size();
		}

		System.out.println("size : "+size);
	}

}
