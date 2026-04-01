class Solution {
    public int maxProfit(int[] prices) {
        return maxProfitDFS(prices, 0, -1, new HashMap<>());
    }

    public int maxProfitDFS(final int[] prices, final Integer index, final Integer numberOfCoins, final HashMap<List<Integer>, Integer> cache) {
        if (index >= prices.length) {
            return 0;
        }
        if (cache.containsKey(Arrays.asList(index, numberOfCoins))) {
            return cache.get(Arrays.asList(index, numberOfCoins));
        }
        Integer doNothing = maxProfitDFS(prices, index + 1, numberOfCoins, cache);
        if (numberOfCoins > 0) {
            final Integer ifSell = prices[index] + maxProfitDFS(prices, index + 2, 0, cache);
            final Integer bestOption = Math.max(ifSell, doNothing);
            cache.put(Arrays.asList(index, numberOfCoins), bestOption);
            return bestOption;
        } else {
            final Integer ifBuy = maxProfitDFS(prices, index + 1, 1, cache) - prices[index];
            final Integer bestOption = Math.max(ifBuy, doNothing);
            cache.put(Arrays.asList(index, numberOfCoins), bestOption);
            return bestOption;
        }
    }
}
