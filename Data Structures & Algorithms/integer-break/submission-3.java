class Solution {
    public int integerBreak(int n) {
        if (n <= 3) return n - 1;
        return integerBreak(n, new HashMap<>());
    }

    public int integerBreak(int n, HashMap<Integer, Integer> cache) {
        if (n == 0) {
            return 1;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int maxSubProduct = 0;
        for (int i = 1; i <= n; i++) {
            Integer remainingProduct = i * integerBreak(n - i, cache);
            maxSubProduct = Math.max(maxSubProduct, remainingProduct);
        }
        cache.put(n, maxSubProduct);
        return maxSubProduct;
    }
}