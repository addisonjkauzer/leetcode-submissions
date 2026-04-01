class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return dfsPathWithObstaclesCounter(obstacleGrid, 0, 0, new HashMap<>());
    }

    public int dfsPathWithObstaclesCounter(int[][] obstacleGrid, int i, int j, HashMap<String, Integer> cache) {
        String coords = i + "," + j;
        if (cache.containsKey(coords)) {
            return cache.get(coords);
        }
        if (obstacleGrid[i][j] == 1) {
            return 0;
        }
        if (i == obstacleGrid.length - 1 && j == obstacleGrid[i].length - 1) {
            return 1;
        }
        Integer count = 0;
        if (i < obstacleGrid.length - 1) {
            count += dfsPathWithObstaclesCounter(obstacleGrid, i + 1, j, cache);
        }
        if (j < obstacleGrid[i].length - 1) {
            count += dfsPathWithObstaclesCounter(obstacleGrid, i, j + 1, cache);
        }
        cache.put(coords, count);
        return count;
    }
}