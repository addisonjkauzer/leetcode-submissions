class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int notTakingSize = cardPoints.length - k;
        int totalSum = Arrays.stream(cardPoints).sum();
        if (notTakingSize <= 0) {
            return totalSum;
        }

        int leftPointer = 0;
        int rightPointer = 0;
        int currentNotTakingSum = 0;
        int minNotTakingSum = Integer.MAX_VALUE;
        while (rightPointer < notTakingSize) {
            currentNotTakingSum += cardPoints[rightPointer];
            rightPointer++;
        }
        while (rightPointer < cardPoints.length) {
            minNotTakingSum = Math.min(minNotTakingSum, currentNotTakingSum);
            currentNotTakingSum -= cardPoints[leftPointer];
            leftPointer++;
            currentNotTakingSum += cardPoints[rightPointer];
            rightPointer++;
        }
        minNotTakingSum = Math.min(minNotTakingSum, currentNotTakingSum);

        return totalSum - minNotTakingSum;
    }
}