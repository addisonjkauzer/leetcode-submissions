class Solution {
    public boolean canPartition(int[] nums) {
        Integer sum = 0;
        for (Integer num : nums) {
            sum += num;
        }
        return canPartition(nums, 0, sum);
    }

    public boolean canPartition(int[] nums, Integer index, Integer target) {
        if (target == 0) {
            return true;
        }
        if (index >= nums.length) {
            return false;
        }
        boolean withIndex = canPartition(nums, index + 1, target - 2 * nums[index]);
        boolean withoutIndex = canPartition(nums, index + 1, target);
        return withIndex || withoutIndex;
    }
}
