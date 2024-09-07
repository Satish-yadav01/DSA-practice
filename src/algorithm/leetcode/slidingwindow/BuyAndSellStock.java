package algorithm.leetcode.slidingwindow;

public class BuyAndSellStock {
    public static void main(String[] args) {
        int profit = maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println("profit = " + profit);
    }

    public static int maxProfit(int[] prices) {
        int left=0, right=1, maxProfit=0;

        while(right < prices.length){
            if(prices[left] < prices[right]){
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(profit,maxProfit);
            }else{
                left = right;
            }
            right++;
        }

        return maxProfit;
    }
}
