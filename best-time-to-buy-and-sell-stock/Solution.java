public class Solution {
    public static int maxProfit(int[] prices) {
        int length = prices.length;
        int maxProfit = 0;
        for(int i=0; i<length; ++i) {
            for(int j=i+1; j<length; ++j) {
                int diff = prices[j]-prices[i];
                if(diff > maxProfit) {
                    maxProfit = diff;
                }
            }
         }
         return maxProfit;
    }

    public static int maxProfit2(int[] prices) {
       int maxProfit = 0;
       int minPrice = Integer.MAX_VALUE;
       for(int price: prices) {
        if(price < minPrice) {
            minPrice = price;
        }
        int profit = price - minPrice;
        if(profit > maxProfit) {
            maxProfit = profit;
        }
       }
       return maxProfit;
    }

    public static void main(String[] args) { 
        int[] prices = new int[] {7, 1, 5, 3, 6, 4};
        System.out.println("sol1: " + maxProfit(prices));
        System.out.println("sol2: " + maxProfit2(prices));
    }
}
