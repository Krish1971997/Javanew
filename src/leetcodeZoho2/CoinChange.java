package leetcodeZoho2;

import java.util.Arrays;

public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);

		dp[0] = 0;

		for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
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
