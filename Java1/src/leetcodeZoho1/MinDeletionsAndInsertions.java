package leetcodeZoho1;

public class MinDeletionsAndInsertions {
    public static void minDeletionsAndInsertions(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        // Create a 2D array to store the minimum deletions and insertions
        int[][] dp = new int[m + 1][n + 1];

        // Fill the dp array using bottom-up dynamic programming approach
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
              //  if (i == 0 || j == 0) {
              //      dp[i][j] = 0;
                 if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Calculate the minimum deletions and insertions
        int deletions = m - dp[m][n];
        int insertions = n - dp[m][n];

        System.out.println("Minimum Deletion = " + deletions);
        System.out.println("Minimum Insertion = " + insertions);
    }

    public static void main(String[] args) {
        String str1 = "horse";
        String str2 = "ros";
        System.out.println("Input :");
        System.out.println("str1 = \"" + str1 + "\", str2 = \"" + str2 + "\"");
        System.out.println("Output :");
        minDeletionsAndInsertions(str1, str2);
    }
}
