package prepinsta;

import java.util.Objects;

class HashCodeCheckObj {

	long key;
	String value;
	
    int capacity = 16; // Default capacity

	public HashCodeCheckObj(long key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
	
	@Override
	public int hashCode() {
		//return Objects.hash(key,value);
	     return (int)value.charAt(0);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HashCodeCheckObj other = (HashCodeCheckObj) obj;
		return key == other.key && Objects.equals(value, other.value);
	}
}

public class HashCodeCheck{
	public static void main(String[] args) {
		int key=4234;
		String value="Rest";
		HashCodeCheckObj h=new HashCodeCheckObj(key,value);
		System.out.println(h.hashCode());
		
		int hash = h.hashCode();
		int index = (h.capacity - 1) & hash;
		System.out.println("h.capacity -->"+h.capacity);
		System.out.println("Hash --> "+hash);
		System.out.println("index --> "+index);
	}
}