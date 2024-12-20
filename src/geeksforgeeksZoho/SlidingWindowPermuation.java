package geeksforgeeksZoho;

//https://www.youtube.com/watch?v=D3k7RxFz3Ho&list=RDCMUCz-SkYwTxLdcYF6efMrtssg&index=6
public class SlidingWindowPermuation {
	
//	public class PermutationInString {
	    public static boolean checkInclusion(String s1, String s2) {
	        if (s1.length() > s2.length()) 
	            return false;

	        int[] count = new int[26];

	        // Count occurrences of characters in s1
	        for (char c : s1.toCharArray()) {
	            count[c - 'a']++;
	        }

	        // Use sliding window approach
	        for (int i = 0; i < s2.length(); i++) {
	            char currentChar = s2.charAt(i);

	            // Decrease count for the outgoing character
	            if (i >= s1.length()) {
	                char outgoingChar = s2.charAt(i - s1.length());
	                count[outgoingChar - 'a']++;
	            }

	            // Increase count for the current character
	            count[currentChar - 'a']--;

	            // Check if the current window is a permutation of s1
	            if (i >= s1.length() - 1 && allZeros(count)) {
	                return true;
	            }
	        }

	        return false;
	    }

	    private static boolean allZeros(int[] count) {
	        for (int num : count) {
	            if (num != 0) {
	                return false;
	            }
	        }
	        return true;
	    }

	    public static void main(String[] args) {
	        // Test cases
	        System.out.println(checkInclusion("abcd", "eidbacooo"));  // Output: true
	        System.out.println(checkInclusion("ab", "eidboaoo"));  // Output: false
	    }
	}

	
	
/*	public static void main(String[] args) {
		String s1 = "abcd", s2 = "eidbacoooo";
		
		if(slidingwindowPermuatationcheck(s1,s2))
			System.out.println("True");
		else
			System.out.println("False");		
	}
	
	public static boolean slidingwindowPermuatationcheck (String s1, String s2){
		Map<Character, Integer> need = new HashMap<Character, Integer>();
		Map<Character, Integer> have = new HashMap<Character, Integer>();

		for (int i = 0; i < s1.length(); i++) {
			char ch = s1.charAt(i);
			if (!need.containsKey(ch)) {
				need.put(ch, 0);
			}
			need.put(ch, need.get(ch) + 1);
		}
		
		int start = 0, end = 0;
		while (end < s2.length()) {
			char ch = s2.charAt(end);
			if (!need.containsKey(ch)) {
				end++;
				start = end;
				have.clear();
				continue;
			}

			if (!have.containsKey(ch))
				have.put(ch, 0);
			have.put(ch, have.get(ch) + 1);

			while (need.get(ch) < have.get(ch)) {
				char c = s2.charAt(start);
				have.put(c, have.get(c) - 1);
				start = start + 1;
			}
			int windowsize = end - start + 1;
			if (windowsize == s1.length())
				return true;
			end+=1;
		}
		return false;
	} */