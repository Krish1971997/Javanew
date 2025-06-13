package leetcodeZoho6;

//need to learn
public class MinimumFlipsAlternating {

    public static int minFlips(String s) {
        int n = s.length();
        String doubled = s + s;

        char[] pattern1 = new char[2 * n];
        char[] pattern2 = new char[2 * n];

        for (int i = 0; i < 2 * n; i++) {
            pattern1[i] = (i % 2 == 0) ? '0' : '1';
            pattern2[i] = (i % 2 == 0) ? '1' : '0';
        }

        int minFlips = Integer.MAX_VALUE;
        int diff1 = 0, diff2 = 0;

        for (int i = 0; i < 2 * n; i++) {
            if (doubled.charAt(i) != pattern1[i]) diff1++;
            if (doubled.charAt(i) != pattern2[i]) diff2++;

            if (i >= n) {
                if (doubled.charAt(i - n) != pattern1[i - n]) diff1--;
                if (doubled.charAt(i - n) != pattern2[i - n]) diff2--;
            }

            if (i >= n - 1) {
                minFlips = Math.min(minFlips, Math.min(diff1, diff2));
            }
        }

        return minFlips;
    }

    public static void main(String[] args) {
        String s1 = "111000";
        String s2 = "010";

        System.out.println("Input: " + s1 + " => Min Flips: " + minFlips(s1)); // Output: 2
        System.out.println("Input: " + s2 + " => Min Flips: " + minFlips(s2)); // Output: 0
    }
}
