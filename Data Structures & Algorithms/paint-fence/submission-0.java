class Solution {
    public int numWays(int n, int k) {
        return dfsNumWays(n, k, new HashMap<>());
    }

    public int dfsNumWays(int n, int k, HashMap<Integer, Integer> cache) {
        if (n == 1) {
            return k;
        }
        if (n == 2) {
            return k * k;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        int ways = (k - 1) * (dfsNumWays(n - 1, k, cache) + dfsNumWays(n - 2, k, cache));
        cache.put(n, ways);
        return ways;
    }
}
