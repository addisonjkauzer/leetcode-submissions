class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer coinCount = coinChange(coins, amount, new HashMap<>());
        return coinCount == Integer.MAX_VALUE ? -1 : coinCount;
    }

    public int coinChange(int[] coins, Integer target, HashMap<Integer, Integer> cache) {
        if (target == 0) {
            return 0;
        }
        if (cache.containsKey(target)) {
            return cache.get(target);
        }
        Integer minCoinCount = Integer.MAX_VALUE;
        for (Integer coin : coins) {
            if (target - coin >= 0) {
                Integer result = coinChange(coins, target - coin, cache);
                if (result != Integer.MAX_VALUE) {
                    minCoinCount = Math.min(minCoinCount, 1 + result);
                }
            }
        }
        cache.put(target, minCoinCount);
        return minCoinCount;
    }
}
