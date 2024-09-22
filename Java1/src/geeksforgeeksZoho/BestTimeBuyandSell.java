package geeksforgeeksZoho;

public class BestTimeBuyandSell {
	public static void main(String[] args) {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		/**
		int maxprofit = 0;
		int minPrice = prices[0];
		for (int i = 1; i < prices.length; i++) {
			int potentialProfit = prices[i] - minPrice;

			if (potentialProfit > maxprofit)
				maxprofit = potentialProfit;

			if (prices[i] < minPrice)
				minPrice = prices[i];
		}
		System.out.println("Maxprofit - >"+maxprofit);
		*/
	        int max_profit = 0;
		        int min = prices[0];
		        for (int i=1;i<prices.length;i++) {
		            if (prices[i] < min) {
		                min = prices[i];
		            }
		            else if (prices[i]-min > max_profit) {
		                max_profit = prices[i]-min;
		            }
		        }

		        System.out.println("Max profit : "+max_profit);	
	}
}
