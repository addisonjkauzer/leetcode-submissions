class Solution {
    public int maxScore(String s) {
        Integer allRightScore = 0;
        for (char binary : s.toCharArray()) {
            Integer value = Character.getNumericValue(binary);
            allRightScore += value;
        }
        Integer maxScore = 0;
        Integer runningScore = allRightScore;
        for (int i = 0; i < s.length() - 1; i++) {
            char binary = s.charAt(i);
            if (binary == '0') {
                runningScore++;
            } else {
                runningScore--;
            }
            maxScore = Math.max(maxScore, runningScore);
        }
        return maxScore;
    }
}