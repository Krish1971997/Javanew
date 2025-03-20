package zsecondround;

import java.util.HashMap;
import java.util.Map.Entry;

public class Program3 {
	
	public static void main(String[] args) {
		int[] arr= {8,12,8,15,12};
		System.out.println(findUnMatchedEarBud1(arr));
	}

	private static int findUnMatchedEarBud(int[] arr) {
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		
		for (int i = 0; i < arr.length; i++) 
			map.put(arr[i], map.getOrDefault(arr[i],0)+1);
		
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue()%2!=0)
				return entry.getKey();
		}	
		return 0;
	}
	
	private static int findUnMatchedEarBud1(int[] arr) {
		int number=arr[0];
		for (int i = 1; i < arr.length; i++) {
			number=number^arr[i];
		}
		return number;
	}
	
//	private static int findUnMatchedEarBud(int[] arr) {
//		
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = i+1; j < arr.length; j++) {
//				if(arr[i]==arr[j]) {
//					arr[i]=-1;
//					arr[i]=-1;
//				}
//			}
//		}
//			
//		return 0;
//	}
}
