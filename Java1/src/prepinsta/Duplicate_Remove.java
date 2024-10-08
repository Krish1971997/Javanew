package prepinsta;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Duplicate_Remove {
	
	public static void main(String[] args) {
		HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
		map.put(0, 0);
		
		HashSet<Integer> set=new HashSet<>();
		String[]s= {"sql","python","java","sql","python","java"};	
		removeDuplicates(s);
	}
	
	public static void removeDuplicates(String []s)
	{
		System.out.println("Original String :-");
		for (String string : s) {
			System.out.print(string+" ");
		}
		
		Set<String> str=new LinkedHashSet<>();
		for (int i = 0; i < s.length; i++) {
			str.add(s[i]);
		}
		
		String[] unique=new String[str.size()];
		str.toArray(unique);
		
		System.out.println("\nDuplicates removed String :");
		for (String string : unique) {
			System.out.print(string+" ");
		}
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
}
