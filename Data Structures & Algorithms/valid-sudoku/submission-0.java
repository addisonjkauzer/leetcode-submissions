class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> uniques = new HashSet<>();

        //Check Rows
        for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
            uniques = new HashSet<>();
            for (int columnIndex = 0; columnIndex < board[rowIndex].length; columnIndex++) {
                final Character currentCharacter = board[rowIndex][columnIndex];
                if (currentCharacter.equals('.')) {
                    continue;
                }
                final Integer currentSize = uniques.size();
                uniques.add(currentCharacter);
                if (currentSize == uniques.size()) {
                    return false;
                }
            }
        }

        //Check columns
        for (int columnIndex = 0; columnIndex < board[0].length; columnIndex++) {
            uniques = new HashSet<>();
            for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
                final Character currentCharacter = board[rowIndex][columnIndex];
                if (currentCharacter.equals('.')) {
                    continue;
                }
                final Integer currentSize = uniques.size();
                uniques.add(currentCharacter);
                if (currentSize == uniques.size()) {
                    return false;
                }
            }
        }

        // Check grids
        uniques = new HashSet<>();
        for (int rowAdjuster = 0; rowAdjuster < 9; rowAdjuster = rowAdjuster + 3) {
            for (int columnAdjuster = 0; columnAdjuster < 9; columnAdjuster = columnAdjuster + 3) {
                uniques = new HashSet<>();
                for (int rowIndex = 0; rowIndex < 3; rowIndex++) {
                    for (int columnIndex=0; columnIndex < 3; columnIndex++) {
                        final Character currentCharacter = board[rowIndex+rowAdjuster][columnIndex+columnAdjuster];
                        if (currentCharacter.equals('.')) {
                            continue;
                        }
                        final Integer currentSize = uniques.size();
                        uniques.add(currentCharacter);
                        if (currentSize == uniques.size()) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
