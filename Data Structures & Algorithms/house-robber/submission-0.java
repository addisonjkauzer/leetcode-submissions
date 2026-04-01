class Solution {
    public int rob(int[] nums) {
        return rob(nums, 0, new HashMap<>());
    }

    public int rob(int[] nums, Integer index, HashMap<Integer, Integer> cache) {
        if (cache.containsKey(index)) {
            return cache.get(index);
        }
        if (index >= nums.length) {
            return 0;
        }
        Integer robThisHouse = nums[index] + rob(nums, index + 2, cache);
        Integer robNextHouse = rob(nums, index + 1, cache);
        Integer take = Math.max(robThisHouse, robNextHouse);
        cache.put(index, take);
        return take;
    }
}
