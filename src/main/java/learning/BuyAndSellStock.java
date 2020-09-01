package learning;

// Best Time to Buy and Sell Stock

// Idea is to find smaller num followed by bigger num, so maintain variables to hold minprice and maxprofit and loop through
// TC : O(n) SC : O(1)
public class BuyAndSellStock {

	 public int maxProfit(int[] prices) {
	        int minBuyPrice = Integer.MAX_VALUE, maxProfit = 0;
	        for(int i=0; i< prices.length;i++){
	        	if(prices[i] < minBuyPrice) {
	        		minBuyPrice = prices[i];
	        	}else if (prices[i] - minBuyPrice > maxProfit) {
	        		maxProfit = prices[i] - minBuyPrice;
	        	}
	          
	        }
			return maxProfit;
	        
	    }
	 
	 public static void main(String[] args) {
		 BuyAndSellStock buyAndSellStock = new BuyAndSellStock();
		System.out.println( buyAndSellStock.maxProfit(new int[] {7,1,5,3,6,4}) );
	 }
}
