class Solution {
    public boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];
        boolean[] isFound = new boolean[1];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(board, i, j, word, visited, isFound);
            }
        }

        return isFound[0];
        
    }

    public void dfs(char[][] board, int row, int column, String word, boolean[][] visited, boolean[] isFound) {

        if (word.isEmpty()) {
            isFound[0] = true;
            return;
        }
        if (row >= board.length || 
            column >= board[0].length || 
            row < 0 ||
            column < 0 ||
            board[row][column] != word.charAt(0) || 
            visited[row][column]) {
            return;
        }
        visited[row][column] = true;
        dfs(board, row + 1, column, word.substring(1), visited, isFound);
        dfs(board, row - 1, column, word.substring(1), visited, isFound);
        dfs(board, row, column + 1, word.substring(1), visited, isFound);
        dfs(board, row, column - 1, word.substring(1), visited, isFound);
        visited[row][column] = false;
    }
}
