class Solution {
    public int lengthOfLIS(int[] nums) {
        return lengthOfLIS(nums, 0, Integer.MIN_VALUE, new HashMap<>());
    }

    public int lengthOfLIS(int[] nums, Integer index, Integer previousValue, HashMap<Integer, Integer> cache) {
        if (index >= nums.length) {
            return 0;
        }
        if (nums[index] > previousValue) {
            Integer includeCurrent;
            if (cache.containsKey(index)) {
                includeCurrent = cache.get(index);
            } else {
                includeCurrent = 1 + lengthOfLIS(nums, index + 1, nums[index], cache);
                cache.put(index, includeCurrent);
            }
            Integer dontIncludeCurrent = lengthOfLIS(nums, index + 1, previousValue, cache);
            return Math.max(includeCurrent, dontIncludeCurrent);
        }
        return lengthOfLIS(nums, index + 1, previousValue, cache);
    }
}
