class Solution {
    public boolean exist(char[][] board, String word) {
        char[] letters = word.toCharArray();
        char[] removeFirstLetter = Arrays.copyOfRange(letters, 1, letters.length);

        HashSet<Character> letterChecker = new HashSet();
        for (Character letter : letters) {
            letterChecker.add(letter);
        }
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j++) {
                if (letterChecker.contains(board[i][j])) {
                    letterChecker.remove(board[i][j]);
                }
            }
        }
        if (letterChecker.size() > 0) {
            return false;
        }

        boolean hasSolution = false;
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == letters[0]) {
                    if(recuseCheckNeighbors(board, removeFirstLetter, i, j, new HashSet(new ArrayList()))) {
                        hasSolution = true;
                    }
                }
            }
        }
        return hasSolution;
    }

    public boolean recuseCheckNeighbors(char[][] board, char[] remainingLetters, int iIndex, int jIndex, Set<List<Integer>> used) {
        used.add(new ArrayList(Arrays.asList(iIndex, jIndex)));
        if (remainingLetters.length == 0) {
            return true;
        }
        boolean hasSolution = false;
        char[] removeFirstLetter = Arrays.copyOfRange(remainingLetters, 1, remainingLetters.length);
        if (iIndex-1 >=0 && !used.contains(new ArrayList(Arrays.asList(iIndex-1, jIndex)))) {
            char letterAbove = board[iIndex -1][jIndex];
            if (letterAbove == remainingLetters[0]) {
                if (recuseCheckNeighbors(board, removeFirstLetter, iIndex-1, jIndex, new HashSet(used))) {
                    hasSolution = true;
                }
            }
        }
        if (iIndex+1 < board.length && !used.contains(new ArrayList(Arrays.asList(iIndex+1, jIndex)))) {
            char letterBelow = board[iIndex+1][jIndex];
            if (letterBelow == remainingLetters[0]) {
                if (recuseCheckNeighbors(board, removeFirstLetter, iIndex+1, jIndex, new HashSet(used))) {
                    hasSolution = true;
                }
            }
        }
        if (jIndex + 1 < board[0].length && !used.contains(new ArrayList(Arrays.asList(iIndex, jIndex+1)))) {
            char letterRight = board[iIndex][jIndex+1];
            if (letterRight == remainingLetters[0]) {
                if (recuseCheckNeighbors(board, removeFirstLetter, iIndex, jIndex+1, new HashSet(used))) {
                    hasSolution = true;
                }
            }
        }
        if (jIndex -1 >= 0 && !used.contains(new ArrayList(Arrays.asList(iIndex, jIndex-1)))) {
            char letterLeft = board[iIndex][jIndex-1];
            if (letterLeft == remainingLetters[0]) {
                if (recuseCheckNeighbors(board, removeFirstLetter, iIndex, jIndex-1, new HashSet(used))) {
                    hasSolution = true;
                }
            }
        }
        return hasSolution;

    }
}