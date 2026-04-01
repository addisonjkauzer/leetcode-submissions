class Solution {
    public long maxPoints(int[][] points) {
        long maxPoints= 0;
        HashMap<String, Long> cache = new HashMap<>();
        for (int col = 0; col < points[0].length; col++) {
            maxPoints = Math.max(maxPoints, dfsMaxPoints(points, 0, col, cache));
        }
        return maxPoints;
    }

    public long dfsMaxPoints(int[][] points, int row, int previousCol, HashMap<String, Long> cache) {
        String seenKey = row + "," + previousCol;
        if (cache.containsKey(seenKey)) {
            return cache.get(seenKey);
        }
        if (row >= points.length) {
            return 0;
        }
        long maxPoints = 0;
        for (int col = 0; col < points[row].length; col++) {
            long profit = points[row][col] + dfsMaxPoints(points, row + 1, col, cache);
            long cost = Math.abs(previousCol - col);
            maxPoints = Math.max(maxPoints, profit - cost);
        }
        cache.put(seenKey, maxPoints);
        return maxPoints;
    }
}