class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0) return false;
        return dfsMakeSquare(matchsticks, 0, new int[4]);
    }

    public boolean dfsMakeSquare(int[] matchsticks, int index, int[] sides) {
        if (index == matchsticks.length) {
            return sides[0] == sides[1] && sides[1] == sides[2] && sides[2] == sides[3];
        }
        for (int i = 0; i < 4; i++) {
            int currentSide = sides[i];
            int newSide = currentSide + matchsticks[index];
            sides[i] = newSide;
            if(dfsMakeSquare(matchsticks, index + 1, sides)) return true;
            sides[i] = currentSide;
        }
        return false;
    }
}