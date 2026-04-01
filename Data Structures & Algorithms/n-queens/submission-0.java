class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] isTaken = new boolean[n][n];
        List<String> previousRows = new ArrayList<>();
        List<List<String>> results = new ArrayList<>();

        solveNQueens(isTaken, 0 , 0, "", previousRows, results);

        return results;
        
    }

    public void solveNQueens(boolean[][] isTaken, 
                            Integer row, 
                            Integer column, 
                            String currentRow, 
                            List<String> previousRows, 
                            List<List<String>> results) {
        if (column == isTaken[0].length) {
            if (currentRow.contains("Q")) {
                previousRows.add(currentRow);
                solveNQueens(isTaken, row + 1, 0, "", previousRows, results);
                previousRows.remove(previousRows.size() - 1);
            }
            return;
        }
        if (row == isTaken.length) {
            results.add(new ArrayList<>(previousRows));
            return;
        }
        if (isTaken[row][column]) {
            solveNQueens(isTaken, row, column + 1, currentRow + ".", previousRows, results);
            return;
        }
        List<Integer[]> swapped = new ArrayList<>();
        for (int i = 0; i < isTaken.length; i++) {
            if (!isTaken[row][i]) {
                isTaken[row][i] = true;
                swapped.add(new Integer[]{row, i});
            }
            if (!isTaken[i][column]) {
                isTaken[i][column] = true;
                swapped.add(new Integer[]{i, column});
            }
            if (row + i < isTaken.length && column + i < isTaken[row].length && !isTaken[row + i][column + i]) {
                isTaken[row + i][column + i] = true;
                swapped.add(new Integer[]{row + i, column + i});
            }
            if (row - i >= 0 && column - i >= 0 && !isTaken[row - i][column - i]) {
                isTaken[row - i][column - i] = true;
                swapped.add(new Integer[]{row - i, column - i});
            }
            if (row - i >= 0 && column + i < isTaken[row].length && !isTaken[row - i][column + i]) {
                isTaken[row - i][column + i] = true;
                swapped.add(new Integer[]{row - i, column + i});
            }
            if (row + i < isTaken.length && column - i >= 0 && !isTaken[row + i][column - i]) {
                isTaken[row + i][column - i] = true;
                swapped.add(new Integer[]{row + i, column - i});
            }
        }
        solveNQueens(isTaken, row, column + 1, currentRow + "Q", previousRows, results);
        for (Integer[] coordinates : swapped) {
            isTaken[coordinates[0]][coordinates[1]] = false;
            
        }
        solveNQueens(isTaken, row, column + 1, currentRow + ".", previousRows, results);
    }
}
