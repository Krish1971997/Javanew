package leetcodeZoho2;

import java.util.HashMap;

class Hashset<E> {
	private transient HashMap map;

	private static final Object PRESENT = new Object();

	public Hashset() {
		map = new HashMap<>();
	}

	public boolean add(E e) {
		return map.put(e, PRESENT) == null;
	}
}

public class Hashsetimpl
{     
    public static void main(String args[])  
    { 
     	Hashset hs = new Hashset(); 
          
        boolean b1 = hs.add("Geeks"); 
        boolean b2 = hs.add("GeeksforGeeks"); 
          
        boolean b3 = hs.add("Geeks"); 
          
        System.out.println("b1 = "+b1); 
        System.out.println("b2 = "+b2); 
        System.out.println("b3 = "+b3); 
          
        System.out.println(hs); 
              
    } 
} 