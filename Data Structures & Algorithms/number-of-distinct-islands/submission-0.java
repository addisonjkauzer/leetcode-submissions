class Solution {
    private final static Integer[][] DIRECTIONS = new Integer[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int numDistinctIslands(int[][] grid) {
        HashSet<String> islandShapes = new HashSet<>();
        HashSet<String> seen = new HashSet<>();

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                islandShapes.add(dfsDistinctIsland(grid, row, col, seen));
            }
        }
        System.out.println(islandShapes);
        islandShapes.remove("");
        return islandShapes.size();
    }

    public String dfsDistinctIsland(int[][] grid, int row, int col, HashSet<String> seen) {
        String seenKey = row + "," + col;
        if (row >= grid.length || row < 0 || col >= grid[row].length || col < 0 || seen.contains(seenKey) || grid[row][col] == 0) {
            return "";
        }
        seen.add(seenKey);
        String islandShape = "";
        for (int i = 0; i < DIRECTIONS.length; i++) {
            Integer[] direction = DIRECTIONS[i];
            islandShape += i + dfsDistinctIsland(grid, row + direction[0], col + direction[1], seen);
        }
        return islandShape;
    }
}
