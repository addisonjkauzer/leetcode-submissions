class Solution {
    public boolean canJump(int[] nums) {
        return canJump(nums, 0, new HashMap<>());
    }

    public boolean canJump(int[] nums, Integer index, HashMap<Integer, Boolean> cache) {
        if (index == nums.length - 1) {
            return true;
        }
        if (index >= nums.length) {
            return false;
        }
        if (cache.containsKey(index)) {
            return cache.get(index);
        }
        boolean canJump = false;
        for (int i = 1; i <= nums[index]; i++) {
            canJump = canJump || canJump(nums, index + i, cache);
        }
        cache.put(index, canJump);
        return canJump;
    }
}
