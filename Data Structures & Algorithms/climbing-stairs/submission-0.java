class Solution {
    public int climbStairs(int n) {
        return climbStairs(n, new HashMap<>());
    }

    public int climbStairs(int n, HashMap<Integer, Integer> cache) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        if (n == 1 || n == 0) {
            return 1;
        }
        Integer waysToClimbTwo =  climbStairs(n-2, cache);
        Integer waysToClimbOne = climbStairs(n-1, cache);
        cache.put(n, waysToClimbOne + waysToClimbTwo);
        return waysToClimbOne + waysToClimbTwo;
    }
}
