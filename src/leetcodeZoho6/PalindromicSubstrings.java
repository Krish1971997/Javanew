package leetcodeZoho6;

//need to learn
public class PalindromicSubstrings {

    public static int countSubstrings(String s) {
        int count = 0;

        for (int center = 0; center < 2 * s.length() - 1; center++) {
            int left = center / 2;
            int right = left + (center % 2);

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "aaa";

        System.out.println("Palindromic substrings in '" + str1 + "': " + countSubstrings(str1)); // 3
        System.out.println("Palindromic substrings in '" + str2 + "': " + countSubstrings(str2)); // 6
    }
}
