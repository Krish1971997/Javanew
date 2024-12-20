package java8;

import java.util.Set;
import java.util.TreeSet;

public class AscendingOrder {

	public static void main(String[] args) {
		int arr[]= {5,8,1,2,9,6,3};
		
		Set<Integer>list=new TreeSet();
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}
		
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}
}
