package prepinsta;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
	public static void main(String[] args) {
		String[] words = { "This", "is", "an", "example", "of", "text", "justification." };
		List<String> cur = new ArrayList<>();
		for (String string : words) {
			cur.add(string);
		}
		System.out.println(cur);
	}

}
