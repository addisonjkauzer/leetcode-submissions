class Solution {
    public static final Integer[][] DIRECTIONS = new Integer[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int findMaxFish(int[][] grid) {
        HashSet<String> seen = new HashSet<>();
        int maxFish = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                maxFish = Math.max(maxFish, dfsAllFish(grid, row, col, seen));
            }
        }
        return maxFish;
    }

    public int dfsAllFish(int[][] grid, int row, int col, HashSet<String> seen) {
        String key = row + "," + col;
        if (seen.contains(key) || row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == 0) {
            return 0;
        }
        seen.add(key);
        int sum = grid[row][col];
        for (Integer[] direction : DIRECTIONS) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            sum += dfsAllFish(grid, newRow, newCol, seen);
        }
        return sum;
    }
}