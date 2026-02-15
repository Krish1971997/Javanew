package codetesting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class TestProgram {
	public static void main(String[] args) {
		HashMap<Key, String> map =new HashMap<>();
		map.put(new Key(1), "apple");
		map.put(new Key(1), "apple1");
		System.out.println(map.size());
		
		
		List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
        list.add(4);
	}

}


class Key {
    int id;
Key(int id) {
        this.id = id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Key)) return false;
        Key key = (Key) o;
        return id == key.id;
    }
    
    @Override
    public int hashCode() {
    	return Objects.hashCode(id);
    }
}