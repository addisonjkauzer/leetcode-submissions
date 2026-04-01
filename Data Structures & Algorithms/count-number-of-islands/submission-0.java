class Solution {
    public int numIslands(char[][] grid) {
        Integer numOfIslands = 0;
        boolean[][] isAlreadyIsland = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !isAlreadyIsland[i][j]) {
                    numOfIslands++;
                    fillIsland(grid, isAlreadyIsland, i, j);
                } 
            }
        }
        return numOfIslands;
    }

    public void fillIsland(char[][] grid, boolean[][] isAlreadyIsland, int i, int j) {
        if (i >= grid.length || i < 0 || j >= grid[i].length || j < 0) {
            return;
        }
        if (grid[i][j] == '1' && !isAlreadyIsland[i][j]) {
            isAlreadyIsland[i][j] = true;
            fillIsland(grid, isAlreadyIsland, i + 1, j);
            fillIsland(grid, isAlreadyIsland, i - 1, j);
            fillIsland(grid, isAlreadyIsland, i, j + 1);
            fillIsland(grid, isAlreadyIsland, i, j - 1);
        }
    }
}
