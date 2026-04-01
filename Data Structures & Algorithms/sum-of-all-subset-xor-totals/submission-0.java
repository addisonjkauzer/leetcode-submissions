class Solution {
    public int subsetXORSum(int[] nums) {
        return dfsSubsetXORSumHelper(nums, 0, 0);
    }

    public int dfsSubsetXORSumHelper(int[] nums, Integer index, int runningXOR) {
        if (index >= nums.length) {
            return runningXOR;
        }

        Integer sum = dfsSubsetXORSumHelper(nums, index + 1, runningXOR);
        sum += dfsSubsetXORSumHelper(nums, index + 1, runningXOR ^ nums[index]);
        return sum;
    }
}