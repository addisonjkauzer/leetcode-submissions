class Solution {

    private static final Integer[][] DIRECTIONS = new Integer[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {


        int targetColor = image[sr][sc];

        if (targetColor == color) {
            return image;
        }

        Queue<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[]{sr, sc});

        while (!queue.isEmpty()) {
            Integer[] newTarget = queue.poll();
            Integer row = newTarget[0];
            Integer col = newTarget[1];
            image[row][col] = color;
            for (Integer[] direction : DIRECTIONS) {
                Integer newRow = row + direction[0];
                Integer newCol = col + direction[1];
                if (newRow >= 0 && newRow < image.length && newCol >= 0 && newCol < image[newRow].length && image[newRow][newCol] == targetColor) {
                    queue.offer(new Integer[]{newRow, newCol});
                }
            }
        }
        return image;
        
    }
}