class Solution {
    public int numIslands(char[][] grid) {
        int islandCounter = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length;j++) {
                int marker = grid[i][j];
                if (marker == '2' || marker == '0') {
                    continue;
                } else {
                    islandCounter++;
                    expandIsland(grid, i, j);
                }
            }
        }
        return islandCounter;
    }

    public void expandIsland(char[][] grid, int iIndex, int jIndex) {
        grid[iIndex][jIndex] = '2';
        if (iIndex-1 >=0) {
            char numberAbove = grid[iIndex -1][jIndex];
            if (numberAbove == '1') {
                expandIsland(grid, iIndex-1, jIndex);
            }
        }
        if (iIndex+1 < grid.length) {
            char numberBelow = grid[iIndex+1][jIndex];
            if (numberBelow == '1') {
                expandIsland(grid, iIndex+1, jIndex);
            }
        }
        if (jIndex + 1 < grid[0].length) {
            char numberRight = grid[iIndex][jIndex+1];
            if (numberRight == '1') {
                expandIsland(grid, iIndex, jIndex+1);
            }
        }
        if (jIndex -1 >= 0) {
            char numberLeft = grid[iIndex][jIndex-1];
            if (numberLeft == '1') {
                expandIsland(grid, iIndex, jIndex-1);
            }
        }
    }
}