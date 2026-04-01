class Solution {
    public void rotate(int[][] matrix) {
        boolean[][] rotated = new boolean[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int nextValue = matrix[i][j];
                int[] nextIndexes = getNextIndexes(i, j, matrix);
                while (!rotated[nextIndexes[0]][nextIndexes[1]]) {
                    Integer temp = matrix[nextIndexes[0]][nextIndexes[1]];
                    matrix[nextIndexes[0]][nextIndexes[1]] = nextValue;
                    rotated[nextIndexes[0]][nextIndexes[1]] = true;
                    nextValue = temp;
                    nextIndexes = getNextIndexes(nextIndexes[0], nextIndexes[1], matrix);
                }
            }
        }
    }

    private int[] getNextIndexes(int row, int column, int[][] matrix) {
        Integer newRow = column;
        Integer newColumn = matrix.length - 1 - row;

        return new int[]{newRow, newColumn};
    }
}
