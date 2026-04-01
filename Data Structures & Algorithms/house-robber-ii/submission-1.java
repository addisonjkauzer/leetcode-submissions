class Solution {
    public int rob(int[] nums) {
        Integer withFirstHouse = rob(nums, 0, new HashMap<>(), true);
        Integer withOutFirstHouse = rob(nums, 1, new HashMap<>(), false);
        return Math.max(withFirstHouse, withOutFirstHouse);
    }

    public int rob(int[] nums, Integer index, HashMap<Integer, Integer> cache, boolean firstHouse) {
        if (cache.containsKey(index)) {
            return cache.get(index);
        }
        if (index >= nums.length) {
            return 0;
        }
        if (index == nums.length - 1 && firstHouse && nums.length > 1) {
            return 0;
        }
        Integer robThisHouse = nums[index] + rob(nums, index + 2, cache, firstHouse);
        Integer robNextHouse = rob(nums, index + 1, cache, firstHouse);
        Integer take = Math.max(robThisHouse, robNextHouse);
        cache.put(index, take);
        return take;
    }
}
