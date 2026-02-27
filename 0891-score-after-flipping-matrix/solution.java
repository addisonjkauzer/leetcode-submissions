class Solution {
    public int matrixScore(int[][] grid) {
        int score = 0;
        for (int row = 0; row < grid.length; row++) {
            if (grid[row][0] == 0) {
                for (int col = grid[row].length - 1; col >= 0; col--) {
                    grid[row][col] ^= 1;
                }
            }
        }

        for (int col = 0; col < grid[0].length; col++) {
            int zeros = 0;
            int ones = 0;
            boolean shouldSwap = false;
            for (int row = 0; row < grid.length; row++) {
                if (grid[row][col] == 1) {
                    ones++;
                } else {
                    zeros++;
                }
            }
            for (int row = 0; row < grid.length; row++) {
                if (zeros > ones) {
                    grid[row][col] ^= 1;
                }
            }
        }

        for (int row = 0; row < grid.length; row++) {
            int multiplier = 1;
            for (int col = grid[row].length - 1; col >= 0; col--) {
                System.out.print(grid[row][col]);
                score += grid[row][col] * multiplier;
                multiplier *= 2;
            }
            System.out.println();
        }
        return score;
    }
}