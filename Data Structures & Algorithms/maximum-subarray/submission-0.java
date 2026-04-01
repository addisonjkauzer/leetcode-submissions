class Solution {
    public int maxSubArray(int[] nums) {
        Integer maxSum = nums[0];
        Integer runningSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            Integer withCurrent = runningSum + nums[i];
            if (withCurrent > nums[i]) {
                runningSum = withCurrent;
            } else {
                runningSum = nums[i];
            }
            maxSum = Math.max(maxSum, runningSum);
        }
        return maxSum;
    }
}
