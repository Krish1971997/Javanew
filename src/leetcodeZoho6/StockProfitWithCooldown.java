package leetcodeZoho6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class StockProfitWithCooldown {
	public static void maxProfit(int[] prices) {
		int n = prices.length;
		if (n == 0) {
			System.out.println("Total Profit: 0");
			return;
		}

		int[] hold = new int[n]; // Max profit while holding stock
		int[] sell = new int[n]; // Max profit after selling stock
		int[] cooldown = new int[n]; // Max profit in cooldown

		// Initial state
		hold[0] = -prices[0]; // Buy stock on day 0
		sell[0] = 0;
		cooldown[0] = 0;

		for (int i = 1; i < n; i++) {
			hold[i] = Math.max(hold[i - 1], cooldown[i - 1] - prices[i]); // Buy or keep holding
			sell[i] = hold[i - 1] + prices[i]; // Sell stock
			cooldown[i] = Math.max(cooldown[i - 1], sell[i - 1]); // Stay in cooldown or transition from sell
		}

		int maxProfit = Math.max(sell[n - 1], cooldown[n - 1]); // Maximum possible profit

		// Print transactions
		List<String> transactions = new ArrayList<>();
		int i = n - 1;
		while (i >= 0) {
			if (i > 0 && sell[i] == hold[i - 1] + prices[i]) {
				int sellDay = i;
				i--; // Skip the cooldown day
				while (i > 0 && hold[i] != cooldown[i - 1] - prices[i]) {
					i--;
				}
				transactions.add("(" + i + "," + sellDay + ")");
				i--; // Move to previous day due to cooldown
			} else {
				i--;
			}
		}
		Collections.reverse(transactions);
		System.out.println("Transactions: " + String.join(" cooldown ", transactions));
		System.out.println("Total Profit: " + maxProfit);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Taking input
		//System.out.print("Enter number of days: ");
		//int n = scanner.nextInt();
		int[] prices = {100,180,260,310,40,535,695};

//		System.out.print("Enter stock values: ");
//		for (int i = 0; i < n; i++) {
//			prices[i] = scanner.nextInt();
//		}

		maxProfit(prices);

		//scanner.close();
	}
}
