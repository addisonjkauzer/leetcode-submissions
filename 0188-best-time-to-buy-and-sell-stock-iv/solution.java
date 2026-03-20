class Solution {
    public int maxProfit(int k, int[] prices) {
        return dfsMaxProfit(k * 2, prices, 0, false, new HashMap<>());
    }

    public int dfsMaxProfit(int k, int[] prices, int index, boolean holding, HashMap<String, Integer> cache) {
        if (index == prices.length || k == 0) {
            return 0;
        }
        String key = index + "," + holding + "," + k;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        //do nothing
        int result = dfsMaxProfit(k, prices, index + 1, holding, cache);
        //make transaction 
        if (holding) {
            int sell = dfsMaxProfit(k - 1, prices, index + 1, false, cache) + prices[index];
            result = Math.max(result, sell);
        } else {
            int buy = dfsMaxProfit(k - 1, prices, index + 1, true, cache) - prices[index];
            result = Math.max(result, buy);
        }
        cache.put(key, result);
        return result;
    }
}