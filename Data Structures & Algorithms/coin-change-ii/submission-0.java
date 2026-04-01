class Solution {
    public int change(int amount, int[] coins) {
        return dfsChange(amount, coins, 0, new HashMap<>());
    }

    public int dfsChange(int amount, int[] coins, int index, HashMap<List<Integer>, Integer> cache) {
        if (cache.containsKey(Arrays.asList(amount, index))) {
            return cache.get(Arrays.asList(amount, index));
        }
        if (index >= coins.length || amount < 0) {
            return 0;
        }
        if (amount == 0) {
            return 1;
        }
        Integer takeCurrent = dfsChange(amount - coins[index], coins, index, cache);
        Integer goNext = dfsChange(amount, coins, index + 1, cache);
        cache.put(Arrays.asList(amount, index), takeCurrent + goNext);
        return takeCurrent + goNext;
    }
}
