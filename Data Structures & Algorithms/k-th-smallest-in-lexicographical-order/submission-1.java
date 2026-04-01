class Solution {
    public int findKthNumber(int n, int k) {
        long currentNumber = 1;
        long totalSteps = 1;
        while (totalSteps < k) {
            long stepsAtCurrent = count(currentNumber, n);
            if (totalSteps + stepsAtCurrent <= k) {
                currentNumber++;
                totalSteps += stepsAtCurrent;
            } else {
                currentNumber *= 10;
                totalSteps++;
            }
        }
        return (int) currentNumber;
    }

    public long count(long parent, int n) {
        long left = parent;
        long right = parent + 1;
        int total = 0;
        while (left <= n) {
            total += Math.min(right, (long)n + 1) - left;
            left *= 10;
            right *= 10;
        }
        return total;
    }
}