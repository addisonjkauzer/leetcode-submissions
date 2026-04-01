class Solution {
    public int maxAscendingSum(int[] nums) {

        int previous = 0;
        int runningSum = 0;
        int maxSum = 0;

        for (int num : nums) {
            if (previous >= num) {
                runningSum = 0;
            }
            runningSum += num;
            previous = num;
            maxSum = Math.max(maxSum, runningSum);
        }

        return maxSum;
        
    }
}