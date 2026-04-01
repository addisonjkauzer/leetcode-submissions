class Solution {
    public static final Integer[][] DIRECTIONS = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    Queue<Integer[]> queue = new LinkedList<>();
                    List<Integer[]> islandCoords = new ArrayList<>();
                    queue.add(new Integer[]{i, j});
                    if (bfsIsIsland(board, queue, islandCoords)) {
                        for (Integer[] coords : islandCoords) {
                            board[coords[0]][coords[1]] = 'X';
                        }
                    }
                }
            }
        }
    }

    public boolean bfsIsIsland(char[][] board, Queue<Integer[]> queue, List<Integer[]> islandCoords) {
        boolean isIsland = true;
        boolean[][] visited = new boolean[board.length][board[0].length];
        while (!queue.isEmpty()) {
            Queue newQueue = new LinkedList<>();
            for (Integer[] coord : queue) {
                islandCoords.add(new Integer[]{coord[0], coord[1]});
                visited[coord[0]][coord[1]] = true;
                for (Integer[] direction : DIRECTIONS) {
                    Integer i = coord[0] + direction[0];
                    Integer j = coord[1] + direction[1];
                    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
                        return false;
                    }
                    if (board[i][j] == 'O' && !visited[i][j]) {
                        newQueue.add(new Integer[]{i, j});
                    }
                }
            }
            queue = newQueue;
        }
        return isIsland;
    }
}
