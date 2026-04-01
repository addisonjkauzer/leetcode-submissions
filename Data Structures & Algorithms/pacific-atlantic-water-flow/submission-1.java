class Solution {
    public static Integer[][] DIRECTIONS = {{0,1},{1,0},{-1,0},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacificFlow = new boolean[heights.length][heights[0].length];
        boolean[][] atlanticFlow = new boolean[heights.length][heights[0].length];

        Queue<Integer[]> pacificNeighbors = new LinkedList<>();
        Queue<Integer[]> atlanticNeighbors = new LinkedList<>();

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                if (i == 0 || j == 0) {
                    pacificNeighbors.add(new Integer[]{i,j});
                }
                if (i == heights.length - 1 || j == heights[i].length -1) {
                    atlanticNeighbors.add(new Integer[]{i,j});
                }
            }
        }

        bfs(heights, pacificNeighbors, pacificFlow);
        bfs(heights, atlanticNeighbors, atlanticFlow);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                if (atlanticFlow[i][j] && pacificFlow[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    public void bfs(final int[][] heights, Queue<Integer[]> queue, boolean[][] flowState) {
        while (!queue.isEmpty()) {
            final Queue<Integer[]> newQueue = new LinkedList<>();
            for (Integer[] coords : queue) {
                final Integer i = coords[0];
                final Integer j = coords[1];
                flowState[i][j] = true;
                for (Integer[] direction : DIRECTIONS) {
                    final Integer neighborI = i + direction[0];
                    final Integer neighborJ = j + direction[1];
                    if (neighborI < 0 || neighborI >= heights.length || neighborJ < 0 || neighborJ >= heights[0].length || flowState[neighborI][neighborJ]) {
                        continue;
                    }
                    if (heights[neighborI][neighborJ] >= heights[i][j]) {
                        newQueue.add(new Integer[]{neighborI, neighborJ});
                    }
                }
                queue = newQueue;
            }
        }
    }
}
