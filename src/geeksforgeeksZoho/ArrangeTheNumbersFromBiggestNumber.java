package geeksforgeeksZoho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArrangeTheNumbersFromBiggestNumber {
	public static void main(String[] args) {
		String arr[] = { "34", "1", "3", "8", "7", "91", "9", "18", "0" };
		ArrayList<String> list = new ArrayList<String>();

		for (int i = 0; i < arr.length; i++)
			list.add(String.valueOf(arr[i]));

		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String s1 = o1 + o2;
				String s2 = o2 + o1;
				return s1.compareTo(s2) > 0 ? -1 : 1;
			}
		});

		/*
		 * list.sort((o1, o2) -> { String s1=o1+o2; String s2=o2+o1; return
		 * s1.compareTo(s2)>0?-1:1; });
		 */
		list.forEach(n->System.out.print(n));
		//System.out.println(list.toString());
	}
}
