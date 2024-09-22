package geeksforgeeksZoho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GroupAnagram {
	public static void main(String[] args) {
		String str[]= {"eat","tea","tan","ate","nat","bat"};
		Map<String, List<String>> map=new LinkedHashMap<String,List<String>>();
		
		for (String string : str) {
			char ch[]=string.toCharArray();
			Arrays.sort(ch);
			String s=String.valueOf(ch);
			
			if(map.containsKey(s)) {
				//List<String> list=map.get(s);
				//list.add(string);
				//map.put(s, list);
				map.get(s).add(string);
				
			} else {
				List<String> list=new ArrayList<String>();
				list.add(string);
				map.put(s, list);
			}
		}
		
		for (Entry<String, List<String>> linkedmap:map.entrySet()) {
			System.out.println(linkedmap.getValue());
		}
	}
	
	//https://studyalgorithms.com/string/leetcode-group-anagrams-solution/
	/**
	 *  private String getFrequencyString(String str) {

    // Frequency buckets
    int[] freq = new int[26];

    // Iterate over each character
    for (char c : str.toCharArray()) {
      freq[c - 'a']++;
    }

    // Start creating the frequency string
    StringBuilder frequencyString = new StringBuilder("");
    char c = 'a';
    for (int i : freq) {
      frequencyString.append(c);
      frequencyString.append(i);
      c++;
    }

    return frequencyString.toString();
  }
	 */
}
