class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] isAlreadyIsland = new boolean[grid.length][grid[0].length];
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && !isAlreadyIsland[i][j]) {
                    int[] area = new int[1];
                    fillIsland(grid, isAlreadyIsland, i, j, area);
                    maxArea = Math.max(maxArea, area[0]);
                } 
            }
        }
        return maxArea;
    }

    public void fillIsland(int[][] grid, boolean[][] isAlreadyIsland, int i, int j, int[] area) {
        if (i >= grid.length || i < 0 || j >= grid[i].length || j < 0) {
            return;
        }
        if (grid[i][j] == 1 && !isAlreadyIsland[i][j]) {
            isAlreadyIsland[i][j] = true;
            area[0]++;
            fillIsland(grid, isAlreadyIsland, i + 1, j, area);
            fillIsland(grid, isAlreadyIsland, i - 1, j, area);
            fillIsland(grid, isAlreadyIsland, i, j + 1, area);
            fillIsland(grid, isAlreadyIsland, i, j - 1, area);
        }
    }
}
