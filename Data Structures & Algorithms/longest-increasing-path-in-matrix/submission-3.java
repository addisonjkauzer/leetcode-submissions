class Solution {
    public static final Integer[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public int longestIncreasingPath(int[][] matrix) {
        Integer maxLength = 0;
        HashMap<List<Integer>, Integer> cache = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                maxLength = Math.max(maxLength, dfsLongestPath(matrix, i, j, cache));
            }
        }
        return maxLength;
    }

    public int dfsLongestPath(int[][] matrix, Integer i, Integer j, HashMap<List<Integer>, Integer> cache) {
        if (cache.containsKey(Arrays.asList(i, j))) {
            return cache.get(Arrays.asList(i,j));
        }
        Integer maxDirection = 0;
        for (Integer[] direction : directions) {
            Integer newI = i + direction[0];
            Integer newJ = j + direction[1];
            if (newI >= matrix.length || newJ >= matrix[0].length || newI < 0 || newJ < 0) {
                continue;
            }
            if (matrix[newI][newJ] > matrix[i][j]) {
                maxDirection = Math.max(maxDirection, dfsLongestPath(matrix, newI, newJ, cache));
            }
        }
        cache.put(Arrays.asList(i,j), maxDirection + 1);
        return maxDirection + 1;
    }
}
