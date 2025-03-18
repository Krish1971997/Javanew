package leetcodeZoho6;

import java.util.*;

public class StockProfitCooldown {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        int[] hold = new int[n];      // Max profit holding a stock
        int[] sell = new int[n];      // Max profit after selling a stock
        int[] cooldown = new int[n];  // Max profit in cooldown

        // Initial states
        hold[0] = -prices[0]; // Buying the stock at first day
        sell[0] = 0;          // No sale at first day
        cooldown[0] = 0;      // No cooldown at first day

        for (int i = 1; i < n; i++) {
            hold[i] = Math.max(hold[i - 1], cooldown[i - 1] - prices[i]); // Buy or keep holding
            sell[i] = hold[i - 1] + prices[i]; // Sell stock
            cooldown[i] = Math.max(cooldown[i - 1], sell[i - 1]); // Stay in cooldown or transition from sell
        }

        return Math.max(sell[n - 1], cooldown[n - 1]); // Max profit at the end
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Taking input
        System.out.print("Enter number of days: ");
        int n = scanner.nextInt();
        int[] prices = new int[n];

        System.out.print("Enter stock values: ");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        int profit = maxProfit(prices);
        System.out.println("Total Profit: " + profit);
        
        scanner.close();
    }
}
