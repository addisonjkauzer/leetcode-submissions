class Solution {
    public int minCostII(int[][] costs) {
        int min = Integer.MAX_VALUE;
        HashMap<String, Integer> cache = new HashMap<>();
        for (int i = 0; i < costs[0].length; i++) {
            int costRemainingHouses = costs[0][i] + dfsMinCost(costs, 1, i, cache);
            min = Math.min(min, costRemainingHouses);
        }
        return min;
    }

    public int dfsMinCost(int[][] costs, int row, int color, HashMap<String, Integer> cache) {
        String key = row + "," + color;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        if (row == costs.length) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < costs[row].length; i++) {
            if (i == color) {
                continue;
            }
            int cost = costs[row][i] + dfsMinCost(costs, row + 1, i, cache);
            min = Math.min(min, cost);
        }
        cache.put(key, min);
        return min;
    }
}
