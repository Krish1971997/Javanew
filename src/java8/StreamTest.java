package java8;

import java.util.ArrayList;
import java.util.List;

public class StreamTest {
	
	public static void main(String[] args) {
		System.out.println(ReverseStringSplitUpUsingDots.stringReverse);
		List stack=new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			stack.add(i);
		}
		
		stack.stream().forEach(n-> System.out.println(n));
	}

}
