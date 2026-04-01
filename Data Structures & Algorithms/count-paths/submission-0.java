class Solution {
    public int uniquePaths(int m, int n) {
        return dfsUniquePaths(0, 0, new HashMap<>(), m, n);
    }

    public int dfsUniquePaths(int i, int j, HashMap<List<Integer>, Integer> cache, Integer rows, Integer columns) {
        if (cache.containsKey(Arrays.asList(i, j))) {
            return cache.get(Arrays.asList(i, j));
        }
        if (i == rows - 1 && j == columns - 1) {
            return 1;
        }
        if (i == rows || j == columns) {
            return 0;
        }
        Integer right = dfsUniquePaths(i, j+ 1, cache, rows, columns);
        Integer down = dfsUniquePaths(i+1, j, cache, rows, columns);
        cache.put(Arrays.asList(i, j), right + down);
        return right + down;

    }
}
