class Solution {
    public int maxProfit(int[] prices) {
        Integer maxProfit = 0;


        Integer lowPointer = 0;
        Integer highPointer = 0;

        while (highPointer < prices.length) {
            maxProfit = Math.max(maxProfit, prices[highPointer] - prices[lowPointer]);

            if (prices[lowPointer] > prices[highPointer]) {
                lowPointer = highPointer;
            } else {
                highPointer++;
            }
        }
        return maxProfit;
    }
}
