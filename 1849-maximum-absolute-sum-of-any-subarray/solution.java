class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max = maxSum(nums);
        int min = maxNegSum(nums);
        return Math.max(max, Math.abs(min));
    }

    public int maxSum(int[] nums) {
        int result = nums[0];
        int runningSum = 0;

        for (int num : nums) {
            int potentialSum = runningSum + num;
            if (potentialSum < 0) {
                runningSum = 0;
            } else {
                runningSum = potentialSum;
            }
            result = Math.max(result, runningSum);
        }
        return result;
    }

    public int maxNegSum(int[] nums) {
        int result = nums[0];
        int runningSum = 0;

        for (int num : nums) {
            int potentialSum = runningSum + num;
            if (potentialSum > 0) {
                runningSum = 0;
            } else {
                runningSum = potentialSum;
            }
            result = Math.min(result, runningSum);
        }
        return result;
    }
}