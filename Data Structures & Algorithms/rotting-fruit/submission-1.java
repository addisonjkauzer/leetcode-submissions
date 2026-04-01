class Solution {
    final static Integer[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        Queue<Integer[]> rottenFruit = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    rottenFruit.add(new Integer[]{i,j});
                }
            }
        }
        Integer time = bfs(grid, rottenFruit);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return time >= 0 ? time : 0;
    }

    public int bfs(int[][] grid, Queue<Integer[]> queue) {
        Integer time = 0;
        while (!queue.isEmpty()) {
            Queue newQueue = new LinkedList<>();
            for (Integer[] coord : queue) {
                for (Integer[] direction : DIRECTIONS) {
                    Integer i = coord[0] + direction[0];
                    Integer j = coord[1] + direction[1];
                    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
                        continue;
                    }
                    grid[i][j] = 2;
                    newQueue.add(new Integer[]{i, j});
                }
            }
            time++;
            queue = newQueue;
        }
        return time - 1;
    }

}
