class Solution {
    public int numTeams(int[] rating) {
        Integer result = 0;

        for (int i = 1; i < rating.length - 1; i++) {
            Integer middle = rating[i];
            Integer lessThanMiddleCount = 0;
            Integer greaterThanMiddleCount = 0;
            for (int j = 0; j < i; j++) {
                if (rating[j] < middle) {
                    lessThanMiddleCount++;
                }
            }
            for (int j = i+1; j < rating.length; j++) {
                if (rating[j] > middle) {
                    greaterThanMiddleCount++;
                }
            }
            result += lessThanMiddleCount * greaterThanMiddleCount;

            Integer greaterThanOnLeftCount = i - lessThanMiddleCount;
            Integer lessThanOnRightCount = rating.length - 1 - i - greaterThanMiddleCount;
            result += greaterThanOnLeftCount * lessThanOnRightCount;
        }
        return result;
    }
}