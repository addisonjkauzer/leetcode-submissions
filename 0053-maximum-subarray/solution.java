class Solution {
    public int maxSubArray(int[] nums) {
        int runningSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > runningSum + nums[i]) {
                runningSum = nums[i];
            } else {
                runningSum = runningSum + nums[i];
            }
            maxSum = Math.max(runningSum, maxSum);
        }
        return maxSum;
    }
}