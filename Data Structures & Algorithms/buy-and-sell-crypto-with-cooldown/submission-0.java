class Solution {
    public int maxProfit(int[] prices) {
        return maxProfitDFS(prices, 0, -1, new HashMap<>());
    }

    public int maxProfitDFS(final int[] prices, final Integer index, final Integer coinCost, final HashMap<List<Integer>, Integer> cache) {
        if (index >= prices.length) {
            return 0;
        }
        if (cache.containsKey(Arrays.asList(index, coinCost))) {
            return cache.get(Arrays.asList(index, coinCost));
        }
        if (coinCost >= 0) {
            final Integer ifSell = prices[index] + maxProfitDFS(prices, index + 2, -1, cache);
            final Integer ifKeep = maxProfitDFS(prices, index + 1, coinCost, cache);
            final Integer bestOption = Math.max(ifSell, ifKeep);
            cache.put(Arrays.asList(index, coinCost), bestOption);
            return bestOption;
        }
        final Integer ifBuy = maxProfitDFS(prices, index + 1, prices[index], cache) - prices[index];
        final Integer ifWait = maxProfitDFS(prices, index + 1, -1, cache);
        final Integer bestOption = Math.max(ifBuy, ifWait);
        cache.put(Arrays.asList(index, coinCost), bestOption);
        return bestOption;
    }
}
