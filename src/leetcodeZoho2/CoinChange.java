package leetcodeZoho2;

import java.util.Arrays;

public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);

		dp[0] = 0;

		for (int coin : coins) {
			for (int j = coin; j <= amount; j++) {
				dp[j] = Math.min(dp[j], dp[j - coin] + 1);
			}
		}
		// If dp[amount] is still amount + 1, it means the amount cannot be formed
		return dp[amount] > amount ? -1 : dp[amount];
	}

	public static void main(String[] args) {
		CoinChange cc = new CoinChange();
		int[] coins = { 1, 2, 5 };
		int amount = 11;
		int result = cc.coinChange(coins, amount);
		System.out.println("Minimum number of coins needed: " + result);
	}
}
