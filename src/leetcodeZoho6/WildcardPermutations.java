package leetcodeZoho6;

import java.util.*;

public class WildcardPermutations {

    private static final char[] VOWELS = {'A', 'E', 'I', 'O', 'U'};

    public static void main(String[] args) {
        System.out.println(generate("A*B"));   // Output: AEB, AIB, AOB, AUB
        System.out.println(generate("A**U"));  // Output: valid combinations without consecutive duplicates
    }
    
    public static List<String> generate(String input) {
        List<String> result = new ArrayList<>();
        backtrack(input.toCharArray(), 0, new StringBuilder(), result);
        return result;
    }

    private static void backtrack(char[] input, int index, StringBuilder current, List<String> result) {
        if (index == input.length) {
            result.add(current.toString());
            return;
        }

        char ch = input[index];
        if (ch == '*') {
            for (char vowel : VOWELS) {
                if (current.length() > 0 && current.charAt(current.length() - 1) == vowel) {
                    continue; // Skip repeated letters
                }
                current.append(vowel);
                backtrack(input, index + 1, current, result);
                current.deleteCharAt(current.length() - 1);
            }
        } else {
            if (current.length() > 0 && current.charAt(current.length() - 1) == ch) {
                return; // Skip if same as previous
            }
            current.append(ch);
            backtrack(input, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
