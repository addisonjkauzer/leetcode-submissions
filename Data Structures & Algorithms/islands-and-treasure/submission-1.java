class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<Integer[]> gateQueue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    gateQueue.add(new Integer[]{i + 1, j});
                    gateQueue.add(new Integer[]{i - 1, j});
                    gateQueue.add(new Integer[]{i, j + 1});
                    gateQueue.add(new Integer[]{i, j - 1});
                }
            }
        }
        bfs(grid, gateQueue);
    }

    public void bfs(int[][] grid, Queue<Integer[]> queue) {
        Integer distance = 1;
        while (!queue.isEmpty()) {
            Queue<Integer[]> newQueue = new LinkedList<>();
            for (Integer[] index : queue) {
                Integer i = index[0];
                Integer j = index[1];
                System.out.println(i + "," + j);
                if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 2147483647) {
                    continue;
                }
                grid[i][j] = distance;
                newQueue.add(new Integer[]{i + 1, j});
                newQueue.add(new Integer[]{i - 1, j});
                newQueue.add(new Integer[]{i, j + 1});
                newQueue.add(new Integer[]{i, j - 1});
            }
            distance++;
            queue = newQueue;
        }

    }
}
