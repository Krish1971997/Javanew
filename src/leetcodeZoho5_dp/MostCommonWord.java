package leetcodeZoho5_dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MostCommonWord {

	public static void main(String[] args) {
		String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String[] banned = { "hit" };

		System.out.println(mostCommonWord(paragraph, banned)); // Output: ball
	}

	public static String mostCommonWord(String paragraph, String[] banned) {
		// Step 1: Convert the banned words array into an array for fast lookup
//		boolean[] bannedWords = new boolean[256]; // For lowercase 'a' to 'z' and spaces
//		for (String word : banned) {
//			for (int i = 0; i < word.length(); i++) {
//				bannedWords[word.charAt(i) - 'a'] = true; // Mark the banned characters
//			}
//		}

		// Step 2: Clean the paragraph (convert to lowercase, remove punctuation)
		
		String[] words = splitWords(paragraph);
		
        Map<String, Integer> frequencyMap = new HashMap<>();
        for(int i=0;i<words.length;i++) {
        	frequencyMap.put(words[i],frequencyMap.getOrDefault(words[i], 0)+1); 
        }
		
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
        	System.out.println(entry.getKey()+" -> "+entry.getValue());
        }
        
        int count=0;
        String Value=null;
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
        	for (int i = 0; i < banned.length; i++) {
			 if(count>entry.getValue() && entry.getKey()!=banned[i]) {
				 count=entry.getValue();
				 Value=entry.getKey();
			 }	
		}
        }
        return Value;
        
		
//		StringBuilder cleanedParagraph = new StringBuilder();
//		for (int i = 0; i < paragraph.length(); i++) {
//			char c = paragraph.charAt(i);
//			if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ') {
//				cleanedParagraph.append(Character.toLowerCase(c));
//			}
//		}
//
//
//		// Step 4: Count the frequency of words (manually)
//		int[] freq = new int[words.length];
//		int maxCount = 0;
//		String mostCommonWord = "";
//
//		for (int i = 0; i < words.length; i++) {
//			String word = words[i];
//			if (isBanned(word, bannedWords)) {
//				continue;
//			}
//			freq[i]++; // increase word count
//			if (freq[i] > maxCount) {
//				maxCount = freq[i];
//				mostCommonWord = word;
//			}
//		}
//
//		return mostCommonWord;
	}

	// Custom word split function to manually split by space
	private static String[] splitWords(String paragraph) {
		int wordCount = wordsCount(paragraph);
		StringBuilder tempWord = new StringBuilder();
		String[] words = new String[wordCount];
		wordCount = 0;
		for (int i = 0; i < paragraph.length(); i++) {
			if (paragraph.charAt(i) == ' ' || i == paragraph.length() - 1) {
				if (tempWord.length() > 0) {
					words[wordCount++] = tempWord.toString();
					tempWord.setLength(0);
				}
			} else {
				tempWord.append(paragraph.charAt(i));
			}
		}
		System.out.println(Arrays.toString(words));
		return words;
	}
	
	
	public static int wordsCount(String paragraph) {
		int count=1;
		for (int i = 0; i < paragraph.length(); i++) {
			if(paragraph.charAt(i)==' ') {
				count++;
			}
		}
		return count;
	}

	// Helper function to check if a word is banned
	private static boolean isBanned(String word, boolean[] bannedWords) {
		for (int i = 0; i < word.length(); i++) {
			if (bannedWords[word.charAt(i) - 'a']) {
				return true;
			}
		}
		return false;
	}
}
