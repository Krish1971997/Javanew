package leetcodeZoho3;

public class CoinChange {

	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) 
			dp[i] = amount + 1; // Use amount + 1 as an initial large value

		for (int i = 1; i <= amount; i++) {
			for (int coin : coins) {
				if (i >= coin) 
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
			}
		}

		return dp[amount] > amount ? -1 : dp[amount];
	}

	public static void main(String[] args) {
		CoinChange solution = new CoinChange();

		// Example 1
		int[] coins1 = { 1, 2, 5 };
		int amount1 = 18;
		int result1 = solution.coinChange(coins1, amount1);
		System.out.println("Minimum number of coins needed for amount " + amount1 + ": " + result1);

		// Example 2
		int[] coins2 = { 2 };
		int amount2 = 3;
		int result2 = solution.coinChange(coins2, amount2);
		System.out.println("Minimum number of coins needed for amount " + amount2 + ": " + result2);

		// Example 3
		int[] coins3 = { 1 };
		int amount3 = 0;
		int result3 = solution.coinChange(coins3, amount3);
		System.out.println("Minimum number of coins needed for amount " + amount3 + ": " + result3);

		// Example 4
		int[] coins4 = { 1, 2, 5 };
		int amount4 = 3;
		int result4 = solution.coinChange(coins4, amount4);
		System.out.println("Minimum number of coins needed for amount " + amount4 + ": " + result4);
	}
}
