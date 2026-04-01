class Solution {
    public int combinationSum4(int[] nums, int target) {
        return dfsCombinationsSum(nums, target, new HashMap<>());
    }

    public int dfsCombinationsSum(int[] nums, int target, HashMap<Integer, Integer> cache) {
        if (cache.containsKey(target)) {
            return cache.get(target);
        }
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }
        Integer count = 0;
        for (int num : nums) {
            count += dfsCombinationsSum(nums, target - num, cache);
        }
        cache.put(target, count);
        return count;
    }
}