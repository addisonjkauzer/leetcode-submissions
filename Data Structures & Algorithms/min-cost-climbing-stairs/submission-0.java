class Solution {
    public int minCostClimbingStairs(int[] cost) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        Integer costAtZero = minCostClimbingStairs(cost, 0, cache);
        Integer costAtOne = minCostClimbingStairs(cost, 1, cache);
        return Math.min(costAtZero, costAtOne);
    }

    public int minCostClimbingStairs(int[] cost, Integer index, HashMap<Integer, Integer> cache) {
        if (cache.containsKey(index)) {
            return cache.get(index);
        }
        if (index >= cost.length) {
            return 0;
        }
        Integer costOfOneStep = minCostClimbingStairs(cost, index + 1, cache);
        Integer costOfTwoStep = minCostClimbingStairs(cost, index + 2, cache);
        Integer currentCost = Math.min(costOfOneStep, costOfTwoStep) + cost[index];
        cache.put(index, currentCost);
        return currentCost;
    }
}
