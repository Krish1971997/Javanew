package zsecondround;

public class Program2 {
	public static void main(String[] args) {
	int[] prices= {7,3,5,8,6,4};
	
	System.out.println(findProfit(prices));
}

	private static int findProfit(int[] prices) {
		int maxProfit=0;
		int minPrice=prices[0];
		
		for (int i = 1; i < prices.length; i++) {
			if(minPrice>prices[i])
				minPrice=prices[i];
			else if((prices[i]-minPrice)>maxProfit) {
				maxProfit=prices[i]-minPrice;
			}
		}
		
		return maxProfit; 
	}
}
