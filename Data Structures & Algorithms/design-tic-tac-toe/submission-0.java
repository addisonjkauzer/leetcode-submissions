class TicTacToe {

    int[][] board;

    public TicTacToe(int n) {
        board = new int[n][n];
    }
    
    public int move(int row, int col, int player) {
        board[row][col] = player;
        return getWinner(row, col, player);
    }

    private int getWinner(int row, int col, int player) {
        if (completeRow(row, col) || 
        completeCol(row, col) || 
        completeBackslashDiag(row, col) || 
        completeForwardslashDiag(row, col)) {
            return player;
        }
        return 0;
    }

    private boolean completeRow(int row, int col) {
        int player = board[row][col];
        int right = (col + 1) % board.length;

        while (right != col) {
            if (board[row][right] != player) {
                return false;
            }
            right = (right + 1) % board.length;
        }
        return true;
    }

    private boolean completeCol(int row, int col) {
        int player = board[row][col];
        int down = (row + 1) % board.length;

        while (down != row) {
            if (board[down][col] != player) {
                return false;
            }
            down = (down + 1) % board.length;
        }
        return true;
    }

    private boolean completeBackslashDiag(int row, int col) {
        int player = board[row][col];
        int newRow = 0;
        int newCol = 0;

        while (newCol != board.length) {
            if (board[newRow][newCol] != player) {
                return false;
            }
            newRow++;
            newCol++;
        }
        return true;
    }

    private boolean completeForwardslashDiag(int row, int col) {
        int player = board[row][col];
        int newRow = board.length - 1;
        int newCol = 0;

        while (newCol != board.length) {
            if (board[newRow][newCol] != player) {
                return false;
            }
            newRow--;
            newCol++;
        }
        return true;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
