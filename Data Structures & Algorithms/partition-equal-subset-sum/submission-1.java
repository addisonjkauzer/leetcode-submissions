class Solution {
    public boolean canPartition(int[] nums) {
        Integer sum = 0;
        for (Integer num : nums) {
            sum += num;
        }
        return canPartition(nums, 0, sum, new HashMap<>());
    }

    public boolean canPartition(int[] nums, Integer index, Integer target, HashMap<List<Integer>, Boolean> cache) {
        if (target == 0) {
            return true;
        }
        if (index >= nums.length) {
            return false;
        }
        if (cache.containsKey(Arrays.asList(index, target))) {
            return cache.get(Arrays.asList(index, target));
        }
        boolean withIndex = canPartition(nums, index + 1, target - 2 * nums[index], cache);
        boolean withoutIndex = canPartition(nums, index + 1, target, cache);
        cache.put(Arrays.asList(index, target), withIndex || withoutIndex);
        return withIndex || withoutIndex;
    }
}
