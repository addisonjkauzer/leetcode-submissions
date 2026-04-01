class Solution {
    public final static Integer[][] DIRECTIONS = {{0,1}, {1,0}, {0,-1}, {-1, 0}};
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 1) {
            return Arrays.stream(matrix[0]).boxed().collect(Collectors.toList());
        }
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        List<Integer> result = new ArrayList<>();
        Integer directionIndex = 0;
        Integer i = 0;
        Integer j = 0;
        while (i < matrix.length && i >= 0 && j < matrix[i].length && j >= 0 && !visited[i][j]) {
            result.add(matrix[i][j]);
            visited[i][j] = true;
            Integer newI = i + DIRECTIONS[directionIndex][0];
            Integer newJ = j + DIRECTIONS[directionIndex][1];
            if (newI >= matrix.length || newI < 0 || newJ >= matrix[newI].length || newJ < 0 || visited[newI][newJ]) {
                directionIndex++;
                directionIndex = directionIndex % 4;
                newI = i + DIRECTIONS[directionIndex][0];
                newJ = j + DIRECTIONS[directionIndex][1];
            }
            i = newI;
            j = newJ;
        }
        return result;
    }
}
