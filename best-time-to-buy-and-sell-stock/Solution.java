public class Solution {
    public static int maxProfit(int[] prices) {
        // znalezienie najwiekszej roznicy pomiedzy i-ta liczba a kolejnymi, pod warunkiem ze reszta jest wieksza od itej,
        // zapisanie tej roznicy do tablicy elemenotw
        // zwrocenie maxa z tej tablicy za pomoca Collections.max(), chyba ze max jest <0 to zwrocenie 0
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

    public static void main(String[] args) { 
        int[] prices = new int[] {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }
}
