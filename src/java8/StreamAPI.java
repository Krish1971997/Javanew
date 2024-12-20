package java8;

import java.util.Arrays;
import java.util.List;

public class StreamAPI {
	
	public static void main(String[] args) {
		List<Integer> list=Arrays.asList(1,3,9,7,2,6,5,4,10);
		
		
		list.stream().filter(n->n%2==1).forEach(n->System.out.println(n));
	}

}


